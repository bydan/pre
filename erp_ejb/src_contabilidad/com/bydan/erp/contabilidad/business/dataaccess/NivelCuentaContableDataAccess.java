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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//NivelCuentaContableConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class NivelCuentaContableDataAccess extends  NivelCuentaContableDataAccessAdditional{ //NivelCuentaContableDataAccessAdditional,DataAccessHelper<NivelCuentaContable>
	//static Logger logger = Logger.getLogger(NivelCuentaContableDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="nivel_cuenta_contable";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+"(version_row,id_empresa,nivel,numero_digitos)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nivel=?,numero_digitos=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select nivelcuentacontable from "+NivelCuentaContableConstantesFunciones.SPERSISTENCENAME+" nivelcuentacontable";
	public static String QUERYSELECTNATIVE="select "+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+".id,"+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+".version_row,"+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+".id_empresa,"+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+".nivel,"+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+".numero_digitos from "+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME;//+" as "+NivelCuentaContableConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+".id,"+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+".version_row from "+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME;//+" as "+NivelCuentaContableConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+NivelCuentaContableConstantesFunciones.SCHEMA+"."+NivelCuentaContableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nivel=?,numero_digitos=?";
	
	public static String STOREPROCEDUREINSERT="call SP_NIVELCUENTACONTABLE_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_NIVELCUENTACONTABLE_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_NIVELCUENTACONTABLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_NIVELCUENTACONTABLE_SELECT(?,?)";
	
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
	
	
	protected NivelCuentaContableDataAccessAdditional nivelcuentacontableDataAccessAdditional=null;
	
	public NivelCuentaContableDataAccessAdditional getNivelCuentaContableDataAccessAdditional() {
		return this.nivelcuentacontableDataAccessAdditional;
	}
	
	public void setNivelCuentaContableDataAccessAdditional(NivelCuentaContableDataAccessAdditional nivelcuentacontableDataAccessAdditional) {
		try {
			this.nivelcuentacontableDataAccessAdditional=nivelcuentacontableDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public NivelCuentaContableDataAccess() {
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
		NivelCuentaContableDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		NivelCuentaContableDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		NivelCuentaContableDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setNivelCuentaContableOriginal(NivelCuentaContable nivelcuentacontable)throws Exception  {
		nivelcuentacontable.setNivelCuentaContableOriginal((NivelCuentaContable)nivelcuentacontable.clone());		
	}
	
	public void setNivelCuentaContablesOriginal(List<NivelCuentaContable> nivelcuentacontables)throws Exception  {
		
		for(NivelCuentaContable nivelcuentacontable:nivelcuentacontables){
			nivelcuentacontable.setNivelCuentaContableOriginal((NivelCuentaContable)nivelcuentacontable.clone());
		}
	}
	
	public static void setNivelCuentaContableOriginalStatic(NivelCuentaContable nivelcuentacontable)throws Exception  {
		nivelcuentacontable.setNivelCuentaContableOriginal((NivelCuentaContable)nivelcuentacontable.clone());		
	}
	
	public static void setNivelCuentaContablesOriginalStatic(List<NivelCuentaContable> nivelcuentacontables)throws Exception  {
		
		for(NivelCuentaContable nivelcuentacontable:nivelcuentacontables){
			nivelcuentacontable.setNivelCuentaContableOriginal((NivelCuentaContable)nivelcuentacontable.clone());
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
	
	public  NivelCuentaContable getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		NivelCuentaContable entity = new NivelCuentaContable();		
		
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
	
	public  NivelCuentaContable getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		NivelCuentaContable entity = new NivelCuentaContable();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NivelCuentaContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NivelCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.NivelCuentaContable.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setNivelCuentaContableOriginal(new NivelCuentaContable());
      	    	entity=super.getEntity("",entity,resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNivelCuentaContable("",entity,resultSet); 
				
				//entity.setNivelCuentaContableOriginal(super.getEntity("",entity.getNivelCuentaContableOriginal(),resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNivelCuentaContableOriginal(this.getEntityNivelCuentaContable("",entity.getNivelCuentaContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseNivelCuentaContable(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  NivelCuentaContable getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NivelCuentaContable entity = new NivelCuentaContable();
				
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
	
	public  NivelCuentaContable getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NivelCuentaContable entity = new NivelCuentaContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NivelCuentaContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NivelCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NivelCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.NivelCuentaContable.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setNivelCuentaContableOriginal(new NivelCuentaContable());
      	    	entity=super.getEntity("",entity,resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNivelCuentaContable("",entity,resultSet);    
				
				//entity.setNivelCuentaContableOriginal(super.getEntity("",entity.getNivelCuentaContableOriginal(),resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNivelCuentaContableOriginal(this.getEntityNivelCuentaContable("",entity.getNivelCuentaContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseNivelCuentaContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //NivelCuentaContable
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		NivelCuentaContable entity = new NivelCuentaContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NivelCuentaContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NivelCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NivelCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.NivelCuentaContable.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseNivelCuentaContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<NivelCuentaContable> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NivelCuentaContable> entities = new  ArrayList<NivelCuentaContable>();
		NivelCuentaContable entity = new NivelCuentaContable();		  
		
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
	
	public  List<NivelCuentaContable> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NivelCuentaContable> entities = new  ArrayList<NivelCuentaContable>();
		NivelCuentaContable entity = new NivelCuentaContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=NivelCuentaContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NivelCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NivelCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NivelCuentaContable();
      	    	entity=super.getEntity("",entity,resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNivelCuentaContable("",entity,resultSet);
      	    	
				//entity.setNivelCuentaContableOriginal( new NivelCuentaContable());
      	    	//entity.setNivelCuentaContableOriginal(super.getEntity("",entity.getNivelCuentaContableOriginal(),resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNivelCuentaContableOriginal(this.getEntityNivelCuentaContable("",entity.getNivelCuentaContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNivelCuentaContables(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNivelCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NivelCuentaContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NivelCuentaContable> entities = new  ArrayList<NivelCuentaContable>();
		NivelCuentaContable entity = new NivelCuentaContable();		  
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
	
	public  List<NivelCuentaContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NivelCuentaContable> entities = new  ArrayList<NivelCuentaContable>();
		NivelCuentaContable entity = new NivelCuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NivelCuentaContable();
				
				if(conMapGenerico) {
					entity.inicializarMapNivelCuentaContable();
					//entity.setMapNivelCuentaContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapNivelCuentaContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNivelCuentaContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA);         		
					entity=NivelCuentaContableDataAccess.getEntityNivelCuentaContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNivelCuentaContableOriginal( new NivelCuentaContable());
					////entity.setNivelCuentaContableOriginal(super.getEntity("",entity.getNivelCuentaContableOriginal(),resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA));         		
					////entity.setNivelCuentaContableOriginal(this.getEntityNivelCuentaContable("",entity.getNivelCuentaContableOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNivelCuentaContables(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNivelCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public NivelCuentaContable getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NivelCuentaContable entity = new NivelCuentaContable();		  
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
	
	public  NivelCuentaContable getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NivelCuentaContable entity = new NivelCuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NivelCuentaContable();
				
				if(conMapGenerico) {
					entity.inicializarMapNivelCuentaContable();
					//entity.setMapNivelCuentaContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapNivelCuentaContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNivelCuentaContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA);         		
					entity=NivelCuentaContableDataAccess.getEntityNivelCuentaContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNivelCuentaContableOriginal( new NivelCuentaContable());
					////entity.setNivelCuentaContableOriginal(super.getEntity("",entity.getNivelCuentaContableOriginal(),resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA));         		
					////entity.setNivelCuentaContableOriginal(this.getEntityNivelCuentaContable("",entity.getNivelCuentaContableOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseNivelCuentaContable(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNivelCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static NivelCuentaContable getEntityNivelCuentaContable(String strPrefijo,NivelCuentaContable entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = NivelCuentaContable.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = NivelCuentaContable.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					NivelCuentaContableDataAccess.setFieldReflectionNivelCuentaContable(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasNivelCuentaContable=NivelCuentaContableConstantesFunciones.getTodosTiposColumnasNivelCuentaContable();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasNivelCuentaContable) {
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
							field = NivelCuentaContable.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = NivelCuentaContable.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						NivelCuentaContableDataAccess.setFieldReflectionNivelCuentaContable(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionNivelCuentaContable(Field field,String strPrefijo,String sColumn,NivelCuentaContable entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case NivelCuentaContableConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NivelCuentaContableConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NivelCuentaContableConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NivelCuentaContableConstantesFunciones.NIVEL:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NivelCuentaContableConstantesFunciones.NUMERODIGITOS:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NivelCuentaContable>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<NivelCuentaContable> entities = new  ArrayList<NivelCuentaContable>();
		NivelCuentaContable entity = new NivelCuentaContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NivelCuentaContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NivelCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NivelCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new NivelCuentaContable();
					entity=super.getEntity("",entity,resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityNivelCuentaContable("",entity,resultSet);
					
					//entity.setNivelCuentaContableOriginal( new NivelCuentaContable());
					//entity.setNivelCuentaContableOriginal(super.getEntity("",entity.getNivelCuentaContableOriginal(),resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA));         		
					//entity.setNivelCuentaContableOriginal(this.getEntityNivelCuentaContable("",entity.getNivelCuentaContableOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseNivelCuentaContables(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNivelCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NivelCuentaContable>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<NivelCuentaContable> entities = new  ArrayList<NivelCuentaContable>();
		NivelCuentaContable entity = new NivelCuentaContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NivelCuentaContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NivelCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NivelCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<NivelCuentaContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NivelCuentaContable> entities = new  ArrayList<NivelCuentaContable>();
		NivelCuentaContable entity = new NivelCuentaContable();		  
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
	
	public  List<NivelCuentaContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NivelCuentaContable> entities = new  ArrayList<NivelCuentaContable>();
		NivelCuentaContable entity = new NivelCuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NivelCuentaContable();
      	    	entity=super.getEntity("",entity,resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNivelCuentaContable("",entity,resultSet);
      	    	
				//entity.setNivelCuentaContableOriginal( new NivelCuentaContable());
      	    	//entity.setNivelCuentaContableOriginal(super.getEntity("",entity.getNivelCuentaContableOriginal(),resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNivelCuentaContableOriginal(this.getEntityNivelCuentaContable("",entity.getNivelCuentaContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseNivelCuentaContables(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNivelCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NivelCuentaContable> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NivelCuentaContable> entities = new  ArrayList<NivelCuentaContable>();
		NivelCuentaContable entity = new NivelCuentaContable();		  
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
	
	public  List<NivelCuentaContable> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NivelCuentaContable> entities = new  ArrayList<NivelCuentaContable>();
		NivelCuentaContable entity = new NivelCuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NivelCuentaContable();
      	    	entity=super.getEntity("",entity,resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNivelCuentaContable("",entity,resultSet);
      	    	
				//entity.setNivelCuentaContableOriginal( new NivelCuentaContable());
      	    	//entity.setNivelCuentaContableOriginal(super.getEntity("",entity.getNivelCuentaContableOriginal(),resultSet,NivelCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNivelCuentaContableOriginal(this.getEntityNivelCuentaContable("",entity.getNivelCuentaContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNivelCuentaContables(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public NivelCuentaContable getEntityNivelCuentaContable(String strPrefijo,NivelCuentaContable entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+NivelCuentaContableConstantesFunciones.IDEMPRESA));
				entity.setnivel(resultSet.getInt(strPrefijo+NivelCuentaContableConstantesFunciones.NIVEL));
				entity.setnumero_digitos(resultSet.getInt(strPrefijo+NivelCuentaContableConstantesFunciones.NUMERODIGITOS));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowNivelCuentaContable(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(NivelCuentaContable entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=NivelCuentaContableDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=NivelCuentaContableDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=NivelCuentaContableDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=NivelCuentaContableDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(NivelCuentaContableConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,NivelCuentaContableDataAccess.TABLENAME,NivelCuentaContableDataAccess.ISWITHSTOREPROCEDURES);
			
			NivelCuentaContableDataAccess.setNivelCuentaContableOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,NivelCuentaContable relnivelcuentacontable)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relnivelcuentacontable.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,NivelCuentaContable nivelcuentacontable) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!nivelcuentacontable.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(nivelcuentacontable.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenivel=new ParameterValue<Integer>();
					parameterMaintenanceValuenivel.setValue(nivelcuentacontable.getnivel());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenivel);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_digitos=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_digitos.setValue(nivelcuentacontable.getnumero_digitos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_digitos);
					parametersTemp.add(parameterMaintenance);
					
						if(!nivelcuentacontable.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(nivelcuentacontable.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(nivelcuentacontable.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(nivelcuentacontable.getId());
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
	
	public void setIsNewIsChangedFalseNivelCuentaContable(NivelCuentaContable nivelcuentacontable)throws Exception  {		
		nivelcuentacontable.setIsNew(false);
		nivelcuentacontable.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseNivelCuentaContables(List<NivelCuentaContable> nivelcuentacontables)throws Exception  {				
		for(NivelCuentaContable nivelcuentacontable:nivelcuentacontables) {
			nivelcuentacontable.setIsNew(false);
			nivelcuentacontable.setIsChanged(false);
		}
	}
	
	public void generarExportarNivelCuentaContable(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
