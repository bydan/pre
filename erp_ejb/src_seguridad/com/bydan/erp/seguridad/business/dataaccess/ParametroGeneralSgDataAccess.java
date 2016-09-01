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
package com.bydan.erp.seguridad.business.dataaccess;

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

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.util.*;//ParametroGeneralSgConstantesFunciones;










@SuppressWarnings("unused")
final public class ParametroGeneralSgDataAccess extends  ParametroGeneralSgDataAccessAdditional{ //ParametroGeneralSgDataAccessAdditional,DataAccessHelper<ParametroGeneralSg>
	//static Logger logger = Logger.getLogger(ParametroGeneralSgDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_general_sg";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+"(version_row,nombre_sistema,nombre_simple_sistema,nombre_empresa,version_sistema,siglas_sistema,mail_sistema,telefono_sistema,fax_sistema,representante_nombre,codigo_proceso_actualizacion,esta_activo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+" set version_row=current_timestamp,nombre_sistema=?,nombre_simple_sistema=?,nombre_empresa=?,version_sistema=?,siglas_sistema=?,mail_sistema=?,telefono_sistema=?,fax_sistema=?,representante_nombre=?,codigo_proceso_actualizacion=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrogeneralsg from "+ParametroGeneralSgConstantesFunciones.SPERSISTENCENAME+" parametrogeneralsg";
	public static String QUERYSELECTNATIVE="select "+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".id,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".version_row,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".nombre_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".nombre_simple_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".nombre_empresa,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".version_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".siglas_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".mail_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".telefono_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".fax_sistema,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".representante_nombre,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".codigo_proceso_actualizacion,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".esta_activo from "+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME;//+" as "+ParametroGeneralSgConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".id,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".version_row,"+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+".nombre_simple_sistema from "+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME;//+" as "+ParametroGeneralSgConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroGeneralSgConstantesFunciones.SCHEMA+"."+ParametroGeneralSgConstantesFunciones.TABLENAME+" set version_row=current_timestamp,nombre_sistema=?,nombre_simple_sistema=?,nombre_empresa=?,version_sistema=?,siglas_sistema=?,mail_sistema=?,telefono_sistema=?,fax_sistema=?,representante_nombre=?,codigo_proceso_actualizacion=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROGENERALSG_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROGENERALSG_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROGENERALSG_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROGENERALSG_SELECT(?,?)";
	
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
	
	
	protected ParametroGeneralSgDataAccessAdditional parametrogeneralsgDataAccessAdditional=null;
	
	public ParametroGeneralSgDataAccessAdditional getParametroGeneralSgDataAccessAdditional() {
		return this.parametrogeneralsgDataAccessAdditional;
	}
	
	public void setParametroGeneralSgDataAccessAdditional(ParametroGeneralSgDataAccessAdditional parametrogeneralsgDataAccessAdditional) {
		try {
			this.parametrogeneralsgDataAccessAdditional=parametrogeneralsgDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroGeneralSgDataAccess() {
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
		ParametroGeneralSgDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroGeneralSgDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroGeneralSgDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroGeneralSgOriginal(ParametroGeneralSg parametrogeneralsg)throws Exception  {
		parametrogeneralsg.setParametroGeneralSgOriginal((ParametroGeneralSg)parametrogeneralsg.clone());		
	}
	
	public void setParametroGeneralSgsOriginal(List<ParametroGeneralSg> parametrogeneralsgs)throws Exception  {
		
		for(ParametroGeneralSg parametrogeneralsg:parametrogeneralsgs){
			parametrogeneralsg.setParametroGeneralSgOriginal((ParametroGeneralSg)parametrogeneralsg.clone());
		}
	}
	
	public static void setParametroGeneralSgOriginalStatic(ParametroGeneralSg parametrogeneralsg)throws Exception  {
		parametrogeneralsg.setParametroGeneralSgOriginal((ParametroGeneralSg)parametrogeneralsg.clone());		
	}
	
	public static void setParametroGeneralSgsOriginalStatic(List<ParametroGeneralSg> parametrogeneralsgs)throws Exception  {
		
		for(ParametroGeneralSg parametrogeneralsg:parametrogeneralsgs){
			parametrogeneralsg.setParametroGeneralSgOriginal((ParametroGeneralSg)parametrogeneralsg.clone());
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
	
	public  ParametroGeneralSg getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroGeneralSg entity = new ParametroGeneralSg();		
		
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
	
	public  ParametroGeneralSg getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroGeneralSg entity = new ParametroGeneralSg();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroGeneralSgDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroGeneralSgDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.ParametroGeneralSg.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroGeneralSgOriginal(new ParametroGeneralSg());
      	    	entity=super.getEntity("",entity,resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroGeneralSg("",entity,resultSet); 
				
				//entity.setParametroGeneralSgOriginal(super.getEntity("",entity.getParametroGeneralSgOriginal(),resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGeneralSgOriginal(this.getEntityParametroGeneralSg("",entity.getParametroGeneralSgOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroGeneralSg(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroGeneralSg getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroGeneralSg entity = new ParametroGeneralSg();
				
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
	
	public  ParametroGeneralSg getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroGeneralSg entity = new ParametroGeneralSg();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroGeneralSgDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroGeneralSgDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGeneralSgDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.ParametroGeneralSg.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroGeneralSgOriginal(new ParametroGeneralSg());
      	    	entity=super.getEntity("",entity,resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroGeneralSg("",entity,resultSet);    
				
				//entity.setParametroGeneralSgOriginal(super.getEntity("",entity.getParametroGeneralSgOriginal(),resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGeneralSgOriginal(this.getEntityParametroGeneralSg("",entity.getParametroGeneralSgOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroGeneralSg(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroGeneralSg
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroGeneralSg entity = new ParametroGeneralSg();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroGeneralSgDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroGeneralSgDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGeneralSgDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.ParametroGeneralSg.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroGeneralSg(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroGeneralSg> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroGeneralSg> entities = new  ArrayList<ParametroGeneralSg>();
		ParametroGeneralSg entity = new ParametroGeneralSg();		  
		
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
	
	public  List<ParametroGeneralSg> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroGeneralSg> entities = new  ArrayList<ParametroGeneralSg>();
		ParametroGeneralSg entity = new ParametroGeneralSg();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroGeneralSgDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroGeneralSgDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGeneralSgDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGeneralSg();
      	    	entity=super.getEntity("",entity,resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroGeneralSg("",entity,resultSet);
      	    	
				//entity.setParametroGeneralSgOriginal( new ParametroGeneralSg());
      	    	//entity.setParametroGeneralSgOriginal(super.getEntity("",entity.getParametroGeneralSgOriginal(),resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGeneralSgOriginal(this.getEntityParametroGeneralSg("",entity.getParametroGeneralSgOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroGeneralSgs(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGeneralSg(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroGeneralSg> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroGeneralSg> entities = new  ArrayList<ParametroGeneralSg>();
		ParametroGeneralSg entity = new ParametroGeneralSg();		  
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
	
	public  List<ParametroGeneralSg> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroGeneralSg> entities = new  ArrayList<ParametroGeneralSg>();
		ParametroGeneralSg entity = new ParametroGeneralSg();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGeneralSg();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroGeneralSg();
					//entity.setMapParametroGeneralSg(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroGeneralSgValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroGeneralSg().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA);         		
					entity=ParametroGeneralSgDataAccess.getEntityParametroGeneralSg("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroGeneralSgOriginal( new ParametroGeneralSg());
					////entity.setParametroGeneralSgOriginal(super.getEntity("",entity.getParametroGeneralSgOriginal(),resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroGeneralSgOriginal(this.getEntityParametroGeneralSg("",entity.getParametroGeneralSgOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroGeneralSgs(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGeneralSg(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroGeneralSg getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroGeneralSg entity = new ParametroGeneralSg();		  
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
	
	public  ParametroGeneralSg getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroGeneralSg entity = new ParametroGeneralSg();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGeneralSg();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroGeneralSg();
					//entity.setMapParametroGeneralSg(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroGeneralSgValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroGeneralSg().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA);         		
					entity=ParametroGeneralSgDataAccess.getEntityParametroGeneralSg("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroGeneralSgOriginal( new ParametroGeneralSg());
					////entity.setParametroGeneralSgOriginal(super.getEntity("",entity.getParametroGeneralSgOriginal(),resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroGeneralSgOriginal(this.getEntityParametroGeneralSg("",entity.getParametroGeneralSgOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroGeneralSg(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGeneralSg(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroGeneralSg getEntityParametroGeneralSg(String strPrefijo,ParametroGeneralSg entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroGeneralSg.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroGeneralSg.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroGeneralSgDataAccess.setFieldReflectionParametroGeneralSg(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroGeneralSg=ParametroGeneralSgConstantesFunciones.getTodosTiposColumnasParametroGeneralSg();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroGeneralSg) {
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
							field = ParametroGeneralSg.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroGeneralSg.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroGeneralSgDataAccess.setFieldReflectionParametroGeneralSg(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroGeneralSg(Field field,String strPrefijo,String sColumn,ParametroGeneralSg entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroGeneralSgConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroGeneralSgConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGeneralSgConstantesFunciones.NOMBRESISTEMA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGeneralSgConstantesFunciones.NOMBRESIMPLESISTEMA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGeneralSgConstantesFunciones.NOMBREEMPRESA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGeneralSgConstantesFunciones.VERSIONSISTEMA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ParametroGeneralSgConstantesFunciones.SIGLASSISTEMA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGeneralSgConstantesFunciones.MAILSISTEMA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGeneralSgConstantesFunciones.TELEFONOSISTEMA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGeneralSgConstantesFunciones.FAXSISTEMA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGeneralSgConstantesFunciones.REPRESENTANTENOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGeneralSgConstantesFunciones.CODIGOPROCESOACTUALIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroGeneralSgConstantesFunciones.ESTAACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroGeneralSg>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroGeneralSg> entities = new  ArrayList<ParametroGeneralSg>();
		ParametroGeneralSg entity = new ParametroGeneralSg();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroGeneralSgDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroGeneralSgDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGeneralSgDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroGeneralSg();
					entity=super.getEntity("",entity,resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroGeneralSg("",entity,resultSet);
					
					//entity.setParametroGeneralSgOriginal( new ParametroGeneralSg());
					//entity.setParametroGeneralSgOriginal(super.getEntity("",entity.getParametroGeneralSgOriginal(),resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroGeneralSgOriginal(this.getEntityParametroGeneralSg("",entity.getParametroGeneralSgOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroGeneralSgs(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGeneralSg(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroGeneralSg>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroGeneralSg> entities = new  ArrayList<ParametroGeneralSg>();
		ParametroGeneralSg entity = new ParametroGeneralSg();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroGeneralSgDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroGeneralSgDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroGeneralSgDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroGeneralSg> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGeneralSg> entities = new  ArrayList<ParametroGeneralSg>();
		ParametroGeneralSg entity = new ParametroGeneralSg();		  
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
	
	public  List<ParametroGeneralSg> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGeneralSg> entities = new  ArrayList<ParametroGeneralSg>();
		ParametroGeneralSg entity = new ParametroGeneralSg();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGeneralSg();
      	    	entity=super.getEntity("",entity,resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroGeneralSg("",entity,resultSet);
      	    	
				//entity.setParametroGeneralSgOriginal( new ParametroGeneralSg());
      	    	//entity.setParametroGeneralSgOriginal(super.getEntity("",entity.getParametroGeneralSgOriginal(),resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGeneralSgOriginal(this.getEntityParametroGeneralSg("",entity.getParametroGeneralSgOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroGeneralSgs(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroGeneralSg(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroGeneralSg> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGeneralSg> entities = new  ArrayList<ParametroGeneralSg>();
		ParametroGeneralSg entity = new ParametroGeneralSg();		  
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
	
	public  List<ParametroGeneralSg> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroGeneralSg> entities = new  ArrayList<ParametroGeneralSg>();
		ParametroGeneralSg entity = new ParametroGeneralSg();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroGeneralSg();
      	    	entity=super.getEntity("",entity,resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroGeneralSg("",entity,resultSet);
      	    	
				//entity.setParametroGeneralSgOriginal( new ParametroGeneralSg());
      	    	//entity.setParametroGeneralSgOriginal(super.getEntity("",entity.getParametroGeneralSgOriginal(),resultSet,ParametroGeneralSgDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroGeneralSgOriginal(this.getEntityParametroGeneralSg("",entity.getParametroGeneralSgOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroGeneralSgs(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroGeneralSg getEntityParametroGeneralSg(String strPrefijo,ParametroGeneralSg entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre_sistema(resultSet.getString(strPrefijo+ParametroGeneralSgConstantesFunciones.NOMBRESISTEMA));
				entity.setnombre_simple_sistema(resultSet.getString(strPrefijo+ParametroGeneralSgConstantesFunciones.NOMBRESIMPLESISTEMA));
				entity.setnombre_empresa(resultSet.getString(strPrefijo+ParametroGeneralSgConstantesFunciones.NOMBREEMPRESA));
				entity.setversion_sistema(resultSet.getDouble(strPrefijo+ParametroGeneralSgConstantesFunciones.VERSIONSISTEMA));
				entity.setsiglas_sistema(resultSet.getString(strPrefijo+ParametroGeneralSgConstantesFunciones.SIGLASSISTEMA));
				entity.setmail_sistema(resultSet.getString(strPrefijo+ParametroGeneralSgConstantesFunciones.MAILSISTEMA));
				entity.settelefono_sistema(resultSet.getString(strPrefijo+ParametroGeneralSgConstantesFunciones.TELEFONOSISTEMA));
				entity.setfax_sistema(resultSet.getString(strPrefijo+ParametroGeneralSgConstantesFunciones.FAXSISTEMA));
				entity.setrepresentante_nombre(resultSet.getString(strPrefijo+ParametroGeneralSgConstantesFunciones.REPRESENTANTENOMBRE));
				entity.setcodigo_proceso_actualizacion(resultSet.getString(strPrefijo+ParametroGeneralSgConstantesFunciones.CODIGOPROCESOACTUALIZACION));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+ParametroGeneralSgConstantesFunciones.ESTAACTIVO));
			} else {
				entity.setnombre_simple_sistema(resultSet.getString(strPrefijo+ParametroGeneralSgConstantesFunciones.NOMBRESIMPLESISTEMA));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroGeneralSg(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroGeneralSg entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroGeneralSgDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroGeneralSgDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroGeneralSgDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroGeneralSgDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroGeneralSgConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroGeneralSgDataAccess.TABLENAME,ParametroGeneralSgDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroGeneralSgDataAccess.setParametroGeneralSgOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroGeneralSg parametrogeneralsg) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrogeneralsg.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_sistema=new ParameterValue<String>();
					parameterMaintenanceValuenombre_sistema.setValue(parametrogeneralsg.getnombre_sistema());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_sistema);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_simple_sistema=new ParameterValue<String>();
					parameterMaintenanceValuenombre_simple_sistema.setValue(parametrogeneralsg.getnombre_simple_sistema());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_simple_sistema);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_empresa=new ParameterValue<String>();
					parameterMaintenanceValuenombre_empresa.setValue(parametrogeneralsg.getnombre_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueversion_sistema=new ParameterValue<Double>();
					parameterMaintenanceValueversion_sistema.setValue(parametrogeneralsg.getversion_sistema());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueversion_sistema);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesiglas_sistema=new ParameterValue<String>();
					parameterMaintenanceValuesiglas_sistema.setValue(parametrogeneralsg.getsiglas_sistema());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesiglas_sistema);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemail_sistema=new ParameterValue<String>();
					parameterMaintenanceValuemail_sistema.setValue(parametrogeneralsg.getmail_sistema());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemail_sistema);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono_sistema=new ParameterValue<String>();
					parameterMaintenanceValuetelefono_sistema.setValue(parametrogeneralsg.gettelefono_sistema());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono_sistema);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuefax_sistema=new ParameterValue<String>();
					parameterMaintenanceValuefax_sistema.setValue(parametrogeneralsg.getfax_sistema());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefax_sistema);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuerepresentante_nombre=new ParameterValue<String>();
					parameterMaintenanceValuerepresentante_nombre.setValue(parametrogeneralsg.getrepresentante_nombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerepresentante_nombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_proceso_actualizacion=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_proceso_actualizacion.setValue(parametrogeneralsg.getcodigo_proceso_actualizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_proceso_actualizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(parametrogeneralsg.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrogeneralsg.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrogeneralsg.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrogeneralsg.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrogeneralsg.getId());
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
	
	public void setIsNewIsChangedFalseParametroGeneralSg(ParametroGeneralSg parametrogeneralsg)throws Exception  {		
		parametrogeneralsg.setIsNew(false);
		parametrogeneralsg.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroGeneralSgs(List<ParametroGeneralSg> parametrogeneralsgs)throws Exception  {				
		for(ParametroGeneralSg parametrogeneralsg:parametrogeneralsgs) {
			parametrogeneralsg.setIsNew(false);
			parametrogeneralsg.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroGeneralSg(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
