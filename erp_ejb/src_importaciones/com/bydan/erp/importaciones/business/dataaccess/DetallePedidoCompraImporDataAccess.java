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
import com.bydan.erp.importaciones.util.*;//DetallePedidoCompraImporConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DetallePedidoCompraImporDataAccess extends  DetallePedidoCompraImporDataAccessAdditional{ //DetallePedidoCompraImporDataAccessAdditional,DataAccessHelper<DetallePedidoCompraImpor>
	//static Logger logger = Logger.getLogger(DetallePedidoCompraImporDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_pedido_compra_impor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+"(version_row,id_pedido_compra_impor,id_empresa,id_sucursal,id_bodega,id_producto,id_unidad,id_ejercicio,id_periodo,id_arancel,cantidad_pedido,cantidad_entra,cantidad_pendiente,porcentaje,peso,precio,lote,porcentaje_arancel,cantidad_unidad_auxiliar,precio_unidad_auxiliar,fob,fob_exw,total,descripcion,id_centro_costo,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pedido_compra_impor=?,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,id_ejercicio=?,id_periodo=?,id_arancel=?,cantidad_pedido=?,cantidad_entra=?,cantidad_pendiente=?,porcentaje=?,peso=?,precio=?,lote=?,porcentaje_arancel=?,cantidad_unidad_auxiliar=?,precio_unidad_auxiliar=?,fob=?,fob_exw=?,total=?,descripcion=?,id_centro_costo=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallepedidocompraimpor from "+DetallePedidoCompraImporConstantesFunciones.SPERSISTENCENAME+" detallepedidocompraimpor";
	public static String QUERYSELECTNATIVE="select "+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".version_row,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_pedido_compra_impor,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_empresa,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_sucursal,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_bodega,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_producto,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_unidad,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_ejercicio,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_periodo,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_arancel,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".cantidad_pedido,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".cantidad_entra,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".cantidad_pendiente,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".porcentaje,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".peso,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".precio,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".lote,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".porcentaje_arancel,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".cantidad_unidad_auxiliar,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".precio_unidad_auxiliar,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".fob,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".fob_exw,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".total,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".descripcion,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_centro_costo,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_anio,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_mes from "+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME;//+" as "+DetallePedidoCompraImporConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".version_row from "+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME;//+" as "+DetallePedidoCompraImporConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pedido_compra_impor=?,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,id_ejercicio=?,id_periodo=?,id_arancel=?,cantidad_pedido=?,cantidad_entra=?,cantidad_pendiente=?,porcentaje=?,peso=?,precio=?,lote=?,porcentaje_arancel=?,cantidad_unidad_auxiliar=?,precio_unidad_auxiliar=?,fob=?,fob_exw=?,total=?,descripcion=?,id_centro_costo=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEPEDIDOCOMPRAIMPOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEPEDIDOCOMPRAIMPOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEPEDIDOCOMPRAIMPOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEPEDIDOCOMPRAIMPOR_SELECT(?,?)";
	
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
	
	
	protected DetallePedidoCompraImporDataAccessAdditional detallepedidocompraimporDataAccessAdditional=null;
	
	public DetallePedidoCompraImporDataAccessAdditional getDetallePedidoCompraImporDataAccessAdditional() {
		return this.detallepedidocompraimporDataAccessAdditional;
	}
	
	public void setDetallePedidoCompraImporDataAccessAdditional(DetallePedidoCompraImporDataAccessAdditional detallepedidocompraimporDataAccessAdditional) {
		try {
			this.detallepedidocompraimporDataAccessAdditional=detallepedidocompraimporDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetallePedidoCompraImporDataAccess() {
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
		DetallePedidoCompraImporDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetallePedidoCompraImporDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetallePedidoCompraImporDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetallePedidoCompraImporOriginal(DetallePedidoCompraImpor detallepedidocompraimpor)throws Exception  {
		detallepedidocompraimpor.setDetallePedidoCompraImporOriginal((DetallePedidoCompraImpor)detallepedidocompraimpor.clone());		
	}
	
	public void setDetallePedidoCompraImporsOriginal(List<DetallePedidoCompraImpor> detallepedidocompraimpors)throws Exception  {
		
		for(DetallePedidoCompraImpor detallepedidocompraimpor:detallepedidocompraimpors){
			detallepedidocompraimpor.setDetallePedidoCompraImporOriginal((DetallePedidoCompraImpor)detallepedidocompraimpor.clone());
		}
	}
	
	public static void setDetallePedidoCompraImporOriginalStatic(DetallePedidoCompraImpor detallepedidocompraimpor)throws Exception  {
		detallepedidocompraimpor.setDetallePedidoCompraImporOriginal((DetallePedidoCompraImpor)detallepedidocompraimpor.clone());		
	}
	
	public static void setDetallePedidoCompraImporsOriginalStatic(List<DetallePedidoCompraImpor> detallepedidocompraimpors)throws Exception  {
		
		for(DetallePedidoCompraImpor detallepedidocompraimpor:detallepedidocompraimpors){
			detallepedidocompraimpor.setDetallePedidoCompraImporOriginal((DetallePedidoCompraImpor)detallepedidocompraimpor.clone());
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
	
	public  DetallePedidoCompraImpor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		
		
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
	
	public  DetallePedidoCompraImpor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePedidoCompraImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePedidoCompraImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Importaciones.DetallePedidoCompraImpor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetallePedidoCompraImporOriginal(new DetallePedidoCompraImpor());
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetallePedidoCompraImpor("",entity,resultSet); 
				
				//entity.setDetallePedidoCompraImporOriginal(super.getEntity("",entity.getDetallePedidoCompraImporOriginal(),resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoCompraImporOriginal(this.getEntityDetallePedidoCompraImpor("",entity.getDetallePedidoCompraImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetallePedidoCompraImpor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetallePedidoCompraImpor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();
				
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
	
	public  DetallePedidoCompraImpor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePedidoCompraImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePedidoCompraImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoCompraImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.DetallePedidoCompraImpor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetallePedidoCompraImporOriginal(new DetallePedidoCompraImpor());
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetallePedidoCompraImpor("",entity,resultSet);    
				
				//entity.setDetallePedidoCompraImporOriginal(super.getEntity("",entity.getDetallePedidoCompraImporOriginal(),resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoCompraImporOriginal(this.getEntityDetallePedidoCompraImpor("",entity.getDetallePedidoCompraImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetallePedidoCompraImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetallePedidoCompraImpor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePedidoCompraImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePedidoCompraImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoCompraImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.DetallePedidoCompraImpor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetallePedidoCompraImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetallePedidoCompraImpor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetallePedidoCompraImpor> entities = new  ArrayList<DetallePedidoCompraImpor>();
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		  
		
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
	
	public  List<DetallePedidoCompraImpor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetallePedidoCompraImpor> entities = new  ArrayList<DetallePedidoCompraImpor>();
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePedidoCompraImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePedidoCompraImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoCompraImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoCompraImpor();
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePedidoCompraImpor("",entity,resultSet);
      	    	
				//entity.setDetallePedidoCompraImporOriginal( new DetallePedidoCompraImpor());
      	    	//entity.setDetallePedidoCompraImporOriginal(super.getEntity("",entity.getDetallePedidoCompraImporOriginal(),resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoCompraImporOriginal(this.getEntityDetallePedidoCompraImpor("",entity.getDetallePedidoCompraImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePedidoCompraImpors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoCompraImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetallePedidoCompraImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetallePedidoCompraImpor> entities = new  ArrayList<DetallePedidoCompraImpor>();
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		  
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
	
	public  List<DetallePedidoCompraImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetallePedidoCompraImpor> entities = new  ArrayList<DetallePedidoCompraImpor>();
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoCompraImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapDetallePedidoCompraImpor();
					//entity.setMapDetallePedidoCompraImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetallePedidoCompraImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetallePedidoCompraImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA);         		
					entity=DetallePedidoCompraImporDataAccess.getEntityDetallePedidoCompraImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetallePedidoCompraImporOriginal( new DetallePedidoCompraImpor());
					////entity.setDetallePedidoCompraImporOriginal(super.getEntity("",entity.getDetallePedidoCompraImporOriginal(),resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA));         		
					////entity.setDetallePedidoCompraImporOriginal(this.getEntityDetallePedidoCompraImpor("",entity.getDetallePedidoCompraImporOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePedidoCompraImpors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoCompraImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetallePedidoCompraImpor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		  
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
	
	public  DetallePedidoCompraImpor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoCompraImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapDetallePedidoCompraImpor();
					//entity.setMapDetallePedidoCompraImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetallePedidoCompraImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetallePedidoCompraImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA);         		
					entity=DetallePedidoCompraImporDataAccess.getEntityDetallePedidoCompraImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetallePedidoCompraImporOriginal( new DetallePedidoCompraImpor());
					////entity.setDetallePedidoCompraImporOriginal(super.getEntity("",entity.getDetallePedidoCompraImporOriginal(),resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA));         		
					////entity.setDetallePedidoCompraImporOriginal(this.getEntityDetallePedidoCompraImpor("",entity.getDetallePedidoCompraImporOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetallePedidoCompraImpor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoCompraImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetallePedidoCompraImpor getEntityDetallePedidoCompraImpor(String strPrefijo,DetallePedidoCompraImpor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetallePedidoCompraImpor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetallePedidoCompraImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetallePedidoCompraImporDataAccess.setFieldReflectionDetallePedidoCompraImpor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetallePedidoCompraImpor=DetallePedidoCompraImporConstantesFunciones.getTodosTiposColumnasDetallePedidoCompraImpor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetallePedidoCompraImpor) {
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
							field = DetallePedidoCompraImpor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetallePedidoCompraImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetallePedidoCompraImporDataAccess.setFieldReflectionDetallePedidoCompraImpor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetallePedidoCompraImpor(Field field,String strPrefijo,String sColumn,DetallePedidoCompraImpor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetallePedidoCompraImporConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.IDARANCEL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.CANTIDADPEDIDO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.CANTIDADENTRA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.CANTIDADPENDIENTE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.PESO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.LOTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.PORCENTAJEARANCEL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.CANTIDADUNIDADAUXILIAR:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.PRECIOUNIDADAUXILIAR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.FOB:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.FOBEXW:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePedidoCompraImporConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetallePedidoCompraImpor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetallePedidoCompraImpor> entities = new  ArrayList<DetallePedidoCompraImpor>();
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePedidoCompraImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePedidoCompraImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoCompraImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetallePedidoCompraImpor();
					entity=super.getEntity("",entity,resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetallePedidoCompraImpor("",entity,resultSet);
					
					//entity.setDetallePedidoCompraImporOriginal( new DetallePedidoCompraImpor());
					//entity.setDetallePedidoCompraImporOriginal(super.getEntity("",entity.getDetallePedidoCompraImporOriginal(),resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA));         		
					//entity.setDetallePedidoCompraImporOriginal(this.getEntityDetallePedidoCompraImpor("",entity.getDetallePedidoCompraImporOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetallePedidoCompraImpors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoCompraImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetallePedidoCompraImpor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetallePedidoCompraImpor> entities = new  ArrayList<DetallePedidoCompraImpor>();
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePedidoCompraImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePedidoCompraImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePedidoCompraImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetallePedidoCompraImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoCompraImpor> entities = new  ArrayList<DetallePedidoCompraImpor>();
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		  
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
	
	public  List<DetallePedidoCompraImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoCompraImpor> entities = new  ArrayList<DetallePedidoCompraImpor>();
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoCompraImpor();
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePedidoCompraImpor("",entity,resultSet);
      	    	
				//entity.setDetallePedidoCompraImporOriginal( new DetallePedidoCompraImpor());
      	    	//entity.setDetallePedidoCompraImporOriginal(super.getEntity("",entity.getDetallePedidoCompraImporOriginal(),resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoCompraImporOriginal(this.getEntityDetallePedidoCompraImpor("",entity.getDetallePedidoCompraImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetallePedidoCompraImpors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePedidoCompraImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetallePedidoCompraImpor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoCompraImpor> entities = new  ArrayList<DetallePedidoCompraImpor>();
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		  
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
	
	public  List<DetallePedidoCompraImpor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePedidoCompraImpor> entities = new  ArrayList<DetallePedidoCompraImpor>();
		DetallePedidoCompraImpor entity = new DetallePedidoCompraImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePedidoCompraImpor();
      	    	entity=super.getEntity("",entity,resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePedidoCompraImpor("",entity,resultSet);
      	    	
				//entity.setDetallePedidoCompraImporOriginal( new DetallePedidoCompraImpor());
      	    	//entity.setDetallePedidoCompraImporOriginal(super.getEntity("",entity.getDetallePedidoCompraImporOriginal(),resultSet,DetallePedidoCompraImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePedidoCompraImporOriginal(this.getEntityDetallePedidoCompraImpor("",entity.getDetallePedidoCompraImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePedidoCompraImpors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetallePedidoCompraImpor getEntityDetallePedidoCompraImpor(String strPrefijo,DetallePedidoCompraImpor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pedido_compra_impor(resultSet.getLong(strPrefijo+DetallePedidoCompraImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetallePedidoCompraImporConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetallePedidoCompraImporConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetallePedidoCompraImporConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetallePedidoCompraImporConstantesFunciones.IDUNIDAD));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetallePedidoCompraImporConstantesFunciones.IDPERIODO));
				entity.setid_arancel(resultSet.getLong(strPrefijo+DetallePedidoCompraImporConstantesFunciones.IDARANCEL));
				entity.setcantidad_pedido(resultSet.getInt(strPrefijo+DetallePedidoCompraImporConstantesFunciones.CANTIDADPEDIDO));
				entity.setcantidad_entra(resultSet.getInt(strPrefijo+DetallePedidoCompraImporConstantesFunciones.CANTIDADENTRA));
				entity.setcantidad_pendiente(resultSet.getInt(strPrefijo+DetallePedidoCompraImporConstantesFunciones.CANTIDADPENDIENTE));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+DetallePedidoCompraImporConstantesFunciones.PORCENTAJE));
				entity.setpeso(resultSet.getDouble(strPrefijo+DetallePedidoCompraImporConstantesFunciones.PESO));
				entity.setprecio(resultSet.getDouble(strPrefijo+DetallePedidoCompraImporConstantesFunciones.PRECIO));
				entity.setlote(resultSet.getString(strPrefijo+DetallePedidoCompraImporConstantesFunciones.LOTE));
				entity.setporcentaje_arancel(resultSet.getDouble(strPrefijo+DetallePedidoCompraImporConstantesFunciones.PORCENTAJEARANCEL));
				entity.setcantidad_unidad_auxiliar(resultSet.getInt(strPrefijo+DetallePedidoCompraImporConstantesFunciones.CANTIDADUNIDADAUXILIAR));
				entity.setprecio_unidad_auxiliar(resultSet.getDouble(strPrefijo+DetallePedidoCompraImporConstantesFunciones.PRECIOUNIDADAUXILIAR));
				entity.setfob(resultSet.getDouble(strPrefijo+DetallePedidoCompraImporConstantesFunciones.FOB));
				entity.setfob_exw(resultSet.getDouble(strPrefijo+DetallePedidoCompraImporConstantesFunciones.FOBEXW));
				entity.settotal(resultSet.getDouble(strPrefijo+DetallePedidoCompraImporConstantesFunciones.TOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetallePedidoCompraImporConstantesFunciones.DESCRIPCION));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+DetallePedidoCompraImporConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_anio(resultSet.getLong(strPrefijo+DetallePedidoCompraImporConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetallePedidoCompraImporConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetallePedidoCompraImpor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetallePedidoCompraImpor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetallePedidoCompraImporDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetallePedidoCompraImporDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetallePedidoCompraImporDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetallePedidoCompraImporDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetallePedidoCompraImporConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetallePedidoCompraImporDataAccess.TABLENAME,DetallePedidoCompraImporDataAccess.ISWITHSTOREPROCEDURES);
			
			DetallePedidoCompraImporDataAccess.setDetallePedidoCompraImporOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public PedidoCompraImpor getPedidoCompraImpor(Connexion connexion,DetallePedidoCompraImpor reldetallepedidocompraimpor)throws SQLException,Exception {

		PedidoCompraImpor pedidocompraimpor= new PedidoCompraImpor();

		try {
			PedidoCompraImporDataAccess pedidocompraimporDataAccess=new PedidoCompraImporDataAccess();

			pedidocompraimporDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			pedidocompraimporDataAccess.setConnexionType(this.connexionType);
			pedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);

			pedidocompraimpor=pedidocompraimporDataAccess.getEntity(connexion,reldetallepedidocompraimpor.getid_pedido_compra_impor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompraimpor;

	}

	public Empresa getEmpresa(Connexion connexion,DetallePedidoCompraImpor reldetallepedidocompraimpor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallepedidocompraimpor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetallePedidoCompraImpor reldetallepedidocompraimpor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallepedidocompraimpor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,DetallePedidoCompraImpor reldetallepedidocompraimpor)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetallepedidocompraimpor.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetallePedidoCompraImpor reldetallepedidocompraimpor)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetallepedidocompraimpor.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetallePedidoCompraImpor reldetallepedidocompraimpor)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetallepedidocompraimpor.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetallePedidoCompraImpor reldetallepedidocompraimpor)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetallepedidocompraimpor.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetallePedidoCompraImpor reldetallepedidocompraimpor)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetallepedidocompraimpor.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Arancel getArancel(Connexion connexion,DetallePedidoCompraImpor reldetallepedidocompraimpor)throws SQLException,Exception {

		Arancel arancel= new Arancel();

		try {
			ArancelDataAccess arancelDataAccess=new ArancelDataAccess();

			arancelDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			arancelDataAccess.setConnexionType(this.connexionType);
			arancelDataAccess.setParameterDbType(this.parameterDbType);

			arancel=arancelDataAccess.getEntity(connexion,reldetallepedidocompraimpor.getid_arancel());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return arancel;

	}

	public CentroCosto getCentroCosto(Connexion connexion,DetallePedidoCompraImpor reldetallepedidocompraimpor)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,reldetallepedidocompraimpor.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public Anio getAnio(Connexion connexion,DetallePedidoCompraImpor reldetallepedidocompraimpor)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetallepedidocompraimpor.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetallePedidoCompraImpor reldetallepedidocompraimpor)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetallepedidocompraimpor.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetallePedidoCompraImpor detallepedidocompraimpor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallepedidocompraimpor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pedido_compra_impor=new ParameterValue<Long>();
					parameterMaintenanceValueid_pedido_compra_impor.setValue(detallepedidocompraimpor.getid_pedido_compra_impor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pedido_compra_impor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallepedidocompraimpor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallepedidocompraimpor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detallepedidocompraimpor.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detallepedidocompraimpor.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detallepedidocompraimpor.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detallepedidocompraimpor.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detallepedidocompraimpor.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_arancel=new ParameterValue<Long>();
					parameterMaintenanceValueid_arancel.setValue(detallepedidocompraimpor.getid_arancel());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_arancel);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_pedido=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_pedido.setValue(detallepedidocompraimpor.getcantidad_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_entra=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_entra.setValue(detallepedidocompraimpor.getcantidad_entra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_entra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_pendiente=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_pendiente.setValue(detallepedidocompraimpor.getcantidad_pendiente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_pendiente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(detallepedidocompraimpor.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuepeso=new ParameterValue<Double>();
					parameterMaintenanceValuepeso.setValue(detallepedidocompraimpor.getpeso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepeso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(detallepedidocompraimpor.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote=new ParameterValue<String>();
					parameterMaintenanceValuelote.setValue(detallepedidocompraimpor.getlote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_arancel=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_arancel.setValue(detallepedidocompraimpor.getporcentaje_arancel());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_arancel);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_unidad_auxiliar=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_unidad_auxiliar.setValue(detallepedidocompraimpor.getcantidad_unidad_auxiliar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_unidad_auxiliar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio_unidad_auxiliar=new ParameterValue<Double>();
					parameterMaintenanceValueprecio_unidad_auxiliar.setValue(detallepedidocompraimpor.getprecio_unidad_auxiliar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio_unidad_auxiliar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefob=new ParameterValue<Double>();
					parameterMaintenanceValuefob.setValue(detallepedidocompraimpor.getfob());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefob);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefob_exw=new ParameterValue<Double>();
					parameterMaintenanceValuefob_exw.setValue(detallepedidocompraimpor.getfob_exw());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefob_exw);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(detallepedidocompraimpor.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detallepedidocompraimpor.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(detallepedidocompraimpor.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detallepedidocompraimpor.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detallepedidocompraimpor.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallepedidocompraimpor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallepedidocompraimpor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallepedidocompraimpor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallepedidocompraimpor.getId());
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
	
	public void setIsNewIsChangedFalseDetallePedidoCompraImpor(DetallePedidoCompraImpor detallepedidocompraimpor)throws Exception  {		
		detallepedidocompraimpor.setIsNew(false);
		detallepedidocompraimpor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetallePedidoCompraImpors(List<DetallePedidoCompraImpor> detallepedidocompraimpors)throws Exception  {				
		for(DetallePedidoCompraImpor detallepedidocompraimpor:detallepedidocompraimpors) {
			detallepedidocompraimpor.setIsNew(false);
			detallepedidocompraimpor.setIsChanged(false);
		}
	}
	
	public void generarExportarDetallePedidoCompraImpor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
