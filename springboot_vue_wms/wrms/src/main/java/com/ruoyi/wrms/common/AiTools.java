//package com.ruoyi.wrms.common;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Description;
//
//import java.time.LocalDate;
//import java.util.function.Function;
//
//@Configuration
//public class AiTools {
//
//	@Autowired
//	FlightBookingService flightBookingService;
//
//	@JsonInclude(Include.NON_NULL)
//	public record BookingDetails(String bookingNumber, String name, LocalDate date, BookingStatus bookingStatus,
//			String from, String to, String bookingClass) {
//	}
//
//	//jdk17新特性，密封类
//	public record CancelBookingRequest(String bookingNumber,String name){}
//	public record BookingDetailsRequest(String bookingNumber,String name){}
//	public record changeBookingRequest(String bookingNumber, String name, String newDate, String from, String to){}
//
//	@Bean
//	@Description("处理机票退订")
//	public Function<CancelBookingRequest,String> cancelBooking(){
//		return cancelBookingRequest -> {
//			// apply 调用退订方法
//			flightBookingService.cancelBooking(cancelBookingRequest.bookingNumber(),cancelBookingRequest.name());
//			return "退订成功!";
//		};
//	}
//
//
//	@Bean
//	@Description("获取机票预定详细信息")
//	public Function<BookingDetailsRequest, BookingDetails> getBookingDetails() {
//		return request -> {
//			try {
//				return flightBookingService.getBookingDetails(request.bookingNumber(), request.name());
//			}
//			catch (Exception e) {
//
//				return new BookingDetails(request.bookingNumber(), request.name(), null, null, null, null, null);
//			}
//		};
//	}
//	@Bean
//	@Description("更改航班预定")//告诉大模型该方法可以处理什么类型的请求
//	public Function<changeBookingRequest, String> changeBooking() {
//		return changeBookingrequest -> {
//			flightBookingService.changeBooking(changeBookingrequest.bookingNumber(), changeBookingrequest.name(), changeBookingrequest.newDate(), changeBookingrequest.from(), changeBookingrequest.to());
//			return "更改成功!";
//
//		};
//	}
//
//}
