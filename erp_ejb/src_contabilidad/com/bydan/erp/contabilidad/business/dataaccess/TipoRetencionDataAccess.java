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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//TipoRetencionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.importaciones.util.*;




@SuppressWarnings("unused")
final public class TipoRetencionDataAccess extends  TipoRetencionDataAccessAdditional{ //TipoRetencionDataAccessAdditional,DataAccessHelper<TipoRetencion>
	//static Logger logger = Logger.getLogger(TipoRetencionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_retencion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+"(id,version_row,id_empresa,nombre,codigo,porcentaje,monto_minimo,id_cuenta_contable,id_cuenta_contable_credito,es_retencion_iva,es_debito,es_con_iva_factura,es_con_sub_total_factura,es_con_secuencial)values(?,current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_empresa=?,nombre=?,codigo=?,porcentaje=?,monto_minimo=?,id_cuenta_contable=?,id_cuenta_contable_credito=?,es_retencion_iva=?,es_debito=?,es_con_iva_factura=?,es_con_sub_total_factura=?,es_con_secuencial=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tiporetencion from "+TipoRetencionConstantesFunciones.SPERSISTENCENAME+" tiporetencion";
	public static String QUERYSELECTNATIVE="select "+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".id,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".version_row,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".id_empresa,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".nombre,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".codigo,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".porcentaje,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".monto_minimo,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".id_cuenta_contable,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".es_retencion_iva,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".es_debito,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".es_con_iva_factura,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".es_con_sub_total_factura,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".es_con_secuencial from "+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME;//+" as "+TipoRetencionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".id,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".version_row,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".nombre from "+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME;//+" as "+TipoRetencionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_empresa=?,nombre=?,codigo=?,porcentaje=?,monto_minimo=?,id_cuenta_contable=?,id_cuenta_contable_credito=?,es_retencion_iva=?,es_debito=?,es_con_iva_factura=?,es_con_sub_total_factura=?,es_con_secuencial=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPORETENCION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPORETENCION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPORETENCION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPORETENCION_SELECT(?,?)";
	
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
	
	
	protected TipoRetencionDataAccessAdditional tiporetencionDataAccessAdditional=null;
	
	public TipoRetencionDataAccessAdditional getTipoRetencionDataAccessAdditional() {
		return this.tiporetencionDataAccessAdditional;
	}
	
	public void setTipoRetencionDataAccessAdditional(TipoRetencionDataAccessAdditional tiporetencionDataAccessAdditional) {
		try {
			this.tiporetencionDataAccessAdditional=tiporetencionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoRetencionDataAccess() {
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
		TipoRetencionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoRetencionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoRetencionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoRetencionOriginal(TipoRetencion tiporetencion)throws Exception  {
		tiporetencion.setTipoRetencionOriginal((TipoRetencion)tiporetencion.clone());		
	}
	
	public void setTipoRetencionsOriginal(List<TipoRetencion> tiporetencions)throws Exception  {
		
		for(TipoRetencion tiporetencion:tiporetencions){
			tiporetencion.setTipoRetencionOriginal((TipoRetencion)tiporetencion.clone());
		}
	}
	
	public static void setTipoRetencionOriginalStatic(TipoRetencion tiporetencion)throws Exception  {
		tiporetencion.setTipoRetencionOriginal((TipoRetencion)tiporetencion.clone());		
	}
	
	public static void setTipoRetencionsOriginalStatic(List<TipoRetencion> tiporetencions)throws Exception  {
		
		for(TipoRetencion tiporetencion:tiporetencions){
			tiporetencion.setTipoRetencionOriginal((TipoRetencion)tiporetencion.clone());
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
	
	public  TipoRetencion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRetencion entity = new TipoRetencion();		
		
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
	
	public  TipoRetencion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoRetencion entity = new TipoRetencion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRetencionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoRetencion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoRetencionOriginal(new TipoRetencion());
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRetencion("",entity,resultSet); 
				
				//entity.setTipoRetencionOriginal(super.getEntity("",entity.getTipoRetencionOriginal(),resultSet,TipoRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionOriginal(this.getEntityTipoRetencion("",entity.getTipoRetencionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRetencion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoRetencion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRetencion entity = new TipoRetencion();
				
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
	
	public  TipoRetencion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoRetencion entity = new TipoRetencion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRetencionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoRetencion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoRetencionOriginal(new TipoRetencion());
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoRetencion("",entity,resultSet);    
				
				//entity.setTipoRetencionOriginal(super.getEntity("",entity.getTipoRetencionOriginal(),resultSet,TipoRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionOriginal(this.getEntityTipoRetencion("",entity.getTipoRetencionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoRetencion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoRetencion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoRetencion entity = new TipoRetencion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRetencionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoRetencion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoRetencion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoRetencion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRetencion> entities = new  ArrayList<TipoRetencion>();
		TipoRetencion entity = new TipoRetencion();		  
		
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
	
	public  List<TipoRetencion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoRetencion> entities = new  ArrayList<TipoRetencion>();
		TipoRetencion entity = new TipoRetencion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoRetencionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencion();
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRetencion("",entity,resultSet);
      	    	
				//entity.setTipoRetencionOriginal( new TipoRetencion());
      	    	//entity.setTipoRetencionOriginal(super.getEntity("",entity.getTipoRetencionOriginal(),resultSet,TipoRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionOriginal(this.getEntityTipoRetencion("",entity.getTipoRetencionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRetencions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRetencion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRetencion> entities = new  ArrayList<TipoRetencion>();
		TipoRetencion entity = new TipoRetencion();		  
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
	
	public  List<TipoRetencion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoRetencion> entities = new  ArrayList<TipoRetencion>();
		TipoRetencion entity = new TipoRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencion();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRetencion();
					//entity.setMapTipoRetencion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoRetencionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRetencion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRetencionDataAccess.ISWITHSCHEMA);         		
					entity=TipoRetencionDataAccess.getEntityTipoRetencion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRetencionOriginal( new TipoRetencion());
					////entity.setTipoRetencionOriginal(super.getEntity("",entity.getTipoRetencionOriginal(),resultSet,TipoRetencionDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRetencionOriginal(this.getEntityTipoRetencion("",entity.getTipoRetencionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRetencions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoRetencion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRetencion entity = new TipoRetencion();		  
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
	
	public  TipoRetencion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoRetencion entity = new TipoRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencion();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoRetencion();
					//entity.setMapTipoRetencion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoRetencionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoRetencion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoRetencionDataAccess.ISWITHSCHEMA);         		
					entity=TipoRetencionDataAccess.getEntityTipoRetencion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoRetencionOriginal( new TipoRetencion());
					////entity.setTipoRetencionOriginal(super.getEntity("",entity.getTipoRetencionOriginal(),resultSet,TipoRetencionDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoRetencionOriginal(this.getEntityTipoRetencion("",entity.getTipoRetencionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoRetencion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoRetencion getEntityTipoRetencion(String strPrefijo,TipoRetencion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoRetencion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoRetencion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoRetencionDataAccess.setFieldReflectionTipoRetencion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoRetencion=TipoRetencionConstantesFunciones.getTodosTiposColumnasTipoRetencion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoRetencion) {
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
							field = TipoRetencion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoRetencion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoRetencionDataAccess.setFieldReflectionTipoRetencion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoRetencion(Field field,String strPrefijo,String sColumn,TipoRetencion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoRetencionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRetencionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRetencionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRetencionConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRetencionConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoRetencionConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoRetencionConstantesFunciones.MONTOMINIMO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoRetencionConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRetencionConstantesFunciones.IDCUENTACONTABLECREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoRetencionConstantesFunciones.ESRETENCIONIVA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoRetencionConstantesFunciones.ESDEBITO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoRetencionConstantesFunciones.ESCONIVAFACTURA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoRetencionConstantesFunciones.ESCONSUBTOTALFACTURA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoRetencionConstantesFunciones.ESCONSECUENCIAL:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRetencion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoRetencion> entities = new  ArrayList<TipoRetencion>();
		TipoRetencion entity = new TipoRetencion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRetencionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoRetencion();
					entity=super.getEntity("",entity,resultSet,TipoRetencionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoRetencion("",entity,resultSet);
					
					//entity.setTipoRetencionOriginal( new TipoRetencion());
					//entity.setTipoRetencionOriginal(super.getEntity("",entity.getTipoRetencionOriginal(),resultSet,TipoRetencionDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoRetencionOriginal(this.getEntityTipoRetencion("",entity.getTipoRetencionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoRetencions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoRetencion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoRetencion> entities = new  ArrayList<TipoRetencion>();
		TipoRetencion entity = new TipoRetencion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoRetencionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoRetencion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRetencion> entities = new  ArrayList<TipoRetencion>();
		TipoRetencion entity = new TipoRetencion();		  
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
	
	public  List<TipoRetencion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRetencion> entities = new  ArrayList<TipoRetencion>();
		TipoRetencion entity = new TipoRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencion();
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRetencion("",entity,resultSet);
      	    	
				//entity.setTipoRetencionOriginal( new TipoRetencion());
      	    	//entity.setTipoRetencionOriginal(super.getEntity("",entity.getTipoRetencionOriginal(),resultSet,TipoRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionOriginal(this.getEntityTipoRetencion("",entity.getTipoRetencionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoRetencions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoRetencion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoRetencion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRetencion> entities = new  ArrayList<TipoRetencion>();
		TipoRetencion entity = new TipoRetencion();		  
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
	
	public  List<TipoRetencion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoRetencion> entities = new  ArrayList<TipoRetencion>();
		TipoRetencion entity = new TipoRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoRetencion();
      	    	entity=super.getEntity("",entity,resultSet,TipoRetencionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoRetencion("",entity,resultSet);
      	    	
				//entity.setTipoRetencionOriginal( new TipoRetencion());
      	    	//entity.setTipoRetencionOriginal(super.getEntity("",entity.getTipoRetencionOriginal(),resultSet,TipoRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoRetencionOriginal(this.getEntityTipoRetencion("",entity.getTipoRetencionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoRetencions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoRetencion getEntityTipoRetencion(String strPrefijo,TipoRetencion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoRetencionConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+TipoRetencionConstantesFunciones.NOMBRE));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoRetencionConstantesFunciones.CODIGO));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+TipoRetencionConstantesFunciones.PORCENTAJE));
				entity.setmonto_minimo(resultSet.getDouble(strPrefijo+TipoRetencionConstantesFunciones.MONTOMINIMO));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+TipoRetencionConstantesFunciones.IDCUENTACONTABLE));if(resultSet.wasNull()) {entity.setid_cuenta_contable(null); }
				entity.setid_cuenta_contable_credito(resultSet.getLong(strPrefijo+TipoRetencionConstantesFunciones.IDCUENTACONTABLECREDITO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito(null); }
				entity.setes_retencion_iva(resultSet.getBoolean(strPrefijo+TipoRetencionConstantesFunciones.ESRETENCIONIVA));
				entity.setes_debito(resultSet.getBoolean(strPrefijo+TipoRetencionConstantesFunciones.ESDEBITO));
				entity.setes_con_iva_factura(resultSet.getBoolean(strPrefijo+TipoRetencionConstantesFunciones.ESCONIVAFACTURA));
				entity.setes_con_sub_total_factura(resultSet.getBoolean(strPrefijo+TipoRetencionConstantesFunciones.ESCONSUBTOTALFACTURA));
				entity.setes_con_secuencial(resultSet.getBoolean(strPrefijo+TipoRetencionConstantesFunciones.ESCONSECUENCIAL));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoRetencionConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoRetencion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoRetencion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoRetencionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoRetencionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoRetencionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoRetencionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoRetencionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoRetencionDataAccess.TABLENAME,TipoRetencionDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoRetencionDataAccess.setTipoRetencionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoRetencion reltiporetencion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltiporetencion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public CuentaContable getCuentaContable(Connexion connexion,TipoRetencion reltiporetencion)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltiporetencion.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCredito(Connexion connexion,TipoRetencion reltiporetencion)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltiporetencion.getid_cuenta_contable_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<Definicion> getDefinicions(Connexion connexion,TipoRetencion tiporetencion)throws SQLException,Exception {

		List<Definicion> definicions= new ArrayList<Definicion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion ON "+DefinicionConstantesFunciones.SCHEMA+".definicion.id_tipo_retencion="+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id WHERE "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id="+String.valueOf(tiporetencion.getId());
			} else {
				sQuery=" INNER JOIN definicion.TipoRetencion WHERE definicion.TipoRetencion.id="+String.valueOf(tiporetencion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DefinicionDataAccess definicionDataAccess=new DefinicionDataAccess();

			definicionDataAccess.setConnexionType(this.connexionType);
			definicionDataAccess.setParameterDbType(this.parameterDbType);
			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return definicions;

	}

	public List<FacturaProveedorServicio> getFacturaProveedorServicioIva1s(Connexion connexion,TipoRetencion tiporetencion)throws SQLException,Exception {

		List<FacturaProveedorServicio> facturaproveedorservicioiva1s= new ArrayList<FacturaProveedorServicio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion ON "+FacturaProveedorServicioConstantesFunciones.SCHEMA+".factura_proveedor_servicio.id_tipo_retencion="+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id WHERE "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id="+String.valueOf(tiporetencion.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedorservicio.TipoRetencionIva1 WHERE facturaproveedorservicio.TipoRetencionIva1.id="+String.valueOf(tiporetencion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorServicioDataAccess facturaproveedorservicioDataAccess=new FacturaProveedorServicioDataAccess();

			facturaproveedorservicioDataAccess.setConnexionType(this.connexionType);
			facturaproveedorservicioDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedorservicioiva1s=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedorservicioiva1s;

	}

	public List<DetaFormaPago> getDetaFormaPagos(Connexion connexion,TipoRetencion tiporetencion)throws SQLException,Exception {

		List<DetaFormaPago> detaformapagos= new ArrayList<DetaFormaPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion ON "+DetaFormaPagoConstantesFunciones.SCHEMA+".deta_forma_pago.id_tipo_retencion="+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id WHERE "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id="+String.valueOf(tiporetencion.getId());
			} else {
				sQuery=" INNER JOIN detaformapago.TipoRetencion WHERE detaformapago.TipoRetencion.id="+String.valueOf(tiporetencion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaFormaPagoDataAccess detaformapagoDataAccess=new DetaFormaPagoDataAccess();

			detaformapagoDataAccess.setConnexionType(this.connexionType);
			detaformapagoDataAccess.setParameterDbType(this.parameterDbType);
			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detaformapagos;

	}

	public List<RetencionVenta> getRetencionVentas(Connexion connexion,TipoRetencion tiporetencion)throws SQLException,Exception {

		List<RetencionVenta> retencionventas= new ArrayList<RetencionVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion ON "+RetencionVentaConstantesFunciones.SCHEMA+".retencion_venta.id_tipo_retencion="+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id WHERE "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id="+String.valueOf(tiporetencion.getId());
			} else {
				sQuery=" INNER JOIN retencionventa.TipoRetencion WHERE retencionventa.TipoRetencion.id="+String.valueOf(tiporetencion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RetencionVentaDataAccess retencionventaDataAccess=new RetencionVentaDataAccess();

			retencionventaDataAccess.setConnexionType(this.connexionType);
			retencionventaDataAccess.setParameterDbType(this.parameterDbType);
			retencionventas=retencionventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return retencionventas;

	}

	public List<TablaRetencion> getTablaRetencions(Connexion connexion,TipoRetencion tiporetencion)throws SQLException,Exception {

		List<TablaRetencion> tablaretencions= new ArrayList<TablaRetencion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion ON "+TablaRetencionConstantesFunciones.SCHEMA+".tabla_retencion.id_tipo_retencion="+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id WHERE "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id="+String.valueOf(tiporetencion.getId());
			} else {
				sQuery=" INNER JOIN tablaretencion.TipoRetencion WHERE tablaretencion.TipoRetencion.id="+String.valueOf(tiporetencion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TablaRetencionDataAccess tablaretencionDataAccess=new TablaRetencionDataAccess();

			tablaretencionDataAccess.setConnexionType(this.connexionType);
			tablaretencionDataAccess.setParameterDbType(this.parameterDbType);
			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tablaretencions;

	}

	public List<Retencion> getRetencions(Connexion connexion,TipoRetencion tiporetencion)throws SQLException,Exception {

		List<Retencion> retencions= new ArrayList<Retencion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion ON "+RetencionConstantesFunciones.SCHEMA+".retencion.id_tipo_retencion="+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id WHERE "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id="+String.valueOf(tiporetencion.getId());
			} else {
				sQuery=" INNER JOIN retencion.TipoRetencion WHERE retencion.TipoRetencion.id="+String.valueOf(tiporetencion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RetencionDataAccess retencionDataAccess=new RetencionDataAccess();

			retencionDataAccess.setConnexionType(this.connexionType);
			retencionDataAccess.setParameterDbType(this.parameterDbType);
			retencions=retencionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return retencions;

	}

	public List<ClienteRetencion> getClienteRetencions(Connexion connexion,TipoRetencion tiporetencion)throws SQLException,Exception {

		List<ClienteRetencion> clienteretencions= new ArrayList<ClienteRetencion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion ON "+ClienteRetencionConstantesFunciones.SCHEMA+".cliente_retencion.id_tipo_retencion="+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id WHERE "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id="+String.valueOf(tiporetencion.getId());
			} else {
				sQuery=" INNER JOIN clienteretencion.TipoRetencion WHERE clienteretencion.TipoRetencion.id="+String.valueOf(tiporetencion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteRetencionDataAccess clienteretencionDataAccess=new ClienteRetencionDataAccess();

			clienteretencionDataAccess.setConnexionType(this.connexionType);
			clienteretencionDataAccess.setParameterDbType(this.parameterDbType);
			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clienteretencions;

	}

	public List<TarjetaCredito> getTarjetaCreditos(Connexion connexion,TipoRetencion tiporetencion)throws SQLException,Exception {

		List<TarjetaCredito> tarjetacreditos= new ArrayList<TarjetaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion ON "+TarjetaCreditoConstantesFunciones.SCHEMA+".tarjeta_credito.id_tipo_retencion="+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id WHERE "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id="+String.valueOf(tiporetencion.getId());
			} else {
				sQuery=" INNER JOIN tarjetacredito.TipoRetencion WHERE tarjetacredito.TipoRetencion.id="+String.valueOf(tiporetencion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TarjetaCreditoDataAccess tarjetacreditoDataAccess=new TarjetaCreditoDataAccess();

			tarjetacreditoDataAccess.setConnexionType(this.connexionType);
			tarjetacreditoDataAccess.setParameterDbType(this.parameterDbType);
			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tarjetacreditos;

	}

	public List<FormularioRenta> getFormularioRentas(Connexion connexion,TipoRetencion tiporetencion)throws SQLException,Exception {

		List<FormularioRenta> formulariorentas= new ArrayList<FormularioRenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion ON "+FormularioRentaConstantesFunciones.SCHEMA+".formulario_renta.id_tipo_retencion="+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id WHERE "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id="+String.valueOf(tiporetencion.getId());
			} else {
				sQuery=" INNER JOIN formulariorenta.TipoRetencion WHERE formulariorenta.TipoRetencion.id="+String.valueOf(tiporetencion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormularioRentaDataAccess formulariorentaDataAccess=new FormularioRentaDataAccess();

			formulariorentaDataAccess.setConnexionType(this.connexionType);
			formulariorentaDataAccess.setParameterDbType(this.parameterDbType);
			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formulariorentas;

	}

	public List<Transaccion> getTransaccions(Connexion connexion,TipoRetencion tiporetencion)throws SQLException,Exception {

		List<Transaccion> transaccions= new ArrayList<Transaccion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion ON "+TransaccionConstantesFunciones.SCHEMA+".transaccion.id_tipo_retencion="+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id WHERE "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id="+String.valueOf(tiporetencion.getId());
			} else {
				sQuery=" INNER JOIN transaccion.TipoRetencion WHERE transaccion.TipoRetencion.id="+String.valueOf(tiporetencion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);
			transaccions=transaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccions;

	}

	public List<PlantillaFactura> getPlantillaFacturaFuenteServicios(Connexion connexion,TipoRetencion tiporetencion)throws SQLException,Exception {

		List<PlantillaFactura> plantillafacturafuenteservicios= new ArrayList<PlantillaFactura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion ON "+PlantillaFacturaConstantesFunciones.SCHEMA+".plantilla_factura.id_tipo_retencion="+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id WHERE "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id="+String.valueOf(tiporetencion.getId());
			} else {
				sQuery=" INNER JOIN plantillafactura.TipoRetencionFuenteServicio WHERE plantillafactura.TipoRetencionFuenteServicio.id="+String.valueOf(tiporetencion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PlantillaFacturaDataAccess plantillafacturaDataAccess=new PlantillaFacturaDataAccess();

			plantillafacturaDataAccess.setConnexionType(this.connexionType);
			plantillafacturaDataAccess.setParameterDbType(this.parameterDbType);
			plantillafacturafuenteservicios=plantillafacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return plantillafacturafuenteservicios;

	}

	public List<FacturaProveedor> getFacturaProveedorIva2s(Connexion connexion,TipoRetencion tiporetencion)throws SQLException,Exception {

		List<FacturaProveedor> facturaproveedoriva2s= new ArrayList<FacturaProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion ON "+FacturaProveedorConstantesFunciones.SCHEMA+".factura_proveedor.id_tipo_retencion="+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id WHERE "+TipoRetencionConstantesFunciones.SCHEMA+".tipo_retencion.id="+String.valueOf(tiporetencion.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedor.TipoRetencionIva2 WHERE facturaproveedor.TipoRetencionIva2.id="+String.valueOf(tiporetencion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorDataAccess facturaproveedorDataAccess=new FacturaProveedorDataAccess();

			facturaproveedorDataAccess.setConnexionType(this.connexionType);
			facturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedoriva2s=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedoriva2s;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoRetencion tiporetencion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tiporetencion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tiporetencion.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tiporetencion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tiporetencion.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tiporetencion.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(tiporetencion.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_minimo=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_minimo.setValue(tiporetencion.getmonto_minimo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_minimo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(tiporetencion.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito.setValue(tiporetencion.getid_cuenta_contable_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_retencion_iva=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_retencion_iva.setValue(tiporetencion.getes_retencion_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_retencion_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_debito=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_debito.setValue(tiporetencion.getes_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_con_iva_factura=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_con_iva_factura.setValue(tiporetencion.getes_con_iva_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_con_iva_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_con_sub_total_factura=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_con_sub_total_factura.setValue(tiporetencion.getes_con_sub_total_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_con_sub_total_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_con_secuencial=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_con_secuencial.setValue(tiporetencion.getes_con_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_con_secuencial);
					parametersTemp.add(parameterMaintenance);
					
						if(!tiporetencion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tiporetencion.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tiporetencion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tiporetencion.getId());
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
	
	public void setIsNewIsChangedFalseTipoRetencion(TipoRetencion tiporetencion)throws Exception  {		
		tiporetencion.setIsNew(false);
		tiporetencion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoRetencions(List<TipoRetencion> tiporetencions)throws Exception  {				
		for(TipoRetencion tiporetencion:tiporetencions) {
			tiporetencion.setIsNew(false);
			tiporetencion.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoRetencion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
