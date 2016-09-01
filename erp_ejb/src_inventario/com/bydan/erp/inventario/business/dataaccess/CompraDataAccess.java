/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.inventario.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//CompraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class CompraDataAccess extends  CompraDataAccessAdditional{ //CompraDataAccessAdditional,DataAccessHelper<Compra>
	//static Logger logger = Logger.getLogger(CompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_modulo,id_ejercicio,id_periodo,id_anio,id_mes,id_usuario,fecha_emision,fecha_entrega,numero_secuencial,id_moneda,id_tipo_cambio,id_estado_inventario,id_cliente,id_formato,id_empleado,numero_factura,id_transportista,descripcion,id_orden_compra,id_pedido_compra,autori_usuario,factura_inicial,factura_final,servicio_documento,fecha_valor,porcentaje_descuento,suman,ice,valor_descuento,total_descuento,iva,stock,sub_total,total_otro,ultimo_costo,numero_items,retencion,total,flete,impuesto,id_tipo_transaccion_modulo,id_asiento_contable,numero_comprobante,fecha)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,fecha_emision=?,fecha_entrega=?,numero_secuencial=?,id_moneda=?,id_tipo_cambio=?,id_estado_inventario=?,id_cliente=?,id_formato=?,id_empleado=?,numero_factura=?,id_transportista=?,descripcion=?,id_orden_compra=?,id_pedido_compra=?,autori_usuario=?,factura_inicial=?,factura_final=?,servicio_documento=?,fecha_valor=?,porcentaje_descuento=?,suman=?,ice=?,valor_descuento=?,total_descuento=?,iva=?,stock=?,sub_total=?,total_otro=?,ultimo_costo=?,numero_items=?,retencion=?,total=?,flete=?,impuesto=?,id_tipo_transaccion_modulo=?,id_asiento_contable=?,numero_comprobante=?,fecha=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select compra from "+CompraConstantesFunciones.SPERSISTENCENAME+" compra";
	public static String QUERYSELECTNATIVE="select "+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".version_row,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_empresa,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_sucursal,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_modulo,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_ejercicio,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_periodo,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_anio,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_mes,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_usuario,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".fecha_emision,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".fecha_entrega,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".numero_secuencial,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_moneda,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_tipo_cambio,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_estado_inventario,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_cliente,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_formato,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_empleado,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".numero_factura,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_transportista,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".descripcion,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_orden_compra,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_pedido_compra,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".autori_usuario,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".factura_inicial,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".factura_final,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".servicio_documento,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".fecha_valor,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".porcentaje_descuento,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".suman,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".ice,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".valor_descuento,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".total_descuento,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".iva,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".stock,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".sub_total,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".total_otro,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".ultimo_costo,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".numero_items,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".retencion,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".total,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".flete,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".impuesto,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id_asiento_contable,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".numero_comprobante,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".fecha from "+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME;//+" as "+CompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".id,"+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+".version_row from "+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME;//+" as "+CompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CompraConstantesFunciones.SCHEMA+"."+CompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,fecha_emision=?,fecha_entrega=?,numero_secuencial=?,id_moneda=?,id_tipo_cambio=?,id_estado_inventario=?,id_cliente=?,id_formato=?,id_empleado=?,numero_factura=?,id_transportista=?,descripcion=?,id_orden_compra=?,id_pedido_compra=?,autori_usuario=?,factura_inicial=?,factura_final=?,servicio_documento=?,fecha_valor=?,porcentaje_descuento=?,suman=?,ice=?,valor_descuento=?,total_descuento=?,iva=?,stock=?,sub_total=?,total_otro=?,ultimo_costo=?,numero_items=?,retencion=?,total=?,flete=?,impuesto=?,id_tipo_transaccion_modulo=?,id_asiento_contable=?,numero_comprobante=?,fecha=?";
	
	public static String STOREPROCEDUREINSERT="call SP_COMPRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_COMPRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_COMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_COMPRA_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected CompraDataAccessAdditional compraDataAccessAdditional=null;
	
	public CompraDataAccessAdditional getCompraDataAccessAdditional() {
		return this.compraDataAccessAdditional;
	}
	
	public void setCompraDataAccessAdditional(CompraDataAccessAdditional compraDataAccessAdditional) {
		try {
			this.compraDataAccessAdditional=compraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CompraDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		CompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}

	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setCompraOriginal(Compra compra)throws Exception  {
		compra.setCompraOriginal((Compra)compra.clone());		
	}
	
	public void setComprasOriginal(List<Compra> compras)throws Exception  {
		
		for(Compra compra:compras){
			compra.setCompraOriginal((Compra)compra.clone());
		}
	}
	
	public static void setCompraOriginalStatic(Compra compra)throws Exception  {
		compra.setCompraOriginal((Compra)compra.clone());		
	}
	
	public static void setComprasOriginalStatic(List<Compra> compras)throws Exception  {
		
		for(Compra compra:compras){
			compra.setCompraOriginal((Compra)compra.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  Compra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Compra entity = new Compra();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  Compra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Compra entity = new Compra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.Compra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCompraOriginal(new Compra());
      	    	entity=super.getEntity("",entity,resultSet,CompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCompra("",entity,resultSet); 
				
				//entity.setCompraOriginal(super.getEntity("",entity.getCompraOriginal(),resultSet,CompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCompraOriginal(this.getEntityCompra("",entity.getCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Compra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Compra entity = new Compra();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  Compra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Compra entity = new Compra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Compra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCompraOriginal(new Compra());
      	    	entity=super.getEntity("",entity,resultSet,CompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCompra("",entity,resultSet);    
				
				//entity.setCompraOriginal(super.getEntity("",entity.getCompraOriginal(),resultSet,CompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCompraOriginal(this.getEntityCompra("",entity.getCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Compra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Compra entity = new Compra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Compra.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Compra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Compra> entities = new  ArrayList<Compra>();
		Compra entity = new Compra();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<Compra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Compra> entities = new  ArrayList<Compra>();
		Compra entity = new Compra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Compra();
      	    	entity=super.getEntity("",entity,resultSet,CompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCompra("",entity,resultSet);
      	    	
				//entity.setCompraOriginal( new Compra());
      	    	//entity.setCompraOriginal(super.getEntity("",entity.getCompraOriginal(),resultSet,CompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCompraOriginal(this.getEntityCompra("",entity.getCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Compra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Compra> entities = new  ArrayList<Compra>();
		Compra entity = new Compra();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<Compra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Compra> entities = new  ArrayList<Compra>();
		Compra entity = new Compra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Compra();
				
				if(conMapGenerico) {
					entity.inicializarMapCompra();
					//entity.setMapCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CompraDataAccess.ISWITHSCHEMA);         		
					entity=CompraDataAccess.getEntityCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCompraOriginal( new Compra());
					////entity.setCompraOriginal(super.getEntity("",entity.getCompraOriginal(),resultSet,CompraDataAccess.ISWITHSCHEMA));         		
					////entity.setCompraOriginal(this.getEntityCompra("",entity.getCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Compra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Compra entity = new Compra();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  Compra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Compra entity = new Compra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Compra();
				
				if(conMapGenerico) {
					entity.inicializarMapCompra();
					//entity.setMapCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CompraDataAccess.ISWITHSCHEMA);         		
					entity=CompraDataAccess.getEntityCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCompraOriginal( new Compra());
					////entity.setCompraOriginal(super.getEntity("",entity.getCompraOriginal(),resultSet,CompraDataAccess.ISWITHSCHEMA));         		
					////entity.setCompraOriginal(this.getEntityCompra("",entity.getCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Compra getEntityCompra(String strPrefijo,Compra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Compra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Compra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CompraDataAccess.setFieldReflectionCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCompra=CompraConstantesFunciones.getTodosTiposColumnasCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCompra) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = Compra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Compra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CompraDataAccess.setFieldReflectionCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCompra(Field field,String strPrefijo,String sColumn,Compra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CompraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CompraConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CompraConstantesFunciones.NUMEROSECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CompraConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDESTADOINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CompraConstantesFunciones.IDTRANSPORTISTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CompraConstantesFunciones.IDORDENCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDPEDIDOCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.AUTORIUSUARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CompraConstantesFunciones.FACTURAINICIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CompraConstantesFunciones.FACTURAFINAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CompraConstantesFunciones.SERVICIODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CompraConstantesFunciones.FECHAVALOR:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CompraConstantesFunciones.PORCENTAJEDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.SUMAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.VALORDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.TOTALDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.STOCK:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.TOTALOTRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.ULTIMOCOSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.NUMEROITEMS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case CompraConstantesFunciones.RETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.IMPUESTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CompraConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CompraConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CompraConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Compra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Compra> entities = new  ArrayList<Compra>();
		Compra entity = new Compra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new Compra();
					entity=super.getEntity("",entity,resultSet,CompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCompra("",entity,resultSet);
					
					//entity.setCompraOriginal( new Compra());
					//entity.setCompraOriginal(super.getEntity("",entity.getCompraOriginal(),resultSet,CompraDataAccess.ISWITHSCHEMA));         		
					//entity.setCompraOriginal(this.getEntityCompra("",entity.getCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Compra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Compra> entities = new  ArrayList<Compra>();
		Compra entity = new Compra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<Compra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Compra> entities = new  ArrayList<Compra>();
		Compra entity = new Compra();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<Compra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Compra> entities = new  ArrayList<Compra>();
		Compra entity = new Compra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Compra();
      	    	entity=super.getEntity("",entity,resultSet,CompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCompra("",entity,resultSet);
      	    	
				//entity.setCompraOriginal( new Compra());
      	    	//entity.setCompraOriginal(super.getEntity("",entity.getCompraOriginal(),resultSet,CompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCompraOriginal(this.getEntityCompra("",entity.getCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Compra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Compra> entities = new  ArrayList<Compra>();
		Compra entity = new Compra();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<Compra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Compra> entities = new  ArrayList<Compra>();
		Compra entity = new Compra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Compra();
      	    	entity=super.getEntity("",entity,resultSet,CompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCompra("",entity,resultSet);
      	    	
				//entity.setCompraOriginal( new Compra());
      	    	//entity.setCompraOriginal(super.getEntity("",entity.getCompraOriginal(),resultSet,CompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCompraOriginal(this.getEntityCompra("",entity.getCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCompras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Compra getEntityCompra(String strPrefijo,Compra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDSUCURSAL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDMODULO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_usuario(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDUSUARIO));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+CompraConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+CompraConstantesFunciones.FECHAENTREGA).getTime()));
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+CompraConstantesFunciones.NUMEROSECUENCIAL));
				entity.setid_moneda(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDMONEDA));
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setid_estado_inventario(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDESTADOINVENTARIO));
				entity.setid_cliente(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDCLIENTE));
				entity.setid_formato(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDFORMATO));
				entity.setid_empleado(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDEMPLEADO));
				entity.setnumero_factura(resultSet.getString(strPrefijo+CompraConstantesFunciones.NUMEROFACTURA));
				entity.setid_transportista(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDTRANSPORTISTA));if(resultSet.wasNull()) {entity.setid_transportista(null); }
				entity.setdescripcion(resultSet.getString(strPrefijo+CompraConstantesFunciones.DESCRIPCION));
				entity.setid_orden_compra(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDORDENCOMPRA));if(resultSet.wasNull()) {entity.setid_orden_compra(null); }
				entity.setid_pedido_compra(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDPEDIDOCOMPRA));if(resultSet.wasNull()) {entity.setid_pedido_compra(null); }
				entity.setautori_usuario(resultSet.getString(strPrefijo+CompraConstantesFunciones.AUTORIUSUARIO));
				entity.setfactura_inicial(resultSet.getString(strPrefijo+CompraConstantesFunciones.FACTURAINICIAL));
				entity.setfactura_final(resultSet.getString(strPrefijo+CompraConstantesFunciones.FACTURAFINAL));
				entity.setservicio_documento(resultSet.getString(strPrefijo+CompraConstantesFunciones.SERVICIODOCUMENTO));
				entity.setfecha_valor(new Date(resultSet.getDate(strPrefijo+CompraConstantesFunciones.FECHAVALOR).getTime()));
				entity.setporcentaje_descuento(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.PORCENTAJEDESCUENTO));
				entity.setsuman(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.SUMAN));
				entity.setice(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.ICE));
				entity.setvalor_descuento(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.VALORDESCUENTO));
				entity.settotal_descuento(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.TOTALDESCUENTO));
				entity.setiva(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.IVA));
				entity.setstock(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.STOCK));
				entity.setsub_total(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.SUBTOTAL));
				entity.settotal_otro(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.TOTALOTRO));
				entity.setultimo_costo(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.ULTIMOCOSTO));
				entity.setnumero_items(resultSet.getInt(strPrefijo+CompraConstantesFunciones.NUMEROITEMS));
				entity.setretencion(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.RETENCION));
				entity.settotal(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.TOTAL));
				entity.setflete(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.FLETE));
				entity.setimpuesto(resultSet.getDouble(strPrefijo+CompraConstantesFunciones.IMPUESTO));
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+CompraConstantesFunciones.IDASIENTOCONTABLE));if(resultSet.wasNull()) {entity.setid_asiento_contable(null); }
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+CompraConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+CompraConstantesFunciones.FECHA).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Compra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CompraDataAccess.TABLENAME,CompraDataAccess.ISWITHSTOREPROCEDURES);
			
			CompraDataAccess.setCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcompra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcompra.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relcompra.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Ejercicio getEjercicio(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relcompra.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relcompra.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relcompra.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relcompra.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Usuario getUsuario(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relcompra.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Moneda getMoneda(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relcompra.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public TipoCambio getTipoCambio(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relcompra.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}

	public EstadoInventario getEstadoInventario(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		EstadoInventario estadoinventario= new EstadoInventario();

		try {
			EstadoInventarioDataAccess estadoinventarioDataAccess=new EstadoInventarioDataAccess();

			estadoinventarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoinventarioDataAccess.setConnexionType(this.connexionType);
			estadoinventarioDataAccess.setParameterDbType(this.parameterDbType);

			estadoinventario=estadoinventarioDataAccess.getEntity(connexion,relcompra.getid_estado_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoinventario;

	}

	public Cliente getCliente(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relcompra.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Formato getFormato(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relcompra.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Empleado getEmpleado(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relcompra.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Transportista getTransportista(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		Transportista transportista= new Transportista();

		try {
			TransportistaDataAccess transportistaDataAccess=new TransportistaDataAccess();

			transportistaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transportistaDataAccess.setConnexionType(this.connexionType);
			transportistaDataAccess.setParameterDbType(this.parameterDbType);

			transportista=transportistaDataAccess.getEntity(connexion,relcompra.getid_transportista());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportista;

	}

	public OrdenCompra getOrdenCompra(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		OrdenCompra ordencompra= new OrdenCompra();

		try {
			OrdenCompraDataAccess ordencompraDataAccess=new OrdenCompraDataAccess();

			ordencompraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ordencompraDataAccess.setConnexionType(this.connexionType);
			ordencompraDataAccess.setParameterDbType(this.parameterDbType);

			ordencompra=ordencompraDataAccess.getEntity(connexion,relcompra.getid_orden_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordencompra;

	}

	public PedidoCompra getPedidoCompra(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		PedidoCompra pedidocompra= new PedidoCompra();

		try {
			PedidoCompraDataAccess pedidocompraDataAccess=new PedidoCompraDataAccess();

			pedidocompraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			pedidocompraDataAccess.setConnexionType(this.connexionType);
			pedidocompraDataAccess.setParameterDbType(this.parameterDbType);

			pedidocompra=pedidocompraDataAccess.getEntity(connexion,relcompra.getid_pedido_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompra;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,relcompra.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}

	public AsientoContable getAsientoContable(Connexion connexion,Compra relcompra)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relcompra.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}


		
		public List<RetencionInven> getRetencionInvens(Connexion connexion,Compra compra)throws SQLException,Exception {

		List<RetencionInven> retencioninvens= new ArrayList<RetencionInven>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CompraConstantesFunciones.SCHEMA+".compra ON "+RetencionInvenConstantesFunciones.SCHEMA+".retencion_inven.id_compra="+CompraConstantesFunciones.SCHEMA+".compra.id WHERE "+CompraConstantesFunciones.SCHEMA+".compra.id="+String.valueOf(compra.getId());
			} else {
				sQuery=" INNER JOIN retencioninven.Compra WHERE retencioninven.Compra.id="+String.valueOf(compra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RetencionInvenDataAccess retencioninvenDataAccess=new RetencionInvenDataAccess();

			retencioninvenDataAccess.setConnexionType(this.connexionType);
			retencioninvenDataAccess.setParameterDbType(this.parameterDbType);
			retencioninvens=retencioninvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return retencioninvens;

	}

	public List<TransaccionLocal> getTransaccionLocals(Connexion connexion,Compra compra)throws SQLException,Exception {

		List<TransaccionLocal> transaccionlocals= new ArrayList<TransaccionLocal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CompraConstantesFunciones.SCHEMA+".compra ON "+TransaccionLocalConstantesFunciones.SCHEMA+".transaccion_local.id_compra="+CompraConstantesFunciones.SCHEMA+".compra.id WHERE "+CompraConstantesFunciones.SCHEMA+".compra.id="+String.valueOf(compra.getId());
			} else {
				sQuery=" INNER JOIN transaccionlocal.Compra WHERE transaccionlocal.Compra.id="+String.valueOf(compra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TransaccionLocalDataAccess transaccionlocalDataAccess=new TransaccionLocalDataAccess();

			transaccionlocalDataAccess.setConnexionType(this.connexionType);
			transaccionlocalDataAccess.setParameterDbType(this.parameterDbType);
			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccionlocals;

	}

	public List<MovimientoInventario> getMovimientoInventarios(Connexion connexion,Compra compra)throws SQLException,Exception {

		List<MovimientoInventario> movimientoinventarios= new ArrayList<MovimientoInventario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CompraConstantesFunciones.SCHEMA+".compra ON "+MovimientoInventarioConstantesFunciones.SCHEMA+".movimiento_inventario.id_compra="+CompraConstantesFunciones.SCHEMA+".compra.id WHERE "+CompraConstantesFunciones.SCHEMA+".compra.id="+String.valueOf(compra.getId());
			} else {
				sQuery=" INNER JOIN movimientoinventario.Compra WHERE movimientoinventario.Compra.id="+String.valueOf(compra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MovimientoInventarioDataAccess movimientoinventarioDataAccess=new MovimientoInventarioDataAccess();

			movimientoinventarioDataAccess.setConnexionType(this.connexionType);
			movimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return movimientoinventarios;

	}

	public List<FormaPagoInven> getFormaPagoInvens(Connexion connexion,Compra compra)throws SQLException,Exception {

		List<FormaPagoInven> formapagoinvens= new ArrayList<FormaPagoInven>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CompraConstantesFunciones.SCHEMA+".compra ON "+FormaPagoInvenConstantesFunciones.SCHEMA+".forma_pago_inven.id_compra="+CompraConstantesFunciones.SCHEMA+".compra.id WHERE "+CompraConstantesFunciones.SCHEMA+".compra.id="+String.valueOf(compra.getId());
			} else {
				sQuery=" INNER JOIN formapagoinven.Compra WHERE formapagoinven.Compra.id="+String.valueOf(compra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormaPagoInvenDataAccess formapagoinvenDataAccess=new FormaPagoInvenDataAccess();

			formapagoinvenDataAccess.setConnexionType(this.connexionType);
			formapagoinvenDataAccess.setParameterDbType(this.parameterDbType);
			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapagoinvens;

	}

	public List<DetalleCompra> getDetalleCompras(Connexion connexion,Compra compra)throws SQLException,Exception {

		List<DetalleCompra> detallecompras= new ArrayList<DetalleCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CompraConstantesFunciones.SCHEMA+".compra ON "+DetalleCompraConstantesFunciones.SCHEMA+".detalle_compra.id_compra="+CompraConstantesFunciones.SCHEMA+".compra.id WHERE "+CompraConstantesFunciones.SCHEMA+".compra.id="+String.valueOf(compra.getId());
			} else {
				sQuery=" INNER JOIN detallecompra.Compra WHERE detallecompra.Compra.id="+String.valueOf(compra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleCompraDataAccess detallecompraDataAccess=new DetalleCompraDataAccess();

			detallecompraDataAccess.setConnexionType(this.connexionType);
			detallecompraDataAccess.setParameterDbType(this.parameterDbType);
			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallecompras;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Compra compra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!compra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(compra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(compra.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(compra.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(compra.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(compra.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(compra.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(compra.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(compra.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(compra.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega.setValue(compra.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_secuencial=new ParameterValue<String>();
					parameterMaintenanceValuenumero_secuencial.setValue(compra.getnumero_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(compra.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(compra.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_inventario.setValue(compra.getid_estado_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(compra.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(compra.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(compra.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_factura=new ParameterValue<String>();
					parameterMaintenanceValuenumero_factura.setValue(compra.getnumero_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transportista=new ParameterValue<Long>();
					parameterMaintenanceValueid_transportista.setValue(compra.getid_transportista());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transportista);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(compra.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_orden_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_orden_compra.setValue(compra.getid_orden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_orden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pedido_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_pedido_compra.setValue(compra.getid_pedido_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pedido_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueautori_usuario=new ParameterValue<String>();
					parameterMaintenanceValueautori_usuario.setValue(compra.getautori_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueautori_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuefactura_inicial=new ParameterValue<String>();
					parameterMaintenanceValuefactura_inicial.setValue(compra.getfactura_inicial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefactura_inicial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuefactura_final=new ParameterValue<String>();
					parameterMaintenanceValuefactura_final.setValue(compra.getfactura_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefactura_final);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueservicio_documento=new ParameterValue<String>();
					parameterMaintenanceValueservicio_documento.setValue(compra.getservicio_documento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueservicio_documento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_valor=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_valor.setValue(compra.getfecha_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_descuento=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_descuento.setValue(compra.getporcentaje_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesuman=new ParameterValue<Double>();
					parameterMaintenanceValuesuman.setValue(compra.getsuman());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesuman);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(compra.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_descuento=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_descuento.setValue(compra.getvalor_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_descuento=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_descuento.setValue(compra.gettotal_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(compra.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuestock=new ParameterValue<Double>();
					parameterMaintenanceValuestock.setValue(compra.getstock());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuestock);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(compra.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_otro=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_otro.setValue(compra.gettotal_otro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_otro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueultimo_costo=new ParameterValue<Double>();
					parameterMaintenanceValueultimo_costo.setValue(compra.getultimo_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueultimo_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_items=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_items.setValue(compra.getnumero_items());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_items);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueretencion=new ParameterValue<Double>();
					parameterMaintenanceValueretencion.setValue(compra.getretencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueretencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(compra.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(compra.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto.setValue(compra.getimpuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(compra.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(compra.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(compra.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(compra.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
						if(!compra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(compra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(compra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(compra.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseCompra(Compra compra)throws Exception  {		
		compra.setIsNew(false);
		compra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCompras(List<Compra> compras)throws Exception  {				
		for(Compra compra:compras) {
			compra.setIsNew(false);
			compra.setIsChanged(false);
		}
	}
	
	public void generarExportarCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
