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
package com.bydan.erp.produccion.business.dataaccess;

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

import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.produccion.util.*;//OrdenProduConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class OrdenProduDataAccess extends  OrdenProduDataAccessAdditional{ //OrdenProduDataAccessAdditional,DataAccessHelper<OrdenProdu>
	//static Logger logger = Logger.getLogger(OrdenProduDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="orden_produ";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_formato,id_tipo_prioridad_empresa_produ,id_empleado_responsable,secuencial,id_cliente,direccion_cliente,telefono_cliente,ruc_cliente,lote,fecha_pedido,fecha_entrega,es_uso_interno,fecha,descripcion,id_estado_orden_produ)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_formato=?,id_tipo_prioridad_empresa_produ=?,id_empleado_responsable=?,secuencial=?,id_cliente=?,direccion_cliente=?,telefono_cliente=?,ruc_cliente=?,lote=?,fecha_pedido=?,fecha_entrega=?,es_uso_interno=?,fecha=?,descripcion=?,id_estado_orden_produ=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select ordenprodu from "+OrdenProduConstantesFunciones.SPERSISTENCENAME+" ordenprodu";
	public static String QUERYSELECTNATIVE="select "+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".version_row,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_empresa,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_sucursal,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_ejercicio,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_periodo,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_formato,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_tipo_prioridad_empresa_produ,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_empleado_responsable,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".secuencial,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_cliente,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".direccion_cliente,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".telefono_cliente,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".ruc_cliente,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".lote,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".fecha_pedido,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".fecha_entrega,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".es_uso_interno,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".fecha,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".descripcion,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id_estado_orden_produ from "+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME;//+" as "+OrdenProduConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".id,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".version_row,"+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+".secuencial from "+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME;//+" as "+OrdenProduConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+OrdenProduConstantesFunciones.SCHEMA+"."+OrdenProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_formato=?,id_tipo_prioridad_empresa_produ=?,id_empleado_responsable=?,secuencial=?,id_cliente=?,direccion_cliente=?,telefono_cliente=?,ruc_cliente=?,lote=?,fecha_pedido=?,fecha_entrega=?,es_uso_interno=?,fecha=?,descripcion=?,id_estado_orden_produ=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ORDENPRODU_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ORDENPRODU_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ORDENPRODU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ORDENPRODU_SELECT(?,?)";
	
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
	
	
	protected OrdenProduDataAccessAdditional ordenproduDataAccessAdditional=null;
	
	public OrdenProduDataAccessAdditional getOrdenProduDataAccessAdditional() {
		return this.ordenproduDataAccessAdditional;
	}
	
	public void setOrdenProduDataAccessAdditional(OrdenProduDataAccessAdditional ordenproduDataAccessAdditional) {
		try {
			this.ordenproduDataAccessAdditional=ordenproduDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public OrdenProduDataAccess() {
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
		OrdenProduDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		OrdenProduDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		OrdenProduDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setOrdenProduOriginal(OrdenProdu ordenprodu)throws Exception  {
		ordenprodu.setOrdenProduOriginal((OrdenProdu)ordenprodu.clone());		
	}
	
	public void setOrdenProdusOriginal(List<OrdenProdu> ordenprodus)throws Exception  {
		
		for(OrdenProdu ordenprodu:ordenprodus){
			ordenprodu.setOrdenProduOriginal((OrdenProdu)ordenprodu.clone());
		}
	}
	
	public static void setOrdenProduOriginalStatic(OrdenProdu ordenprodu)throws Exception  {
		ordenprodu.setOrdenProduOriginal((OrdenProdu)ordenprodu.clone());		
	}
	
	public static void setOrdenProdusOriginalStatic(List<OrdenProdu> ordenprodus)throws Exception  {
		
		for(OrdenProdu ordenprodu:ordenprodus){
			ordenprodu.setOrdenProduOriginal((OrdenProdu)ordenprodu.clone());
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
	
	public  OrdenProdu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		OrdenProdu entity = new OrdenProdu();		
		
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
	
	public  OrdenProdu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		OrdenProdu entity = new OrdenProdu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=OrdenProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=OrdenProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.OrdenProdu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setOrdenProduOriginal(new OrdenProdu());
      	    	entity=super.getEntity("",entity,resultSet,OrdenProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityOrdenProdu("",entity,resultSet); 
				
				//entity.setOrdenProduOriginal(super.getEntity("",entity.getOrdenProduOriginal(),resultSet,OrdenProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenProduOriginal(this.getEntityOrdenProdu("",entity.getOrdenProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseOrdenProdu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  OrdenProdu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		OrdenProdu entity = new OrdenProdu();
				
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
	
	public  OrdenProdu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		OrdenProdu entity = new OrdenProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=OrdenProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=OrdenProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.OrdenProdu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setOrdenProduOriginal(new OrdenProdu());
      	    	entity=super.getEntity("",entity,resultSet,OrdenProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityOrdenProdu("",entity,resultSet);    
				
				//entity.setOrdenProduOriginal(super.getEntity("",entity.getOrdenProduOriginal(),resultSet,OrdenProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenProduOriginal(this.getEntityOrdenProdu("",entity.getOrdenProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseOrdenProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //OrdenProdu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		OrdenProdu entity = new OrdenProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=OrdenProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=OrdenProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.OrdenProdu.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseOrdenProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<OrdenProdu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<OrdenProdu> entities = new  ArrayList<OrdenProdu>();
		OrdenProdu entity = new OrdenProdu();		  
		
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
	
	public  List<OrdenProdu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<OrdenProdu> entities = new  ArrayList<OrdenProdu>();
		OrdenProdu entity = new OrdenProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=OrdenProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=OrdenProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenProdu();
      	    	entity=super.getEntity("",entity,resultSet,OrdenProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityOrdenProdu("",entity,resultSet);
      	    	
				//entity.setOrdenProduOriginal( new OrdenProdu());
      	    	//entity.setOrdenProduOriginal(super.getEntity("",entity.getOrdenProduOriginal(),resultSet,OrdenProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenProduOriginal(this.getEntityOrdenProdu("",entity.getOrdenProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseOrdenProdus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<OrdenProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<OrdenProdu> entities = new  ArrayList<OrdenProdu>();
		OrdenProdu entity = new OrdenProdu();		  
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
	
	public  List<OrdenProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<OrdenProdu> entities = new  ArrayList<OrdenProdu>();
		OrdenProdu entity = new OrdenProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapOrdenProdu();
					//entity.setMapOrdenProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapOrdenProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapOrdenProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,OrdenProduDataAccess.ISWITHSCHEMA);         		
					entity=OrdenProduDataAccess.getEntityOrdenProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setOrdenProduOriginal( new OrdenProdu());
					////entity.setOrdenProduOriginal(super.getEntity("",entity.getOrdenProduOriginal(),resultSet,OrdenProduDataAccess.ISWITHSCHEMA));         		
					////entity.setOrdenProduOriginal(this.getEntityOrdenProdu("",entity.getOrdenProduOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseOrdenProdus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public OrdenProdu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		OrdenProdu entity = new OrdenProdu();		  
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
	
	public  OrdenProdu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		OrdenProdu entity = new OrdenProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapOrdenProdu();
					//entity.setMapOrdenProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapOrdenProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapOrdenProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,OrdenProduDataAccess.ISWITHSCHEMA);         		
					entity=OrdenProduDataAccess.getEntityOrdenProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setOrdenProduOriginal( new OrdenProdu());
					////entity.setOrdenProduOriginal(super.getEntity("",entity.getOrdenProduOriginal(),resultSet,OrdenProduDataAccess.ISWITHSCHEMA));         		
					////entity.setOrdenProduOriginal(this.getEntityOrdenProdu("",entity.getOrdenProduOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseOrdenProdu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static OrdenProdu getEntityOrdenProdu(String strPrefijo,OrdenProdu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = OrdenProdu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = OrdenProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					OrdenProduDataAccess.setFieldReflectionOrdenProdu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasOrdenProdu=OrdenProduConstantesFunciones.getTodosTiposColumnasOrdenProdu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasOrdenProdu) {
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
							field = OrdenProdu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = OrdenProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						OrdenProduDataAccess.setFieldReflectionOrdenProdu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionOrdenProdu(Field field,String strPrefijo,String sColumn,OrdenProdu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case OrdenProduConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.IDEMPLEADORESPONSABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.DIRECCIONCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.TELEFONOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.RUCCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.LOTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.FECHAPEDIDO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case OrdenProduConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case OrdenProduConstantesFunciones.ESUSOINTERNO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case OrdenProduConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OrdenProduConstantesFunciones.IDESTADOORDENPRODU:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<OrdenProdu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<OrdenProdu> entities = new  ArrayList<OrdenProdu>();
		OrdenProdu entity = new OrdenProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=OrdenProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=OrdenProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new OrdenProdu();
					entity=super.getEntity("",entity,resultSet,OrdenProduDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityOrdenProdu("",entity,resultSet);
					
					//entity.setOrdenProduOriginal( new OrdenProdu());
					//entity.setOrdenProduOriginal(super.getEntity("",entity.getOrdenProduOriginal(),resultSet,OrdenProduDataAccess.ISWITHSCHEMA));         		
					//entity.setOrdenProduOriginal(this.getEntityOrdenProdu("",entity.getOrdenProduOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseOrdenProdus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<OrdenProdu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<OrdenProdu> entities = new  ArrayList<OrdenProdu>();
		OrdenProdu entity = new OrdenProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=OrdenProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=OrdenProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<OrdenProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<OrdenProdu> entities = new  ArrayList<OrdenProdu>();
		OrdenProdu entity = new OrdenProdu();		  
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
	
	public  List<OrdenProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<OrdenProdu> entities = new  ArrayList<OrdenProdu>();
		OrdenProdu entity = new OrdenProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenProdu();
      	    	entity=super.getEntity("",entity,resultSet,OrdenProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityOrdenProdu("",entity,resultSet);
      	    	
				//entity.setOrdenProduOriginal( new OrdenProdu());
      	    	//entity.setOrdenProduOriginal(super.getEntity("",entity.getOrdenProduOriginal(),resultSet,OrdenProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenProduOriginal(this.getEntityOrdenProdu("",entity.getOrdenProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseOrdenProdus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<OrdenProdu> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<OrdenProdu> entities = new  ArrayList<OrdenProdu>();
		OrdenProdu entity = new OrdenProdu();		  
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
	
	public  List<OrdenProdu> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<OrdenProdu> entities = new  ArrayList<OrdenProdu>();
		OrdenProdu entity = new OrdenProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenProdu();
      	    	entity=super.getEntity("",entity,resultSet,OrdenProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityOrdenProdu("",entity,resultSet);
      	    	
				//entity.setOrdenProduOriginal( new OrdenProdu());
      	    	//entity.setOrdenProduOriginal(super.getEntity("",entity.getOrdenProduOriginal(),resultSet,OrdenProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenProduOriginal(this.getEntityOrdenProdu("",entity.getOrdenProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseOrdenProdus(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public OrdenProdu getEntityOrdenProdu(String strPrefijo,OrdenProdu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+OrdenProduConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+OrdenProduConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+OrdenProduConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+OrdenProduConstantesFunciones.IDPERIODO));
				entity.setid_formato(resultSet.getLong(strPrefijo+OrdenProduConstantesFunciones.IDFORMATO));if(resultSet.wasNull()) {entity.setid_formato(null); }
				entity.setid_tipo_prioridad_empresa_produ(resultSet.getLong(strPrefijo+OrdenProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU));
				entity.setid_empleado_responsable(resultSet.getLong(strPrefijo+OrdenProduConstantesFunciones.IDEMPLEADORESPONSABLE));
				entity.setsecuencial(resultSet.getString(strPrefijo+OrdenProduConstantesFunciones.SECUENCIAL));
				entity.setid_cliente(resultSet.getLong(strPrefijo+OrdenProduConstantesFunciones.IDCLIENTE));
				entity.setdireccion_cliente(resultSet.getString(strPrefijo+OrdenProduConstantesFunciones.DIRECCIONCLIENTE));
				entity.settelefono_cliente(resultSet.getString(strPrefijo+OrdenProduConstantesFunciones.TELEFONOCLIENTE));
				entity.setruc_cliente(resultSet.getString(strPrefijo+OrdenProduConstantesFunciones.RUCCLIENTE));
				entity.setlote(resultSet.getString(strPrefijo+OrdenProduConstantesFunciones.LOTE));
				entity.setfecha_pedido(new Date(resultSet.getDate(strPrefijo+OrdenProduConstantesFunciones.FECHAPEDIDO).getTime()));
				entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+OrdenProduConstantesFunciones.FECHAENTREGA).getTime()));
				entity.setes_uso_interno(resultSet.getBoolean(strPrefijo+OrdenProduConstantesFunciones.ESUSOINTERNO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+OrdenProduConstantesFunciones.FECHA).getTime()));
				entity.setdescripcion(resultSet.getString(strPrefijo+OrdenProduConstantesFunciones.DESCRIPCION));
				entity.setid_estado_orden_produ(resultSet.getLong(strPrefijo+OrdenProduConstantesFunciones.IDESTADOORDENPRODU));
			} else {
				entity.setsecuencial(resultSet.getString(strPrefijo+OrdenProduConstantesFunciones.SECUENCIAL));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowOrdenProdu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(OrdenProdu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=OrdenProduDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=OrdenProduDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=OrdenProduDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=OrdenProduDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(OrdenProduConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,OrdenProduDataAccess.TABLENAME,OrdenProduDataAccess.ISWITHSTOREPROCEDURES);
			
			OrdenProduDataAccess.setOrdenProduOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,OrdenProdu relordenprodu)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relordenprodu.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,OrdenProdu relordenprodu)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relordenprodu.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,OrdenProdu relordenprodu)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relordenprodu.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,OrdenProdu relordenprodu)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relordenprodu.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Formato getFormato(Connexion connexion,OrdenProdu relordenprodu)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relordenprodu.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public TipoPrioridadEmpresaProdu getTipoPrioridadEmpresaProdu(Connexion connexion,OrdenProdu relordenprodu)throws SQLException,Exception {

		TipoPrioridadEmpresaProdu tipoprioridadempresaprodu= new TipoPrioridadEmpresaProdu();

		try {
			TipoPrioridadEmpresaProduDataAccess tipoprioridadempresaproduDataAccess=new TipoPrioridadEmpresaProduDataAccess();

			tipoprioridadempresaproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprioridadempresaproduDataAccess.setConnexionType(this.connexionType);
			tipoprioridadempresaproduDataAccess.setParameterDbType(this.parameterDbType);

			tipoprioridadempresaprodu=tipoprioridadempresaproduDataAccess.getEntity(connexion,relordenprodu.getid_tipo_prioridad_empresa_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprioridadempresaprodu;

	}

	public Empleado getEmpleadoResponsable(Connexion connexion,OrdenProdu relordenprodu)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relordenprodu.getid_empleado_responsable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Cliente getCliente(Connexion connexion,OrdenProdu relordenprodu)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relordenprodu.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public EstadoOrdenProdu getEstadoOrdenProdu(Connexion connexion,OrdenProdu relordenprodu)throws SQLException,Exception {

		EstadoOrdenProdu estadoordenprodu= new EstadoOrdenProdu();

		try {
			EstadoOrdenProduDataAccess estadoordenproduDataAccess=new EstadoOrdenProduDataAccess();

			estadoordenproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoordenproduDataAccess.setConnexionType(this.connexionType);
			estadoordenproduDataAccess.setParameterDbType(this.parameterDbType);

			estadoordenprodu=estadoordenproduDataAccess.getEntity(connexion,relordenprodu.getid_estado_orden_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoordenprodu;

	}


		
		public List<OrdenDetaProdu> getOrdenDetaProdus(Connexion connexion,OrdenProdu ordenprodu)throws SQLException,Exception {

		List<OrdenDetaProdu> ordendetaprodus= new ArrayList<OrdenDetaProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OrdenProduConstantesFunciones.SCHEMA+".orden_produ ON "+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ.id_orden_produ="+OrdenProduConstantesFunciones.SCHEMA+".orden_produ.id WHERE "+OrdenProduConstantesFunciones.SCHEMA+".orden_produ.id="+String.valueOf(ordenprodu.getId());
			} else {
				sQuery=" INNER JOIN ordendetaprodu.OrdenProdu WHERE ordendetaprodu.OrdenProdu.id="+String.valueOf(ordenprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OrdenDetaProduDataAccess ordendetaproduDataAccess=new OrdenDetaProduDataAccess();

			ordendetaproduDataAccess.setConnexionType(this.connexionType);
			ordendetaproduDataAccess.setParameterDbType(this.parameterDbType);
			ordendetaprodus=ordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordendetaprodus;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,OrdenProdu ordenprodu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!ordenprodu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(ordenprodu.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(ordenprodu.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(ordenprodu.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(ordenprodu.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(ordenprodu.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_prioridad_empresa_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_prioridad_empresa_produ.setValue(ordenprodu.getid_tipo_prioridad_empresa_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_prioridad_empresa_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado_responsable=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado_responsable.setValue(ordenprodu.getid_empleado_responsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado_responsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(ordenprodu.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(ordenprodu.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion_cliente=new ParameterValue<String>();
					parameterMaintenanceValuedireccion_cliente.setValue(ordenprodu.getdireccion_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono_cliente=new ParameterValue<String>();
					parameterMaintenanceValuetelefono_cliente.setValue(ordenprodu.gettelefono_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc_cliente=new ParameterValue<String>();
					parameterMaintenanceValueruc_cliente.setValue(ordenprodu.getruc_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote=new ParameterValue<String>();
					parameterMaintenanceValuelote.setValue(ordenprodu.getlote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_pedido=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_pedido.setValue(ordenprodu.getfecha_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega.setValue(ordenprodu.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_uso_interno=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_uso_interno.setValue(ordenprodu.getes_uso_interno());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_uso_interno);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(ordenprodu.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(ordenprodu.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_orden_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_orden_produ.setValue(ordenprodu.getid_estado_orden_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_orden_produ);
					parametersTemp.add(parameterMaintenance);
					
						if(!ordenprodu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(ordenprodu.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(ordenprodu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(ordenprodu.getId());
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
	
	public void setIsNewIsChangedFalseOrdenProdu(OrdenProdu ordenprodu)throws Exception  {		
		ordenprodu.setIsNew(false);
		ordenprodu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseOrdenProdus(List<OrdenProdu> ordenprodus)throws Exception  {				
		for(OrdenProdu ordenprodu:ordenprodus) {
			ordenprodu.setIsNew(false);
			ordenprodu.setIsChanged(false);
		}
	}
	
	public void generarExportarOrdenProdu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
