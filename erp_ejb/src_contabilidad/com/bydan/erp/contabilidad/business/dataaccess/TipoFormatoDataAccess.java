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
import com.bydan.erp.contabilidad.util.*;//TipoFormatoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;




@SuppressWarnings("unused")
final public class TipoFormatoDataAccess extends  TipoFormatoDataAccessAdditional{ //TipoFormatoDataAccessAdditional,DataAccessHelper<TipoFormato>
	//static Logger logger = Logger.getLogger(TipoFormatoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_formato";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre)values(current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoformato from "+TipoFormatoConstantesFunciones.SPERSISTENCENAME+" tipoformato";
	public static String QUERYSELECTNATIVE="select "+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+".id,"+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+".version_row,"+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+".id_empresa,"+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+".nombre from "+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME;//+" as "+TipoFormatoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+".id,"+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+".version_row,"+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+".nombre from "+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME;//+" as "+TipoFormatoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOFORMATO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOFORMATO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOFORMATO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOFORMATO_SELECT(?,?)";
	
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
	
	
	protected TipoFormatoDataAccessAdditional tipoformatoDataAccessAdditional=null;
	
	public TipoFormatoDataAccessAdditional getTipoFormatoDataAccessAdditional() {
		return this.tipoformatoDataAccessAdditional;
	}
	
	public void setTipoFormatoDataAccessAdditional(TipoFormatoDataAccessAdditional tipoformatoDataAccessAdditional) {
		try {
			this.tipoformatoDataAccessAdditional=tipoformatoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoFormatoDataAccess() {
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
		TipoFormatoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoFormatoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoFormatoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoFormatoOriginal(TipoFormato tipoformato)throws Exception  {
		tipoformato.setTipoFormatoOriginal((TipoFormato)tipoformato.clone());		
	}
	
	public void setTipoFormatosOriginal(List<TipoFormato> tipoformatos)throws Exception  {
		
		for(TipoFormato tipoformato:tipoformatos){
			tipoformato.setTipoFormatoOriginal((TipoFormato)tipoformato.clone());
		}
	}
	
	public static void setTipoFormatoOriginalStatic(TipoFormato tipoformato)throws Exception  {
		tipoformato.setTipoFormatoOriginal((TipoFormato)tipoformato.clone());		
	}
	
	public static void setTipoFormatosOriginalStatic(List<TipoFormato> tipoformatos)throws Exception  {
		
		for(TipoFormato tipoformato:tipoformatos){
			tipoformato.setTipoFormatoOriginal((TipoFormato)tipoformato.clone());
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
	
	public  TipoFormato getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoFormato entity = new TipoFormato();		
		
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
	
	public  TipoFormato getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoFormato entity = new TipoFormato();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoFormatoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoFormatoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoFormato.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoFormatoOriginal(new TipoFormato());
      	    	entity=super.getEntity("",entity,resultSet,TipoFormatoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoFormato("",entity,resultSet); 
				
				//entity.setTipoFormatoOriginal(super.getEntity("",entity.getTipoFormatoOriginal(),resultSet,TipoFormatoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFormatoOriginal(this.getEntityTipoFormato("",entity.getTipoFormatoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoFormato(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoFormato getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoFormato entity = new TipoFormato();
				
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
	
	public  TipoFormato getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoFormato entity = new TipoFormato();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoFormatoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoFormatoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFormatoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoFormato.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoFormatoOriginal(new TipoFormato());
      	    	entity=super.getEntity("",entity,resultSet,TipoFormatoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoFormato("",entity,resultSet);    
				
				//entity.setTipoFormatoOriginal(super.getEntity("",entity.getTipoFormatoOriginal(),resultSet,TipoFormatoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFormatoOriginal(this.getEntityTipoFormato("",entity.getTipoFormatoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoFormato(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoFormato
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoFormato entity = new TipoFormato();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoFormatoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoFormatoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFormatoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoFormato.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoFormato(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoFormato> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoFormato> entities = new  ArrayList<TipoFormato>();
		TipoFormato entity = new TipoFormato();		  
		
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
	
	public  List<TipoFormato> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoFormato> entities = new  ArrayList<TipoFormato>();
		TipoFormato entity = new TipoFormato();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoFormatoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoFormatoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFormatoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFormato();
      	    	entity=super.getEntity("",entity,resultSet,TipoFormatoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoFormato("",entity,resultSet);
      	    	
				//entity.setTipoFormatoOriginal( new TipoFormato());
      	    	//entity.setTipoFormatoOriginal(super.getEntity("",entity.getTipoFormatoOriginal(),resultSet,TipoFormatoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFormatoOriginal(this.getEntityTipoFormato("",entity.getTipoFormatoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoFormatos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFormato(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoFormato> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoFormato> entities = new  ArrayList<TipoFormato>();
		TipoFormato entity = new TipoFormato();		  
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
	
	public  List<TipoFormato> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoFormato> entities = new  ArrayList<TipoFormato>();
		TipoFormato entity = new TipoFormato();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFormato();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoFormato();
					//entity.setMapTipoFormato(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoFormatoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoFormato().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoFormatoDataAccess.ISWITHSCHEMA);         		
					entity=TipoFormatoDataAccess.getEntityTipoFormato("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoFormatoOriginal( new TipoFormato());
					////entity.setTipoFormatoOriginal(super.getEntity("",entity.getTipoFormatoOriginal(),resultSet,TipoFormatoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoFormatoOriginal(this.getEntityTipoFormato("",entity.getTipoFormatoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoFormatos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFormato(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoFormato getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoFormato entity = new TipoFormato();		  
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
	
	public  TipoFormato getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoFormato entity = new TipoFormato();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFormato();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoFormato();
					//entity.setMapTipoFormato(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoFormatoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoFormato().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoFormatoDataAccess.ISWITHSCHEMA);         		
					entity=TipoFormatoDataAccess.getEntityTipoFormato("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoFormatoOriginal( new TipoFormato());
					////entity.setTipoFormatoOriginal(super.getEntity("",entity.getTipoFormatoOriginal(),resultSet,TipoFormatoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoFormatoOriginal(this.getEntityTipoFormato("",entity.getTipoFormatoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoFormato(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFormato(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoFormato getEntityTipoFormato(String strPrefijo,TipoFormato entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoFormato.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoFormato.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoFormatoDataAccess.setFieldReflectionTipoFormato(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoFormato=TipoFormatoConstantesFunciones.getTodosTiposColumnasTipoFormato();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoFormato) {
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
							field = TipoFormato.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoFormato.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoFormatoDataAccess.setFieldReflectionTipoFormato(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoFormato(Field field,String strPrefijo,String sColumn,TipoFormato entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoFormatoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoFormatoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoFormatoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoFormatoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoFormato>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoFormato> entities = new  ArrayList<TipoFormato>();
		TipoFormato entity = new TipoFormato();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoFormatoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoFormatoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFormatoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoFormato();
					entity=super.getEntity("",entity,resultSet,TipoFormatoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoFormato("",entity,resultSet);
					
					//entity.setTipoFormatoOriginal( new TipoFormato());
					//entity.setTipoFormatoOriginal(super.getEntity("",entity.getTipoFormatoOriginal(),resultSet,TipoFormatoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoFormatoOriginal(this.getEntityTipoFormato("",entity.getTipoFormatoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoFormatos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFormato(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoFormato>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoFormato> entities = new  ArrayList<TipoFormato>();
		TipoFormato entity = new TipoFormato();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoFormatoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoFormatoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFormatoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoFormato> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoFormato> entities = new  ArrayList<TipoFormato>();
		TipoFormato entity = new TipoFormato();		  
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
	
	public  List<TipoFormato> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoFormato> entities = new  ArrayList<TipoFormato>();
		TipoFormato entity = new TipoFormato();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFormato();
      	    	entity=super.getEntity("",entity,resultSet,TipoFormatoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoFormato("",entity,resultSet);
      	    	
				//entity.setTipoFormatoOriginal( new TipoFormato());
      	    	//entity.setTipoFormatoOriginal(super.getEntity("",entity.getTipoFormatoOriginal(),resultSet,TipoFormatoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFormatoOriginal(this.getEntityTipoFormato("",entity.getTipoFormatoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoFormatos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFormato(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoFormato> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoFormato> entities = new  ArrayList<TipoFormato>();
		TipoFormato entity = new TipoFormato();		  
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
	
	public  List<TipoFormato> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoFormato> entities = new  ArrayList<TipoFormato>();
		TipoFormato entity = new TipoFormato();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFormato();
      	    	entity=super.getEntity("",entity,resultSet,TipoFormatoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoFormato("",entity,resultSet);
      	    	
				//entity.setTipoFormatoOriginal( new TipoFormato());
      	    	//entity.setTipoFormatoOriginal(super.getEntity("",entity.getTipoFormatoOriginal(),resultSet,TipoFormatoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFormatoOriginal(this.getEntityTipoFormato("",entity.getTipoFormatoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoFormatos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoFormato getEntityTipoFormato(String strPrefijo,TipoFormato entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoFormatoConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+TipoFormatoConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoFormatoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoFormato(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoFormato entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoFormatoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoFormatoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoFormatoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoFormatoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoFormatoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoFormatoDataAccess.TABLENAME,TipoFormatoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoFormatoDataAccess.setTipoFormatoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoFormato reltipoformato)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipoformato.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<Formato> getFormatos(Connexion connexion,TipoFormato tipoformato)throws SQLException,Exception {

		List<Formato> formatos= new ArrayList<Formato>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoFormatoConstantesFunciones.SCHEMA+".tipo_formato ON "+FormatoConstantesFunciones.SCHEMA+".formato.id_tipo_formato="+TipoFormatoConstantesFunciones.SCHEMA+".tipo_formato.id WHERE "+TipoFormatoConstantesFunciones.SCHEMA+".tipo_formato.id="+String.valueOf(tipoformato.getId());
			} else {
				sQuery=" INNER JOIN formato.TipoFormato WHERE formato.TipoFormato.id="+String.valueOf(tipoformato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);
			formatos=formatoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formatos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoFormato tipoformato) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoformato.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipoformato.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoformato.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoformato.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoformato.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoformato.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoformato.getId());
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
	
	public void setIsNewIsChangedFalseTipoFormato(TipoFormato tipoformato)throws Exception  {		
		tipoformato.setIsNew(false);
		tipoformato.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoFormatos(List<TipoFormato> tipoformatos)throws Exception  {				
		for(TipoFormato tipoformato:tipoformatos) {
			tipoformato.setIsNew(false);
			tipoformato.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoFormato(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
