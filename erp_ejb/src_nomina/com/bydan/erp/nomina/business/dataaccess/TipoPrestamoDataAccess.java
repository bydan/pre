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
import com.bydan.erp.nomina.util.*;//TipoPrestamoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class TipoPrestamoDataAccess extends  TipoPrestamoDataAccessAdditional{ //TipoPrestamoDataAccessAdditional,DataAccessHelper<TipoPrestamo>
	//static Logger logger = Logger.getLogger(TipoPrestamoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_prestamo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_rubro_emplea,id_cuenta_contable,codigo,nombre,con_pago)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_rubro_emplea=?,id_cuenta_contable=?,codigo=?,nombre=?,con_pago=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoprestamo from "+TipoPrestamoConstantesFunciones.SPERSISTENCENAME+" tipoprestamo";
	public static String QUERYSELECTNATIVE="select "+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".id,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".version_row,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".id_empresa,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".id_rubro_emplea,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".codigo,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".nombre,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".con_pago from "+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME;//+" as "+TipoPrestamoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".id,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".version_row,"+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+".codigo from "+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME;//+" as "+TipoPrestamoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoPrestamoConstantesFunciones.SCHEMA+"."+TipoPrestamoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_rubro_emplea=?,id_cuenta_contable=?,codigo=?,nombre=?,con_pago=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOPRESTAMO_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOPRESTAMO_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOPRESTAMO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOPRESTAMO_SELECT(?,?)";
	
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
	
	
	protected TipoPrestamoDataAccessAdditional tipoprestamoDataAccessAdditional=null;
	
	public TipoPrestamoDataAccessAdditional getTipoPrestamoDataAccessAdditional() {
		return this.tipoprestamoDataAccessAdditional;
	}
	
	public void setTipoPrestamoDataAccessAdditional(TipoPrestamoDataAccessAdditional tipoprestamoDataAccessAdditional) {
		try {
			this.tipoprestamoDataAccessAdditional=tipoprestamoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoPrestamoDataAccess() {
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
		TipoPrestamoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoPrestamoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoPrestamoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoPrestamoOriginal(TipoPrestamo tipoprestamo)throws Exception  {
		tipoprestamo.setTipoPrestamoOriginal((TipoPrestamo)tipoprestamo.clone());		
	}
	
	public void setTipoPrestamosOriginal(List<TipoPrestamo> tipoprestamos)throws Exception  {
		
		for(TipoPrestamo tipoprestamo:tipoprestamos){
			tipoprestamo.setTipoPrestamoOriginal((TipoPrestamo)tipoprestamo.clone());
		}
	}
	
	public static void setTipoPrestamoOriginalStatic(TipoPrestamo tipoprestamo)throws Exception  {
		tipoprestamo.setTipoPrestamoOriginal((TipoPrestamo)tipoprestamo.clone());		
	}
	
	public static void setTipoPrestamosOriginalStatic(List<TipoPrestamo> tipoprestamos)throws Exception  {
		
		for(TipoPrestamo tipoprestamo:tipoprestamos){
			tipoprestamo.setTipoPrestamoOriginal((TipoPrestamo)tipoprestamo.clone());
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
	
	public  TipoPrestamo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoPrestamo entity = new TipoPrestamo();		
		
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
	
	public  TipoPrestamo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoPrestamo entity = new TipoPrestamo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPrestamoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.TipoPrestamo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoPrestamoOriginal(new TipoPrestamo());
      	    	entity=super.getEntity("",entity,resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoPrestamo("",entity,resultSet); 
				
				//entity.setTipoPrestamoOriginal(super.getEntity("",entity.getTipoPrestamoOriginal(),resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrestamoOriginal(this.getEntityTipoPrestamo("",entity.getTipoPrestamoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoPrestamo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoPrestamo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoPrestamo entity = new TipoPrestamo();
				
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
	
	public  TipoPrestamo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoPrestamo entity = new TipoPrestamo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPrestamoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoPrestamo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoPrestamoOriginal(new TipoPrestamo());
      	    	entity=super.getEntity("",entity,resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoPrestamo("",entity,resultSet);    
				
				//entity.setTipoPrestamoOriginal(super.getEntity("",entity.getTipoPrestamoOriginal(),resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrestamoOriginal(this.getEntityTipoPrestamo("",entity.getTipoPrestamoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoPrestamo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoPrestamo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoPrestamo entity = new TipoPrestamo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPrestamoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoPrestamo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoPrestamo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoPrestamo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoPrestamo> entities = new  ArrayList<TipoPrestamo>();
		TipoPrestamo entity = new TipoPrestamo();		  
		
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
	
	public  List<TipoPrestamo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoPrestamo> entities = new  ArrayList<TipoPrestamo>();
		TipoPrestamo entity = new TipoPrestamo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPrestamoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrestamo();
      	    	entity=super.getEntity("",entity,resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoPrestamo("",entity,resultSet);
      	    	
				//entity.setTipoPrestamoOriginal( new TipoPrestamo());
      	    	//entity.setTipoPrestamoOriginal(super.getEntity("",entity.getTipoPrestamoOriginal(),resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrestamoOriginal(this.getEntityTipoPrestamo("",entity.getTipoPrestamoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoPrestamos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoPrestamo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoPrestamo> entities = new  ArrayList<TipoPrestamo>();
		TipoPrestamo entity = new TipoPrestamo();		  
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
	
	public  List<TipoPrestamo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoPrestamo> entities = new  ArrayList<TipoPrestamo>();
		TipoPrestamo entity = new TipoPrestamo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrestamo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoPrestamo();
					//entity.setMapTipoPrestamo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoPrestamoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoPrestamo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA);         		
					entity=TipoPrestamoDataAccess.getEntityTipoPrestamo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoPrestamoOriginal( new TipoPrestamo());
					////entity.setTipoPrestamoOriginal(super.getEntity("",entity.getTipoPrestamoOriginal(),resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoPrestamoOriginal(this.getEntityTipoPrestamo("",entity.getTipoPrestamoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoPrestamos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoPrestamo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoPrestamo entity = new TipoPrestamo();		  
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
	
	public  TipoPrestamo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoPrestamo entity = new TipoPrestamo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrestamo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoPrestamo();
					//entity.setMapTipoPrestamo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoPrestamoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoPrestamo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA);         		
					entity=TipoPrestamoDataAccess.getEntityTipoPrestamo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoPrestamoOriginal( new TipoPrestamo());
					////entity.setTipoPrestamoOriginal(super.getEntity("",entity.getTipoPrestamoOriginal(),resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoPrestamoOriginal(this.getEntityTipoPrestamo("",entity.getTipoPrestamoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoPrestamo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoPrestamo getEntityTipoPrestamo(String strPrefijo,TipoPrestamo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoPrestamo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoPrestamo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoPrestamoDataAccess.setFieldReflectionTipoPrestamo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoPrestamo=TipoPrestamoConstantesFunciones.getTodosTiposColumnasTipoPrestamo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoPrestamo) {
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
							field = TipoPrestamo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoPrestamo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoPrestamoDataAccess.setFieldReflectionTipoPrestamo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoPrestamo(Field field,String strPrefijo,String sColumn,TipoPrestamo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoPrestamoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoPrestamoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoPrestamoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoPrestamoConstantesFunciones.IDRUBROEMPLEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoPrestamoConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoPrestamoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoPrestamoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoPrestamoConstantesFunciones.CONPAGO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoPrestamo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoPrestamo> entities = new  ArrayList<TipoPrestamo>();
		TipoPrestamo entity = new TipoPrestamo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPrestamoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoPrestamo();
					entity=super.getEntity("",entity,resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoPrestamo("",entity,resultSet);
					
					//entity.setTipoPrestamoOriginal( new TipoPrestamo());
					//entity.setTipoPrestamoOriginal(super.getEntity("",entity.getTipoPrestamoOriginal(),resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoPrestamoOriginal(this.getEntityTipoPrestamo("",entity.getTipoPrestamoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoPrestamos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoPrestamo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoPrestamo> entities = new  ArrayList<TipoPrestamo>();
		TipoPrestamo entity = new TipoPrestamo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPrestamoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoPrestamo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrestamo> entities = new  ArrayList<TipoPrestamo>();
		TipoPrestamo entity = new TipoPrestamo();		  
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
	
	public  List<TipoPrestamo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrestamo> entities = new  ArrayList<TipoPrestamo>();
		TipoPrestamo entity = new TipoPrestamo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrestamo();
      	    	entity=super.getEntity("",entity,resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoPrestamo("",entity,resultSet);
      	    	
				//entity.setTipoPrestamoOriginal( new TipoPrestamo());
      	    	//entity.setTipoPrestamoOriginal(super.getEntity("",entity.getTipoPrestamoOriginal(),resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrestamoOriginal(this.getEntityTipoPrestamo("",entity.getTipoPrestamoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoPrestamos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoPrestamo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrestamo> entities = new  ArrayList<TipoPrestamo>();
		TipoPrestamo entity = new TipoPrestamo();		  
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
	
	public  List<TipoPrestamo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrestamo> entities = new  ArrayList<TipoPrestamo>();
		TipoPrestamo entity = new TipoPrestamo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrestamo();
      	    	entity=super.getEntity("",entity,resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoPrestamo("",entity,resultSet);
      	    	
				//entity.setTipoPrestamoOriginal( new TipoPrestamo());
      	    	//entity.setTipoPrestamoOriginal(super.getEntity("",entity.getTipoPrestamoOriginal(),resultSet,TipoPrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrestamoOriginal(this.getEntityTipoPrestamo("",entity.getTipoPrestamoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoPrestamos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoPrestamo getEntityTipoPrestamo(String strPrefijo,TipoPrestamo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoPrestamoConstantesFunciones.IDEMPRESA));
				entity.setid_rubro_emplea(resultSet.getLong(strPrefijo+TipoPrestamoConstantesFunciones.IDRUBROEMPLEA));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+TipoPrestamoConstantesFunciones.IDCUENTACONTABLE));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoPrestamoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoPrestamoConstantesFunciones.NOMBRE));
				entity.setcon_pago(resultSet.getBoolean(strPrefijo+TipoPrestamoConstantesFunciones.CONPAGO));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoPrestamoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoPrestamo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoPrestamo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoPrestamoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoPrestamoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoPrestamoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoPrestamoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoPrestamoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoPrestamoDataAccess.TABLENAME,TipoPrestamoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoPrestamoDataAccess.setTipoPrestamoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoPrestamo reltipoprestamo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipoprestamo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public RubroEmplea getRubroEmplea(Connexion connexion,TipoPrestamo reltipoprestamo)throws SQLException,Exception {

		RubroEmplea rubroemplea= new RubroEmplea();

		try {
			RubroEmpleaDataAccess rubroempleaDataAccess=new RubroEmpleaDataAccess();

			rubroempleaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rubroempleaDataAccess.setConnexionType(this.connexionType);
			rubroempleaDataAccess.setParameterDbType(this.parameterDbType);

			rubroemplea=rubroempleaDataAccess.getEntity(connexion,reltipoprestamo.getid_rubro_emplea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroemplea;

	}

	public CuentaContable getCuentaContable(Connexion connexion,TipoPrestamo reltipoprestamo)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltipoprestamo.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<Prestamo> getPrestamos(Connexion connexion,TipoPrestamo tipoprestamo)throws SQLException,Exception {

		List<Prestamo> prestamos= new ArrayList<Prestamo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrestamoConstantesFunciones.SCHEMA+".tipo_prestamo ON "+PrestamoConstantesFunciones.SCHEMA+".prestamo.id_tipo_prestamo="+TipoPrestamoConstantesFunciones.SCHEMA+".tipo_prestamo.id WHERE "+TipoPrestamoConstantesFunciones.SCHEMA+".tipo_prestamo.id="+String.valueOf(tipoprestamo.getId());
			} else {
				sQuery=" INNER JOIN prestamo.TipoPrestamo WHERE prestamo.TipoPrestamo.id="+String.valueOf(tipoprestamo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PrestamoDataAccess prestamoDataAccess=new PrestamoDataAccess();

			prestamoDataAccess.setConnexionType(this.connexionType);
			prestamoDataAccess.setParameterDbType(this.parameterDbType);
			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return prestamos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoPrestamo tipoprestamo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoprestamo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipoprestamo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_rubro_emplea=new ParameterValue<Long>();
					parameterMaintenanceValueid_rubro_emplea.setValue(tipoprestamo.getid_rubro_emplea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_rubro_emplea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(tipoprestamo.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipoprestamo.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoprestamo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_pago=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_pago.setValue(tipoprestamo.getcon_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_pago);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoprestamo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoprestamo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoprestamo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoprestamo.getId());
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
	
	public void setIsNewIsChangedFalseTipoPrestamo(TipoPrestamo tipoprestamo)throws Exception  {		
		tipoprestamo.setIsNew(false);
		tipoprestamo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoPrestamos(List<TipoPrestamo> tipoprestamos)throws Exception  {				
		for(TipoPrestamo tipoprestamo:tipoprestamos) {
			tipoprestamo.setIsNew(false);
			tipoprestamo.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoPrestamo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
