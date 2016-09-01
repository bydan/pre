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
import com.bydan.erp.inventario.util.*;//DetalleCompraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DetalleCompraDataAccess extends  DetalleCompraDataAccessAdditional{ //DetalleCompraDataAccessAdditional,DataAccessHelper<DetalleCompra>
	//static Logger logger = Logger.getLogger(DetalleCompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+"(version_row,id_compra,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_estado_detalle_inventario,id_bodega,id_producto,id_unidad,descripcion,id_novedad_producto,cantidad,descuento,costo_unitario,iva,iva_valor,costo_total,disponible,costo_iva,ice,ice_valor,descuento1,descuento2,serie,lote,fecha_elaboracion_lote,fecha_caducidad_lote,id_centro_costo,id_cuenta_contable_costo,numero_comprobante,lote_cliente)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_compra=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_estado_detalle_inventario=?,id_bodega=?,id_producto=?,id_unidad=?,descripcion=?,id_novedad_producto=?,cantidad=?,descuento=?,costo_unitario=?,iva=?,iva_valor=?,costo_total=?,disponible=?,costo_iva=?,ice=?,ice_valor=?,descuento1=?,descuento2=?,serie=?,lote=?,fecha_elaboracion_lote=?,fecha_caducidad_lote=?,id_centro_costo=?,id_cuenta_contable_costo=?,numero_comprobante=?,lote_cliente=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallecompra from "+DetalleCompraConstantesFunciones.SPERSISTENCENAME+" detallecompra";
	public static String QUERYSELECTNATIVE="select "+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".version_row,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_compra,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_empresa,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_periodo,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_anio,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_mes,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_estado_detalle_inventario,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_bodega,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_producto,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_unidad,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".descripcion,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_novedad_producto,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".cantidad,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".descuento,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".costo_unitario,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".iva,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".iva_valor,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".costo_total,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".disponible,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".costo_iva,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".ice,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".ice_valor,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".descuento1,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".descuento2,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".serie,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".lote,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".fecha_elaboracion_lote,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".fecha_caducidad_lote,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id_cuenta_contable_costo,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".lote_cliente from "+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME;//+" as "+DetalleCompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".id,"+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+".version_row from "+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME;//+" as "+DetalleCompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleCompraConstantesFunciones.SCHEMA+"."+DetalleCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_compra=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_estado_detalle_inventario=?,id_bodega=?,id_producto=?,id_unidad=?,descripcion=?,id_novedad_producto=?,cantidad=?,descuento=?,costo_unitario=?,iva=?,iva_valor=?,costo_total=?,disponible=?,costo_iva=?,ice=?,ice_valor=?,descuento1=?,descuento2=?,serie=?,lote=?,fecha_elaboracion_lote=?,fecha_caducidad_lote=?,id_centro_costo=?,id_cuenta_contable_costo=?,numero_comprobante=?,lote_cliente=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLECOMPRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLECOMPRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLECOMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLECOMPRA_SELECT(?,?)";
	
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
	
	
	protected DetalleCompraDataAccessAdditional detallecompraDataAccessAdditional=null;
	
	public DetalleCompraDataAccessAdditional getDetalleCompraDataAccessAdditional() {
		return this.detallecompraDataAccessAdditional;
	}
	
	public void setDetalleCompraDataAccessAdditional(DetalleCompraDataAccessAdditional detallecompraDataAccessAdditional) {
		try {
			this.detallecompraDataAccessAdditional=detallecompraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleCompraDataAccess() {
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
		DetalleCompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleCompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleCompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleCompraOriginal(DetalleCompra detallecompra)throws Exception  {
		detallecompra.setDetalleCompraOriginal((DetalleCompra)detallecompra.clone());		
	}
	
	public void setDetalleComprasOriginal(List<DetalleCompra> detallecompras)throws Exception  {
		
		for(DetalleCompra detallecompra:detallecompras){
			detallecompra.setDetalleCompraOriginal((DetalleCompra)detallecompra.clone());
		}
	}
	
	public static void setDetalleCompraOriginalStatic(DetalleCompra detallecompra)throws Exception  {
		detallecompra.setDetalleCompraOriginal((DetalleCompra)detallecompra.clone());		
	}
	
	public static void setDetalleComprasOriginalStatic(List<DetalleCompra> detallecompras)throws Exception  {
		
		for(DetalleCompra detallecompra:detallecompras){
			detallecompra.setDetalleCompraOriginal((DetalleCompra)detallecompra.clone());
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
	
	public  DetalleCompra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleCompra entity = new DetalleCompra();		
		
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
	
	public  DetalleCompra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleCompra entity = new DetalleCompra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DetalleCompra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleCompraOriginal(new DetalleCompra());
      	    	entity=super.getEntity("",entity,resultSet,DetalleCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleCompra("",entity,resultSet); 
				
				//entity.setDetalleCompraOriginal(super.getEntity("",entity.getDetalleCompraOriginal(),resultSet,DetalleCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCompraOriginal(this.getEntityDetalleCompra("",entity.getDetalleCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleCompra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleCompra entity = new DetalleCompra();
				
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
	
	public  DetalleCompra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleCompra entity = new DetalleCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleCompra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleCompraOriginal(new DetalleCompra());
      	    	entity=super.getEntity("",entity,resultSet,DetalleCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleCompra("",entity,resultSet);    
				
				//entity.setDetalleCompraOriginal(super.getEntity("",entity.getDetalleCompraOriginal(),resultSet,DetalleCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCompraOriginal(this.getEntityDetalleCompra("",entity.getDetalleCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleCompra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleCompra entity = new DetalleCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleCompra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleCompra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleCompra> entities = new  ArrayList<DetalleCompra>();
		DetalleCompra entity = new DetalleCompra();		  
		
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
	
	public  List<DetalleCompra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleCompra> entities = new  ArrayList<DetalleCompra>();
		DetalleCompra entity = new DetalleCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetalleCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleCompra("",entity,resultSet);
      	    	
				//entity.setDetalleCompraOriginal( new DetalleCompra());
      	    	//entity.setDetalleCompraOriginal(super.getEntity("",entity.getDetalleCompraOriginal(),resultSet,DetalleCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCompraOriginal(this.getEntityDetalleCompra("",entity.getDetalleCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleCompra> entities = new  ArrayList<DetalleCompra>();
		DetalleCompra entity = new DetalleCompra();		  
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
	
	public  List<DetalleCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleCompra> entities = new  ArrayList<DetalleCompra>();
		DetalleCompra entity = new DetalleCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleCompra();
					//entity.setMapDetalleCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleCompraDataAccess.ISWITHSCHEMA);         		
					entity=DetalleCompraDataAccess.getEntityDetalleCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleCompraOriginal( new DetalleCompra());
					////entity.setDetalleCompraOriginal(super.getEntity("",entity.getDetalleCompraOriginal(),resultSet,DetalleCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleCompraOriginal(this.getEntityDetalleCompra("",entity.getDetalleCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleCompra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleCompra entity = new DetalleCompra();		  
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
	
	public  DetalleCompra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleCompra entity = new DetalleCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleCompra();
					//entity.setMapDetalleCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleCompraDataAccess.ISWITHSCHEMA);         		
					entity=DetalleCompraDataAccess.getEntityDetalleCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleCompraOriginal( new DetalleCompra());
					////entity.setDetalleCompraOriginal(super.getEntity("",entity.getDetalleCompraOriginal(),resultSet,DetalleCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleCompraOriginal(this.getEntityDetalleCompra("",entity.getDetalleCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleCompra getEntityDetalleCompra(String strPrefijo,DetalleCompra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleCompra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleCompraDataAccess.setFieldReflectionDetalleCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleCompra=DetalleCompraConstantesFunciones.getTodosTiposColumnasDetalleCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleCompra) {
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
							field = DetalleCompra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleCompraDataAccess.setFieldReflectionDetalleCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleCompra(Field field,String strPrefijo,String sColumn,DetalleCompra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleCompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IDCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IDESTADODETALLEINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IDNOVEDADPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.COSTOUNITARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IVAVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.DISPONIBLE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.COSTOIVA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.ICEVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.DESCUENTO1:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.DESCUENTO2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.SERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.LOTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.FECHAELABORACIONLOTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleCompraConstantesFunciones.FECHACADUCIDADLOTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleCompraConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.IDCUENTACONTABLECOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleCompraConstantesFunciones.LOTECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleCompra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleCompra> entities = new  ArrayList<DetalleCompra>();
		DetalleCompra entity = new DetalleCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleCompra();
					entity=super.getEntity("",entity,resultSet,DetalleCompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleCompra("",entity,resultSet);
					
					//entity.setDetalleCompraOriginal( new DetalleCompra());
					//entity.setDetalleCompraOriginal(super.getEntity("",entity.getDetalleCompraOriginal(),resultSet,DetalleCompraDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleCompraOriginal(this.getEntityDetalleCompra("",entity.getDetalleCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleCompra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleCompra> entities = new  ArrayList<DetalleCompra>();
		DetalleCompra entity = new DetalleCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCompra> entities = new  ArrayList<DetalleCompra>();
		DetalleCompra entity = new DetalleCompra();		  
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
	
	public  List<DetalleCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCompra> entities = new  ArrayList<DetalleCompra>();
		DetalleCompra entity = new DetalleCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetalleCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleCompra("",entity,resultSet);
      	    	
				//entity.setDetalleCompraOriginal( new DetalleCompra());
      	    	//entity.setDetalleCompraOriginal(super.getEntity("",entity.getDetalleCompraOriginal(),resultSet,DetalleCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCompraOriginal(this.getEntityDetalleCompra("",entity.getDetalleCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleCompra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCompra> entities = new  ArrayList<DetalleCompra>();
		DetalleCompra entity = new DetalleCompra();		  
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
	
	public  List<DetalleCompra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCompra> entities = new  ArrayList<DetalleCompra>();
		DetalleCompra entity = new DetalleCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetalleCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleCompra("",entity,resultSet);
      	    	
				//entity.setDetalleCompraOriginal( new DetalleCompra());
      	    	//entity.setDetalleCompraOriginal(super.getEntity("",entity.getDetalleCompraOriginal(),resultSet,DetalleCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCompraOriginal(this.getEntityDetalleCompra("",entity.getDetalleCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleCompras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleCompra getEntityDetalleCompra(String strPrefijo,DetalleCompra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_compra(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDCOMPRA));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_estado_detalle_inventario(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDESTADODETALLEINVENTARIO));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDUNIDAD));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleCompraConstantesFunciones.DESCRIPCION));
				entity.setid_novedad_producto(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDNOVEDADPRODUCTO));if(resultSet.wasNull()) {entity.setid_novedad_producto(null); }
				entity.setcantidad(resultSet.getInt(strPrefijo+DetalleCompraConstantesFunciones.CANTIDAD));
				entity.setdescuento(resultSet.getDouble(strPrefijo+DetalleCompraConstantesFunciones.DESCUENTO));
				entity.setcosto_unitario(resultSet.getDouble(strPrefijo+DetalleCompraConstantesFunciones.COSTOUNITARIO));
				entity.setiva(resultSet.getDouble(strPrefijo+DetalleCompraConstantesFunciones.IVA));
				entity.setiva_valor(resultSet.getDouble(strPrefijo+DetalleCompraConstantesFunciones.IVAVALOR));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+DetalleCompraConstantesFunciones.COSTOTOTAL));
				entity.setdisponible(resultSet.getInt(strPrefijo+DetalleCompraConstantesFunciones.DISPONIBLE));
				entity.setcosto_iva(resultSet.getBoolean(strPrefijo+DetalleCompraConstantesFunciones.COSTOIVA));
				entity.setice(resultSet.getDouble(strPrefijo+DetalleCompraConstantesFunciones.ICE));
				entity.setice_valor(resultSet.getDouble(strPrefijo+DetalleCompraConstantesFunciones.ICEVALOR));
				entity.setdescuento1(resultSet.getDouble(strPrefijo+DetalleCompraConstantesFunciones.DESCUENTO1));
				entity.setdescuento2(resultSet.getDouble(strPrefijo+DetalleCompraConstantesFunciones.DESCUENTO2));
				entity.setserie(resultSet.getString(strPrefijo+DetalleCompraConstantesFunciones.SERIE));
				entity.setlote(resultSet.getString(strPrefijo+DetalleCompraConstantesFunciones.LOTE));
				entity.setfecha_elaboracion_lote(new Date(resultSet.getDate(strPrefijo+DetalleCompraConstantesFunciones.FECHAELABORACIONLOTE).getTime()));
				entity.setfecha_caducidad_lote(new Date(resultSet.getDate(strPrefijo+DetalleCompraConstantesFunciones.FECHACADUCIDADLOTE).getTime()));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_cuenta_contable_costo(resultSet.getLong(strPrefijo+DetalleCompraConstantesFunciones.IDCUENTACONTABLECOSTO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_costo(null); }
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+DetalleCompraConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setlote_cliente(resultSet.getString(strPrefijo+DetalleCompraConstantesFunciones.LOTECLIENTE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleCompra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleCompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleCompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleCompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleCompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleCompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleCompraDataAccess.TABLENAME,DetalleCompraDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleCompraDataAccess.setDetalleCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Compra getCompra(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		Compra compra= new Compra();

		try {
			CompraDataAccess compraDataAccess=new CompraDataAccess();

			compraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			compraDataAccess.setConnexionType(this.connexionType);
			compraDataAccess.setParameterDbType(this.parameterDbType);

			compra=compraDataAccess.getEntity(connexion,reldetallecompra.getid_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return compra;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallecompra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallecompra.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetallecompra.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetallecompra.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetallecompra.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetallecompra.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public EstadoDetalleInventario getEstadoDetalleInventario(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		EstadoDetalleInventario estadodetalleinventario= new EstadoDetalleInventario();

		try {
			EstadoDetalleInventarioDataAccess estadodetalleinventarioDataAccess=new EstadoDetalleInventarioDataAccess();

			estadodetalleinventarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadodetalleinventarioDataAccess.setConnexionType(this.connexionType);
			estadodetalleinventarioDataAccess.setParameterDbType(this.parameterDbType);

			estadodetalleinventario=estadodetalleinventarioDataAccess.getEntity(connexion,reldetallecompra.getid_estado_detalle_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadodetalleinventario;

	}

	public Bodega getBodega(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetallecompra.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetallecompra.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetallecompra.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public NovedadProducto getNovedadProducto(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		NovedadProducto novedadproducto= new NovedadProducto();

		try {
			NovedadProductoDataAccess novedadproductoDataAccess=new NovedadProductoDataAccess();

			novedadproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			novedadproductoDataAccess.setConnexionType(this.connexionType);
			novedadproductoDataAccess.setParameterDbType(this.parameterDbType);

			novedadproducto=novedadproductoDataAccess.getEntity(connexion,reldetallecompra.getid_novedad_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedadproducto;

	}

	public CentroCosto getCentroCosto(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,reldetallecompra.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public CuentaContable getCuentaContableCosto(Connexion connexion,DetalleCompra reldetallecompra)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reldetallecompra.getid_cuenta_contable_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleCompra detallecompra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallecompra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_compra.setValue(detallecompra.getid_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallecompra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallecompra.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detallecompra.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detallecompra.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detallecompra.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detallecompra.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_detalle_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_detalle_inventario.setValue(detallecompra.getid_estado_detalle_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_detalle_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detallecompra.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detallecompra.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detallecompra.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detallecompra.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_novedad_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_novedad_producto.setValue(detallecompra.getid_novedad_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_novedad_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detallecompra.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(detallecompra.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_unitario=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_unitario.setValue(detallecompra.getcosto_unitario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_unitario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(detallecompra.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva_valor=new ParameterValue<Double>();
					parameterMaintenanceValueiva_valor.setValue(detallecompra.getiva_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(detallecompra.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedisponible=new ParameterValue<Integer>();
					parameterMaintenanceValuedisponible.setValue(detallecompra.getdisponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedisponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecosto_iva=new ParameterValue<Boolean>();
					parameterMaintenanceValuecosto_iva.setValue(detallecompra.getcosto_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(detallecompra.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice_valor=new ParameterValue<Double>();
					parameterMaintenanceValueice_valor.setValue(detallecompra.getice_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento1=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento1.setValue(detallecompra.getdescuento1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento2=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento2.setValue(detallecompra.getdescuento2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueserie=new ParameterValue<String>();
					parameterMaintenanceValueserie.setValue(detallecompra.getserie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueserie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote=new ParameterValue<String>();
					parameterMaintenanceValuelote.setValue(detallecompra.getlote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_elaboracion_lote=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_elaboracion_lote.setValue(detallecompra.getfecha_elaboracion_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_elaboracion_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_caducidad_lote=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_caducidad_lote.setValue(detallecompra.getfecha_caducidad_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_caducidad_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(detallecompra.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo.setValue(detallecompra.getid_cuenta_contable_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(detallecompra.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote_cliente=new ParameterValue<String>();
					parameterMaintenanceValuelote_cliente.setValue(detallecompra.getlote_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote_cliente);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallecompra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallecompra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallecompra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallecompra.getId());
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
	
	public void setIsNewIsChangedFalseDetalleCompra(DetalleCompra detallecompra)throws Exception  {		
		detallecompra.setIsNew(false);
		detallecompra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleCompras(List<DetalleCompra> detallecompras)throws Exception  {				
		for(DetalleCompra detallecompra:detallecompras) {
			detallecompra.setIsNew(false);
			detallecompra.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
