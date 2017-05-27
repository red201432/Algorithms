package jvm;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.IStartup;
 /*
 * 统计Eclipse启动时间
 */
public class ShowTime implements IStartup {
	public void earlyStartup(){
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				long eclipseStartTime=Long.parseLong(System.getProperty("eclipse.startTime"));
				long costTime=System.currentTimeMillis()-eclipseStartTime;
				Shell shell=Display.getDefault().getActiveShell();
				String message="Eclipse 启动耗时 ："+costTime+"ms";
				MessageDialog.openInformation(shell, "Information", message);
			}
		});
	}
}
