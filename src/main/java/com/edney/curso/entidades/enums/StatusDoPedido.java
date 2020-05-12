package com.edney.curso.entidades.enums;

public enum StatusDoPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	POSTADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private StatusDoPedido(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static StatusDoPedido valueOf(int codigo) {
		for (StatusDoPedido value : StatusDoPedido.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código do StatusDoPedido inválido!");
	}
}
