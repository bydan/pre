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
import com.bydan.erp.cartera.util.*;//CargaFamiliarConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class CargaFamiliarDataAccess extends  CargaFamiliarDataAccessAdditional{ //CargaFamiliarDataAccessAdditional,DataAccessHelper<CargaFamiliar>
	//static Logger logger = Logger.getLogger(CargaFamiliarDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="carga_familiar";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_cliente,id_tipo_carga_fami,id_tipo_genero,id_estado_civil,cedula,apellido,nombre,direccion,fecha_nacimiento,valor_cupo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,id_tipo_carga_fami=?,id_tipo_genero=?,id_estado_civil=?,cedula=?,apellido=?,nombre=?,direccion=?,fecha_nacimiento=?,valor_cupo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cargafamiliar from "+CargaFamiliarConstantesFunciones.SPERSISTENCENAME+" cargafamiliar";
	public static String QUERYSELECTNATIVE="select "+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".id,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".version_row,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".id_empresa,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".id_cliente,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".id_tipo_carga_fami,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".id_tipo_genero,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".id_estado_civil,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".cedula,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".apellido,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".nombre,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".direccion,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".fecha_nacimiento,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".valor_cupo from "+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME;//+" as "+CargaFamiliarConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".id,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".version_row,"+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+".nombre from "+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME;//+" as "+CargaFamiliarConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CargaFamiliarConstantesFunciones.SCHEMA+"."+CargaFamiliarConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,id_tipo_carga_fami=?,id_tipo_genero=?,id_estado_civil=?,cedula=?,apellido=?,nombre=?,direccion=?,fecha_nacimiento=?,valor_cupo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CARGAFAMILIAR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CARGAFAMILIAR_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CARGAFAMILIAR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CARGAFAMILIAR_SELECT(?,?)";
	
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
	
	
	protected CargaFamiliarDataAccessAdditional cargafamiliarDataAccessAdditional=null;
	
	public CargaFamiliarDataAccessAdditional getCargaFamiliarDataAccessAdditional() {
		return this.cargafamiliarDataAccessAdditional;
	}
	
	public void setCargaFamiliarDataAccessAdditional(CargaFamiliarDataAccessAdditional cargafamiliarDataAccessAdditional) {
		try {
			this.cargafamiliarDataAccessAdditional=cargafamiliarDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CargaFamiliarDataAccess() {
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
		CargaFamiliarDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CargaFamiliarDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CargaFamiliarDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCargaFamiliarOriginal(CargaFamiliar cargafamiliar)throws Exception  {
		cargafamiliar.setCargaFamiliarOriginal((CargaFamiliar)cargafamiliar.clone());		
	}
	
	public void setCargaFamiliarsOriginal(List<CargaFamiliar> cargafamiliars)throws Exception  {
		
		for(CargaFamiliar cargafamiliar:cargafamiliars){
			cargafamiliar.setCargaFamiliarOriginal((CargaFamiliar)cargafamiliar.clone());
		}
	}
	
	public static void setCargaFamiliarOriginalStatic(CargaFamiliar cargafamiliar)throws Exception  {
		cargafamiliar.setCargaFamiliarOriginal((CargaFamiliar)cargafamiliar.clone());		
	}
	
	public static void setCargaFamiliarsOriginalStatic(List<CargaFamiliar> cargafamiliars)throws Exception  {
		
		for(CargaFamiliar cargafamiliar:cargafamiliars){
			cargafamiliar.setCargaFamiliarOriginal((CargaFamiliar)cargafamiliar.clone());
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
	
	public  CargaFamiliar getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CargaFamiliar entity = new CargaFamiliar();		
		
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
	
	public  CargaFamiliar getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CargaFamiliar entity = new CargaFamiliar();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CargaFamiliarDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CargaFamiliarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.CargaFamiliar.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCargaFamiliarOriginal(new CargaFamiliar());
      	    	entity=super.getEntity("",entity,resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCargaFamiliar("",entity,resultSet); 
				
				//entity.setCargaFamiliarOriginal(super.getEntity("",entity.getCargaFamiliarOriginal(),resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargaFamiliarOriginal(this.getEntityCargaFamiliar("",entity.getCargaFamiliarOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCargaFamiliar(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CargaFamiliar getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CargaFamiliar entity = new CargaFamiliar();
				
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
	
	public  CargaFamiliar getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CargaFamiliar entity = new CargaFamiliar();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CargaFamiliarDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CargaFamiliarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargaFamiliarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.CargaFamiliar.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCargaFamiliarOriginal(new CargaFamiliar());
      	    	entity=super.getEntity("",entity,resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCargaFamiliar("",entity,resultSet);    
				
				//entity.setCargaFamiliarOriginal(super.getEntity("",entity.getCargaFamiliarOriginal(),resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargaFamiliarOriginal(this.getEntityCargaFamiliar("",entity.getCargaFamiliarOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCargaFamiliar(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CargaFamiliar
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CargaFamiliar entity = new CargaFamiliar();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CargaFamiliarDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CargaFamiliarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargaFamiliarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.CargaFamiliar.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCargaFamiliar(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CargaFamiliar> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CargaFamiliar> entities = new  ArrayList<CargaFamiliar>();
		CargaFamiliar entity = new CargaFamiliar();		  
		
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
	
	public  List<CargaFamiliar> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CargaFamiliar> entities = new  ArrayList<CargaFamiliar>();
		CargaFamiliar entity = new CargaFamiliar();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CargaFamiliarDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CargaFamiliarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargaFamiliarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CargaFamiliar();
      	    	entity=super.getEntity("",entity,resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCargaFamiliar("",entity,resultSet);
      	    	
				//entity.setCargaFamiliarOriginal( new CargaFamiliar());
      	    	//entity.setCargaFamiliarOriginal(super.getEntity("",entity.getCargaFamiliarOriginal(),resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargaFamiliarOriginal(this.getEntityCargaFamiliar("",entity.getCargaFamiliarOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCargaFamiliars(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargaFamiliar(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CargaFamiliar> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CargaFamiliar> entities = new  ArrayList<CargaFamiliar>();
		CargaFamiliar entity = new CargaFamiliar();		  
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
	
	public  List<CargaFamiliar> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CargaFamiliar> entities = new  ArrayList<CargaFamiliar>();
		CargaFamiliar entity = new CargaFamiliar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CargaFamiliar();
				
				if(conMapGenerico) {
					entity.inicializarMapCargaFamiliar();
					//entity.setMapCargaFamiliar(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCargaFamiliarValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCargaFamiliar().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA);         		
					entity=CargaFamiliarDataAccess.getEntityCargaFamiliar("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCargaFamiliarOriginal( new CargaFamiliar());
					////entity.setCargaFamiliarOriginal(super.getEntity("",entity.getCargaFamiliarOriginal(),resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA));         		
					////entity.setCargaFamiliarOriginal(this.getEntityCargaFamiliar("",entity.getCargaFamiliarOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCargaFamiliars(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargaFamiliar(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CargaFamiliar getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CargaFamiliar entity = new CargaFamiliar();		  
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
	
	public  CargaFamiliar getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CargaFamiliar entity = new CargaFamiliar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CargaFamiliar();
				
				if(conMapGenerico) {
					entity.inicializarMapCargaFamiliar();
					//entity.setMapCargaFamiliar(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCargaFamiliarValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCargaFamiliar().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA);         		
					entity=CargaFamiliarDataAccess.getEntityCargaFamiliar("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCargaFamiliarOriginal( new CargaFamiliar());
					////entity.setCargaFamiliarOriginal(super.getEntity("",entity.getCargaFamiliarOriginal(),resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA));         		
					////entity.setCargaFamiliarOriginal(this.getEntityCargaFamiliar("",entity.getCargaFamiliarOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCargaFamiliar(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargaFamiliar(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CargaFamiliar getEntityCargaFamiliar(String strPrefijo,CargaFamiliar entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CargaFamiliar.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CargaFamiliar.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CargaFamiliarDataAccess.setFieldReflectionCargaFamiliar(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCargaFamiliar=CargaFamiliarConstantesFunciones.getTodosTiposColumnasCargaFamiliar();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCargaFamiliar) {
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
							field = CargaFamiliar.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CargaFamiliar.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CargaFamiliarDataAccess.setFieldReflectionCargaFamiliar(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCargaFamiliar(Field field,String strPrefijo,String sColumn,CargaFamiliar entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CargaFamiliarConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargaFamiliarConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CargaFamiliarConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargaFamiliarConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargaFamiliarConstantesFunciones.IDTIPOCARGAFAMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargaFamiliarConstantesFunciones.IDTIPOGENERO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargaFamiliarConstantesFunciones.IDESTADOCIVIL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargaFamiliarConstantesFunciones.CEDULA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CargaFamiliarConstantesFunciones.APELLIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CargaFamiliarConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CargaFamiliarConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CargaFamiliarConstantesFunciones.FECHANACIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CargaFamiliarConstantesFunciones.VALORCUPO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CargaFamiliar>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CargaFamiliar> entities = new  ArrayList<CargaFamiliar>();
		CargaFamiliar entity = new CargaFamiliar();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CargaFamiliarDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CargaFamiliarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargaFamiliarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CargaFamiliar();
					entity=super.getEntity("",entity,resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCargaFamiliar("",entity,resultSet);
					
					//entity.setCargaFamiliarOriginal( new CargaFamiliar());
					//entity.setCargaFamiliarOriginal(super.getEntity("",entity.getCargaFamiliarOriginal(),resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA));         		
					//entity.setCargaFamiliarOriginal(this.getEntityCargaFamiliar("",entity.getCargaFamiliarOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCargaFamiliars(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargaFamiliar(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CargaFamiliar>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CargaFamiliar> entities = new  ArrayList<CargaFamiliar>();
		CargaFamiliar entity = new CargaFamiliar();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CargaFamiliarDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CargaFamiliarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargaFamiliarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CargaFamiliar> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CargaFamiliar> entities = new  ArrayList<CargaFamiliar>();
		CargaFamiliar entity = new CargaFamiliar();		  
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
	
	public  List<CargaFamiliar> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CargaFamiliar> entities = new  ArrayList<CargaFamiliar>();
		CargaFamiliar entity = new CargaFamiliar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CargaFamiliar();
      	    	entity=super.getEntity("",entity,resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCargaFamiliar("",entity,resultSet);
      	    	
				//entity.setCargaFamiliarOriginal( new CargaFamiliar());
      	    	//entity.setCargaFamiliarOriginal(super.getEntity("",entity.getCargaFamiliarOriginal(),resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargaFamiliarOriginal(this.getEntityCargaFamiliar("",entity.getCargaFamiliarOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCargaFamiliars(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargaFamiliar(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CargaFamiliar> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CargaFamiliar> entities = new  ArrayList<CargaFamiliar>();
		CargaFamiliar entity = new CargaFamiliar();		  
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
	
	public  List<CargaFamiliar> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CargaFamiliar> entities = new  ArrayList<CargaFamiliar>();
		CargaFamiliar entity = new CargaFamiliar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CargaFamiliar();
      	    	entity=super.getEntity("",entity,resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCargaFamiliar("",entity,resultSet);
      	    	
				//entity.setCargaFamiliarOriginal( new CargaFamiliar());
      	    	//entity.setCargaFamiliarOriginal(super.getEntity("",entity.getCargaFamiliarOriginal(),resultSet,CargaFamiliarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargaFamiliarOriginal(this.getEntityCargaFamiliar("",entity.getCargaFamiliarOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCargaFamiliars(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CargaFamiliar getEntityCargaFamiliar(String strPrefijo,CargaFamiliar entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CargaFamiliarConstantesFunciones.IDEMPRESA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+CargaFamiliarConstantesFunciones.IDCLIENTE));
				entity.setid_tipo_carga_fami(resultSet.getLong(strPrefijo+CargaFamiliarConstantesFunciones.IDTIPOCARGAFAMI));
				entity.setid_tipo_genero(resultSet.getLong(strPrefijo+CargaFamiliarConstantesFunciones.IDTIPOGENERO));
				entity.setid_estado_civil(resultSet.getLong(strPrefijo+CargaFamiliarConstantesFunciones.IDESTADOCIVIL));
				entity.setcedula(resultSet.getString(strPrefijo+CargaFamiliarConstantesFunciones.CEDULA));
				entity.setapellido(resultSet.getString(strPrefijo+CargaFamiliarConstantesFunciones.APELLIDO));
				entity.setnombre(resultSet.getString(strPrefijo+CargaFamiliarConstantesFunciones.NOMBRE));
				entity.setdireccion(resultSet.getString(strPrefijo+CargaFamiliarConstantesFunciones.DIRECCION));
				entity.setfecha_nacimiento(new Date(resultSet.getDate(strPrefijo+CargaFamiliarConstantesFunciones.FECHANACIMIENTO).getTime()));
				entity.setvalor_cupo(resultSet.getDouble(strPrefijo+CargaFamiliarConstantesFunciones.VALORCUPO));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+CargaFamiliarConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCargaFamiliar(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CargaFamiliar entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CargaFamiliarDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CargaFamiliarDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CargaFamiliarDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CargaFamiliarDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CargaFamiliarConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CargaFamiliarDataAccess.TABLENAME,CargaFamiliarDataAccess.ISWITHSTOREPROCEDURES);
			
			CargaFamiliarDataAccess.setCargaFamiliarOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CargaFamiliar relcargafamiliar)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcargafamiliar.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,CargaFamiliar relcargafamiliar)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relcargafamiliar.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoCargaFami getTipoCargaFami(Connexion connexion,CargaFamiliar relcargafamiliar)throws SQLException,Exception {

		TipoCargaFami tipocargafami= new TipoCargaFami();

		try {
			TipoCargaFamiDataAccess tipocargafamiDataAccess=new TipoCargaFamiDataAccess();

			tipocargafamiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocargafamiDataAccess.setConnexionType(this.connexionType);
			tipocargafamiDataAccess.setParameterDbType(this.parameterDbType);

			tipocargafami=tipocargafamiDataAccess.getEntity(connexion,relcargafamiliar.getid_tipo_carga_fami());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocargafami;

	}

	public TipoGenero getTipoGenero(Connexion connexion,CargaFamiliar relcargafamiliar)throws SQLException,Exception {

		TipoGenero tipogenero= new TipoGenero();

		try {
			TipoGeneroDataAccess tipogeneroDataAccess=new TipoGeneroDataAccess();

			tipogeneroDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogeneroDataAccess.setConnexionType(this.connexionType);
			tipogeneroDataAccess.setParameterDbType(this.parameterDbType);

			tipogenero=tipogeneroDataAccess.getEntity(connexion,relcargafamiliar.getid_tipo_genero());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogenero;

	}

	public EstadoCivil getEstadoCivil(Connexion connexion,CargaFamiliar relcargafamiliar)throws SQLException,Exception {

		EstadoCivil estadocivil= new EstadoCivil();

		try {
			EstadoCivilDataAccess estadocivilDataAccess=new EstadoCivilDataAccess();

			estadocivilDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadocivilDataAccess.setConnexionType(this.connexionType);
			estadocivilDataAccess.setParameterDbType(this.parameterDbType);

			estadocivil=estadocivilDataAccess.getEntity(connexion,relcargafamiliar.getid_estado_civil());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadocivil;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CargaFamiliar cargafamiliar) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cargafamiliar.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cargafamiliar.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(cargafamiliar.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_carga_fami=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_carga_fami.setValue(cargafamiliar.getid_tipo_carga_fami());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_carga_fami);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_genero=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_genero.setValue(cargafamiliar.getid_tipo_genero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_genero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_civil=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_civil.setValue(cargafamiliar.getid_estado_civil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_civil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecedula=new ParameterValue<String>();
					parameterMaintenanceValuecedula.setValue(cargafamiliar.getcedula());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecedula);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueapellido=new ParameterValue<String>();
					parameterMaintenanceValueapellido.setValue(cargafamiliar.getapellido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueapellido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(cargafamiliar.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(cargafamiliar.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_nacimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_nacimiento.setValue(cargafamiliar.getfecha_nacimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_nacimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_cupo=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_cupo.setValue(cargafamiliar.getvalor_cupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_cupo);
					parametersTemp.add(parameterMaintenance);
					
						if(!cargafamiliar.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cargafamiliar.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cargafamiliar.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cargafamiliar.getId());
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
	
	public void setIsNewIsChangedFalseCargaFamiliar(CargaFamiliar cargafamiliar)throws Exception  {		
		cargafamiliar.setIsNew(false);
		cargafamiliar.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCargaFamiliars(List<CargaFamiliar> cargafamiliars)throws Exception  {				
		for(CargaFamiliar cargafamiliar:cargafamiliars) {
			cargafamiliar.setIsNew(false);
			cargafamiliar.setIsChanged(false);
		}
	}
	
	public void generarExportarCargaFamiliar(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
