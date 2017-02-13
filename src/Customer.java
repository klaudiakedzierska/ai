import java.time.LocalDateTime;

public class Customer
{
	private double width;
	
	private double height;
	
	private LocalDateTime endTime;
	
	public Customer(double width, double height, LocalDateTime endTime)
	{
		this.width = width;
		this.height = height;
		this.endTime = endTime;
	
	}
	public double getWidth()
	{
		return width;
	}

	public void setWidth(double width)
	{
		this.width = width;
	}

	public double getHeight() 
	{
		return height;
	}

	public void setHeight(double height) 
	{
		this.height = height;
	}

	public LocalDateTime getEndTime() 
	{
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) 
	{
		this.endTime = endTime;
	}

	
	}
