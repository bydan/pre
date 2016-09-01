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
import com.bydan.erp.cartera.util.*;//InformacionLaboralConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class InformacionLaboralDataAccess extends  InformacionLaboralDataAccessAdditional{ //InformacionLaboralDataAccessAdditional,DataAccessHelper<InformacionLaboral>
	//static Logger logger = Logger.getLogger(InformacionLaboralDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="informacionlaboral";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+"(version_row,idcliente,idvalorempresa,idvalorclienterelacionlaboral,idvalorclientearealaboral,idvalorclientecargolaboral,id_pais,idciudad,tiempoa,tiempom,nombreempresa,direccion,nombrereferencia,telefono,telefonocodigoarea,telefonomovil,email,esactivo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+" set version_row=current_timestamp,idcliente=?,idvalorempresa=?,idvalorclienterelacionlaboral=?,idvalorclientearealaboral=?,idvalorclientecargolaboral=?,id_pais=?,idciudad=?,tiempoa=?,tiempom=?,nombreempresa=?,direccion=?,nombrereferencia=?,telefono=?,telefonocodigoarea=?,telefonomovil=?,email=?,esactivo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select informacionlaboral from "+InformacionLaboralConstantesFunciones.SPERSISTENCENAME+" informacionlaboral";
	public static String QUERYSELECTNATIVE="select "+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".id,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".version_row,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".idcliente,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".idvalorempresa,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".idvalorclienterelacionlaboral,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".idvalorclientearealaboral,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".idvalorclientecargolaboral,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".id_pais,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".idciudad,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".tiempoa,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".tiempom,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".nombreempresa,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".direccion,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".nombrereferencia,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".telefono,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".telefonocodigoarea,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".telefonomovil,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".email,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".esactivo from "+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME;//+" as "+InformacionLaboralConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".id,"+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+".version_row from "+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME;//+" as "+InformacionLaboralConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+InformacionLaboralConstantesFunciones.SCHEMA+"."+InformacionLaboralConstantesFunciones.TABLENAME+" set version_row=current_timestamp,idcliente=?,idvalorempresa=?,idvalorclienterelacionlaboral=?,idvalorclientearealaboral=?,idvalorclientecargolaboral=?,id_pais=?,idciudad=?,tiempoa=?,tiempom=?,nombreempresa=?,direccion=?,nombrereferencia=?,telefono=?,telefonocodigoarea=?,telefonomovil=?,email=?,esactivo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_INFORMACIONLABORAL_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_INFORMACIONLABORAL_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_INFORMACIONLABORAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_INFORMACIONLABORAL_SELECT(?,?)";
	
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
	
	
	protected InformacionLaboralDataAccessAdditional informacionlaboralDataAccessAdditional=null;
	
	public InformacionLaboralDataAccessAdditional getInformacionLaboralDataAccessAdditional() {
		return this.informacionlaboralDataAccessAdditional;
	}
	
	public void setInformacionLaboralDataAccessAdditional(InformacionLaboralDataAccessAdditional informacionlaboralDataAccessAdditional) {
		try {
			this.informacionlaboralDataAccessAdditional=informacionlaboralDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public InformacionLaboralDataAccess() {
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
		InformacionLaboralDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		InformacionLaboralDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		InformacionLaboralDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setInformacionLaboralOriginal(InformacionLaboral informacionlaboral)throws Exception  {
		informacionlaboral.setInformacionLaboralOriginal((InformacionLaboral)informacionlaboral.clone());		
	}
	
	public void setInformacionLaboralsOriginal(List<InformacionLaboral> informacionlaborals)throws Exception  {
		
		for(InformacionLaboral informacionlaboral:informacionlaborals){
			informacionlaboral.setInformacionLaboralOriginal((InformacionLaboral)informacionlaboral.clone());
		}
	}
	
	public static void setInformacionLaboralOriginalStatic(InformacionLaboral informacionlaboral)throws Exception  {
		informacionlaboral.setInformacionLaboralOriginal((InformacionLaboral)informacionlaboral.clone());		
	}
	
	public static void setInformacionLaboralsOriginalStatic(List<InformacionLaboral> informacionlaborals)throws Exception  {
		
		for(InformacionLaboral informacionlaboral:informacionlaborals){
			informacionlaboral.setInformacionLaboralOriginal((InformacionLaboral)informacionlaboral.clone());
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
	
	public  InformacionLaboral getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		InformacionLaboral entity = new InformacionLaboral();		
		
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
	
	public  InformacionLaboral getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		InformacionLaboral entity = new InformacionLaboral();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=InformacionLaboralDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=InformacionLaboralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.InformacionLaboral.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setInformacionLaboralOriginal(new InformacionLaboral());
      	    	entity=super.getEntity("",entity,resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityInformacionLaboral("",entity,resultSet); 
				
				//entity.setInformacionLaboralOriginal(super.getEntity("",entity.getInformacionLaboralOriginal(),resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionLaboralOriginal(this.getEntityInformacionLaboral("",entity.getInformacionLaboralOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseInformacionLaboral(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  InformacionLaboral getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		InformacionLaboral entity = new InformacionLaboral();
				
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
	
	public  InformacionLaboral getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		InformacionLaboral entity = new InformacionLaboral();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=InformacionLaboralDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=InformacionLaboralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionLaboralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.InformacionLaboral.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setInformacionLaboralOriginal(new InformacionLaboral());
      	    	entity=super.getEntity("",entity,resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityInformacionLaboral("",entity,resultSet);    
				
				//entity.setInformacionLaboralOriginal(super.getEntity("",entity.getInformacionLaboralOriginal(),resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionLaboralOriginal(this.getEntityInformacionLaboral("",entity.getInformacionLaboralOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseInformacionLaboral(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //InformacionLaboral
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		InformacionLaboral entity = new InformacionLaboral();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=InformacionLaboralDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=InformacionLaboralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionLaboralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.InformacionLaboral.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseInformacionLaboral(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<InformacionLaboral> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<InformacionLaboral> entities = new  ArrayList<InformacionLaboral>();
		InformacionLaboral entity = new InformacionLaboral();		  
		
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
	
	public  List<InformacionLaboral> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<InformacionLaboral> entities = new  ArrayList<InformacionLaboral>();
		InformacionLaboral entity = new InformacionLaboral();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=InformacionLaboralDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=InformacionLaboralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionLaboralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionLaboral();
      	    	entity=super.getEntity("",entity,resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityInformacionLaboral("",entity,resultSet);
      	    	
				//entity.setInformacionLaboralOriginal( new InformacionLaboral());
      	    	//entity.setInformacionLaboralOriginal(super.getEntity("",entity.getInformacionLaboralOriginal(),resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionLaboralOriginal(this.getEntityInformacionLaboral("",entity.getInformacionLaboralOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseInformacionLaborals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionLaboral(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<InformacionLaboral> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<InformacionLaboral> entities = new  ArrayList<InformacionLaboral>();
		InformacionLaboral entity = new InformacionLaboral();		  
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
	
	public  List<InformacionLaboral> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<InformacionLaboral> entities = new  ArrayList<InformacionLaboral>();
		InformacionLaboral entity = new InformacionLaboral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionLaboral();
				
				if(conMapGenerico) {
					entity.inicializarMapInformacionLaboral();
					//entity.setMapInformacionLaboral(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapInformacionLaboralValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapInformacionLaboral().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA);         		
					entity=InformacionLaboralDataAccess.getEntityInformacionLaboral("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setInformacionLaboralOriginal( new InformacionLaboral());
					////entity.setInformacionLaboralOriginal(super.getEntity("",entity.getInformacionLaboralOriginal(),resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA));         		
					////entity.setInformacionLaboralOriginal(this.getEntityInformacionLaboral("",entity.getInformacionLaboralOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseInformacionLaborals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionLaboral(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public InformacionLaboral getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		InformacionLaboral entity = new InformacionLaboral();		  
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
	
	public  InformacionLaboral getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		InformacionLaboral entity = new InformacionLaboral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionLaboral();
				
				if(conMapGenerico) {
					entity.inicializarMapInformacionLaboral();
					//entity.setMapInformacionLaboral(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapInformacionLaboralValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapInformacionLaboral().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA);         		
					entity=InformacionLaboralDataAccess.getEntityInformacionLaboral("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setInformacionLaboralOriginal( new InformacionLaboral());
					////entity.setInformacionLaboralOriginal(super.getEntity("",entity.getInformacionLaboralOriginal(),resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA));         		
					////entity.setInformacionLaboralOriginal(this.getEntityInformacionLaboral("",entity.getInformacionLaboralOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseInformacionLaboral(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionLaboral(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static InformacionLaboral getEntityInformacionLaboral(String strPrefijo,InformacionLaboral entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = InformacionLaboral.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = InformacionLaboral.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					InformacionLaboralDataAccess.setFieldReflectionInformacionLaboral(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasInformacionLaboral=InformacionLaboralConstantesFunciones.getTodosTiposColumnasInformacionLaboral();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasInformacionLaboral) {
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
							field = InformacionLaboral.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = InformacionLaboral.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						InformacionLaboralDataAccess.setFieldReflectionInformacionLaboral(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionInformacionLaboral(Field field,String strPrefijo,String sColumn,InformacionLaboral entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case InformacionLaboralConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.IDTIPOEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.IDTIPORELALABO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.IDTIPOAREALABO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.IDTIPOCARGOLABO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.TIEMPOA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.TIEMPOM:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.NOMBREEMPRESA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.NOMBREREFERENCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.TELEFONOCODIGOAREA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.TELEFONOMOVIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.EMAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionLaboralConstantesFunciones.ESACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<InformacionLaboral>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<InformacionLaboral> entities = new  ArrayList<InformacionLaboral>();
		InformacionLaboral entity = new InformacionLaboral();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=InformacionLaboralDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=InformacionLaboralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionLaboralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new InformacionLaboral();
					entity=super.getEntity("",entity,resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityInformacionLaboral("",entity,resultSet);
					
					//entity.setInformacionLaboralOriginal( new InformacionLaboral());
					//entity.setInformacionLaboralOriginal(super.getEntity("",entity.getInformacionLaboralOriginal(),resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA));         		
					//entity.setInformacionLaboralOriginal(this.getEntityInformacionLaboral("",entity.getInformacionLaboralOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseInformacionLaborals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionLaboral(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<InformacionLaboral>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<InformacionLaboral> entities = new  ArrayList<InformacionLaboral>();
		InformacionLaboral entity = new InformacionLaboral();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=InformacionLaboralDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=InformacionLaboralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionLaboralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<InformacionLaboral> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<InformacionLaboral> entities = new  ArrayList<InformacionLaboral>();
		InformacionLaboral entity = new InformacionLaboral();		  
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
	
	public  List<InformacionLaboral> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<InformacionLaboral> entities = new  ArrayList<InformacionLaboral>();
		InformacionLaboral entity = new InformacionLaboral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionLaboral();
      	    	entity=super.getEntity("",entity,resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityInformacionLaboral("",entity,resultSet);
      	    	
				//entity.setInformacionLaboralOriginal( new InformacionLaboral());
      	    	//entity.setInformacionLaboralOriginal(super.getEntity("",entity.getInformacionLaboralOriginal(),resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionLaboralOriginal(this.getEntityInformacionLaboral("",entity.getInformacionLaboralOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseInformacionLaborals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionLaboral(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<InformacionLaboral> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<InformacionLaboral> entities = new  ArrayList<InformacionLaboral>();
		InformacionLaboral entity = new InformacionLaboral();		  
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
	
	public  List<InformacionLaboral> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<InformacionLaboral> entities = new  ArrayList<InformacionLaboral>();
		InformacionLaboral entity = new InformacionLaboral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionLaboral();
      	    	entity=super.getEntity("",entity,resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityInformacionLaboral("",entity,resultSet);
      	    	
				//entity.setInformacionLaboralOriginal( new InformacionLaboral());
      	    	//entity.setInformacionLaboralOriginal(super.getEntity("",entity.getInformacionLaboralOriginal(),resultSet,InformacionLaboralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionLaboralOriginal(this.getEntityInformacionLaboral("",entity.getInformacionLaboralOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseInformacionLaborals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public InformacionLaboral getEntityInformacionLaboral(String strPrefijo,InformacionLaboral entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setidcliente(resultSet.getLong(strPrefijo+InformacionLaboralConstantesFunciones.IDCLIENTE));
				entity.setidvalorempresa(resultSet.getLong(strPrefijo+InformacionLaboralConstantesFunciones.IDTIPOEMPRESA));
				entity.setidvalorclienterelacionlaboral(resultSet.getLong(strPrefijo+InformacionLaboralConstantesFunciones.IDTIPORELALABO));
				entity.setidvalorclientearealaboral(resultSet.getLong(strPrefijo+InformacionLaboralConstantesFunciones.IDTIPOAREALABO));
				entity.setidvalorclientecargolaboral(resultSet.getLong(strPrefijo+InformacionLaboralConstantesFunciones.IDTIPOCARGOLABO));
				entity.setid_pais(resultSet.getLong(strPrefijo+InformacionLaboralConstantesFunciones.IDPAIS));
				entity.setidciudad(resultSet.getLong(strPrefijo+InformacionLaboralConstantesFunciones.IDCIUDAD));
				entity.settiempoa(resultSet.getInt(strPrefijo+InformacionLaboralConstantesFunciones.TIEMPOA));
				entity.settiempom(resultSet.getInt(strPrefijo+InformacionLaboralConstantesFunciones.TIEMPOM));
				entity.setnombreempresa(resultSet.getString(strPrefijo+InformacionLaboralConstantesFunciones.NOMBREEMPRESA));
				entity.setdireccion(resultSet.getString(strPrefijo+InformacionLaboralConstantesFunciones.DIRECCION));
				entity.setnombrereferencia(resultSet.getString(strPrefijo+InformacionLaboralConstantesFunciones.NOMBREREFERENCIA));
				entity.settelefono(resultSet.getString(strPrefijo+InformacionLaboralConstantesFunciones.TELEFONO));
				entity.settelefonocodigoarea(resultSet.getString(strPrefijo+InformacionLaboralConstantesFunciones.TELEFONOCODIGOAREA));
				entity.settelefonomovil(resultSet.getString(strPrefijo+InformacionLaboralConstantesFunciones.TELEFONOMOVIL));
				entity.setemail(resultSet.getString(strPrefijo+InformacionLaboralConstantesFunciones.EMAIL));
				entity.setesactivo(resultSet.getBoolean(strPrefijo+InformacionLaboralConstantesFunciones.ESACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowInformacionLaboral(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(InformacionLaboral entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=InformacionLaboralDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=InformacionLaboralDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=InformacionLaboralDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=InformacionLaboralDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(InformacionLaboralConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,InformacionLaboralDataAccess.TABLENAME,InformacionLaboralDataAccess.ISWITHSTOREPROCEDURES);
			
			InformacionLaboralDataAccess.setInformacionLaboralOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Cliente getCliente(Connexion connexion,InformacionLaboral relinformacionlaboral)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relinformacionlaboral.getidcliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoEmpresa getTipoEmpresa(Connexion connexion,InformacionLaboral relinformacionlaboral)throws SQLException,Exception {

		TipoEmpresa tipoempresa= new TipoEmpresa();

		try {
			TipoEmpresaDataAccess tipoempresaDataAccess=new TipoEmpresaDataAccess();

			tipoempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoempresaDataAccess.setConnexionType(this.connexionType);
			tipoempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipoempresa=tipoempresaDataAccess.getEntity(connexion,relinformacionlaboral.getidvalorempresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoempresa;

	}

	public TipoRelaLabo getTipoRelaLabo(Connexion connexion,InformacionLaboral relinformacionlaboral)throws SQLException,Exception {

		TipoRelaLabo tiporelalabo= new TipoRelaLabo();

		try {
			TipoRelaLaboDataAccess tiporelalaboDataAccess=new TipoRelaLaboDataAccess();

			tiporelalaboDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporelalaboDataAccess.setConnexionType(this.connexionType);
			tiporelalaboDataAccess.setParameterDbType(this.parameterDbType);

			tiporelalabo=tiporelalaboDataAccess.getEntity(connexion,relinformacionlaboral.getidvalorclienterelacionlaboral());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporelalabo;

	}

	public TipoAreaLabo getTipoAreaLabo(Connexion connexion,InformacionLaboral relinformacionlaboral)throws SQLException,Exception {

		TipoAreaLabo tipoarealabo= new TipoAreaLabo();

		try {
			TipoAreaLaboDataAccess tipoarealaboDataAccess=new TipoAreaLaboDataAccess();

			tipoarealaboDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoarealaboDataAccess.setConnexionType(this.connexionType);
			tipoarealaboDataAccess.setParameterDbType(this.parameterDbType);

			tipoarealabo=tipoarealaboDataAccess.getEntity(connexion,relinformacionlaboral.getidvalorclientearealaboral());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoarealabo;

	}

	public TipoCargoLabo getTipoCargoLabo(Connexion connexion,InformacionLaboral relinformacionlaboral)throws SQLException,Exception {

		TipoCargoLabo tipocargolabo= new TipoCargoLabo();

		try {
			TipoCargoLaboDataAccess tipocargolaboDataAccess=new TipoCargoLaboDataAccess();

			tipocargolaboDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocargolaboDataAccess.setConnexionType(this.connexionType);
			tipocargolaboDataAccess.setParameterDbType(this.parameterDbType);

			tipocargolabo=tipocargolaboDataAccess.getEntity(connexion,relinformacionlaboral.getidvalorclientecargolaboral());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocargolabo;

	}

	public Pais getPais(Connexion connexion,InformacionLaboral relinformacionlaboral)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relinformacionlaboral.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,InformacionLaboral relinformacionlaboral)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relinformacionlaboral.getidciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,InformacionLaboral informacionlaboral) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!informacionlaboral.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidcliente=new ParameterValue<Long>();
					parameterMaintenanceValueidcliente.setValue(informacionlaboral.getidcliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidcliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorempresa=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorempresa.setValue(informacionlaboral.getidvalorempresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorempresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorclienterelacionlaboral=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorclienterelacionlaboral.setValue(informacionlaboral.getidvalorclienterelacionlaboral());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorclienterelacionlaboral);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorclientearealaboral=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorclientearealaboral.setValue(informacionlaboral.getidvalorclientearealaboral());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorclientearealaboral);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorclientecargolaboral=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorclientecargolaboral.setValue(informacionlaboral.getidvalorclientecargolaboral());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorclientecargolaboral);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(informacionlaboral.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidciudad=new ParameterValue<Long>();
					parameterMaintenanceValueidciudad.setValue(informacionlaboral.getidciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuetiempoa=new ParameterValue<Integer>();
					parameterMaintenanceValuetiempoa.setValue(informacionlaboral.gettiempoa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetiempoa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuetiempom=new ParameterValue<Integer>();
					parameterMaintenanceValuetiempom.setValue(informacionlaboral.gettiempom());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetiempom);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombreempresa=new ParameterValue<String>();
					parameterMaintenanceValuenombreempresa.setValue(informacionlaboral.getnombreempresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombreempresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(informacionlaboral.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombrereferencia=new ParameterValue<String>();
					parameterMaintenanceValuenombrereferencia.setValue(informacionlaboral.getnombrereferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombrereferencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(informacionlaboral.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefonocodigoarea=new ParameterValue<String>();
					parameterMaintenanceValuetelefonocodigoarea.setValue(informacionlaboral.gettelefonocodigoarea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefonocodigoarea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefonomovil=new ParameterValue<String>();
					parameterMaintenanceValuetelefonomovil.setValue(informacionlaboral.gettelefonomovil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefonomovil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueemail=new ParameterValue<String>();
					parameterMaintenanceValueemail.setValue(informacionlaboral.getemail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueemail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesactivo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesactivo.setValue(informacionlaboral.getesactivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesactivo);
					parametersTemp.add(parameterMaintenance);
					
						if(!informacionlaboral.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(informacionlaboral.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(informacionlaboral.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(informacionlaboral.getId());
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
	
	public void setIsNewIsChangedFalseInformacionLaboral(InformacionLaboral informacionlaboral)throws Exception  {		
		informacionlaboral.setIsNew(false);
		informacionlaboral.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseInformacionLaborals(List<InformacionLaboral> informacionlaborals)throws Exception  {				
		for(InformacionLaboral informacionlaboral:informacionlaborals) {
			informacionlaboral.setIsNew(false);
			informacionlaboral.setIsChanged(false);
		}
	}
	
	public void generarExportarInformacionLaboral(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
