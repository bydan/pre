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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//DetaNotaCreditoSoliConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class DetaNotaCreditoSoliDataAccess extends  DetaNotaCreditoSoliDataAccessAdditional{ //DetaNotaCreditoSoliDataAccessAdditional,DataAccessHelper<DetaNotaCreditoSoli>
	//static Logger logger = Logger.getLogger(DetaNotaCreditoSoliDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="deta_nota_credito_soli";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_nota_credito_soli,id_bodega,id_producto,id_unidad,id_empaque,id_tipo_devolucion_empresa,id_centro_costo,cantidad,precio,porcen_descuen,descuento,impuesto,porcen_iva,total,descripcion,codigo_lote,numero_caja,descuento2,costo,incluye_impuesto,porcen_ice,fecha_emision)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_nota_credito_soli=?,id_bodega=?,id_producto=?,id_unidad=?,id_empaque=?,id_tipo_devolucion_empresa=?,id_centro_costo=?,cantidad=?,precio=?,porcen_descuen=?,descuento=?,impuesto=?,porcen_iva=?,total=?,descripcion=?,codigo_lote=?,numero_caja=?,descuento2=?,costo=?,incluye_impuesto=?,porcen_ice=?,fecha_emision=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detanotacreditosoli from "+DetaNotaCreditoSoliConstantesFunciones.SPERSISTENCENAME+" detanotacreditosoli";
	public static String QUERYSELECTNATIVE="select "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".version_row,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_empresa,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_sucursal,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_ejercicio,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_periodo,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_anio,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_mes,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_nota_credito_soli,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_bodega,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_producto,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_unidad,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_empaque,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_tipo_devolucion_empresa,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id_centro_costo,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".cantidad,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".precio,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".porcen_descuen,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".descuento,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".impuesto,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".porcen_iva,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".total,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".descripcion,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".codigo_lote,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".numero_caja,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".descuento2,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".costo,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".incluye_impuesto,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".porcen_ice,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".fecha_emision from "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME;//+" as "+DetaNotaCreditoSoliConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".id,"+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+".version_row from "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME;//+" as "+DetaNotaCreditoSoliConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+"."+DetaNotaCreditoSoliConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_nota_credito_soli=?,id_bodega=?,id_producto=?,id_unidad=?,id_empaque=?,id_tipo_devolucion_empresa=?,id_centro_costo=?,cantidad=?,precio=?,porcen_descuen=?,descuento=?,impuesto=?,porcen_iva=?,total=?,descripcion=?,codigo_lote=?,numero_caja=?,descuento2=?,costo=?,incluye_impuesto=?,porcen_ice=?,fecha_emision=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETANOTACREDITOSOLI_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETANOTACREDITOSOLI_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETANOTACREDITOSOLI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETANOTACREDITOSOLI_SELECT(?,?)";
	
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
	
	
	protected DetaNotaCreditoSoliDataAccessAdditional detanotacreditosoliDataAccessAdditional=null;
	
	public DetaNotaCreditoSoliDataAccessAdditional getDetaNotaCreditoSoliDataAccessAdditional() {
		return this.detanotacreditosoliDataAccessAdditional;
	}
	
	public void setDetaNotaCreditoSoliDataAccessAdditional(DetaNotaCreditoSoliDataAccessAdditional detanotacreditosoliDataAccessAdditional) {
		try {
			this.detanotacreditosoliDataAccessAdditional=detanotacreditosoliDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetaNotaCreditoSoliDataAccess() {
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
		DetaNotaCreditoSoliDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetaNotaCreditoSoliDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetaNotaCreditoSoliDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetaNotaCreditoSoliOriginal(DetaNotaCreditoSoli detanotacreditosoli)throws Exception  {
		detanotacreditosoli.setDetaNotaCreditoSoliOriginal((DetaNotaCreditoSoli)detanotacreditosoli.clone());		
	}
	
	public void setDetaNotaCreditoSolisOriginal(List<DetaNotaCreditoSoli> detanotacreditosolis)throws Exception  {
		
		for(DetaNotaCreditoSoli detanotacreditosoli:detanotacreditosolis){
			detanotacreditosoli.setDetaNotaCreditoSoliOriginal((DetaNotaCreditoSoli)detanotacreditosoli.clone());
		}
	}
	
	public static void setDetaNotaCreditoSoliOriginalStatic(DetaNotaCreditoSoli detanotacreditosoli)throws Exception  {
		detanotacreditosoli.setDetaNotaCreditoSoliOriginal((DetaNotaCreditoSoli)detanotacreditosoli.clone());		
	}
	
	public static void setDetaNotaCreditoSolisOriginalStatic(List<DetaNotaCreditoSoli> detanotacreditosolis)throws Exception  {
		
		for(DetaNotaCreditoSoli detanotacreditosoli:detanotacreditosolis){
			detanotacreditosoli.setDetaNotaCreditoSoliOriginal((DetaNotaCreditoSoli)detanotacreditosoli.clone());
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
	
	public  DetaNotaCreditoSoli getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		
		
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
	
	public  DetaNotaCreditoSoli getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetaNotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetaNotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.DetaNotaCreditoSoli.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetaNotaCreditoSoliOriginal(new DetaNotaCreditoSoli());
      	    	entity=super.getEntity("",entity,resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetaNotaCreditoSoli("",entity,resultSet); 
				
				//entity.setDetaNotaCreditoSoliOriginal(super.getEntity("",entity.getDetaNotaCreditoSoliOriginal(),resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaNotaCreditoSoliOriginal(this.getEntityDetaNotaCreditoSoli("",entity.getDetaNotaCreditoSoliOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetaNotaCreditoSoli(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetaNotaCreditoSoli getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();
				
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
	
	public  DetaNotaCreditoSoli getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetaNotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetaNotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaNotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetaNotaCreditoSoli.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetaNotaCreditoSoliOriginal(new DetaNotaCreditoSoli());
      	    	entity=super.getEntity("",entity,resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetaNotaCreditoSoli("",entity,resultSet);    
				
				//entity.setDetaNotaCreditoSoliOriginal(super.getEntity("",entity.getDetaNotaCreditoSoliOriginal(),resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaNotaCreditoSoliOriginal(this.getEntityDetaNotaCreditoSoli("",entity.getDetaNotaCreditoSoliOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetaNotaCreditoSoli(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetaNotaCreditoSoli
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetaNotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetaNotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaNotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetaNotaCreditoSoli.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetaNotaCreditoSoli(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetaNotaCreditoSoli> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetaNotaCreditoSoli> entities = new  ArrayList<DetaNotaCreditoSoli>();
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		  
		
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
	
	public  List<DetaNotaCreditoSoli> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetaNotaCreditoSoli> entities = new  ArrayList<DetaNotaCreditoSoli>();
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetaNotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetaNotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaNotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaNotaCreditoSoli();
      	    	entity=super.getEntity("",entity,resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetaNotaCreditoSoli("",entity,resultSet);
      	    	
				//entity.setDetaNotaCreditoSoliOriginal( new DetaNotaCreditoSoli());
      	    	//entity.setDetaNotaCreditoSoliOriginal(super.getEntity("",entity.getDetaNotaCreditoSoliOriginal(),resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaNotaCreditoSoliOriginal(this.getEntityDetaNotaCreditoSoli("",entity.getDetaNotaCreditoSoliOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetaNotaCreditoSolis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetaNotaCreditoSoli> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetaNotaCreditoSoli> entities = new  ArrayList<DetaNotaCreditoSoli>();
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		  
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
	
	public  List<DetaNotaCreditoSoli> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetaNotaCreditoSoli> entities = new  ArrayList<DetaNotaCreditoSoli>();
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaNotaCreditoSoli();
				
				if(conMapGenerico) {
					entity.inicializarMapDetaNotaCreditoSoli();
					//entity.setMapDetaNotaCreditoSoli(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetaNotaCreditoSoliValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetaNotaCreditoSoli().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
					entity=DetaNotaCreditoSoliDataAccess.getEntityDetaNotaCreditoSoli("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetaNotaCreditoSoliOriginal( new DetaNotaCreditoSoli());
					////entity.setDetaNotaCreditoSoliOriginal(super.getEntity("",entity.getDetaNotaCreditoSoliOriginal(),resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
					////entity.setDetaNotaCreditoSoliOriginal(this.getEntityDetaNotaCreditoSoli("",entity.getDetaNotaCreditoSoliOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetaNotaCreditoSolis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetaNotaCreditoSoli getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		  
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
	
	public  DetaNotaCreditoSoli getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaNotaCreditoSoli();
				
				if(conMapGenerico) {
					entity.inicializarMapDetaNotaCreditoSoli();
					//entity.setMapDetaNotaCreditoSoli(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetaNotaCreditoSoliValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetaNotaCreditoSoli().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
					entity=DetaNotaCreditoSoliDataAccess.getEntityDetaNotaCreditoSoli("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetaNotaCreditoSoliOriginal( new DetaNotaCreditoSoli());
					////entity.setDetaNotaCreditoSoliOriginal(super.getEntity("",entity.getDetaNotaCreditoSoliOriginal(),resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
					////entity.setDetaNotaCreditoSoliOriginal(this.getEntityDetaNotaCreditoSoli("",entity.getDetaNotaCreditoSoliOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetaNotaCreditoSoli(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetaNotaCreditoSoli getEntityDetaNotaCreditoSoli(String strPrefijo,DetaNotaCreditoSoli entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetaNotaCreditoSoli.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetaNotaCreditoSoli.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetaNotaCreditoSoliDataAccess.setFieldReflectionDetaNotaCreditoSoli(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetaNotaCreditoSoli=DetaNotaCreditoSoliConstantesFunciones.getTodosTiposColumnasDetaNotaCreditoSoli();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetaNotaCreditoSoli) {
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
							field = DetaNotaCreditoSoli.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetaNotaCreditoSoli.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetaNotaCreditoSoliDataAccess.setFieldReflectionDetaNotaCreditoSoli(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetaNotaCreditoSoli(Field field,String strPrefijo,String sColumn,DetaNotaCreditoSoli entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetaNotaCreditoSoliConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IDNOTACREDITOSOLI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IDEMPAQUE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IDTIPODEVOLUCIONEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.PORCENDESCUEN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.IMPUESTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.PORCENIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.CODIGOLOTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.NUMEROCAJA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.DESCUENTO2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.INCLUYEIMPUESTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.PORCENICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetaNotaCreditoSoliConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetaNotaCreditoSoli>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetaNotaCreditoSoli> entities = new  ArrayList<DetaNotaCreditoSoli>();
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetaNotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetaNotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaNotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetaNotaCreditoSoli();
					entity=super.getEntity("",entity,resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetaNotaCreditoSoli("",entity,resultSet);
					
					//entity.setDetaNotaCreditoSoliOriginal( new DetaNotaCreditoSoli());
					//entity.setDetaNotaCreditoSoliOriginal(super.getEntity("",entity.getDetaNotaCreditoSoliOriginal(),resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
					//entity.setDetaNotaCreditoSoliOriginal(this.getEntityDetaNotaCreditoSoli("",entity.getDetaNotaCreditoSoliOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetaNotaCreditoSolis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetaNotaCreditoSoli>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetaNotaCreditoSoli> entities = new  ArrayList<DetaNotaCreditoSoli>();
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetaNotaCreditoSoliDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetaNotaCreditoSoliDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetaNotaCreditoSoliDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetaNotaCreditoSoli> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaNotaCreditoSoli> entities = new  ArrayList<DetaNotaCreditoSoli>();
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		  
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
	
	public  List<DetaNotaCreditoSoli> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaNotaCreditoSoli> entities = new  ArrayList<DetaNotaCreditoSoli>();
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaNotaCreditoSoli();
      	    	entity=super.getEntity("",entity,resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetaNotaCreditoSoli("",entity,resultSet);
      	    	
				//entity.setDetaNotaCreditoSoliOriginal( new DetaNotaCreditoSoli());
      	    	//entity.setDetaNotaCreditoSoliOriginal(super.getEntity("",entity.getDetaNotaCreditoSoliOriginal(),resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaNotaCreditoSoliOriginal(this.getEntityDetaNotaCreditoSoli("",entity.getDetaNotaCreditoSoliOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetaNotaCreditoSolis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetaNotaCreditoSoli(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetaNotaCreditoSoli> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaNotaCreditoSoli> entities = new  ArrayList<DetaNotaCreditoSoli>();
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		  
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
	
	public  List<DetaNotaCreditoSoli> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetaNotaCreditoSoli> entities = new  ArrayList<DetaNotaCreditoSoli>();
		DetaNotaCreditoSoli entity = new DetaNotaCreditoSoli();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetaNotaCreditoSoli();
      	    	entity=super.getEntity("",entity,resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetaNotaCreditoSoli("",entity,resultSet);
      	    	
				//entity.setDetaNotaCreditoSoliOriginal( new DetaNotaCreditoSoli());
      	    	//entity.setDetaNotaCreditoSoliOriginal(super.getEntity("",entity.getDetaNotaCreditoSoliOriginal(),resultSet,DetaNotaCreditoSoliDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetaNotaCreditoSoliOriginal(this.getEntityDetaNotaCreditoSoli("",entity.getDetaNotaCreditoSoliOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetaNotaCreditoSolis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetaNotaCreditoSoli getEntityDetaNotaCreditoSoli(String strPrefijo,DetaNotaCreditoSoli entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_nota_credito_soli(resultSet.getLong(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IDNOTACREDITOSOLI));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IDUNIDAD));
				entity.setid_empaque(resultSet.getLong(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IDEMPAQUE));if(resultSet.wasNull()) {entity.setid_empaque(null); }
				entity.setid_tipo_devolucion_empresa(resultSet.getLong(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IDTIPODEVOLUCIONEMPRESA));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setcantidad(resultSet.getInt(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.CANTIDAD));
				entity.setprecio(resultSet.getDouble(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.PRECIO));
				entity.setporcen_descuen(resultSet.getDouble(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.PORCENDESCUEN));
				entity.setdescuento(resultSet.getDouble(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.DESCUENTO));
				entity.setimpuesto(resultSet.getDouble(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.IMPUESTO));
				entity.setporcen_iva(resultSet.getDouble(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.PORCENIVA));
				entity.settotal(resultSet.getDouble(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.TOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.DESCRIPCION));
				entity.setcodigo_lote(resultSet.getString(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.CODIGOLOTE));
				entity.setnumero_caja(resultSet.getString(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.NUMEROCAJA));
				entity.setdescuento2(resultSet.getDouble(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.DESCUENTO2));
				entity.setcosto(resultSet.getDouble(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.COSTO));
				entity.setincluye_impuesto(resultSet.getBoolean(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.INCLUYEIMPUESTO));
				entity.setporcen_ice(resultSet.getDouble(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.PORCENICE));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+DetaNotaCreditoSoliConstantesFunciones.FECHAEMISION).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetaNotaCreditoSoli(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetaNotaCreditoSoli entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetaNotaCreditoSoliDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetaNotaCreditoSoliDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetaNotaCreditoSoliDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetaNotaCreditoSoliDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetaNotaCreditoSoliConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetaNotaCreditoSoliDataAccess.TABLENAME,DetaNotaCreditoSoliDataAccess.ISWITHSTOREPROCEDURES);
			
			DetaNotaCreditoSoliDataAccess.setDetaNotaCreditoSoliOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetaNotaCreditoSoli reldetanotacreditosoli)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetanotacreditosoli.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetaNotaCreditoSoli reldetanotacreditosoli)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetanotacreditosoli.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetaNotaCreditoSoli reldetanotacreditosoli)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetanotacreditosoli.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetaNotaCreditoSoli reldetanotacreditosoli)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetanotacreditosoli.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetaNotaCreditoSoli reldetanotacreditosoli)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetanotacreditosoli.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetaNotaCreditoSoli reldetanotacreditosoli)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetanotacreditosoli.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public NotaCreditoSoli getNotaCreditoSoli(Connexion connexion,DetaNotaCreditoSoli reldetanotacreditosoli)throws SQLException,Exception {

		NotaCreditoSoli notacreditosoli= new NotaCreditoSoli();

		try {
			NotaCreditoSoliDataAccess notacreditosoliDataAccess=new NotaCreditoSoliDataAccess();

			notacreditosoliDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			notacreditosoliDataAccess.setConnexionType(this.connexionType);
			notacreditosoliDataAccess.setParameterDbType(this.parameterDbType);

			notacreditosoli=notacreditosoliDataAccess.getEntity(connexion,reldetanotacreditosoli.getid_nota_credito_soli());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditosoli;

	}

	public Bodega getBodega(Connexion connexion,DetaNotaCreditoSoli reldetanotacreditosoli)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetanotacreditosoli.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetaNotaCreditoSoli reldetanotacreditosoli)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetanotacreditosoli.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetaNotaCreditoSoli reldetanotacreditosoli)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetanotacreditosoli.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public Empaque getEmpaque(Connexion connexion,DetaNotaCreditoSoli reldetanotacreditosoli)throws SQLException,Exception {

		Empaque empaque= new Empaque();

		try {
			EmpaqueDataAccess empaqueDataAccess=new EmpaqueDataAccess();

			empaqueDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empaqueDataAccess.setConnexionType(this.connexionType);
			empaqueDataAccess.setParameterDbType(this.parameterDbType);

			empaque=empaqueDataAccess.getEntity(connexion,reldetanotacreditosoli.getid_empaque());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empaque;

	}

	public TipoDevolucionEmpresa getTipoDevolucionEmpresa(Connexion connexion,DetaNotaCreditoSoli reldetanotacreditosoli)throws SQLException,Exception {

		TipoDevolucionEmpresa tipodevolucionempresa= new TipoDevolucionEmpresa();

		try {
			TipoDevolucionEmpresaDataAccess tipodevolucionempresaDataAccess=new TipoDevolucionEmpresaDataAccess();

			tipodevolucionempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodevolucionempresaDataAccess.setConnexionType(this.connexionType);
			tipodevolucionempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipodevolucionempresa=tipodevolucionempresaDataAccess.getEntity(connexion,reldetanotacreditosoli.getid_tipo_devolucion_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodevolucionempresa;

	}

	public CentroCosto getCentroCosto(Connexion connexion,DetaNotaCreditoSoli reldetanotacreditosoli)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,reldetanotacreditosoli.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetaNotaCreditoSoli detanotacreditosoli) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detanotacreditosoli.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detanotacreditosoli.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detanotacreditosoli.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detanotacreditosoli.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detanotacreditosoli.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detanotacreditosoli.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detanotacreditosoli.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_nota_credito_soli=new ParameterValue<Long>();
					parameterMaintenanceValueid_nota_credito_soli.setValue(detanotacreditosoli.getid_nota_credito_soli());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_nota_credito_soli);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detanotacreditosoli.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detanotacreditosoli.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detanotacreditosoli.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empaque=new ParameterValue<Long>();
					parameterMaintenanceValueid_empaque.setValue(detanotacreditosoli.getid_empaque());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empaque);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_devolucion_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_devolucion_empresa.setValue(detanotacreditosoli.getid_tipo_devolucion_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_devolucion_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(detanotacreditosoli.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detanotacreditosoli.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(detanotacreditosoli.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcen_descuen=new ParameterValue<Double>();
					parameterMaintenanceValueporcen_descuen.setValue(detanotacreditosoli.getporcen_descuen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_descuen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(detanotacreditosoli.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto.setValue(detanotacreditosoli.getimpuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcen_iva=new ParameterValue<Double>();
					parameterMaintenanceValueporcen_iva.setValue(detanotacreditosoli.getporcen_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(detanotacreditosoli.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detanotacreditosoli.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_lote=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_lote.setValue(detanotacreditosoli.getcodigo_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_caja=new ParameterValue<String>();
					parameterMaintenanceValuenumero_caja.setValue(detanotacreditosoli.getnumero_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_caja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento2=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento2.setValue(detanotacreditosoli.getdescuento2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(detanotacreditosoli.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueincluye_impuesto=new ParameterValue<Boolean>();
					parameterMaintenanceValueincluye_impuesto.setValue(detanotacreditosoli.getincluye_impuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueincluye_impuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcen_ice=new ParameterValue<Double>();
					parameterMaintenanceValueporcen_ice.setValue(detanotacreditosoli.getporcen_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(detanotacreditosoli.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
						if(!detanotacreditosoli.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detanotacreditosoli.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detanotacreditosoli.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detanotacreditosoli.getId());
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
	
	public void setIsNewIsChangedFalseDetaNotaCreditoSoli(DetaNotaCreditoSoli detanotacreditosoli)throws Exception  {		
		detanotacreditosoli.setIsNew(false);
		detanotacreditosoli.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetaNotaCreditoSolis(List<DetaNotaCreditoSoli> detanotacreditosolis)throws Exception  {				
		for(DetaNotaCreditoSoli detanotacreditosoli:detanotacreditosolis) {
			detanotacreditosoli.setIsNew(false);
			detanotacreditosoli.setIsChanged(false);
		}
	}
	
	public void generarExportarDetaNotaCreditoSoli(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
