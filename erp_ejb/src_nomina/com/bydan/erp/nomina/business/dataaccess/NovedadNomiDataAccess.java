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
import com.bydan.erp.nomina.util.*;//NovedadNomiConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class NovedadNomiDataAccess extends  NovedadNomiDataAccessAdditional{ //NovedadNomiDataAccessAdditional,DataAccessHelper<NovedadNomi>
	//static Logger logger = Logger.getLogger(NovedadNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="novedad_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_empleado_autoriza,id_tipo_novedad_nomi,id_estado_novedad_nomi,fecha,numero_hora,numero_minuto,numero_jornada_trabajo,anio_vacacion,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_empleado_autoriza=?,id_tipo_novedad_nomi=?,id_estado_novedad_nomi=?,fecha=?,numero_hora=?,numero_minuto=?,numero_jornada_trabajo=?,anio_vacacion=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select novedadnomi from "+NovedadNomiConstantesFunciones.SPERSISTENCENAME+" novedadnomi";
	public static String QUERYSELECTNATIVE="select "+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".id,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".version_row,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".id_empresa,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".id_empleado,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".id_empleado_autoriza,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".id_tipo_novedad_nomi,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".id_estado_novedad_nomi,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".fecha,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".numero_hora,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".numero_minuto,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".numero_jornada_trabajo,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".anio_vacacion,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".descripcion from "+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME;//+" as "+NovedadNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".id,"+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+".version_row from "+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME;//+" as "+NovedadNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+NovedadNomiConstantesFunciones.SCHEMA+"."+NovedadNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_empleado_autoriza=?,id_tipo_novedad_nomi=?,id_estado_novedad_nomi=?,fecha=?,numero_hora=?,numero_minuto=?,numero_jornada_trabajo=?,anio_vacacion=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_NOVEDADNOMI_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_NOVEDADNOMI_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_NOVEDADNOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_NOVEDADNOMI_SELECT(?,?)";
	
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
	
	
	protected NovedadNomiDataAccessAdditional novedadnomiDataAccessAdditional=null;
	
	public NovedadNomiDataAccessAdditional getNovedadNomiDataAccessAdditional() {
		return this.novedadnomiDataAccessAdditional;
	}
	
	public void setNovedadNomiDataAccessAdditional(NovedadNomiDataAccessAdditional novedadnomiDataAccessAdditional) {
		try {
			this.novedadnomiDataAccessAdditional=novedadnomiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public NovedadNomiDataAccess() {
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
		NovedadNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		NovedadNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		NovedadNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setNovedadNomiOriginal(NovedadNomi novedadnomi)throws Exception  {
		novedadnomi.setNovedadNomiOriginal((NovedadNomi)novedadnomi.clone());		
	}
	
	public void setNovedadNomisOriginal(List<NovedadNomi> novedadnomis)throws Exception  {
		
		for(NovedadNomi novedadnomi:novedadnomis){
			novedadnomi.setNovedadNomiOriginal((NovedadNomi)novedadnomi.clone());
		}
	}
	
	public static void setNovedadNomiOriginalStatic(NovedadNomi novedadnomi)throws Exception  {
		novedadnomi.setNovedadNomiOriginal((NovedadNomi)novedadnomi.clone());		
	}
	
	public static void setNovedadNomisOriginalStatic(List<NovedadNomi> novedadnomis)throws Exception  {
		
		for(NovedadNomi novedadnomi:novedadnomis){
			novedadnomi.setNovedadNomiOriginal((NovedadNomi)novedadnomi.clone());
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
	
	public  NovedadNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		NovedadNomi entity = new NovedadNomi();		
		
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
	
	public  NovedadNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		NovedadNomi entity = new NovedadNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NovedadNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.NovedadNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setNovedadNomiOriginal(new NovedadNomi());
      	    	entity=super.getEntity("",entity,resultSet,NovedadNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNovedadNomi("",entity,resultSet); 
				
				//entity.setNovedadNomiOriginal(super.getEntity("",entity.getNovedadNomiOriginal(),resultSet,NovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadNomiOriginal(this.getEntityNovedadNomi("",entity.getNovedadNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseNovedadNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  NovedadNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NovedadNomi entity = new NovedadNomi();
				
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
	
	public  NovedadNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NovedadNomi entity = new NovedadNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NovedadNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.NovedadNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setNovedadNomiOriginal(new NovedadNomi());
      	    	entity=super.getEntity("",entity,resultSet,NovedadNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNovedadNomi("",entity,resultSet);    
				
				//entity.setNovedadNomiOriginal(super.getEntity("",entity.getNovedadNomiOriginal(),resultSet,NovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadNomiOriginal(this.getEntityNovedadNomi("",entity.getNovedadNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseNovedadNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //NovedadNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		NovedadNomi entity = new NovedadNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NovedadNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.NovedadNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseNovedadNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<NovedadNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NovedadNomi> entities = new  ArrayList<NovedadNomi>();
		NovedadNomi entity = new NovedadNomi();		  
		
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
	
	public  List<NovedadNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NovedadNomi> entities = new  ArrayList<NovedadNomi>();
		NovedadNomi entity = new NovedadNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=NovedadNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadNomi();
      	    	entity=super.getEntity("",entity,resultSet,NovedadNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNovedadNomi("",entity,resultSet);
      	    	
				//entity.setNovedadNomiOriginal( new NovedadNomi());
      	    	//entity.setNovedadNomiOriginal(super.getEntity("",entity.getNovedadNomiOriginal(),resultSet,NovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadNomiOriginal(this.getEntityNovedadNomi("",entity.getNovedadNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNovedadNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NovedadNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NovedadNomi> entities = new  ArrayList<NovedadNomi>();
		NovedadNomi entity = new NovedadNomi();		  
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
	
	public  List<NovedadNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NovedadNomi> entities = new  ArrayList<NovedadNomi>();
		NovedadNomi entity = new NovedadNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapNovedadNomi();
					//entity.setMapNovedadNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapNovedadNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNovedadNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NovedadNomiDataAccess.ISWITHSCHEMA);         		
					entity=NovedadNomiDataAccess.getEntityNovedadNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNovedadNomiOriginal( new NovedadNomi());
					////entity.setNovedadNomiOriginal(super.getEntity("",entity.getNovedadNomiOriginal(),resultSet,NovedadNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setNovedadNomiOriginal(this.getEntityNovedadNomi("",entity.getNovedadNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNovedadNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public NovedadNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NovedadNomi entity = new NovedadNomi();		  
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
	
	public  NovedadNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NovedadNomi entity = new NovedadNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapNovedadNomi();
					//entity.setMapNovedadNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapNovedadNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNovedadNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NovedadNomiDataAccess.ISWITHSCHEMA);         		
					entity=NovedadNomiDataAccess.getEntityNovedadNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNovedadNomiOriginal( new NovedadNomi());
					////entity.setNovedadNomiOriginal(super.getEntity("",entity.getNovedadNomiOriginal(),resultSet,NovedadNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setNovedadNomiOriginal(this.getEntityNovedadNomi("",entity.getNovedadNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseNovedadNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static NovedadNomi getEntityNovedadNomi(String strPrefijo,NovedadNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = NovedadNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = NovedadNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					NovedadNomiDataAccess.setFieldReflectionNovedadNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasNovedadNomi=NovedadNomiConstantesFunciones.getTodosTiposColumnasNovedadNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasNovedadNomi) {
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
							field = NovedadNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = NovedadNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						NovedadNomiDataAccess.setFieldReflectionNovedadNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionNovedadNomi(Field field,String strPrefijo,String sColumn,NovedadNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case NovedadNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NovedadNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NovedadNomiConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NovedadNomiConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NovedadNomiConstantesFunciones.IDEMPLEADOAUTORIZA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NovedadNomiConstantesFunciones.IDTIPONOVEDADNOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NovedadNomiConstantesFunciones.IDESTADONOVEDADNOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NovedadNomiConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case NovedadNomiConstantesFunciones.NUMEROHORA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NovedadNomiConstantesFunciones.NUMEROMINUTO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NovedadNomiConstantesFunciones.NUMEROJORNADATRABAJO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NovedadNomiConstantesFunciones.ANIOVACACION:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NovedadNomiConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NovedadNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<NovedadNomi> entities = new  ArrayList<NovedadNomi>();
		NovedadNomi entity = new NovedadNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NovedadNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new NovedadNomi();
					entity=super.getEntity("",entity,resultSet,NovedadNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityNovedadNomi("",entity,resultSet);
					
					//entity.setNovedadNomiOriginal( new NovedadNomi());
					//entity.setNovedadNomiOriginal(super.getEntity("",entity.getNovedadNomiOriginal(),resultSet,NovedadNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setNovedadNomiOriginal(this.getEntityNovedadNomi("",entity.getNovedadNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseNovedadNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NovedadNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<NovedadNomi> entities = new  ArrayList<NovedadNomi>();
		NovedadNomi entity = new NovedadNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NovedadNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NovedadNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<NovedadNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NovedadNomi> entities = new  ArrayList<NovedadNomi>();
		NovedadNomi entity = new NovedadNomi();		  
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
	
	public  List<NovedadNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NovedadNomi> entities = new  ArrayList<NovedadNomi>();
		NovedadNomi entity = new NovedadNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadNomi();
      	    	entity=super.getEntity("",entity,resultSet,NovedadNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNovedadNomi("",entity,resultSet);
      	    	
				//entity.setNovedadNomiOriginal( new NovedadNomi());
      	    	//entity.setNovedadNomiOriginal(super.getEntity("",entity.getNovedadNomiOriginal(),resultSet,NovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadNomiOriginal(this.getEntityNovedadNomi("",entity.getNovedadNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseNovedadNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NovedadNomi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NovedadNomi> entities = new  ArrayList<NovedadNomi>();
		NovedadNomi entity = new NovedadNomi();		  
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
	
	public  List<NovedadNomi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NovedadNomi> entities = new  ArrayList<NovedadNomi>();
		NovedadNomi entity = new NovedadNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadNomi();
      	    	entity=super.getEntity("",entity,resultSet,NovedadNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNovedadNomi("",entity,resultSet);
      	    	
				//entity.setNovedadNomiOriginal( new NovedadNomi());
      	    	//entity.setNovedadNomiOriginal(super.getEntity("",entity.getNovedadNomiOriginal(),resultSet,NovedadNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadNomiOriginal(this.getEntityNovedadNomi("",entity.getNovedadNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNovedadNomis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public NovedadNomi getEntityNovedadNomi(String strPrefijo,NovedadNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+NovedadNomiConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+NovedadNomiConstantesFunciones.IDEMPLEADO));
				entity.setid_empleado_autoriza(resultSet.getLong(strPrefijo+NovedadNomiConstantesFunciones.IDEMPLEADOAUTORIZA));
				entity.setid_tipo_novedad_nomi(resultSet.getLong(strPrefijo+NovedadNomiConstantesFunciones.IDTIPONOVEDADNOMI));
				entity.setid_estado_novedad_nomi(resultSet.getLong(strPrefijo+NovedadNomiConstantesFunciones.IDESTADONOVEDADNOMI));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+NovedadNomiConstantesFunciones.FECHA).getTime()));
				entity.setnumero_hora(resultSet.getInt(strPrefijo+NovedadNomiConstantesFunciones.NUMEROHORA));
				entity.setnumero_minuto(resultSet.getInt(strPrefijo+NovedadNomiConstantesFunciones.NUMEROMINUTO));
				entity.setnumero_jornada_trabajo(resultSet.getInt(strPrefijo+NovedadNomiConstantesFunciones.NUMEROJORNADATRABAJO));
				entity.setanio_vacacion(resultSet.getInt(strPrefijo+NovedadNomiConstantesFunciones.ANIOVACACION));
				entity.setdescripcion(resultSet.getString(strPrefijo+NovedadNomiConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowNovedadNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(NovedadNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=NovedadNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=NovedadNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=NovedadNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=NovedadNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(NovedadNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,NovedadNomiDataAccess.TABLENAME,NovedadNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			NovedadNomiDataAccess.setNovedadNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,NovedadNomi relnovedadnomi)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relnovedadnomi.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,NovedadNomi relnovedadnomi)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relnovedadnomi.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Empleado getEmpleadoAutoriza(Connexion connexion,NovedadNomi relnovedadnomi)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relnovedadnomi.getid_empleado_autoriza());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoNovedadNomi getTipoNovedadNomi(Connexion connexion,NovedadNomi relnovedadnomi)throws SQLException,Exception {

		TipoNovedadNomi tiponovedadnomi= new TipoNovedadNomi();

		try {
			TipoNovedadNomiDataAccess tiponovedadnomiDataAccess=new TipoNovedadNomiDataAccess();

			tiponovedadnomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiponovedadnomiDataAccess.setConnexionType(this.connexionType);
			tiponovedadnomiDataAccess.setParameterDbType(this.parameterDbType);

			tiponovedadnomi=tiponovedadnomiDataAccess.getEntity(connexion,relnovedadnomi.getid_tipo_novedad_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiponovedadnomi;

	}

	public EstadoNovedadNomi getEstadoNovedadNomi(Connexion connexion,NovedadNomi relnovedadnomi)throws SQLException,Exception {

		EstadoNovedadNomi estadonovedadnomi= new EstadoNovedadNomi();

		try {
			EstadoNovedadNomiDataAccess estadonovedadnomiDataAccess=new EstadoNovedadNomiDataAccess();

			estadonovedadnomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadonovedadnomiDataAccess.setConnexionType(this.connexionType);
			estadonovedadnomiDataAccess.setParameterDbType(this.parameterDbType);

			estadonovedadnomi=estadonovedadnomiDataAccess.getEntity(connexion,relnovedadnomi.getid_estado_novedad_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadonovedadnomi;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,NovedadNomi novedadnomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!novedadnomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(novedadnomi.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(novedadnomi.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado_autoriza=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado_autoriza.setValue(novedadnomi.getid_empleado_autoriza());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado_autoriza);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_novedad_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_novedad_nomi.setValue(novedadnomi.getid_tipo_novedad_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_novedad_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_novedad_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_novedad_nomi.setValue(novedadnomi.getid_estado_novedad_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_novedad_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(novedadnomi.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_hora=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_hora.setValue(novedadnomi.getnumero_hora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_hora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_minuto=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_minuto.setValue(novedadnomi.getnumero_minuto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_minuto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_jornada_trabajo=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_jornada_trabajo.setValue(novedadnomi.getnumero_jornada_trabajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_jornada_trabajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueanio_vacacion=new ParameterValue<Integer>();
					parameterMaintenanceValueanio_vacacion.setValue(novedadnomi.getanio_vacacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanio_vacacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(novedadnomi.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!novedadnomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(novedadnomi.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(novedadnomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(novedadnomi.getId());
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
	
	public void setIsNewIsChangedFalseNovedadNomi(NovedadNomi novedadnomi)throws Exception  {		
		novedadnomi.setIsNew(false);
		novedadnomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseNovedadNomis(List<NovedadNomi> novedadnomis)throws Exception  {				
		for(NovedadNomi novedadnomi:novedadnomis) {
			novedadnomi.setIsNew(false);
			novedadnomi.setIsChanged(false);
		}
	}
	
	public void generarExportarNovedadNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
