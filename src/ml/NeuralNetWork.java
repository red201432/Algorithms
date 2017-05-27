package ml;

import java.util.Random;
import static java.lang.Math.exp;

import com.sun.java.swing.plaf.windows.resources.windows;

public class NeuralNetWork {
	int[] shape;				//每层神经元个数
	int layers;					//标识神经网络的层数
	double[][][] 	weights;	//三个维度分别表示[层][神经元][对应输入]
	double[][] bias;			//[层][神经元]
	double[][] zs;				//用来存放每个神经元z=w*x+b
	double[][] xs;				//用来存放输入x和后面每层的输出s(z)
	
	public NeuralNetWork(int... shape) {
		// TODO Auto-generated constructor stub
		this.shape = shape;
		layers = shape.length;
		weights = new double[layers][][];
		bias = new double[layers][];
		weights[0] = new double[0][0];
		bias[0] = new double[0];
		zs = new double[layers][];
		xs = new double[layers][];
		for (int i = 1; i<layers; i++){
			weights[i] = new double[this.shape[i]][this.shape[i-1]];
			bias[i] = new double[this.shape[i]];
			
		}
		fillRandom(weights);
		fillRandom(bias);
	}
	Random rand = new Random();
    
    void fillRandom(double[] d) {
        for (int i = 0; i < d.length; i++) {
            d[i] = rand.nextGaussian();
        }
    }
    
    void fillRandom(double[][] d) {
        for (int i = 0; i < d.length; i++) {
            fillRandom(d[i]);
        }
    }
    
    void fillRandom(double[][][] d) {
        for (int i = 0; i < d.length; i++) {
            fillRandom(d[i]);
        }
    }
		double[] f(double[] in){
			zs[0] = xs[0] = in ;
			for(int i=1; i<layers; i++){
				zs[i] = add(wx(xs[i-1],weights[i]),bias[i]);
				xs[i] = sigmoid(zs[i]);
			}
		return xs[layers-1];
	}
	
	double sigmoid(double d){
		return 1.0 / (1.0 + exp(-d));
	}
	
	double[] sigmoid(double[] d){
		int length = d.length;
		double[] v = new double[length];
		for(int i = 0; i < length; i++){
			v[i] = sigmoid(d[i]);
		}
		return v;
	}
	
	double[] wx(double[] x, double[][] weight){
		int numberOfNeron = weight.length;
		double[] wx = new double[numberOfNeron];
		for(int i=0; i < numberOfNeron; i++){
			wx[i] = dot(weight[i],x);
		}
		return wx;
	}
	void train(double[] in, double[] expect, double rate) {
        double[] y = f(in);
        double[] cost = sub(expect, y);
        double[][][] dw = new double[layers][][];
        double[][] db = new double[layers][];
        dw[0] = new double[0][0];
        db[0] = new double[0];
        for (int i = layers - 1; i > 0; i--) {
            double[] sp = signmoidPrime(zs[i]);
            cost = mul(cost, sp);
            dw[i] = dw(xs[i - 1], cost);
            db[i] = cost;
            cost = dx(weights[i], cost);
        }

        weights = add(weights, mul(dw, rate));
        bias = add(bias, mul(db, rate));
    }


    double[] signmoidPrime(double d[]) {
        int length = d.length;
        double[] v = new double[length];
        for (int i = 0; i < length; i++) {
            v[i] = sigmoidPrime(d[i]);
        }
        return v;
    }

    double sigmoidPrime(double d) {
        return sigmoid(d) * (1 - sigmoid(d));
    }

    double[] sub(double[] a, double[] b) {
        int len = a.length;
        double[] v = new double[len];
        for (int i = 0; i < len; i++) {
            v[i] = a[i] - b[i];
        }
        return v;
    }

    //derivative of x is w*c and sum for each x
    double[] dx(double[][] w, double[] c) {
        int numberOfX = w[0].length;
        double[] v = new double[numberOfX];
        for (int i = 0; i < numberOfX; i++) {
            for (int j = 0; j < c.length; j++) {
                v[i] += w[j][i] * c[j];
            }
        }
        return v;
    }

    //derivative of w is x*c for each c and each x
    double[][] dw(double[] x, double[] c) {
        int numberOfNeuron = c.length;
        int numberOfIn = x.length;
        double[][] dw = new double[numberOfNeuron][numberOfIn];
        for (int neuron = 0; neuron < numberOfNeuron; neuron++) {
            for (int input = 0; input < numberOfIn; input++) {
                dw[neuron][input] = c[neuron] * x[input];
            }
        }
        return dw;
    }

    //V[i]*X[i]
    double[] mul(double[] v, double[] x) {
        double[] d = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            d[i] = v[i] * x[i];
        }
        return d;
    }

    double[][][] mul(double[][][] a, double b) {
        double[][][] v = new double[a.length][][];
        for (int i = 0; i < a.length; i++) {
            v[i] = mul(a[i], b);
        }
        return v;
    }


    double[][] mul(double[][] a, double b) {
        double[][] v = new double[a.length][];
        for (int i = 0; i < a.length; i++) {
            v[i] = mul(a[i], b);
        }
        return v;
    }

    double[] mul(double[] a, double b) {
        double[] d = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            d[i] = a[i] * b;
        }
        return d;
    }

    double[][][] add(double[][][] a, double[][][] b) {
        double[][][] v = new double[a.length][][];
        for (int i = 0; i < a.length; i++) {
            v[i] = add(a[i], b[i]);
        }
        return v;
    }

    double[][] add(double[][] a, double[][] b) {
        int length = a.length;
        double[][] v = new double[length][];
        for (int i = 0; i < length; i++) {
            v[i] = add(a[i], b[i]);
        }
        return v;
    }

    double[] add(double[] a, double[] b) {
        int length = a.length;
        double[] v = new double[length];
        for (int i = 0; i < length; i++) {
            v[i] = a[i] + b[i];
        }
        return v;
    }

    double dot(double[] w, double[] x) {
        double v = 0;
        for (int i = 0; i < w.length; i++) {
            v += w[i] * x[i];
        }
        return v;
    }
	
	
	
}
