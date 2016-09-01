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
import com.bydan.erp.contabilidad.util.*;//TipoDescripcionAsientoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class TipoDescripcionAsientoDataAccess extends  TipoDescripcionAsientoDataAccessAdditional{ //TipoDescripcionAsientoDataAccessAdditional,DataAccessHelper<TipoDescripcionAsiento>
	//static Logger logger = Logger.getLogger(TipoDescripcionAsientoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_descripcion_asiento";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_modulo,codigo,nombre)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipodescripcionasiento from "+TipoDescripcionAsientoConstantesFunciones.SPERSISTENCENAME+" tipodescripcionasiento";
	public static String QUERYSELECTNATIVE="select "+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".id,"+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".version_row,"+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".id_empresa,"+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".id_modulo,"+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".codigo,"+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".nombre from "+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME;//+" as "+TipoDescripcionAsientoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".id,"+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".version_row,"+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".codigo,"+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".nombre from "+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME;//+" as "+TipoDescripcionAsientoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPODESCRIPCIONASIENTO_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPODESCRIPCIONASIENTO_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPODESCRIPCIONASIENTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPODESCRIPCIONASIENTO_SELECT(?,?)";
	
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
	
	
	protected TipoDescripcionAsientoDataAccessAdditional tipodescripcionasientoDataAccessAdditional=null;
	
	public TipoDescripcionAsientoDataAccessAdditional getTipoDescripcionAsientoDataAccessAdditional() {
		return this.tipodescripcionasientoDataAccessAdditional;
	}
	
	public void setTipoDescripcionAsientoDataAccessAdditional(TipoDescripcionAsientoDataAccessAdditional tipodescripcionasientoDataAccessAdditional) {
		try {
			this.tipodescripcionasientoDataAccessAdditional=tipodescripcionasientoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoDescripcionAsientoDataAccess() {
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
		TipoDescripcionAsientoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoDescripcionAsientoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoDescripcionAsientoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoDescripcionAsientoOriginal(TipoDescripcionAsiento tipodescripcionasiento)throws Exception  {
		tipodescripcionasiento.setTipoDescripcionAsientoOriginal((TipoDescripcionAsiento)tipodescripcionasiento.clone());		
	}
	
	public void setTipoDescripcionAsientosOriginal(List<TipoDescripcionAsiento> tipodescripcionasientos)throws Exception  {
		
		for(TipoDescripcionAsiento tipodescripcionasiento:tipodescripcionasientos){
			tipodescripcionasiento.setTipoDescripcionAsientoOriginal((TipoDescripcionAsiento)tipodescripcionasiento.clone());
		}
	}
	
	public static void setTipoDescripcionAsientoOriginalStatic(TipoDescripcionAsiento tipodescripcionasiento)throws Exception  {
		tipodescripcionasiento.setTipoDescripcionAsientoOriginal((TipoDescripcionAsiento)tipodescripcionasiento.clone());		
	}
	
	public static void setTipoDescripcionAsientosOriginalStatic(List<TipoDescripcionAsiento> tipodescripcionasientos)throws Exception  {
		
		for(TipoDescripcionAsiento tipodescripcionasiento:tipodescripcionasientos){
			tipodescripcionasiento.setTipoDescripcionAsientoOriginal((TipoDescripcionAsiento)tipodescripcionasiento.clone());
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
	
	public  TipoDescripcionAsiento getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		
		
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
	
	public  TipoDescripcionAsiento getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDescripcionAsientoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDescripcionAsientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoDescripcionAsiento.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoDescripcionAsientoOriginal(new TipoDescripcionAsiento());
      	    	entity=super.getEntity("",entity,resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDescripcionAsiento("",entity,resultSet); 
				
				//entity.setTipoDescripcionAsientoOriginal(super.getEntity("",entity.getTipoDescripcionAsientoOriginal(),resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDescripcionAsientoOriginal(this.getEntityTipoDescripcionAsiento("",entity.getTipoDescripcionAsientoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDescripcionAsiento(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoDescripcionAsiento getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();
				
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
	
	public  TipoDescripcionAsiento getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDescripcionAsientoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDescripcionAsientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDescripcionAsientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoDescripcionAsiento.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoDescripcionAsientoOriginal(new TipoDescripcionAsiento());
      	    	entity=super.getEntity("",entity,resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDescripcionAsiento("",entity,resultSet);    
				
				//entity.setTipoDescripcionAsientoOriginal(super.getEntity("",entity.getTipoDescripcionAsientoOriginal(),resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDescripcionAsientoOriginal(this.getEntityTipoDescripcionAsiento("",entity.getTipoDescripcionAsientoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDescripcionAsiento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoDescripcionAsiento
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDescripcionAsientoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDescripcionAsientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDescripcionAsientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoDescripcionAsiento.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoDescripcionAsiento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoDescripcionAsiento> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDescripcionAsiento> entities = new  ArrayList<TipoDescripcionAsiento>();
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		  
		
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
	
	public  List<TipoDescripcionAsiento> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDescripcionAsiento> entities = new  ArrayList<TipoDescripcionAsiento>();
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDescripcionAsientoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDescripcionAsientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDescripcionAsientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDescripcionAsiento();
      	    	entity=super.getEntity("",entity,resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDescripcionAsiento("",entity,resultSet);
      	    	
				//entity.setTipoDescripcionAsientoOriginal( new TipoDescripcionAsiento());
      	    	//entity.setTipoDescripcionAsientoOriginal(super.getEntity("",entity.getTipoDescripcionAsientoOriginal(),resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDescripcionAsientoOriginal(this.getEntityTipoDescripcionAsiento("",entity.getTipoDescripcionAsientoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDescripcionAsientos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDescripcionAsiento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDescripcionAsiento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDescripcionAsiento> entities = new  ArrayList<TipoDescripcionAsiento>();
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		  
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
	
	public  List<TipoDescripcionAsiento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDescripcionAsiento> entities = new  ArrayList<TipoDescripcionAsiento>();
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDescripcionAsiento();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDescripcionAsiento();
					//entity.setMapTipoDescripcionAsiento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoDescripcionAsientoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDescripcionAsiento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA);         		
					entity=TipoDescripcionAsientoDataAccess.getEntityTipoDescripcionAsiento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDescripcionAsientoOriginal( new TipoDescripcionAsiento());
					////entity.setTipoDescripcionAsientoOriginal(super.getEntity("",entity.getTipoDescripcionAsientoOriginal(),resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDescripcionAsientoOriginal(this.getEntityTipoDescripcionAsiento("",entity.getTipoDescripcionAsientoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDescripcionAsientos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDescripcionAsiento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoDescripcionAsiento getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		  
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
	
	public  TipoDescripcionAsiento getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDescripcionAsiento();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDescripcionAsiento();
					//entity.setMapTipoDescripcionAsiento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoDescripcionAsientoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDescripcionAsiento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA);         		
					entity=TipoDescripcionAsientoDataAccess.getEntityTipoDescripcionAsiento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDescripcionAsientoOriginal( new TipoDescripcionAsiento());
					////entity.setTipoDescripcionAsientoOriginal(super.getEntity("",entity.getTipoDescripcionAsientoOriginal(),resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDescripcionAsientoOriginal(this.getEntityTipoDescripcionAsiento("",entity.getTipoDescripcionAsientoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoDescripcionAsiento(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDescripcionAsiento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoDescripcionAsiento getEntityTipoDescripcionAsiento(String strPrefijo,TipoDescripcionAsiento entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoDescripcionAsiento.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoDescripcionAsiento.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoDescripcionAsientoDataAccess.setFieldReflectionTipoDescripcionAsiento(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoDescripcionAsiento=TipoDescripcionAsientoConstantesFunciones.getTodosTiposColumnasTipoDescripcionAsiento();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoDescripcionAsiento) {
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
							field = TipoDescripcionAsiento.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoDescripcionAsiento.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoDescripcionAsientoDataAccess.setFieldReflectionTipoDescripcionAsiento(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoDescripcionAsiento(Field field,String strPrefijo,String sColumn,TipoDescripcionAsiento entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoDescripcionAsientoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDescripcionAsientoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDescripcionAsientoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDescripcionAsientoConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDescripcionAsientoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDescripcionAsientoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDescripcionAsiento>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoDescripcionAsiento> entities = new  ArrayList<TipoDescripcionAsiento>();
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDescripcionAsientoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDescripcionAsientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDescripcionAsientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoDescripcionAsiento();
					entity=super.getEntity("",entity,resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoDescripcionAsiento("",entity,resultSet);
					
					//entity.setTipoDescripcionAsientoOriginal( new TipoDescripcionAsiento());
					//entity.setTipoDescripcionAsientoOriginal(super.getEntity("",entity.getTipoDescripcionAsientoOriginal(),resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoDescripcionAsientoOriginal(this.getEntityTipoDescripcionAsiento("",entity.getTipoDescripcionAsientoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoDescripcionAsientos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDescripcionAsiento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDescripcionAsiento>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoDescripcionAsiento> entities = new  ArrayList<TipoDescripcionAsiento>();
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDescripcionAsientoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDescripcionAsientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDescripcionAsientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoDescripcionAsiento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDescripcionAsiento> entities = new  ArrayList<TipoDescripcionAsiento>();
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		  
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
	
	public  List<TipoDescripcionAsiento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDescripcionAsiento> entities = new  ArrayList<TipoDescripcionAsiento>();
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDescripcionAsiento();
      	    	entity=super.getEntity("",entity,resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDescripcionAsiento("",entity,resultSet);
      	    	
				//entity.setTipoDescripcionAsientoOriginal( new TipoDescripcionAsiento());
      	    	//entity.setTipoDescripcionAsientoOriginal(super.getEntity("",entity.getTipoDescripcionAsientoOriginal(),resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDescripcionAsientoOriginal(this.getEntityTipoDescripcionAsiento("",entity.getTipoDescripcionAsientoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoDescripcionAsientos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDescripcionAsiento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDescripcionAsiento> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDescripcionAsiento> entities = new  ArrayList<TipoDescripcionAsiento>();
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		  
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
	
	public  List<TipoDescripcionAsiento> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDescripcionAsiento> entities = new  ArrayList<TipoDescripcionAsiento>();
		TipoDescripcionAsiento entity = new TipoDescripcionAsiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDescripcionAsiento();
      	    	entity=super.getEntity("",entity,resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDescripcionAsiento("",entity,resultSet);
      	    	
				//entity.setTipoDescripcionAsientoOriginal( new TipoDescripcionAsiento());
      	    	//entity.setTipoDescripcionAsientoOriginal(super.getEntity("",entity.getTipoDescripcionAsientoOriginal(),resultSet,TipoDescripcionAsientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDescripcionAsientoOriginal(this.getEntityTipoDescripcionAsiento("",entity.getTipoDescripcionAsientoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDescripcionAsientos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoDescripcionAsiento getEntityTipoDescripcionAsiento(String strPrefijo,TipoDescripcionAsiento entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoDescripcionAsientoConstantesFunciones.IDEMPRESA));
				entity.setid_modulo(resultSet.getLong(strPrefijo+TipoDescripcionAsientoConstantesFunciones.IDMODULO));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDescripcionAsientoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoDescripcionAsientoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDescripcionAsientoConstantesFunciones.CODIGO));entity.setnombre(resultSet.getString(strPrefijo+TipoDescripcionAsientoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoDescripcionAsiento(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoDescripcionAsiento entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoDescripcionAsientoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoDescripcionAsientoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoDescripcionAsientoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoDescripcionAsientoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoDescripcionAsientoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoDescripcionAsientoDataAccess.TABLENAME,TipoDescripcionAsientoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoDescripcionAsientoDataAccess.setTipoDescripcionAsientoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoDescripcionAsiento reltipodescripcionasiento)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipodescripcionasiento.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Modulo getModulo(Connexion connexion,TipoDescripcionAsiento reltipodescripcionasiento)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reltipodescripcionasiento.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}


		
		public List<AsientoContable> getAsientoContables(Connexion connexion,TipoDescripcionAsiento tipodescripcionasiento)throws SQLException,Exception {

		List<AsientoContable> asientocontables= new ArrayList<AsientoContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDescripcionAsientoConstantesFunciones.SCHEMA+".tipo_descripcion_asiento ON "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id_tipo_descripcion_asiento="+TipoDescripcionAsientoConstantesFunciones.SCHEMA+".tipo_descripcion_asiento.id WHERE "+TipoDescripcionAsientoConstantesFunciones.SCHEMA+".tipo_descripcion_asiento.id="+String.valueOf(tipodescripcionasiento.getId());
			} else {
				sQuery=" INNER JOIN asientocontable.TipoDescripcionAsiento WHERE asientocontable.TipoDescripcionAsiento.id="+String.valueOf(tipodescripcionasiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);
			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontables;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoDescripcionAsiento tipodescripcionasiento) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipodescripcionasiento.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipodescripcionasiento.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(tipodescripcionasiento.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipodescripcionasiento.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipodescripcionasiento.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipodescripcionasiento.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipodescripcionasiento.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipodescripcionasiento.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipodescripcionasiento.getId());
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
	
	public void setIsNewIsChangedFalseTipoDescripcionAsiento(TipoDescripcionAsiento tipodescripcionasiento)throws Exception  {		
		tipodescripcionasiento.setIsNew(false);
		tipodescripcionasiento.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoDescripcionAsientos(List<TipoDescripcionAsiento> tipodescripcionasientos)throws Exception  {				
		for(TipoDescripcionAsiento tipodescripcionasiento:tipodescripcionasientos) {
			tipodescripcionasiento.setIsNew(false);
			tipodescripcionasiento.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoDescripcionAsiento(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
