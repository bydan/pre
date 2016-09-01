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
import com.bydan.erp.cartera.util.*;//TipoGarantiaEmpresaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;




@SuppressWarnings("unused")
final public class TipoGarantiaEmpresaDataAccess extends  TipoGarantiaEmpresaDataAccessAdditional{ //TipoGarantiaEmpresaDataAccessAdditional,DataAccessHelper<TipoGarantiaEmpresa>
	//static Logger logger = Logger.getLogger(TipoGarantiaEmpresaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_garantia_empresa";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,es_defecto)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,es_defecto=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipogarantiaempresa from "+TipoGarantiaEmpresaConstantesFunciones.SPERSISTENCENAME+" tipogarantiaempresa";
	public static String QUERYSELECTNATIVE="select "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".id,"+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".codigo,"+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".es_defecto from "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoGarantiaEmpresaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".id,"+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+".codigo from "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoGarantiaEmpresaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+"."+TipoGarantiaEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,es_defecto=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOGARANTIAEMPRESA_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOGARANTIAEMPRESA_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOGARANTIAEMPRESA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOGARANTIAEMPRESA_SELECT(?,?)";
	
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
	
	
	protected TipoGarantiaEmpresaDataAccessAdditional tipogarantiaempresaDataAccessAdditional=null;
	
	public TipoGarantiaEmpresaDataAccessAdditional getTipoGarantiaEmpresaDataAccessAdditional() {
		return this.tipogarantiaempresaDataAccessAdditional;
	}
	
	public void setTipoGarantiaEmpresaDataAccessAdditional(TipoGarantiaEmpresaDataAccessAdditional tipogarantiaempresaDataAccessAdditional) {
		try {
			this.tipogarantiaempresaDataAccessAdditional=tipogarantiaempresaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoGarantiaEmpresaDataAccess() {
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
		TipoGarantiaEmpresaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoGarantiaEmpresaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoGarantiaEmpresaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoGarantiaEmpresaOriginal(TipoGarantiaEmpresa tipogarantiaempresa)throws Exception  {
		tipogarantiaempresa.setTipoGarantiaEmpresaOriginal((TipoGarantiaEmpresa)tipogarantiaempresa.clone());		
	}
	
	public void setTipoGarantiaEmpresasOriginal(List<TipoGarantiaEmpresa> tipogarantiaempresas)throws Exception  {
		
		for(TipoGarantiaEmpresa tipogarantiaempresa:tipogarantiaempresas){
			tipogarantiaempresa.setTipoGarantiaEmpresaOriginal((TipoGarantiaEmpresa)tipogarantiaempresa.clone());
		}
	}
	
	public static void setTipoGarantiaEmpresaOriginalStatic(TipoGarantiaEmpresa tipogarantiaempresa)throws Exception  {
		tipogarantiaempresa.setTipoGarantiaEmpresaOriginal((TipoGarantiaEmpresa)tipogarantiaempresa.clone());		
	}
	
	public static void setTipoGarantiaEmpresasOriginalStatic(List<TipoGarantiaEmpresa> tipogarantiaempresas)throws Exception  {
		
		for(TipoGarantiaEmpresa tipogarantiaempresa:tipogarantiaempresas){
			tipogarantiaempresa.setTipoGarantiaEmpresaOriginal((TipoGarantiaEmpresa)tipogarantiaempresa.clone());
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
	
	public  TipoGarantiaEmpresa getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		
		
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
	
	public  TipoGarantiaEmpresa getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGarantiaEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGarantiaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.TipoGarantiaEmpresa.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoGarantiaEmpresaOriginal(new TipoGarantiaEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoGarantiaEmpresa("",entity,resultSet); 
				
				//entity.setTipoGarantiaEmpresaOriginal(super.getEntity("",entity.getTipoGarantiaEmpresaOriginal(),resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGarantiaEmpresaOriginal(this.getEntityTipoGarantiaEmpresa("",entity.getTipoGarantiaEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoGarantiaEmpresa(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoGarantiaEmpresa getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();
				
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
	
	public  TipoGarantiaEmpresa getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGarantiaEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGarantiaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGarantiaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoGarantiaEmpresa.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoGarantiaEmpresaOriginal(new TipoGarantiaEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoGarantiaEmpresa("",entity,resultSet);    
				
				//entity.setTipoGarantiaEmpresaOriginal(super.getEntity("",entity.getTipoGarantiaEmpresaOriginal(),resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGarantiaEmpresaOriginal(this.getEntityTipoGarantiaEmpresa("",entity.getTipoGarantiaEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoGarantiaEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoGarantiaEmpresa
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGarantiaEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGarantiaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGarantiaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoGarantiaEmpresa.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoGarantiaEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoGarantiaEmpresa> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoGarantiaEmpresa> entities = new  ArrayList<TipoGarantiaEmpresa>();
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		  
		
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
	
	public  List<TipoGarantiaEmpresa> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoGarantiaEmpresa> entities = new  ArrayList<TipoGarantiaEmpresa>();
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGarantiaEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGarantiaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGarantiaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGarantiaEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGarantiaEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoGarantiaEmpresaOriginal( new TipoGarantiaEmpresa());
      	    	//entity.setTipoGarantiaEmpresaOriginal(super.getEntity("",entity.getTipoGarantiaEmpresaOriginal(),resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGarantiaEmpresaOriginal(this.getEntityTipoGarantiaEmpresa("",entity.getTipoGarantiaEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGarantiaEmpresas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGarantiaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoGarantiaEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoGarantiaEmpresa> entities = new  ArrayList<TipoGarantiaEmpresa>();
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		  
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
	
	public  List<TipoGarantiaEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoGarantiaEmpresa> entities = new  ArrayList<TipoGarantiaEmpresa>();
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGarantiaEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoGarantiaEmpresa();
					//entity.setMapTipoGarantiaEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoGarantiaEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoGarantiaEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoGarantiaEmpresaDataAccess.getEntityTipoGarantiaEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoGarantiaEmpresaOriginal( new TipoGarantiaEmpresa());
					////entity.setTipoGarantiaEmpresaOriginal(super.getEntity("",entity.getTipoGarantiaEmpresaOriginal(),resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoGarantiaEmpresaOriginal(this.getEntityTipoGarantiaEmpresa("",entity.getTipoGarantiaEmpresaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGarantiaEmpresas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGarantiaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoGarantiaEmpresa getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		  
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
	
	public  TipoGarantiaEmpresa getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGarantiaEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoGarantiaEmpresa();
					//entity.setMapTipoGarantiaEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoGarantiaEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoGarantiaEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoGarantiaEmpresaDataAccess.getEntityTipoGarantiaEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoGarantiaEmpresaOriginal( new TipoGarantiaEmpresa());
					////entity.setTipoGarantiaEmpresaOriginal(super.getEntity("",entity.getTipoGarantiaEmpresaOriginal(),resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoGarantiaEmpresaOriginal(this.getEntityTipoGarantiaEmpresa("",entity.getTipoGarantiaEmpresaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoGarantiaEmpresa(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGarantiaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoGarantiaEmpresa getEntityTipoGarantiaEmpresa(String strPrefijo,TipoGarantiaEmpresa entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoGarantiaEmpresa.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoGarantiaEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoGarantiaEmpresaDataAccess.setFieldReflectionTipoGarantiaEmpresa(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoGarantiaEmpresa=TipoGarantiaEmpresaConstantesFunciones.getTodosTiposColumnasTipoGarantiaEmpresa();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoGarantiaEmpresa) {
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
							field = TipoGarantiaEmpresa.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoGarantiaEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoGarantiaEmpresaDataAccess.setFieldReflectionTipoGarantiaEmpresa(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoGarantiaEmpresa(Field field,String strPrefijo,String sColumn,TipoGarantiaEmpresa entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoGarantiaEmpresaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGarantiaEmpresaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGarantiaEmpresaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoGarantiaEmpresaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoGarantiaEmpresaConstantesFunciones.ESDEFECTO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoGarantiaEmpresa>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoGarantiaEmpresa> entities = new  ArrayList<TipoGarantiaEmpresa>();
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGarantiaEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGarantiaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGarantiaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoGarantiaEmpresa();
					entity=super.getEntity("",entity,resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoGarantiaEmpresa("",entity,resultSet);
					
					//entity.setTipoGarantiaEmpresaOriginal( new TipoGarantiaEmpresa());
					//entity.setTipoGarantiaEmpresaOriginal(super.getEntity("",entity.getTipoGarantiaEmpresaOriginal(),resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoGarantiaEmpresaOriginal(this.getEntityTipoGarantiaEmpresa("",entity.getTipoGarantiaEmpresaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoGarantiaEmpresas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGarantiaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoGarantiaEmpresa>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoGarantiaEmpresa> entities = new  ArrayList<TipoGarantiaEmpresa>();
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGarantiaEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGarantiaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGarantiaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoGarantiaEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGarantiaEmpresa> entities = new  ArrayList<TipoGarantiaEmpresa>();
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		  
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
	
	public  List<TipoGarantiaEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGarantiaEmpresa> entities = new  ArrayList<TipoGarantiaEmpresa>();
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGarantiaEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGarantiaEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoGarantiaEmpresaOriginal( new TipoGarantiaEmpresa());
      	    	//entity.setTipoGarantiaEmpresaOriginal(super.getEntity("",entity.getTipoGarantiaEmpresaOriginal(),resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGarantiaEmpresaOriginal(this.getEntityTipoGarantiaEmpresa("",entity.getTipoGarantiaEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoGarantiaEmpresas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGarantiaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoGarantiaEmpresa> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGarantiaEmpresa> entities = new  ArrayList<TipoGarantiaEmpresa>();
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		  
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
	
	public  List<TipoGarantiaEmpresa> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGarantiaEmpresa> entities = new  ArrayList<TipoGarantiaEmpresa>();
		TipoGarantiaEmpresa entity = new TipoGarantiaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGarantiaEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGarantiaEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoGarantiaEmpresaOriginal( new TipoGarantiaEmpresa());
      	    	//entity.setTipoGarantiaEmpresaOriginal(super.getEntity("",entity.getTipoGarantiaEmpresaOriginal(),resultSet,TipoGarantiaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGarantiaEmpresaOriginal(this.getEntityTipoGarantiaEmpresa("",entity.getTipoGarantiaEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGarantiaEmpresas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoGarantiaEmpresa getEntityTipoGarantiaEmpresa(String strPrefijo,TipoGarantiaEmpresa entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoGarantiaEmpresaConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoGarantiaEmpresaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoGarantiaEmpresaConstantesFunciones.NOMBRE));
				entity.setes_defecto(resultSet.getBoolean(strPrefijo+TipoGarantiaEmpresaConstantesFunciones.ESDEFECTO));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoGarantiaEmpresaConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoGarantiaEmpresa(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoGarantiaEmpresa entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoGarantiaEmpresaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoGarantiaEmpresaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoGarantiaEmpresaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoGarantiaEmpresaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoGarantiaEmpresaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoGarantiaEmpresaDataAccess.TABLENAME,TipoGarantiaEmpresaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoGarantiaEmpresaDataAccess.setTipoGarantiaEmpresaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoGarantiaEmpresa reltipogarantiaempresa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipogarantiaempresa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<Cliente> getClientes(Connexion connexion,TipoGarantiaEmpresa tipogarantiaempresa)throws SQLException,Exception {

		List<Cliente> clientes= new ArrayList<Cliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+".tipo_garantia_empresa ON "+ClienteConstantesFunciones.SCHEMA+".cliente.id_tipo_garantia_empresa="+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+".tipo_garantia_empresa.id WHERE "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+".tipo_garantia_empresa.id="+String.valueOf(tipogarantiaempresa.getId());
			} else {
				sQuery=" INNER JOIN cliente.TipoGarantiaEmpresa WHERE cliente.TipoGarantiaEmpresa.id="+String.valueOf(tipogarantiaempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clientes;

	}

	public List<GarantiaCliente> getGarantiaClientes(Connexion connexion,TipoGarantiaEmpresa tipogarantiaempresa)throws SQLException,Exception {

		List<GarantiaCliente> garantiaclientes= new ArrayList<GarantiaCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+".tipo_garantia_empresa ON "+GarantiaClienteConstantesFunciones.SCHEMA+".garantia_cliente.id_tipo_garantia_empresa="+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+".tipo_garantia_empresa.id WHERE "+TipoGarantiaEmpresaConstantesFunciones.SCHEMA+".tipo_garantia_empresa.id="+String.valueOf(tipogarantiaempresa.getId());
			} else {
				sQuery=" INNER JOIN garantiacliente.TipoGarantiaEmpresa WHERE garantiacliente.TipoGarantiaEmpresa.id="+String.valueOf(tipogarantiaempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GarantiaClienteDataAccess garantiaclienteDataAccess=new GarantiaClienteDataAccess();

			garantiaclienteDataAccess.setConnexionType(this.connexionType);
			garantiaclienteDataAccess.setParameterDbType(this.parameterDbType);
			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return garantiaclientes;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoGarantiaEmpresa tipogarantiaempresa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipogarantiaempresa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipogarantiaempresa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipogarantiaempresa.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipogarantiaempresa.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_defecto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_defecto.setValue(tipogarantiaempresa.getes_defecto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_defecto);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipogarantiaempresa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipogarantiaempresa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipogarantiaempresa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipogarantiaempresa.getId());
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
	
	public void setIsNewIsChangedFalseTipoGarantiaEmpresa(TipoGarantiaEmpresa tipogarantiaempresa)throws Exception  {		
		tipogarantiaempresa.setIsNew(false);
		tipogarantiaempresa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoGarantiaEmpresas(List<TipoGarantiaEmpresa> tipogarantiaempresas)throws Exception  {				
		for(TipoGarantiaEmpresa tipogarantiaempresa:tipogarantiaempresas) {
			tipogarantiaempresa.setIsNew(false);
			tipogarantiaempresa.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoGarantiaEmpresa(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
