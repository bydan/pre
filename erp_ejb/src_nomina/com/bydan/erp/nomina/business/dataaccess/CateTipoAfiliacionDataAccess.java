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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//CateTipoAfiliacionConstantesFunciones;


import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;




@SuppressWarnings("unused")
final public class CateTipoAfiliacionDataAccess extends  CateTipoAfiliacionDataAccessAdditional{ //CateTipoAfiliacionDataAccessAdditional,DataAccessHelper<CateTipoAfiliacion>
	//static Logger logger = Logger.getLogger(CateTipoAfiliacionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cate_tipo_afiliacion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre,es_defecto)values(?,current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?,es_defecto=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select catetipoafiliacion from "+CateTipoAfiliacionConstantesFunciones.SPERSISTENCENAME+" catetipoafiliacion";
	public static String QUERYSELECTNATIVE="select "+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+".id,"+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+".version_row,"+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+".codigo,"+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+".nombre,"+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+".es_defecto from "+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME;//+" as "+CateTipoAfiliacionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+".id,"+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+".version_row,"+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+".codigo from "+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME;//+" as "+CateTipoAfiliacionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CateTipoAfiliacionConstantesFunciones.SCHEMA+"."+CateTipoAfiliacionConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?,es_defecto=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CATETIPOAFILIACION_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CATETIPOAFILIACION_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CATETIPOAFILIACION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CATETIPOAFILIACION_SELECT(?,?)";
	
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
	
	
	protected CateTipoAfiliacionDataAccessAdditional catetipoafiliacionDataAccessAdditional=null;
	
	public CateTipoAfiliacionDataAccessAdditional getCateTipoAfiliacionDataAccessAdditional() {
		return this.catetipoafiliacionDataAccessAdditional;
	}
	
	public void setCateTipoAfiliacionDataAccessAdditional(CateTipoAfiliacionDataAccessAdditional catetipoafiliacionDataAccessAdditional) {
		try {
			this.catetipoafiliacionDataAccessAdditional=catetipoafiliacionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CateTipoAfiliacionDataAccess() {
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
		CateTipoAfiliacionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CateTipoAfiliacionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CateTipoAfiliacionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCateTipoAfiliacionOriginal(CateTipoAfiliacion catetipoafiliacion)throws Exception  {
		catetipoafiliacion.setCateTipoAfiliacionOriginal((CateTipoAfiliacion)catetipoafiliacion.clone());		
	}
	
	public void setCateTipoAfiliacionsOriginal(List<CateTipoAfiliacion> catetipoafiliacions)throws Exception  {
		
		for(CateTipoAfiliacion catetipoafiliacion:catetipoafiliacions){
			catetipoafiliacion.setCateTipoAfiliacionOriginal((CateTipoAfiliacion)catetipoafiliacion.clone());
		}
	}
	
	public static void setCateTipoAfiliacionOriginalStatic(CateTipoAfiliacion catetipoafiliacion)throws Exception  {
		catetipoafiliacion.setCateTipoAfiliacionOriginal((CateTipoAfiliacion)catetipoafiliacion.clone());		
	}
	
	public static void setCateTipoAfiliacionsOriginalStatic(List<CateTipoAfiliacion> catetipoafiliacions)throws Exception  {
		
		for(CateTipoAfiliacion catetipoafiliacion:catetipoafiliacions){
			catetipoafiliacion.setCateTipoAfiliacionOriginal((CateTipoAfiliacion)catetipoafiliacion.clone());
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
	
	public  CateTipoAfiliacion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		
		
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
	
	public  CateTipoAfiliacion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CateTipoAfiliacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CateTipoAfiliacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.CateTipoAfiliacion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCateTipoAfiliacionOriginal(new CateTipoAfiliacion());
      	    	entity=super.getEntity("",entity,resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCateTipoAfiliacion("",entity,resultSet); 
				
				//entity.setCateTipoAfiliacionOriginal(super.getEntity("",entity.getCateTipoAfiliacionOriginal(),resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCateTipoAfiliacionOriginal(this.getEntityCateTipoAfiliacion("",entity.getCateTipoAfiliacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCateTipoAfiliacion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CateTipoAfiliacion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CateTipoAfiliacion entity = new CateTipoAfiliacion();
				
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
	
	public  CateTipoAfiliacion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CateTipoAfiliacion entity = new CateTipoAfiliacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CateTipoAfiliacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CateTipoAfiliacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,CateTipoAfiliacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.CateTipoAfiliacion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCateTipoAfiliacionOriginal(new CateTipoAfiliacion());
      	    	entity=super.getEntity("",entity,resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCateTipoAfiliacion("",entity,resultSet);    
				
				//entity.setCateTipoAfiliacionOriginal(super.getEntity("",entity.getCateTipoAfiliacionOriginal(),resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCateTipoAfiliacionOriginal(this.getEntityCateTipoAfiliacion("",entity.getCateTipoAfiliacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCateTipoAfiliacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CateTipoAfiliacion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CateTipoAfiliacion entity = new CateTipoAfiliacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CateTipoAfiliacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CateTipoAfiliacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,CateTipoAfiliacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.CateTipoAfiliacion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCateTipoAfiliacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CateTipoAfiliacion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CateTipoAfiliacion> entities = new  ArrayList<CateTipoAfiliacion>();
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		  
		
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
	
	public  List<CateTipoAfiliacion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CateTipoAfiliacion> entities = new  ArrayList<CateTipoAfiliacion>();
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CateTipoAfiliacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CateTipoAfiliacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,CateTipoAfiliacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CateTipoAfiliacion();
      	    	entity=super.getEntity("",entity,resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCateTipoAfiliacion("",entity,resultSet);
      	    	
				//entity.setCateTipoAfiliacionOriginal( new CateTipoAfiliacion());
      	    	//entity.setCateTipoAfiliacionOriginal(super.getEntity("",entity.getCateTipoAfiliacionOriginal(),resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCateTipoAfiliacionOriginal(this.getEntityCateTipoAfiliacion("",entity.getCateTipoAfiliacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCateTipoAfiliacions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCateTipoAfiliacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CateTipoAfiliacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CateTipoAfiliacion> entities = new  ArrayList<CateTipoAfiliacion>();
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		  
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
	
	public  List<CateTipoAfiliacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CateTipoAfiliacion> entities = new  ArrayList<CateTipoAfiliacion>();
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CateTipoAfiliacion();
				
				if(conMapGenerico) {
					entity.inicializarMapCateTipoAfiliacion();
					//entity.setMapCateTipoAfiliacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCateTipoAfiliacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCateTipoAfiliacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA);         		
					entity=CateTipoAfiliacionDataAccess.getEntityCateTipoAfiliacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCateTipoAfiliacionOriginal( new CateTipoAfiliacion());
					////entity.setCateTipoAfiliacionOriginal(super.getEntity("",entity.getCateTipoAfiliacionOriginal(),resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA));         		
					////entity.setCateTipoAfiliacionOriginal(this.getEntityCateTipoAfiliacion("",entity.getCateTipoAfiliacionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCateTipoAfiliacions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCateTipoAfiliacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CateTipoAfiliacion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		  
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
	
	public  CateTipoAfiliacion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CateTipoAfiliacion();
				
				if(conMapGenerico) {
					entity.inicializarMapCateTipoAfiliacion();
					//entity.setMapCateTipoAfiliacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCateTipoAfiliacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCateTipoAfiliacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA);         		
					entity=CateTipoAfiliacionDataAccess.getEntityCateTipoAfiliacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCateTipoAfiliacionOriginal( new CateTipoAfiliacion());
					////entity.setCateTipoAfiliacionOriginal(super.getEntity("",entity.getCateTipoAfiliacionOriginal(),resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA));         		
					////entity.setCateTipoAfiliacionOriginal(this.getEntityCateTipoAfiliacion("",entity.getCateTipoAfiliacionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCateTipoAfiliacion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCateTipoAfiliacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CateTipoAfiliacion getEntityCateTipoAfiliacion(String strPrefijo,CateTipoAfiliacion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CateTipoAfiliacion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CateTipoAfiliacion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CateTipoAfiliacionDataAccess.setFieldReflectionCateTipoAfiliacion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCateTipoAfiliacion=CateTipoAfiliacionConstantesFunciones.getTodosTiposColumnasCateTipoAfiliacion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCateTipoAfiliacion) {
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
							field = CateTipoAfiliacion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CateTipoAfiliacion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CateTipoAfiliacionDataAccess.setFieldReflectionCateTipoAfiliacion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCateTipoAfiliacion(Field field,String strPrefijo,String sColumn,CateTipoAfiliacion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CateTipoAfiliacionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CateTipoAfiliacionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CateTipoAfiliacionConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CateTipoAfiliacionConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CateTipoAfiliacionConstantesFunciones.ESDEFECTO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CateTipoAfiliacion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CateTipoAfiliacion> entities = new  ArrayList<CateTipoAfiliacion>();
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CateTipoAfiliacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CateTipoAfiliacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,CateTipoAfiliacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CateTipoAfiliacion();
					entity=super.getEntity("",entity,resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCateTipoAfiliacion("",entity,resultSet);
					
					//entity.setCateTipoAfiliacionOriginal( new CateTipoAfiliacion());
					//entity.setCateTipoAfiliacionOriginal(super.getEntity("",entity.getCateTipoAfiliacionOriginal(),resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA));         		
					//entity.setCateTipoAfiliacionOriginal(this.getEntityCateTipoAfiliacion("",entity.getCateTipoAfiliacionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCateTipoAfiliacions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCateTipoAfiliacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CateTipoAfiliacion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CateTipoAfiliacion> entities = new  ArrayList<CateTipoAfiliacion>();
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CateTipoAfiliacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CateTipoAfiliacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,CateTipoAfiliacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CateTipoAfiliacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CateTipoAfiliacion> entities = new  ArrayList<CateTipoAfiliacion>();
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		  
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
	
	public  List<CateTipoAfiliacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CateTipoAfiliacion> entities = new  ArrayList<CateTipoAfiliacion>();
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CateTipoAfiliacion();
      	    	entity=super.getEntity("",entity,resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCateTipoAfiliacion("",entity,resultSet);
      	    	
				//entity.setCateTipoAfiliacionOriginal( new CateTipoAfiliacion());
      	    	//entity.setCateTipoAfiliacionOriginal(super.getEntity("",entity.getCateTipoAfiliacionOriginal(),resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCateTipoAfiliacionOriginal(this.getEntityCateTipoAfiliacion("",entity.getCateTipoAfiliacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCateTipoAfiliacions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCateTipoAfiliacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CateTipoAfiliacion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CateTipoAfiliacion> entities = new  ArrayList<CateTipoAfiliacion>();
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		  
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
	
	public  List<CateTipoAfiliacion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CateTipoAfiliacion> entities = new  ArrayList<CateTipoAfiliacion>();
		CateTipoAfiliacion entity = new CateTipoAfiliacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CateTipoAfiliacion();
      	    	entity=super.getEntity("",entity,resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCateTipoAfiliacion("",entity,resultSet);
      	    	
				//entity.setCateTipoAfiliacionOriginal( new CateTipoAfiliacion());
      	    	//entity.setCateTipoAfiliacionOriginal(super.getEntity("",entity.getCateTipoAfiliacionOriginal(),resultSet,CateTipoAfiliacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCateTipoAfiliacionOriginal(this.getEntityCateTipoAfiliacion("",entity.getCateTipoAfiliacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCateTipoAfiliacions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CateTipoAfiliacion getEntityCateTipoAfiliacion(String strPrefijo,CateTipoAfiliacion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+CateTipoAfiliacionConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+CateTipoAfiliacionConstantesFunciones.NOMBRE));
				entity.setes_defecto(resultSet.getBoolean(strPrefijo+CateTipoAfiliacionConstantesFunciones.ESDEFECTO));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+CateTipoAfiliacionConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCateTipoAfiliacion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CateTipoAfiliacion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CateTipoAfiliacionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CateTipoAfiliacionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CateTipoAfiliacionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CateTipoAfiliacionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CateTipoAfiliacionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,CateTipoAfiliacionDataAccess.TABLENAME,CateTipoAfiliacionDataAccess.ISWITHSTOREPROCEDURES);
			
			CateTipoAfiliacionDataAccess.setCateTipoAfiliacionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<Cliente> getClientes(Connexion connexion,CateTipoAfiliacion catetipoafiliacion)throws SQLException,Exception {

		List<Cliente> clientes= new ArrayList<Cliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CateTipoAfiliacionConstantesFunciones.SCHEMA+".cate_tipo_afiliacion ON "+ClienteConstantesFunciones.SCHEMA+".cliente.id_cate_tipo_afiliacion="+CateTipoAfiliacionConstantesFunciones.SCHEMA+".cate_tipo_afiliacion.id WHERE "+CateTipoAfiliacionConstantesFunciones.SCHEMA+".cate_tipo_afiliacion.id="+String.valueOf(catetipoafiliacion.getId());
			} else {
				sQuery=" INNER JOIN cliente.CateTipoAfiliacion WHERE cliente.CateTipoAfiliacion.id="+String.valueOf(catetipoafiliacion.getId());

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

	public List<TipoAfiliacion> getTipoAfiliacions(Connexion connexion,CateTipoAfiliacion catetipoafiliacion)throws SQLException,Exception {

		List<TipoAfiliacion> tipoafiliacions= new ArrayList<TipoAfiliacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CateTipoAfiliacionConstantesFunciones.SCHEMA+".cate_tipo_afiliacion ON "+TipoAfiliacionConstantesFunciones.SCHEMA+".tipo_afiliacion.id_cate_tipo_afiliacion="+CateTipoAfiliacionConstantesFunciones.SCHEMA+".cate_tipo_afiliacion.id WHERE "+CateTipoAfiliacionConstantesFunciones.SCHEMA+".cate_tipo_afiliacion.id="+String.valueOf(catetipoafiliacion.getId());
			} else {
				sQuery=" INNER JOIN tipoafiliacion.CateTipoAfiliacion WHERE tipoafiliacion.CateTipoAfiliacion.id="+String.valueOf(catetipoafiliacion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TipoAfiliacionDataAccess tipoafiliacionDataAccess=new TipoAfiliacionDataAccess();

			tipoafiliacionDataAccess.setConnexionType(this.connexionType);
			tipoafiliacionDataAccess.setParameterDbType(this.parameterDbType);
			tipoafiliacions=tipoafiliacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoafiliacions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CateTipoAfiliacion catetipoafiliacion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!catetipoafiliacion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(catetipoafiliacion.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(catetipoafiliacion.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(catetipoafiliacion.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_defecto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_defecto.setValue(catetipoafiliacion.getes_defecto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_defecto);
					parametersTemp.add(parameterMaintenance);
					
						if(!catetipoafiliacion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(catetipoafiliacion.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(catetipoafiliacion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(catetipoafiliacion.getId());
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
	
	public void setIsNewIsChangedFalseCateTipoAfiliacion(CateTipoAfiliacion catetipoafiliacion)throws Exception  {		
		catetipoafiliacion.setIsNew(false);
		catetipoafiliacion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCateTipoAfiliacions(List<CateTipoAfiliacion> catetipoafiliacions)throws Exception  {				
		for(CateTipoAfiliacion catetipoafiliacion:catetipoafiliacions) {
			catetipoafiliacion.setIsNew(false);
			catetipoafiliacion.setIsChanged(false);
		}
	}
	
	public void generarExportarCateTipoAfiliacion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
