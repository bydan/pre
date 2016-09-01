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
import com.bydan.erp.contabilidad.util.*;//ImportarExportarConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class ImportarExportarDataAccess extends  ImportarExportarDataAccessAdditional{ //ImportarExportarDataAccessAdditional,DataAccessHelper<ImportarExportar>
	//static Logger logger = Logger.getLogger(ImportarExportarDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="importar_exportar";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+"(version_row,id_modulo,id_asiento_contable,ruc,id_periodo_import_export,id_transaccion_conta,fecha,id_tipo_importacion,id_tipo_comprobante,numero_comprobante,documento_transporte,numero_referencia_comprobante,id_tipo_tributario,codigo_fiscal,id_cliente,es_juridico,base0,monto_total_cif,monto_iva,id_tipo_iva,monto_ice,id_tipo_ice,base_general,id_tipo_banco,id_tipo_comprobante_banco,con_convenio,con_devolucion,fecha_emision,numero_serie_comprobante,numero_autorizacion_comprobante,numero_secuencial_fuente,valor_fob)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_modulo=?,id_asiento_contable=?,ruc=?,id_periodo_import_export=?,id_transaccion_conta=?,fecha=?,id_tipo_importacion=?,id_tipo_comprobante=?,numero_comprobante=?,documento_transporte=?,numero_referencia_comprobante=?,id_tipo_tributario=?,codigo_fiscal=?,id_cliente=?,es_juridico=?,base0=?,monto_total_cif=?,monto_iva=?,id_tipo_iva=?,monto_ice=?,id_tipo_ice=?,base_general=?,id_tipo_banco=?,id_tipo_comprobante_banco=?,con_convenio=?,con_devolucion=?,fecha_emision=?,numero_serie_comprobante=?,numero_autorizacion_comprobante=?,numero_secuencial_fuente=?,valor_fob=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select importarexportar from "+ImportarExportarConstantesFunciones.SPERSISTENCENAME+" importarexportar";
	public static String QUERYSELECTNATIVE="select "+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".version_row,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_modulo,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_asiento_contable,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".ruc,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_periodo_import_export,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_transaccion_conta,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".fecha,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_importacion,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_comprobante,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".numero_comprobante,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".documento_transporte,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".numero_referencia_comprobante,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_tributario,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".codigo_fiscal,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_cliente,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".es_juridico,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".base0,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".monto_total_cif,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".monto_iva,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_iva,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".monto_ice,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_ice,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".base_general,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_banco,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_comprobante_banco,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".con_convenio,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".con_devolucion,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".fecha_emision,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".numero_serie_comprobante,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".numero_autorizacion_comprobante,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".numero_secuencial_fuente,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".valor_fob from "+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME;//+" as "+ImportarExportarConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".version_row,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".ruc from "+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME;//+" as "+ImportarExportarConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_modulo=?,id_asiento_contable=?,ruc=?,id_periodo_import_export=?,id_transaccion_conta=?,fecha=?,id_tipo_importacion=?,id_tipo_comprobante=?,numero_comprobante=?,documento_transporte=?,numero_referencia_comprobante=?,id_tipo_tributario=?,codigo_fiscal=?,id_cliente=?,es_juridico=?,base0=?,monto_total_cif=?,monto_iva=?,id_tipo_iva=?,monto_ice=?,id_tipo_ice=?,base_general=?,id_tipo_banco=?,id_tipo_comprobante_banco=?,con_convenio=?,con_devolucion=?,fecha_emision=?,numero_serie_comprobante=?,numero_autorizacion_comprobante=?,numero_secuencial_fuente=?,valor_fob=?";
	
	public static String STOREPROCEDUREINSERT="call SP_IMPORTAREXPORTAR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_IMPORTAREXPORTAR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_IMPORTAREXPORTAR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_IMPORTAREXPORTAR_SELECT(?,?)";
	
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
	
	
	protected ImportarExportarDataAccessAdditional importarexportarDataAccessAdditional=null;
	
	public ImportarExportarDataAccessAdditional getImportarExportarDataAccessAdditional() {
		return this.importarexportarDataAccessAdditional;
	}
	
	public void setImportarExportarDataAccessAdditional(ImportarExportarDataAccessAdditional importarexportarDataAccessAdditional) {
		try {
			this.importarexportarDataAccessAdditional=importarexportarDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ImportarExportarDataAccess() {
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
		ImportarExportarDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ImportarExportarDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ImportarExportarDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setImportarExportarOriginal(ImportarExportar importarexportar)throws Exception  {
		importarexportar.setImportarExportarOriginal((ImportarExportar)importarexportar.clone());		
	}
	
	public void setImportarExportarsOriginal(List<ImportarExportar> importarexportars)throws Exception  {
		
		for(ImportarExportar importarexportar:importarexportars){
			importarexportar.setImportarExportarOriginal((ImportarExportar)importarexportar.clone());
		}
	}
	
	public static void setImportarExportarOriginalStatic(ImportarExportar importarexportar)throws Exception  {
		importarexportar.setImportarExportarOriginal((ImportarExportar)importarexportar.clone());		
	}
	
	public static void setImportarExportarsOriginalStatic(List<ImportarExportar> importarexportars)throws Exception  {
		
		for(ImportarExportar importarexportar:importarexportars){
			importarexportar.setImportarExportarOriginal((ImportarExportar)importarexportar.clone());
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
	
	public  ImportarExportar getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ImportarExportar entity = new ImportarExportar();		
		
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
	
	public  ImportarExportar getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ImportarExportar entity = new ImportarExportar();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ImportarExportarDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ImportarExportarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.ImportarExportar.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setImportarExportarOriginal(new ImportarExportar());
      	    	entity=super.getEntity("",entity,resultSet,ImportarExportarDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityImportarExportar("",entity,resultSet); 
				
				//entity.setImportarExportarOriginal(super.getEntity("",entity.getImportarExportarOriginal(),resultSet,ImportarExportarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImportarExportarOriginal(this.getEntityImportarExportar("",entity.getImportarExportarOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseImportarExportar(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ImportarExportar getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ImportarExportar entity = new ImportarExportar();
				
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
	
	public  ImportarExportar getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ImportarExportar entity = new ImportarExportar();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ImportarExportarDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ImportarExportarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImportarExportarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ImportarExportar.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setImportarExportarOriginal(new ImportarExportar());
      	    	entity=super.getEntity("",entity,resultSet,ImportarExportarDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityImportarExportar("",entity,resultSet);    
				
				//entity.setImportarExportarOriginal(super.getEntity("",entity.getImportarExportarOriginal(),resultSet,ImportarExportarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImportarExportarOriginal(this.getEntityImportarExportar("",entity.getImportarExportarOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseImportarExportar(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ImportarExportar
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ImportarExportar entity = new ImportarExportar();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ImportarExportarDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ImportarExportarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImportarExportarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ImportarExportar.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseImportarExportar(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ImportarExportar> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ImportarExportar> entities = new  ArrayList<ImportarExportar>();
		ImportarExportar entity = new ImportarExportar();		  
		
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
	
	public  List<ImportarExportar> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ImportarExportar> entities = new  ArrayList<ImportarExportar>();
		ImportarExportar entity = new ImportarExportar();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ImportarExportarDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ImportarExportarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImportarExportarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImportarExportar();
      	    	entity=super.getEntity("",entity,resultSet,ImportarExportarDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityImportarExportar("",entity,resultSet);
      	    	
				//entity.setImportarExportarOriginal( new ImportarExportar());
      	    	//entity.setImportarExportarOriginal(super.getEntity("",entity.getImportarExportarOriginal(),resultSet,ImportarExportarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImportarExportarOriginal(this.getEntityImportarExportar("",entity.getImportarExportarOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseImportarExportars(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImportarExportar(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ImportarExportar> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ImportarExportar> entities = new  ArrayList<ImportarExportar>();
		ImportarExportar entity = new ImportarExportar();		  
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
	
	public  List<ImportarExportar> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ImportarExportar> entities = new  ArrayList<ImportarExportar>();
		ImportarExportar entity = new ImportarExportar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImportarExportar();
				
				if(conMapGenerico) {
					entity.inicializarMapImportarExportar();
					//entity.setMapImportarExportar(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapImportarExportarValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapImportarExportar().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ImportarExportarDataAccess.ISWITHSCHEMA);         		
					entity=ImportarExportarDataAccess.getEntityImportarExportar("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setImportarExportarOriginal( new ImportarExportar());
					////entity.setImportarExportarOriginal(super.getEntity("",entity.getImportarExportarOriginal(),resultSet,ImportarExportarDataAccess.ISWITHSCHEMA));         		
					////entity.setImportarExportarOriginal(this.getEntityImportarExportar("",entity.getImportarExportarOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseImportarExportars(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImportarExportar(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ImportarExportar getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ImportarExportar entity = new ImportarExportar();		  
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
	
	public  ImportarExportar getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ImportarExportar entity = new ImportarExportar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImportarExportar();
				
				if(conMapGenerico) {
					entity.inicializarMapImportarExportar();
					//entity.setMapImportarExportar(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapImportarExportarValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapImportarExportar().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ImportarExportarDataAccess.ISWITHSCHEMA);         		
					entity=ImportarExportarDataAccess.getEntityImportarExportar("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setImportarExportarOriginal( new ImportarExportar());
					////entity.setImportarExportarOriginal(super.getEntity("",entity.getImportarExportarOriginal(),resultSet,ImportarExportarDataAccess.ISWITHSCHEMA));         		
					////entity.setImportarExportarOriginal(this.getEntityImportarExportar("",entity.getImportarExportarOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseImportarExportar(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImportarExportar(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ImportarExportar getEntityImportarExportar(String strPrefijo,ImportarExportar entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ImportarExportar.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ImportarExportar.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ImportarExportarDataAccess.setFieldReflectionImportarExportar(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasImportarExportar=ImportarExportarConstantesFunciones.getTodosTiposColumnasImportarExportar();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasImportarExportar) {
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
							field = ImportarExportar.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ImportarExportar.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ImportarExportarDataAccess.setFieldReflectionImportarExportar(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionImportarExportar(Field field,String strPrefijo,String sColumn,ImportarExportar entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ImportarExportarConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.RUCINFORMANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.IDPERIODOIMPORTEXPORT:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.IDTRANSACCIONCONTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ImportarExportarConstantesFunciones.IDTIPOIMPORTACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.DOCUMENTOTRANSPORTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.NUMEROREFERENCIACOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.IDTIPOTRIBUTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.CODIGOFISCAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.ESJURIDICO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.BASE0:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.MONTOTOTALCIF:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.MONTOIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.IDTIPOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.MONTOICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.IDTIPOICE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.BASEGENERAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.IDTIPOBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTEBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.CONCONVENIO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.CONDEVOLUCION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ImportarExportarConstantesFunciones.NUMEROSERIECOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.NUMEROAUTORIZACIONCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.NUMEROSECUENCIALFUENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ImportarExportarConstantesFunciones.VALORFOB:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ImportarExportar>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ImportarExportar> entities = new  ArrayList<ImportarExportar>();
		ImportarExportar entity = new ImportarExportar();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ImportarExportarDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ImportarExportarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImportarExportarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ImportarExportar();
					entity=super.getEntity("",entity,resultSet,ImportarExportarDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityImportarExportar("",entity,resultSet);
					
					//entity.setImportarExportarOriginal( new ImportarExportar());
					//entity.setImportarExportarOriginal(super.getEntity("",entity.getImportarExportarOriginal(),resultSet,ImportarExportarDataAccess.ISWITHSCHEMA));         		
					//entity.setImportarExportarOriginal(this.getEntityImportarExportar("",entity.getImportarExportarOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseImportarExportars(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImportarExportar(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ImportarExportar>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ImportarExportar> entities = new  ArrayList<ImportarExportar>();
		ImportarExportar entity = new ImportarExportar();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ImportarExportarDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ImportarExportarDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImportarExportarDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ImportarExportar> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ImportarExportar> entities = new  ArrayList<ImportarExportar>();
		ImportarExportar entity = new ImportarExportar();		  
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
	
	public  List<ImportarExportar> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ImportarExportar> entities = new  ArrayList<ImportarExportar>();
		ImportarExportar entity = new ImportarExportar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImportarExportar();
      	    	entity=super.getEntity("",entity,resultSet,ImportarExportarDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityImportarExportar("",entity,resultSet);
      	    	
				//entity.setImportarExportarOriginal( new ImportarExportar());
      	    	//entity.setImportarExportarOriginal(super.getEntity("",entity.getImportarExportarOriginal(),resultSet,ImportarExportarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImportarExportarOriginal(this.getEntityImportarExportar("",entity.getImportarExportarOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseImportarExportars(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImportarExportar(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ImportarExportar> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ImportarExportar> entities = new  ArrayList<ImportarExportar>();
		ImportarExportar entity = new ImportarExportar();		  
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
	
	public  List<ImportarExportar> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ImportarExportar> entities = new  ArrayList<ImportarExportar>();
		ImportarExportar entity = new ImportarExportar();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImportarExportar();
      	    	entity=super.getEntity("",entity,resultSet,ImportarExportarDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityImportarExportar("",entity,resultSet);
      	    	
				//entity.setImportarExportarOriginal( new ImportarExportar());
      	    	//entity.setImportarExportarOriginal(super.getEntity("",entity.getImportarExportarOriginal(),resultSet,ImportarExportarDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImportarExportarOriginal(this.getEntityImportarExportar("",entity.getImportarExportarOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseImportarExportars(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ImportarExportar getEntityImportarExportar(String strPrefijo,ImportarExportar entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_modulo(resultSet.getLong(strPrefijo+ImportarExportarConstantesFunciones.IDMODULO));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+ImportarExportarConstantesFunciones.IDASIENTOCONTABLE));
				entity.setruc(resultSet.getString(strPrefijo+ImportarExportarConstantesFunciones.RUCINFORMANTE));
				entity.setid_periodo_import_export(resultSet.getLong(strPrefijo+ImportarExportarConstantesFunciones.IDPERIODOIMPORTEXPORT));
				entity.setid_transaccion_conta(resultSet.getLong(strPrefijo+ImportarExportarConstantesFunciones.IDTRANSACCIONCONTA));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+ImportarExportarConstantesFunciones.FECHA).getTime()));
				entity.setid_tipo_importacion(resultSet.getLong(strPrefijo+ImportarExportarConstantesFunciones.IDTIPOIMPORTACION));
				entity.setid_tipo_comprobante(resultSet.getLong(strPrefijo+ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTE));
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+ImportarExportarConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setdocumento_transporte(resultSet.getString(strPrefijo+ImportarExportarConstantesFunciones.DOCUMENTOTRANSPORTE));
				entity.setnumero_referencia_comprobante(resultSet.getString(strPrefijo+ImportarExportarConstantesFunciones.NUMEROREFERENCIACOMPROBANTE));
				entity.setid_tipo_tributario(resultSet.getLong(strPrefijo+ImportarExportarConstantesFunciones.IDTIPOTRIBUTARIO));
				entity.setcodigo_fiscal(resultSet.getString(strPrefijo+ImportarExportarConstantesFunciones.CODIGOFISCAL));
				entity.setid_cliente(resultSet.getLong(strPrefijo+ImportarExportarConstantesFunciones.IDCLIENTE));
				entity.setes_juridico(resultSet.getBoolean(strPrefijo+ImportarExportarConstantesFunciones.ESJURIDICO));
				entity.setbase0(resultSet.getDouble(strPrefijo+ImportarExportarConstantesFunciones.BASE0));
				entity.setmonto_total_cif(resultSet.getDouble(strPrefijo+ImportarExportarConstantesFunciones.MONTOTOTALCIF));
				entity.setmonto_iva(resultSet.getDouble(strPrefijo+ImportarExportarConstantesFunciones.MONTOIVA));
				entity.setid_tipo_iva(resultSet.getLong(strPrefijo+ImportarExportarConstantesFunciones.IDTIPOIVA));
				entity.setmonto_ice(resultSet.getDouble(strPrefijo+ImportarExportarConstantesFunciones.MONTOICE));
				entity.setid_tipo_ice(resultSet.getLong(strPrefijo+ImportarExportarConstantesFunciones.IDTIPOICE));
				entity.setbase_general(resultSet.getDouble(strPrefijo+ImportarExportarConstantesFunciones.BASEGENERAL));
				entity.setid_tipo_banco(resultSet.getLong(strPrefijo+ImportarExportarConstantesFunciones.IDTIPOBANCO));
				entity.setid_tipo_comprobante_banco(resultSet.getLong(strPrefijo+ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTEBANCO));
				entity.setcon_convenio(resultSet.getBoolean(strPrefijo+ImportarExportarConstantesFunciones.CONCONVENIO));
				entity.setcon_devolucion(resultSet.getBoolean(strPrefijo+ImportarExportarConstantesFunciones.CONDEVOLUCION));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+ImportarExportarConstantesFunciones.FECHAEMISION).getTime()));
				entity.setnumero_serie_comprobante(resultSet.getString(strPrefijo+ImportarExportarConstantesFunciones.NUMEROSERIECOMPROBANTE));
				entity.setnumero_autorizacion_comprobante(resultSet.getString(strPrefijo+ImportarExportarConstantesFunciones.NUMEROAUTORIZACIONCOMPROBANTE));
				entity.setnumero_secuencial_fuente(resultSet.getString(strPrefijo+ImportarExportarConstantesFunciones.NUMEROSECUENCIALFUENTE));
				entity.setvalor_fob(resultSet.getDouble(strPrefijo+ImportarExportarConstantesFunciones.VALORFOB));
			} else {
				entity.setruc(resultSet.getString(strPrefijo+ImportarExportarConstantesFunciones.RUCINFORMANTE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowImportarExportar(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ImportarExportar entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ImportarExportarDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ImportarExportarDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ImportarExportarDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ImportarExportarDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ImportarExportarConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ImportarExportarDataAccess.TABLENAME,ImportarExportarDataAccess.ISWITHSTOREPROCEDURES);
			
			ImportarExportarDataAccess.setImportarExportarOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Modulo getModulo(Connexion connexion,ImportarExportar relimportarexportar)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relimportarexportar.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public AsientoContable getAsientoContable(Connexion connexion,ImportarExportar relimportarexportar)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relimportarexportar.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public PeriodoImportExport getPeriodoImportExport(Connexion connexion,ImportarExportar relimportarexportar)throws SQLException,Exception {

		PeriodoImportExport periodoimportexport= new PeriodoImportExport();

		try {
			PeriodoImportExportDataAccess periodoimportexportDataAccess=new PeriodoImportExportDataAccess();

			periodoimportexportDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoimportexportDataAccess.setConnexionType(this.connexionType);
			periodoimportexportDataAccess.setParameterDbType(this.parameterDbType);

			periodoimportexport=periodoimportexportDataAccess.getEntity(connexion,relimportarexportar.getid_periodo_import_export());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodoimportexport;

	}

	public TransaccionConta getTransaccionConta(Connexion connexion,ImportarExportar relimportarexportar)throws SQLException,Exception {

		TransaccionConta transaccionconta= new TransaccionConta();

		try {
			TransaccionContaDataAccess transaccioncontaDataAccess=new TransaccionContaDataAccess();

			transaccioncontaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccioncontaDataAccess.setConnexionType(this.connexionType);
			transaccioncontaDataAccess.setParameterDbType(this.parameterDbType);

			transaccionconta=transaccioncontaDataAccess.getEntity(connexion,relimportarexportar.getid_transaccion_conta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccionconta;

	}

	public TipoImportacion getTipoImportacion(Connexion connexion,ImportarExportar relimportarexportar)throws SQLException,Exception {

		TipoImportacion tipoimportacion= new TipoImportacion();

		try {
			TipoImportacionDataAccess tipoimportacionDataAccess=new TipoImportacionDataAccess();

			tipoimportacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoimportacionDataAccess.setConnexionType(this.connexionType);
			tipoimportacionDataAccess.setParameterDbType(this.parameterDbType);

			tipoimportacion=tipoimportacionDataAccess.getEntity(connexion,relimportarexportar.getid_tipo_importacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoimportacion;

	}

	public TipoComprobante getTipoComprobante(Connexion connexion,ImportarExportar relimportarexportar)throws SQLException,Exception {

		TipoComprobante tipocomprobante= new TipoComprobante();

		try {
			TipoComprobanteDataAccess tipocomprobanteDataAccess=new TipoComprobanteDataAccess();

			tipocomprobanteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocomprobanteDataAccess.setConnexionType(this.connexionType);
			tipocomprobanteDataAccess.setParameterDbType(this.parameterDbType);

			tipocomprobante=tipocomprobanteDataAccess.getEntity(connexion,relimportarexportar.getid_tipo_comprobante());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocomprobante;

	}

	public TipoTributario getTipoTributario(Connexion connexion,ImportarExportar relimportarexportar)throws SQLException,Exception {

		TipoTributario tipotributario= new TipoTributario();

		try {
			TipoTributarioDataAccess tipotributarioDataAccess=new TipoTributarioDataAccess();

			tipotributarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotributarioDataAccess.setConnexionType(this.connexionType);
			tipotributarioDataAccess.setParameterDbType(this.parameterDbType);

			tipotributario=tipotributarioDataAccess.getEntity(connexion,relimportarexportar.getid_tipo_tributario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotributario;

	}

	public Cliente getCliente(Connexion connexion,ImportarExportar relimportarexportar)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relimportarexportar.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoIva getTipoIva(Connexion connexion,ImportarExportar relimportarexportar)throws SQLException,Exception {

		TipoIva tipoiva= new TipoIva();

		try {
			TipoIvaDataAccess tipoivaDataAccess=new TipoIvaDataAccess();

			tipoivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoivaDataAccess.setConnexionType(this.connexionType);
			tipoivaDataAccess.setParameterDbType(this.parameterDbType);

			tipoiva=tipoivaDataAccess.getEntity(connexion,relimportarexportar.getid_tipo_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoiva;

	}

	public TipoIce getTipoIce(Connexion connexion,ImportarExportar relimportarexportar)throws SQLException,Exception {

		TipoIce tipoice= new TipoIce();

		try {
			TipoIceDataAccess tipoiceDataAccess=new TipoIceDataAccess();

			tipoiceDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoiceDataAccess.setConnexionType(this.connexionType);
			tipoiceDataAccess.setParameterDbType(this.parameterDbType);

			tipoice=tipoiceDataAccess.getEntity(connexion,relimportarexportar.getid_tipo_ice());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoice;

	}

	public TipoBanco getTipoBanco(Connexion connexion,ImportarExportar relimportarexportar)throws SQLException,Exception {

		TipoBanco tipobanco= new TipoBanco();

		try {
			TipoBancoDataAccess tipobancoDataAccess=new TipoBancoDataAccess();

			tipobancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipobancoDataAccess.setConnexionType(this.connexionType);
			tipobancoDataAccess.setParameterDbType(this.parameterDbType);

			tipobanco=tipobancoDataAccess.getEntity(connexion,relimportarexportar.getid_tipo_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipobanco;

	}

	public TipoComprobante getTipoComprobanteBanco(Connexion connexion,ImportarExportar relimportarexportar)throws SQLException,Exception {

		TipoComprobante tipocomprobante= new TipoComprobante();

		try {
			TipoComprobanteDataAccess tipocomprobanteDataAccess=new TipoComprobanteDataAccess();

			tipocomprobanteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocomprobanteDataAccess.setConnexionType(this.connexionType);
			tipocomprobanteDataAccess.setParameterDbType(this.parameterDbType);

			tipocomprobante=tipocomprobanteDataAccess.getEntity(connexion,relimportarexportar.getid_tipo_comprobante_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocomprobante;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ImportarExportar importarexportar) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!importarexportar.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(importarexportar.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(importarexportar.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(importarexportar.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo_import_export=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo_import_export.setValue(importarexportar.getid_periodo_import_export());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo_import_export);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_conta=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_conta.setValue(importarexportar.getid_transaccion_conta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_conta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(importarexportar.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_importacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_importacion.setValue(importarexportar.getid_tipo_importacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_importacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_comprobante=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_comprobante.setValue(importarexportar.getid_tipo_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(importarexportar.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedocumento_transporte=new ParameterValue<String>();
					parameterMaintenanceValuedocumento_transporte.setValue(importarexportar.getdocumento_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedocumento_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_referencia_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_referencia_comprobante.setValue(importarexportar.getnumero_referencia_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_referencia_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_tributario=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_tributario.setValue(importarexportar.getid_tipo_tributario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_tributario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_fiscal=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_fiscal.setValue(importarexportar.getcodigo_fiscal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_fiscal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(importarexportar.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_juridico=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_juridico.setValue(importarexportar.getes_juridico());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_juridico);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebase0=new ParameterValue<Double>();
					parameterMaintenanceValuebase0.setValue(importarexportar.getbase0());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebase0);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_total_cif=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_total_cif.setValue(importarexportar.getmonto_total_cif());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_total_cif);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_iva=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_iva.setValue(importarexportar.getmonto_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_iva.setValue(importarexportar.getid_tipo_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_ice=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_ice.setValue(importarexportar.getmonto_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_ice=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_ice.setValue(importarexportar.getid_tipo_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebase_general=new ParameterValue<Double>();
					parameterMaintenanceValuebase_general.setValue(importarexportar.getbase_general());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebase_general);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_banco.setValue(importarexportar.getid_tipo_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_comprobante_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_comprobante_banco.setValue(importarexportar.getid_tipo_comprobante_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_comprobante_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_convenio=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_convenio.setValue(importarexportar.getcon_convenio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_convenio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_devolucion=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_devolucion.setValue(importarexportar.getcon_devolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_devolucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(importarexportar.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_serie_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_serie_comprobante.setValue(importarexportar.getnumero_serie_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_serie_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_autorizacion_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_autorizacion_comprobante.setValue(importarexportar.getnumero_autorizacion_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_autorizacion_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_secuencial_fuente=new ParameterValue<String>();
					parameterMaintenanceValuenumero_secuencial_fuente.setValue(importarexportar.getnumero_secuencial_fuente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_secuencial_fuente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_fob=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_fob.setValue(importarexportar.getvalor_fob());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_fob);
					parametersTemp.add(parameterMaintenance);
					
						if(!importarexportar.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(importarexportar.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(importarexportar.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(importarexportar.getId());
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
	
	public void setIsNewIsChangedFalseImportarExportar(ImportarExportar importarexportar)throws Exception  {		
		importarexportar.setIsNew(false);
		importarexportar.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseImportarExportars(List<ImportarExportar> importarexportars)throws Exception  {				
		for(ImportarExportar importarexportar:importarexportars) {
			importarexportar.setIsNew(false);
			importarexportar.setIsChanged(false);
		}
	}
	
	public void generarExportarImportarExportar(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
