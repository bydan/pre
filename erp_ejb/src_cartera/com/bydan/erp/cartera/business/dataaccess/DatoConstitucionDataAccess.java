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
import com.bydan.erp.cartera.util.*;//DatoConstitucionConstantesFunciones;










@SuppressWarnings("unused")
final public class DatoConstitucionDataAccess extends  DatoConstitucionDataAccessAdditional{ //DatoConstitucionDataAccessAdditional,DataAccessHelper<DatoConstitucion>
	//static Logger logger = Logger.getLogger(DatoConstitucionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="datoconstitucion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+"(version_row,idcliente,idvalorclientecompania,direccion,fechaconstitucion,capitalsuscrito,plazofiniquito,reservalegal,fechaestatuto,esactivo)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,idcliente=?,idvalorclientecompania=?,direccion=?,fechaconstitucion=?,capitalsuscrito=?,plazofiniquito=?,reservalegal=?,fechaestatuto=?,esactivo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select datoconstitucion from "+DatoConstitucionConstantesFunciones.SPERSISTENCENAME+" datoconstitucion";
	public static String QUERYSELECTNATIVE="select "+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".id,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".version_row,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".idcliente,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".idvalorclientecompania,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".direccion,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".fechaconstitucion,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".capitalsuscrito,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".plazofiniquito,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".reservalegal,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".fechaestatuto,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".esactivo from "+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME;//+" as "+DatoConstitucionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".id,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".version_row,"+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+".direccion from "+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME;//+" as "+DatoConstitucionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DatoConstitucionConstantesFunciones.SCHEMA+"."+DatoConstitucionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,idcliente=?,idvalorclientecompania=?,direccion=?,fechaconstitucion=?,capitalsuscrito=?,plazofiniquito=?,reservalegal=?,fechaestatuto=?,esactivo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DATOCONSTITUCION_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DATOCONSTITUCION_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DATOCONSTITUCION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DATOCONSTITUCION_SELECT(?,?)";
	
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
	
	
	protected DatoConstitucionDataAccessAdditional datoconstitucionDataAccessAdditional=null;
	
	public DatoConstitucionDataAccessAdditional getDatoConstitucionDataAccessAdditional() {
		return this.datoconstitucionDataAccessAdditional;
	}
	
	public void setDatoConstitucionDataAccessAdditional(DatoConstitucionDataAccessAdditional datoconstitucionDataAccessAdditional) {
		try {
			this.datoconstitucionDataAccessAdditional=datoconstitucionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DatoConstitucionDataAccess() {
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
		DatoConstitucionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DatoConstitucionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DatoConstitucionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDatoConstitucionOriginal(DatoConstitucion datoconstitucion)throws Exception  {
		datoconstitucion.setDatoConstitucionOriginal((DatoConstitucion)datoconstitucion.clone());		
	}
	
	public void setDatoConstitucionsOriginal(List<DatoConstitucion> datoconstitucions)throws Exception  {
		
		for(DatoConstitucion datoconstitucion:datoconstitucions){
			datoconstitucion.setDatoConstitucionOriginal((DatoConstitucion)datoconstitucion.clone());
		}
	}
	
	public static void setDatoConstitucionOriginalStatic(DatoConstitucion datoconstitucion)throws Exception  {
		datoconstitucion.setDatoConstitucionOriginal((DatoConstitucion)datoconstitucion.clone());		
	}
	
	public static void setDatoConstitucionsOriginalStatic(List<DatoConstitucion> datoconstitucions)throws Exception  {
		
		for(DatoConstitucion datoconstitucion:datoconstitucions){
			datoconstitucion.setDatoConstitucionOriginal((DatoConstitucion)datoconstitucion.clone());
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
	
	public  DatoConstitucion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DatoConstitucion entity = new DatoConstitucion();		
		
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
	
	public  DatoConstitucion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DatoConstitucion entity = new DatoConstitucion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoConstitucionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoConstitucionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.DatoConstitucion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDatoConstitucionOriginal(new DatoConstitucion());
      	    	entity=super.getEntity("",entity,resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDatoConstitucion("",entity,resultSet); 
				
				//entity.setDatoConstitucionOriginal(super.getEntity("",entity.getDatoConstitucionOriginal(),resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoConstitucionOriginal(this.getEntityDatoConstitucion("",entity.getDatoConstitucionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDatoConstitucion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DatoConstitucion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DatoConstitucion entity = new DatoConstitucion();
				
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
	
	public  DatoConstitucion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DatoConstitucion entity = new DatoConstitucion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoConstitucionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoConstitucionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoConstitucionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.DatoConstitucion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDatoConstitucionOriginal(new DatoConstitucion());
      	    	entity=super.getEntity("",entity,resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDatoConstitucion("",entity,resultSet);    
				
				//entity.setDatoConstitucionOriginal(super.getEntity("",entity.getDatoConstitucionOriginal(),resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoConstitucionOriginal(this.getEntityDatoConstitucion("",entity.getDatoConstitucionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDatoConstitucion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DatoConstitucion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DatoConstitucion entity = new DatoConstitucion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoConstitucionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoConstitucionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoConstitucionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.DatoConstitucion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDatoConstitucion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DatoConstitucion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DatoConstitucion> entities = new  ArrayList<DatoConstitucion>();
		DatoConstitucion entity = new DatoConstitucion();		  
		
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
	
	public  List<DatoConstitucion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DatoConstitucion> entities = new  ArrayList<DatoConstitucion>();
		DatoConstitucion entity = new DatoConstitucion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoConstitucionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoConstitucionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoConstitucionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoConstitucion();
      	    	entity=super.getEntity("",entity,resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoConstitucion("",entity,resultSet);
      	    	
				//entity.setDatoConstitucionOriginal( new DatoConstitucion());
      	    	//entity.setDatoConstitucionOriginal(super.getEntity("",entity.getDatoConstitucionOriginal(),resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoConstitucionOriginal(this.getEntityDatoConstitucion("",entity.getDatoConstitucionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoConstitucions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoConstitucion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DatoConstitucion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DatoConstitucion> entities = new  ArrayList<DatoConstitucion>();
		DatoConstitucion entity = new DatoConstitucion();		  
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
	
	public  List<DatoConstitucion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DatoConstitucion> entities = new  ArrayList<DatoConstitucion>();
		DatoConstitucion entity = new DatoConstitucion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoConstitucion();
				
				if(conMapGenerico) {
					entity.inicializarMapDatoConstitucion();
					//entity.setMapDatoConstitucion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDatoConstitucionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDatoConstitucion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA);         		
					entity=DatoConstitucionDataAccess.getEntityDatoConstitucion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDatoConstitucionOriginal( new DatoConstitucion());
					////entity.setDatoConstitucionOriginal(super.getEntity("",entity.getDatoConstitucionOriginal(),resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA));         		
					////entity.setDatoConstitucionOriginal(this.getEntityDatoConstitucion("",entity.getDatoConstitucionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoConstitucions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoConstitucion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DatoConstitucion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DatoConstitucion entity = new DatoConstitucion();		  
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
	
	public  DatoConstitucion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DatoConstitucion entity = new DatoConstitucion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoConstitucion();
				
				if(conMapGenerico) {
					entity.inicializarMapDatoConstitucion();
					//entity.setMapDatoConstitucion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDatoConstitucionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDatoConstitucion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA);         		
					entity=DatoConstitucionDataAccess.getEntityDatoConstitucion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDatoConstitucionOriginal( new DatoConstitucion());
					////entity.setDatoConstitucionOriginal(super.getEntity("",entity.getDatoConstitucionOriginal(),resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA));         		
					////entity.setDatoConstitucionOriginal(this.getEntityDatoConstitucion("",entity.getDatoConstitucionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDatoConstitucion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoConstitucion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DatoConstitucion getEntityDatoConstitucion(String strPrefijo,DatoConstitucion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DatoConstitucion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DatoConstitucion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DatoConstitucionDataAccess.setFieldReflectionDatoConstitucion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDatoConstitucion=DatoConstitucionConstantesFunciones.getTodosTiposColumnasDatoConstitucion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDatoConstitucion) {
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
							field = DatoConstitucion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DatoConstitucion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DatoConstitucionDataAccess.setFieldReflectionDatoConstitucion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDatoConstitucion(Field field,String strPrefijo,String sColumn,DatoConstitucion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DatoConstitucionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoConstitucionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoConstitucionConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoConstitucionConstantesFunciones.IDTIPOCOMPANIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoConstitucionConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoConstitucionConstantesFunciones.FECHACONSTITUCION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DatoConstitucionConstantesFunciones.CAPITALSUSCRITO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DatoConstitucionConstantesFunciones.PLAZOFINIQUITO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DatoConstitucionConstantesFunciones.RESERVALEGAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DatoConstitucionConstantesFunciones.FECHAESTATUTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DatoConstitucionConstantesFunciones.ESACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DatoConstitucion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DatoConstitucion> entities = new  ArrayList<DatoConstitucion>();
		DatoConstitucion entity = new DatoConstitucion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoConstitucionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoConstitucionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoConstitucionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DatoConstitucion();
					entity=super.getEntity("",entity,resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDatoConstitucion("",entity,resultSet);
					
					//entity.setDatoConstitucionOriginal( new DatoConstitucion());
					//entity.setDatoConstitucionOriginal(super.getEntity("",entity.getDatoConstitucionOriginal(),resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA));         		
					//entity.setDatoConstitucionOriginal(this.getEntityDatoConstitucion("",entity.getDatoConstitucionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDatoConstitucions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoConstitucion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DatoConstitucion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DatoConstitucion> entities = new  ArrayList<DatoConstitucion>();
		DatoConstitucion entity = new DatoConstitucion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoConstitucionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoConstitucionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoConstitucionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DatoConstitucion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoConstitucion> entities = new  ArrayList<DatoConstitucion>();
		DatoConstitucion entity = new DatoConstitucion();		  
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
	
	public  List<DatoConstitucion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoConstitucion> entities = new  ArrayList<DatoConstitucion>();
		DatoConstitucion entity = new DatoConstitucion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoConstitucion();
      	    	entity=super.getEntity("",entity,resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoConstitucion("",entity,resultSet);
      	    	
				//entity.setDatoConstitucionOriginal( new DatoConstitucion());
      	    	//entity.setDatoConstitucionOriginal(super.getEntity("",entity.getDatoConstitucionOriginal(),resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoConstitucionOriginal(this.getEntityDatoConstitucion("",entity.getDatoConstitucionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDatoConstitucions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoConstitucion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DatoConstitucion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoConstitucion> entities = new  ArrayList<DatoConstitucion>();
		DatoConstitucion entity = new DatoConstitucion();		  
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
	
	public  List<DatoConstitucion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoConstitucion> entities = new  ArrayList<DatoConstitucion>();
		DatoConstitucion entity = new DatoConstitucion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoConstitucion();
      	    	entity=super.getEntity("",entity,resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoConstitucion("",entity,resultSet);
      	    	
				//entity.setDatoConstitucionOriginal( new DatoConstitucion());
      	    	//entity.setDatoConstitucionOriginal(super.getEntity("",entity.getDatoConstitucionOriginal(),resultSet,DatoConstitucionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoConstitucionOriginal(this.getEntityDatoConstitucion("",entity.getDatoConstitucionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoConstitucions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DatoConstitucion getEntityDatoConstitucion(String strPrefijo,DatoConstitucion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setidcliente(resultSet.getLong(strPrefijo+DatoConstitucionConstantesFunciones.IDCLIENTE));
				entity.setidvalorclientecompania(resultSet.getLong(strPrefijo+DatoConstitucionConstantesFunciones.IDTIPOCOMPANIA));
				entity.setdireccion(resultSet.getString(strPrefijo+DatoConstitucionConstantesFunciones.DIRECCION));
				entity.setfechaconstitucion(new Date(resultSet.getDate(strPrefijo+DatoConstitucionConstantesFunciones.FECHACONSTITUCION).getTime()));
				entity.setcapitalsuscrito(resultSet.getDouble(strPrefijo+DatoConstitucionConstantesFunciones.CAPITALSUSCRITO));
				entity.setplazofiniquito(resultSet.getInt(strPrefijo+DatoConstitucionConstantesFunciones.PLAZOFINIQUITO));
				entity.setreservalegal(resultSet.getDouble(strPrefijo+DatoConstitucionConstantesFunciones.RESERVALEGAL));
				entity.setfechaestatuto(new Date(resultSet.getDate(strPrefijo+DatoConstitucionConstantesFunciones.FECHAESTATUTO).getTime()));
				entity.setesactivo(resultSet.getBoolean(strPrefijo+DatoConstitucionConstantesFunciones.ESACTIVO));
			} else {
				entity.setdireccion(resultSet.getString(strPrefijo+DatoConstitucionConstantesFunciones.DIRECCION));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDatoConstitucion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DatoConstitucion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DatoConstitucionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DatoConstitucionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DatoConstitucionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DatoConstitucionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DatoConstitucionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DatoConstitucionDataAccess.TABLENAME,DatoConstitucionDataAccess.ISWITHSTOREPROCEDURES);
			
			DatoConstitucionDataAccess.setDatoConstitucionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Cliente getCliente(Connexion connexion,DatoConstitucion reldatoconstitucion)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,reldatoconstitucion.getidcliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoCompania getTipoCompania(Connexion connexion,DatoConstitucion reldatoconstitucion)throws SQLException,Exception {

		TipoCompania tipocompania= new TipoCompania();

		try {
			TipoCompaniaDataAccess tipocompaniaDataAccess=new TipoCompaniaDataAccess();

			tipocompaniaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocompaniaDataAccess.setConnexionType(this.connexionType);
			tipocompaniaDataAccess.setParameterDbType(this.parameterDbType);

			tipocompania=tipocompaniaDataAccess.getEntity(connexion,reldatoconstitucion.getidvalorclientecompania());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocompania;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DatoConstitucion datoconstitucion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!datoconstitucion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidcliente=new ParameterValue<Long>();
					parameterMaintenanceValueidcliente.setValue(datoconstitucion.getidcliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidcliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorclientecompania=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorclientecompania.setValue(datoconstitucion.getidvalorclientecompania());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorclientecompania);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(datoconstitucion.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefechaconstitucion=new ParameterValue<Date>();
					parameterMaintenanceValuefechaconstitucion.setValue(datoconstitucion.getfechaconstitucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefechaconstitucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecapitalsuscrito=new ParameterValue<Double>();
					parameterMaintenanceValuecapitalsuscrito.setValue(datoconstitucion.getcapitalsuscrito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecapitalsuscrito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueplazofiniquito=new ParameterValue<Integer>();
					parameterMaintenanceValueplazofiniquito.setValue(datoconstitucion.getplazofiniquito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueplazofiniquito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuereservalegal=new ParameterValue<Double>();
					parameterMaintenanceValuereservalegal.setValue(datoconstitucion.getreservalegal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuereservalegal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefechaestatuto=new ParameterValue<Date>();
					parameterMaintenanceValuefechaestatuto.setValue(datoconstitucion.getfechaestatuto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefechaestatuto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesactivo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesactivo.setValue(datoconstitucion.getesactivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesactivo);
					parametersTemp.add(parameterMaintenance);
					
						if(!datoconstitucion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(datoconstitucion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(datoconstitucion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(datoconstitucion.getId());
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
	
	public void setIsNewIsChangedFalseDatoConstitucion(DatoConstitucion datoconstitucion)throws Exception  {		
		datoconstitucion.setIsNew(false);
		datoconstitucion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDatoConstitucions(List<DatoConstitucion> datoconstitucions)throws Exception  {				
		for(DatoConstitucion datoconstitucion:datoconstitucions) {
			datoconstitucion.setIsNew(false);
			datoconstitucion.setIsChanged(false);
		}
	}
	
	public void generarExportarDatoConstitucion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
