package dados;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class Acesso
{
	private LocalDate data;
	private LocalTime time;
	private Cliente cliente;
	
	public Acesso(LocalDate data, LocalTime time, Cliente cliente)
	{
		this.data=data;
		this.time=time;
		this.cliente=cliente;
	}
	
	private Vector<Integer> convert_unformatted_time_to_int(LocalDate data, LocalTime time)
	{
		DateTimeFormatter formatador=DateTimeFormatter.ofPattern("hh:mm a");
		Vector<Integer> formatted_time=new Vector<Integer>();
		
		String[] date_parts=data.toString().split("-");
		formatted_time.add(Integer.parseInt(date_parts[0]));
		formatted_time.add(Integer.parseInt(date_parts[1]));
		formatted_time.add(Integer.parseInt(date_parts[2]));
		String[] time_parts=formatador.format(time).split(" ");
		String[] time_part=time_parts[0].split(":");
		if(time_parts[1].equals("PM"))
		{
			formatted_time.add(Integer.parseInt(time_part[0])+12);
		}
		else
		{
			formatted_time.add(Integer.parseInt(time_part[0]));
		}
		formatted_time.add(Integer.parseInt(time_part[1]));
		return formatted_time;
	}
	
	public double get_access_value(LocalDate data_final, LocalTime tempo_final)
	{
		Vector<Integer> first_time_values=convert_unformatted_time_to_int(data, time);
		Vector<Integer> final_time_values=convert_unformatted_time_to_int(data_final, tempo_final);
		int year_diff=first_time_values.get(0)-final_time_values.get(0);
		int month_diff=first_time_values.get(1)-final_time_values.get(1);
		int day_diff=first_time_values.get(2)-final_time_values.get(2);
		day_diff+=year_diff*365+month_diff*30;
		int hour_diff=first_time_values.get(3)-final_time_values.get(3);
		int minute_diff=first_time_values.get(4)-final_time_values.get(4);
		double value;
		if(first_time_values.get(3)<20)
		{
			if(hour_diff<9)
			{
				value=(double)minute_diff*0.5;
				value-=((double)minute_diff/15)*0.5;
				value-=(double)hour_diff;
			}
			else
			{
				value=(double)day_diff*110;
				value+=(double)minute_diff*0.2;
			}
		}
		else
		{
			value=(double)30;
			value-=(double)minute_diff*0.5;
			value-=((double)minute_diff/15)*0.5;
			value-=(double)hour_diff;
		}
		return value;
	}
	
	public String get_data()
	{
		return data.toString();
	}
	
	public String get_tempo()
	{
		DateTimeFormatter formatador=DateTimeFormatter.ofPattern("hh:mm a");
		return formatador.format(time);
	}
	
	public Cliente get_cliente()
	{
		return cliente;
	}
}