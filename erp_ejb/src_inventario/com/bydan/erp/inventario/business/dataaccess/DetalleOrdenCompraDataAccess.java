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
import com.bydan.erp.inventario.util.*;//DetalleOrdenCompraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DetalleOrdenCompraDataAccess extends  DetalleOrdenCompraDataAccessAdditional{ //DetalleOrdenCompraDataAccessAdditional,DataAccessHelper<DetalleOrdenCompra>
	//static Logger logger = Logger.getLogger(DetalleOrdenCompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_orden_compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+"(version_row,id_orden_compra,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_bodega,id_producto,id_unidad,descripcion,cantidad,descuento,costo_unitario,iva,iva_valor,costo_total,disponible,id_novedad_producto,id_estado_detalle_orden_compra,numero_comprobante,lote_cliente)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_orden_compra=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_bodega=?,id_producto=?,id_unidad=?,descripcion=?,cantidad=?,descuento=?,costo_unitario=?,iva=?,iva_valor=?,costo_total=?,disponible=?,id_novedad_producto=?,id_estado_detalle_orden_compra=?,numero_comprobante=?,lote_cliente=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleordencompra from "+DetalleOrdenCompraConstantesFunciones.SPERSISTENCENAME+" detalleordencompra";
	public static String QUERYSELECTNATIVE="select "+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".version_row,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_orden_compra,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_empresa,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_periodo,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_anio,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_mes,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_bodega,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_producto,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_unidad,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".descripcion,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".cantidad,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".descuento,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".costo_unitario,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".iva,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".iva_valor,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".costo_total,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".disponible,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_novedad_producto,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id_estado_detalle_orden_compra,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".lote_cliente from "+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME;//+" as "+DetalleOrdenCompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".id,"+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+".version_row from "+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME;//+" as "+DetalleOrdenCompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleOrdenCompraConstantesFunciones.SCHEMA+"."+DetalleOrdenCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_orden_compra=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_bodega=?,id_producto=?,id_unidad=?,descripcion=?,cantidad=?,descuento=?,costo_unitario=?,iva=?,iva_valor=?,costo_total=?,disponible=?,id_novedad_producto=?,id_estado_detalle_orden_compra=?,numero_comprobante=?,lote_cliente=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEORDENCOMPRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEORDENCOMPRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEORDENCOMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEORDENCOMPRA_SELECT(?,?)";
	
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
	
	
	protected DetalleOrdenCompraDataAccessAdditional detalleordencompraDataAccessAdditional=null;
	
	public DetalleOrdenCompraDataAccessAdditional getDetalleOrdenCompraDataAccessAdditional() {
		return this.detalleordencompraDataAccessAdditional;
	}
	
	public void setDetalleOrdenCompraDataAccessAdditional(DetalleOrdenCompraDataAccessAdditional detalleordencompraDataAccessAdditional) {
		try {
			this.detalleordencompraDataAccessAdditional=detalleordencompraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleOrdenCompraDataAccess() {
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
		DetalleOrdenCompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleOrdenCompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleOrdenCompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleOrdenCompraOriginal(DetalleOrdenCompra detalleordencompra)throws Exception  {
		detalleordencompra.setDetalleOrdenCompraOriginal((DetalleOrdenCompra)detalleordencompra.clone());		
	}
	
	public void setDetalleOrdenComprasOriginal(List<DetalleOrdenCompra> detalleordencompras)throws Exception  {
		
		for(DetalleOrdenCompra detalleordencompra:detalleordencompras){
			detalleordencompra.setDetalleOrdenCompraOriginal((DetalleOrdenCompra)detalleordencompra.clone());
		}
	}
	
	public static void setDetalleOrdenCompraOriginalStatic(DetalleOrdenCompra detalleordencompra)throws Exception  {
		detalleordencompra.setDetalleOrdenCompraOriginal((DetalleOrdenCompra)detalleordencompra.clone());		
	}
	
	public static void setDetalleOrdenComprasOriginalStatic(List<DetalleOrdenCompra> detalleordencompras)throws Exception  {
		
		for(DetalleOrdenCompra detalleordencompra:detalleordencompras){
			detalleordencompra.setDetalleOrdenCompraOriginal((DetalleOrdenCompra)detalleordencompra.clone());
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
	
	public  DetalleOrdenCompra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		
		
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
	
	public  DetalleOrdenCompra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleOrdenCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DetalleOrdenCompra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleOrdenCompraOriginal(new DetalleOrdenCompra());
      	    	entity=super.getEntity("",entity,resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleOrdenCompra("",entity,resultSet); 
				
				//entity.setDetalleOrdenCompraOriginal(super.getEntity("",entity.getDetalleOrdenCompraOriginal(),resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleOrdenCompraOriginal(this.getEntityDetalleOrdenCompra("",entity.getDetalleOrdenCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleOrdenCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleOrdenCompra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleOrdenCompra entity = new DetalleOrdenCompra();
				
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
	
	public  DetalleOrdenCompra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleOrdenCompra entity = new DetalleOrdenCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleOrdenCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleOrdenCompra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleOrdenCompraOriginal(new DetalleOrdenCompra());
      	    	entity=super.getEntity("",entity,resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleOrdenCompra("",entity,resultSet);    
				
				//entity.setDetalleOrdenCompraOriginal(super.getEntity("",entity.getDetalleOrdenCompraOriginal(),resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleOrdenCompraOriginal(this.getEntityDetalleOrdenCompra("",entity.getDetalleOrdenCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleOrdenCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleOrdenCompra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleOrdenCompra entity = new DetalleOrdenCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleOrdenCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleOrdenCompra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleOrdenCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleOrdenCompra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleOrdenCompra> entities = new  ArrayList<DetalleOrdenCompra>();
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		  
		
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
	
	public  List<DetalleOrdenCompra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleOrdenCompra> entities = new  ArrayList<DetalleOrdenCompra>();
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleOrdenCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleOrdenCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleOrdenCompra("",entity,resultSet);
      	    	
				//entity.setDetalleOrdenCompraOriginal( new DetalleOrdenCompra());
      	    	//entity.setDetalleOrdenCompraOriginal(super.getEntity("",entity.getDetalleOrdenCompraOriginal(),resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleOrdenCompraOriginal(this.getEntityDetalleOrdenCompra("",entity.getDetalleOrdenCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleOrdenCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleOrdenCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleOrdenCompra> entities = new  ArrayList<DetalleOrdenCompra>();
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		  
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
	
	public  List<DetalleOrdenCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleOrdenCompra> entities = new  ArrayList<DetalleOrdenCompra>();
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleOrdenCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleOrdenCompra();
					//entity.setMapDetalleOrdenCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleOrdenCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleOrdenCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA);         		
					entity=DetalleOrdenCompraDataAccess.getEntityDetalleOrdenCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleOrdenCompraOriginal( new DetalleOrdenCompra());
					////entity.setDetalleOrdenCompraOriginal(super.getEntity("",entity.getDetalleOrdenCompraOriginal(),resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleOrdenCompraOriginal(this.getEntityDetalleOrdenCompra("",entity.getDetalleOrdenCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleOrdenCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleOrdenCompra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		  
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
	
	public  DetalleOrdenCompra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleOrdenCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleOrdenCompra();
					//entity.setMapDetalleOrdenCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleOrdenCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleOrdenCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA);         		
					entity=DetalleOrdenCompraDataAccess.getEntityDetalleOrdenCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleOrdenCompraOriginal( new DetalleOrdenCompra());
					////entity.setDetalleOrdenCompraOriginal(super.getEntity("",entity.getDetalleOrdenCompraOriginal(),resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleOrdenCompraOriginal(this.getEntityDetalleOrdenCompra("",entity.getDetalleOrdenCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleOrdenCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleOrdenCompra getEntityDetalleOrdenCompra(String strPrefijo,DetalleOrdenCompra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleOrdenCompra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleOrdenCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleOrdenCompraDataAccess.setFieldReflectionDetalleOrdenCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleOrdenCompra=DetalleOrdenCompraConstantesFunciones.getTodosTiposColumnasDetalleOrdenCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleOrdenCompra) {
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
							field = DetalleOrdenCompra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleOrdenCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleOrdenCompraDataAccess.setFieldReflectionDetalleOrdenCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleOrdenCompra(Field field,String strPrefijo,String sColumn,DetalleOrdenCompra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleOrdenCompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IDORDENCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.COSTOUNITARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IVAVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.DISPONIBLE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IDNOVEDADPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.IDESTADODETALLEORDENCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleOrdenCompraConstantesFunciones.LOTECLIENTE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleOrdenCompra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleOrdenCompra> entities = new  ArrayList<DetalleOrdenCompra>();
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleOrdenCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleOrdenCompra();
					entity=super.getEntity("",entity,resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleOrdenCompra("",entity,resultSet);
					
					//entity.setDetalleOrdenCompraOriginal( new DetalleOrdenCompra());
					//entity.setDetalleOrdenCompraOriginal(super.getEntity("",entity.getDetalleOrdenCompraOriginal(),resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleOrdenCompraOriginal(this.getEntityDetalleOrdenCompra("",entity.getDetalleOrdenCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleOrdenCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleOrdenCompra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleOrdenCompra> entities = new  ArrayList<DetalleOrdenCompra>();
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleOrdenCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleOrdenCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleOrdenCompra> entities = new  ArrayList<DetalleOrdenCompra>();
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		  
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
	
	public  List<DetalleOrdenCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleOrdenCompra> entities = new  ArrayList<DetalleOrdenCompra>();
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleOrdenCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleOrdenCompra("",entity,resultSet);
      	    	
				//entity.setDetalleOrdenCompraOriginal( new DetalleOrdenCompra());
      	    	//entity.setDetalleOrdenCompraOriginal(super.getEntity("",entity.getDetalleOrdenCompraOriginal(),resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleOrdenCompraOriginal(this.getEntityDetalleOrdenCompra("",entity.getDetalleOrdenCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleOrdenCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleOrdenCompra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleOrdenCompra> entities = new  ArrayList<DetalleOrdenCompra>();
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		  
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
	
	public  List<DetalleOrdenCompra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleOrdenCompra> entities = new  ArrayList<DetalleOrdenCompra>();
		DetalleOrdenCompra entity = new DetalleOrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleOrdenCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleOrdenCompra("",entity,resultSet);
      	    	
				//entity.setDetalleOrdenCompraOriginal( new DetalleOrdenCompra());
      	    	//entity.setDetalleOrdenCompraOriginal(super.getEntity("",entity.getDetalleOrdenCompraOriginal(),resultSet,DetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleOrdenCompraOriginal(this.getEntityDetalleOrdenCompra("",entity.getDetalleOrdenCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleOrdenCompras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleOrdenCompra getEntityDetalleOrdenCompra(String strPrefijo,DetalleOrdenCompra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_orden_compra(resultSet.getLong(strPrefijo+DetalleOrdenCompraConstantesFunciones.IDORDENCOMPRA));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleOrdenCompraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleOrdenCompraConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleOrdenCompraConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleOrdenCompraConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleOrdenCompraConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleOrdenCompraConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleOrdenCompraConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleOrdenCompraConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleOrdenCompraConstantesFunciones.IDUNIDAD));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleOrdenCompraConstantesFunciones.DESCRIPCION));
				entity.setcantidad(resultSet.getInt(strPrefijo+DetalleOrdenCompraConstantesFunciones.CANTIDAD));
				entity.setdescuento(resultSet.getDouble(strPrefijo+DetalleOrdenCompraConstantesFunciones.DESCUENTO));
				entity.setcosto_unitario(resultSet.getDouble(strPrefijo+DetalleOrdenCompraConstantesFunciones.COSTOUNITARIO));
				entity.setiva(resultSet.getDouble(strPrefijo+DetalleOrdenCompraConstantesFunciones.IVA));
				entity.setiva_valor(resultSet.getDouble(strPrefijo+DetalleOrdenCompraConstantesFunciones.IVAVALOR));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+DetalleOrdenCompraConstantesFunciones.COSTOTOTAL));
				entity.setdisponible(resultSet.getInt(strPrefijo+DetalleOrdenCompraConstantesFunciones.DISPONIBLE));
				entity.setid_novedad_producto(resultSet.getLong(strPrefijo+DetalleOrdenCompraConstantesFunciones.IDNOVEDADPRODUCTO));if(resultSet.wasNull()) {entity.setid_novedad_producto(null); }
				entity.setid_estado_detalle_orden_compra(resultSet.getLong(strPrefijo+DetalleOrdenCompraConstantesFunciones.IDESTADODETALLEORDENCOMPRA));
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+DetalleOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setlote_cliente(resultSet.getString(strPrefijo+DetalleOrdenCompraConstantesFunciones.LOTECLIENTE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleOrdenCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleOrdenCompra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleOrdenCompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleOrdenCompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleOrdenCompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleOrdenCompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleOrdenCompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleOrdenCompraDataAccess.TABLENAME,DetalleOrdenCompraDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleOrdenCompraDataAccess.setDetalleOrdenCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public OrdenCompra getOrdenCompra(Connexion connexion,DetalleOrdenCompra reldetalleordencompra)throws SQLException,Exception {

		OrdenCompra ordencompra= new OrdenCompra();

		try {
			OrdenCompraDataAccess ordencompraDataAccess=new OrdenCompraDataAccess();

			ordencompraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ordencompraDataAccess.setConnexionType(this.connexionType);
			ordencompraDataAccess.setParameterDbType(this.parameterDbType);

			ordencompra=ordencompraDataAccess.getEntity(connexion,reldetalleordencompra.getid_orden_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordencompra;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleOrdenCompra reldetalleordencompra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleordencompra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleOrdenCompra reldetalleordencompra)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleordencompra.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleOrdenCompra reldetalleordencompra)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetalleordencompra.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleOrdenCompra reldetalleordencompra)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetalleordencompra.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetalleOrdenCompra reldetalleordencompra)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetalleordencompra.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleOrdenCompra reldetalleordencompra)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetalleordencompra.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Bodega getBodega(Connexion connexion,DetalleOrdenCompra reldetalleordencompra)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetalleordencompra.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetalleOrdenCompra reldetalleordencompra)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetalleordencompra.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetalleOrdenCompra reldetalleordencompra)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetalleordencompra.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public NovedadProducto getNovedadProducto(Connexion connexion,DetalleOrdenCompra reldetalleordencompra)throws SQLException,Exception {

		NovedadProducto novedadproducto= new NovedadProducto();

		try {
			NovedadProductoDataAccess novedadproductoDataAccess=new NovedadProductoDataAccess();

			novedadproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			novedadproductoDataAccess.setConnexionType(this.connexionType);
			novedadproductoDataAccess.setParameterDbType(this.parameterDbType);

			novedadproducto=novedadproductoDataAccess.getEntity(connexion,reldetalleordencompra.getid_novedad_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedadproducto;

	}

	public EstadoDetalleOrdenCompra getEstadoDetalleOrdenCompra(Connexion connexion,DetalleOrdenCompra reldetalleordencompra)throws SQLException,Exception {

		EstadoDetalleOrdenCompra estadodetalleordencompra= new EstadoDetalleOrdenCompra();

		try {
			EstadoDetalleOrdenCompraDataAccess estadodetalleordencompraDataAccess=new EstadoDetalleOrdenCompraDataAccess();

			estadodetalleordencompraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadodetalleordencompraDataAccess.setConnexionType(this.connexionType);
			estadodetalleordencompraDataAccess.setParameterDbType(this.parameterDbType);

			estadodetalleordencompra=estadodetalleordencompraDataAccess.getEntity(connexion,reldetalleordencompra.getid_estado_detalle_orden_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadodetalleordencompra;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleOrdenCompra detalleordencompra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleordencompra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_orden_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_orden_compra.setValue(detalleordencompra.getid_orden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_orden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleordencompra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleordencompra.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detalleordencompra.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detalleordencompra.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detalleordencompra.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detalleordencompra.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detalleordencompra.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detalleordencompra.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detalleordencompra.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detalleordencompra.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detalleordencompra.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(detalleordencompra.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_unitario=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_unitario.setValue(detalleordencompra.getcosto_unitario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_unitario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(detalleordencompra.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva_valor=new ParameterValue<Double>();
					parameterMaintenanceValueiva_valor.setValue(detalleordencompra.getiva_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(detalleordencompra.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedisponible=new ParameterValue<Integer>();
					parameterMaintenanceValuedisponible.setValue(detalleordencompra.getdisponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedisponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_novedad_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_novedad_producto.setValue(detalleordencompra.getid_novedad_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_novedad_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_detalle_orden_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_detalle_orden_compra.setValue(detalleordencompra.getid_estado_detalle_orden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_detalle_orden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(detalleordencompra.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote_cliente=new ParameterValue<String>();
					parameterMaintenanceValuelote_cliente.setValue(detalleordencompra.getlote_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote_cliente);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleordencompra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleordencompra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleordencompra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleordencompra.getId());
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
	
	public void setIsNewIsChangedFalseDetalleOrdenCompra(DetalleOrdenCompra detalleordencompra)throws Exception  {		
		detalleordencompra.setIsNew(false);
		detalleordencompra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleOrdenCompras(List<DetalleOrdenCompra> detalleordencompras)throws Exception  {				
		for(DetalleOrdenCompra detalleordencompra:detalleordencompras) {
			detalleordencompra.setIsNew(false);
			detalleordencompra.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleOrdenCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
