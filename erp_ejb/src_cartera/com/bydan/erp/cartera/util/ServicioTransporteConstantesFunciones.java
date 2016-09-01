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
package com.bydan.erp.cartera.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.cartera.util.ServicioTransporteConstantesFunciones;
import com.bydan.erp.cartera.util.ServicioTransporteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ServicioTransporteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ServicioTransporteConstantesFunciones extends ServicioTransporteConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="ServicioTransporte";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ServicioTransporte"+ServicioTransporteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ServicioTransporteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ServicioTransporteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ServicioTransporteConstantesFunciones.SCHEMA+"_"+ServicioTransporteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ServicioTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ServicioTransporteConstantesFunciones.SCHEMA+"_"+ServicioTransporteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ServicioTransporteConstantesFunciones.SCHEMA+"_"+ServicioTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ServicioTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ServicioTransporteConstantesFunciones.SCHEMA+"_"+ServicioTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ServicioTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ServicioTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ServicioTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ServicioTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ServicioTransporteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ServicioTransporteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ServicioTransporteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ServicioTransporteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ServicioTransporteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ServicioTransporteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Servicio Transportes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Servicio Transporte";
	public static final String SCLASSWEBTITULO_LOWER="Servicio Transporte";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ServicioTransporte";
	public static final String OBJECTNAME="serviciotransporte";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="servicio_transporte";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select serviciotransporte from "+ServicioTransporteConstantesFunciones.SPERSISTENCENAME+" serviciotransporte";
	public static String QUERYSELECTNATIVE="select "+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".version_row,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_empresa,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_sucursal,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_ejercicio,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_periodo,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_cliente,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_cliente_proveedor,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_transportista,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_vehiculo,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_ruta_transporte,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".fecha_ingreso,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".fecha_entrega,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".codigo_guia1,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".codigo_guia2,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".precio,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".valor_iva,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".valor_total,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".descripcion from "+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME;//+" as "+ServicioTransporteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ServicioTransporteConstantesFuncionesAdditional serviciotransporteConstantesFuncionesAdditional=null;
	
	public ServicioTransporteConstantesFuncionesAdditional getServicioTransporteConstantesFuncionesAdditional() {
		return this.serviciotransporteConstantesFuncionesAdditional;
	}
	
	public void setServicioTransporteConstantesFuncionesAdditional(ServicioTransporteConstantesFuncionesAdditional serviciotransporteConstantesFuncionesAdditional) {
		try {
			this.serviciotransporteConstantesFuncionesAdditional=serviciotransporteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDCLIENTEPROVEEDOR= "id_cliente_proveedor";
    public static final String IDTRANSPORTISTA= "id_transportista";
    public static final String IDVEHICULO= "id_vehiculo";
    public static final String IDRUTATRANSPORTE= "id_ruta_transporte";
    public static final String IDDETALLEACTIVOFIJO= "id_detalle_activo_fijo";
    public static final String FECHAINGRESO= "fecha_ingreso";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String CODIGOGUIA1= "codigo_guia1";
    public static final String CODIGOGUIA2= "codigo_guia2";
    public static final String PRECIO= "precio";
    public static final String VALORIVA= "valor_iva";
    public static final String VALORTOTAL= "valor_total";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDCLIENTEPROVEEDOR= "Cliente Proveedor";
		public static final String LABEL_IDCLIENTEPROVEEDOR_LOWER= "Cliente Proveedor";
    	public static final String LABEL_IDTRANSPORTISTA= "Transportista";
		public static final String LABEL_IDTRANSPORTISTA_LOWER= "Transportista";
    	public static final String LABEL_IDVEHICULO= "Vehiculo";
		public static final String LABEL_IDVEHICULO_LOWER= "Vehiculo";
    	public static final String LABEL_IDRUTATRANSPORTE= "Ruta Transporte";
		public static final String LABEL_IDRUTATRANSPORTE_LOWER= "Ruta Transporte";
    	public static final String LABEL_IDDETALLEACTIVOFIJO= "Detalle Activo Fijo";
		public static final String LABEL_IDDETALLEACTIVOFIJO_LOWER= "Detalle Activo Fijo";
    	public static final String LABEL_FECHAINGRESO= "Fecha Ingreso";
		public static final String LABEL_FECHAINGRESO_LOWER= "Fecha Ingreso";
    	public static final String LABEL_FECHAENTREGA= "Fecha Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "Fecha Entrega";
    	public static final String LABEL_CODIGOGUIA1= "Codigo Guia1";
		public static final String LABEL_CODIGOGUIA1_LOWER= "Codigo Guia1";
    	public static final String LABEL_CODIGOGUIA2= "Codigo Guia2";
		public static final String LABEL_CODIGOGUIA2_LOWER= "Codigo Guia2";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_VALORIVA= "Valor Iva";
		public static final String LABEL_VALORIVA_LOWER= "Valor Iva";
    	public static final String LABEL_VALORTOTAL= "Valor Total";
		public static final String LABEL_VALORTOTAL_LOWER= "Valor Total";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO_GUIA1=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_GUIA1=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_GUIA2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_GUIA2=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getServicioTransporteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.IDEMPRESA)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.IDPERIODO)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.IDCLIENTE)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.IDCLIENTEPROVEEDOR)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.IDTRANSPORTISTA)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_IDTRANSPORTISTA;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.IDVEHICULO)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_IDVEHICULO;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.IDRUTATRANSPORTE)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_IDRUTATRANSPORTE;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.IDDETALLEACTIVOFIJO)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.FECHAINGRESO)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_FECHAINGRESO;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.FECHAENTREGA)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.CODIGOGUIA1)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_CODIGOGUIA1;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.CODIGOGUIA2)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_CODIGOGUIA2;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.PRECIO)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.VALORIVA)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_VALORIVA;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.VALORTOTAL)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_VALORTOTAL;}
		if(sNombreColumna.equals(ServicioTransporteConstantesFunciones.DESCRIPCION)) {sLabelColumna=ServicioTransporteConstantesFunciones.LABEL_DESCRIPCION;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getServicioTransporteDescripcion(ServicioTransporte serviciotransporte) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(serviciotransporte !=null/* && serviciotransporte.getId()!=0*/) {
			if(serviciotransporte.getId()!=null) {
				sDescripcion=serviciotransporte.getId().toString();
			}//serviciotransporteserviciotransporte.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getServicioTransporteDescripcionDetallado(ServicioTransporte serviciotransporte) {
		String sDescripcion="";
			
		sDescripcion+=ServicioTransporteConstantesFunciones.ID+"=";
		sDescripcion+=serviciotransporte.getId().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=serviciotransporte.getVersionRow().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=serviciotransporte.getid_empresa().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=serviciotransporte.getid_sucursal().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=serviciotransporte.getid_ejercicio().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=serviciotransporte.getid_periodo().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=serviciotransporte.getid_cliente().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.IDCLIENTEPROVEEDOR+"=";
		sDescripcion+=serviciotransporte.getid_cliente_proveedor().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.IDTRANSPORTISTA+"=";
		sDescripcion+=serviciotransporte.getid_transportista().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.IDVEHICULO+"=";
		sDescripcion+=serviciotransporte.getid_vehiculo().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.IDRUTATRANSPORTE+"=";
		sDescripcion+=serviciotransporte.getid_ruta_transporte().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.IDDETALLEACTIVOFIJO+"=";
		sDescripcion+=serviciotransporte.getid_detalle_activo_fijo().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.FECHAINGRESO+"=";
		sDescripcion+=serviciotransporte.getfecha_ingreso().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=serviciotransporte.getfecha_entrega().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.CODIGOGUIA1+"=";
		sDescripcion+=serviciotransporte.getcodigo_guia1()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.CODIGOGUIA2+"=";
		sDescripcion+=serviciotransporte.getcodigo_guia2()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.PRECIO+"=";
		sDescripcion+=serviciotransporte.getprecio().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.VALORIVA+"=";
		sDescripcion+=serviciotransporte.getvalor_iva().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.VALORTOTAL+"=";
		sDescripcion+=serviciotransporte.getvalor_total().toString()+",";
		sDescripcion+=ServicioTransporteConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=serviciotransporte.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setServicioTransporteDescripcion(ServicioTransporte serviciotransporte,String sValor) throws Exception {			
		if(serviciotransporte !=null) {
			//serviciotransporteserviciotransporte.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getClienteProveedorDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTransportistaDescripcion(Transportista transportista) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transportista!=null/*&&transportista.getId()>0*/) {
			sDescripcion=TransportistaConstantesFunciones.getTransportistaDescripcion(transportista);
		}

		return sDescripcion;
	}

	public static String getVehiculoDescripcion(Vehiculo vehiculo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vehiculo!=null/*&&vehiculo.getId()>0*/) {
			sDescripcion=VehiculoConstantesFunciones.getVehiculoDescripcion(vehiculo);
		}

		return sDescripcion;
	}

	public static String getRutaTransporteDescripcion(RutaTransporte rutatransporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(rutatransporte!=null/*&&rutatransporte.getId()>0*/) {
			sDescripcion=RutaTransporteConstantesFunciones.getRutaTransporteDescripcion(rutatransporte);
		}

		return sDescripcion;
	}

	public static String getDetalleActivoFijoDescripcion(DetalleActivoFijo detalleactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detalleactivofijo!=null/*&&detalleactivofijo.getId()>0*/) {
			sDescripcion=DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(detalleactivofijo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdClienteProveedor")) {
			sNombreIndice="Tipo=  Por Cliente Proveedor";
		} else if(sNombreIndice.equals("FK_IdDetalleActivoFijo")) {
			sNombreIndice="Tipo=  Por Detalle Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdRutaTransporte")) {
			sNombreIndice="Tipo=  Por Ruta Transporte";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTransportista")) {
			sNombreIndice="Tipo=  Por Transportista";
		} else if(sNombreIndice.equals("FK_IdVehiculo")) {
			sNombreIndice="Tipo=  Por Vehiculo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdClienteProveedor(Long id_cliente_proveedor) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente_proveedor!=null) {sDetalleIndice+=" Codigo Unico De Cliente Proveedor="+id_cliente_proveedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetalleActivoFijo(Long id_detalle_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Detalle Activo Fijo="+id_detalle_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRutaTransporte(Long id_ruta_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_ruta_transporte!=null) {sDetalleIndice+=" Codigo Unico De Ruta Transporte="+id_ruta_transporte.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransportista(Long id_transportista) {
		String sDetalleIndice=" Parametros->";
		if(id_transportista!=null) {sDetalleIndice+=" Codigo Unico De Transportista="+id_transportista.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVehiculo(Long id_vehiculo) {
		String sDetalleIndice=" Parametros->";
		if(id_vehiculo!=null) {sDetalleIndice+=" Codigo Unico De Vehiculo="+id_vehiculo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosServicioTransporte(ServicioTransporte serviciotransporte,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		serviciotransporte.setcodigo_guia1(serviciotransporte.getcodigo_guia1().trim());
		serviciotransporte.setcodigo_guia2(serviciotransporte.getcodigo_guia2().trim());
		serviciotransporte.setdescripcion(serviciotransporte.getdescripcion().trim());
	}
	
	public static void quitarEspaciosServicioTransportes(List<ServicioTransporte> serviciotransportes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ServicioTransporte serviciotransporte: serviciotransportes) {
			serviciotransporte.setcodigo_guia1(serviciotransporte.getcodigo_guia1().trim());
			serviciotransporte.setcodigo_guia2(serviciotransporte.getcodigo_guia2().trim());
			serviciotransporte.setdescripcion(serviciotransporte.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresServicioTransporte(ServicioTransporte serviciotransporte,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && serviciotransporte.getConCambioAuxiliar()) {
			serviciotransporte.setIsDeleted(serviciotransporte.getIsDeletedAuxiliar());	
			serviciotransporte.setIsNew(serviciotransporte.getIsNewAuxiliar());	
			serviciotransporte.setIsChanged(serviciotransporte.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			serviciotransporte.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			serviciotransporte.setIsDeletedAuxiliar(false);	
			serviciotransporte.setIsNewAuxiliar(false);	
			serviciotransporte.setIsChangedAuxiliar(false);
			
			serviciotransporte.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresServicioTransportes(List<ServicioTransporte> serviciotransportes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ServicioTransporte serviciotransporte : serviciotransportes) {
			if(conAsignarBase && serviciotransporte.getConCambioAuxiliar()) {
				serviciotransporte.setIsDeleted(serviciotransporte.getIsDeletedAuxiliar());	
				serviciotransporte.setIsNew(serviciotransporte.getIsNewAuxiliar());	
				serviciotransporte.setIsChanged(serviciotransporte.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				serviciotransporte.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				serviciotransporte.setIsDeletedAuxiliar(false);	
				serviciotransporte.setIsNewAuxiliar(false);	
				serviciotransporte.setIsChangedAuxiliar(false);
				
				serviciotransporte.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresServicioTransporte(ServicioTransporte serviciotransporte,Boolean conEnteros) throws Exception  {
		serviciotransporte.setprecio(0.0);
		serviciotransporte.setvalor_iva(0.0);
		serviciotransporte.setvalor_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresServicioTransportes(List<ServicioTransporte> serviciotransportes,Boolean conEnteros) throws Exception  {
		
		for(ServicioTransporte serviciotransporte: serviciotransportes) {
			serviciotransporte.setprecio(0.0);
			serviciotransporte.setvalor_iva(0.0);
			serviciotransporte.setvalor_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaServicioTransporte(List<ServicioTransporte> serviciotransportes,ServicioTransporte serviciotransporteAux) throws Exception  {
		ServicioTransporteConstantesFunciones.InicializarValoresServicioTransporte(serviciotransporteAux,true);
		
		for(ServicioTransporte serviciotransporte: serviciotransportes) {
			if(serviciotransporte.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			serviciotransporteAux.setprecio(serviciotransporteAux.getprecio()+serviciotransporte.getprecio());			
			serviciotransporteAux.setvalor_iva(serviciotransporteAux.getvalor_iva()+serviciotransporte.getvalor_iva());			
			serviciotransporteAux.setvalor_total(serviciotransporteAux.getvalor_total()+serviciotransporte.getvalor_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesServicioTransporte(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ServicioTransporteConstantesFunciones.getArrayColumnasGlobalesServicioTransporte(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesServicioTransporte(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ServicioTransporteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ServicioTransporteConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ServicioTransporteConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ServicioTransporteConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ServicioTransporteConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ServicioTransporteConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ServicioTransporteConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ServicioTransporteConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoServicioTransporte(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ServicioTransporte> serviciotransportes,ServicioTransporte serviciotransporte,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ServicioTransporte serviciotransporteAux: serviciotransportes) {
			if(serviciotransporteAux!=null && serviciotransporte!=null) {
				if((serviciotransporteAux.getId()==null && serviciotransporte.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(serviciotransporteAux.getId()!=null && serviciotransporte.getId()!=null){
					if(serviciotransporteAux.getId().equals(serviciotransporte.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaServicioTransporte(List<ServicioTransporte> serviciotransportes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double valor_ivaTotal=0.0;
		Double valor_totalTotal=0.0;
	
		for(ServicioTransporte serviciotransporte: serviciotransportes) {			
			if(serviciotransporte.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=serviciotransporte.getprecio();
			valor_ivaTotal+=serviciotransporte.getvalor_iva();
			valor_totalTotal+=serviciotransporte.getvalor_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ServicioTransporteConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ServicioTransporteConstantesFunciones.VALORIVA);
		datoGeneral.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_VALORIVA);
		datoGeneral.setdValorDouble(valor_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ServicioTransporteConstantesFunciones.VALORTOTAL);
		datoGeneral.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_VALORTOTAL);
		datoGeneral.setdValorDouble(valor_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaServicioTransporte() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_ID, ServicioTransporteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_VERSIONROW, ServicioTransporteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_IDEMPRESA, ServicioTransporteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_IDSUCURSAL, ServicioTransporteConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_IDEJERCICIO, ServicioTransporteConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_IDPERIODO, ServicioTransporteConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_IDCLIENTE, ServicioTransporteConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR, ServicioTransporteConstantesFunciones.IDCLIENTEPROVEEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_IDTRANSPORTISTA, ServicioTransporteConstantesFunciones.IDTRANSPORTISTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_IDVEHICULO, ServicioTransporteConstantesFunciones.IDVEHICULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_IDRUTATRANSPORTE, ServicioTransporteConstantesFunciones.IDRUTATRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO, ServicioTransporteConstantesFunciones.IDDETALLEACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_FECHAINGRESO, ServicioTransporteConstantesFunciones.FECHAINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_FECHAENTREGA, ServicioTransporteConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_CODIGOGUIA1, ServicioTransporteConstantesFunciones.CODIGOGUIA1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_CODIGOGUIA2, ServicioTransporteConstantesFunciones.CODIGOGUIA2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_PRECIO, ServicioTransporteConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_VALORIVA, ServicioTransporteConstantesFunciones.VALORIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_VALORTOTAL, ServicioTransporteConstantesFunciones.VALORTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioTransporteConstantesFunciones.LABEL_DESCRIPCION, ServicioTransporteConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasServicioTransporte() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.IDCLIENTEPROVEEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.IDTRANSPORTISTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.IDVEHICULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.IDRUTATRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.IDDETALLEACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.FECHAINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.CODIGOGUIA1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.CODIGOGUIA2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.VALORIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.VALORTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioTransporteConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarServicioTransporte() throws Exception  {
		return ServicioTransporteConstantesFunciones.getTiposSeleccionarServicioTransporte(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarServicioTransporte(Boolean conFk) throws Exception  {
		return ServicioTransporteConstantesFunciones.getTiposSeleccionarServicioTransporte(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarServicioTransporte(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_IDTRANSPORTISTA);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_IDTRANSPORTISTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_IDVEHICULO);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_IDVEHICULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_IDRUTATRANSPORTE);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_IDRUTATRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_FECHAINGRESO);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_FECHAINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_CODIGOGUIA1);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_CODIGOGUIA1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_CODIGOGUIA2);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_CODIGOGUIA2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_VALORIVA);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_VALORIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_VALORTOTAL);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_VALORTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioTransporteConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ServicioTransporteConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesServicioTransporte(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesServicioTransporte(ServicioTransporte serviciotransporteAux) throws Exception {
		
			serviciotransporteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(serviciotransporteAux.getEmpresa()));
			serviciotransporteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(serviciotransporteAux.getSucursal()));
			serviciotransporteAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(serviciotransporteAux.getEjercicio()));
			serviciotransporteAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(serviciotransporteAux.getPeriodo()));
			serviciotransporteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(serviciotransporteAux.getCliente()));
			serviciotransporteAux.setclienteproveedor_descripcion(ClienteConstantesFunciones.getClienteDescripcion(serviciotransporteAux.getClienteProveedor()));
			serviciotransporteAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(serviciotransporteAux.getTransportista()));
			serviciotransporteAux.setvehiculo_descripcion(VehiculoConstantesFunciones.getVehiculoDescripcion(serviciotransporteAux.getVehiculo()));
			serviciotransporteAux.setrutatransporte_descripcion(RutaTransporteConstantesFunciones.getRutaTransporteDescripcion(serviciotransporteAux.getRutaTransporte()));
			serviciotransporteAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(serviciotransporteAux.getDetalleActivoFijo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesServicioTransporte(List<ServicioTransporte> serviciotransportesTemp) throws Exception {
		for(ServicioTransporte serviciotransporteAux:serviciotransportesTemp) {
			
			serviciotransporteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(serviciotransporteAux.getEmpresa()));
			serviciotransporteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(serviciotransporteAux.getSucursal()));
			serviciotransporteAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(serviciotransporteAux.getEjercicio()));
			serviciotransporteAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(serviciotransporteAux.getPeriodo()));
			serviciotransporteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(serviciotransporteAux.getCliente()));
			serviciotransporteAux.setclienteproveedor_descripcion(ClienteConstantesFunciones.getClienteDescripcion(serviciotransporteAux.getClienteProveedor()));
			serviciotransporteAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(serviciotransporteAux.getTransportista()));
			serviciotransporteAux.setvehiculo_descripcion(VehiculoConstantesFunciones.getVehiculoDescripcion(serviciotransporteAux.getVehiculo()));
			serviciotransporteAux.setrutatransporte_descripcion(RutaTransporteConstantesFunciones.getRutaTransporteDescripcion(serviciotransporteAux.getRutaTransporte()));
			serviciotransporteAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(serviciotransporteAux.getDetalleActivoFijo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfServicioTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Transportista.class));
				classes.add(new Classe(Vehiculo.class));
				classes.add(new Classe(RutaTransporte.class));
				classes.add(new Classe(DetalleActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transportista.class)) {
						classes.add(new Classe(Transportista.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vehiculo.class)) {
						classes.add(new Classe(Vehiculo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RutaTransporte.class)) {
						classes.add(new Classe(RutaTransporte.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfServicioTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(Vehiculo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vehiculo.class)); continue;
					}

					if(RutaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RutaTransporte.class)); continue;
					}

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(Vehiculo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vehiculo.class)); continue;
					}

					if(RutaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RutaTransporte.class)); continue;
					}

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfServicioTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ServicioTransporteConstantesFunciones.getClassesRelationshipsOfServicioTransporte(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfServicioTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleServicioTransporte.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleServicioTransporte.class)) {
						classes.add(new Classe(DetalleServicioTransporte.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfServicioTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ServicioTransporteConstantesFunciones.getClassesRelationshipsFromStringsOfServicioTransporte(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfServicioTransporte(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleServicioTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleServicioTransporte.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleServicioTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleServicioTransporte.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(ServicioTransporte serviciotransporte,List<ServicioTransporte> serviciotransportes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ServicioTransporte serviciotransporteEncontrado=null;
			
			for(ServicioTransporte serviciotransporteLocal:serviciotransportes) {
				if(serviciotransporteLocal.getId().equals(serviciotransporte.getId())) {
					serviciotransporteEncontrado=serviciotransporteLocal;
					
					serviciotransporteLocal.setIsChanged(serviciotransporte.getIsChanged());
					serviciotransporteLocal.setIsNew(serviciotransporte.getIsNew());
					serviciotransporteLocal.setIsDeleted(serviciotransporte.getIsDeleted());
					
					serviciotransporteLocal.setGeneralEntityOriginal(serviciotransporte.getGeneralEntityOriginal());
					
					serviciotransporteLocal.setId(serviciotransporte.getId());	
					serviciotransporteLocal.setVersionRow(serviciotransporte.getVersionRow());	
					serviciotransporteLocal.setid_empresa(serviciotransporte.getid_empresa());	
					serviciotransporteLocal.setid_sucursal(serviciotransporte.getid_sucursal());	
					serviciotransporteLocal.setid_ejercicio(serviciotransporte.getid_ejercicio());	
					serviciotransporteLocal.setid_periodo(serviciotransporte.getid_periodo());	
					serviciotransporteLocal.setid_cliente(serviciotransporte.getid_cliente());	
					serviciotransporteLocal.setid_cliente_proveedor(serviciotransporte.getid_cliente_proveedor());	
					serviciotransporteLocal.setid_transportista(serviciotransporte.getid_transportista());	
					serviciotransporteLocal.setid_vehiculo(serviciotransporte.getid_vehiculo());	
					serviciotransporteLocal.setid_ruta_transporte(serviciotransporte.getid_ruta_transporte());	
					serviciotransporteLocal.setid_detalle_activo_fijo(serviciotransporte.getid_detalle_activo_fijo());	
					serviciotransporteLocal.setfecha_ingreso(serviciotransporte.getfecha_ingreso());	
					serviciotransporteLocal.setfecha_entrega(serviciotransporte.getfecha_entrega());	
					serviciotransporteLocal.setcodigo_guia1(serviciotransporte.getcodigo_guia1());	
					serviciotransporteLocal.setcodigo_guia2(serviciotransporte.getcodigo_guia2());	
					serviciotransporteLocal.setprecio(serviciotransporte.getprecio());	
					serviciotransporteLocal.setvalor_iva(serviciotransporte.getvalor_iva());	
					serviciotransporteLocal.setvalor_total(serviciotransporte.getvalor_total());	
					serviciotransporteLocal.setdescripcion(serviciotransporte.getdescripcion());	
					
					
					serviciotransporteLocal.setDetalleServicioTransportes(serviciotransporte.getDetalleServicioTransportes());
					
					existe=true;
					break;
				}
			}
			
			if(!serviciotransporte.getIsDeleted()) {
				if(!existe) {
					serviciotransportes.add(serviciotransporte);
				}
			} else {
				if(serviciotransporteEncontrado!=null && permiteQuitar)  {
					serviciotransportes.remove(serviciotransporteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ServicioTransporte serviciotransporte,List<ServicioTransporte> serviciotransportes) throws Exception {
		try	{			
			for(ServicioTransporte serviciotransporteLocal:serviciotransportes) {
				if(serviciotransporteLocal.getId().equals(serviciotransporte.getId())) {
					serviciotransporteLocal.setIsSelected(serviciotransporte.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesServicioTransporte(List<ServicioTransporte> serviciotransportesAux) throws Exception {
		//this.serviciotransportesAux=serviciotransportesAux;
		
		for(ServicioTransporte serviciotransporteAux:serviciotransportesAux) {
			if(serviciotransporteAux.getIsChanged()) {
				serviciotransporteAux.setIsChanged(false);
			}		
			
			if(serviciotransporteAux.getIsNew()) {
				serviciotransporteAux.setIsNew(false);
			}	
			
			if(serviciotransporteAux.getIsDeleted()) {
				serviciotransporteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesServicioTransporte(ServicioTransporte serviciotransporteAux) throws Exception {
		//this.serviciotransporteAux=serviciotransporteAux;
		
			if(serviciotransporteAux.getIsChanged()) {
				serviciotransporteAux.setIsChanged(false);
			}		
			
			if(serviciotransporteAux.getIsNew()) {
				serviciotransporteAux.setIsNew(false);
			}	
			
			if(serviciotransporteAux.getIsDeleted()) {
				serviciotransporteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ServicioTransporte serviciotransporteAsignar,ServicioTransporte serviciotransporte) throws Exception {
		serviciotransporteAsignar.setId(serviciotransporte.getId());	
		serviciotransporteAsignar.setVersionRow(serviciotransporte.getVersionRow());	
		serviciotransporteAsignar.setid_empresa(serviciotransporte.getid_empresa());
		serviciotransporteAsignar.setempresa_descripcion(serviciotransporte.getempresa_descripcion());	
		serviciotransporteAsignar.setid_sucursal(serviciotransporte.getid_sucursal());
		serviciotransporteAsignar.setsucursal_descripcion(serviciotransporte.getsucursal_descripcion());	
		serviciotransporteAsignar.setid_ejercicio(serviciotransporte.getid_ejercicio());
		serviciotransporteAsignar.setejercicio_descripcion(serviciotransporte.getejercicio_descripcion());	
		serviciotransporteAsignar.setid_periodo(serviciotransporte.getid_periodo());
		serviciotransporteAsignar.setperiodo_descripcion(serviciotransporte.getperiodo_descripcion());	
		serviciotransporteAsignar.setid_cliente(serviciotransporte.getid_cliente());
		serviciotransporteAsignar.setcliente_descripcion(serviciotransporte.getcliente_descripcion());	
		serviciotransporteAsignar.setid_cliente_proveedor(serviciotransporte.getid_cliente_proveedor());
		serviciotransporteAsignar.setclienteproveedor_descripcion(serviciotransporte.getclienteproveedor_descripcion());	
		serviciotransporteAsignar.setid_transportista(serviciotransporte.getid_transportista());
		serviciotransporteAsignar.settransportista_descripcion(serviciotransporte.gettransportista_descripcion());	
		serviciotransporteAsignar.setid_vehiculo(serviciotransporte.getid_vehiculo());
		serviciotransporteAsignar.setvehiculo_descripcion(serviciotransporte.getvehiculo_descripcion());	
		serviciotransporteAsignar.setid_ruta_transporte(serviciotransporte.getid_ruta_transporte());
		serviciotransporteAsignar.setrutatransporte_descripcion(serviciotransporte.getrutatransporte_descripcion());	
		serviciotransporteAsignar.setid_detalle_activo_fijo(serviciotransporte.getid_detalle_activo_fijo());
		serviciotransporteAsignar.setdetalleactivofijo_descripcion(serviciotransporte.getdetalleactivofijo_descripcion());	
		serviciotransporteAsignar.setfecha_ingreso(serviciotransporte.getfecha_ingreso());	
		serviciotransporteAsignar.setfecha_entrega(serviciotransporte.getfecha_entrega());	
		serviciotransporteAsignar.setcodigo_guia1(serviciotransporte.getcodigo_guia1());	
		serviciotransporteAsignar.setcodigo_guia2(serviciotransporte.getcodigo_guia2());	
		serviciotransporteAsignar.setprecio(serviciotransporte.getprecio());	
		serviciotransporteAsignar.setvalor_iva(serviciotransporte.getvalor_iva());	
		serviciotransporteAsignar.setvalor_total(serviciotransporte.getvalor_total());	
		serviciotransporteAsignar.setdescripcion(serviciotransporte.getdescripcion());	
	}
	
	public static void inicializarServicioTransporte(ServicioTransporte serviciotransporte) throws Exception {
		try {
				serviciotransporte.setId(0L);	
					
				serviciotransporte.setid_empresa(-1L);	
				serviciotransporte.setid_sucursal(-1L);	
				serviciotransporte.setid_ejercicio(-1L);	
				serviciotransporte.setid_periodo(-1L);	
				serviciotransporte.setid_cliente(-1L);	
				serviciotransporte.setid_cliente_proveedor(-1L);	
				serviciotransporte.setid_transportista(-1L);	
				serviciotransporte.setid_vehiculo(-1L);	
				serviciotransporte.setid_ruta_transporte(-1L);	
				serviciotransporte.setid_detalle_activo_fijo(-1L);	
				serviciotransporte.setfecha_ingreso(new Date());	
				serviciotransporte.setfecha_entrega(new Date());	
				serviciotransporte.setcodigo_guia1("");	
				serviciotransporte.setcodigo_guia2("");	
				serviciotransporte.setprecio(0.0);	
				serviciotransporte.setvalor_iva(0.0);	
				serviciotransporte.setvalor_total(0.0);	
				serviciotransporte.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderServicioTransporte(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_IDCLIENTEPROVEEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_IDTRANSPORTISTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_IDVEHICULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_IDRUTATRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_FECHAINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_CODIGOGUIA1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_CODIGOGUIA2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_VALORIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_VALORTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioTransporteConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataServicioTransporte(String sTipo,Row row,Workbook workbook,ServicioTransporte serviciotransporte,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getclienteproveedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.gettransportista_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getvehiculo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getrutatransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getdetalleactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getfecha_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getcodigo_guia1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getcodigo_guia2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getvalor_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getvalor_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciotransporte.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryServicioTransporte=Constantes.SFINALQUERY;
	
	public String getsFinalQueryServicioTransporte() {
		return this.sFinalQueryServicioTransporte;
	}
	
	public void setsFinalQueryServicioTransporte(String sFinalQueryServicioTransporte) {
		this.sFinalQueryServicioTransporte= sFinalQueryServicioTransporte;
	}
	
	public Border resaltarSeleccionarServicioTransporte=null;
	
	public Border setResaltarSeleccionarServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarSeleccionarServicioTransporte= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarServicioTransporte() {
		return this.resaltarSeleccionarServicioTransporte;
	}
	
	public void setResaltarSeleccionarServicioTransporte(Border borderResaltarSeleccionarServicioTransporte) {
		this.resaltarSeleccionarServicioTransporte= borderResaltarSeleccionarServicioTransporte;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridServicioTransporte=null;
	public Boolean mostraridServicioTransporte=true;
	public Boolean activaridServicioTransporte=true;

	public Border resaltarid_empresaServicioTransporte=null;
	public Boolean mostrarid_empresaServicioTransporte=true;
	public Boolean activarid_empresaServicioTransporte=true;
	public Boolean cargarid_empresaServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_sucursalServicioTransporte=null;
	public Boolean mostrarid_sucursalServicioTransporte=true;
	public Boolean activarid_sucursalServicioTransporte=true;
	public Boolean cargarid_sucursalServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_ejercicioServicioTransporte=null;
	public Boolean mostrarid_ejercicioServicioTransporte=true;
	public Boolean activarid_ejercicioServicioTransporte=true;
	public Boolean cargarid_ejercicioServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_periodoServicioTransporte=null;
	public Boolean mostrarid_periodoServicioTransporte=true;
	public Boolean activarid_periodoServicioTransporte=true;
	public Boolean cargarid_periodoServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_clienteServicioTransporte=null;
	public Boolean mostrarid_clienteServicioTransporte=true;
	public Boolean activarid_clienteServicioTransporte=true;
	public Boolean cargarid_clienteServicioTransporte=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_cliente_proveedorServicioTransporte=null;
	public Boolean mostrarid_cliente_proveedorServicioTransporte=true;
	public Boolean activarid_cliente_proveedorServicioTransporte=true;
	public Boolean cargarid_cliente_proveedorServicioTransporte=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cliente_proveedorServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_transportistaServicioTransporte=null;
	public Boolean mostrarid_transportistaServicioTransporte=true;
	public Boolean activarid_transportistaServicioTransporte=true;
	public Boolean cargarid_transportistaServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportistaServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_vehiculoServicioTransporte=null;
	public Boolean mostrarid_vehiculoServicioTransporte=true;
	public Boolean activarid_vehiculoServicioTransporte=true;
	public Boolean cargarid_vehiculoServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vehiculoServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_ruta_transporteServicioTransporte=null;
	public Boolean mostrarid_ruta_transporteServicioTransporte=true;
	public Boolean activarid_ruta_transporteServicioTransporte=true;
	public Boolean cargarid_ruta_transporteServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ruta_transporteServicioTransporte=false;//ConEventDepend=true

	public Border resaltarid_detalle_activo_fijoServicioTransporte=null;
	public Boolean mostrarid_detalle_activo_fijoServicioTransporte=true;
	public Boolean activarid_detalle_activo_fijoServicioTransporte=true;
	public Boolean cargarid_detalle_activo_fijoServicioTransporte=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_activo_fijoServicioTransporte=false;//ConEventDepend=true

	public Border resaltarfecha_ingresoServicioTransporte=null;
	public Boolean mostrarfecha_ingresoServicioTransporte=true;
	public Boolean activarfecha_ingresoServicioTransporte=false;

	public Border resaltarfecha_entregaServicioTransporte=null;
	public Boolean mostrarfecha_entregaServicioTransporte=true;
	public Boolean activarfecha_entregaServicioTransporte=false;

	public Border resaltarcodigo_guia1ServicioTransporte=null;
	public Boolean mostrarcodigo_guia1ServicioTransporte=true;
	public Boolean activarcodigo_guia1ServicioTransporte=true;

	public Border resaltarcodigo_guia2ServicioTransporte=null;
	public Boolean mostrarcodigo_guia2ServicioTransporte=true;
	public Boolean activarcodigo_guia2ServicioTransporte=true;

	public Border resaltarprecioServicioTransporte=null;
	public Boolean mostrarprecioServicioTransporte=true;
	public Boolean activarprecioServicioTransporte=true;

	public Border resaltarvalor_ivaServicioTransporte=null;
	public Boolean mostrarvalor_ivaServicioTransporte=true;
	public Boolean activarvalor_ivaServicioTransporte=true;

	public Border resaltarvalor_totalServicioTransporte=null;
	public Boolean mostrarvalor_totalServicioTransporte=true;
	public Boolean activarvalor_totalServicioTransporte=true;

	public Border resaltardescripcionServicioTransporte=null;
	public Boolean mostrardescripcionServicioTransporte=true;
	public Boolean activardescripcionServicioTransporte=true;

	
	

	public Border setResaltaridServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltaridServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridServicioTransporte() {
		return this.resaltaridServicioTransporte;
	}

	public void setResaltaridServicioTransporte(Border borderResaltar) {
		this.resaltaridServicioTransporte= borderResaltar;
	}

	public Boolean getMostraridServicioTransporte() {
		return this.mostraridServicioTransporte;
	}

	public void setMostraridServicioTransporte(Boolean mostraridServicioTransporte) {
		this.mostraridServicioTransporte= mostraridServicioTransporte;
	}

	public Boolean getActivaridServicioTransporte() {
		return this.activaridServicioTransporte;
	}

	public void setActivaridServicioTransporte(Boolean activaridServicioTransporte) {
		this.activaridServicioTransporte= activaridServicioTransporte;
	}

	public Border setResaltarid_empresaServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_empresaServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaServicioTransporte() {
		return this.resaltarid_empresaServicioTransporte;
	}

	public void setResaltarid_empresaServicioTransporte(Border borderResaltar) {
		this.resaltarid_empresaServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_empresaServicioTransporte() {
		return this.mostrarid_empresaServicioTransporte;
	}

	public void setMostrarid_empresaServicioTransporte(Boolean mostrarid_empresaServicioTransporte) {
		this.mostrarid_empresaServicioTransporte= mostrarid_empresaServicioTransporte;
	}

	public Boolean getActivarid_empresaServicioTransporte() {
		return this.activarid_empresaServicioTransporte;
	}

	public void setActivarid_empresaServicioTransporte(Boolean activarid_empresaServicioTransporte) {
		this.activarid_empresaServicioTransporte= activarid_empresaServicioTransporte;
	}

	public Boolean getCargarid_empresaServicioTransporte() {
		return this.cargarid_empresaServicioTransporte;
	}

	public void setCargarid_empresaServicioTransporte(Boolean cargarid_empresaServicioTransporte) {
		this.cargarid_empresaServicioTransporte= cargarid_empresaServicioTransporte;
	}

	public Border setResaltarid_sucursalServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_sucursalServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalServicioTransporte() {
		return this.resaltarid_sucursalServicioTransporte;
	}

	public void setResaltarid_sucursalServicioTransporte(Border borderResaltar) {
		this.resaltarid_sucursalServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_sucursalServicioTransporte() {
		return this.mostrarid_sucursalServicioTransporte;
	}

	public void setMostrarid_sucursalServicioTransporte(Boolean mostrarid_sucursalServicioTransporte) {
		this.mostrarid_sucursalServicioTransporte= mostrarid_sucursalServicioTransporte;
	}

	public Boolean getActivarid_sucursalServicioTransporte() {
		return this.activarid_sucursalServicioTransporte;
	}

	public void setActivarid_sucursalServicioTransporte(Boolean activarid_sucursalServicioTransporte) {
		this.activarid_sucursalServicioTransporte= activarid_sucursalServicioTransporte;
	}

	public Boolean getCargarid_sucursalServicioTransporte() {
		return this.cargarid_sucursalServicioTransporte;
	}

	public void setCargarid_sucursalServicioTransporte(Boolean cargarid_sucursalServicioTransporte) {
		this.cargarid_sucursalServicioTransporte= cargarid_sucursalServicioTransporte;
	}

	public Border setResaltarid_ejercicioServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioServicioTransporte() {
		return this.resaltarid_ejercicioServicioTransporte;
	}

	public void setResaltarid_ejercicioServicioTransporte(Border borderResaltar) {
		this.resaltarid_ejercicioServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioServicioTransporte() {
		return this.mostrarid_ejercicioServicioTransporte;
	}

	public void setMostrarid_ejercicioServicioTransporte(Boolean mostrarid_ejercicioServicioTransporte) {
		this.mostrarid_ejercicioServicioTransporte= mostrarid_ejercicioServicioTransporte;
	}

	public Boolean getActivarid_ejercicioServicioTransporte() {
		return this.activarid_ejercicioServicioTransporte;
	}

	public void setActivarid_ejercicioServicioTransporte(Boolean activarid_ejercicioServicioTransporte) {
		this.activarid_ejercicioServicioTransporte= activarid_ejercicioServicioTransporte;
	}

	public Boolean getCargarid_ejercicioServicioTransporte() {
		return this.cargarid_ejercicioServicioTransporte;
	}

	public void setCargarid_ejercicioServicioTransporte(Boolean cargarid_ejercicioServicioTransporte) {
		this.cargarid_ejercicioServicioTransporte= cargarid_ejercicioServicioTransporte;
	}

	public Border setResaltarid_periodoServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_periodoServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoServicioTransporte() {
		return this.resaltarid_periodoServicioTransporte;
	}

	public void setResaltarid_periodoServicioTransporte(Border borderResaltar) {
		this.resaltarid_periodoServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_periodoServicioTransporte() {
		return this.mostrarid_periodoServicioTransporte;
	}

	public void setMostrarid_periodoServicioTransporte(Boolean mostrarid_periodoServicioTransporte) {
		this.mostrarid_periodoServicioTransporte= mostrarid_periodoServicioTransporte;
	}

	public Boolean getActivarid_periodoServicioTransporte() {
		return this.activarid_periodoServicioTransporte;
	}

	public void setActivarid_periodoServicioTransporte(Boolean activarid_periodoServicioTransporte) {
		this.activarid_periodoServicioTransporte= activarid_periodoServicioTransporte;
	}

	public Boolean getCargarid_periodoServicioTransporte() {
		return this.cargarid_periodoServicioTransporte;
	}

	public void setCargarid_periodoServicioTransporte(Boolean cargarid_periodoServicioTransporte) {
		this.cargarid_periodoServicioTransporte= cargarid_periodoServicioTransporte;
	}

	public Border setResaltarid_clienteServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_clienteServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteServicioTransporte() {
		return this.resaltarid_clienteServicioTransporte;
	}

	public void setResaltarid_clienteServicioTransporte(Border borderResaltar) {
		this.resaltarid_clienteServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_clienteServicioTransporte() {
		return this.mostrarid_clienteServicioTransporte;
	}

	public void setMostrarid_clienteServicioTransporte(Boolean mostrarid_clienteServicioTransporte) {
		this.mostrarid_clienteServicioTransporte= mostrarid_clienteServicioTransporte;
	}

	public Boolean getActivarid_clienteServicioTransporte() {
		return this.activarid_clienteServicioTransporte;
	}

	public void setActivarid_clienteServicioTransporte(Boolean activarid_clienteServicioTransporte) {
		this.activarid_clienteServicioTransporte= activarid_clienteServicioTransporte;
	}

	public Boolean getCargarid_clienteServicioTransporte() {
		return this.cargarid_clienteServicioTransporte;
	}

	public void setCargarid_clienteServicioTransporte(Boolean cargarid_clienteServicioTransporte) {
		this.cargarid_clienteServicioTransporte= cargarid_clienteServicioTransporte;
	}

	public Border setResaltarid_cliente_proveedorServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_cliente_proveedorServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cliente_proveedorServicioTransporte() {
		return this.resaltarid_cliente_proveedorServicioTransporte;
	}

	public void setResaltarid_cliente_proveedorServicioTransporte(Border borderResaltar) {
		this.resaltarid_cliente_proveedorServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_cliente_proveedorServicioTransporte() {
		return this.mostrarid_cliente_proveedorServicioTransporte;
	}

	public void setMostrarid_cliente_proveedorServicioTransporte(Boolean mostrarid_cliente_proveedorServicioTransporte) {
		this.mostrarid_cliente_proveedorServicioTransporte= mostrarid_cliente_proveedorServicioTransporte;
	}

	public Boolean getActivarid_cliente_proveedorServicioTransporte() {
		return this.activarid_cliente_proveedorServicioTransporte;
	}

	public void setActivarid_cliente_proveedorServicioTransporte(Boolean activarid_cliente_proveedorServicioTransporte) {
		this.activarid_cliente_proveedorServicioTransporte= activarid_cliente_proveedorServicioTransporte;
	}

	public Boolean getCargarid_cliente_proveedorServicioTransporte() {
		return this.cargarid_cliente_proveedorServicioTransporte;
	}

	public void setCargarid_cliente_proveedorServicioTransporte(Boolean cargarid_cliente_proveedorServicioTransporte) {
		this.cargarid_cliente_proveedorServicioTransporte= cargarid_cliente_proveedorServicioTransporte;
	}

	public Border setResaltarid_transportistaServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_transportistaServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportistaServicioTransporte() {
		return this.resaltarid_transportistaServicioTransporte;
	}

	public void setResaltarid_transportistaServicioTransporte(Border borderResaltar) {
		this.resaltarid_transportistaServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_transportistaServicioTransporte() {
		return this.mostrarid_transportistaServicioTransporte;
	}

	public void setMostrarid_transportistaServicioTransporte(Boolean mostrarid_transportistaServicioTransporte) {
		this.mostrarid_transportistaServicioTransporte= mostrarid_transportistaServicioTransporte;
	}

	public Boolean getActivarid_transportistaServicioTransporte() {
		return this.activarid_transportistaServicioTransporte;
	}

	public void setActivarid_transportistaServicioTransporte(Boolean activarid_transportistaServicioTransporte) {
		this.activarid_transportistaServicioTransporte= activarid_transportistaServicioTransporte;
	}

	public Boolean getCargarid_transportistaServicioTransporte() {
		return this.cargarid_transportistaServicioTransporte;
	}

	public void setCargarid_transportistaServicioTransporte(Boolean cargarid_transportistaServicioTransporte) {
		this.cargarid_transportistaServicioTransporte= cargarid_transportistaServicioTransporte;
	}

	public Border setResaltarid_vehiculoServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_vehiculoServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vehiculoServicioTransporte() {
		return this.resaltarid_vehiculoServicioTransporte;
	}

	public void setResaltarid_vehiculoServicioTransporte(Border borderResaltar) {
		this.resaltarid_vehiculoServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_vehiculoServicioTransporte() {
		return this.mostrarid_vehiculoServicioTransporte;
	}

	public void setMostrarid_vehiculoServicioTransporte(Boolean mostrarid_vehiculoServicioTransporte) {
		this.mostrarid_vehiculoServicioTransporte= mostrarid_vehiculoServicioTransporte;
	}

	public Boolean getActivarid_vehiculoServicioTransporte() {
		return this.activarid_vehiculoServicioTransporte;
	}

	public void setActivarid_vehiculoServicioTransporte(Boolean activarid_vehiculoServicioTransporte) {
		this.activarid_vehiculoServicioTransporte= activarid_vehiculoServicioTransporte;
	}

	public Boolean getCargarid_vehiculoServicioTransporte() {
		return this.cargarid_vehiculoServicioTransporte;
	}

	public void setCargarid_vehiculoServicioTransporte(Boolean cargarid_vehiculoServicioTransporte) {
		this.cargarid_vehiculoServicioTransporte= cargarid_vehiculoServicioTransporte;
	}

	public Border setResaltarid_ruta_transporteServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_ruta_transporteServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ruta_transporteServicioTransporte() {
		return this.resaltarid_ruta_transporteServicioTransporte;
	}

	public void setResaltarid_ruta_transporteServicioTransporte(Border borderResaltar) {
		this.resaltarid_ruta_transporteServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_ruta_transporteServicioTransporte() {
		return this.mostrarid_ruta_transporteServicioTransporte;
	}

	public void setMostrarid_ruta_transporteServicioTransporte(Boolean mostrarid_ruta_transporteServicioTransporte) {
		this.mostrarid_ruta_transporteServicioTransporte= mostrarid_ruta_transporteServicioTransporte;
	}

	public Boolean getActivarid_ruta_transporteServicioTransporte() {
		return this.activarid_ruta_transporteServicioTransporte;
	}

	public void setActivarid_ruta_transporteServicioTransporte(Boolean activarid_ruta_transporteServicioTransporte) {
		this.activarid_ruta_transporteServicioTransporte= activarid_ruta_transporteServicioTransporte;
	}

	public Boolean getCargarid_ruta_transporteServicioTransporte() {
		return this.cargarid_ruta_transporteServicioTransporte;
	}

	public void setCargarid_ruta_transporteServicioTransporte(Boolean cargarid_ruta_transporteServicioTransporte) {
		this.cargarid_ruta_transporteServicioTransporte= cargarid_ruta_transporteServicioTransporte;
	}

	public Border setResaltarid_detalle_activo_fijoServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarid_detalle_activo_fijoServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_activo_fijoServicioTransporte() {
		return this.resaltarid_detalle_activo_fijoServicioTransporte;
	}

	public void setResaltarid_detalle_activo_fijoServicioTransporte(Border borderResaltar) {
		this.resaltarid_detalle_activo_fijoServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarid_detalle_activo_fijoServicioTransporte() {
		return this.mostrarid_detalle_activo_fijoServicioTransporte;
	}

	public void setMostrarid_detalle_activo_fijoServicioTransporte(Boolean mostrarid_detalle_activo_fijoServicioTransporte) {
		this.mostrarid_detalle_activo_fijoServicioTransporte= mostrarid_detalle_activo_fijoServicioTransporte;
	}

	public Boolean getActivarid_detalle_activo_fijoServicioTransporte() {
		return this.activarid_detalle_activo_fijoServicioTransporte;
	}

	public void setActivarid_detalle_activo_fijoServicioTransporte(Boolean activarid_detalle_activo_fijoServicioTransporte) {
		this.activarid_detalle_activo_fijoServicioTransporte= activarid_detalle_activo_fijoServicioTransporte;
	}

	public Boolean getCargarid_detalle_activo_fijoServicioTransporte() {
		return this.cargarid_detalle_activo_fijoServicioTransporte;
	}

	public void setCargarid_detalle_activo_fijoServicioTransporte(Boolean cargarid_detalle_activo_fijoServicioTransporte) {
		this.cargarid_detalle_activo_fijoServicioTransporte= cargarid_detalle_activo_fijoServicioTransporte;
	}

	public Border setResaltarfecha_ingresoServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarfecha_ingresoServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ingresoServicioTransporte() {
		return this.resaltarfecha_ingresoServicioTransporte;
	}

	public void setResaltarfecha_ingresoServicioTransporte(Border borderResaltar) {
		this.resaltarfecha_ingresoServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarfecha_ingresoServicioTransporte() {
		return this.mostrarfecha_ingresoServicioTransporte;
	}

	public void setMostrarfecha_ingresoServicioTransporte(Boolean mostrarfecha_ingresoServicioTransporte) {
		this.mostrarfecha_ingresoServicioTransporte= mostrarfecha_ingresoServicioTransporte;
	}

	public Boolean getActivarfecha_ingresoServicioTransporte() {
		return this.activarfecha_ingresoServicioTransporte;
	}

	public void setActivarfecha_ingresoServicioTransporte(Boolean activarfecha_ingresoServicioTransporte) {
		this.activarfecha_ingresoServicioTransporte= activarfecha_ingresoServicioTransporte;
	}

	public Border setResaltarfecha_entregaServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaServicioTransporte() {
		return this.resaltarfecha_entregaServicioTransporte;
	}

	public void setResaltarfecha_entregaServicioTransporte(Border borderResaltar) {
		this.resaltarfecha_entregaServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaServicioTransporte() {
		return this.mostrarfecha_entregaServicioTransporte;
	}

	public void setMostrarfecha_entregaServicioTransporte(Boolean mostrarfecha_entregaServicioTransporte) {
		this.mostrarfecha_entregaServicioTransporte= mostrarfecha_entregaServicioTransporte;
	}

	public Boolean getActivarfecha_entregaServicioTransporte() {
		return this.activarfecha_entregaServicioTransporte;
	}

	public void setActivarfecha_entregaServicioTransporte(Boolean activarfecha_entregaServicioTransporte) {
		this.activarfecha_entregaServicioTransporte= activarfecha_entregaServicioTransporte;
	}

	public Border setResaltarcodigo_guia1ServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarcodigo_guia1ServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_guia1ServicioTransporte() {
		return this.resaltarcodigo_guia1ServicioTransporte;
	}

	public void setResaltarcodigo_guia1ServicioTransporte(Border borderResaltar) {
		this.resaltarcodigo_guia1ServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarcodigo_guia1ServicioTransporte() {
		return this.mostrarcodigo_guia1ServicioTransporte;
	}

	public void setMostrarcodigo_guia1ServicioTransporte(Boolean mostrarcodigo_guia1ServicioTransporte) {
		this.mostrarcodigo_guia1ServicioTransporte= mostrarcodigo_guia1ServicioTransporte;
	}

	public Boolean getActivarcodigo_guia1ServicioTransporte() {
		return this.activarcodigo_guia1ServicioTransporte;
	}

	public void setActivarcodigo_guia1ServicioTransporte(Boolean activarcodigo_guia1ServicioTransporte) {
		this.activarcodigo_guia1ServicioTransporte= activarcodigo_guia1ServicioTransporte;
	}

	public Border setResaltarcodigo_guia2ServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarcodigo_guia2ServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_guia2ServicioTransporte() {
		return this.resaltarcodigo_guia2ServicioTransporte;
	}

	public void setResaltarcodigo_guia2ServicioTransporte(Border borderResaltar) {
		this.resaltarcodigo_guia2ServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarcodigo_guia2ServicioTransporte() {
		return this.mostrarcodigo_guia2ServicioTransporte;
	}

	public void setMostrarcodigo_guia2ServicioTransporte(Boolean mostrarcodigo_guia2ServicioTransporte) {
		this.mostrarcodigo_guia2ServicioTransporte= mostrarcodigo_guia2ServicioTransporte;
	}

	public Boolean getActivarcodigo_guia2ServicioTransporte() {
		return this.activarcodigo_guia2ServicioTransporte;
	}

	public void setActivarcodigo_guia2ServicioTransporte(Boolean activarcodigo_guia2ServicioTransporte) {
		this.activarcodigo_guia2ServicioTransporte= activarcodigo_guia2ServicioTransporte;
	}

	public Border setResaltarprecioServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarprecioServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioServicioTransporte() {
		return this.resaltarprecioServicioTransporte;
	}

	public void setResaltarprecioServicioTransporte(Border borderResaltar) {
		this.resaltarprecioServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarprecioServicioTransporte() {
		return this.mostrarprecioServicioTransporte;
	}

	public void setMostrarprecioServicioTransporte(Boolean mostrarprecioServicioTransporte) {
		this.mostrarprecioServicioTransporte= mostrarprecioServicioTransporte;
	}

	public Boolean getActivarprecioServicioTransporte() {
		return this.activarprecioServicioTransporte;
	}

	public void setActivarprecioServicioTransporte(Boolean activarprecioServicioTransporte) {
		this.activarprecioServicioTransporte= activarprecioServicioTransporte;
	}

	public Border setResaltarvalor_ivaServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarvalor_ivaServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_ivaServicioTransporte() {
		return this.resaltarvalor_ivaServicioTransporte;
	}

	public void setResaltarvalor_ivaServicioTransporte(Border borderResaltar) {
		this.resaltarvalor_ivaServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarvalor_ivaServicioTransporte() {
		return this.mostrarvalor_ivaServicioTransporte;
	}

	public void setMostrarvalor_ivaServicioTransporte(Boolean mostrarvalor_ivaServicioTransporte) {
		this.mostrarvalor_ivaServicioTransporte= mostrarvalor_ivaServicioTransporte;
	}

	public Boolean getActivarvalor_ivaServicioTransporte() {
		return this.activarvalor_ivaServicioTransporte;
	}

	public void setActivarvalor_ivaServicioTransporte(Boolean activarvalor_ivaServicioTransporte) {
		this.activarvalor_ivaServicioTransporte= activarvalor_ivaServicioTransporte;
	}

	public Border setResaltarvalor_totalServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltarvalor_totalServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_totalServicioTransporte() {
		return this.resaltarvalor_totalServicioTransporte;
	}

	public void setResaltarvalor_totalServicioTransporte(Border borderResaltar) {
		this.resaltarvalor_totalServicioTransporte= borderResaltar;
	}

	public Boolean getMostrarvalor_totalServicioTransporte() {
		return this.mostrarvalor_totalServicioTransporte;
	}

	public void setMostrarvalor_totalServicioTransporte(Boolean mostrarvalor_totalServicioTransporte) {
		this.mostrarvalor_totalServicioTransporte= mostrarvalor_totalServicioTransporte;
	}

	public Boolean getActivarvalor_totalServicioTransporte() {
		return this.activarvalor_totalServicioTransporte;
	}

	public void setActivarvalor_totalServicioTransporte(Boolean activarvalor_totalServicioTransporte) {
		this.activarvalor_totalServicioTransporte= activarvalor_totalServicioTransporte;
	}

	public Border setResaltardescripcionServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltar);
		
		this.resaltardescripcionServicioTransporte= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionServicioTransporte() {
		return this.resaltardescripcionServicioTransporte;
	}

	public void setResaltardescripcionServicioTransporte(Border borderResaltar) {
		this.resaltardescripcionServicioTransporte= borderResaltar;
	}

	public Boolean getMostrardescripcionServicioTransporte() {
		return this.mostrardescripcionServicioTransporte;
	}

	public void setMostrardescripcionServicioTransporte(Boolean mostrardescripcionServicioTransporte) {
		this.mostrardescripcionServicioTransporte= mostrardescripcionServicioTransporte;
	}

	public Boolean getActivardescripcionServicioTransporte() {
		return this.activardescripcionServicioTransporte;
	}

	public void setActivardescripcionServicioTransporte(Boolean activardescripcionServicioTransporte) {
		this.activardescripcionServicioTransporte= activardescripcionServicioTransporte;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridServicioTransporte(esInicial);
		this.setMostrarid_empresaServicioTransporte(esInicial);
		this.setMostrarid_sucursalServicioTransporte(esInicial);
		this.setMostrarid_ejercicioServicioTransporte(esInicial);
		this.setMostrarid_periodoServicioTransporte(esInicial);
		this.setMostrarid_clienteServicioTransporte(esInicial);
		this.setMostrarid_cliente_proveedorServicioTransporte(esInicial);
		this.setMostrarid_transportistaServicioTransporte(esInicial);
		this.setMostrarid_vehiculoServicioTransporte(esInicial);
		this.setMostrarid_ruta_transporteServicioTransporte(esInicial);
		this.setMostrarid_detalle_activo_fijoServicioTransporte(esInicial);
		this.setMostrarfecha_ingresoServicioTransporte(esInicial);
		this.setMostrarfecha_entregaServicioTransporte(esInicial);
		this.setMostrarcodigo_guia1ServicioTransporte(esInicial);
		this.setMostrarcodigo_guia2ServicioTransporte(esInicial);
		this.setMostrarprecioServicioTransporte(esInicial);
		this.setMostrarvalor_ivaServicioTransporte(esInicial);
		this.setMostrarvalor_totalServicioTransporte(esInicial);
		this.setMostrardescripcionServicioTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.ID)) {
				this.setMostraridServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDCLIENTEPROVEEDOR)) {
				this.setMostrarid_cliente_proveedorServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDTRANSPORTISTA)) {
				this.setMostrarid_transportistaServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDVEHICULO)) {
				this.setMostrarid_vehiculoServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDRUTATRANSPORTE)) {
				this.setMostrarid_ruta_transporteServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setMostrarid_detalle_activo_fijoServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.FECHAINGRESO)) {
				this.setMostrarfecha_ingresoServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.CODIGOGUIA1)) {
				this.setMostrarcodigo_guia1ServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.CODIGOGUIA2)) {
				this.setMostrarcodigo_guia2ServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.PRECIO)) {
				this.setMostrarprecioServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.VALORIVA)) {
				this.setMostrarvalor_ivaServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.VALORTOTAL)) {
				this.setMostrarvalor_totalServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionServicioTransporte(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridServicioTransporte(esInicial);
		this.setActivarid_empresaServicioTransporte(esInicial);
		this.setActivarid_sucursalServicioTransporte(esInicial);
		this.setActivarid_ejercicioServicioTransporte(esInicial);
		this.setActivarid_periodoServicioTransporte(esInicial);
		this.setActivarid_clienteServicioTransporte(esInicial);
		this.setActivarid_cliente_proveedorServicioTransporte(esInicial);
		this.setActivarid_transportistaServicioTransporte(esInicial);
		this.setActivarid_vehiculoServicioTransporte(esInicial);
		this.setActivarid_ruta_transporteServicioTransporte(esInicial);
		this.setActivarid_detalle_activo_fijoServicioTransporte(esInicial);
		this.setActivarfecha_ingresoServicioTransporte(esInicial);
		this.setActivarfecha_entregaServicioTransporte(esInicial);
		this.setActivarcodigo_guia1ServicioTransporte(esInicial);
		this.setActivarcodigo_guia2ServicioTransporte(esInicial);
		this.setActivarprecioServicioTransporte(esInicial);
		this.setActivarvalor_ivaServicioTransporte(esInicial);
		this.setActivarvalor_totalServicioTransporte(esInicial);
		this.setActivardescripcionServicioTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.ID)) {
				this.setActivaridServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDCLIENTEPROVEEDOR)) {
				this.setActivarid_cliente_proveedorServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDTRANSPORTISTA)) {
				this.setActivarid_transportistaServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDVEHICULO)) {
				this.setActivarid_vehiculoServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDRUTATRANSPORTE)) {
				this.setActivarid_ruta_transporteServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setActivarid_detalle_activo_fijoServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.FECHAINGRESO)) {
				this.setActivarfecha_ingresoServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.CODIGOGUIA1)) {
				this.setActivarcodigo_guia1ServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.CODIGOGUIA2)) {
				this.setActivarcodigo_guia2ServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.PRECIO)) {
				this.setActivarprecioServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.VALORIVA)) {
				this.setActivarvalor_ivaServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.VALORTOTAL)) {
				this.setActivarvalor_totalServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionServicioTransporte(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridServicioTransporte(esInicial);
		this.setResaltarid_empresaServicioTransporte(esInicial);
		this.setResaltarid_sucursalServicioTransporte(esInicial);
		this.setResaltarid_ejercicioServicioTransporte(esInicial);
		this.setResaltarid_periodoServicioTransporte(esInicial);
		this.setResaltarid_clienteServicioTransporte(esInicial);
		this.setResaltarid_cliente_proveedorServicioTransporte(esInicial);
		this.setResaltarid_transportistaServicioTransporte(esInicial);
		this.setResaltarid_vehiculoServicioTransporte(esInicial);
		this.setResaltarid_ruta_transporteServicioTransporte(esInicial);
		this.setResaltarid_detalle_activo_fijoServicioTransporte(esInicial);
		this.setResaltarfecha_ingresoServicioTransporte(esInicial);
		this.setResaltarfecha_entregaServicioTransporte(esInicial);
		this.setResaltarcodigo_guia1ServicioTransporte(esInicial);
		this.setResaltarcodigo_guia2ServicioTransporte(esInicial);
		this.setResaltarprecioServicioTransporte(esInicial);
		this.setResaltarvalor_ivaServicioTransporte(esInicial);
		this.setResaltarvalor_totalServicioTransporte(esInicial);
		this.setResaltardescripcionServicioTransporte(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.ID)) {
				this.setResaltaridServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDCLIENTEPROVEEDOR)) {
				this.setResaltarid_cliente_proveedorServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDTRANSPORTISTA)) {
				this.setResaltarid_transportistaServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDVEHICULO)) {
				this.setResaltarid_vehiculoServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDRUTATRANSPORTE)) {
				this.setResaltarid_ruta_transporteServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setResaltarid_detalle_activo_fijoServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.FECHAINGRESO)) {
				this.setResaltarfecha_ingresoServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.CODIGOGUIA1)) {
				this.setResaltarcodigo_guia1ServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.CODIGOGUIA2)) {
				this.setResaltarcodigo_guia2ServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.PRECIO)) {
				this.setResaltarprecioServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.VALORIVA)) {
				this.setResaltarvalor_ivaServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.VALORTOTAL)) {
				this.setResaltarvalor_totalServicioTransporte(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioTransporteConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionServicioTransporte(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleServicioTransporteServicioTransporte=null;

	public Border getResaltarDetalleServicioTransporteServicioTransporte() {
		return this.resaltarDetalleServicioTransporteServicioTransporte;
	}

	public void setResaltarDetalleServicioTransporteServicioTransporte(Border borderResaltarDetalleServicioTransporte) {
		if(borderResaltarDetalleServicioTransporte!=null) {
			this.resaltarDetalleServicioTransporteServicioTransporte= borderResaltarDetalleServicioTransporte;
		}
	}

	public Border setResaltarDetalleServicioTransporteServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleServicioTransporte=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//serviciotransporteBeanSwingJInternalFrame.jTtoolBarServicioTransporte.setBorder(borderResaltarDetalleServicioTransporte);
			
		this.resaltarDetalleServicioTransporteServicioTransporte= borderResaltarDetalleServicioTransporte;

		 return borderResaltarDetalleServicioTransporte;
	}



	public Boolean mostrarDetalleServicioTransporteServicioTransporte=true;

	public Boolean getMostrarDetalleServicioTransporteServicioTransporte() {
		return this.mostrarDetalleServicioTransporteServicioTransporte;
	}

	public void setMostrarDetalleServicioTransporteServicioTransporte(Boolean visibilidadResaltarDetalleServicioTransporte) {
		this.mostrarDetalleServicioTransporteServicioTransporte= visibilidadResaltarDetalleServicioTransporte;
	}



	public Boolean activarDetalleServicioTransporteServicioTransporte=true;

	public Boolean gethabilitarResaltarDetalleServicioTransporteServicioTransporte() {
		return this.activarDetalleServicioTransporteServicioTransporte;
	}

	public void setActivarDetalleServicioTransporteServicioTransporte(Boolean habilitarResaltarDetalleServicioTransporte) {
		this.activarDetalleServicioTransporteServicioTransporte= habilitarResaltarDetalleServicioTransporte;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarDetalleServicioTransporteServicioTransporte(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleServicioTransporte.class)) {
				this.setMostrarDetalleServicioTransporteServicioTransporte(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarDetalleServicioTransporteServicioTransporte(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleServicioTransporte.class)) {
				this.setActivarDetalleServicioTransporteServicioTransporte(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleServicioTransporteServicioTransporte(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleServicioTransporte.class)) {
				this.setResaltarDetalleServicioTransporteServicioTransporte(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdClienteServicioTransporte=true;

	public Boolean getMostrarFK_IdClienteServicioTransporte() {
		return this.mostrarFK_IdClienteServicioTransporte;
	}

	public void setMostrarFK_IdClienteServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteProveedorServicioTransporte=true;

	public Boolean getMostrarFK_IdClienteProveedorServicioTransporte() {
		return this.mostrarFK_IdClienteProveedorServicioTransporte;
	}

	public void setMostrarFK_IdClienteProveedorServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteProveedorServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleActivoFijoServicioTransporte=true;

	public Boolean getMostrarFK_IdDetalleActivoFijoServicioTransporte() {
		return this.mostrarFK_IdDetalleActivoFijoServicioTransporte;
	}

	public void setMostrarFK_IdDetalleActivoFijoServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleActivoFijoServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioServicioTransporte=true;

	public Boolean getMostrarFK_IdEjercicioServicioTransporte() {
		return this.mostrarFK_IdEjercicioServicioTransporte;
	}

	public void setMostrarFK_IdEjercicioServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaServicioTransporte=true;

	public Boolean getMostrarFK_IdEmpresaServicioTransporte() {
		return this.mostrarFK_IdEmpresaServicioTransporte;
	}

	public void setMostrarFK_IdEmpresaServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoServicioTransporte=true;

	public Boolean getMostrarFK_IdPeriodoServicioTransporte() {
		return this.mostrarFK_IdPeriodoServicioTransporte;
	}

	public void setMostrarFK_IdPeriodoServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRutaTransporteServicioTransporte=true;

	public Boolean getMostrarFK_IdRutaTransporteServicioTransporte() {
		return this.mostrarFK_IdRutaTransporteServicioTransporte;
	}

	public void setMostrarFK_IdRutaTransporteServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRutaTransporteServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalServicioTransporte=true;

	public Boolean getMostrarFK_IdSucursalServicioTransporte() {
		return this.mostrarFK_IdSucursalServicioTransporte;
	}

	public void setMostrarFK_IdSucursalServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransportistaServicioTransporte=true;

	public Boolean getMostrarFK_IdTransportistaServicioTransporte() {
		return this.mostrarFK_IdTransportistaServicioTransporte;
	}

	public void setMostrarFK_IdTransportistaServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransportistaServicioTransporte= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVehiculoServicioTransporte=true;

	public Boolean getMostrarFK_IdVehiculoServicioTransporte() {
		return this.mostrarFK_IdVehiculoServicioTransporte;
	}

	public void setMostrarFK_IdVehiculoServicioTransporte(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVehiculoServicioTransporte= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteServicioTransporte=true;

	public Boolean getActivarFK_IdClienteServicioTransporte() {
		return this.activarFK_IdClienteServicioTransporte;
	}

	public void setActivarFK_IdClienteServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdClienteServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteProveedorServicioTransporte=true;

	public Boolean getActivarFK_IdClienteProveedorServicioTransporte() {
		return this.activarFK_IdClienteProveedorServicioTransporte;
	}

	public void setActivarFK_IdClienteProveedorServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdClienteProveedorServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleActivoFijoServicioTransporte=true;

	public Boolean getActivarFK_IdDetalleActivoFijoServicioTransporte() {
		return this.activarFK_IdDetalleActivoFijoServicioTransporte;
	}

	public void setActivarFK_IdDetalleActivoFijoServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleActivoFijoServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioServicioTransporte=true;

	public Boolean getActivarFK_IdEjercicioServicioTransporte() {
		return this.activarFK_IdEjercicioServicioTransporte;
	}

	public void setActivarFK_IdEjercicioServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaServicioTransporte=true;

	public Boolean getActivarFK_IdEmpresaServicioTransporte() {
		return this.activarFK_IdEmpresaServicioTransporte;
	}

	public void setActivarFK_IdEmpresaServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoServicioTransporte=true;

	public Boolean getActivarFK_IdPeriodoServicioTransporte() {
		return this.activarFK_IdPeriodoServicioTransporte;
	}

	public void setActivarFK_IdPeriodoServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdRutaTransporteServicioTransporte=true;

	public Boolean getActivarFK_IdRutaTransporteServicioTransporte() {
		return this.activarFK_IdRutaTransporteServicioTransporte;
	}

	public void setActivarFK_IdRutaTransporteServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdRutaTransporteServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalServicioTransporte=true;

	public Boolean getActivarFK_IdSucursalServicioTransporte() {
		return this.activarFK_IdSucursalServicioTransporte;
	}

	public void setActivarFK_IdSucursalServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdTransportistaServicioTransporte=true;

	public Boolean getActivarFK_IdTransportistaServicioTransporte() {
		return this.activarFK_IdTransportistaServicioTransporte;
	}

	public void setActivarFK_IdTransportistaServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdTransportistaServicioTransporte= habilitarResaltar;
	}

	public Boolean activarFK_IdVehiculoServicioTransporte=true;

	public Boolean getActivarFK_IdVehiculoServicioTransporte() {
		return this.activarFK_IdVehiculoServicioTransporte;
	}

	public void setActivarFK_IdVehiculoServicioTransporte(Boolean habilitarResaltar) {
		this.activarFK_IdVehiculoServicioTransporte= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteServicioTransporte=null;

	public Border getResaltarFK_IdClienteServicioTransporte() {
		return this.resaltarFK_IdClienteServicioTransporte;
	}

	public void setResaltarFK_IdClienteServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdClienteServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdClienteServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdClienteProveedorServicioTransporte=null;

	public Border getResaltarFK_IdClienteProveedorServicioTransporte() {
		return this.resaltarFK_IdClienteProveedorServicioTransporte;
	}

	public void setResaltarFK_IdClienteProveedorServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdClienteProveedorServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdClienteProveedorServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteProveedorServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdDetalleActivoFijoServicioTransporte=null;

	public Border getResaltarFK_IdDetalleActivoFijoServicioTransporte() {
		return this.resaltarFK_IdDetalleActivoFijoServicioTransporte;
	}

	public void setResaltarFK_IdDetalleActivoFijoServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdDetalleActivoFijoServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdDetalleActivoFijoServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleActivoFijoServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioServicioTransporte=null;

	public Border getResaltarFK_IdEjercicioServicioTransporte() {
		return this.resaltarFK_IdEjercicioServicioTransporte;
	}

	public void setResaltarFK_IdEjercicioServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdEjercicioServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaServicioTransporte=null;

	public Border getResaltarFK_IdEmpresaServicioTransporte() {
		return this.resaltarFK_IdEmpresaServicioTransporte;
	}

	public void setResaltarFK_IdEmpresaServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdEmpresaServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoServicioTransporte=null;

	public Border getResaltarFK_IdPeriodoServicioTransporte() {
		return this.resaltarFK_IdPeriodoServicioTransporte;
	}

	public void setResaltarFK_IdPeriodoServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdPeriodoServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdRutaTransporteServicioTransporte=null;

	public Border getResaltarFK_IdRutaTransporteServicioTransporte() {
		return this.resaltarFK_IdRutaTransporteServicioTransporte;
	}

	public void setResaltarFK_IdRutaTransporteServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdRutaTransporteServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdRutaTransporteServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRutaTransporteServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdSucursalServicioTransporte=null;

	public Border getResaltarFK_IdSucursalServicioTransporte() {
		return this.resaltarFK_IdSucursalServicioTransporte;
	}

	public void setResaltarFK_IdSucursalServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdSucursalServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdSucursalServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdTransportistaServicioTransporte=null;

	public Border getResaltarFK_IdTransportistaServicioTransporte() {
		return this.resaltarFK_IdTransportistaServicioTransporte;
	}

	public void setResaltarFK_IdTransportistaServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdTransportistaServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdTransportistaServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransportistaServicioTransporte= borderResaltar;
	}

	public Border resaltarFK_IdVehiculoServicioTransporte=null;

	public Border getResaltarFK_IdVehiculoServicioTransporte() {
		return this.resaltarFK_IdVehiculoServicioTransporte;
	}

	public void setResaltarFK_IdVehiculoServicioTransporte(Border borderResaltar) {
		this.resaltarFK_IdVehiculoServicioTransporte= borderResaltar;
	}

	public void setResaltarFK_IdVehiculoServicioTransporte(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioTransporteBeanSwingJInternalFrame serviciotransporteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVehiculoServicioTransporte= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}