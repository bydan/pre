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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//AnalisisTransaClienteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class AnalisisTransaClienteDataAccess extends  AnalisisTransaClienteDataAccessAdditional{ //AnalisisTransaClienteDataAccessAdditional,DataAccessHelper<AnalisisTransaCliente>
	//static Logger logger = Logger.getLogger(AnalisisTransaClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="analisis_transa_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_modulo,nombre,descripcion,id_transaccion,id_transaccion1,id_transaccion2,id_transaccion3,id_transaccion4,id_transaccion5,id_transaccion6,id_transaccion7,id_transaccion8,id_transaccion9,id_transaccion10)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,nombre=?,descripcion=?,id_transaccion=?,id_transaccion1=?,id_transaccion2=?,id_transaccion3=?,id_transaccion4=?,id_transaccion5=?,id_transaccion6=?,id_transaccion7=?,id_transaccion8=?,id_transaccion9=?,id_transaccion10=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select analisistransacliente from "+AnalisisTransaClienteConstantesFunciones.SPERSISTENCENAME+" analisistransacliente";
	public static String QUERYSELECTNATIVE="select "+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".version_row,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_empresa,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_modulo,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".nombre,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".descripcion,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion1,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion2,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion3,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion4,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion5,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion6,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion7,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion8,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion9,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion10 from "+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME;//+" as "+AnalisisTransaClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".version_row,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".nombre from "+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME;//+" as "+AnalisisTransaClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,nombre=?,descripcion=?,id_transaccion=?,id_transaccion1=?,id_transaccion2=?,id_transaccion3=?,id_transaccion4=?,id_transaccion5=?,id_transaccion6=?,id_transaccion7=?,id_transaccion8=?,id_transaccion9=?,id_transaccion10=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ANALISISTRANSACLIENTE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ANALISISTRANSACLIENTE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ANALISISTRANSACLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ANALISISTRANSACLIENTE_SELECT(?,?)";
	
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
	
	
	protected AnalisisTransaClienteDataAccessAdditional analisistransaclienteDataAccessAdditional=null;
	
	public AnalisisTransaClienteDataAccessAdditional getAnalisisTransaClienteDataAccessAdditional() {
		return this.analisistransaclienteDataAccessAdditional;
	}
	
	public void setAnalisisTransaClienteDataAccessAdditional(AnalisisTransaClienteDataAccessAdditional analisistransaclienteDataAccessAdditional) {
		try {
			this.analisistransaclienteDataAccessAdditional=analisistransaclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AnalisisTransaClienteDataAccess() {
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
		AnalisisTransaClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AnalisisTransaClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AnalisisTransaClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAnalisisTransaClienteOriginal(AnalisisTransaCliente analisistransacliente)throws Exception  {
		analisistransacliente.setAnalisisTransaClienteOriginal((AnalisisTransaCliente)analisistransacliente.clone());		
	}
	
	public void setAnalisisTransaClientesOriginal(List<AnalisisTransaCliente> analisistransaclientes)throws Exception  {
		
		for(AnalisisTransaCliente analisistransacliente:analisistransaclientes){
			analisistransacliente.setAnalisisTransaClienteOriginal((AnalisisTransaCliente)analisistransacliente.clone());
		}
	}
	
	public static void setAnalisisTransaClienteOriginalStatic(AnalisisTransaCliente analisistransacliente)throws Exception  {
		analisistransacliente.setAnalisisTransaClienteOriginal((AnalisisTransaCliente)analisistransacliente.clone());		
	}
	
	public static void setAnalisisTransaClientesOriginalStatic(List<AnalisisTransaCliente> analisistransaclientes)throws Exception  {
		
		for(AnalisisTransaCliente analisistransacliente:analisistransaclientes){
			analisistransacliente.setAnalisisTransaClienteOriginal((AnalisisTransaCliente)analisistransacliente.clone());
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
	
	public  AnalisisTransaCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		
		
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
	
	public  AnalisisTransaCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AnalisisTransaClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AnalisisTransaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.AnalisisTransaCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAnalisisTransaClienteOriginal(new AnalisisTransaCliente());
      	    	entity=super.getEntity("",entity,resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAnalisisTransaCliente("",entity,resultSet); 
				
				//entity.setAnalisisTransaClienteOriginal(super.getEntity("",entity.getAnalisisTransaClienteOriginal(),resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAnalisisTransaClienteOriginal(this.getEntityAnalisisTransaCliente("",entity.getAnalisisTransaClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAnalisisTransaCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  AnalisisTransaCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AnalisisTransaCliente entity = new AnalisisTransaCliente();
				
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
	
	public  AnalisisTransaCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AnalisisTransaCliente entity = new AnalisisTransaCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AnalisisTransaClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AnalisisTransaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AnalisisTransaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.AnalisisTransaCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAnalisisTransaClienteOriginal(new AnalisisTransaCliente());
      	    	entity=super.getEntity("",entity,resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAnalisisTransaCliente("",entity,resultSet);    
				
				//entity.setAnalisisTransaClienteOriginal(super.getEntity("",entity.getAnalisisTransaClienteOriginal(),resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAnalisisTransaClienteOriginal(this.getEntityAnalisisTransaCliente("",entity.getAnalisisTransaClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAnalisisTransaCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //AnalisisTransaCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		AnalisisTransaCliente entity = new AnalisisTransaCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AnalisisTransaClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AnalisisTransaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AnalisisTransaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.AnalisisTransaCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAnalisisTransaCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<AnalisisTransaCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AnalisisTransaCliente> entities = new  ArrayList<AnalisisTransaCliente>();
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		  
		
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
	
	public  List<AnalisisTransaCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AnalisisTransaCliente> entities = new  ArrayList<AnalisisTransaCliente>();
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AnalisisTransaClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AnalisisTransaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AnalisisTransaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AnalisisTransaCliente();
      	    	entity=super.getEntity("",entity,resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAnalisisTransaCliente("",entity,resultSet);
      	    	
				//entity.setAnalisisTransaClienteOriginal( new AnalisisTransaCliente());
      	    	//entity.setAnalisisTransaClienteOriginal(super.getEntity("",entity.getAnalisisTransaClienteOriginal(),resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAnalisisTransaClienteOriginal(this.getEntityAnalisisTransaCliente("",entity.getAnalisisTransaClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAnalisisTransaClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAnalisisTransaCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AnalisisTransaCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AnalisisTransaCliente> entities = new  ArrayList<AnalisisTransaCliente>();
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		  
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
	
	public  List<AnalisisTransaCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AnalisisTransaCliente> entities = new  ArrayList<AnalisisTransaCliente>();
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AnalisisTransaCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapAnalisisTransaCliente();
					//entity.setMapAnalisisTransaCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAnalisisTransaClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAnalisisTransaCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA);         		
					entity=AnalisisTransaClienteDataAccess.getEntityAnalisisTransaCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAnalisisTransaClienteOriginal( new AnalisisTransaCliente());
					////entity.setAnalisisTransaClienteOriginal(super.getEntity("",entity.getAnalisisTransaClienteOriginal(),resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setAnalisisTransaClienteOriginal(this.getEntityAnalisisTransaCliente("",entity.getAnalisisTransaClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAnalisisTransaClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAnalisisTransaCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public AnalisisTransaCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		  
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
	
	public  AnalisisTransaCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AnalisisTransaCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapAnalisisTransaCliente();
					//entity.setMapAnalisisTransaCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAnalisisTransaClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAnalisisTransaCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA);         		
					entity=AnalisisTransaClienteDataAccess.getEntityAnalisisTransaCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAnalisisTransaClienteOriginal( new AnalisisTransaCliente());
					////entity.setAnalisisTransaClienteOriginal(super.getEntity("",entity.getAnalisisTransaClienteOriginal(),resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setAnalisisTransaClienteOriginal(this.getEntityAnalisisTransaCliente("",entity.getAnalisisTransaClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAnalisisTransaCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAnalisisTransaCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AnalisisTransaCliente getEntityAnalisisTransaCliente(String strPrefijo,AnalisisTransaCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = AnalisisTransaCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = AnalisisTransaCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AnalisisTransaClienteDataAccess.setFieldReflectionAnalisisTransaCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAnalisisTransaCliente=AnalisisTransaClienteConstantesFunciones.getTodosTiposColumnasAnalisisTransaCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAnalisisTransaCliente) {
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
							field = AnalisisTransaCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = AnalisisTransaCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AnalisisTransaClienteDataAccess.setFieldReflectionAnalisisTransaCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAnalisisTransaCliente(Field field,String strPrefijo,String sColumn,AnalisisTransaCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AnalisisTransaClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.IDTRANSACCION1:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.IDTRANSACCION2:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.IDTRANSACCION3:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.IDTRANSACCION4:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.IDTRANSACCION5:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.IDTRANSACCION6:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.IDTRANSACCION7:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.IDTRANSACCION8:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.IDTRANSACCION9:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnalisisTransaClienteConstantesFunciones.IDTRANSACCION10:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AnalisisTransaCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<AnalisisTransaCliente> entities = new  ArrayList<AnalisisTransaCliente>();
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AnalisisTransaClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AnalisisTransaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AnalisisTransaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new AnalisisTransaCliente();
					entity=super.getEntity("",entity,resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAnalisisTransaCliente("",entity,resultSet);
					
					//entity.setAnalisisTransaClienteOriginal( new AnalisisTransaCliente());
					//entity.setAnalisisTransaClienteOriginal(super.getEntity("",entity.getAnalisisTransaClienteOriginal(),resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setAnalisisTransaClienteOriginal(this.getEntityAnalisisTransaCliente("",entity.getAnalisisTransaClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAnalisisTransaClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAnalisisTransaCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AnalisisTransaCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<AnalisisTransaCliente> entities = new  ArrayList<AnalisisTransaCliente>();
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AnalisisTransaClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AnalisisTransaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AnalisisTransaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<AnalisisTransaCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AnalisisTransaCliente> entities = new  ArrayList<AnalisisTransaCliente>();
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		  
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
	
	public  List<AnalisisTransaCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AnalisisTransaCliente> entities = new  ArrayList<AnalisisTransaCliente>();
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AnalisisTransaCliente();
      	    	entity=super.getEntity("",entity,resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAnalisisTransaCliente("",entity,resultSet);
      	    	
				//entity.setAnalisisTransaClienteOriginal( new AnalisisTransaCliente());
      	    	//entity.setAnalisisTransaClienteOriginal(super.getEntity("",entity.getAnalisisTransaClienteOriginal(),resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAnalisisTransaClienteOriginal(this.getEntityAnalisisTransaCliente("",entity.getAnalisisTransaClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAnalisisTransaClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAnalisisTransaCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AnalisisTransaCliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AnalisisTransaCliente> entities = new  ArrayList<AnalisisTransaCliente>();
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		  
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
	
	public  List<AnalisisTransaCliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AnalisisTransaCliente> entities = new  ArrayList<AnalisisTransaCliente>();
		AnalisisTransaCliente entity = new AnalisisTransaCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AnalisisTransaCliente();
      	    	entity=super.getEntity("",entity,resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAnalisisTransaCliente("",entity,resultSet);
      	    	
				//entity.setAnalisisTransaClienteOriginal( new AnalisisTransaCliente());
      	    	//entity.setAnalisisTransaClienteOriginal(super.getEntity("",entity.getAnalisisTransaClienteOriginal(),resultSet,AnalisisTransaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAnalisisTransaClienteOriginal(this.getEntityAnalisisTransaCliente("",entity.getAnalisisTransaClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAnalisisTransaClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public AnalisisTransaCliente getEntityAnalisisTransaCliente(String strPrefijo,AnalisisTransaCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+AnalisisTransaClienteConstantesFunciones.IDEMPRESA));
				entity.setid_modulo(resultSet.getLong(strPrefijo+AnalisisTransaClienteConstantesFunciones.IDMODULO));
				entity.setnombre(resultSet.getString(strPrefijo+AnalisisTransaClienteConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+AnalisisTransaClienteConstantesFunciones.DESCRIPCION));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+AnalisisTransaClienteConstantesFunciones.IDTRANSACCION));
				entity.setid_transaccion1(resultSet.getLong(strPrefijo+AnalisisTransaClienteConstantesFunciones.IDTRANSACCION1));if(resultSet.wasNull()) {entity.setid_transaccion1(null); }
				entity.setid_transaccion2(resultSet.getLong(strPrefijo+AnalisisTransaClienteConstantesFunciones.IDTRANSACCION2));if(resultSet.wasNull()) {entity.setid_transaccion2(null); }
				entity.setid_transaccion3(resultSet.getLong(strPrefijo+AnalisisTransaClienteConstantesFunciones.IDTRANSACCION3));if(resultSet.wasNull()) {entity.setid_transaccion3(null); }
				entity.setid_transaccion4(resultSet.getLong(strPrefijo+AnalisisTransaClienteConstantesFunciones.IDTRANSACCION4));if(resultSet.wasNull()) {entity.setid_transaccion4(null); }
				entity.setid_transaccion5(resultSet.getLong(strPrefijo+AnalisisTransaClienteConstantesFunciones.IDTRANSACCION5));if(resultSet.wasNull()) {entity.setid_transaccion5(null); }
				entity.setid_transaccion6(resultSet.getLong(strPrefijo+AnalisisTransaClienteConstantesFunciones.IDTRANSACCION6));if(resultSet.wasNull()) {entity.setid_transaccion6(null); }
				entity.setid_transaccion7(resultSet.getLong(strPrefijo+AnalisisTransaClienteConstantesFunciones.IDTRANSACCION7));if(resultSet.wasNull()) {entity.setid_transaccion7(null); }
				entity.setid_transaccion8(resultSet.getLong(strPrefijo+AnalisisTransaClienteConstantesFunciones.IDTRANSACCION8));if(resultSet.wasNull()) {entity.setid_transaccion8(null); }
				entity.setid_transaccion9(resultSet.getLong(strPrefijo+AnalisisTransaClienteConstantesFunciones.IDTRANSACCION9));if(resultSet.wasNull()) {entity.setid_transaccion9(null); }
				entity.setid_transaccion10(resultSet.getLong(strPrefijo+AnalisisTransaClienteConstantesFunciones.IDTRANSACCION10));if(resultSet.wasNull()) {entity.setid_transaccion10(null); }
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+AnalisisTransaClienteConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAnalisisTransaCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(AnalisisTransaCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AnalisisTransaClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AnalisisTransaClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AnalisisTransaClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AnalisisTransaClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AnalisisTransaClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AnalisisTransaClienteDataAccess.TABLENAME,AnalisisTransaClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			AnalisisTransaClienteDataAccess.setAnalisisTransaClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,AnalisisTransaCliente relanalisistransacliente)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relanalisistransacliente.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Modulo getModulo(Connexion connexion,AnalisisTransaCliente relanalisistransacliente)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relanalisistransacliente.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Transaccion getTransaccion(Connexion connexion,AnalisisTransaCliente relanalisistransacliente)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relanalisistransacliente.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccion1(Connexion connexion,AnalisisTransaCliente relanalisistransacliente)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relanalisistransacliente.getid_transaccion1());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccion2(Connexion connexion,AnalisisTransaCliente relanalisistransacliente)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relanalisistransacliente.getid_transaccion2());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccion3(Connexion connexion,AnalisisTransaCliente relanalisistransacliente)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relanalisistransacliente.getid_transaccion3());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccion4(Connexion connexion,AnalisisTransaCliente relanalisistransacliente)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relanalisistransacliente.getid_transaccion4());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccion5(Connexion connexion,AnalisisTransaCliente relanalisistransacliente)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relanalisistransacliente.getid_transaccion5());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccion6(Connexion connexion,AnalisisTransaCliente relanalisistransacliente)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relanalisistransacliente.getid_transaccion6());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccion7(Connexion connexion,AnalisisTransaCliente relanalisistransacliente)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relanalisistransacliente.getid_transaccion7());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccion8(Connexion connexion,AnalisisTransaCliente relanalisistransacliente)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relanalisistransacliente.getid_transaccion8());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccion9(Connexion connexion,AnalisisTransaCliente relanalisistransacliente)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relanalisistransacliente.getid_transaccion9());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccion10(Connexion connexion,AnalisisTransaCliente relanalisistransacliente)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relanalisistransacliente.getid_transaccion10());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,AnalisisTransaCliente analisistransacliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!analisistransacliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(analisistransacliente.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(analisistransacliente.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(analisistransacliente.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(analisistransacliente.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(analisistransacliente.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion1=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion1.setValue(analisistransacliente.getid_transaccion1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion2=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion2.setValue(analisistransacliente.getid_transaccion2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion3=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion3.setValue(analisistransacliente.getid_transaccion3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion4=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion4.setValue(analisistransacliente.getid_transaccion4());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion4);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion5=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion5.setValue(analisistransacliente.getid_transaccion5());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion5);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion6=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion6.setValue(analisistransacliente.getid_transaccion6());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion6);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion7=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion7.setValue(analisistransacliente.getid_transaccion7());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion7);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion8=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion8.setValue(analisistransacliente.getid_transaccion8());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion8);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion9=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion9.setValue(analisistransacliente.getid_transaccion9());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion9);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion10=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion10.setValue(analisistransacliente.getid_transaccion10());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion10);
					parametersTemp.add(parameterMaintenance);
					
						if(!analisistransacliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(analisistransacliente.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(analisistransacliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(analisistransacliente.getId());
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
	
	public void setIsNewIsChangedFalseAnalisisTransaCliente(AnalisisTransaCliente analisistransacliente)throws Exception  {		
		analisistransacliente.setIsNew(false);
		analisistransacliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAnalisisTransaClientes(List<AnalisisTransaCliente> analisistransaclientes)throws Exception  {				
		for(AnalisisTransaCliente analisistransacliente:analisistransaclientes) {
			analisistransacliente.setIsNew(false);
			analisistransacliente.setIsChanged(false);
		}
	}
	
	public void generarExportarAnalisisTransaCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
