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
import com.bydan.erp.cartera.util.*;//InformacionEconomicaConstantesFunciones;










@SuppressWarnings("unused")
final public class InformacionEconomicaDataAccess extends  InformacionEconomicaDataAccessAdditional{ //InformacionEconomicaDataAccessAdditional,DataAccessHelper<InformacionEconomica>
	//static Logger logger = Logger.getLogger(InformacionEconomicaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="informacioneconomica";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+"(version_row,idcliente,idvalorclientevinculacion,codigoactualizacion,codigodestinofinanciero,origenrecursos,cuasavinculacion,sectorizacion,esactivo)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,idcliente=?,idvalorclientevinculacion=?,codigoactualizacion=?,codigodestinofinanciero=?,origenrecursos=?,cuasavinculacion=?,sectorizacion=?,esactivo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select informacioneconomica from "+InformacionEconomicaConstantesFunciones.SPERSISTENCENAME+" informacioneconomica";
	public static String QUERYSELECTNATIVE="select "+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".id,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".version_row,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".idcliente,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".idvalorclientevinculacion,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".codigoactualizacion,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".codigodestinofinanciero,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".origenrecursos,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".cuasavinculacion,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".sectorizacion,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".esactivo from "+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME;//+" as "+InformacionEconomicaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".id,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".version_row,"+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+".codigoactualizacion from "+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME;//+" as "+InformacionEconomicaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+InformacionEconomicaConstantesFunciones.SCHEMA+"."+InformacionEconomicaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,idcliente=?,idvalorclientevinculacion=?,codigoactualizacion=?,codigodestinofinanciero=?,origenrecursos=?,cuasavinculacion=?,sectorizacion=?,esactivo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_INFORMACIONECONOMICA_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_INFORMACIONECONOMICA_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_INFORMACIONECONOMICA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_INFORMACIONECONOMICA_SELECT(?,?)";
	
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
	
	
	protected InformacionEconomicaDataAccessAdditional informacioneconomicaDataAccessAdditional=null;
	
	public InformacionEconomicaDataAccessAdditional getInformacionEconomicaDataAccessAdditional() {
		return this.informacioneconomicaDataAccessAdditional;
	}
	
	public void setInformacionEconomicaDataAccessAdditional(InformacionEconomicaDataAccessAdditional informacioneconomicaDataAccessAdditional) {
		try {
			this.informacioneconomicaDataAccessAdditional=informacioneconomicaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public InformacionEconomicaDataAccess() {
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
		InformacionEconomicaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		InformacionEconomicaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		InformacionEconomicaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setInformacionEconomicaOriginal(InformacionEconomica informacioneconomica)throws Exception  {
		informacioneconomica.setInformacionEconomicaOriginal((InformacionEconomica)informacioneconomica.clone());		
	}
	
	public void setInformacionEconomicasOriginal(List<InformacionEconomica> informacioneconomicas)throws Exception  {
		
		for(InformacionEconomica informacioneconomica:informacioneconomicas){
			informacioneconomica.setInformacionEconomicaOriginal((InformacionEconomica)informacioneconomica.clone());
		}
	}
	
	public static void setInformacionEconomicaOriginalStatic(InformacionEconomica informacioneconomica)throws Exception  {
		informacioneconomica.setInformacionEconomicaOriginal((InformacionEconomica)informacioneconomica.clone());		
	}
	
	public static void setInformacionEconomicasOriginalStatic(List<InformacionEconomica> informacioneconomicas)throws Exception  {
		
		for(InformacionEconomica informacioneconomica:informacioneconomicas){
			informacioneconomica.setInformacionEconomicaOriginal((InformacionEconomica)informacioneconomica.clone());
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
	
	public  InformacionEconomica getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		InformacionEconomica entity = new InformacionEconomica();		
		
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
	
	public  InformacionEconomica getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		InformacionEconomica entity = new InformacionEconomica();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=InformacionEconomicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=InformacionEconomicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.InformacionEconomica.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setInformacionEconomicaOriginal(new InformacionEconomica());
      	    	entity=super.getEntity("",entity,resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityInformacionEconomica("",entity,resultSet); 
				
				//entity.setInformacionEconomicaOriginal(super.getEntity("",entity.getInformacionEconomicaOriginal(),resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionEconomicaOriginal(this.getEntityInformacionEconomica("",entity.getInformacionEconomicaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseInformacionEconomica(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  InformacionEconomica getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		InformacionEconomica entity = new InformacionEconomica();
				
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
	
	public  InformacionEconomica getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		InformacionEconomica entity = new InformacionEconomica();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=InformacionEconomicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=InformacionEconomicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionEconomicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.InformacionEconomica.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setInformacionEconomicaOriginal(new InformacionEconomica());
      	    	entity=super.getEntity("",entity,resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityInformacionEconomica("",entity,resultSet);    
				
				//entity.setInformacionEconomicaOriginal(super.getEntity("",entity.getInformacionEconomicaOriginal(),resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionEconomicaOriginal(this.getEntityInformacionEconomica("",entity.getInformacionEconomicaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseInformacionEconomica(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //InformacionEconomica
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		InformacionEconomica entity = new InformacionEconomica();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=InformacionEconomicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=InformacionEconomicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionEconomicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.InformacionEconomica.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseInformacionEconomica(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<InformacionEconomica> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<InformacionEconomica> entities = new  ArrayList<InformacionEconomica>();
		InformacionEconomica entity = new InformacionEconomica();		  
		
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
	
	public  List<InformacionEconomica> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<InformacionEconomica> entities = new  ArrayList<InformacionEconomica>();
		InformacionEconomica entity = new InformacionEconomica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=InformacionEconomicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=InformacionEconomicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionEconomicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionEconomica();
      	    	entity=super.getEntity("",entity,resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityInformacionEconomica("",entity,resultSet);
      	    	
				//entity.setInformacionEconomicaOriginal( new InformacionEconomica());
      	    	//entity.setInformacionEconomicaOriginal(super.getEntity("",entity.getInformacionEconomicaOriginal(),resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionEconomicaOriginal(this.getEntityInformacionEconomica("",entity.getInformacionEconomicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseInformacionEconomicas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionEconomica(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<InformacionEconomica> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<InformacionEconomica> entities = new  ArrayList<InformacionEconomica>();
		InformacionEconomica entity = new InformacionEconomica();		  
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
	
	public  List<InformacionEconomica> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<InformacionEconomica> entities = new  ArrayList<InformacionEconomica>();
		InformacionEconomica entity = new InformacionEconomica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionEconomica();
				
				if(conMapGenerico) {
					entity.inicializarMapInformacionEconomica();
					//entity.setMapInformacionEconomica(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapInformacionEconomicaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapInformacionEconomica().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA);         		
					entity=InformacionEconomicaDataAccess.getEntityInformacionEconomica("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setInformacionEconomicaOriginal( new InformacionEconomica());
					////entity.setInformacionEconomicaOriginal(super.getEntity("",entity.getInformacionEconomicaOriginal(),resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA));         		
					////entity.setInformacionEconomicaOriginal(this.getEntityInformacionEconomica("",entity.getInformacionEconomicaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseInformacionEconomicas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionEconomica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public InformacionEconomica getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		InformacionEconomica entity = new InformacionEconomica();		  
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
	
	public  InformacionEconomica getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		InformacionEconomica entity = new InformacionEconomica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionEconomica();
				
				if(conMapGenerico) {
					entity.inicializarMapInformacionEconomica();
					//entity.setMapInformacionEconomica(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapInformacionEconomicaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapInformacionEconomica().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA);         		
					entity=InformacionEconomicaDataAccess.getEntityInformacionEconomica("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setInformacionEconomicaOriginal( new InformacionEconomica());
					////entity.setInformacionEconomicaOriginal(super.getEntity("",entity.getInformacionEconomicaOriginal(),resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA));         		
					////entity.setInformacionEconomicaOriginal(this.getEntityInformacionEconomica("",entity.getInformacionEconomicaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseInformacionEconomica(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionEconomica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static InformacionEconomica getEntityInformacionEconomica(String strPrefijo,InformacionEconomica entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = InformacionEconomica.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = InformacionEconomica.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					InformacionEconomicaDataAccess.setFieldReflectionInformacionEconomica(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasInformacionEconomica=InformacionEconomicaConstantesFunciones.getTodosTiposColumnasInformacionEconomica();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasInformacionEconomica) {
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
							field = InformacionEconomica.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = InformacionEconomica.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						InformacionEconomicaDataAccess.setFieldReflectionInformacionEconomica(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionInformacionEconomica(Field field,String strPrefijo,String sColumn,InformacionEconomica entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case InformacionEconomicaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionEconomicaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionEconomicaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionEconomicaConstantesFunciones.IDTIPOVINCULACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionEconomicaConstantesFunciones.CODIGOACTUALIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionEconomicaConstantesFunciones.CODIGODESTINOFINANCIERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionEconomicaConstantesFunciones.ORIGENRECURSOS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionEconomicaConstantesFunciones.CUASAVINCULACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionEconomicaConstantesFunciones.SECTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionEconomicaConstantesFunciones.ESACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<InformacionEconomica>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<InformacionEconomica> entities = new  ArrayList<InformacionEconomica>();
		InformacionEconomica entity = new InformacionEconomica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=InformacionEconomicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=InformacionEconomicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionEconomicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new InformacionEconomica();
					entity=super.getEntity("",entity,resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityInformacionEconomica("",entity,resultSet);
					
					//entity.setInformacionEconomicaOriginal( new InformacionEconomica());
					//entity.setInformacionEconomicaOriginal(super.getEntity("",entity.getInformacionEconomicaOriginal(),resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA));         		
					//entity.setInformacionEconomicaOriginal(this.getEntityInformacionEconomica("",entity.getInformacionEconomicaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseInformacionEconomicas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionEconomica(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<InformacionEconomica>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<InformacionEconomica> entities = new  ArrayList<InformacionEconomica>();
		InformacionEconomica entity = new InformacionEconomica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=InformacionEconomicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=InformacionEconomicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionEconomicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<InformacionEconomica> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<InformacionEconomica> entities = new  ArrayList<InformacionEconomica>();
		InformacionEconomica entity = new InformacionEconomica();		  
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
	
	public  List<InformacionEconomica> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<InformacionEconomica> entities = new  ArrayList<InformacionEconomica>();
		InformacionEconomica entity = new InformacionEconomica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionEconomica();
      	    	entity=super.getEntity("",entity,resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityInformacionEconomica("",entity,resultSet);
      	    	
				//entity.setInformacionEconomicaOriginal( new InformacionEconomica());
      	    	//entity.setInformacionEconomicaOriginal(super.getEntity("",entity.getInformacionEconomicaOriginal(),resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionEconomicaOriginal(this.getEntityInformacionEconomica("",entity.getInformacionEconomicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseInformacionEconomicas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionEconomica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<InformacionEconomica> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<InformacionEconomica> entities = new  ArrayList<InformacionEconomica>();
		InformacionEconomica entity = new InformacionEconomica();		  
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
	
	public  List<InformacionEconomica> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<InformacionEconomica> entities = new  ArrayList<InformacionEconomica>();
		InformacionEconomica entity = new InformacionEconomica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionEconomica();
      	    	entity=super.getEntity("",entity,resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityInformacionEconomica("",entity,resultSet);
      	    	
				//entity.setInformacionEconomicaOriginal( new InformacionEconomica());
      	    	//entity.setInformacionEconomicaOriginal(super.getEntity("",entity.getInformacionEconomicaOriginal(),resultSet,InformacionEconomicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionEconomicaOriginal(this.getEntityInformacionEconomica("",entity.getInformacionEconomicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseInformacionEconomicas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public InformacionEconomica getEntityInformacionEconomica(String strPrefijo,InformacionEconomica entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setidcliente(resultSet.getLong(strPrefijo+InformacionEconomicaConstantesFunciones.IDCLIENTE));
				entity.setidvalorclientevinculacion(resultSet.getLong(strPrefijo+InformacionEconomicaConstantesFunciones.IDTIPOVINCULACION));
				entity.setcodigoactualizacion(resultSet.getString(strPrefijo+InformacionEconomicaConstantesFunciones.CODIGOACTUALIZACION));
				entity.setcodigodestinofinanciero(resultSet.getString(strPrefijo+InformacionEconomicaConstantesFunciones.CODIGODESTINOFINANCIERO));
				entity.setorigenrecursos(resultSet.getString(strPrefijo+InformacionEconomicaConstantesFunciones.ORIGENRECURSOS));
				entity.setcuasavinculacion(resultSet.getString(strPrefijo+InformacionEconomicaConstantesFunciones.CUASAVINCULACION));
				entity.setsectorizacion(resultSet.getString(strPrefijo+InformacionEconomicaConstantesFunciones.SECTORIZACION));
				entity.setesactivo(resultSet.getBoolean(strPrefijo+InformacionEconomicaConstantesFunciones.ESACTIVO));
			} else {
				entity.setcodigoactualizacion(resultSet.getString(strPrefijo+InformacionEconomicaConstantesFunciones.CODIGOACTUALIZACION));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowInformacionEconomica(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(InformacionEconomica entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=InformacionEconomicaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=InformacionEconomicaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=InformacionEconomicaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=InformacionEconomicaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(InformacionEconomicaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,InformacionEconomicaDataAccess.TABLENAME,InformacionEconomicaDataAccess.ISWITHSTOREPROCEDURES);
			
			InformacionEconomicaDataAccess.setInformacionEconomicaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Cliente getCliente(Connexion connexion,InformacionEconomica relinformacioneconomica)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relinformacioneconomica.getidcliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoVinculacion getTipoVinculacion(Connexion connexion,InformacionEconomica relinformacioneconomica)throws SQLException,Exception {

		TipoVinculacion tipovinculacion= new TipoVinculacion();

		try {
			TipoVinculacionDataAccess tipovinculacionDataAccess=new TipoVinculacionDataAccess();

			tipovinculacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipovinculacionDataAccess.setConnexionType(this.connexionType);
			tipovinculacionDataAccess.setParameterDbType(this.parameterDbType);

			tipovinculacion=tipovinculacionDataAccess.getEntity(connexion,relinformacioneconomica.getidvalorclientevinculacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipovinculacion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,InformacionEconomica informacioneconomica) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!informacioneconomica.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidcliente=new ParameterValue<Long>();
					parameterMaintenanceValueidcliente.setValue(informacioneconomica.getidcliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidcliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorclientevinculacion=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorclientevinculacion.setValue(informacioneconomica.getidvalorclientevinculacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorclientevinculacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigoactualizacion=new ParameterValue<String>();
					parameterMaintenanceValuecodigoactualizacion.setValue(informacioneconomica.getcodigoactualizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigoactualizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigodestinofinanciero=new ParameterValue<String>();
					parameterMaintenanceValuecodigodestinofinanciero.setValue(informacioneconomica.getcodigodestinofinanciero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigodestinofinanciero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueorigenrecursos=new ParameterValue<String>();
					parameterMaintenanceValueorigenrecursos.setValue(informacioneconomica.getorigenrecursos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorigenrecursos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecuasavinculacion=new ParameterValue<String>();
					parameterMaintenanceValuecuasavinculacion.setValue(informacioneconomica.getcuasavinculacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecuasavinculacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesectorizacion=new ParameterValue<String>();
					parameterMaintenanceValuesectorizacion.setValue(informacioneconomica.getsectorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesectorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesactivo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesactivo.setValue(informacioneconomica.getesactivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesactivo);
					parametersTemp.add(parameterMaintenance);
					
						if(!informacioneconomica.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(informacioneconomica.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(informacioneconomica.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(informacioneconomica.getId());
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
	
	public void setIsNewIsChangedFalseInformacionEconomica(InformacionEconomica informacioneconomica)throws Exception  {		
		informacioneconomica.setIsNew(false);
		informacioneconomica.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseInformacionEconomicas(List<InformacionEconomica> informacioneconomicas)throws Exception  {				
		for(InformacionEconomica informacioneconomica:informacioneconomicas) {
			informacioneconomica.setIsNew(false);
			informacioneconomica.setIsChanged(false);
		}
	}
	
	public void generarExportarInformacionEconomica(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
