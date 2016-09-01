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
import com.bydan.erp.facturacion.util.*;//PedidoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class PedidoDataAccess extends  PedidoDataAccessAdditional{ //PedidoDataAccessAdditional,DataAccessHelper<Pedido>
	//static Logger logger = Logger.getLogger(PedidoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="pedido";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_usuario,numero,pre_impreso,fecha_emision,fecha_entrega,id_moneda,cotizacion,id_empleado,id_tipo_precio,id_formato,direccion,id_cliente,telefono,ruc,id_sub_cliente,id_vendedor,id_consultor,orden,id_responsable,id_estado_pedido,id_transporte,id_ruta_transporte,valor_ruta,id_tipo_llamada,id_transportista,hora_inicio,hora_fin,descripcion,cupo,saldo,pedidos,documentos,disponible,descuento_porcentaje,total_con_iva,suman,descuento_valor,total_sin_iva,descuento_total,flete,total,subtotal,otro,ultimo_costo,iva,financiamiento,margen_utilidad,otros_valores,anticipo,id_tipo_cambio,id_centro_costo,id_zona,fecha,numero_fue,fecha_servidor,monto_retencion,ice)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,numero=?,pre_impreso=?,fecha_emision=?,fecha_entrega=?,id_moneda=?,cotizacion=?,id_empleado=?,id_tipo_precio=?,id_formato=?,direccion=?,id_cliente=?,telefono=?,ruc=?,id_sub_cliente=?,id_vendedor=?,id_consultor=?,orden=?,id_responsable=?,id_estado_pedido=?,id_transporte=?,id_ruta_transporte=?,valor_ruta=?,id_tipo_llamada=?,id_transportista=?,hora_inicio=?,hora_fin=?,descripcion=?,cupo=?,saldo=?,pedidos=?,documentos=?,disponible=?,descuento_porcentaje=?,total_con_iva=?,suman=?,descuento_valor=?,total_sin_iva=?,descuento_total=?,flete=?,total=?,subtotal=?,otro=?,ultimo_costo=?,iva=?,financiamiento=?,margen_utilidad=?,otros_valores=?,anticipo=?,id_tipo_cambio=?,id_centro_costo=?,id_zona=?,fecha=?,numero_fue=?,fecha_servidor=?,monto_retencion=?,ice=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select pedido from "+PedidoConstantesFunciones.SPERSISTENCENAME+" pedido";
	public static String QUERYSELECTNATIVE="select "+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".version_row,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_empresa,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_ejercicio,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_periodo,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_anio,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_mes,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_usuario,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".numero,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".pre_impreso,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".fecha_emision,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".fecha_entrega,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_moneda,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".cotizacion,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_empleado,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_tipo_precio,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_formato,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".direccion,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_cliente,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".telefono,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".ruc,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_sub_cliente,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_vendedor,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_consultor,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".orden,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_responsable,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_estado_pedido,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_transporte,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_ruta_transporte,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".valor_ruta,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_tipo_llamada,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_transportista,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".hora_inicio,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".hora_fin,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".descripcion,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".cupo,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".saldo,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".pedidos,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".documentos,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".disponible,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".descuento_porcentaje,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".total_con_iva,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".suman,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".descuento_valor,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".total_sin_iva,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".descuento_total,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".flete,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".total,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".subtotal,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".otro,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".ultimo_costo,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".iva,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".financiamiento,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".margen_utilidad,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".otros_valores,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".anticipo,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_tipo_cambio,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_centro_costo,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id_zona,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".fecha,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".numero_fue,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".fecha_servidor,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".monto_retencion,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".ice from "+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME;//+" as "+PedidoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".id,"+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+".version_row from "+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME;//+" as "+PedidoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PedidoConstantesFunciones.SCHEMA+"."+PedidoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,numero=?,pre_impreso=?,fecha_emision=?,fecha_entrega=?,id_moneda=?,cotizacion=?,id_empleado=?,id_tipo_precio=?,id_formato=?,direccion=?,id_cliente=?,telefono=?,ruc=?,id_sub_cliente=?,id_vendedor=?,id_consultor=?,orden=?,id_responsable=?,id_estado_pedido=?,id_transporte=?,id_ruta_transporte=?,valor_ruta=?,id_tipo_llamada=?,id_transportista=?,hora_inicio=?,hora_fin=?,descripcion=?,cupo=?,saldo=?,pedidos=?,documentos=?,disponible=?,descuento_porcentaje=?,total_con_iva=?,suman=?,descuento_valor=?,total_sin_iva=?,descuento_total=?,flete=?,total=?,subtotal=?,otro=?,ultimo_costo=?,iva=?,financiamiento=?,margen_utilidad=?,otros_valores=?,anticipo=?,id_tipo_cambio=?,id_centro_costo=?,id_zona=?,fecha=?,numero_fue=?,fecha_servidor=?,monto_retencion=?,ice=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PEDIDO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PEDIDO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PEDIDO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PEDIDO_SELECT(?,?)";
	
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
	
	
	protected PedidoDataAccessAdditional pedidoDataAccessAdditional=null;
	
	public PedidoDataAccessAdditional getPedidoDataAccessAdditional() {
		return this.pedidoDataAccessAdditional;
	}
	
	public void setPedidoDataAccessAdditional(PedidoDataAccessAdditional pedidoDataAccessAdditional) {
		try {
			this.pedidoDataAccessAdditional=pedidoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PedidoDataAccess() {
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
		PedidoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PedidoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PedidoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPedidoOriginal(Pedido pedido)throws Exception  {
		pedido.setPedidoOriginal((Pedido)pedido.clone());		
	}
	
	public void setPedidosOriginal(List<Pedido> pedidos)throws Exception  {
		
		for(Pedido pedido:pedidos){
			pedido.setPedidoOriginal((Pedido)pedido.clone());
		}
	}
	
	public static void setPedidoOriginalStatic(Pedido pedido)throws Exception  {
		pedido.setPedidoOriginal((Pedido)pedido.clone());		
	}
	
	public static void setPedidosOriginalStatic(List<Pedido> pedidos)throws Exception  {
		
		for(Pedido pedido:pedidos){
			pedido.setPedidoOriginal((Pedido)pedido.clone());
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
	
	public  Pedido getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Pedido entity = new Pedido();		
		
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
	
	public  Pedido getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Pedido entity = new Pedido();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.Pedido.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPedidoOriginal(new Pedido());
      	    	entity=super.getEntity("",entity,resultSet,PedidoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedido("",entity,resultSet); 
				
				//entity.setPedidoOriginal(super.getEntity("",entity.getPedidoOriginal(),resultSet,PedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoOriginal(this.getEntityPedido("",entity.getPedidoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePedido(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Pedido getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Pedido entity = new Pedido();
				
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
	
	public  Pedido getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Pedido entity = new Pedido();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.Pedido.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPedidoOriginal(new Pedido());
      	    	entity=super.getEntity("",entity,resultSet,PedidoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedido("",entity,resultSet);    
				
				//entity.setPedidoOriginal(super.getEntity("",entity.getPedidoOriginal(),resultSet,PedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoOriginal(this.getEntityPedido("",entity.getPedidoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePedido(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Pedido
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Pedido entity = new Pedido();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.Pedido.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePedido(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Pedido> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Pedido> entities = new  ArrayList<Pedido>();
		Pedido entity = new Pedido();		  
		
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
	
	public  List<Pedido> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Pedido> entities = new  ArrayList<Pedido>();
		Pedido entity = new Pedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Pedido();
      	    	entity=super.getEntity("",entity,resultSet,PedidoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedido("",entity,resultSet);
      	    	
				//entity.setPedidoOriginal( new Pedido());
      	    	//entity.setPedidoOriginal(super.getEntity("",entity.getPedidoOriginal(),resultSet,PedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoOriginal(this.getEntityPedido("",entity.getPedidoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedido(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Pedido> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Pedido> entities = new  ArrayList<Pedido>();
		Pedido entity = new Pedido();		  
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
	
	public  List<Pedido> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Pedido> entities = new  ArrayList<Pedido>();
		Pedido entity = new Pedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Pedido();
				
				if(conMapGenerico) {
					entity.inicializarMapPedido();
					//entity.setMapPedido(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPedidoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedido().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoDataAccess.ISWITHSCHEMA);         		
					entity=PedidoDataAccess.getEntityPedido("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoOriginal( new Pedido());
					////entity.setPedidoOriginal(super.getEntity("",entity.getPedidoOriginal(),resultSet,PedidoDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoOriginal(this.getEntityPedido("",entity.getPedidoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Pedido getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Pedido entity = new Pedido();		  
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
	
	public  Pedido getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Pedido entity = new Pedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Pedido();
				
				if(conMapGenerico) {
					entity.inicializarMapPedido();
					//entity.setMapPedido(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPedidoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedido().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoDataAccess.ISWITHSCHEMA);         		
					entity=PedidoDataAccess.getEntityPedido("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoOriginal( new Pedido());
					////entity.setPedidoOriginal(super.getEntity("",entity.getPedidoOriginal(),resultSet,PedidoDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoOriginal(this.getEntityPedido("",entity.getPedidoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePedido(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Pedido getEntityPedido(String strPrefijo,Pedido entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Pedido.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Pedido.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PedidoDataAccess.setFieldReflectionPedido(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPedido=PedidoConstantesFunciones.getTodosTiposColumnasPedido();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPedido) {
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
							field = Pedido.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Pedido.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PedidoDataAccess.setFieldReflectionPedido(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPedido(Field field,String strPrefijo,String sColumn,Pedido entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PedidoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoConstantesFunciones.PREIMPRESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.COTIZACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDSUBCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDCONSULTOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.ORDEN:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDRESPONSABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDESTADOPEDIDO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDTRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDRUTATRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.VALORRUTA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDTIPOLLAMADA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDTRANSPORTISTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.HORAINICIO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case PedidoConstantesFunciones.HORAFIN:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case PedidoConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoConstantesFunciones.CUPO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.SALDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.PEDIDOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.DOCUMENTOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.DISPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.DESCUENTOPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.TOTALCONIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.SUMAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.DESCUENTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.DESCUENTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.OTRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.ULTIMOCOSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.MARGENUTILIDAD:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.OTROSVALORES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.ANTICIPO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.IDZONA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoConstantesFunciones.NUMEROFUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoConstantesFunciones.FECHASERVIDOR:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoConstantesFunciones.MONTORETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoConstantesFunciones.ICE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Pedido>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Pedido> entities = new  ArrayList<Pedido>();
		Pedido entity = new Pedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Pedido();
					entity=super.getEntity("",entity,resultSet,PedidoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPedido("",entity,resultSet);
					
					//entity.setPedidoOriginal( new Pedido());
					//entity.setPedidoOriginal(super.getEntity("",entity.getPedidoOriginal(),resultSet,PedidoDataAccess.ISWITHSCHEMA));         		
					//entity.setPedidoOriginal(this.getEntityPedido("",entity.getPedidoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePedidos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedido(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Pedido>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Pedido> entities = new  ArrayList<Pedido>();
		Pedido entity = new Pedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Pedido> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Pedido> entities = new  ArrayList<Pedido>();
		Pedido entity = new Pedido();		  
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
	
	public  List<Pedido> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Pedido> entities = new  ArrayList<Pedido>();
		Pedido entity = new Pedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Pedido();
      	    	entity=super.getEntity("",entity,resultSet,PedidoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedido("",entity,resultSet);
      	    	
				//entity.setPedidoOriginal( new Pedido());
      	    	//entity.setPedidoOriginal(super.getEntity("",entity.getPedidoOriginal(),resultSet,PedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoOriginal(this.getEntityPedido("",entity.getPedidoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePedidos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Pedido> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Pedido> entities = new  ArrayList<Pedido>();
		Pedido entity = new Pedido();		  
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
	
	public  List<Pedido> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Pedido> entities = new  ArrayList<Pedido>();
		Pedido entity = new Pedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Pedido();
      	    	entity=super.getEntity("",entity,resultSet,PedidoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedido("",entity,resultSet);
      	    	
				//entity.setPedidoOriginal( new Pedido());
      	    	//entity.setPedidoOriginal(super.getEntity("",entity.getPedidoOriginal(),resultSet,PedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoOriginal(this.getEntityPedido("",entity.getPedidoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Pedido getEntityPedido(String strPrefijo,Pedido entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_usuario(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDUSUARIO));
				entity.setnumero(resultSet.getString(strPrefijo+PedidoConstantesFunciones.NUMERO));
				entity.setpre_impreso(resultSet.getString(strPrefijo+PedidoConstantesFunciones.PREIMPRESO));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+PedidoConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+PedidoConstantesFunciones.FECHAENTREGA).getTime()));
				entity.setid_moneda(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDMONEDA));
				entity.setcotizacion(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.COTIZACION));
				entity.setid_empleado(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDEMPLEADO));
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDTIPOPRECIO));
				entity.setid_formato(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDFORMATO));if(resultSet.wasNull()) {entity.setid_formato(null); }
				entity.setdireccion(resultSet.getString(strPrefijo+PedidoConstantesFunciones.DIRECCION));
				entity.setid_cliente(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDCLIENTE));
				entity.settelefono(resultSet.getString(strPrefijo+PedidoConstantesFunciones.TELEFONO));
				entity.setruc(resultSet.getString(strPrefijo+PedidoConstantesFunciones.RUC));
				entity.setid_sub_cliente(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDSUBCLIENTE));if(resultSet.wasNull()) {entity.setid_sub_cliente(null); }
				entity.setid_vendedor(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDVENDEDOR));if(resultSet.wasNull()) {entity.setid_vendedor(null); }
				entity.setid_consultor(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDCONSULTOR));if(resultSet.wasNull()) {entity.setid_consultor(null); }
				entity.setorden(resultSet.getString(strPrefijo+PedidoConstantesFunciones.ORDEN));
				entity.setid_responsable(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDRESPONSABLE));if(resultSet.wasNull()) {entity.setid_responsable(null); }
				entity.setid_estado_pedido(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDESTADOPEDIDO));
				entity.setid_transporte(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDTRANSPORTE));if(resultSet.wasNull()) {entity.setid_transporte(null); }
				entity.setid_ruta_transporte(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDRUTATRANSPORTE));if(resultSet.wasNull()) {entity.setid_ruta_transporte(null); }
				entity.setvalor_ruta(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.VALORRUTA));
				entity.setid_tipo_llamada(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDTIPOLLAMADA));if(resultSet.wasNull()) {entity.setid_tipo_llamada(null); }
				entity.setid_transportista(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDTRANSPORTISTA));if(resultSet.wasNull()) {entity.setid_transportista(null); }
				entity.sethora_inicio(resultSet.getTime(strPrefijo+PedidoConstantesFunciones.HORAINICIO));
				entity.sethora_fin(resultSet.getTime(strPrefijo+PedidoConstantesFunciones.HORAFIN));
				entity.setdescripcion(resultSet.getString(strPrefijo+PedidoConstantesFunciones.DESCRIPCION));
				entity.setcupo(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.CUPO));
				entity.setsaldo(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.SALDO));
				entity.setpedidos(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.PEDIDOS));
				entity.setdocumentos(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.DOCUMENTOS));
				entity.setdisponible(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.DISPONIBLE));
				entity.setdescuento_porcentaje(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.DESCUENTOPORCENTAJE));
				entity.settotal_con_iva(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.TOTALCONIVA));
				entity.setsuman(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.SUMAN));
				entity.setdescuento_valor(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.DESCUENTOVALOR));
				entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.TOTALSINIVA));
				entity.setdescuento_total(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.DESCUENTOTOTAL));
				entity.setflete(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.FLETE));
				entity.settotal(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.TOTAL));
				entity.setsubtotal(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.SUBTOTAL));
				entity.setotro(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.OTRO));
				entity.setultimo_costo(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.ULTIMOCOSTO));
				entity.setiva(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.IVA));
				entity.setfinanciamiento(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.FINANCIAMIENTO));
				entity.setmargen_utilidad(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.MARGENUTILIDAD));
				entity.setotros_valores(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.OTROSVALORES));
				entity.setanticipo(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.ANTICIPO));
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_zona(resultSet.getLong(strPrefijo+PedidoConstantesFunciones.IDZONA));if(resultSet.wasNull()) {entity.setid_zona(null); }
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PedidoConstantesFunciones.FECHA).getTime()));
				entity.setnumero_fue(resultSet.getString(strPrefijo+PedidoConstantesFunciones.NUMEROFUE));
				entity.setfecha_servidor(new Date(resultSet.getDate(strPrefijo+PedidoConstantesFunciones.FECHASERVIDOR).getTime()));
				entity.setmonto_retencion(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.MONTORETENCION));
				entity.setice(resultSet.getDouble(strPrefijo+PedidoConstantesFunciones.ICE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPedido(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Pedido entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PedidoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PedidoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PedidoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PedidoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PedidoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PedidoDataAccess.TABLENAME,PedidoDataAccess.ISWITHSTOREPROCEDURES);
			
			PedidoDataAccess.setPedidoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpedido.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpedido.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpedido.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relpedido.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relpedido.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relpedido.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Usuario getUsuario(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relpedido.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Moneda getMoneda(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relpedido.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Empleado getEmpleado(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relpedido.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relpedido.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public Formato getFormato(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relpedido.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Cliente getCliente(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relpedido.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public SubCliente getSubCliente(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		SubCliente subcliente= new SubCliente();

		try {
			SubClienteDataAccess subclienteDataAccess=new SubClienteDataAccess();

			subclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			subclienteDataAccess.setConnexionType(this.connexionType);
			subclienteDataAccess.setParameterDbType(this.parameterDbType);

			subcliente=subclienteDataAccess.getEntity(connexion,relpedido.getid_sub_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subcliente;

	}

	public Vendedor getVendedor(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relpedido.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Consultor getConsultor(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Consultor consultor= new Consultor();

		try {
			ConsultorDataAccess consultorDataAccess=new ConsultorDataAccess();

			consultorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			consultorDataAccess.setConnexionType(this.connexionType);
			consultorDataAccess.setParameterDbType(this.parameterDbType);

			consultor=consultorDataAccess.getEntity(connexion,relpedido.getid_consultor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consultor;

	}

	public Responsable getResponsable(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Responsable responsable= new Responsable();

		try {
			ResponsableDataAccess responsableDataAccess=new ResponsableDataAccess();

			responsableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			responsableDataAccess.setConnexionType(this.connexionType);
			responsableDataAccess.setParameterDbType(this.parameterDbType);

			responsable=responsableDataAccess.getEntity(connexion,relpedido.getid_responsable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return responsable;

	}

	public EstadoPedido getEstadoPedido(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		EstadoPedido estadopedido= new EstadoPedido();

		try {
			EstadoPedidoDataAccess estadopedidoDataAccess=new EstadoPedidoDataAccess();

			//estadopedidoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadopedidoDataAccess.setConnexionType(this.connexionType);
			estadopedidoDataAccess.setParameterDbType(this.parameterDbType);

			estadopedido=estadopedidoDataAccess.getEntity(connexion,relpedido.getid_estado_pedido());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopedido;

	}

	public Transporte getTransporte(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Transporte transporte= new Transporte();

		try {
			TransporteDataAccess transporteDataAccess=new TransporteDataAccess();

			transporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transporteDataAccess.setConnexionType(this.connexionType);
			transporteDataAccess.setParameterDbType(this.parameterDbType);

			transporte=transporteDataAccess.getEntity(connexion,relpedido.getid_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transporte;

	}

	public RutaTransporte getRutaTransporte(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		RutaTransporte rutatransporte= new RutaTransporte();

		try {
			RutaTransporteDataAccess rutatransporteDataAccess=new RutaTransporteDataAccess();

			rutatransporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rutatransporteDataAccess.setConnexionType(this.connexionType);
			rutatransporteDataAccess.setParameterDbType(this.parameterDbType);

			rutatransporte=rutatransporteDataAccess.getEntity(connexion,relpedido.getid_ruta_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rutatransporte;

	}

	public TipoLlamada getTipoLlamada(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		TipoLlamada tipollamada= new TipoLlamada();

		try {
			TipoLlamadaDataAccess tipollamadaDataAccess=new TipoLlamadaDataAccess();

			tipollamadaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipollamadaDataAccess.setConnexionType(this.connexionType);
			tipollamadaDataAccess.setParameterDbType(this.parameterDbType);

			tipollamada=tipollamadaDataAccess.getEntity(connexion,relpedido.getid_tipo_llamada());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipollamada;

	}

	public Transportista getTransportista(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Transportista transportista= new Transportista();

		try {
			TransportistaDataAccess transportistaDataAccess=new TransportistaDataAccess();

			transportistaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transportistaDataAccess.setConnexionType(this.connexionType);
			transportistaDataAccess.setParameterDbType(this.parameterDbType);

			transportista=transportistaDataAccess.getEntity(connexion,relpedido.getid_transportista());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportista;

	}

	public TipoCambio getTipoCambio(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relpedido.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}

	public CentroCosto getCentroCosto(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relpedido.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public Zona getZona(Connexion connexion,Pedido relpedido)throws SQLException,Exception {

		Zona zona= new Zona();

		try {
			ZonaDataAccess zonaDataAccess=new ZonaDataAccess();

			zonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			zonaDataAccess.setConnexionType(this.connexionType);
			zonaDataAccess.setParameterDbType(this.parameterDbType);

			zona=zonaDataAccess.getEntity(connexion,relpedido.getid_zona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return zona;

	}


		
		public List<Contenedor> getContenedors(Connexion connexion,Pedido pedido)throws SQLException,Exception {

		List<Contenedor> contenedors= new ArrayList<Contenedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PedidoConstantesFunciones.SCHEMA+".pedido ON "+ContenedorConstantesFunciones.SCHEMA+".contenedor.id_pedido="+PedidoConstantesFunciones.SCHEMA+".pedido.id WHERE "+PedidoConstantesFunciones.SCHEMA+".pedido.id="+String.valueOf(pedido.getId());
			} else {
				sQuery=" INNER JOIN contenedor.Pedido WHERE contenedor.Pedido.id="+String.valueOf(pedido.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ContenedorDataAccess contenedorDataAccess=new ContenedorDataAccess();

			contenedorDataAccess.setConnexionType(this.connexionType);
			contenedorDataAccess.setParameterDbType(this.parameterDbType);
			contenedors=contenedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return contenedors;

	}

	public List<Factura> getFacturas(Connexion connexion,Pedido pedido)throws SQLException,Exception {

		List<Factura> facturas= new ArrayList<Factura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PedidoConstantesFunciones.SCHEMA+".pedido ON "+FacturaConstantesFunciones.SCHEMA+".factura.id_pedido="+PedidoConstantesFunciones.SCHEMA+".pedido.id WHERE "+PedidoConstantesFunciones.SCHEMA+".pedido.id="+String.valueOf(pedido.getId());
			} else {
				sQuery=" INNER JOIN factura.Pedido WHERE factura.Pedido.id="+String.valueOf(pedido.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);
			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturas;

	}

	public List<DetallePedido> getDetallePedidos(Connexion connexion,Pedido pedido)throws SQLException,Exception {

		List<DetallePedido> detallepedidos= new ArrayList<DetallePedido>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PedidoConstantesFunciones.SCHEMA+".pedido ON "+DetallePedidoConstantesFunciones.SCHEMA+".detalle_pedido.id_pedido="+PedidoConstantesFunciones.SCHEMA+".pedido.id WHERE "+PedidoConstantesFunciones.SCHEMA+".pedido.id="+String.valueOf(pedido.getId());
			} else {
				sQuery=" INNER JOIN detallepedido.Pedido WHERE detallepedido.Pedido.id="+String.valueOf(pedido.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetallePedidoDataAccess detallepedidoDataAccess=new DetallePedidoDataAccess();

			detallepedidoDataAccess.setConnexionType(this.connexionType);
			detallepedidoDataAccess.setParameterDbType(this.parameterDbType);
			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallepedidos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Pedido pedido) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!pedido.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(pedido.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(pedido.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(pedido.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(pedido.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(pedido.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(pedido.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(pedido.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero=new ParameterValue<String>();
					parameterMaintenanceValuenumero.setValue(pedido.getnumero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepre_impreso=new ParameterValue<String>();
					parameterMaintenanceValuepre_impreso.setValue(pedido.getpre_impreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepre_impreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(pedido.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega.setValue(pedido.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(pedido.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecotizacion=new ParameterValue<Double>();
					parameterMaintenanceValuecotizacion.setValue(pedido.getcotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(pedido.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(pedido.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(pedido.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(pedido.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(pedido.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(pedido.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(pedido.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sub_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_sub_cliente.setValue(pedido.getid_sub_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sub_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(pedido.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_consultor=new ParameterValue<Long>();
					parameterMaintenanceValueid_consultor.setValue(pedido.getid_consultor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_consultor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueorden=new ParameterValue<String>();
					parameterMaintenanceValueorden.setValue(pedido.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_responsable=new ParameterValue<Long>();
					parameterMaintenanceValueid_responsable.setValue(pedido.getid_responsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_responsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_pedido=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_pedido.setValue(pedido.getid_estado_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_transporte.setValue(pedido.getid_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ruta_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_ruta_transporte.setValue(pedido.getid_ruta_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ruta_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_ruta=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_ruta.setValue(pedido.getvalor_ruta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_ruta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_llamada=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_llamada.setValue(pedido.getid_tipo_llamada());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_llamada);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transportista=new ParameterValue<Long>();
					parameterMaintenanceValueid_transportista.setValue(pedido.getid_transportista());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transportista);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_inicio=new ParameterValue<Time>();
					parameterMaintenanceValuehora_inicio.setValue(pedido.gethora_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_fin=new ParameterValue<Time>();
					parameterMaintenanceValuehora_fin.setValue(pedido.gethora_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(pedido.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecupo=new ParameterValue<Double>();
					parameterMaintenanceValuecupo.setValue(pedido.getcupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesaldo=new ParameterValue<Double>();
					parameterMaintenanceValuesaldo.setValue(pedido.getsaldo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesaldo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuepedidos=new ParameterValue<Double>();
					parameterMaintenanceValuepedidos.setValue(pedido.getpedidos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepedidos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedocumentos=new ParameterValue<Double>();
					parameterMaintenanceValuedocumentos.setValue(pedido.getdocumentos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedocumentos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedisponible=new ParameterValue<Double>();
					parameterMaintenanceValuedisponible.setValue(pedido.getdisponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedisponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_porcentaje.setValue(pedido.getdescuento_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_con_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_con_iva.setValue(pedido.gettotal_con_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_con_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesuman=new ParameterValue<Double>();
					parameterMaintenanceValuesuman.setValue(pedido.getsuman());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesuman);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_valor=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_valor.setValue(pedido.getdescuento_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_sin_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_sin_iva.setValue(pedido.gettotal_sin_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_sin_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_total=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_total.setValue(pedido.getdescuento_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(pedido.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(pedido.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesubtotal=new ParameterValue<Double>();
					parameterMaintenanceValuesubtotal.setValue(pedido.getsubtotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesubtotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotro=new ParameterValue<Double>();
					parameterMaintenanceValueotro.setValue(pedido.getotro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueultimo_costo=new ParameterValue<Double>();
					parameterMaintenanceValueultimo_costo.setValue(pedido.getultimo_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueultimo_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(pedido.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefinanciamiento=new ParameterValue<Double>();
					parameterMaintenanceValuefinanciamiento.setValue(pedido.getfinanciamiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefinanciamiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemargen_utilidad=new ParameterValue<Double>();
					parameterMaintenanceValuemargen_utilidad.setValue(pedido.getmargen_utilidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemargen_utilidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotros_valores=new ParameterValue<Double>();
					parameterMaintenanceValueotros_valores.setValue(pedido.getotros_valores());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotros_valores);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueanticipo=new ParameterValue<Double>();
					parameterMaintenanceValueanticipo.setValue(pedido.getanticipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanticipo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(pedido.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(pedido.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_zona=new ParameterValue<Long>();
					parameterMaintenanceValueid_zona.setValue(pedido.getid_zona());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_zona);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(pedido.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_fue=new ParameterValue<String>();
					parameterMaintenanceValuenumero_fue.setValue(pedido.getnumero_fue());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_fue);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_servidor=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_servidor.setValue(pedido.getfecha_servidor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_servidor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_retencion=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_retencion.setValue(pedido.getmonto_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(pedido.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
						if(!pedido.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(pedido.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(pedido.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(pedido.getId());
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
	
	public void setIsNewIsChangedFalsePedido(Pedido pedido)throws Exception  {		
		pedido.setIsNew(false);
		pedido.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePedidos(List<Pedido> pedidos)throws Exception  {				
		for(Pedido pedido:pedidos) {
			pedido.setIsNew(false);
			pedido.setIsChanged(false);
		}
	}
	
	public void generarExportarPedido(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
