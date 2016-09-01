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
package com.bydan.erp.importaciones.business.dataaccess;

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

import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.importaciones.util.*;//DetalleLiquidacionImpuestoImporConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class DetalleLiquidacionImpuestoImporDataAccess extends  DetalleLiquidacionImpuestoImporDataAccessAdditional{ //DetalleLiquidacionImpuestoImporDataAccessAdditional,DataAccessHelper<DetalleLiquidacionImpuestoImpor>
	//static Logger logger = Logger.getLogger(DetalleLiquidacionImpuestoImporDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_liquidacion_impuesto_impor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+"(version_row,id_liquidacion_impuesto_impor,id_empresa,id_sucursal,cantidad,valor,fob,porcentaje_iva,porcentaje_arancel,porcentaje_aplicar,flete,seguro,base_imponible,valor_arancel,valor_fodi,valor_iva,numero_comprobante,porcentaje_fodi,valor_imponible)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_liquidacion_impuesto_impor=?,id_empresa=?,id_sucursal=?,cantidad=?,valor=?,fob=?,porcentaje_iva=?,porcentaje_arancel=?,porcentaje_aplicar=?,flete=?,seguro=?,base_imponible=?,valor_arancel=?,valor_fodi=?,valor_iva=?,numero_comprobante=?,porcentaje_fodi=?,valor_imponible=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleliquidacionimpuestoimpor from "+DetalleLiquidacionImpuestoImporConstantesFunciones.SPERSISTENCENAME+" detalleliquidacionimpuestoimpor";
	public static String QUERYSELECTNATIVE="select "+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".version_row,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_liquidacion_impuesto_impor,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_empresa,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".cantidad,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".valor,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".fob,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".porcentaje_iva,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".porcentaje_arancel,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".porcentaje_aplicar,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".flete,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".seguro,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".base_imponible,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".valor_arancel,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".valor_fodi,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".valor_iva,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".porcentaje_fodi,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".valor_imponible from "+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME;//+" as "+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".id,"+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+".version_row from "+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME;//+" as "+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleLiquidacionImpuestoImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImpuestoImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_liquidacion_impuesto_impor=?,id_empresa=?,id_sucursal=?,cantidad=?,valor=?,fob=?,porcentaje_iva=?,porcentaje_arancel=?,porcentaje_aplicar=?,flete=?,seguro=?,base_imponible=?,valor_arancel=?,valor_fodi=?,valor_iva=?,numero_comprobante=?,porcentaje_fodi=?,valor_imponible=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLELIQUIDACIONIMPUESTOIMPOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLELIQUIDACIONIMPUESTOIMPOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLELIQUIDACIONIMPUESTOIMPOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLELIQUIDACIONIMPUESTOIMPOR_SELECT(?,?)";
	
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
	
	
	protected DetalleLiquidacionImpuestoImporDataAccessAdditional detalleliquidacionimpuestoimporDataAccessAdditional=null;
	
	public DetalleLiquidacionImpuestoImporDataAccessAdditional getDetalleLiquidacionImpuestoImporDataAccessAdditional() {
		return this.detalleliquidacionimpuestoimporDataAccessAdditional;
	}
	
	public void setDetalleLiquidacionImpuestoImporDataAccessAdditional(DetalleLiquidacionImpuestoImporDataAccessAdditional detalleliquidacionimpuestoimporDataAccessAdditional) {
		try {
			this.detalleliquidacionimpuestoimporDataAccessAdditional=detalleliquidacionimpuestoimporDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleLiquidacionImpuestoImporDataAccess() {
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
		DetalleLiquidacionImpuestoImporDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleLiquidacionImpuestoImporDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleLiquidacionImpuestoImporDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleLiquidacionImpuestoImporOriginal(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor)throws Exception  {
		detalleliquidacionimpuestoimpor.setDetalleLiquidacionImpuestoImporOriginal((DetalleLiquidacionImpuestoImpor)detalleliquidacionimpuestoimpor.clone());		
	}
	
	public void setDetalleLiquidacionImpuestoImporsOriginal(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors)throws Exception  {
		
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:detalleliquidacionimpuestoimpors){
			detalleliquidacionimpuestoimpor.setDetalleLiquidacionImpuestoImporOriginal((DetalleLiquidacionImpuestoImpor)detalleliquidacionimpuestoimpor.clone());
		}
	}
	
	public static void setDetalleLiquidacionImpuestoImporOriginalStatic(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor)throws Exception  {
		detalleliquidacionimpuestoimpor.setDetalleLiquidacionImpuestoImporOriginal((DetalleLiquidacionImpuestoImpor)detalleliquidacionimpuestoimpor.clone());		
	}
	
	public static void setDetalleLiquidacionImpuestoImporsOriginalStatic(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors)throws Exception  {
		
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:detalleliquidacionimpuestoimpors){
			detalleliquidacionimpuestoimpor.setDetalleLiquidacionImpuestoImporOriginal((DetalleLiquidacionImpuestoImpor)detalleliquidacionimpuestoimpor.clone());
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
	
	public  DetalleLiquidacionImpuestoImpor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		
		
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
	
	public  DetalleLiquidacionImpuestoImpor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleLiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleLiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Importaciones.DetalleLiquidacionImpuestoImpor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleLiquidacionImpuestoImporOriginal(new DetalleLiquidacionImpuestoImpor());
      	    	entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleLiquidacionImpuestoImpor("",entity,resultSet); 
				
				//entity.setDetalleLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleLiquidacionImpuestoImporOriginal(this.getEntityDetalleLiquidacionImpuestoImpor("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleLiquidacionImpuestoImpor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleLiquidacionImpuestoImpor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();
				
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
	
	public  DetalleLiquidacionImpuestoImpor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleLiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleLiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleLiquidacionImpuestoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.DetalleLiquidacionImpuestoImpor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleLiquidacionImpuestoImporOriginal(new DetalleLiquidacionImpuestoImpor());
      	    	entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleLiquidacionImpuestoImpor("",entity,resultSet);    
				
				//entity.setDetalleLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleLiquidacionImpuestoImporOriginal(this.getEntityDetalleLiquidacionImpuestoImpor("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleLiquidacionImpuestoImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleLiquidacionImpuestoImpor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleLiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleLiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleLiquidacionImpuestoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.DetalleLiquidacionImpuestoImpor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleLiquidacionImpuestoImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleLiquidacionImpuestoImpor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleLiquidacionImpuestoImpor> entities = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		  
		
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
	
	public  List<DetalleLiquidacionImpuestoImpor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleLiquidacionImpuestoImpor> entities = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleLiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleLiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleLiquidacionImpuestoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleLiquidacionImpuestoImpor();
      	    	entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleLiquidacionImpuestoImpor("",entity,resultSet);
      	    	
				//entity.setDetalleLiquidacionImpuestoImporOriginal( new DetalleLiquidacionImpuestoImpor());
      	    	//entity.setDetalleLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleLiquidacionImpuestoImporOriginal(this.getEntityDetalleLiquidacionImpuestoImpor("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleLiquidacionImpuestoImpors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleLiquidacionImpuestoImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleLiquidacionImpuestoImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleLiquidacionImpuestoImpor> entities = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		  
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
	
	public  List<DetalleLiquidacionImpuestoImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleLiquidacionImpuestoImpor> entities = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleLiquidacionImpuestoImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleLiquidacionImpuestoImpor();
					//entity.setMapDetalleLiquidacionImpuestoImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleLiquidacionImpuestoImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleLiquidacionImpuestoImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         		
					entity=DetalleLiquidacionImpuestoImporDataAccess.getEntityDetalleLiquidacionImpuestoImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleLiquidacionImpuestoImporOriginal( new DetalleLiquidacionImpuestoImpor());
					////entity.setDetalleLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleLiquidacionImpuestoImporOriginal(this.getEntityDetalleLiquidacionImpuestoImpor("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleLiquidacionImpuestoImpors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleLiquidacionImpuestoImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleLiquidacionImpuestoImpor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		  
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
	
	public  DetalleLiquidacionImpuestoImpor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleLiquidacionImpuestoImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleLiquidacionImpuestoImpor();
					//entity.setMapDetalleLiquidacionImpuestoImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleLiquidacionImpuestoImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleLiquidacionImpuestoImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         		
					entity=DetalleLiquidacionImpuestoImporDataAccess.getEntityDetalleLiquidacionImpuestoImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleLiquidacionImpuestoImporOriginal( new DetalleLiquidacionImpuestoImpor());
					////entity.setDetalleLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleLiquidacionImpuestoImporOriginal(this.getEntityDetalleLiquidacionImpuestoImpor("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleLiquidacionImpuestoImpor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleLiquidacionImpuestoImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleLiquidacionImpuestoImpor getEntityDetalleLiquidacionImpuestoImpor(String strPrefijo,DetalleLiquidacionImpuestoImpor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleLiquidacionImpuestoImpor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleLiquidacionImpuestoImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleLiquidacionImpuestoImporDataAccess.setFieldReflectionDetalleLiquidacionImpuestoImpor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleLiquidacionImpuestoImpor=DetalleLiquidacionImpuestoImporConstantesFunciones.getTodosTiposColumnasDetalleLiquidacionImpuestoImpor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleLiquidacionImpuestoImpor) {
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
							field = DetalleLiquidacionImpuestoImpor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleLiquidacionImpuestoImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleLiquidacionImpuestoImporDataAccess.setFieldReflectionDetalleLiquidacionImpuestoImpor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleLiquidacionImpuestoImpor(Field field,String strPrefijo,String sColumn,DetalleLiquidacionImpuestoImpor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.IDLIQUIDACIONIMPUESTOIMPOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.FOB:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEARANCEL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEAPLICAR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.SEGURO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.BASEIMPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.VALORARANCEL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.VALORFODI:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIMPONIBLE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleLiquidacionImpuestoImpor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleLiquidacionImpuestoImpor> entities = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleLiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleLiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleLiquidacionImpuestoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleLiquidacionImpuestoImpor();
					entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleLiquidacionImpuestoImpor("",entity,resultSet);
					
					//entity.setDetalleLiquidacionImpuestoImporOriginal( new DetalleLiquidacionImpuestoImpor());
					//entity.setDetalleLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleLiquidacionImpuestoImporOriginal(this.getEntityDetalleLiquidacionImpuestoImpor("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleLiquidacionImpuestoImpors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleLiquidacionImpuestoImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleLiquidacionImpuestoImpor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleLiquidacionImpuestoImpor> entities = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleLiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleLiquidacionImpuestoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleLiquidacionImpuestoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleLiquidacionImpuestoImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleLiquidacionImpuestoImpor> entities = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		  
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
	
	public  List<DetalleLiquidacionImpuestoImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleLiquidacionImpuestoImpor> entities = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleLiquidacionImpuestoImpor();
      	    	entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleLiquidacionImpuestoImpor("",entity,resultSet);
      	    	
				//entity.setDetalleLiquidacionImpuestoImporOriginal( new DetalleLiquidacionImpuestoImpor());
      	    	//entity.setDetalleLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleLiquidacionImpuestoImporOriginal(this.getEntityDetalleLiquidacionImpuestoImpor("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleLiquidacionImpuestoImpors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleLiquidacionImpuestoImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleLiquidacionImpuestoImpor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleLiquidacionImpuestoImpor> entities = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		  
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
	
	public  List<DetalleLiquidacionImpuestoImpor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleLiquidacionImpuestoImpor> entities = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		DetalleLiquidacionImpuestoImpor entity = new DetalleLiquidacionImpuestoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleLiquidacionImpuestoImpor();
      	    	entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleLiquidacionImpuestoImpor("",entity,resultSet);
      	    	
				//entity.setDetalleLiquidacionImpuestoImporOriginal( new DetalleLiquidacionImpuestoImpor());
      	    	//entity.setDetalleLiquidacionImpuestoImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleLiquidacionImpuestoImporOriginal(this.getEntityDetalleLiquidacionImpuestoImpor("",entity.getDetalleLiquidacionImpuestoImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleLiquidacionImpuestoImpors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleLiquidacionImpuestoImpor getEntityDetalleLiquidacionImpuestoImpor(String strPrefijo,DetalleLiquidacionImpuestoImpor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_liquidacion_impuesto_impor(resultSet.getLong(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.IDLIQUIDACIONIMPUESTOIMPOR));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL));
				entity.setcantidad(resultSet.getInt(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.CANTIDAD));
				entity.setvalor(resultSet.getDouble(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.VALOR));
				entity.setfob(resultSet.getDouble(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.FOB));
				entity.setporcentaje_iva(resultSet.getDouble(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA));
				entity.setporcentaje_arancel(resultSet.getDouble(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEARANCEL));
				entity.setporcentaje_aplicar(resultSet.getDouble(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEAPLICAR));
				entity.setflete(resultSet.getDouble(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.FLETE));
				entity.setseguro(resultSet.getDouble(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.SEGURO));
				entity.setbase_imponible(resultSet.getDouble(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.BASEIMPONIBLE));
				entity.setvalor_arancel(resultSet.getDouble(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.VALORARANCEL));
				entity.setvalor_fodi(resultSet.getDouble(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.VALORFODI));
				entity.setvalor_iva(resultSet.getDouble(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIVA));
				entity.setnumero_comprobante(resultSet.getInt(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setporcentaje_fodi(resultSet.getDouble(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI));
				entity.setvalor_imponible(resultSet.getDouble(strPrefijo+DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIMPONIBLE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleLiquidacionImpuestoImpor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleLiquidacionImpuestoImpor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleLiquidacionImpuestoImporDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleLiquidacionImpuestoImporDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleLiquidacionImpuestoImporDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleLiquidacionImpuestoImporDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleLiquidacionImpuestoImporConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleLiquidacionImpuestoImporDataAccess.TABLENAME,DetalleLiquidacionImpuestoImporDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleLiquidacionImpuestoImporDataAccess.setDetalleLiquidacionImpuestoImporOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public LiquidacionImpuestoImpor getLiquidacionImpuestoImpor(Connexion connexion,DetalleLiquidacionImpuestoImpor reldetalleliquidacionimpuestoimpor)throws SQLException,Exception {

		LiquidacionImpuestoImpor liquidacionimpuestoimpor= new LiquidacionImpuestoImpor();

		try {
			LiquidacionImpuestoImporDataAccess liquidacionimpuestoimporDataAccess=new LiquidacionImpuestoImporDataAccess();

			liquidacionimpuestoimporDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			liquidacionimpuestoimporDataAccess.setConnexionType(this.connexionType);
			liquidacionimpuestoimporDataAccess.setParameterDbType(this.parameterDbType);

			liquidacionimpuestoimpor=liquidacionimpuestoimporDataAccess.getEntity(connexion,reldetalleliquidacionimpuestoimpor.getid_liquidacion_impuesto_impor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return liquidacionimpuestoimpor;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleLiquidacionImpuestoImpor reldetalleliquidacionimpuestoimpor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleliquidacionimpuestoimpor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleLiquidacionImpuestoImpor reldetalleliquidacionimpuestoimpor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleliquidacionimpuestoimpor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleliquidacionimpuestoimpor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_liquidacion_impuesto_impor=new ParameterValue<Long>();
					parameterMaintenanceValueid_liquidacion_impuesto_impor.setValue(detalleliquidacionimpuestoimpor.getid_liquidacion_impuesto_impor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_liquidacion_impuesto_impor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleliquidacionimpuestoimpor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleliquidacionimpuestoimpor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detalleliquidacionimpuestoimpor.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(detalleliquidacionimpuestoimpor.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefob=new ParameterValue<Double>();
					parameterMaintenanceValuefob.setValue(detalleliquidacionimpuestoimpor.getfob());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefob);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_iva=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_iva.setValue(detalleliquidacionimpuestoimpor.getporcentaje_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_arancel=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_arancel.setValue(detalleliquidacionimpuestoimpor.getporcentaje_arancel());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_arancel);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_aplicar=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_aplicar.setValue(detalleliquidacionimpuestoimpor.getporcentaje_aplicar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_aplicar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(detalleliquidacionimpuestoimpor.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueseguro=new ParameterValue<Double>();
					parameterMaintenanceValueseguro.setValue(detalleliquidacionimpuestoimpor.getseguro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueseguro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebase_imponible=new ParameterValue<Double>();
					parameterMaintenanceValuebase_imponible.setValue(detalleliquidacionimpuestoimpor.getbase_imponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebase_imponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_arancel=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_arancel.setValue(detalleliquidacionimpuestoimpor.getvalor_arancel());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_arancel);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_fodi=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_fodi.setValue(detalleliquidacionimpuestoimpor.getvalor_fodi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_fodi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_iva=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_iva.setValue(detalleliquidacionimpuestoimpor.getvalor_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_comprobante=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_comprobante.setValue(detalleliquidacionimpuestoimpor.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_fodi=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_fodi.setValue(detalleliquidacionimpuestoimpor.getporcentaje_fodi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_fodi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_imponible=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_imponible.setValue(detalleliquidacionimpuestoimpor.getvalor_imponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_imponible);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleliquidacionimpuestoimpor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleliquidacionimpuestoimpor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleliquidacionimpuestoimpor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleliquidacionimpuestoimpor.getId());
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
	
	public void setIsNewIsChangedFalseDetalleLiquidacionImpuestoImpor(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor)throws Exception  {		
		detalleliquidacionimpuestoimpor.setIsNew(false);
		detalleliquidacionimpuestoimpor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleLiquidacionImpuestoImpors(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors)throws Exception  {				
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:detalleliquidacionimpuestoimpors) {
			detalleliquidacionimpuestoimpor.setIsNew(false);
			detalleliquidacionimpuestoimpor.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleLiquidacionImpuestoImpor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
