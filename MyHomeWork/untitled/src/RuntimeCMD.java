import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
ProcessBuilder.start() 和 Runtime.exec 方法创建一个本机进程，并返回 Process 子类的一个实例，该实例可用来控制进程并获得相关信息。
Process 类提供了执行从进程输入、执行输出到进程、等待进程完成、检查进程的退出状态以及销毁（杀掉）进程的方法。
Process对象有以下几个方法：
　　1、destroy()　　　　　　杀死这个子进程
　　2、exitValue()　　　 　　得到进程运行结束后的返回状态
　　3、waitFor()　　　　 　　得到进程运行结束后的返回状态，如果进程未运行完毕则等待知道执行完毕
　　4、getInputStream()　　 得到进程的标准输出信息流   **
　　5、getErrorStream()　　 得到进程的错误输出信息流
　　6、getOutputStream()　  得到进程的输入流


在java中，RunTime.getRuntime().exec()实现了调用服务器命令脚本来执行功能需要。
RunTime.getRuntime().exec()的用法
public Process exec(String command)-----在单独的进程中执行指定的字符串命令。
public Process exec(String [] cmdArray)---在单独的进程中执行指定命令和变量
public Process exec(String command, String [] envp)----在指定环境的独立进程中执行指定命令和变量
public Process exec(String [] cmdArray, String [] envp)----在指定环境的独立进程中执行指定的命令和变量
public Process exec(String command,String[] envp,File dir)----在有指定环境和工作目录的独立进程中执行指定的字符串命令
public Process exec(String[] cmdarray,String[] envp,File dir)----在指定环境和工作目录的独立进程中执行指定的命令和变量
这些方法都返回一个java.lang.Process对象
 */
public class RuntimeCMD {
    public static void main(String[] args) throws IOException {
        //public Process exec(String command)方法
        String cmd = "arp -a";
//        String cmd = "ps && arp -a"; //&&符号
        Process start = Runtime.getRuntime().exec(cmd);
//
        //public Process exec(String [] cmdArray)方法
//        String[] cmdArray = new String[2];
//        cmdArray[0]="arp";
//        cmdArray[1]="-a";
//        Process start = Runtime.getRuntime().exec(cmdArray);

        System.out.println(start);
        InputStream inputStream = start.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "gbk");
        int len = -1;
        char[] c = new char[1024];
        StringBuffer outputString = new StringBuffer();
        while ((len = inputStreamReader.read(c)) != -1) {
            String s = new String(c, 0, len);
            outputString.append(s);
            System.out.print(s);
        }
        inputStream.close();
    }
}
