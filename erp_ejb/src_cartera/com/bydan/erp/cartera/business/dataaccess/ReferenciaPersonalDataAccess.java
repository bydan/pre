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
import com.bydan.erp.cartera.util.*;//ReferenciaPersonalConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ReferenciaPersonalDataAccess extends  ReferenciaPersonalDataAccessAdditional{ //ReferenciaPersonalDataAccessAdditional,DataAccessHelper<ReferenciaPersonal>
	//static Logger logger = Logger.getLogger(ReferenciaPersonalDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="referenciapersonal";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+"(version_row,id_empresa,idcliente,idvalorclientereferenciapersonal,id_pais,idciudad,nombre,identificacion,fecha_nacimiento,direccion,telefono,telefonomovil,telefonocodigoarea,preferencia,email,observacion,esta_trabajando,empresa_trabajo,direccion_trabajo,telefono_trabajo,esactivo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,idcliente=?,idvalorclientereferenciapersonal=?,id_pais=?,idciudad=?,nombre=?,identificacion=?,fecha_nacimiento=?,direccion=?,telefono=?,telefonomovil=?,telefonocodigoarea=?,preferencia=?,email=?,observacion=?,esta_trabajando=?,empresa_trabajo=?,direccion_trabajo=?,telefono_trabajo=?,esactivo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select referenciapersonal from "+ReferenciaPersonalConstantesFunciones.SPERSISTENCENAME+" referenciapersonal";
	public static String QUERYSELECTNATIVE="select "+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".id,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".version_row,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".id_empresa,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".idcliente,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".idvalorclientereferenciapersonal,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".id_pais,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".idciudad,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".nombre,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".identificacion,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".fecha_nacimiento,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".direccion,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".telefono,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".telefonomovil,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".telefonocodigoarea,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".preferencia,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".email,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".observacion,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".esta_trabajando,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".empresa_trabajo,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".direccion_trabajo,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".telefono_trabajo,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".esactivo from "+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME;//+" as "+ReferenciaPersonalConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".id,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".version_row,"+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+".nombre from "+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME;//+" as "+ReferenciaPersonalConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ReferenciaPersonalConstantesFunciones.SCHEMA+"."+ReferenciaPersonalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,idcliente=?,idvalorclientereferenciapersonal=?,id_pais=?,idciudad=?,nombre=?,identificacion=?,fecha_nacimiento=?,direccion=?,telefono=?,telefonomovil=?,telefonocodigoarea=?,preferencia=?,email=?,observacion=?,esta_trabajando=?,empresa_trabajo=?,direccion_trabajo=?,telefono_trabajo=?,esactivo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_REFERENCIAPERSONAL_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_REFERENCIAPERSONAL_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_REFERENCIAPERSONAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_REFERENCIAPERSONAL_SELECT(?,?)";
	
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
	
	
	protected ReferenciaPersonalDataAccessAdditional referenciapersonalDataAccessAdditional=null;
	
	public ReferenciaPersonalDataAccessAdditional getReferenciaPersonalDataAccessAdditional() {
		return this.referenciapersonalDataAccessAdditional;
	}
	
	public void setReferenciaPersonalDataAccessAdditional(ReferenciaPersonalDataAccessAdditional referenciapersonalDataAccessAdditional) {
		try {
			this.referenciapersonalDataAccessAdditional=referenciapersonalDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ReferenciaPersonalDataAccess() {
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
		ReferenciaPersonalDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ReferenciaPersonalDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ReferenciaPersonalDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setReferenciaPersonalOriginal(ReferenciaPersonal referenciapersonal)throws Exception  {
		referenciapersonal.setReferenciaPersonalOriginal((ReferenciaPersonal)referenciapersonal.clone());		
	}
	
	public void setReferenciaPersonalsOriginal(List<ReferenciaPersonal> referenciapersonals)throws Exception  {
		
		for(ReferenciaPersonal referenciapersonal:referenciapersonals){
			referenciapersonal.setReferenciaPersonalOriginal((ReferenciaPersonal)referenciapersonal.clone());
		}
	}
	
	public static void setReferenciaPersonalOriginalStatic(ReferenciaPersonal referenciapersonal)throws Exception  {
		referenciapersonal.setReferenciaPersonalOriginal((ReferenciaPersonal)referenciapersonal.clone());		
	}
	
	public static void setReferenciaPersonalsOriginalStatic(List<ReferenciaPersonal> referenciapersonals)throws Exception  {
		
		for(ReferenciaPersonal referenciapersonal:referenciapersonals){
			referenciapersonal.setReferenciaPersonalOriginal((ReferenciaPersonal)referenciapersonal.clone());
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
	
	public  ReferenciaPersonal getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ReferenciaPersonal entity = new ReferenciaPersonal();		
		
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
	
	public  ReferenciaPersonal getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ReferenciaPersonal entity = new ReferenciaPersonal();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ReferenciaPersonalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ReferenciaPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.ReferenciaPersonal.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setReferenciaPersonalOriginal(new ReferenciaPersonal());
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityReferenciaPersonal("",entity,resultSet); 
				
				//entity.setReferenciaPersonalOriginal(super.getEntity("",entity.getReferenciaPersonalOriginal(),resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaPersonalOriginal(this.getEntityReferenciaPersonal("",entity.getReferenciaPersonalOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseReferenciaPersonal(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ReferenciaPersonal getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ReferenciaPersonal entity = new ReferenciaPersonal();
				
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
	
	public  ReferenciaPersonal getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ReferenciaPersonal entity = new ReferenciaPersonal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ReferenciaPersonalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ReferenciaPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ReferenciaPersonal.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setReferenciaPersonalOriginal(new ReferenciaPersonal());
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityReferenciaPersonal("",entity,resultSet);    
				
				//entity.setReferenciaPersonalOriginal(super.getEntity("",entity.getReferenciaPersonalOriginal(),resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaPersonalOriginal(this.getEntityReferenciaPersonal("",entity.getReferenciaPersonalOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseReferenciaPersonal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ReferenciaPersonal
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ReferenciaPersonal entity = new ReferenciaPersonal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ReferenciaPersonalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ReferenciaPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ReferenciaPersonal.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseReferenciaPersonal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ReferenciaPersonal> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ReferenciaPersonal> entities = new  ArrayList<ReferenciaPersonal>();
		ReferenciaPersonal entity = new ReferenciaPersonal();		  
		
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
	
	public  List<ReferenciaPersonal> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ReferenciaPersonal> entities = new  ArrayList<ReferenciaPersonal>();
		ReferenciaPersonal entity = new ReferenciaPersonal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ReferenciaPersonalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ReferenciaPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaPersonal();
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityReferenciaPersonal("",entity,resultSet);
      	    	
				//entity.setReferenciaPersonalOriginal( new ReferenciaPersonal());
      	    	//entity.setReferenciaPersonalOriginal(super.getEntity("",entity.getReferenciaPersonalOriginal(),resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaPersonalOriginal(this.getEntityReferenciaPersonal("",entity.getReferenciaPersonalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseReferenciaPersonals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaPersonal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ReferenciaPersonal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ReferenciaPersonal> entities = new  ArrayList<ReferenciaPersonal>();
		ReferenciaPersonal entity = new ReferenciaPersonal();		  
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
	
	public  List<ReferenciaPersonal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ReferenciaPersonal> entities = new  ArrayList<ReferenciaPersonal>();
		ReferenciaPersonal entity = new ReferenciaPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaPersonal();
				
				if(conMapGenerico) {
					entity.inicializarMapReferenciaPersonal();
					//entity.setMapReferenciaPersonal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapReferenciaPersonalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapReferenciaPersonal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA);         		
					entity=ReferenciaPersonalDataAccess.getEntityReferenciaPersonal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setReferenciaPersonalOriginal( new ReferenciaPersonal());
					////entity.setReferenciaPersonalOriginal(super.getEntity("",entity.getReferenciaPersonalOriginal(),resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA));         		
					////entity.setReferenciaPersonalOriginal(this.getEntityReferenciaPersonal("",entity.getReferenciaPersonalOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseReferenciaPersonals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaPersonal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ReferenciaPersonal getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ReferenciaPersonal entity = new ReferenciaPersonal();		  
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
	
	public  ReferenciaPersonal getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ReferenciaPersonal entity = new ReferenciaPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaPersonal();
				
				if(conMapGenerico) {
					entity.inicializarMapReferenciaPersonal();
					//entity.setMapReferenciaPersonal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapReferenciaPersonalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapReferenciaPersonal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA);         		
					entity=ReferenciaPersonalDataAccess.getEntityReferenciaPersonal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setReferenciaPersonalOriginal( new ReferenciaPersonal());
					////entity.setReferenciaPersonalOriginal(super.getEntity("",entity.getReferenciaPersonalOriginal(),resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA));         		
					////entity.setReferenciaPersonalOriginal(this.getEntityReferenciaPersonal("",entity.getReferenciaPersonalOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseReferenciaPersonal(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaPersonal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ReferenciaPersonal getEntityReferenciaPersonal(String strPrefijo,ReferenciaPersonal entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ReferenciaPersonal.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ReferenciaPersonal.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ReferenciaPersonalDataAccess.setFieldReflectionReferenciaPersonal(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasReferenciaPersonal=ReferenciaPersonalConstantesFunciones.getTodosTiposColumnasReferenciaPersonal();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasReferenciaPersonal) {
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
							field = ReferenciaPersonal.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ReferenciaPersonal.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ReferenciaPersonalDataAccess.setFieldReflectionReferenciaPersonal(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionReferenciaPersonal(Field field,String strPrefijo,String sColumn,ReferenciaPersonal entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ReferenciaPersonalConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.IDTIPOREFEPERSO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.IDENTIFICACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.FECHANACIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ReferenciaPersonalConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.TELEFONOMOVIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.TELEFONOCODIGOAREA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.PREFERENCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.EMAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.OBSERVACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.ESTATRABAJANDO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.EMPRESATRABAJO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.DIRECCIONTRABAJO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.TELEFONOTRABAJO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReferenciaPersonalConstantesFunciones.ESACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ReferenciaPersonal>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ReferenciaPersonal> entities = new  ArrayList<ReferenciaPersonal>();
		ReferenciaPersonal entity = new ReferenciaPersonal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ReferenciaPersonalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ReferenciaPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ReferenciaPersonal();
					entity=super.getEntity("",entity,resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityReferenciaPersonal("",entity,resultSet);
					
					//entity.setReferenciaPersonalOriginal( new ReferenciaPersonal());
					//entity.setReferenciaPersonalOriginal(super.getEntity("",entity.getReferenciaPersonalOriginal(),resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA));         		
					//entity.setReferenciaPersonalOriginal(this.getEntityReferenciaPersonal("",entity.getReferenciaPersonalOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseReferenciaPersonals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaPersonal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ReferenciaPersonal>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ReferenciaPersonal> entities = new  ArrayList<ReferenciaPersonal>();
		ReferenciaPersonal entity = new ReferenciaPersonal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ReferenciaPersonalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ReferenciaPersonalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReferenciaPersonalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ReferenciaPersonal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReferenciaPersonal> entities = new  ArrayList<ReferenciaPersonal>();
		ReferenciaPersonal entity = new ReferenciaPersonal();		  
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
	
	public  List<ReferenciaPersonal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReferenciaPersonal> entities = new  ArrayList<ReferenciaPersonal>();
		ReferenciaPersonal entity = new ReferenciaPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaPersonal();
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityReferenciaPersonal("",entity,resultSet);
      	    	
				//entity.setReferenciaPersonalOriginal( new ReferenciaPersonal());
      	    	//entity.setReferenciaPersonalOriginal(super.getEntity("",entity.getReferenciaPersonalOriginal(),resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaPersonalOriginal(this.getEntityReferenciaPersonal("",entity.getReferenciaPersonalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseReferenciaPersonals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReferenciaPersonal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ReferenciaPersonal> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReferenciaPersonal> entities = new  ArrayList<ReferenciaPersonal>();
		ReferenciaPersonal entity = new ReferenciaPersonal();		  
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
	
	public  List<ReferenciaPersonal> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReferenciaPersonal> entities = new  ArrayList<ReferenciaPersonal>();
		ReferenciaPersonal entity = new ReferenciaPersonal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReferenciaPersonal();
      	    	entity=super.getEntity("",entity,resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityReferenciaPersonal("",entity,resultSet);
      	    	
				//entity.setReferenciaPersonalOriginal( new ReferenciaPersonal());
      	    	//entity.setReferenciaPersonalOriginal(super.getEntity("",entity.getReferenciaPersonalOriginal(),resultSet,ReferenciaPersonalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReferenciaPersonalOriginal(this.getEntityReferenciaPersonal("",entity.getReferenciaPersonalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseReferenciaPersonals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ReferenciaPersonal getEntityReferenciaPersonal(String strPrefijo,ReferenciaPersonal entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ReferenciaPersonalConstantesFunciones.IDEMPRESA));
				entity.setidcliente(resultSet.getLong(strPrefijo+ReferenciaPersonalConstantesFunciones.IDCLIENTE));
				entity.setidvalorclientereferenciapersonal(resultSet.getLong(strPrefijo+ReferenciaPersonalConstantesFunciones.IDTIPOREFEPERSO));
				entity.setid_pais(resultSet.getLong(strPrefijo+ReferenciaPersonalConstantesFunciones.IDPAIS));
				entity.setidciudad(resultSet.getLong(strPrefijo+ReferenciaPersonalConstantesFunciones.IDCIUDAD));
				entity.setnombre(resultSet.getString(strPrefijo+ReferenciaPersonalConstantesFunciones.NOMBRE));
				entity.setidentificacion(resultSet.getString(strPrefijo+ReferenciaPersonalConstantesFunciones.IDENTIFICACION));
				entity.setfecha_nacimiento(new Date(resultSet.getDate(strPrefijo+ReferenciaPersonalConstantesFunciones.FECHANACIMIENTO).getTime()));
				entity.setdireccion(resultSet.getString(strPrefijo+ReferenciaPersonalConstantesFunciones.DIRECCION));
				entity.settelefono(resultSet.getString(strPrefijo+ReferenciaPersonalConstantesFunciones.TELEFONO));
				entity.settelefonomovil(resultSet.getString(strPrefijo+ReferenciaPersonalConstantesFunciones.TELEFONOMOVIL));
				entity.settelefonocodigoarea(resultSet.getString(strPrefijo+ReferenciaPersonalConstantesFunciones.TELEFONOCODIGOAREA));
				entity.setpreferencia(resultSet.getString(strPrefijo+ReferenciaPersonalConstantesFunciones.PREFERENCIA));
				entity.setemail(resultSet.getString(strPrefijo+ReferenciaPersonalConstantesFunciones.EMAIL));
				entity.setobservacion(resultSet.getString(strPrefijo+ReferenciaPersonalConstantesFunciones.OBSERVACION));
				entity.setesta_trabajando(resultSet.getBoolean(strPrefijo+ReferenciaPersonalConstantesFunciones.ESTATRABAJANDO));
				entity.setempresa_trabajo(resultSet.getString(strPrefijo+ReferenciaPersonalConstantesFunciones.EMPRESATRABAJO));
				entity.setdireccion_trabajo(resultSet.getString(strPrefijo+ReferenciaPersonalConstantesFunciones.DIRECCIONTRABAJO));
				entity.settelefono_trabajo(resultSet.getString(strPrefijo+ReferenciaPersonalConstantesFunciones.TELEFONOTRABAJO));
				entity.setesactivo(resultSet.getBoolean(strPrefijo+ReferenciaPersonalConstantesFunciones.ESACTIVO));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+ReferenciaPersonalConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowReferenciaPersonal(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ReferenciaPersonal entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ReferenciaPersonalDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ReferenciaPersonalDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ReferenciaPersonalDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ReferenciaPersonalDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ReferenciaPersonalConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ReferenciaPersonalDataAccess.TABLENAME,ReferenciaPersonalDataAccess.ISWITHSTOREPROCEDURES);
			
			ReferenciaPersonalDataAccess.setReferenciaPersonalOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ReferenciaPersonal relreferenciapersonal)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relreferenciapersonal.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,ReferenciaPersonal relreferenciapersonal)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relreferenciapersonal.getidcliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoRefePerso getTipoRefePerso(Connexion connexion,ReferenciaPersonal relreferenciapersonal)throws SQLException,Exception {

		TipoRefePerso tiporefeperso= new TipoRefePerso();

		try {
			TipoRefePersoDataAccess tiporefepersoDataAccess=new TipoRefePersoDataAccess();

			tiporefepersoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporefepersoDataAccess.setConnexionType(this.connexionType);
			tiporefepersoDataAccess.setParameterDbType(this.parameterDbType);

			tiporefeperso=tiporefepersoDataAccess.getEntity(connexion,relreferenciapersonal.getidvalorclientereferenciapersonal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporefeperso;

	}

	public Pais getPais(Connexion connexion,ReferenciaPersonal relreferenciapersonal)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relreferenciapersonal.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,ReferenciaPersonal relreferenciapersonal)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relreferenciapersonal.getidciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ReferenciaPersonal referenciapersonal) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!referenciapersonal.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(referenciapersonal.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidcliente=new ParameterValue<Long>();
					parameterMaintenanceValueidcliente.setValue(referenciapersonal.getidcliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidcliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorclientereferenciapersonal=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorclientereferenciapersonal.setValue(referenciapersonal.getidvalorclientereferenciapersonal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorclientereferenciapersonal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(referenciapersonal.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidciudad=new ParameterValue<Long>();
					parameterMaintenanceValueidciudad.setValue(referenciapersonal.getidciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(referenciapersonal.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueidentificacion=new ParameterValue<String>();
					parameterMaintenanceValueidentificacion.setValue(referenciapersonal.getidentificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidentificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_nacimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_nacimiento.setValue(referenciapersonal.getfecha_nacimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_nacimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(referenciapersonal.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(referenciapersonal.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefonomovil=new ParameterValue<String>();
					parameterMaintenanceValuetelefonomovil.setValue(referenciapersonal.gettelefonomovil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefonomovil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefonocodigoarea=new ParameterValue<String>();
					parameterMaintenanceValuetelefonocodigoarea.setValue(referenciapersonal.gettelefonocodigoarea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefonocodigoarea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepreferencia=new ParameterValue<String>();
					parameterMaintenanceValuepreferencia.setValue(referenciapersonal.getpreferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepreferencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueemail=new ParameterValue<String>();
					parameterMaintenanceValueemail.setValue(referenciapersonal.getemail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueemail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion=new ParameterValue<String>();
					parameterMaintenanceValueobservacion.setValue(referenciapersonal.getobservacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_trabajando=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_trabajando.setValue(referenciapersonal.getesta_trabajando());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_trabajando);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueempresa_trabajo=new ParameterValue<String>();
					parameterMaintenanceValueempresa_trabajo.setValue(referenciapersonal.getempresa_trabajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueempresa_trabajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion_trabajo=new ParameterValue<String>();
					parameterMaintenanceValuedireccion_trabajo.setValue(referenciapersonal.getdireccion_trabajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion_trabajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono_trabajo=new ParameterValue<String>();
					parameterMaintenanceValuetelefono_trabajo.setValue(referenciapersonal.gettelefono_trabajo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono_trabajo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesactivo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesactivo.setValue(referenciapersonal.getesactivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesactivo);
					parametersTemp.add(parameterMaintenance);
					
						if(!referenciapersonal.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(referenciapersonal.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(referenciapersonal.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(referenciapersonal.getId());
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
	
	public void setIsNewIsChangedFalseReferenciaPersonal(ReferenciaPersonal referenciapersonal)throws Exception  {		
		referenciapersonal.setIsNew(false);
		referenciapersonal.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseReferenciaPersonals(List<ReferenciaPersonal> referenciapersonals)throws Exception  {				
		for(ReferenciaPersonal referenciapersonal:referenciapersonals) {
			referenciapersonal.setIsNew(false);
			referenciapersonal.setIsChanged(false);
		}
	}
	
	public void generarExportarReferenciaPersonal(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
