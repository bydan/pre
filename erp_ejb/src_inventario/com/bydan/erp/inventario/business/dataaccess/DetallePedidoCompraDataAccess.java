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
import com.bydan.erp.inventario.util.*;//DetallePedidoCompraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DetallePedidoCompraDataAccess extends  DetallePedidoCompraDataAccessAdditional{ //DetallePedidoCompraDataAccessAdditional,DataAccessHelper<DetallePedidoCompra>
	//static Logger logger = Logger.getLogger(DetallePedidoCompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_pedido_compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+"(version_row,id_pedido_compra,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_bodega,id_producto,id_unidad,id_centro_costo,cantidad_pedido,costo_unitario,costo_total,descripcion,cantidad_entregada,cantidad_pendiente)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pedido_compra=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_bodega=?,id_producto=?,id_unidad=?,id_centro_costo=?,cantidad_pedido=?,costo_unitario=?,costo_total=?,descripcion=?,cantidad_entregada=?,cantidad_pendiente=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallepedidocompra from "+DetallePedidoCompraConstantesFunciones.SPERSISTENCENAME+" detallepedidocompra";
	public static String QUERYSELECTNATIVE="select "+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".version_row,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_pedido_compra,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_empresa,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_sucursal,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_periodo,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_anio,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_mes,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_bodega,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_producto,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_unidad,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id_centro_costo,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".cantidad_pedido,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".costo_unitario,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".costo_total,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".descripcion,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".cantidad_entregada,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".cantidad_pendiente from "+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME;//+" as "+DetallePedidoCompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".id,"+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+".version_row from "+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME;//+" as "+DetallePedidoCompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetallePedidoCompraConstantesFunciones.SCHEMA+"."+DetallePedidoCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pedido_compra=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_bodega=?,id_producto=?,id_unidad=?,id_centro_costo=?,cantidad_pedido=?,costo_unitario=?,costo_total=?,descripcion=?,cantidad_entregada=?,cantidad_pendiente=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEPEDIDOCOMPRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEPEDIDOCOMPRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEPEDIDOCOMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEPEDIDOCOMPRA_SELECT(?,?)";
	
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
	
	
	protected DetallePedidoCompraDataAccessAdditional detallepedidocompraDataAccessAdditional=null;
	
	public DetallePedidoCompraDataAccessAdditional getDetallePedidoCompraDataAccessAdditional() {
		return this.detallepedidocompraDataAccessAdditional;
	}
	
	public void setDetallePedidoCompraDataAccessAdditional(DetallePedidoCompraDataAccessAdditional detallepedidocompraDataAccessAdditional) {
		try {
			this.detallepedidocompraDataAccessAdditional=detallepedidocompraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetallePedidoCompraDataAccess() {
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
		DetallePedidoCompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetallePedidoCompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetallePedidoCompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetallePedidoCompraOriginal(DetallePedidoCompra detallepedidocompra)throws Exception  {
		detallepedidocompra.setDetallePedidoCompraOriginal((DetallePedidoCompra)detallepedidocompra.clone());		
	}
	
	public void setDetallePedidoComprasOriginal(List<DetallePedidoCompra> detallepedidocompras)throws Exception  {
		
		for(DetallePedidoCompra detallepedidocompra:detallepedidocompras){
			detallepedidocompra.setDetallePedidoCompraOriginal((DetallePedidoCompra)detallepedidocompra.clone());
		}
	}
	
	public static void setDetallePedidoCompraOriginalStatic(DetallePedidoCompra detallepedidocompra)throws Exception  {
		detallepedidocompra.setDetallePedidoCompraOriginal((DetallePedidoCompra)detallepedidocompra.clone());		
	}
	
	public static void setDetallePedidoComprasOriginalStatic(List<DetallePedidoCompra> detallepedidocompras)throws Exception  {
		
		for(DetallePedidoCompra detallepedidocompra:detallepedidocompras){
			detallepedidocompra.setDetallePedidoCompraOriginal((DetallePedidoCompra)detallepedidocompra.clone());
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
	
	public  DetallePedidoCompra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetallePedidoCompra entity = new DetallePedidoCompra();		
		
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
	
	public  DetallePedidoCompra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetallePedidoCompra entity = new DetallePedidoCompra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePedidoCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DetallePedidoCompra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetallePedidoCompraOriginal(new DetallePedidoCompra());
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetallePedidoCompra("",entity,resultSet); 
				
				//entity.setDetallePedidoCompraOriginal(super.getEntity("",entity.getDetallePedidoCompraOriginal(),resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoCompraOriginal(this.getEntityDetallePedidoCompra("",entity.getDetallePedidoCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetallePedidoCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetallePedidoCompra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetallePedidoCompra entity = new DetallePedidoCompra();
				
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
	
	public  DetallePedidoCompra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetallePedidoCompra entity = new DetallePedidoCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePedidoCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetallePedidoCompra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetallePedidoCompraOriginal(new DetallePedidoCompra());
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetallePedidoCompra("",entity,resultSet);    
				
				//entity.setDetallePedidoCompraOriginal(super.getEntity("",entity.getDetallePedidoCompraOriginal(),resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoCompraOriginal(this.getEntityDetallePedidoCompra("",entity.getDetallePedidoCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetallePedidoCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetallePedidoCompra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetallePedidoCompra entity = new DetallePedidoCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePedidoCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetallePedidoCompra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetallePedidoCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetallePedidoCompra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetallePedidoCompra> entities = new  ArrayList<DetallePedidoCompra>();
		DetallePedidoCompra entity = new DetallePedidoCompra();		  
		
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
	
	public  List<DetallePedidoCompra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetallePedidoCompra> entities = new  ArrayList<DetallePedidoCompra>();
		DetallePedidoCompra entity = new DetallePedidoCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePedidoCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePedidoCompra("",entity,resultSet);
      	    	
				//entity.setDetallePedidoCompraOriginal( new DetallePedidoCompra());
      	    	//entity.setDetallePedidoCompraOriginal(super.getEntity("",entity.getDetallePedidoCompraOriginal(),resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoCompraOriginal(this.getEntityDetallePedidoCompra("",entity.getDetallePedidoCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePedidoCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetallePedidoCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetallePedidoCompra> entities = new  ArrayList<DetallePedidoCompra>();
		DetallePedidoCompra entity = new DetallePedidoCompra();		  
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
	
	public  List<DetallePedidoCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetallePedidoCompra> entities = new  ArrayList<DetallePedidoCompra>();
		DetallePedidoCompra entity = new DetallePedidoCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapDetallePedidoCompra();
					//entity.setMapDetallePedidoCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetallePedidoCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetallePedidoCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA);         		
					entity=DetallePedidoCompraDataAccess.getEntityDetallePedidoCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetallePedidoCompraOriginal( new DetallePedidoCompra());
					////entity.setDetallePedidoCompraOriginal(super.getEntity("",entity.getDetallePedidoCompraOriginal(),resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setDetallePedidoCompraOriginal(this.getEntityDetallePedidoCompra("",entity.getDetallePedidoCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePedidoCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetallePedidoCompra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetallePedidoCompra entity = new DetallePedidoCompra();		  
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
	
	public  DetallePedidoCompra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetallePedidoCompra entity = new DetallePedidoCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapDetallePedidoCompra();
					//entity.setMapDetallePedidoCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetallePedidoCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetallePedidoCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA);         		
					entity=DetallePedidoCompraDataAccess.getEntityDetallePedidoCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetallePedidoCompraOriginal( new DetallePedidoCompra());
					////entity.setDetallePedidoCompraOriginal(super.getEntity("",entity.getDetallePedidoCompraOriginal(),resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setDetallePedidoCompraOriginal(this.getEntityDetallePedidoCompra("",entity.getDetallePedidoCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetallePedidoCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetallePedidoCompra getEntityDetallePedidoCompra(String strPrefijo,DetallePedidoCompra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetallePedidoCompra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetallePedidoCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetallePedidoCompraDataAccess.setFieldReflectionDetallePedidoCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetallePedidoCompra=DetallePedidoCompraConstantesFunciones.getTodosTiposColumnasDetallePedidoCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetallePedidoCompra) {
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
							field = DetallePedidoCompra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetallePedidoCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetallePedidoCompraDataAccess.setFieldReflectionDetallePedidoCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetallePedidoCompra(Field field,String strPrefijo,String sColumn,DetallePedidoCompra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetallePedidoCompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.IDPEDIDOCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.CANTIDADPEDIDO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.COSTOUNITARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.CANTIDADENTREGADA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetallePedidoCompraConstantesFunciones.CANTIDADPENDIENTE:
					field.set(entity,resultSet.getInt(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetallePedidoCompra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetallePedidoCompra> entities = new  ArrayList<DetallePedidoCompra>();
		DetallePedidoCompra entity = new DetallePedidoCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePedidoCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetallePedidoCompra();
					entity=super.getEntity("",entity,resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetallePedidoCompra("",entity,resultSet);
					
					//entity.setDetallePedidoCompraOriginal( new DetallePedidoCompra());
					//entity.setDetallePedidoCompraOriginal(super.getEntity("",entity.getDetallePedidoCompraOriginal(),resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA));         		
					//entity.setDetallePedidoCompraOriginal(this.getEntityDetallePedidoCompra("",entity.getDetallePedidoCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetallePedidoCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetallePedidoCompra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetallePedidoCompra> entities = new  ArrayList<DetallePedidoCompra>();
		DetallePedidoCompra entity = new DetallePedidoCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePedidoCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetallePedidoCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoCompra> entities = new  ArrayList<DetallePedidoCompra>();
		DetallePedidoCompra entity = new DetallePedidoCompra();		  
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
	
	public  List<DetallePedidoCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoCompra> entities = new  ArrayList<DetallePedidoCompra>();
		DetallePedidoCompra entity = new DetallePedidoCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePedidoCompra("",entity,resultSet);
      	    	
				//entity.setDetallePedidoCompraOriginal( new DetallePedidoCompra());
      	    	//entity.setDetallePedidoCompraOriginal(super.getEntity("",entity.getDetallePedidoCompraOriginal(),resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoCompraOriginal(this.getEntityDetallePedidoCompra("",entity.getDetallePedidoCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetallePedidoCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetallePedidoCompra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoCompra> entities = new  ArrayList<DetallePedidoCompra>();
		DetallePedidoCompra entity = new DetallePedidoCompra();		  
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
	
	public  List<DetallePedidoCompra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoCompra> entities = new  ArrayList<DetallePedidoCompra>();
		DetallePedidoCompra entity = new DetallePedidoCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePedidoCompra("",entity,resultSet);
      	    	
				//entity.setDetallePedidoCompraOriginal( new DetallePedidoCompra());
      	    	//entity.setDetallePedidoCompraOriginal(super.getEntity("",entity.getDetallePedidoCompraOriginal(),resultSet,DetallePedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoCompraOriginal(this.getEntityDetallePedidoCompra("",entity.getDetallePedidoCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePedidoCompras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetallePedidoCompra getEntityDetallePedidoCompra(String strPrefijo,DetallePedidoCompra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pedido_compra(resultSet.getLong(strPrefijo+DetallePedidoCompraConstantesFunciones.IDPEDIDOCOMPRA));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetallePedidoCompraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetallePedidoCompraConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetallePedidoCompraConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetallePedidoCompraConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetallePedidoCompraConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetallePedidoCompraConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetallePedidoCompraConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetallePedidoCompraConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetallePedidoCompraConstantesFunciones.IDUNIDAD));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+DetallePedidoCompraConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setcantidad_pedido(resultSet.getInt(strPrefijo+DetallePedidoCompraConstantesFunciones.CANTIDADPEDIDO));
				entity.setcosto_unitario(resultSet.getDouble(strPrefijo+DetallePedidoCompraConstantesFunciones.COSTOUNITARIO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+DetallePedidoCompraConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetallePedidoCompraConstantesFunciones.DESCRIPCION));
				entity.setcantidad_entregada(resultSet.getInt(strPrefijo+DetallePedidoCompraConstantesFunciones.CANTIDADENTREGADA));
				entity.setcantidad_pendiente(resultSet.getInt(strPrefijo+DetallePedidoCompraConstantesFunciones.CANTIDADPENDIENTE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetallePedidoCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetallePedidoCompra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetallePedidoCompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetallePedidoCompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetallePedidoCompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetallePedidoCompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetallePedidoCompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetallePedidoCompraDataAccess.TABLENAME,DetallePedidoCompraDataAccess.ISWITHSTOREPROCEDURES);
			
			DetallePedidoCompraDataAccess.setDetallePedidoCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public PedidoCompra getPedidoCompra(Connexion connexion,DetallePedidoCompra reldetallepedidocompra)throws SQLException,Exception {

		PedidoCompra pedidocompra= new PedidoCompra();

		try {
			PedidoCompraDataAccess pedidocompraDataAccess=new PedidoCompraDataAccess();

			pedidocompraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			pedidocompraDataAccess.setConnexionType(this.connexionType);
			pedidocompraDataAccess.setParameterDbType(this.parameterDbType);

			pedidocompra=pedidocompraDataAccess.getEntity(connexion,reldetallepedidocompra.getid_pedido_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompra;

	}

	public Empresa getEmpresa(Connexion connexion,DetallePedidoCompra reldetallepedidocompra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallepedidocompra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetallePedidoCompra reldetallepedidocompra)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallepedidocompra.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetallePedidoCompra reldetallepedidocompra)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetallepedidocompra.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetallePedidoCompra reldetallepedidocompra)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetallepedidocompra.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetallePedidoCompra reldetallepedidocompra)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetallepedidocompra.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetallePedidoCompra reldetallepedidocompra)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetallepedidocompra.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Bodega getBodega(Connexion connexion,DetallePedidoCompra reldetallepedidocompra)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetallepedidocompra.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetallePedidoCompra reldetallepedidocompra)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetallepedidocompra.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetallePedidoCompra reldetallepedidocompra)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetallepedidocompra.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public CentroCosto getCentroCosto(Connexion connexion,DetallePedidoCompra reldetallepedidocompra)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,reldetallepedidocompra.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetallePedidoCompra detallepedidocompra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallepedidocompra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pedido_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_pedido_compra.setValue(detallepedidocompra.getid_pedido_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pedido_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallepedidocompra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallepedidocompra.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detallepedidocompra.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detallepedidocompra.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detallepedidocompra.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detallepedidocompra.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detallepedidocompra.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detallepedidocompra.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detallepedidocompra.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(detallepedidocompra.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_pedido=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_pedido.setValue(detallepedidocompra.getcantidad_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_unitario=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_unitario.setValue(detallepedidocompra.getcosto_unitario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_unitario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(detallepedidocompra.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detallepedidocompra.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_entregada=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_entregada.setValue(detallepedidocompra.getcantidad_entregada());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_entregada);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_pendiente=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_pendiente.setValue(detallepedidocompra.getcantidad_pendiente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_pendiente);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallepedidocompra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallepedidocompra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallepedidocompra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallepedidocompra.getId());
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
	
	public void setIsNewIsChangedFalseDetallePedidoCompra(DetallePedidoCompra detallepedidocompra)throws Exception  {		
		detallepedidocompra.setIsNew(false);
		detallepedidocompra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetallePedidoCompras(List<DetallePedidoCompra> detallepedidocompras)throws Exception  {				
		for(DetallePedidoCompra detallepedidocompra:detallepedidocompras) {
			detallepedidocompra.setIsNew(false);
			detallepedidocompra.setIsChanged(false);
		}
	}
	
	public void generarExportarDetallePedidoCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
