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
import com.bydan.erp.facturacion.util.*;//TipoNotaCreditoSoliConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;




@SuppressWarnings("unused")
final public class TipoNotaCreditoSoliDataAccess extends  TipoNotaCreditoSoliDataAccessAdditional{ //TipoNotaCreditoSoliDataAccessAdditional,DataAccessHelper<TipoNotaCreditoSoli>
	//static Logger logger = Logger.getLogger(TipoNotaCreditoSoliDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_nota_credito_soli";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tiponotacreditosoli from "+TipoNotaCreditoSoliConstantesFunciones.SPERSISTENCENAME+" tiponotacreditosoli";
	public static String QUERYSELECTNATIVE="select "+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+".id,"+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+".version_row,"+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+".codigo,"+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+".nombre from "+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME;//+" as "+TipoNotaCreditoSoliConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+".id,"+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+".version_row,"+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+".codigo from "+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME;//+" as "+TipoNotaCreditoSoliConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+"."+TipoNotaCreditoSoliConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPONOTACREDITOSOLI_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPONOTACREDITOSOLI_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPONOTACREDITOSOLI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPONOTACREDITOSOLI_SELECT(?,?)";
	
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
	
	
	protected TipoNotaCreditoSoliDataAccessAdditional tiponotacreditosoliDataAccessAdditional=null;
	
	public TipoNotaCreditoSoliDataAccessAdditional getTipoNotaCreditoSoliDataAccessAdditional() {
		return this.tiponotacreditosoliDataAccessAdditional;
	}
	
	public void setTipoNotaCreditoSoliDataAccessAdditional(TipoNotaCreditoSoliDataAccessAdditional tiponotacreditosoliDataAccessAdditional) {
		try {
			this.tiponotacreditosoliDataAccessAdditional=tiponotacreditosoliDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoNotaCreditoSoliDataAccess() {
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
		TipoNotaCreditoSoliDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoNotaCreditoSoliDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoNotaCreditoSoliDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoNotaCreditoSoliOriginal(TipoNotaCreditoSoli tiponotacreditosoli)throws Exception  {
		tiponotacreditosoli.setTipoNotaCreditoSoliOriginal((TipoNotaCreditoSoli)tiponotacreditosoli.clone());		
	}
	
	public void setTipoNotaCreditoSolisOriginal(List<TipoNotaCreditoSoli> tiponotacreditosolis)throws Exception  {
		
		for(TipoNotaCreditoSoli tiponotacreditosoli:tiponotacreditosolis){
			tiponotacreditosoli.setTipoNotaCreditoSoliOriginal((TipoNotaCreditoSoli)tiponotacreditosoli.clone());
		}
	}
	
	public static void setTipoNotaCreditoSoliOriginalStatic(TipoNotaCreditoSoli tiponotacreditosoli)throws Exception  {
		tiponotacreditosoli.setTipoNotaCreditoSoliOriginal((TipoNotaCreditoSoli)tiponotacreditosoli.clone());		
	}
	
	public static void setTipoNotaCreditoSolisOriginalStatic(List<TipoNotaCreditoSoli> tiponotacreditosolis)throws Exception  {
		
		for(TipoNotaCreditoSoli tiponotacreditosoli:tiponotacreditosolis){
			tiponotacreditosoli.setTipoNotaCreditoSoliOriginal((TipoNotaCreditoSoli)tiponotacreditosoli.clone());
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
	
	public  TipoNotaCreditoSoli getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		
		
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
	
	public  TipoNotaCreditoSoli getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoNotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoNotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TipoNotaCreditoSoli.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoNotaCreditoSoliOriginal(new TipoNotaCreditoSoli());
      	    	entity=super.getEntity("",entity,resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoNotaCreditoSoli("",entity,resultSet); 
				
				//entity.setTipoNotaCreditoSoliOriginal(super.getEntity("",entity.getTipoNotaCreditoSoliOriginal(),resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoNotaCreditoSoliOriginal(this.getEntityTipoNotaCreditoSoli("",entity.getTipoNotaCreditoSoliOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoNotaCreditoSoli(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoNotaCreditoSoli getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();
				
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
	
	public  TipoNotaCreditoSoli getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoNotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoNotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoNotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoNotaCreditoSoli.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoNotaCreditoSoliOriginal(new TipoNotaCreditoSoli());
      	    	entity=super.getEntity("",entity,resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoNotaCreditoSoli("",entity,resultSet);    
				
				//entity.setTipoNotaCreditoSoliOriginal(super.getEntity("",entity.getTipoNotaCreditoSoliOriginal(),resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoNotaCreditoSoliOriginal(this.getEntityTipoNotaCreditoSoli("",entity.getTipoNotaCreditoSoliOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoNotaCreditoSoli(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoNotaCreditoSoli
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoNotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoNotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoNotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoNotaCreditoSoli.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoNotaCreditoSoli(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoNotaCreditoSoli> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoNotaCreditoSoli> entities = new  ArrayList<TipoNotaCreditoSoli>();
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		  
		
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
	
	public  List<TipoNotaCreditoSoli> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoNotaCreditoSoli> entities = new  ArrayList<TipoNotaCreditoSoli>();
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoNotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoNotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoNotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoNotaCreditoSoli();
      	    	entity=super.getEntity("",entity,resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoNotaCreditoSoli("",entity,resultSet);
      	    	
				//entity.setTipoNotaCreditoSoliOriginal( new TipoNotaCreditoSoli());
      	    	//entity.setTipoNotaCreditoSoliOriginal(super.getEntity("",entity.getTipoNotaCreditoSoliOriginal(),resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoNotaCreditoSoliOriginal(this.getEntityTipoNotaCreditoSoli("",entity.getTipoNotaCreditoSoliOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoNotaCreditoSolis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoNotaCreditoSoli> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoNotaCreditoSoli> entities = new  ArrayList<TipoNotaCreditoSoli>();
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		  
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
	
	public  List<TipoNotaCreditoSoli> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoNotaCreditoSoli> entities = new  ArrayList<TipoNotaCreditoSoli>();
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoNotaCreditoSoli();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoNotaCreditoSoli();
					//entity.setMapTipoNotaCreditoSoli(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoNotaCreditoSoliValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoNotaCreditoSoli().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
					entity=TipoNotaCreditoSoliDataAccess.getEntityTipoNotaCreditoSoli("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoNotaCreditoSoliOriginal( new TipoNotaCreditoSoli());
					////entity.setTipoNotaCreditoSoliOriginal(super.getEntity("",entity.getTipoNotaCreditoSoliOriginal(),resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoNotaCreditoSoliOriginal(this.getEntityTipoNotaCreditoSoli("",entity.getTipoNotaCreditoSoliOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoNotaCreditoSolis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoNotaCreditoSoli getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		  
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
	
	public  TipoNotaCreditoSoli getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoNotaCreditoSoli();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoNotaCreditoSoli();
					//entity.setMapTipoNotaCreditoSoli(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoNotaCreditoSoliValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoNotaCreditoSoli().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
					entity=TipoNotaCreditoSoliDataAccess.getEntityTipoNotaCreditoSoli("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoNotaCreditoSoliOriginal( new TipoNotaCreditoSoli());
					////entity.setTipoNotaCreditoSoliOriginal(super.getEntity("",entity.getTipoNotaCreditoSoliOriginal(),resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoNotaCreditoSoliOriginal(this.getEntityTipoNotaCreditoSoli("",entity.getTipoNotaCreditoSoliOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoNotaCreditoSoli(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoNotaCreditoSoli getEntityTipoNotaCreditoSoli(String strPrefijo,TipoNotaCreditoSoli entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoNotaCreditoSoli.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoNotaCreditoSoli.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoNotaCreditoSoliDataAccess.setFieldReflectionTipoNotaCreditoSoli(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoNotaCreditoSoli=TipoNotaCreditoSoliConstantesFunciones.getTodosTiposColumnasTipoNotaCreditoSoli();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoNotaCreditoSoli) {
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
							field = TipoNotaCreditoSoli.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoNotaCreditoSoli.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoNotaCreditoSoliDataAccess.setFieldReflectionTipoNotaCreditoSoli(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoNotaCreditoSoli(Field field,String strPrefijo,String sColumn,TipoNotaCreditoSoli entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoNotaCreditoSoliConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoNotaCreditoSoliConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoNotaCreditoSoliConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoNotaCreditoSoliConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoNotaCreditoSoli>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoNotaCreditoSoli> entities = new  ArrayList<TipoNotaCreditoSoli>();
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoNotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoNotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoNotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoNotaCreditoSoli();
					entity=super.getEntity("",entity,resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoNotaCreditoSoli("",entity,resultSet);
					
					//entity.setTipoNotaCreditoSoliOriginal( new TipoNotaCreditoSoli());
					//entity.setTipoNotaCreditoSoliOriginal(super.getEntity("",entity.getTipoNotaCreditoSoliOriginal(),resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoNotaCreditoSoliOriginal(this.getEntityTipoNotaCreditoSoli("",entity.getTipoNotaCreditoSoliOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoNotaCreditoSolis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoNotaCreditoSoli>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoNotaCreditoSoli> entities = new  ArrayList<TipoNotaCreditoSoli>();
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoNotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoNotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoNotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoNotaCreditoSoli> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoNotaCreditoSoli> entities = new  ArrayList<TipoNotaCreditoSoli>();
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		  
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
	
	public  List<TipoNotaCreditoSoli> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoNotaCreditoSoli> entities = new  ArrayList<TipoNotaCreditoSoli>();
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoNotaCreditoSoli();
      	    	entity=super.getEntity("",entity,resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoNotaCreditoSoli("",entity,resultSet);
      	    	
				//entity.setTipoNotaCreditoSoliOriginal( new TipoNotaCreditoSoli());
      	    	//entity.setTipoNotaCreditoSoliOriginal(super.getEntity("",entity.getTipoNotaCreditoSoliOriginal(),resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoNotaCreditoSoliOriginal(this.getEntityTipoNotaCreditoSoli("",entity.getTipoNotaCreditoSoliOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoNotaCreditoSolis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoNotaCreditoSoli> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoNotaCreditoSoli> entities = new  ArrayList<TipoNotaCreditoSoli>();
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		  
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
	
	public  List<TipoNotaCreditoSoli> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoNotaCreditoSoli> entities = new  ArrayList<TipoNotaCreditoSoli>();
		TipoNotaCreditoSoli entity = new TipoNotaCreditoSoli();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoNotaCreditoSoli();
      	    	entity=super.getEntity("",entity,resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoNotaCreditoSoli("",entity,resultSet);
      	    	
				//entity.setTipoNotaCreditoSoliOriginal( new TipoNotaCreditoSoli());
      	    	//entity.setTipoNotaCreditoSoliOriginal(super.getEntity("",entity.getTipoNotaCreditoSoliOriginal(),resultSet,TipoNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoNotaCreditoSoliOriginal(this.getEntityTipoNotaCreditoSoli("",entity.getTipoNotaCreditoSoliOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoNotaCreditoSolis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoNotaCreditoSoli getEntityTipoNotaCreditoSoli(String strPrefijo,TipoNotaCreditoSoli entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoNotaCreditoSoliConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoNotaCreditoSoliConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoNotaCreditoSoliConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoNotaCreditoSoli(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoNotaCreditoSoli entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoNotaCreditoSoliDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoNotaCreditoSoliDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoNotaCreditoSoliDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoNotaCreditoSoliDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoNotaCreditoSoliConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoNotaCreditoSoliDataAccess.TABLENAME,TipoNotaCreditoSoliDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoNotaCreditoSoliDataAccess.setTipoNotaCreditoSoliOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<NotaCreditoSoli> getNotaCreditoSolis(Connexion connexion,TipoNotaCreditoSoli tiponotacreditosoli)throws SQLException,Exception {

		List<NotaCreditoSoli> notacreditosolis= new ArrayList<NotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+".tipo_nota_credito_soli ON "+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli.id_tipo_nota_credito_soli="+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+".tipo_nota_credito_soli.id WHERE "+TipoNotaCreditoSoliConstantesFunciones.SCHEMA+".tipo_nota_credito_soli.id="+String.valueOf(tiponotacreditosoli.getId());
			} else {
				sQuery=" INNER JOIN notacreditosoli.TipoNotaCreditoSoli WHERE notacreditosoli.TipoNotaCreditoSoli.id="+String.valueOf(tiponotacreditosoli.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoSoliDataAccess notacreditosoliDataAccess=new NotaCreditoSoliDataAccess();

			notacreditosoliDataAccess.setConnexionType(this.connexionType);
			notacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditosolis;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoNotaCreditoSoli tiponotacreditosoli) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tiponotacreditosoli.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tiponotacreditosoli.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tiponotacreditosoli.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tiponotacreditosoli.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tiponotacreditosoli.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tiponotacreditosoli.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tiponotacreditosoli.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tiponotacreditosoli.getId());
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
	
	public void setIsNewIsChangedFalseTipoNotaCreditoSoli(TipoNotaCreditoSoli tiponotacreditosoli)throws Exception  {		
		tiponotacreditosoli.setIsNew(false);
		tiponotacreditosoli.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoNotaCreditoSolis(List<TipoNotaCreditoSoli> tiponotacreditosolis)throws Exception  {				
		for(TipoNotaCreditoSoli tiponotacreditosoli:tiponotacreditosolis) {
			tiponotacreditosoli.setIsNew(false);
			tiponotacreditosoli.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoNotaCreditoSoli(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
