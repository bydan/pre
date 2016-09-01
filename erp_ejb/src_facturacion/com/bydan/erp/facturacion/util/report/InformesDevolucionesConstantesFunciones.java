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
package com.bydan.erp.facturacion.util.report;

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


import com.bydan.erp.facturacion.util.report.InformesDevolucionesConstantesFunciones;
import com.bydan.erp.facturacion.util.report.InformesDevolucionesParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.InformesDevolucionesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class InformesDevolucionesConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="InformesDevoluciones";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="InformesDevoluciones"+InformesDevolucionesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="InformesDevolucionesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="InformesDevolucionesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=InformesDevolucionesConstantesFunciones.SCHEMA+"_"+InformesDevolucionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/InformesDevolucionesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=InformesDevolucionesConstantesFunciones.SCHEMA+"_"+InformesDevolucionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=InformesDevolucionesConstantesFunciones.SCHEMA+"_"+InformesDevolucionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/InformesDevolucionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=InformesDevolucionesConstantesFunciones.SCHEMA+"_"+InformesDevolucionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformesDevolucionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/InformesDevolucionesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformesDevolucionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformesDevolucionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/InformesDevolucionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+InformesDevolucionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=InformesDevolucionesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+InformesDevolucionesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=InformesDevolucionesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+InformesDevolucionesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Informes Devolucioneses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Informes Devoluciones";
	public static final String SCLASSWEBTITULO_LOWER="Informes Devoluciones";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="InformesDevoluciones";
	public static final String OBJECTNAME="informesdevoluciones";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="informes_devoluciones";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select informesdevoluciones from "+InformesDevolucionesConstantesFunciones.SPERSISTENCENAME+" informesdevoluciones";
	public static String QUERYSELECTNATIVE="select "+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".id,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".version_row,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".id_producto,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".id_tipo_devolucion_empresa,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".id_empresa,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".id_sucursal,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".fecha_emision_desde,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".user_name_usuario,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".numero_pre_impreso,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".fecha_emision,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".nombre_bodega,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".nombre_producto,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".nombre_tipo_devolucion_empresa,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".cantidad,"+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME+".codigo_producto from "+InformesDevolucionesConstantesFunciones.SCHEMA+"."+InformesDevolucionesConstantesFunciones.TABLENAME;//+" as "+InformesDevolucionesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDTIPODEVOLUCIONEMPRESA= "id_tipo_devolucion_empresa";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String USERNAMEUSUARIO= "user_name_usuario";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NOMBREBODEGA= "nombre_bodega";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String NOMBRETIPODEVOLUCIONEMPRESA= "nombre_tipo_devolucion_empresa";
    public static final String CANTIDAD= "cantidad";
    public static final String CODIGOPRODUCTO= "codigo_producto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDTIPODEVOLUCIONEMPRESA= "Tipo Devolucion Empresa";
		public static final String LABEL_IDTIPODEVOLUCIONEMPRESA_LOWER= "Tipo Devolucion Empresa";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_USERNAMEUSUARIO= "User Name Usuario";
		public static final String LABEL_USERNAMEUSUARIO_LOWER= "User Name Usuario";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NOMBREBODEGA= "Nombre Bodega";
		public static final String LABEL_NOMBREBODEGA_LOWER= "Nombre Bodega";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_NOMBRETIPODEVOLUCIONEMPRESA= "Nombre Tipo Devolucion Empresa";
		public static final String LABEL_NOMBRETIPODEVOLUCIONEMPRESA_LOWER= "Nombre Tipo Devolucion Empresa";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXUSER_NAME_USUARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXUSER_NAME_USUARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNOMBRE_BODEGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BODEGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TIPO_DEVOLUCION_EMPRESA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_DEVOLUCION_EMPRESA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getInformesDevolucionesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.IDPRODUCTO)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.IDTIPODEVOLUCIONEMPRESA)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.IDEMPRESA)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.IDSUCURSAL)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.USERNAMEUSUARIO)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_USERNAMEUSUARIO;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.FECHAEMISION)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.NOMBREBODEGA)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_NOMBREBODEGA;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.NOMBRETIPODEVOLUCIONEMPRESA)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_NOMBRETIPODEVOLUCIONEMPRESA;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.CANTIDAD)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(InformesDevolucionesConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=InformesDevolucionesConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getInformesDevolucionesDescripcion(InformesDevoluciones informesdevoluciones) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(informesdevoluciones !=null/* && informesdevoluciones.getId()!=0*/) {
			if(informesdevoluciones.getId()!=null) {
				sDescripcion=informesdevoluciones.getId().toString();
			}//informesdevolucionesinformesdevoluciones.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getInformesDevolucionesDescripcionDetallado(InformesDevoluciones informesdevoluciones) {
		String sDescripcion="";
			
		sDescripcion+=InformesDevolucionesConstantesFunciones.ID+"=";
		sDescripcion+=informesdevoluciones.getId().toString()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=informesdevoluciones.getVersionRow().toString()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=informesdevoluciones.getid_producto().toString()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.IDTIPODEVOLUCIONEMPRESA+"=";
		sDescripcion+=informesdevoluciones.getid_tipo_devolucion_empresa().toString()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=informesdevoluciones.getid_empresa().toString()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=informesdevoluciones.getid_sucursal().toString()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=informesdevoluciones.getfecha_emision_desde().toString()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=informesdevoluciones.getfecha_emision_hasta().toString()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.USERNAMEUSUARIO+"=";
		sDescripcion+=informesdevoluciones.getuser_name_usuario()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=informesdevoluciones.getnombre_completo_cliente()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=informesdevoluciones.getnumero_pre_impreso()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=informesdevoluciones.getfecha_emision().toString()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.NOMBREBODEGA+"=";
		sDescripcion+=informesdevoluciones.getnombre_bodega()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=informesdevoluciones.getnombre_producto()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.NOMBRETIPODEVOLUCIONEMPRESA+"=";
		sDescripcion+=informesdevoluciones.getnombre_tipo_devolucion_empresa()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=informesdevoluciones.getcantidad().toString()+",";
		sDescripcion+=InformesDevolucionesConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=informesdevoluciones.getcodigo_producto()+",";
			
		return sDescripcion;
	}
	
	public static void setInformesDevolucionesDescripcion(InformesDevoluciones informesdevoluciones,String sValor) throws Exception {			
		if(informesdevoluciones !=null) {
			//informesdevolucionesinformesdevoluciones.getId().toString();
		}		
	}
	
		

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}

	public static String getTipoDevolucionEmpresaDescripcion(TipoDevolucionEmpresa tipodevolucionempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodevolucionempresa!=null/*&&tipodevolucionempresa.getId()>0*/) {
			sDescripcion=TipoDevolucionEmpresaConstantesFunciones.getTipoDevolucionEmpresaDescripcion(tipodevolucionempresa);
		}

		return sDescripcion;
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaInformesDevoluciones")) {
			sNombreIndice="Tipo=  Por Producto Por Tipo Devolucion Empresa Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDevolucionEmpresa")) {
			sNombreIndice="Tipo=  Por Tipo Devolucion Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaInformesDevoluciones(Long id_producto,Long id_tipo_devolucion_empresa,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();}
		if(id_tipo_devolucion_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Devolucion Empresa="+id_tipo_devolucion_empresa.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDevolucionEmpresa(Long id_tipo_devolucion_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_devolucion_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Devolucion Empresa="+id_tipo_devolucion_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosInformesDevoluciones(InformesDevoluciones informesdevoluciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		informesdevoluciones.setuser_name_usuario(informesdevoluciones.getuser_name_usuario().trim());
		informesdevoluciones.setnombre_completo_cliente(informesdevoluciones.getnombre_completo_cliente().trim());
		informesdevoluciones.setnumero_pre_impreso(informesdevoluciones.getnumero_pre_impreso().trim());
		informesdevoluciones.setnombre_bodega(informesdevoluciones.getnombre_bodega().trim());
		informesdevoluciones.setnombre_producto(informesdevoluciones.getnombre_producto().trim());
		informesdevoluciones.setnombre_tipo_devolucion_empresa(informesdevoluciones.getnombre_tipo_devolucion_empresa().trim());
		informesdevoluciones.setcodigo_producto(informesdevoluciones.getcodigo_producto().trim());
	}
	
	public static void quitarEspaciosInformesDevolucioness(List<InformesDevoluciones> informesdevolucioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(InformesDevoluciones informesdevoluciones: informesdevolucioness) {
			informesdevoluciones.setuser_name_usuario(informesdevoluciones.getuser_name_usuario().trim());
			informesdevoluciones.setnombre_completo_cliente(informesdevoluciones.getnombre_completo_cliente().trim());
			informesdevoluciones.setnumero_pre_impreso(informesdevoluciones.getnumero_pre_impreso().trim());
			informesdevoluciones.setnombre_bodega(informesdevoluciones.getnombre_bodega().trim());
			informesdevoluciones.setnombre_producto(informesdevoluciones.getnombre_producto().trim());
			informesdevoluciones.setnombre_tipo_devolucion_empresa(informesdevoluciones.getnombre_tipo_devolucion_empresa().trim());
			informesdevoluciones.setcodigo_producto(informesdevoluciones.getcodigo_producto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresInformesDevoluciones(InformesDevoluciones informesdevoluciones,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && informesdevoluciones.getConCambioAuxiliar()) {
			informesdevoluciones.setIsDeleted(informesdevoluciones.getIsDeletedAuxiliar());	
			informesdevoluciones.setIsNew(informesdevoluciones.getIsNewAuxiliar());	
			informesdevoluciones.setIsChanged(informesdevoluciones.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			informesdevoluciones.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			informesdevoluciones.setIsDeletedAuxiliar(false);	
			informesdevoluciones.setIsNewAuxiliar(false);	
			informesdevoluciones.setIsChangedAuxiliar(false);
			
			informesdevoluciones.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresInformesDevolucioness(List<InformesDevoluciones> informesdevolucioness,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(InformesDevoluciones informesdevoluciones : informesdevolucioness) {
			if(conAsignarBase && informesdevoluciones.getConCambioAuxiliar()) {
				informesdevoluciones.setIsDeleted(informesdevoluciones.getIsDeletedAuxiliar());	
				informesdevoluciones.setIsNew(informesdevoluciones.getIsNewAuxiliar());	
				informesdevoluciones.setIsChanged(informesdevoluciones.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				informesdevoluciones.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				informesdevoluciones.setIsDeletedAuxiliar(false);	
				informesdevoluciones.setIsNewAuxiliar(false);	
				informesdevoluciones.setIsChangedAuxiliar(false);
				
				informesdevoluciones.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresInformesDevoluciones(InformesDevoluciones informesdevoluciones,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			informesdevoluciones.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresInformesDevolucioness(List<InformesDevoluciones> informesdevolucioness,Boolean conEnteros) throws Exception  {
		
		for(InformesDevoluciones informesdevoluciones: informesdevolucioness) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				informesdevoluciones.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaInformesDevoluciones(List<InformesDevoluciones> informesdevolucioness,InformesDevoluciones informesdevolucionesAux) throws Exception  {
		InformesDevolucionesConstantesFunciones.InicializarValoresInformesDevoluciones(informesdevolucionesAux,true);
		
		for(InformesDevoluciones informesdevoluciones: informesdevolucioness) {
			if(informesdevoluciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			informesdevolucionesAux.setcantidad(informesdevolucionesAux.getcantidad()+informesdevoluciones.getcantidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesInformesDevoluciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=InformesDevolucionesConstantesFunciones.getArrayColumnasGlobalesInformesDevoluciones(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesInformesDevoluciones(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(InformesDevolucionesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(InformesDevolucionesConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(InformesDevolucionesConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(InformesDevolucionesConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoInformesDevoluciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<InformesDevoluciones> informesdevolucioness,InformesDevoluciones informesdevoluciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(InformesDevoluciones informesdevolucionesAux: informesdevolucioness) {
			if(informesdevolucionesAux!=null && informesdevoluciones!=null) {
				if((informesdevolucionesAux.getId()==null && informesdevoluciones.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(informesdevolucionesAux.getId()!=null && informesdevoluciones.getId()!=null){
					if(informesdevolucionesAux.getId().equals(informesdevoluciones.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaInformesDevoluciones(List<InformesDevoluciones> informesdevolucioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(InformesDevoluciones informesdevoluciones: informesdevolucioness) {			
			if(informesdevoluciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaInformesDevoluciones() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,InformesDevolucionesConstantesFunciones.LABEL_ID, InformesDevolucionesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformesDevolucionesConstantesFunciones.LABEL_VERSIONROW, InformesDevolucionesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformesDevolucionesConstantesFunciones.LABEL_USERNAMEUSUARIO, InformesDevolucionesConstantesFunciones.USERNAMEUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformesDevolucionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, InformesDevolucionesConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformesDevolucionesConstantesFunciones.LABEL_NUMEROPREIMPRESO, InformesDevolucionesConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformesDevolucionesConstantesFunciones.LABEL_FECHAEMISION, InformesDevolucionesConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformesDevolucionesConstantesFunciones.LABEL_NOMBREBODEGA, InformesDevolucionesConstantesFunciones.NOMBREBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformesDevolucionesConstantesFunciones.LABEL_NOMBREPRODUCTO, InformesDevolucionesConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformesDevolucionesConstantesFunciones.LABEL_NOMBRETIPODEVOLUCIONEMPRESA, InformesDevolucionesConstantesFunciones.NOMBRETIPODEVOLUCIONEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformesDevolucionesConstantesFunciones.LABEL_CANTIDAD, InformesDevolucionesConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,InformesDevolucionesConstantesFunciones.LABEL_CODIGOPRODUCTO, InformesDevolucionesConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasInformesDevoluciones() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=InformesDevolucionesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformesDevolucionesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformesDevolucionesConstantesFunciones.USERNAMEUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformesDevolucionesConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformesDevolucionesConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformesDevolucionesConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformesDevolucionesConstantesFunciones.NOMBREBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformesDevolucionesConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformesDevolucionesConstantesFunciones.NOMBRETIPODEVOLUCIONEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformesDevolucionesConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=InformesDevolucionesConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInformesDevoluciones() throws Exception  {
		return InformesDevolucionesConstantesFunciones.getTiposSeleccionarInformesDevoluciones(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInformesDevoluciones(Boolean conFk) throws Exception  {
		return InformesDevolucionesConstantesFunciones.getTiposSeleccionarInformesDevoluciones(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarInformesDevoluciones(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_USERNAMEUSUARIO);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_USERNAMEUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_NOMBREBODEGA);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_NOMBREBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_NOMBRETIPODEVOLUCIONEMPRESA);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_NOMBRETIPODEVOLUCIONEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(InformesDevolucionesConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(InformesDevolucionesConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesInformesDevoluciones(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesInformesDevoluciones(InformesDevoluciones informesdevolucionesAux) throws Exception {
		
			informesdevolucionesAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(informesdevolucionesAux.getProducto()));
			informesdevolucionesAux.settipodevolucionempresa_descripcion(TipoDevolucionEmpresaConstantesFunciones.getTipoDevolucionEmpresaDescripcion(informesdevolucionesAux.getTipoDevolucionEmpresa()));
			informesdevolucionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(informesdevolucionesAux.getEmpresa()));
			informesdevolucionesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(informesdevolucionesAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesInformesDevoluciones(List<InformesDevoluciones> informesdevolucionessTemp) throws Exception {
		for(InformesDevoluciones informesdevolucionesAux:informesdevolucionessTemp) {
			
			informesdevolucionesAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(informesdevolucionesAux.getProducto()));
			informesdevolucionesAux.settipodevolucionempresa_descripcion(TipoDevolucionEmpresaConstantesFunciones.getTipoDevolucionEmpresaDescripcion(informesdevolucionesAux.getTipoDevolucionEmpresa()));
			informesdevolucionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(informesdevolucionesAux.getEmpresa()));
			informesdevolucionesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(informesdevolucionesAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfInformesDevoluciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(TipoDevolucionEmpresa.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
						classes.add(new Classe(TipoDevolucionEmpresa.class));
					}
				}

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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfInformesDevoluciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(TipoDevolucionEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDevolucionEmpresa.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(TipoDevolucionEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDevolucionEmpresa.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfInformesDevoluciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return InformesDevolucionesConstantesFunciones.getClassesRelationshipsOfInformesDevoluciones(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfInformesDevoluciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfInformesDevoluciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return InformesDevolucionesConstantesFunciones.getClassesRelationshipsFromStringsOfInformesDevoluciones(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfInformesDevoluciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(InformesDevoluciones informesdevoluciones,List<InformesDevoluciones> informesdevolucioness,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(InformesDevoluciones informesdevoluciones,List<InformesDevoluciones> informesdevolucioness) throws Exception {
		try	{			
			for(InformesDevoluciones informesdevolucionesLocal:informesdevolucioness) {
				if(informesdevolucionesLocal.getId().equals(informesdevoluciones.getId())) {
					informesdevolucionesLocal.setIsSelected(informesdevoluciones.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesInformesDevoluciones(List<InformesDevoluciones> informesdevolucionessAux) throws Exception {
		//this.informesdevolucionessAux=informesdevolucionessAux;
		
		for(InformesDevoluciones informesdevolucionesAux:informesdevolucionessAux) {
			if(informesdevolucionesAux.getIsChanged()) {
				informesdevolucionesAux.setIsChanged(false);
			}		
			
			if(informesdevolucionesAux.getIsNew()) {
				informesdevolucionesAux.setIsNew(false);
			}	
			
			if(informesdevolucionesAux.getIsDeleted()) {
				informesdevolucionesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesInformesDevoluciones(InformesDevoluciones informesdevolucionesAux) throws Exception {
		//this.informesdevolucionesAux=informesdevolucionesAux;
		
			if(informesdevolucionesAux.getIsChanged()) {
				informesdevolucionesAux.setIsChanged(false);
			}		
			
			if(informesdevolucionesAux.getIsNew()) {
				informesdevolucionesAux.setIsNew(false);
			}	
			
			if(informesdevolucionesAux.getIsDeleted()) {
				informesdevolucionesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(InformesDevoluciones informesdevolucionesAsignar,InformesDevoluciones informesdevoluciones) throws Exception {
		informesdevolucionesAsignar.setId(informesdevoluciones.getId());	
		informesdevolucionesAsignar.setVersionRow(informesdevoluciones.getVersionRow());	
		informesdevolucionesAsignar.setuser_name_usuario(informesdevoluciones.getuser_name_usuario());	
		informesdevolucionesAsignar.setnombre_completo_cliente(informesdevoluciones.getnombre_completo_cliente());	
		informesdevolucionesAsignar.setnumero_pre_impreso(informesdevoluciones.getnumero_pre_impreso());	
		informesdevolucionesAsignar.setfecha_emision(informesdevoluciones.getfecha_emision());	
		informesdevolucionesAsignar.setnombre_bodega(informesdevoluciones.getnombre_bodega());	
		informesdevolucionesAsignar.setnombre_producto(informesdevoluciones.getnombre_producto());	
		informesdevolucionesAsignar.setnombre_tipo_devolucion_empresa(informesdevoluciones.getnombre_tipo_devolucion_empresa());	
		informesdevolucionesAsignar.setcantidad(informesdevoluciones.getcantidad());	
		informesdevolucionesAsignar.setcodigo_producto(informesdevoluciones.getcodigo_producto());	
	}
	
	public static void inicializarInformesDevoluciones(InformesDevoluciones informesdevoluciones) throws Exception {
		try {
				informesdevoluciones.setId(0L);	
					
				informesdevoluciones.setuser_name_usuario("");	
				informesdevoluciones.setnombre_completo_cliente("");	
				informesdevoluciones.setnumero_pre_impreso("");	
				informesdevoluciones.setfecha_emision(new Date());	
				informesdevoluciones.setnombre_bodega("");	
				informesdevoluciones.setnombre_producto("");	
				informesdevoluciones.setnombre_tipo_devolucion_empresa("");	
				informesdevoluciones.setcantidad(0);	
				informesdevoluciones.setcodigo_producto("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderInformesDevoluciones(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_IDTIPODEVOLUCIONEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_USERNAMEUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_NOMBREBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_NOMBRETIPODEVOLUCIONEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(InformesDevolucionesConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataInformesDevoluciones(String sTipo,Row row,Workbook workbook,InformesDevoluciones informesdevoluciones,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.gettipodevolucionempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getuser_name_usuario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getnombre_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getnombre_tipo_devolucion_empresa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(informesdevoluciones.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryInformesDevoluciones="";
	
	public String getsFinalQueryInformesDevoluciones() {
		return this.sFinalQueryInformesDevoluciones;
	}
	
	public void setsFinalQueryInformesDevoluciones(String sFinalQueryInformesDevoluciones) {
		this.sFinalQueryInformesDevoluciones= sFinalQueryInformesDevoluciones;
	}
	
	public Border resaltarSeleccionarInformesDevoluciones=null;
	
	public Border setResaltarSeleccionarInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarSeleccionarInformesDevoluciones= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarInformesDevoluciones() {
		return this.resaltarSeleccionarInformesDevoluciones;
	}
	
	public void setResaltarSeleccionarInformesDevoluciones(Border borderResaltarSeleccionarInformesDevoluciones) {
		this.resaltarSeleccionarInformesDevoluciones= borderResaltarSeleccionarInformesDevoluciones;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridInformesDevoluciones=null;
	public Boolean mostraridInformesDevoluciones=true;
	public Boolean activaridInformesDevoluciones=true;

	public Border resaltarid_productoInformesDevoluciones=null;
	public Boolean mostrarid_productoInformesDevoluciones=true;
	public Boolean activarid_productoInformesDevoluciones=true;
	public Boolean cargarid_productoInformesDevoluciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoInformesDevoluciones=false;//ConEventDepend=true

	public Border resaltarid_tipo_devolucion_empresaInformesDevoluciones=null;
	public Boolean mostrarid_tipo_devolucion_empresaInformesDevoluciones=true;
	public Boolean activarid_tipo_devolucion_empresaInformesDevoluciones=true;
	public Boolean cargarid_tipo_devolucion_empresaInformesDevoluciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_devolucion_empresaInformesDevoluciones=false;//ConEventDepend=true

	public Border resaltarid_empresaInformesDevoluciones=null;
	public Boolean mostrarid_empresaInformesDevoluciones=true;
	public Boolean activarid_empresaInformesDevoluciones=true;
	public Boolean cargarid_empresaInformesDevoluciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaInformesDevoluciones=false;//ConEventDepend=true

	public Border resaltarid_sucursalInformesDevoluciones=null;
	public Boolean mostrarid_sucursalInformesDevoluciones=true;
	public Boolean activarid_sucursalInformesDevoluciones=true;
	public Boolean cargarid_sucursalInformesDevoluciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalInformesDevoluciones=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeInformesDevoluciones=null;
	public Boolean mostrarfecha_emision_desdeInformesDevoluciones=true;
	public Boolean activarfecha_emision_desdeInformesDevoluciones=true;

	public Border resaltarfecha_emision_hastaInformesDevoluciones=null;
	public Boolean mostrarfecha_emision_hastaInformesDevoluciones=true;
	public Boolean activarfecha_emision_hastaInformesDevoluciones=true;

	public Border resaltaruser_name_usuarioInformesDevoluciones=null;
	public Boolean mostraruser_name_usuarioInformesDevoluciones=true;
	public Boolean activaruser_name_usuarioInformesDevoluciones=true;

	public Border resaltarnombre_completo_clienteInformesDevoluciones=null;
	public Boolean mostrarnombre_completo_clienteInformesDevoluciones=true;
	public Boolean activarnombre_completo_clienteInformesDevoluciones=true;

	public Border resaltarnumero_pre_impresoInformesDevoluciones=null;
	public Boolean mostrarnumero_pre_impresoInformesDevoluciones=true;
	public Boolean activarnumero_pre_impresoInformesDevoluciones=true;

	public Border resaltarfecha_emisionInformesDevoluciones=null;
	public Boolean mostrarfecha_emisionInformesDevoluciones=true;
	public Boolean activarfecha_emisionInformesDevoluciones=true;

	public Border resaltarnombre_bodegaInformesDevoluciones=null;
	public Boolean mostrarnombre_bodegaInformesDevoluciones=true;
	public Boolean activarnombre_bodegaInformesDevoluciones=true;

	public Border resaltarnombre_productoInformesDevoluciones=null;
	public Boolean mostrarnombre_productoInformesDevoluciones=true;
	public Boolean activarnombre_productoInformesDevoluciones=true;

	public Border resaltarnombre_tipo_devolucion_empresaInformesDevoluciones=null;
	public Boolean mostrarnombre_tipo_devolucion_empresaInformesDevoluciones=true;
	public Boolean activarnombre_tipo_devolucion_empresaInformesDevoluciones=true;

	public Border resaltarcantidadInformesDevoluciones=null;
	public Boolean mostrarcantidadInformesDevoluciones=true;
	public Boolean activarcantidadInformesDevoluciones=true;

	public Border resaltarcodigo_productoInformesDevoluciones=null;
	public Boolean mostrarcodigo_productoInformesDevoluciones=true;
	public Boolean activarcodigo_productoInformesDevoluciones=true;

	
	

	public Border setResaltaridInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltaridInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridInformesDevoluciones() {
		return this.resaltaridInformesDevoluciones;
	}

	public void setResaltaridInformesDevoluciones(Border borderResaltar) {
		this.resaltaridInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostraridInformesDevoluciones() {
		return this.mostraridInformesDevoluciones;
	}

	public void setMostraridInformesDevoluciones(Boolean mostraridInformesDevoluciones) {
		this.mostraridInformesDevoluciones= mostraridInformesDevoluciones;
	}

	public Boolean getActivaridInformesDevoluciones() {
		return this.activaridInformesDevoluciones;
	}

	public void setActivaridInformesDevoluciones(Boolean activaridInformesDevoluciones) {
		this.activaridInformesDevoluciones= activaridInformesDevoluciones;
	}

	public Border setResaltarid_productoInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarid_productoInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoInformesDevoluciones() {
		return this.resaltarid_productoInformesDevoluciones;
	}

	public void setResaltarid_productoInformesDevoluciones(Border borderResaltar) {
		this.resaltarid_productoInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarid_productoInformesDevoluciones() {
		return this.mostrarid_productoInformesDevoluciones;
	}

	public void setMostrarid_productoInformesDevoluciones(Boolean mostrarid_productoInformesDevoluciones) {
		this.mostrarid_productoInformesDevoluciones= mostrarid_productoInformesDevoluciones;
	}

	public Boolean getActivarid_productoInformesDevoluciones() {
		return this.activarid_productoInformesDevoluciones;
	}

	public void setActivarid_productoInformesDevoluciones(Boolean activarid_productoInformesDevoluciones) {
		this.activarid_productoInformesDevoluciones= activarid_productoInformesDevoluciones;
	}

	public Boolean getCargarid_productoInformesDevoluciones() {
		return this.cargarid_productoInformesDevoluciones;
	}

	public void setCargarid_productoInformesDevoluciones(Boolean cargarid_productoInformesDevoluciones) {
		this.cargarid_productoInformesDevoluciones= cargarid_productoInformesDevoluciones;
	}

	public Border setResaltarid_tipo_devolucion_empresaInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarid_tipo_devolucion_empresaInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_devolucion_empresaInformesDevoluciones() {
		return this.resaltarid_tipo_devolucion_empresaInformesDevoluciones;
	}

	public void setResaltarid_tipo_devolucion_empresaInformesDevoluciones(Border borderResaltar) {
		this.resaltarid_tipo_devolucion_empresaInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarid_tipo_devolucion_empresaInformesDevoluciones() {
		return this.mostrarid_tipo_devolucion_empresaInformesDevoluciones;
	}

	public void setMostrarid_tipo_devolucion_empresaInformesDevoluciones(Boolean mostrarid_tipo_devolucion_empresaInformesDevoluciones) {
		this.mostrarid_tipo_devolucion_empresaInformesDevoluciones= mostrarid_tipo_devolucion_empresaInformesDevoluciones;
	}

	public Boolean getActivarid_tipo_devolucion_empresaInformesDevoluciones() {
		return this.activarid_tipo_devolucion_empresaInformesDevoluciones;
	}

	public void setActivarid_tipo_devolucion_empresaInformesDevoluciones(Boolean activarid_tipo_devolucion_empresaInformesDevoluciones) {
		this.activarid_tipo_devolucion_empresaInformesDevoluciones= activarid_tipo_devolucion_empresaInformesDevoluciones;
	}

	public Boolean getCargarid_tipo_devolucion_empresaInformesDevoluciones() {
		return this.cargarid_tipo_devolucion_empresaInformesDevoluciones;
	}

	public void setCargarid_tipo_devolucion_empresaInformesDevoluciones(Boolean cargarid_tipo_devolucion_empresaInformesDevoluciones) {
		this.cargarid_tipo_devolucion_empresaInformesDevoluciones= cargarid_tipo_devolucion_empresaInformesDevoluciones;
	}

	public Border setResaltarid_empresaInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarid_empresaInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaInformesDevoluciones() {
		return this.resaltarid_empresaInformesDevoluciones;
	}

	public void setResaltarid_empresaInformesDevoluciones(Border borderResaltar) {
		this.resaltarid_empresaInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarid_empresaInformesDevoluciones() {
		return this.mostrarid_empresaInformesDevoluciones;
	}

	public void setMostrarid_empresaInformesDevoluciones(Boolean mostrarid_empresaInformesDevoluciones) {
		this.mostrarid_empresaInformesDevoluciones= mostrarid_empresaInformesDevoluciones;
	}

	public Boolean getActivarid_empresaInformesDevoluciones() {
		return this.activarid_empresaInformesDevoluciones;
	}

	public void setActivarid_empresaInformesDevoluciones(Boolean activarid_empresaInformesDevoluciones) {
		this.activarid_empresaInformesDevoluciones= activarid_empresaInformesDevoluciones;
	}

	public Boolean getCargarid_empresaInformesDevoluciones() {
		return this.cargarid_empresaInformesDevoluciones;
	}

	public void setCargarid_empresaInformesDevoluciones(Boolean cargarid_empresaInformesDevoluciones) {
		this.cargarid_empresaInformesDevoluciones= cargarid_empresaInformesDevoluciones;
	}

	public Border setResaltarid_sucursalInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarid_sucursalInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalInformesDevoluciones() {
		return this.resaltarid_sucursalInformesDevoluciones;
	}

	public void setResaltarid_sucursalInformesDevoluciones(Border borderResaltar) {
		this.resaltarid_sucursalInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarid_sucursalInformesDevoluciones() {
		return this.mostrarid_sucursalInformesDevoluciones;
	}

	public void setMostrarid_sucursalInformesDevoluciones(Boolean mostrarid_sucursalInformesDevoluciones) {
		this.mostrarid_sucursalInformesDevoluciones= mostrarid_sucursalInformesDevoluciones;
	}

	public Boolean getActivarid_sucursalInformesDevoluciones() {
		return this.activarid_sucursalInformesDevoluciones;
	}

	public void setActivarid_sucursalInformesDevoluciones(Boolean activarid_sucursalInformesDevoluciones) {
		this.activarid_sucursalInformesDevoluciones= activarid_sucursalInformesDevoluciones;
	}

	public Boolean getCargarid_sucursalInformesDevoluciones() {
		return this.cargarid_sucursalInformesDevoluciones;
	}

	public void setCargarid_sucursalInformesDevoluciones(Boolean cargarid_sucursalInformesDevoluciones) {
		this.cargarid_sucursalInformesDevoluciones= cargarid_sucursalInformesDevoluciones;
	}

	public Border setResaltarfecha_emision_desdeInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeInformesDevoluciones() {
		return this.resaltarfecha_emision_desdeInformesDevoluciones;
	}

	public void setResaltarfecha_emision_desdeInformesDevoluciones(Border borderResaltar) {
		this.resaltarfecha_emision_desdeInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeInformesDevoluciones() {
		return this.mostrarfecha_emision_desdeInformesDevoluciones;
	}

	public void setMostrarfecha_emision_desdeInformesDevoluciones(Boolean mostrarfecha_emision_desdeInformesDevoluciones) {
		this.mostrarfecha_emision_desdeInformesDevoluciones= mostrarfecha_emision_desdeInformesDevoluciones;
	}

	public Boolean getActivarfecha_emision_desdeInformesDevoluciones() {
		return this.activarfecha_emision_desdeInformesDevoluciones;
	}

	public void setActivarfecha_emision_desdeInformesDevoluciones(Boolean activarfecha_emision_desdeInformesDevoluciones) {
		this.activarfecha_emision_desdeInformesDevoluciones= activarfecha_emision_desdeInformesDevoluciones;
	}

	public Border setResaltarfecha_emision_hastaInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaInformesDevoluciones() {
		return this.resaltarfecha_emision_hastaInformesDevoluciones;
	}

	public void setResaltarfecha_emision_hastaInformesDevoluciones(Border borderResaltar) {
		this.resaltarfecha_emision_hastaInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaInformesDevoluciones() {
		return this.mostrarfecha_emision_hastaInformesDevoluciones;
	}

	public void setMostrarfecha_emision_hastaInformesDevoluciones(Boolean mostrarfecha_emision_hastaInformesDevoluciones) {
		this.mostrarfecha_emision_hastaInformesDevoluciones= mostrarfecha_emision_hastaInformesDevoluciones;
	}

	public Boolean getActivarfecha_emision_hastaInformesDevoluciones() {
		return this.activarfecha_emision_hastaInformesDevoluciones;
	}

	public void setActivarfecha_emision_hastaInformesDevoluciones(Boolean activarfecha_emision_hastaInformesDevoluciones) {
		this.activarfecha_emision_hastaInformesDevoluciones= activarfecha_emision_hastaInformesDevoluciones;
	}

	public Border setResaltaruser_name_usuarioInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltaruser_name_usuarioInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaruser_name_usuarioInformesDevoluciones() {
		return this.resaltaruser_name_usuarioInformesDevoluciones;
	}

	public void setResaltaruser_name_usuarioInformesDevoluciones(Border borderResaltar) {
		this.resaltaruser_name_usuarioInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostraruser_name_usuarioInformesDevoluciones() {
		return this.mostraruser_name_usuarioInformesDevoluciones;
	}

	public void setMostraruser_name_usuarioInformesDevoluciones(Boolean mostraruser_name_usuarioInformesDevoluciones) {
		this.mostraruser_name_usuarioInformesDevoluciones= mostraruser_name_usuarioInformesDevoluciones;
	}

	public Boolean getActivaruser_name_usuarioInformesDevoluciones() {
		return this.activaruser_name_usuarioInformesDevoluciones;
	}

	public void setActivaruser_name_usuarioInformesDevoluciones(Boolean activaruser_name_usuarioInformesDevoluciones) {
		this.activaruser_name_usuarioInformesDevoluciones= activaruser_name_usuarioInformesDevoluciones;
	}

	public Border setResaltarnombre_completo_clienteInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteInformesDevoluciones() {
		return this.resaltarnombre_completo_clienteInformesDevoluciones;
	}

	public void setResaltarnombre_completo_clienteInformesDevoluciones(Border borderResaltar) {
		this.resaltarnombre_completo_clienteInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteInformesDevoluciones() {
		return this.mostrarnombre_completo_clienteInformesDevoluciones;
	}

	public void setMostrarnombre_completo_clienteInformesDevoluciones(Boolean mostrarnombre_completo_clienteInformesDevoluciones) {
		this.mostrarnombre_completo_clienteInformesDevoluciones= mostrarnombre_completo_clienteInformesDevoluciones;
	}

	public Boolean getActivarnombre_completo_clienteInformesDevoluciones() {
		return this.activarnombre_completo_clienteInformesDevoluciones;
	}

	public void setActivarnombre_completo_clienteInformesDevoluciones(Boolean activarnombre_completo_clienteInformesDevoluciones) {
		this.activarnombre_completo_clienteInformesDevoluciones= activarnombre_completo_clienteInformesDevoluciones;
	}

	public Border setResaltarnumero_pre_impresoInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoInformesDevoluciones() {
		return this.resaltarnumero_pre_impresoInformesDevoluciones;
	}

	public void setResaltarnumero_pre_impresoInformesDevoluciones(Border borderResaltar) {
		this.resaltarnumero_pre_impresoInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoInformesDevoluciones() {
		return this.mostrarnumero_pre_impresoInformesDevoluciones;
	}

	public void setMostrarnumero_pre_impresoInformesDevoluciones(Boolean mostrarnumero_pre_impresoInformesDevoluciones) {
		this.mostrarnumero_pre_impresoInformesDevoluciones= mostrarnumero_pre_impresoInformesDevoluciones;
	}

	public Boolean getActivarnumero_pre_impresoInformesDevoluciones() {
		return this.activarnumero_pre_impresoInformesDevoluciones;
	}

	public void setActivarnumero_pre_impresoInformesDevoluciones(Boolean activarnumero_pre_impresoInformesDevoluciones) {
		this.activarnumero_pre_impresoInformesDevoluciones= activarnumero_pre_impresoInformesDevoluciones;
	}

	public Border setResaltarfecha_emisionInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionInformesDevoluciones() {
		return this.resaltarfecha_emisionInformesDevoluciones;
	}

	public void setResaltarfecha_emisionInformesDevoluciones(Border borderResaltar) {
		this.resaltarfecha_emisionInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionInformesDevoluciones() {
		return this.mostrarfecha_emisionInformesDevoluciones;
	}

	public void setMostrarfecha_emisionInformesDevoluciones(Boolean mostrarfecha_emisionInformesDevoluciones) {
		this.mostrarfecha_emisionInformesDevoluciones= mostrarfecha_emisionInformesDevoluciones;
	}

	public Boolean getActivarfecha_emisionInformesDevoluciones() {
		return this.activarfecha_emisionInformesDevoluciones;
	}

	public void setActivarfecha_emisionInformesDevoluciones(Boolean activarfecha_emisionInformesDevoluciones) {
		this.activarfecha_emisionInformesDevoluciones= activarfecha_emisionInformesDevoluciones;
	}

	public Border setResaltarnombre_bodegaInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarnombre_bodegaInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodegaInformesDevoluciones() {
		return this.resaltarnombre_bodegaInformesDevoluciones;
	}

	public void setResaltarnombre_bodegaInformesDevoluciones(Border borderResaltar) {
		this.resaltarnombre_bodegaInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarnombre_bodegaInformesDevoluciones() {
		return this.mostrarnombre_bodegaInformesDevoluciones;
	}

	public void setMostrarnombre_bodegaInformesDevoluciones(Boolean mostrarnombre_bodegaInformesDevoluciones) {
		this.mostrarnombre_bodegaInformesDevoluciones= mostrarnombre_bodegaInformesDevoluciones;
	}

	public Boolean getActivarnombre_bodegaInformesDevoluciones() {
		return this.activarnombre_bodegaInformesDevoluciones;
	}

	public void setActivarnombre_bodegaInformesDevoluciones(Boolean activarnombre_bodegaInformesDevoluciones) {
		this.activarnombre_bodegaInformesDevoluciones= activarnombre_bodegaInformesDevoluciones;
	}

	public Border setResaltarnombre_productoInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarnombre_productoInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoInformesDevoluciones() {
		return this.resaltarnombre_productoInformesDevoluciones;
	}

	public void setResaltarnombre_productoInformesDevoluciones(Border borderResaltar) {
		this.resaltarnombre_productoInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarnombre_productoInformesDevoluciones() {
		return this.mostrarnombre_productoInformesDevoluciones;
	}

	public void setMostrarnombre_productoInformesDevoluciones(Boolean mostrarnombre_productoInformesDevoluciones) {
		this.mostrarnombre_productoInformesDevoluciones= mostrarnombre_productoInformesDevoluciones;
	}

	public Boolean getActivarnombre_productoInformesDevoluciones() {
		return this.activarnombre_productoInformesDevoluciones;
	}

	public void setActivarnombre_productoInformesDevoluciones(Boolean activarnombre_productoInformesDevoluciones) {
		this.activarnombre_productoInformesDevoluciones= activarnombre_productoInformesDevoluciones;
	}

	public Border setResaltarnombre_tipo_devolucion_empresaInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_devolucion_empresaInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_devolucion_empresaInformesDevoluciones() {
		return this.resaltarnombre_tipo_devolucion_empresaInformesDevoluciones;
	}

	public void setResaltarnombre_tipo_devolucion_empresaInformesDevoluciones(Border borderResaltar) {
		this.resaltarnombre_tipo_devolucion_empresaInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_devolucion_empresaInformesDevoluciones() {
		return this.mostrarnombre_tipo_devolucion_empresaInformesDevoluciones;
	}

	public void setMostrarnombre_tipo_devolucion_empresaInformesDevoluciones(Boolean mostrarnombre_tipo_devolucion_empresaInformesDevoluciones) {
		this.mostrarnombre_tipo_devolucion_empresaInformesDevoluciones= mostrarnombre_tipo_devolucion_empresaInformesDevoluciones;
	}

	public Boolean getActivarnombre_tipo_devolucion_empresaInformesDevoluciones() {
		return this.activarnombre_tipo_devolucion_empresaInformesDevoluciones;
	}

	public void setActivarnombre_tipo_devolucion_empresaInformesDevoluciones(Boolean activarnombre_tipo_devolucion_empresaInformesDevoluciones) {
		this.activarnombre_tipo_devolucion_empresaInformesDevoluciones= activarnombre_tipo_devolucion_empresaInformesDevoluciones;
	}

	public Border setResaltarcantidadInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarcantidadInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadInformesDevoluciones() {
		return this.resaltarcantidadInformesDevoluciones;
	}

	public void setResaltarcantidadInformesDevoluciones(Border borderResaltar) {
		this.resaltarcantidadInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarcantidadInformesDevoluciones() {
		return this.mostrarcantidadInformesDevoluciones;
	}

	public void setMostrarcantidadInformesDevoluciones(Boolean mostrarcantidadInformesDevoluciones) {
		this.mostrarcantidadInformesDevoluciones= mostrarcantidadInformesDevoluciones;
	}

	public Boolean getActivarcantidadInformesDevoluciones() {
		return this.activarcantidadInformesDevoluciones;
	}

	public void setActivarcantidadInformesDevoluciones(Boolean activarcantidadInformesDevoluciones) {
		this.activarcantidadInformesDevoluciones= activarcantidadInformesDevoluciones;
	}

	public Border setResaltarcodigo_productoInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//informesdevolucionesBeanSwingJInternalFrame.jTtoolBarInformesDevoluciones.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoInformesDevoluciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoInformesDevoluciones() {
		return this.resaltarcodigo_productoInformesDevoluciones;
	}

	public void setResaltarcodigo_productoInformesDevoluciones(Border borderResaltar) {
		this.resaltarcodigo_productoInformesDevoluciones= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoInformesDevoluciones() {
		return this.mostrarcodigo_productoInformesDevoluciones;
	}

	public void setMostrarcodigo_productoInformesDevoluciones(Boolean mostrarcodigo_productoInformesDevoluciones) {
		this.mostrarcodigo_productoInformesDevoluciones= mostrarcodigo_productoInformesDevoluciones;
	}

	public Boolean getActivarcodigo_productoInformesDevoluciones() {
		return this.activarcodigo_productoInformesDevoluciones;
	}

	public void setActivarcodigo_productoInformesDevoluciones(Boolean activarcodigo_productoInformesDevoluciones) {
		this.activarcodigo_productoInformesDevoluciones= activarcodigo_productoInformesDevoluciones;
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
		
		
		this.setMostraridInformesDevoluciones(esInicial);
		this.setMostrarid_productoInformesDevoluciones(esInicial);
		this.setMostrarid_tipo_devolucion_empresaInformesDevoluciones(esInicial);
		this.setMostrarid_empresaInformesDevoluciones(esInicial);
		this.setMostrarid_sucursalInformesDevoluciones(esInicial);
		this.setMostrarfecha_emision_desdeInformesDevoluciones(esInicial);
		this.setMostrarfecha_emision_hastaInformesDevoluciones(esInicial);
		this.setMostraruser_name_usuarioInformesDevoluciones(esInicial);
		this.setMostrarnombre_completo_clienteInformesDevoluciones(esInicial);
		this.setMostrarnumero_pre_impresoInformesDevoluciones(esInicial);
		this.setMostrarfecha_emisionInformesDevoluciones(esInicial);
		this.setMostrarnombre_bodegaInformesDevoluciones(esInicial);
		this.setMostrarnombre_productoInformesDevoluciones(esInicial);
		this.setMostrarnombre_tipo_devolucion_empresaInformesDevoluciones(esInicial);
		this.setMostrarcantidadInformesDevoluciones(esInicial);
		this.setMostrarcodigo_productoInformesDevoluciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.ID)) {
				this.setMostraridInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.IDTIPODEVOLUCIONEMPRESA)) {
				this.setMostrarid_tipo_devolucion_empresaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.USERNAMEUSUARIO)) {
				this.setMostraruser_name_usuarioInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NOMBREBODEGA)) {
				this.setMostrarnombre_bodegaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NOMBRETIPODEVOLUCIONEMPRESA)) {
				this.setMostrarnombre_tipo_devolucion_empresaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoInformesDevoluciones(esAsigna);
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
		
		
		this.setActivaridInformesDevoluciones(esInicial);
		this.setActivarid_productoInformesDevoluciones(esInicial);
		this.setActivarid_tipo_devolucion_empresaInformesDevoluciones(esInicial);
		this.setActivarid_empresaInformesDevoluciones(esInicial);
		this.setActivarid_sucursalInformesDevoluciones(esInicial);
		this.setActivarfecha_emision_desdeInformesDevoluciones(esInicial);
		this.setActivarfecha_emision_hastaInformesDevoluciones(esInicial);
		this.setActivaruser_name_usuarioInformesDevoluciones(esInicial);
		this.setActivarnombre_completo_clienteInformesDevoluciones(esInicial);
		this.setActivarnumero_pre_impresoInformesDevoluciones(esInicial);
		this.setActivarfecha_emisionInformesDevoluciones(esInicial);
		this.setActivarnombre_bodegaInformesDevoluciones(esInicial);
		this.setActivarnombre_productoInformesDevoluciones(esInicial);
		this.setActivarnombre_tipo_devolucion_empresaInformesDevoluciones(esInicial);
		this.setActivarcantidadInformesDevoluciones(esInicial);
		this.setActivarcodigo_productoInformesDevoluciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.ID)) {
				this.setActivaridInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.IDTIPODEVOLUCIONEMPRESA)) {
				this.setActivarid_tipo_devolucion_empresaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.USERNAMEUSUARIO)) {
				this.setActivaruser_name_usuarioInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NOMBREBODEGA)) {
				this.setActivarnombre_bodegaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NOMBRETIPODEVOLUCIONEMPRESA)) {
				this.setActivarnombre_tipo_devolucion_empresaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoInformesDevoluciones(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridInformesDevoluciones(esInicial);
		this.setResaltarid_productoInformesDevoluciones(esInicial);
		this.setResaltarid_tipo_devolucion_empresaInformesDevoluciones(esInicial);
		this.setResaltarid_empresaInformesDevoluciones(esInicial);
		this.setResaltarid_sucursalInformesDevoluciones(esInicial);
		this.setResaltarfecha_emision_desdeInformesDevoluciones(esInicial);
		this.setResaltarfecha_emision_hastaInformesDevoluciones(esInicial);
		this.setResaltaruser_name_usuarioInformesDevoluciones(esInicial);
		this.setResaltarnombre_completo_clienteInformesDevoluciones(esInicial);
		this.setResaltarnumero_pre_impresoInformesDevoluciones(esInicial);
		this.setResaltarfecha_emisionInformesDevoluciones(esInicial);
		this.setResaltarnombre_bodegaInformesDevoluciones(esInicial);
		this.setResaltarnombre_productoInformesDevoluciones(esInicial);
		this.setResaltarnombre_tipo_devolucion_empresaInformesDevoluciones(esInicial);
		this.setResaltarcantidadInformesDevoluciones(esInicial);
		this.setResaltarcodigo_productoInformesDevoluciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.ID)) {
				this.setResaltaridInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.IDTIPODEVOLUCIONEMPRESA)) {
				this.setResaltarid_tipo_devolucion_empresaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.USERNAMEUSUARIO)) {
				this.setResaltaruser_name_usuarioInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NOMBREBODEGA)) {
				this.setResaltarnombre_bodegaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.NOMBRETIPODEVOLUCIONEMPRESA)) {
				this.setResaltarnombre_tipo_devolucion_empresaInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadInformesDevoluciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(InformesDevolucionesConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoInformesDevoluciones(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaInformesDevolucionesInformesDevoluciones=true;

	public Boolean getMostrarBusquedaInformesDevolucionesInformesDevoluciones() {
		return this.mostrarBusquedaInformesDevolucionesInformesDevoluciones;
	}

	public void setMostrarBusquedaInformesDevolucionesInformesDevoluciones(Boolean visibilidadResaltar) {
		this.mostrarBusquedaInformesDevolucionesInformesDevoluciones= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaInformesDevolucionesInformesDevoluciones=true;

	public Boolean getActivarBusquedaInformesDevolucionesInformesDevoluciones() {
		return this.activarBusquedaInformesDevolucionesInformesDevoluciones;
	}

	public void setActivarBusquedaInformesDevolucionesInformesDevoluciones(Boolean habilitarResaltar) {
		this.activarBusquedaInformesDevolucionesInformesDevoluciones= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaInformesDevolucionesInformesDevoluciones=null;

	public Border getResaltarBusquedaInformesDevolucionesInformesDevoluciones() {
		return this.resaltarBusquedaInformesDevolucionesInformesDevoluciones;
	}

	public void setResaltarBusquedaInformesDevolucionesInformesDevoluciones(Border borderResaltar) {
		this.resaltarBusquedaInformesDevolucionesInformesDevoluciones= borderResaltar;
	}

	public void setResaltarBusquedaInformesDevolucionesInformesDevoluciones(ParametroGeneralUsuario parametroGeneralUsuario/*InformesDevolucionesBeanSwingJInternalFrame informesdevolucionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaInformesDevolucionesInformesDevoluciones= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}