import java.math.BigDecimal;

/**
 * http://www.cnblogs.com/chenfei0801/p/3672177.html
 * 在java中浮点型默认是double的，及2.00和1.10都要在计算机里转换进行二进制存储
 * float：32  bit
 符号位（1 bit） 	
指数（8 bit） 	
尾数（23 bit）

double：64 bit
符号位（1 bit） 	
指数（11 bit） 	
尾数（52 bit）

1.10整数部分就是1，转换成二进制1（这里整数转二进制不再赘述）
小数部分：0.1
0.1*2=0.2取整数部分0，基数=0.2
0.2*2=0.4取整数部分0，基数=0.4
0.4*2=0.8取整数部分0，基数=0.8
0.8*2=1.6取整数部分1，基数=1.6-1=0.6
0.6*2=1.2取整数部分1，基数=1.2-1=0.2
0.2*2=0.4取整数部分0，基数=0.4
.
.
.
.
直至基数为0。1.1用二进制表示为：1.000110...xxxx....(后面表示省略)
0.1 = 0*2^(-1)+0*2^(-2)+0*2^(-3)+1*2^(-4)+.........而double类型表示小数部分只有52位，当向后计算52位后基数还不为0，那后面的部分只能舍弃
从这里可以看出float、double并不能准确表示每一位小数，对于有的小数只能无限趋向它（所以有的数运行正常，有的数不正常）

 * @author pps
 *
 */
public class TestDouble {
	public static void main(String[] args){
		System.out.println(2.00-1.10);
		System.out.println(2.00f-1.10f);
		
		
		BigDecimal bg1 = new BigDecimal(0.9);
		BigDecimal bg2 = new BigDecimal(1.0);
		System.out.println(bg2.subtract(bg1));//输出0.09999999999999997779553950749686919152736663818359375

		BigDecimal bg3= new BigDecimal("0.9");
		BigDecimal bg4 = new BigDecimal("1.0");
		System.out.println(bg4.subtract(bg3));//输出0.1
	
	}

}
