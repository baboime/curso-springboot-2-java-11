package com.edney.curso.configuracao;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edney.curso.entidades.Categoria;
import com.edney.curso.entidades.ItemDePedido;
import com.edney.curso.entidades.Pagamento;
import com.edney.curso.entidades.Pedido;
import com.edney.curso.entidades.Produto;
import com.edney.curso.entidades.Usuario;
import com.edney.curso.entidades.enums.StatusDoPedido;
import com.edney.curso.repositorios.RepositorioCategoria;
import com.edney.curso.repositorios.RepositorioItemDePedido;
import com.edney.curso.repositorios.RepositorioPedido;
import com.edney.curso.repositorios.RepositorioProduto;
import com.edney.curso.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class ConfiguracaoTeste implements CommandLineRunner {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioPedido repositorioPedido;
	
	@Autowired
	private RepositorioCategoria repositorioCategoria;
	
	@Autowired
	private RepositorioProduto repositorioProduto;
	
	@Autowired
	private RepositorioItemDePedido repositorioItemDePedido;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		repositorioCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Produto prd1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto prd2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto prd3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto prd4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto prd5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		repositorioProduto.saveAll(Arrays.asList(prd1, prd2, prd3, prd4, prd5));
		
		prd1.getCategorias().add(cat2);
		prd2.getCategorias().add(cat1);
		prd2.getCategorias().add(cat3);
		prd3.getCategorias().add(cat3);
		prd4.getCategorias().add(cat3);
		prd5.getCategorias().add(cat2);
		
		repositorioProduto.saveAll(Arrays.asList(prd1, prd2, prd3, prd4, prd5));
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusDoPedido.PAGO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusDoPedido.AGUARDANDO_PAGAMENTO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusDoPedido.AGUARDANDO_PAGAMENTO, u1);
		
					
		repositorioUsuario.saveAll(Arrays.asList(u1, u2));
		repositorioPedido.saveAll(Arrays.asList(p1, p2, p3));
		
		ItemDePedido ip1 = new ItemDePedido(p1, prd1, 2, prd1.getPreco());
		ItemDePedido ip2 = new ItemDePedido(p1, prd3, 1, prd3.getPreco());
		ItemDePedido ip3 = new ItemDePedido(p2, prd3, 2, prd3.getPreco());
		ItemDePedido ip4 = new ItemDePedido(p3, prd5, 2, prd5.getPreco());
		
		repositorioItemDePedido.saveAll(Arrays.asList(ip1, ip2, ip3,ip4));
		
		Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), p1);
		p1.setPagamento(pag1);
		
		repositorioPedido.save(p1);
		
	
	}	
}
