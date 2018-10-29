/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import beans.Carro_Bean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Querys {

    String sql;
    List<Carro_Bean> carros;

    public Querys() {

        carros = new ArrayList<>();

    }

    public void conseguir_moviles() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        sql = "select  a.id,a.precio,a.moneda_simbolo,s.alias,p.alias "
                + " from db_todobusco_prod.mod_aviso_aviso as a "
                + " join db_todobusco_prod.mod_aviso_subcategoria as s "
                + " on a.idSubcategoria=s.id "
                + " join db_todobusco_prod.mod_ubigeo_pais as p "
                + " on a.idPais=p.id "
                + " where a.idCategoria='2' and (a.estado='10' or a.estado='11' or a.estado='1')";

        PreparedStatement stm = objCon.getCon().prepareStatement(sql);

        ResultSet rs = stm.executeQuery();

        int id = 0;
        float precio = 0.0f;
        String moneda = "";
        String tipo = "";
        String pais = "";

        while (rs.next()) {

            id = rs.getInt(1);
            precio = rs.getFloat(2);
            moneda = rs.getString(3);
            tipo = rs.getString(4);
            pais = rs.getString(5);

            Carro_Bean carrito = new Carro_Bean();

            carrito.setId(id);
            carrito.setPrecio(precio);
            carrito.setMoneda(moneda);
            carrito.setTipo(tipo);
            carrito.setPais(pais);

            System.out.println("id: " + id + " precio: " + precio + " moneda: " + moneda + " tipo: " + tipo + " pais: " + pais);

            carros.add(carrito);

        }

        objCon.desconectar();

    }

    public void conseguir_condicion() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        String condicion = "";
        int i = 0;
        for (Carro_Bean carrito : carros) {

            sql = "select valor from db_todobusco_prod.mod_aviso_caracteristicas_x_aviso "
                    + " where idCaracteristica=21 and idAviso= " + carrito.getId();
            i++;

            PreparedStatement stm = objCon.getCon().prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                condicion = rs.getString(1);
                carrito.setCondicion(condicion);

                System.out.println("contador: " + i + " condicion: " + carrito.getCondicion() + " id: " + carrito.getId());

            }

        }

        objCon.desconectar();

    }

    public void conseguir_marca() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        String marca = "";
        int i = 0;
        for (Carro_Bean carrito : carros) {

            sql = "select valor from db_todobusco_prod.mod_aviso_caracteristicas_x_aviso "
                    + " where idCaracteristica=22 and idAviso= " + carrito.getId();
            i++;

            PreparedStatement stm = objCon.getCon().prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                marca = rs.getString(1);
                carrito.setMarca(marca);

                System.out.println("contador: " + i + " marca: " + carrito.getMarca() + " id: " + carrito.getId());

            }

        }

        objCon.desconectar();

    }

    public void conseguir_modelo() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        String modelo = "";
        int i = 0;
        for (Carro_Bean carrito : carros) {

            sql = "select valor from db_todobusco_prod.mod_aviso_caracteristicas_x_aviso "
                    + " where idCaracteristica=23 and idAviso= " + carrito.getId();
            i++;

            PreparedStatement stm = objCon.getCon().prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                modelo = rs.getString(1);

                carrito.setModelo(modelo);

                System.out.println("contador: " + i + " modelo: " + carrito.getModelo() + " id: " + carrito.getId());

            }

        }

        objCon.desconectar();

    }

    public void conseguir_anio() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        int anio = 0;
        int i = 0;
        for (Carro_Bean carrito : carros) {

            sql = "select valor from db_todobusco_prod.mod_aviso_caracteristicas_x_aviso "
                    + " where idCaracteristica=24 and idAviso= " + carrito.getId();
            i++;

            PreparedStatement stm = objCon.getCon().prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                anio = rs.getInt(1);

                carrito.setAnio(anio);

                System.out.println("contador: " + i + " anio: " + carrito.getAnio() + " id: " + carrito.getId());

            }

        }

        objCon.desconectar();

    }

    public void mostrar_resultados() {

        for (Carro_Bean carrito : carros) {

            System.out.println(carrito.getId() + ";"
                    + carrito.getPrecio() + ";"
                    + carrito.getMoneda() + ";"
                    + carrito.getMoneda() + ";"
                    + carrito.getTipo() + ";"
                    + carrito.getPais() + ";"
                    + carrito.getCondicion() + ";"
                    + carrito.getMarca() + ";"
                    + carrito.getModelo());

        }

    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<Carro_Bean> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro_Bean> carros) {
        this.carros = carros;
    }

}
