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
import com.bydan.erp.cartera.util.*;//ReferenciaBancariaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class ReferenciaBancariaDataAccess extends  ReferenciaBancariaDataAccessAdditional{ //ReferenciaBancariaDataAccessAdditional,DataAccessHelper<ReferenciaBancaria>
	//static Logger logger = Logger.getLogger(ReferenciaBancariaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="referenciabancaria";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+"(version_row,id_empresa,idcliente,idvalorclientebanco,idvalorclienteproductobanco,idvalorclientecuentabanco,numero_cuenta_tarjeta,fecha_emision,fecha_vencimiento,cupo,tiene_credito,numero_creditos,tiene_protestos,numero_protestos,saldos_promedios,propietario_cuenta,id_tipo_valoracion,esactivo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,idcliente=?,idvalorclientebanco=?,idvalorclienteproductobanco=?,idvalorclientecuentabanco=?,numero_cuenta_tarjeta=?,fecha_emision=?,fecha_vencimiento=?,cupo=?,tiene_credito=?,numero_creditos=?,tiene_protestos=?,numero_protestos=?,saldos_promedios=?,propietario_cuenta=?,id_tipo_valoracion=?,esactivo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select referenciabancaria from "+ReferenciaBancariaConstantesFunciones.SPERSISTENCENAME+" referenciabancaria";
	public static String QUERYSELECTNATIVE="select "+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".id,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".version_row,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".id_empresa,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".idcliente,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".idvalorclientebanco,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".idvalorclienteproductobanco,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".idvalorclientecuentabanco,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".numero_cuenta_tarjeta,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".fecha_emision,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".fecha_vencimiento,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".cupo,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".tiene_credito,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".numero_creditos,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".tiene_protestos,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".numero_protestos,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".saldos_promedios,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".propietario_cuenta,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".id_tipo_valoracion,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".esactivo from "+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME;//+" as "+ReferenciaBancariaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".id,"+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+".version_row from "+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME;//+" as "+ReferenciaBancariaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ReferenciaBancariaConstantesFunciones.SCHEMA+"."+ReferenciaBancariaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,idcliente=?,idvalorclientebanco=?,idvalorclienteproductobanco=?,idvalorclientecuentabanco=?,numero_cuenta_tarjeta=?,fecha_emision=?,fecha_vencimiento=?,cupo=?,tiene_credito=?,numero_creditos=?,tiene_protestos=?,numero_protestos=?,saldos_promedios=?,propietario_cuenta=?,id_tipo_valoracion=?,esactivo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_REFERENCIABANCARIA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_REFERENCIABANCARIA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_REFERENCIABANCARIA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_REFERENCIABANCARIA_SELECT(?,?)";
	
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
	
	
	protected ReferenciaBancariaDataAccessAdditional referenciabancariaDataAccessAdditional=null;
	
	public ReferenciaBancariaDataAccessAdditional getReferenciaBancariaDataAccessAdditional() {
		return this.referenciabancariaDataAccessAdditional;
	}
	
	public void setReferenciaBancariaDataAccessAdditional(ReferenciaBancariaDataAccessAdditional referenciabancariaDataAccessAdditional) {
		try {
			this.referenciabancariaDataAccessAdditional=referenciabancariaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ReferenciaBancariaDataAccess() {
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
		ReferenciaBancariaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ReferenciaBancariaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ReferenciaBancariaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setReferenciaBancariaOriginal(ReferenciaBancaria referenciabancaria)throws Exception  {
		referenciabancaria.setReferenciaBancariaOriginal((ReferenciaBancaria)referenciabancaria.clone());		
	}
	
	public void setReferenciaBancariasOriginal(List<ReferenciaBancaria> referenciabancarias)throws Exception  {
		
		for(ReferenciaBancaria referenciabancaria:referenciabancarias){
			referenciabancaria.setReferenciaBancariaOriginal((ReferenciaBancaria)referenciabancaria.clone());
		}
	}
	
	public static void setReferenciaBancariaOriginalStatic(ReferenciaBancaria referenciabancaria)throws Exception  {
		referenciabancaria.setReferenciaBancariaOriginal((ReferenciaBancaria)referenciabancaria.clone());		
	}
	
	public static void setReferenciaBancariasOriginalStatic(List<ReferenciaBancaria> referenciabancarias)throws Exception  {
		
		for(ReferenciaBancaria referenciabancaria:referenciabancarias){
			referenciabancaria.setReferenciaBancariaOriginal((ReferenciaBancaria)referenciabancaria.clone());
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
	
	public  ReferenciaBancaria getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ReferenciaBancaria entity = new ReferenciaBancaria();		
		
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
	
	public  ReferenciaBancaria getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ReferenciaBancaria entity = new ReferenciaBancaria();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ReferenciaBancariaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ReferenciaBancariaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.ReferenciaBancaria.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setReferenciaBancariaOriginal(new ReferenciaBancaria());
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityReferenciaBancaria("",entity,resultSet); 
				
				//entity.setReferenciaBancariaOriginal(super.getEntity("",entity.getReferenciaBancariaOriginal(),resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaBancariaOriginal(this.getEntityReferenciaBancaria("",entity.getReferenciaBancariaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseReferenciaBancaria(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ReferenciaBancaria getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ReferenciaBancaria entity = new ReferenciaBancaria();
				
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
	
	public  ReferenciaBancaria getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ReferenciaBancaria entity = new ReferenciaBancaria();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ReferenciaBancariaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ReferenciaBancariaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaBancariaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ReferenciaBancaria.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setReferenciaBancariaOriginal(new ReferenciaBancaria());
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityReferenciaBancaria("",entity,resultSet);    
				
				//entity.setReferenciaBancariaOriginal(super.getEntity("",entity.getReferenciaBancariaOriginal(),resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaBancariaOriginal(this.getEntityReferenciaBancaria("",entity.getReferenciaBancariaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseReferenciaBancaria(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ReferenciaBancaria
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ReferenciaBancaria entity = new ReferenciaBancaria();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ReferenciaBancariaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ReferenciaBancariaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaBancariaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ReferenciaBancaria.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseReferenciaBancaria(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ReferenciaBancaria> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ReferenciaBancaria> entities = new  ArrayList<ReferenciaBancaria>();
		ReferenciaBancaria entity = new ReferenciaBancaria();		  
		
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
	
	public  List<ReferenciaBancaria> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ReferenciaBancaria> entities = new  ArrayList<ReferenciaBancaria>();
		ReferenciaBancaria entity = new ReferenciaBancaria();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ReferenciaBancariaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ReferenciaBancariaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaBancariaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaBancaria();
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityReferenciaBancaria("",entity,resultSet);
      	    	
				//entity.setReferenciaBancariaOriginal( new ReferenciaBancaria());
      	    	//entity.setReferenciaBancariaOriginal(super.getEntity("",entity.getReferenciaBancariaOriginal(),resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaBancariaOriginal(this.getEntityReferenciaBancaria("",entity.getReferenciaBancariaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseReferenciaBancarias(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaBancaria(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ReferenciaBancaria> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ReferenciaBancaria> entities = new  ArrayList<ReferenciaBancaria>();
		ReferenciaBancaria entity = new ReferenciaBancaria();		  
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
	
	public  List<ReferenciaBancaria> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ReferenciaBancaria> entities = new  ArrayList<ReferenciaBancaria>();
		ReferenciaBancaria entity = new ReferenciaBancaria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaBancaria();
				
				if(conMapGenerico) {
					entity.inicializarMapReferenciaBancaria();
					//entity.setMapReferenciaBancaria(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapReferenciaBancariaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapReferenciaBancaria().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA);         		
					entity=ReferenciaBancariaDataAccess.getEntityReferenciaBancaria("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setReferenciaBancariaOriginal( new ReferenciaBancaria());
					////entity.setReferenciaBancariaOriginal(super.getEntity("",entity.getReferenciaBancariaOriginal(),resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA));         		
					////entity.setReferenciaBancariaOriginal(this.getEntityReferenciaBancaria("",entity.getReferenciaBancariaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseReferenciaBancarias(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaBancaria(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ReferenciaBancaria getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ReferenciaBancaria entity = new ReferenciaBancaria();		  
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
	
	public  ReferenciaBancaria getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ReferenciaBancaria entity = new ReferenciaBancaria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaBancaria();
				
				if(conMapGenerico) {
					entity.inicializarMapReferenciaBancaria();
					//entity.setMapReferenciaBancaria(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapReferenciaBancariaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapReferenciaBancaria().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA);         		
					entity=ReferenciaBancariaDataAccess.getEntityReferenciaBancaria("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setReferenciaBancariaOriginal( new ReferenciaBancaria());
					////entity.setReferenciaBancariaOriginal(super.getEntity("",entity.getReferenciaBancariaOriginal(),resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA));         		
					////entity.setReferenciaBancariaOriginal(this.getEntityReferenciaBancaria("",entity.getReferenciaBancariaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseReferenciaBancaria(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaBancaria(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ReferenciaBancaria getEntityReferenciaBancaria(String strPrefijo,ReferenciaBancaria entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ReferenciaBancaria.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ReferenciaBancaria.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ReferenciaBancariaDataAccess.setFieldReflectionReferenciaBancaria(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasReferenciaBancaria=ReferenciaBancariaConstantesFunciones.getTodosTiposColumnasReferenciaBancaria();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasReferenciaBancaria) {
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
							field = ReferenciaBancaria.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ReferenciaBancaria.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ReferenciaBancariaDataAccess.setFieldReflectionReferenciaBancaria(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionReferenciaBancaria(Field field,String strPrefijo,String sColumn,ReferenciaBancaria entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ReferenciaBancariaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.IDTIPOPRODUBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.IDTIPOCUENTABANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.NUMEROCUENTATARJETA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ReferenciaBancariaConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ReferenciaBancariaConstantesFunciones.CUPO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.TIENECREDITO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.NUMEROCREDITOS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.TIENEPROTESTOS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.NUMEROPROTESTOS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.SALDOSPROMEDIOS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.PROPIETARIOCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.IDTIPOVALORACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaBancariaConstantesFunciones.ESACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ReferenciaBancaria>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ReferenciaBancaria> entities = new  ArrayList<ReferenciaBancaria>();
		ReferenciaBancaria entity = new ReferenciaBancaria();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ReferenciaBancariaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ReferenciaBancariaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaBancariaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ReferenciaBancaria();
					entity=super.getEntity("",entity,resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityReferenciaBancaria("",entity,resultSet);
					
					//entity.setReferenciaBancariaOriginal( new ReferenciaBancaria());
					//entity.setReferenciaBancariaOriginal(super.getEntity("",entity.getReferenciaBancariaOriginal(),resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA));         		
					//entity.setReferenciaBancariaOriginal(this.getEntityReferenciaBancaria("",entity.getReferenciaBancariaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseReferenciaBancarias(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaBancaria(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ReferenciaBancaria>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ReferenciaBancaria> entities = new  ArrayList<ReferenciaBancaria>();
		ReferenciaBancaria entity = new ReferenciaBancaria();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ReferenciaBancariaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ReferenciaBancariaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaBancariaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ReferenciaBancaria> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReferenciaBancaria> entities = new  ArrayList<ReferenciaBancaria>();
		ReferenciaBancaria entity = new ReferenciaBancaria();		  
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
	
	public  List<ReferenciaBancaria> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReferenciaBancaria> entities = new  ArrayList<ReferenciaBancaria>();
		ReferenciaBancaria entity = new ReferenciaBancaria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaBancaria();
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityReferenciaBancaria("",entity,resultSet);
      	    	
				//entity.setReferenciaBancariaOriginal( new ReferenciaBancaria());
      	    	//entity.setReferenciaBancariaOriginal(super.getEntity("",entity.getReferenciaBancariaOriginal(),resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaBancariaOriginal(this.getEntityReferenciaBancaria("",entity.getReferenciaBancariaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseReferenciaBancarias(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaBancaria(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ReferenciaBancaria> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReferenciaBancaria> entities = new  ArrayList<ReferenciaBancaria>();
		ReferenciaBancaria entity = new ReferenciaBancaria();		  
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
	
	public  List<ReferenciaBancaria> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReferenciaBancaria> entities = new  ArrayList<ReferenciaBancaria>();
		ReferenciaBancaria entity = new ReferenciaBancaria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaBancaria();
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityReferenciaBancaria("",entity,resultSet);
      	    	
				//entity.setReferenciaBancariaOriginal( new ReferenciaBancaria());
      	    	//entity.setReferenciaBancariaOriginal(super.getEntity("",entity.getReferenciaBancariaOriginal(),resultSet,ReferenciaBancariaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaBancariaOriginal(this.getEntityReferenciaBancaria("",entity.getReferenciaBancariaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseReferenciaBancarias(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ReferenciaBancaria getEntityReferenciaBancaria(String strPrefijo,ReferenciaBancaria entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ReferenciaBancariaConstantesFunciones.IDEMPRESA));
				entity.setidcliente(resultSet.getLong(strPrefijo+ReferenciaBancariaConstantesFunciones.IDCLIENTE));
				entity.setidvalorclientebanco(resultSet.getLong(strPrefijo+ReferenciaBancariaConstantesFunciones.IDBANCO));
				entity.setidvalorclienteproductobanco(resultSet.getLong(strPrefijo+ReferenciaBancariaConstantesFunciones.IDTIPOPRODUBANCO));
				entity.setidvalorclientecuentabanco(resultSet.getLong(strPrefijo+ReferenciaBancariaConstantesFunciones.IDTIPOCUENTABANCO));
				entity.setnumero_cuenta_tarjeta(resultSet.getString(strPrefijo+ReferenciaBancariaConstantesFunciones.NUMEROCUENTATARJETA));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+ReferenciaBancariaConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+ReferenciaBancariaConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setcupo(resultSet.getDouble(strPrefijo+ReferenciaBancariaConstantesFunciones.CUPO));
				entity.settiene_credito(resultSet.getBoolean(strPrefijo+ReferenciaBancariaConstantesFunciones.TIENECREDITO));
				entity.setnumero_creditos(resultSet.getInt(strPrefijo+ReferenciaBancariaConstantesFunciones.NUMEROCREDITOS));
				entity.settiene_protestos(resultSet.getBoolean(strPrefijo+ReferenciaBancariaConstantesFunciones.TIENEPROTESTOS));
				entity.setnumero_protestos(resultSet.getInt(strPrefijo+ReferenciaBancariaConstantesFunciones.NUMEROPROTESTOS));
				entity.setsaldos_promedios(resultSet.getString(strPrefijo+ReferenciaBancariaConstantesFunciones.SALDOSPROMEDIOS));
				entity.setpropietario_cuenta(resultSet.getString(strPrefijo+ReferenciaBancariaConstantesFunciones.PROPIETARIOCUENTA));
				entity.setid_tipo_valoracion(resultSet.getLong(strPrefijo+ReferenciaBancariaConstantesFunciones.IDTIPOVALORACION));
				entity.setesactivo(resultSet.getBoolean(strPrefijo+ReferenciaBancariaConstantesFunciones.ESACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowReferenciaBancaria(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ReferenciaBancaria entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ReferenciaBancariaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ReferenciaBancariaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ReferenciaBancariaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ReferenciaBancariaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ReferenciaBancariaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ReferenciaBancariaDataAccess.TABLENAME,ReferenciaBancariaDataAccess.ISWITHSTOREPROCEDURES);
			
			ReferenciaBancariaDataAccess.setReferenciaBancariaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ReferenciaBancaria relreferenciabancaria)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relreferenciabancaria.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,ReferenciaBancaria relreferenciabancaria)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relreferenciabancaria.getidcliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Banco getBanco(Connexion connexion,ReferenciaBancaria relreferenciabancaria)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,relreferenciabancaria.getidvalorclientebanco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}

	public TipoProduBanco getTipoProduBanco(Connexion connexion,ReferenciaBancaria relreferenciabancaria)throws SQLException,Exception {

		TipoProduBanco tipoprodubanco= new TipoProduBanco();

		try {
			TipoProduBancoDataAccess tipoprodubancoDataAccess=new TipoProduBancoDataAccess();

			tipoprodubancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprodubancoDataAccess.setConnexionType(this.connexionType);
			tipoprodubancoDataAccess.setParameterDbType(this.parameterDbType);

			tipoprodubanco=tipoprodubancoDataAccess.getEntity(connexion,relreferenciabancaria.getidvalorclienteproductobanco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprodubanco;

	}

	public TipoCuentaBanco getTipoCuentaBanco(Connexion connexion,ReferenciaBancaria relreferenciabancaria)throws SQLException,Exception {

		TipoCuentaBanco tipocuentabanco= new TipoCuentaBanco();

		try {
			TipoCuentaBancoDataAccess tipocuentabancoDataAccess=new TipoCuentaBancoDataAccess();

			tipocuentabancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocuentabancoDataAccess.setConnexionType(this.connexionType);
			tipocuentabancoDataAccess.setParameterDbType(this.parameterDbType);

			tipocuentabanco=tipocuentabancoDataAccess.getEntity(connexion,relreferenciabancaria.getidvalorclientecuentabanco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocuentabanco;

	}

	public TipoValoracion getTipoValoracion(Connexion connexion,ReferenciaBancaria relreferenciabancaria)throws SQLException,Exception {

		TipoValoracion tipovaloracion= new TipoValoracion();

		try {
			TipoValoracionDataAccess tipovaloracionDataAccess=new TipoValoracionDataAccess();

			tipovaloracionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipovaloracionDataAccess.setConnexionType(this.connexionType);
			tipovaloracionDataAccess.setParameterDbType(this.parameterDbType);

			tipovaloracion=tipovaloracionDataAccess.getEntity(connexion,relreferenciabancaria.getid_tipo_valoracion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipovaloracion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ReferenciaBancaria referenciabancaria) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!referenciabancaria.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(referenciabancaria.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidcliente=new ParameterValue<Long>();
					parameterMaintenanceValueidcliente.setValue(referenciabancaria.getidcliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidcliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorclientebanco=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorclientebanco.setValue(referenciabancaria.getidvalorclientebanco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorclientebanco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorclienteproductobanco=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorclienteproductobanco.setValue(referenciabancaria.getidvalorclienteproductobanco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorclienteproductobanco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorclientecuentabanco=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorclientecuentabanco.setValue(referenciabancaria.getidvalorclientecuentabanco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorclientecuentabanco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cuenta_tarjeta=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cuenta_tarjeta.setValue(referenciabancaria.getnumero_cuenta_tarjeta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cuenta_tarjeta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(referenciabancaria.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(referenciabancaria.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecupo=new ParameterValue<Double>();
					parameterMaintenanceValuecupo.setValue(referenciabancaria.getcupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuetiene_credito=new ParameterValue<Boolean>();
					parameterMaintenanceValuetiene_credito.setValue(referenciabancaria.gettiene_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetiene_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_creditos=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_creditos.setValue(referenciabancaria.getnumero_creditos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_creditos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuetiene_protestos=new ParameterValue<Boolean>();
					parameterMaintenanceValuetiene_protestos.setValue(referenciabancaria.gettiene_protestos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetiene_protestos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_protestos=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_protestos.setValue(referenciabancaria.getnumero_protestos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_protestos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesaldos_promedios=new ParameterValue<String>();
					parameterMaintenanceValuesaldos_promedios.setValue(referenciabancaria.getsaldos_promedios());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesaldos_promedios);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepropietario_cuenta=new ParameterValue<String>();
					parameterMaintenanceValuepropietario_cuenta.setValue(referenciabancaria.getpropietario_cuenta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepropietario_cuenta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_valoracion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_valoracion.setValue(referenciabancaria.getid_tipo_valoracion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_valoracion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesactivo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesactivo.setValue(referenciabancaria.getesactivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesactivo);
					parametersTemp.add(parameterMaintenance);
					
						if(!referenciabancaria.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(referenciabancaria.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(referenciabancaria.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(referenciabancaria.getId());
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
	
	public void setIsNewIsChangedFalseReferenciaBancaria(ReferenciaBancaria referenciabancaria)throws Exception  {		
		referenciabancaria.setIsNew(false);
		referenciabancaria.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseReferenciaBancarias(List<ReferenciaBancaria> referenciabancarias)throws Exception  {				
		for(ReferenciaBancaria referenciabancaria:referenciabancarias) {
			referenciabancaria.setIsNew(false);
			referenciabancaria.setIsChanged(false);
		}
	}
	
	public void generarExportarReferenciaBancaria(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
