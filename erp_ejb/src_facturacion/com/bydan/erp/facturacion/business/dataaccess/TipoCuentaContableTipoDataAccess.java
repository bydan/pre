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
package com.bydan.erp.facturacion.business.dataaccess;

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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//TipoCuentaContableTipoConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoCuentaContableTipoDataAccess extends  TipoCuentaContableTipoDataAccessAdditional{ //TipoCuentaContableTipoDataAccessAdditional,DataAccessHelper<TipoCuentaContableTipo>
	//static Logger logger = Logger.getLogger(TipoCuentaContableTipoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_cuenta_contable_tipo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipocuentacontabletipo from "+TipoCuentaContableTipoConstantesFunciones.SPERSISTENCENAME+" tipocuentacontabletipo";
	public static String QUERYSELECTNATIVE="select "+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME+".id,"+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME+".version_row,"+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME+".nombre from "+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME;//+" as "+TipoCuentaContableTipoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME+".id,"+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME+".version_row,"+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME+".nombre from "+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME;//+" as "+TipoCuentaContableTipoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoCuentaContableTipoConstantesFunciones.SCHEMA+"."+TipoCuentaContableTipoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOCUENTACONTABLETIPO_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOCUENTACONTABLETIPO_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOCUENTACONTABLETIPO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOCUENTACONTABLETIPO_SELECT(?,?)";
	
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
	
	
	protected TipoCuentaContableTipoDataAccessAdditional tipocuentacontabletipoDataAccessAdditional=null;
	
	public TipoCuentaContableTipoDataAccessAdditional getTipoCuentaContableTipoDataAccessAdditional() {
		return this.tipocuentacontabletipoDataAccessAdditional;
	}
	
	public void setTipoCuentaContableTipoDataAccessAdditional(TipoCuentaContableTipoDataAccessAdditional tipocuentacontabletipoDataAccessAdditional) {
		try {
			this.tipocuentacontabletipoDataAccessAdditional=tipocuentacontabletipoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoCuentaContableTipoDataAccess() {
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
		TipoCuentaContableTipoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoCuentaContableTipoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoCuentaContableTipoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoCuentaContableTipoOriginal(TipoCuentaContableTipo tipocuentacontabletipo)throws Exception  {
		tipocuentacontabletipo.setTipoCuentaContableTipoOriginal((TipoCuentaContableTipo)tipocuentacontabletipo.clone());		
	}
	
	public void setTipoCuentaContableTiposOriginal(List<TipoCuentaContableTipo> tipocuentacontabletipos)throws Exception  {
		
		for(TipoCuentaContableTipo tipocuentacontabletipo:tipocuentacontabletipos){
			tipocuentacontabletipo.setTipoCuentaContableTipoOriginal((TipoCuentaContableTipo)tipocuentacontabletipo.clone());
		}
	}
	
	public static void setTipoCuentaContableTipoOriginalStatic(TipoCuentaContableTipo tipocuentacontabletipo)throws Exception  {
		tipocuentacontabletipo.setTipoCuentaContableTipoOriginal((TipoCuentaContableTipo)tipocuentacontabletipo.clone());		
	}
	
	public static void setTipoCuentaContableTiposOriginalStatic(List<TipoCuentaContableTipo> tipocuentacontabletipos)throws Exception  {
		
		for(TipoCuentaContableTipo tipocuentacontabletipo:tipocuentacontabletipos){
			tipocuentacontabletipo.setTipoCuentaContableTipoOriginal((TipoCuentaContableTipo)tipocuentacontabletipo.clone());
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
	
	public  TipoCuentaContableTipo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		
		
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
	
	public  TipoCuentaContableTipo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCuentaContableTipoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCuentaContableTipoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TipoCuentaContableTipo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoCuentaContableTipoOriginal(new TipoCuentaContableTipo());
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCuentaContableTipo("",entity,resultSet); 
				
				//entity.setTipoCuentaContableTipoOriginal(super.getEntity("",entity.getTipoCuentaContableTipoOriginal(),resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaContableTipoOriginal(this.getEntityTipoCuentaContableTipo("",entity.getTipoCuentaContableTipoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCuentaContableTipo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoCuentaContableTipo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();
				
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
	
	public  TipoCuentaContableTipo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCuentaContableTipoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCuentaContableTipoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaContableTipoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoCuentaContableTipo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoCuentaContableTipoOriginal(new TipoCuentaContableTipo());
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCuentaContableTipo("",entity,resultSet);    
				
				//entity.setTipoCuentaContableTipoOriginal(super.getEntity("",entity.getTipoCuentaContableTipoOriginal(),resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaContableTipoOriginal(this.getEntityTipoCuentaContableTipo("",entity.getTipoCuentaContableTipoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCuentaContableTipo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoCuentaContableTipo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCuentaContableTipoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCuentaContableTipoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaContableTipoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoCuentaContableTipo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoCuentaContableTipo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoCuentaContableTipo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCuentaContableTipo> entities = new  ArrayList<TipoCuentaContableTipo>();
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		  
		
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
	
	public  List<TipoCuentaContableTipo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCuentaContableTipo> entities = new  ArrayList<TipoCuentaContableTipo>();
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCuentaContableTipoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCuentaContableTipoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaContableTipoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaContableTipo();
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCuentaContableTipo("",entity,resultSet);
      	    	
				//entity.setTipoCuentaContableTipoOriginal( new TipoCuentaContableTipo());
      	    	//entity.setTipoCuentaContableTipoOriginal(super.getEntity("",entity.getTipoCuentaContableTipoOriginal(),resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaContableTipoOriginal(this.getEntityTipoCuentaContableTipo("",entity.getTipoCuentaContableTipoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCuentaContableTipos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaContableTipo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCuentaContableTipo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCuentaContableTipo> entities = new  ArrayList<TipoCuentaContableTipo>();
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		  
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
	
	public  List<TipoCuentaContableTipo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCuentaContableTipo> entities = new  ArrayList<TipoCuentaContableTipo>();
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaContableTipo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCuentaContableTipo();
					//entity.setMapTipoCuentaContableTipo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoCuentaContableTipoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCuentaContableTipo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA);         		
					entity=TipoCuentaContableTipoDataAccess.getEntityTipoCuentaContableTipo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCuentaContableTipoOriginal( new TipoCuentaContableTipo());
					////entity.setTipoCuentaContableTipoOriginal(super.getEntity("",entity.getTipoCuentaContableTipoOriginal(),resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCuentaContableTipoOriginal(this.getEntityTipoCuentaContableTipo("",entity.getTipoCuentaContableTipoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCuentaContableTipos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaContableTipo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoCuentaContableTipo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		  
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
	
	public  TipoCuentaContableTipo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaContableTipo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCuentaContableTipo();
					//entity.setMapTipoCuentaContableTipo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoCuentaContableTipoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCuentaContableTipo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA);         		
					entity=TipoCuentaContableTipoDataAccess.getEntityTipoCuentaContableTipo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCuentaContableTipoOriginal( new TipoCuentaContableTipo());
					////entity.setTipoCuentaContableTipoOriginal(super.getEntity("",entity.getTipoCuentaContableTipoOriginal(),resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCuentaContableTipoOriginal(this.getEntityTipoCuentaContableTipo("",entity.getTipoCuentaContableTipoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoCuentaContableTipo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaContableTipo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoCuentaContableTipo getEntityTipoCuentaContableTipo(String strPrefijo,TipoCuentaContableTipo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoCuentaContableTipo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoCuentaContableTipo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoCuentaContableTipoDataAccess.setFieldReflectionTipoCuentaContableTipo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoCuentaContableTipo=TipoCuentaContableTipoConstantesFunciones.getTodosTiposColumnasTipoCuentaContableTipo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoCuentaContableTipo) {
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
							field = TipoCuentaContableTipo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoCuentaContableTipo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoCuentaContableTipoDataAccess.setFieldReflectionTipoCuentaContableTipo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoCuentaContableTipo(Field field,String strPrefijo,String sColumn,TipoCuentaContableTipo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoCuentaContableTipoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCuentaContableTipoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCuentaContableTipoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCuentaContableTipo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoCuentaContableTipo> entities = new  ArrayList<TipoCuentaContableTipo>();
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCuentaContableTipoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCuentaContableTipoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaContableTipoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoCuentaContableTipo();
					entity=super.getEntity("",entity,resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoCuentaContableTipo("",entity,resultSet);
					
					//entity.setTipoCuentaContableTipoOriginal( new TipoCuentaContableTipo());
					//entity.setTipoCuentaContableTipoOriginal(super.getEntity("",entity.getTipoCuentaContableTipoOriginal(),resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoCuentaContableTipoOriginal(this.getEntityTipoCuentaContableTipo("",entity.getTipoCuentaContableTipoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoCuentaContableTipos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaContableTipo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCuentaContableTipo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoCuentaContableTipo> entities = new  ArrayList<TipoCuentaContableTipo>();
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCuentaContableTipoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCuentaContableTipoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaContableTipoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoCuentaContableTipo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCuentaContableTipo> entities = new  ArrayList<TipoCuentaContableTipo>();
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		  
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
	
	public  List<TipoCuentaContableTipo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCuentaContableTipo> entities = new  ArrayList<TipoCuentaContableTipo>();
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaContableTipo();
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCuentaContableTipo("",entity,resultSet);
      	    	
				//entity.setTipoCuentaContableTipoOriginal( new TipoCuentaContableTipo());
      	    	//entity.setTipoCuentaContableTipoOriginal(super.getEntity("",entity.getTipoCuentaContableTipoOriginal(),resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaContableTipoOriginal(this.getEntityTipoCuentaContableTipo("",entity.getTipoCuentaContableTipoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoCuentaContableTipos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaContableTipo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCuentaContableTipo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCuentaContableTipo> entities = new  ArrayList<TipoCuentaContableTipo>();
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		  
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
	
	public  List<TipoCuentaContableTipo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCuentaContableTipo> entities = new  ArrayList<TipoCuentaContableTipo>();
		TipoCuentaContableTipo entity = new TipoCuentaContableTipo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaContableTipo();
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCuentaContableTipo("",entity,resultSet);
      	    	
				//entity.setTipoCuentaContableTipoOriginal( new TipoCuentaContableTipo());
      	    	//entity.setTipoCuentaContableTipoOriginal(super.getEntity("",entity.getTipoCuentaContableTipoOriginal(),resultSet,TipoCuentaContableTipoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaContableTipoOriginal(this.getEntityTipoCuentaContableTipo("",entity.getTipoCuentaContableTipoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCuentaContableTipos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoCuentaContableTipo getEntityTipoCuentaContableTipo(String strPrefijo,TipoCuentaContableTipo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoCuentaContableTipoConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoCuentaContableTipoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoCuentaContableTipo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoCuentaContableTipo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoCuentaContableTipoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoCuentaContableTipoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoCuentaContableTipoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoCuentaContableTipoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoCuentaContableTipoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoCuentaContableTipoDataAccess.TABLENAME,TipoCuentaContableTipoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoCuentaContableTipoDataAccess.setTipoCuentaContableTipoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<CuentaContableTipo> getCuentaContableTipos(Connexion connexion,TipoCuentaContableTipo tipocuentacontabletipo)throws SQLException,Exception {

		List<CuentaContableTipo> cuentacontabletipos= new ArrayList<CuentaContableTipo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCuentaContableTipoConstantesFunciones.SCHEMA+".tipo_cuenta_contable_tipo ON "+CuentaContableTipoConstantesFunciones.SCHEMA+".cuenta_contable_tipo.id_tipo_cuenta_contable_tipo="+TipoCuentaContableTipoConstantesFunciones.SCHEMA+".tipo_cuenta_contable_tipo.id WHERE "+TipoCuentaContableTipoConstantesFunciones.SCHEMA+".tipo_cuenta_contable_tipo.id="+String.valueOf(tipocuentacontabletipo.getId());
			} else {
				sQuery=" INNER JOIN cuentacontabletipo.TipoCuentaContableTipo WHERE cuentacontabletipo.TipoCuentaContableTipo.id="+String.valueOf(tipocuentacontabletipo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaContableTipoDataAccess cuentacontabletipoDataAccess=new CuentaContableTipoDataAccess();

			cuentacontabletipoDataAccess.setConnexionType(this.connexionType);
			cuentacontabletipoDataAccess.setParameterDbType(this.parameterDbType);
			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontabletipos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoCuentaContableTipo tipocuentacontabletipo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipocuentacontabletipo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipocuentacontabletipo.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipocuentacontabletipo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipocuentacontabletipo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipocuentacontabletipo.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipocuentacontabletipo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipocuentacontabletipo.getId());
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
	
	public void setIsNewIsChangedFalseTipoCuentaContableTipo(TipoCuentaContableTipo tipocuentacontabletipo)throws Exception  {		
		tipocuentacontabletipo.setIsNew(false);
		tipocuentacontabletipo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoCuentaContableTipos(List<TipoCuentaContableTipo> tipocuentacontabletipos)throws Exception  {				
		for(TipoCuentaContableTipo tipocuentacontabletipo:tipocuentacontabletipos) {
			tipocuentacontabletipo.setIsNew(false);
			tipocuentacontabletipo.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoCuentaContableTipo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
