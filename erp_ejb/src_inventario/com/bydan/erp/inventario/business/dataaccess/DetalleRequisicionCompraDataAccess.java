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
import com.bydan.erp.inventario.util.*;//DetalleRequisicionCompraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DetalleRequisicionCompraDataAccess extends  DetalleRequisicionCompraDataAccessAdditional{ //DetalleRequisicionCompraDataAccessAdditional,DataAccessHelper<DetalleRequisicionCompra>
	//static Logger logger = Logger.getLogger(DetalleRequisicionCompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_requisicion_compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+"(version_row,id_requisicion_compra,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_bodega,id_producto,id_unidad,id_centro_costo,cantidad_requisicion,costo_unitario,costo_total,descripcion,cantidad_entregada,cantidad_pendiente)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_requisicion_compra=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_bodega=?,id_producto=?,id_unidad=?,id_centro_costo=?,cantidad_requisicion=?,costo_unitario=?,costo_total=?,descripcion=?,cantidad_entregada=?,cantidad_pendiente=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallerequisicioncompra from "+DetalleRequisicionCompraConstantesFunciones.SPERSISTENCENAME+" detallerequisicioncompra";
	public static String QUERYSELECTNATIVE="select "+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".version_row,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_requisicion_compra,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_empresa,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_periodo,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_anio,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_mes,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_bodega,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_producto,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_unidad,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".cantidad_requisicion,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".costo_unitario,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".costo_total,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".descripcion,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".cantidad_entregada,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".cantidad_pendiente from "+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME;//+" as "+DetalleRequisicionCompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".id,"+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+".version_row from "+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME;//+" as "+DetalleRequisicionCompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleRequisicionCompraConstantesFunciones.SCHEMA+"."+DetalleRequisicionCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_requisicion_compra=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_bodega=?,id_producto=?,id_unidad=?,id_centro_costo=?,cantidad_requisicion=?,costo_unitario=?,costo_total=?,descripcion=?,cantidad_entregada=?,cantidad_pendiente=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEREQUISICIONCOMPRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEREQUISICIONCOMPRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEREQUISICIONCOMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEREQUISICIONCOMPRA_SELECT(?,?)";
	
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
	
	
	protected DetalleRequisicionCompraDataAccessAdditional detallerequisicioncompraDataAccessAdditional=null;
	
	public DetalleRequisicionCompraDataAccessAdditional getDetalleRequisicionCompraDataAccessAdditional() {
		return this.detallerequisicioncompraDataAccessAdditional;
	}
	
	public void setDetalleRequisicionCompraDataAccessAdditional(DetalleRequisicionCompraDataAccessAdditional detallerequisicioncompraDataAccessAdditional) {
		try {
			this.detallerequisicioncompraDataAccessAdditional=detallerequisicioncompraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleRequisicionCompraDataAccess() {
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
		DetalleRequisicionCompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleRequisicionCompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleRequisicionCompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleRequisicionCompraOriginal(DetalleRequisicionCompra detallerequisicioncompra)throws Exception  {
		detallerequisicioncompra.setDetalleRequisicionCompraOriginal((DetalleRequisicionCompra)detallerequisicioncompra.clone());		
	}
	
	public void setDetalleRequisicionComprasOriginal(List<DetalleRequisicionCompra> detallerequisicioncompras)throws Exception  {
		
		for(DetalleRequisicionCompra detallerequisicioncompra:detallerequisicioncompras){
			detallerequisicioncompra.setDetalleRequisicionCompraOriginal((DetalleRequisicionCompra)detallerequisicioncompra.clone());
		}
	}
	
	public static void setDetalleRequisicionCompraOriginalStatic(DetalleRequisicionCompra detallerequisicioncompra)throws Exception  {
		detallerequisicioncompra.setDetalleRequisicionCompraOriginal((DetalleRequisicionCompra)detallerequisicioncompra.clone());		
	}
	
	public static void setDetalleRequisicionComprasOriginalStatic(List<DetalleRequisicionCompra> detallerequisicioncompras)throws Exception  {
		
		for(DetalleRequisicionCompra detallerequisicioncompra:detallerequisicioncompras){
			detallerequisicioncompra.setDetalleRequisicionCompraOriginal((DetalleRequisicionCompra)detallerequisicioncompra.clone());
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
	
	public  DetalleRequisicionCompra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		
		
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
	
	public  DetalleRequisicionCompra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleRequisicionCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleRequisicionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DetalleRequisicionCompra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleRequisicionCompraOriginal(new DetalleRequisicionCompra());
      	    	entity=super.getEntity("",entity,resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleRequisicionCompra("",entity,resultSet); 
				
				//entity.setDetalleRequisicionCompraOriginal(super.getEntity("",entity.getDetalleRequisicionCompraOriginal(),resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleRequisicionCompraOriginal(this.getEntityDetalleRequisicionCompra("",entity.getDetalleRequisicionCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleRequisicionCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleRequisicionCompra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();
				
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
	
	public  DetalleRequisicionCompra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleRequisicionCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleRequisicionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleRequisicionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleRequisicionCompra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleRequisicionCompraOriginal(new DetalleRequisicionCompra());
      	    	entity=super.getEntity("",entity,resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleRequisicionCompra("",entity,resultSet);    
				
				//entity.setDetalleRequisicionCompraOriginal(super.getEntity("",entity.getDetalleRequisicionCompraOriginal(),resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleRequisicionCompraOriginal(this.getEntityDetalleRequisicionCompra("",entity.getDetalleRequisicionCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleRequisicionCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleRequisicionCompra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleRequisicionCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleRequisicionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleRequisicionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleRequisicionCompra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleRequisicionCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleRequisicionCompra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleRequisicionCompra> entities = new  ArrayList<DetalleRequisicionCompra>();
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		  
		
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
	
	public  List<DetalleRequisicionCompra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleRequisicionCompra> entities = new  ArrayList<DetalleRequisicionCompra>();
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleRequisicionCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleRequisicionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleRequisicionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleRequisicionCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleRequisicionCompra("",entity,resultSet);
      	    	
				//entity.setDetalleRequisicionCompraOriginal( new DetalleRequisicionCompra());
      	    	//entity.setDetalleRequisicionCompraOriginal(super.getEntity("",entity.getDetalleRequisicionCompraOriginal(),resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleRequisicionCompraOriginal(this.getEntityDetalleRequisicionCompra("",entity.getDetalleRequisicionCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleRequisicionCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleRequisicionCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleRequisicionCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleRequisicionCompra> entities = new  ArrayList<DetalleRequisicionCompra>();
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		  
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
	
	public  List<DetalleRequisicionCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleRequisicionCompra> entities = new  ArrayList<DetalleRequisicionCompra>();
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleRequisicionCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleRequisicionCompra();
					//entity.setMapDetalleRequisicionCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleRequisicionCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleRequisicionCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA);         		
					entity=DetalleRequisicionCompraDataAccess.getEntityDetalleRequisicionCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleRequisicionCompraOriginal( new DetalleRequisicionCompra());
					////entity.setDetalleRequisicionCompraOriginal(super.getEntity("",entity.getDetalleRequisicionCompraOriginal(),resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleRequisicionCompraOriginal(this.getEntityDetalleRequisicionCompra("",entity.getDetalleRequisicionCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleRequisicionCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleRequisicionCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleRequisicionCompra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		  
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
	
	public  DetalleRequisicionCompra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleRequisicionCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleRequisicionCompra();
					//entity.setMapDetalleRequisicionCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleRequisicionCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleRequisicionCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA);         		
					entity=DetalleRequisicionCompraDataAccess.getEntityDetalleRequisicionCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleRequisicionCompraOriginal( new DetalleRequisicionCompra());
					////entity.setDetalleRequisicionCompraOriginal(super.getEntity("",entity.getDetalleRequisicionCompraOriginal(),resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleRequisicionCompraOriginal(this.getEntityDetalleRequisicionCompra("",entity.getDetalleRequisicionCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleRequisicionCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleRequisicionCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleRequisicionCompra getEntityDetalleRequisicionCompra(String strPrefijo,DetalleRequisicionCompra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleRequisicionCompra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleRequisicionCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleRequisicionCompraDataAccess.setFieldReflectionDetalleRequisicionCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleRequisicionCompra=DetalleRequisicionCompraConstantesFunciones.getTodosTiposColumnasDetalleRequisicionCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleRequisicionCompra) {
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
							field = DetalleRequisicionCompra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleRequisicionCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleRequisicionCompraDataAccess.setFieldReflectionDetalleRequisicionCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleRequisicionCompra(Field field,String strPrefijo,String sColumn,DetalleRequisicionCompra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleRequisicionCompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.IDREQUISICIONCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.CANTIDADREQUISICION:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.COSTOUNITARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.CANTIDADENTREGADA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleRequisicionCompraConstantesFunciones.CANTIDADPENDIENTE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleRequisicionCompra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleRequisicionCompra> entities = new  ArrayList<DetalleRequisicionCompra>();
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleRequisicionCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleRequisicionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleRequisicionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleRequisicionCompra();
					entity=super.getEntity("",entity,resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleRequisicionCompra("",entity,resultSet);
					
					//entity.setDetalleRequisicionCompraOriginal( new DetalleRequisicionCompra());
					//entity.setDetalleRequisicionCompraOriginal(super.getEntity("",entity.getDetalleRequisicionCompraOriginal(),resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleRequisicionCompraOriginal(this.getEntityDetalleRequisicionCompra("",entity.getDetalleRequisicionCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleRequisicionCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleRequisicionCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleRequisicionCompra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleRequisicionCompra> entities = new  ArrayList<DetalleRequisicionCompra>();
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleRequisicionCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleRequisicionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleRequisicionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleRequisicionCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleRequisicionCompra> entities = new  ArrayList<DetalleRequisicionCompra>();
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		  
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
	
	public  List<DetalleRequisicionCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleRequisicionCompra> entities = new  ArrayList<DetalleRequisicionCompra>();
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleRequisicionCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleRequisicionCompra("",entity,resultSet);
      	    	
				//entity.setDetalleRequisicionCompraOriginal( new DetalleRequisicionCompra());
      	    	//entity.setDetalleRequisicionCompraOriginal(super.getEntity("",entity.getDetalleRequisicionCompraOriginal(),resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleRequisicionCompraOriginal(this.getEntityDetalleRequisicionCompra("",entity.getDetalleRequisicionCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleRequisicionCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleRequisicionCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleRequisicionCompra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleRequisicionCompra> entities = new  ArrayList<DetalleRequisicionCompra>();
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		  
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
	
	public  List<DetalleRequisicionCompra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleRequisicionCompra> entities = new  ArrayList<DetalleRequisicionCompra>();
		DetalleRequisicionCompra entity = new DetalleRequisicionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleRequisicionCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleRequisicionCompra("",entity,resultSet);
      	    	
				//entity.setDetalleRequisicionCompraOriginal( new DetalleRequisicionCompra());
      	    	//entity.setDetalleRequisicionCompraOriginal(super.getEntity("",entity.getDetalleRequisicionCompraOriginal(),resultSet,DetalleRequisicionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleRequisicionCompraOriginal(this.getEntityDetalleRequisicionCompra("",entity.getDetalleRequisicionCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleRequisicionCompras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleRequisicionCompra getEntityDetalleRequisicionCompra(String strPrefijo,DetalleRequisicionCompra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_requisicion_compra(resultSet.getLong(strPrefijo+DetalleRequisicionCompraConstantesFunciones.IDREQUISICIONCOMPRA));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleRequisicionCompraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleRequisicionCompraConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleRequisicionCompraConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleRequisicionCompraConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleRequisicionCompraConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleRequisicionCompraConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleRequisicionCompraConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleRequisicionCompraConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleRequisicionCompraConstantesFunciones.IDUNIDAD));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+DetalleRequisicionCompraConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setcantidad_requisicion(resultSet.getInt(strPrefijo+DetalleRequisicionCompraConstantesFunciones.CANTIDADREQUISICION));
				entity.setcosto_unitario(resultSet.getDouble(strPrefijo+DetalleRequisicionCompraConstantesFunciones.COSTOUNITARIO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+DetalleRequisicionCompraConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleRequisicionCompraConstantesFunciones.DESCRIPCION));
				entity.setcantidad_entregada(resultSet.getInt(strPrefijo+DetalleRequisicionCompraConstantesFunciones.CANTIDADENTREGADA));
				entity.setcantidad_pendiente(resultSet.getInt(strPrefijo+DetalleRequisicionCompraConstantesFunciones.CANTIDADPENDIENTE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleRequisicionCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleRequisicionCompra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleRequisicionCompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleRequisicionCompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleRequisicionCompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleRequisicionCompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleRequisicionCompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleRequisicionCompraDataAccess.TABLENAME,DetalleRequisicionCompraDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleRequisicionCompraDataAccess.setDetalleRequisicionCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public RequisicionCompra getRequisicionCompra(Connexion connexion,DetalleRequisicionCompra reldetallerequisicioncompra)throws SQLException,Exception {

		RequisicionCompra requisicioncompra= new RequisicionCompra();

		try {
			RequisicionCompraDataAccess requisicioncompraDataAccess=new RequisicionCompraDataAccess();

			requisicioncompraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			requisicioncompraDataAccess.setConnexionType(this.connexionType);
			requisicioncompraDataAccess.setParameterDbType(this.parameterDbType);

			requisicioncompra=requisicioncompraDataAccess.getEntity(connexion,reldetallerequisicioncompra.getid_requisicion_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return requisicioncompra;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleRequisicionCompra reldetallerequisicioncompra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallerequisicioncompra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleRequisicionCompra reldetallerequisicioncompra)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallerequisicioncompra.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleRequisicionCompra reldetallerequisicioncompra)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetallerequisicioncompra.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleRequisicionCompra reldetallerequisicioncompra)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetallerequisicioncompra.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetalleRequisicionCompra reldetallerequisicioncompra)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetallerequisicioncompra.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleRequisicionCompra reldetallerequisicioncompra)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetallerequisicioncompra.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Bodega getBodega(Connexion connexion,DetalleRequisicionCompra reldetallerequisicioncompra)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetallerequisicioncompra.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetalleRequisicionCompra reldetallerequisicioncompra)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetallerequisicioncompra.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetalleRequisicionCompra reldetallerequisicioncompra)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetallerequisicioncompra.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public CentroCosto getCentroCosto(Connexion connexion,DetalleRequisicionCompra reldetallerequisicioncompra)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,reldetallerequisicioncompra.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleRequisicionCompra detallerequisicioncompra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallerequisicioncompra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_requisicion_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_requisicion_compra.setValue(detallerequisicioncompra.getid_requisicion_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_requisicion_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallerequisicioncompra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallerequisicioncompra.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detallerequisicioncompra.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detallerequisicioncompra.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detallerequisicioncompra.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detallerequisicioncompra.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detallerequisicioncompra.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detallerequisicioncompra.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detallerequisicioncompra.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(detallerequisicioncompra.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_requisicion=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_requisicion.setValue(detallerequisicioncompra.getcantidad_requisicion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_requisicion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_unitario=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_unitario.setValue(detallerequisicioncompra.getcosto_unitario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_unitario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(detallerequisicioncompra.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detallerequisicioncompra.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_entregada=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_entregada.setValue(detallerequisicioncompra.getcantidad_entregada());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_entregada);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_pendiente=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_pendiente.setValue(detallerequisicioncompra.getcantidad_pendiente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_pendiente);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallerequisicioncompra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallerequisicioncompra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallerequisicioncompra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallerequisicioncompra.getId());
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
	
	public void setIsNewIsChangedFalseDetalleRequisicionCompra(DetalleRequisicionCompra detallerequisicioncompra)throws Exception  {		
		detallerequisicioncompra.setIsNew(false);
		detallerequisicioncompra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleRequisicionCompras(List<DetalleRequisicionCompra> detallerequisicioncompras)throws Exception  {				
		for(DetalleRequisicionCompra detallerequisicioncompra:detallerequisicioncompras) {
			detallerequisicioncompra.setIsNew(false);
			detallerequisicioncompra.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleRequisicionCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
