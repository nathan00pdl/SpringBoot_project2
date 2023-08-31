package com.MyExample.Projeto2_Java_Spring.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),  // Aguardando Pagamento
	PAID(2),             // Pago
	SHIPPED(3),          // Enviado
	DELIVERED(4),        // Entregue 
	CANCELED(5);         // Cancelado
	
	private int code;  //Código do tipo enumerado
	
	//Declarando construtor para o tipo enumerado
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		
		//Percorrendo cada estado do pedido para verificar o código correspondente
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Order Status Code!");
	}
}
