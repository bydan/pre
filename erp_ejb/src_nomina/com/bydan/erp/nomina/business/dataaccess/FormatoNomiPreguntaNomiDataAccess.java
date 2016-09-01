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
package com.bydan.erp.nomina.business.dataaccess;

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

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//FormatoNomiPreguntaNomiConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class FormatoNomiPreguntaNomiDataAccess extends  FormatoNomiPreguntaNomiDataAccessAdditional{ //FormatoNomiPreguntaNomiDataAccessAdditional,DataAccessHelper<FormatoNomiPreguntaNomi>
	//static Logger logger = Logger.getLogger(FormatoNomiPreguntaNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="formato_nomi_pregunta_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_formato_nomi,id_factor_nomi,id_pregunta_nomi,ponderacion)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_formato_nomi=?,id_factor_nomi=?,id_pregunta_nomi=?,ponderacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select formatonomipreguntanomi from "+FormatoNomiPreguntaNomiConstantesFunciones.SPERSISTENCENAME+" formatonomipreguntanomi";
	public static String QUERYSELECTNATIVE="select "+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".id,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".version_row,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".id_empresa,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".id_sucursal,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".id_formato_nomi,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".id_factor_nomi,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".id_pregunta_nomi,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".ponderacion from "+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME;//+" as "+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".id,"+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+".version_row from "+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME;//+" as "+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+"."+FormatoNomiPreguntaNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_formato_nomi=?,id_factor_nomi=?,id_pregunta_nomi=?,ponderacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FORMATONOMIPREGUNTANOMI_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FORMATONOMIPREGUNTANOMI_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FORMATONOMIPREGUNTANOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FORMATONOMIPREGUNTANOMI_SELECT(?,?)";
	
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
	
	
	protected FormatoNomiPreguntaNomiDataAccessAdditional formatonomipreguntanomiDataAccessAdditional=null;
	
	public FormatoNomiPreguntaNomiDataAccessAdditional getFormatoNomiPreguntaNomiDataAccessAdditional() {
		return this.formatonomipreguntanomiDataAccessAdditional;
	}
	
	public void setFormatoNomiPreguntaNomiDataAccessAdditional(FormatoNomiPreguntaNomiDataAccessAdditional formatonomipreguntanomiDataAccessAdditional) {
		try {
			this.formatonomipreguntanomiDataAccessAdditional=formatonomipreguntanomiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FormatoNomiPreguntaNomiDataAccess() {
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
		FormatoNomiPreguntaNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FormatoNomiPreguntaNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FormatoNomiPreguntaNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFormatoNomiPreguntaNomiOriginal(FormatoNomiPreguntaNomi formatonomipreguntanomi)throws Exception  {
		formatonomipreguntanomi.setFormatoNomiPreguntaNomiOriginal((FormatoNomiPreguntaNomi)formatonomipreguntanomi.clone());		
	}
	
	public void setFormatoNomiPreguntaNomisOriginal(List<FormatoNomiPreguntaNomi> formatonomipreguntanomis)throws Exception  {
		
		for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomipreguntanomis){
			formatonomipreguntanomi.setFormatoNomiPreguntaNomiOriginal((FormatoNomiPreguntaNomi)formatonomipreguntanomi.clone());
		}
	}
	
	public static void setFormatoNomiPreguntaNomiOriginalStatic(FormatoNomiPreguntaNomi formatonomipreguntanomi)throws Exception  {
		formatonomipreguntanomi.setFormatoNomiPreguntaNomiOriginal((FormatoNomiPreguntaNomi)formatonomipreguntanomi.clone());		
	}
	
	public static void setFormatoNomiPreguntaNomisOriginalStatic(List<FormatoNomiPreguntaNomi> formatonomipreguntanomis)throws Exception  {
		
		for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomipreguntanomis){
			formatonomipreguntanomi.setFormatoNomiPreguntaNomiOriginal((FormatoNomiPreguntaNomi)formatonomipreguntanomi.clone());
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
	
	public  FormatoNomiPreguntaNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		
		
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
	
	public  FormatoNomiPreguntaNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormatoNomiPreguntaNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormatoNomiPreguntaNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.FormatoNomiPreguntaNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFormatoNomiPreguntaNomiOriginal(new FormatoNomiPreguntaNomi());
      	    	entity=super.getEntity("",entity,resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormatoNomiPreguntaNomi("",entity,resultSet); 
				
				//entity.setFormatoNomiPreguntaNomiOriginal(super.getEntity("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoNomiPreguntaNomiOriginal(this.getEntityFormatoNomiPreguntaNomi("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFormatoNomiPreguntaNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  FormatoNomiPreguntaNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();
				
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
	
	public  FormatoNomiPreguntaNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormatoNomiPreguntaNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormatoNomiPreguntaNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoNomiPreguntaNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.FormatoNomiPreguntaNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFormatoNomiPreguntaNomiOriginal(new FormatoNomiPreguntaNomi());
      	    	entity=super.getEntity("",entity,resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormatoNomiPreguntaNomi("",entity,resultSet);    
				
				//entity.setFormatoNomiPreguntaNomiOriginal(super.getEntity("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoNomiPreguntaNomiOriginal(this.getEntityFormatoNomiPreguntaNomi("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFormatoNomiPreguntaNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //FormatoNomiPreguntaNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormatoNomiPreguntaNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormatoNomiPreguntaNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoNomiPreguntaNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.FormatoNomiPreguntaNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFormatoNomiPreguntaNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<FormatoNomiPreguntaNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormatoNomiPreguntaNomi> entities = new  ArrayList<FormatoNomiPreguntaNomi>();
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		  
		
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
	
	public  List<FormatoNomiPreguntaNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormatoNomiPreguntaNomi> entities = new  ArrayList<FormatoNomiPreguntaNomi>();
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FormatoNomiPreguntaNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormatoNomiPreguntaNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoNomiPreguntaNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormatoNomiPreguntaNomi();
      	    	entity=super.getEntity("",entity,resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormatoNomiPreguntaNomi("",entity,resultSet);
      	    	
				//entity.setFormatoNomiPreguntaNomiOriginal( new FormatoNomiPreguntaNomi());
      	    	//entity.setFormatoNomiPreguntaNomiOriginal(super.getEntity("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoNomiPreguntaNomiOriginal(this.getEntityFormatoNomiPreguntaNomi("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormatoNomiPreguntaNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormatoNomiPreguntaNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormatoNomiPreguntaNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormatoNomiPreguntaNomi> entities = new  ArrayList<FormatoNomiPreguntaNomi>();
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		  
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
	
	public  List<FormatoNomiPreguntaNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormatoNomiPreguntaNomi> entities = new  ArrayList<FormatoNomiPreguntaNomi>();
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormatoNomiPreguntaNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapFormatoNomiPreguntaNomi();
					//entity.setMapFormatoNomiPreguntaNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFormatoNomiPreguntaNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormatoNomiPreguntaNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA);         		
					entity=FormatoNomiPreguntaNomiDataAccess.getEntityFormatoNomiPreguntaNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormatoNomiPreguntaNomiOriginal( new FormatoNomiPreguntaNomi());
					////entity.setFormatoNomiPreguntaNomiOriginal(super.getEntity("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setFormatoNomiPreguntaNomiOriginal(this.getEntityFormatoNomiPreguntaNomi("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormatoNomiPreguntaNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormatoNomiPreguntaNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public FormatoNomiPreguntaNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		  
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
	
	public  FormatoNomiPreguntaNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormatoNomiPreguntaNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapFormatoNomiPreguntaNomi();
					//entity.setMapFormatoNomiPreguntaNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFormatoNomiPreguntaNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormatoNomiPreguntaNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA);         		
					entity=FormatoNomiPreguntaNomiDataAccess.getEntityFormatoNomiPreguntaNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormatoNomiPreguntaNomiOriginal( new FormatoNomiPreguntaNomi());
					////entity.setFormatoNomiPreguntaNomiOriginal(super.getEntity("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setFormatoNomiPreguntaNomiOriginal(this.getEntityFormatoNomiPreguntaNomi("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFormatoNomiPreguntaNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormatoNomiPreguntaNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FormatoNomiPreguntaNomi getEntityFormatoNomiPreguntaNomi(String strPrefijo,FormatoNomiPreguntaNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = FormatoNomiPreguntaNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = FormatoNomiPreguntaNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FormatoNomiPreguntaNomiDataAccess.setFieldReflectionFormatoNomiPreguntaNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFormatoNomiPreguntaNomi=FormatoNomiPreguntaNomiConstantesFunciones.getTodosTiposColumnasFormatoNomiPreguntaNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFormatoNomiPreguntaNomi) {
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
							field = FormatoNomiPreguntaNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = FormatoNomiPreguntaNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FormatoNomiPreguntaNomiDataAccess.setFieldReflectionFormatoNomiPreguntaNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFormatoNomiPreguntaNomi(Field field,String strPrefijo,String sColumn,FormatoNomiPreguntaNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FormatoNomiPreguntaNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoNomiPreguntaNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoNomiPreguntaNomiConstantesFunciones.IDFORMATONOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoNomiPreguntaNomiConstantesFunciones.IDFACTORNOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoNomiPreguntaNomiConstantesFunciones.IDPREGUNTANOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoNomiPreguntaNomiConstantesFunciones.PONDERACION:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormatoNomiPreguntaNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<FormatoNomiPreguntaNomi> entities = new  ArrayList<FormatoNomiPreguntaNomi>();
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormatoNomiPreguntaNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormatoNomiPreguntaNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoNomiPreguntaNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new FormatoNomiPreguntaNomi();
					entity=super.getEntity("",entity,resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFormatoNomiPreguntaNomi("",entity,resultSet);
					
					//entity.setFormatoNomiPreguntaNomiOriginal( new FormatoNomiPreguntaNomi());
					//entity.setFormatoNomiPreguntaNomiOriginal(super.getEntity("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setFormatoNomiPreguntaNomiOriginal(this.getEntityFormatoNomiPreguntaNomi("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFormatoNomiPreguntaNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormatoNomiPreguntaNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormatoNomiPreguntaNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<FormatoNomiPreguntaNomi> entities = new  ArrayList<FormatoNomiPreguntaNomi>();
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormatoNomiPreguntaNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormatoNomiPreguntaNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoNomiPreguntaNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<FormatoNomiPreguntaNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormatoNomiPreguntaNomi> entities = new  ArrayList<FormatoNomiPreguntaNomi>();
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		  
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
	
	public  List<FormatoNomiPreguntaNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormatoNomiPreguntaNomi> entities = new  ArrayList<FormatoNomiPreguntaNomi>();
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormatoNomiPreguntaNomi();
      	    	entity=super.getEntity("",entity,resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormatoNomiPreguntaNomi("",entity,resultSet);
      	    	
				//entity.setFormatoNomiPreguntaNomiOriginal( new FormatoNomiPreguntaNomi());
      	    	//entity.setFormatoNomiPreguntaNomiOriginal(super.getEntity("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoNomiPreguntaNomiOriginal(this.getEntityFormatoNomiPreguntaNomi("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFormatoNomiPreguntaNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormatoNomiPreguntaNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormatoNomiPreguntaNomi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormatoNomiPreguntaNomi> entities = new  ArrayList<FormatoNomiPreguntaNomi>();
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		  
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
	
	public  List<FormatoNomiPreguntaNomi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormatoNomiPreguntaNomi> entities = new  ArrayList<FormatoNomiPreguntaNomi>();
		FormatoNomiPreguntaNomi entity = new FormatoNomiPreguntaNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormatoNomiPreguntaNomi();
      	    	entity=super.getEntity("",entity,resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormatoNomiPreguntaNomi("",entity,resultSet);
      	    	
				//entity.setFormatoNomiPreguntaNomiOriginal( new FormatoNomiPreguntaNomi());
      	    	//entity.setFormatoNomiPreguntaNomiOriginal(super.getEntity("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet,FormatoNomiPreguntaNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoNomiPreguntaNomiOriginal(this.getEntityFormatoNomiPreguntaNomi("",entity.getFormatoNomiPreguntaNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormatoNomiPreguntaNomis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public FormatoNomiPreguntaNomi getEntityFormatoNomiPreguntaNomi(String strPrefijo,FormatoNomiPreguntaNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FormatoNomiPreguntaNomiConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+FormatoNomiPreguntaNomiConstantesFunciones.IDSUCURSAL));
				entity.setid_formato_nomi(resultSet.getLong(strPrefijo+FormatoNomiPreguntaNomiConstantesFunciones.IDFORMATONOMI));
				entity.setid_factor_nomi(resultSet.getLong(strPrefijo+FormatoNomiPreguntaNomiConstantesFunciones.IDFACTORNOMI));
				entity.setid_pregunta_nomi(resultSet.getLong(strPrefijo+FormatoNomiPreguntaNomiConstantesFunciones.IDPREGUNTANOMI));
				entity.setponderacion(resultSet.getDouble(strPrefijo+FormatoNomiPreguntaNomiConstantesFunciones.PONDERACION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFormatoNomiPreguntaNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(FormatoNomiPreguntaNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FormatoNomiPreguntaNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FormatoNomiPreguntaNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FormatoNomiPreguntaNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FormatoNomiPreguntaNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FormatoNomiPreguntaNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FormatoNomiPreguntaNomiDataAccess.TABLENAME,FormatoNomiPreguntaNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			FormatoNomiPreguntaNomiDataAccess.setFormatoNomiPreguntaNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,FormatoNomiPreguntaNomi relformatonomipreguntanomi)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relformatonomipreguntanomi.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,FormatoNomiPreguntaNomi relformatonomipreguntanomi)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relformatonomipreguntanomi.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public FormatoNomi getFormatoNomi(Connexion connexion,FormatoNomiPreguntaNomi relformatonomipreguntanomi)throws SQLException,Exception {

		FormatoNomi formatonomi= new FormatoNomi();

		try {
			FormatoNomiDataAccess formatonomiDataAccess=new FormatoNomiDataAccess();

			formatonomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatonomiDataAccess.setConnexionType(this.connexionType);
			formatonomiDataAccess.setParameterDbType(this.parameterDbType);

			formatonomi=formatonomiDataAccess.getEntity(connexion,relformatonomipreguntanomi.getid_formato_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formatonomi;

	}

	public FactorNomi getFactorNomi(Connexion connexion,FormatoNomiPreguntaNomi relformatonomipreguntanomi)throws SQLException,Exception {

		FactorNomi factornomi= new FactorNomi();

		try {
			FactorNomiDataAccess factornomiDataAccess=new FactorNomiDataAccess();

			factornomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			factornomiDataAccess.setConnexionType(this.connexionType);
			factornomiDataAccess.setParameterDbType(this.parameterDbType);

			factornomi=factornomiDataAccess.getEntity(connexion,relformatonomipreguntanomi.getid_factor_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factornomi;

	}

	public PreguntaNomi getPreguntaNomi(Connexion connexion,FormatoNomiPreguntaNomi relformatonomipreguntanomi)throws SQLException,Exception {

		PreguntaNomi preguntanomi= new PreguntaNomi();

		try {
			PreguntaNomiDataAccess preguntanomiDataAccess=new PreguntaNomiDataAccess();

			preguntanomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			preguntanomiDataAccess.setConnexionType(this.connexionType);
			preguntanomiDataAccess.setParameterDbType(this.parameterDbType);

			preguntanomi=preguntanomiDataAccess.getEntity(connexion,relformatonomipreguntanomi.getid_pregunta_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return preguntanomi;

	}


		
		public List<CalificacionEmpleado> getCalificacionEmpleados(Connexion connexion,FormatoNomiPreguntaNomi formatonomipreguntanomi)throws SQLException,Exception {

		List<CalificacionEmpleado> calificacionempleados= new ArrayList<CalificacionEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+".formato_nomi_pregunta_nomi ON "+CalificacionEmpleadoConstantesFunciones.SCHEMA+".calificacion_empleado.id_formato_nomi_pregunta_nomi="+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+".formato_nomi_pregunta_nomi.id WHERE "+FormatoNomiPreguntaNomiConstantesFunciones.SCHEMA+".formato_nomi_pregunta_nomi.id="+String.valueOf(formatonomipreguntanomi.getId());
			} else {
				sQuery=" INNER JOIN calificacionempleado.FormatoNomiPreguntaNomi WHERE calificacionempleado.FormatoNomiPreguntaNomi.id="+String.valueOf(formatonomipreguntanomi.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CalificacionEmpleadoDataAccess calificacionempleadoDataAccess=new CalificacionEmpleadoDataAccess();

			calificacionempleadoDataAccess.setConnexionType(this.connexionType);
			calificacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return calificacionempleados;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,FormatoNomiPreguntaNomi formatonomipreguntanomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!formatonomipreguntanomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(formatonomipreguntanomi.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(formatonomipreguntanomi.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_nomi.setValue(formatonomipreguntanomi.getid_formato_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factor_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_factor_nomi.setValue(formatonomipreguntanomi.getid_factor_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factor_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pregunta_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_pregunta_nomi.setValue(formatonomipreguntanomi.getid_pregunta_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pregunta_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueponderacion=new ParameterValue<Double>();
					parameterMaintenanceValueponderacion.setValue(formatonomipreguntanomi.getponderacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueponderacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!formatonomipreguntanomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(formatonomipreguntanomi.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(formatonomipreguntanomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(formatonomipreguntanomi.getId());
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
	
	public void setIsNewIsChangedFalseFormatoNomiPreguntaNomi(FormatoNomiPreguntaNomi formatonomipreguntanomi)throws Exception  {		
		formatonomipreguntanomi.setIsNew(false);
		formatonomipreguntanomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFormatoNomiPreguntaNomis(List<FormatoNomiPreguntaNomi> formatonomipreguntanomis)throws Exception  {				
		for(FormatoNomiPreguntaNomi formatonomipreguntanomi:formatonomipreguntanomis) {
			formatonomipreguntanomi.setIsNew(false);
			formatonomipreguntanomi.setIsChanged(false);
		}
	}
	
	public void generarExportarFormatoNomiPreguntaNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
