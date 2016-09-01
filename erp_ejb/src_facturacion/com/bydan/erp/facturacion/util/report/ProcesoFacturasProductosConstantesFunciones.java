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


import com.bydan.erp.facturacion.util.report.ProcesoFacturasProductosConstantesFunciones;
import com.bydan.erp.facturacion.util.report.ProcesoFacturasProductosParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.ProcesoFacturasProductosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoFacturasProductosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoFacturasProductos";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoFacturasProductos"+ProcesoFacturasProductosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoFacturasProductosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoFacturasProductosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoFacturasProductosConstantesFunciones.SCHEMA+"_"+ProcesoFacturasProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoFacturasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoFacturasProductosConstantesFunciones.SCHEMA+"_"+ProcesoFacturasProductosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoFacturasProductosConstantesFunciones.SCHEMA+"_"+ProcesoFacturasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoFacturasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoFacturasProductosConstantesFunciones.SCHEMA+"_"+ProcesoFacturasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoFacturasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoFacturasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoFacturasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoFacturasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoFacturasProductosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoFacturasProductosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoFacturasProductosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoFacturasProductosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoFacturasProductosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoFacturasProductosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Facturas Productoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Facturas Productos";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Facturas Productos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoFacturasProductos";
	public static final String OBJECTNAME="procesofacturasproductos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="proceso_facturas_productos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesofacturasproductos from "+ProcesoFacturasProductosConstantesFunciones.SPERSISTENCENAME+" procesofacturasproductos";
	public static String QUERYSELECTNATIVE="select "+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".id,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".version_row,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".id_ciudad,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".id_zona,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".id_grupo_cliente,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".id_vendedor,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".codigo,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".nombre_completo,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".nombre_provincia,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".nombre_ciudad,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".nombre_zona,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".nombre_grupo_cliente,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".codigo_dato,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".nombre_completo_dato,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".numero_pre_impreso_factura,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".nombre_producto,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".nombre_unidad,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".precio,"+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME+".tarea from "+ProcesoFacturasProductosConstantesFunciones.SCHEMA+"."+ProcesoFacturasProductosConstantesFunciones.TABLENAME;//+" as "+ProcesoFacturasProductosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDZONA= "id_zona";
    public static final String IDGRUPOCLIENTE= "id_grupo_cliente";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String NOMBREPROVINCIA= "nombre_provincia";
    public static final String NOMBRECIUDAD= "nombre_ciudad";
    public static final String NOMBREZONA= "nombre_zona";
    public static final String NOMBREGRUPOCLIENTE= "nombre_grupo_cliente";
    public static final String CODIGODATO= "codigo_dato";
    public static final String NOMBRECOMPLETODATO= "nombre_completo_dato";
    public static final String NUMEROPREIMPRESOFACTURA= "numero_pre_impreso_factura";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String PRECIO= "precio";
    public static final String TAREA= "tarea";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
    	public static final String LABEL_IDGRUPOCLIENTE= "Grupo Cliente";
		public static final String LABEL_IDGRUPOCLIENTE_LOWER= "Grupo Cliente";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_NOMBREPROVINCIA= "Nombre Provincia";
		public static final String LABEL_NOMBREPROVINCIA_LOWER= "Nombre Provincia";
    	public static final String LABEL_NOMBRECIUDAD= "Nombre Ciudad";
		public static final String LABEL_NOMBRECIUDAD_LOWER= "Nombre Ciudad";
    	public static final String LABEL_NOMBREZONA= "Nombre Zona";
		public static final String LABEL_NOMBREZONA_LOWER= "Nombre Zona";
    	public static final String LABEL_NOMBREGRUPOCLIENTE= "Nombre Grupo Cliente";
		public static final String LABEL_NOMBREGRUPOCLIENTE_LOWER= "Nombre Grupo Cliente";
    	public static final String LABEL_CODIGODATO= "Codigo Dato";
		public static final String LABEL_CODIGODATO_LOWER= "Codigo Dato";
    	public static final String LABEL_NOMBRECOMPLETODATO= "Nombre Completo Dato";
		public static final String LABEL_NOMBRECOMPLETODATO_LOWER= "Nombre Completo Dato";
    	public static final String LABEL_NUMEROPREIMPRESOFACTURA= "Numero Pre Impreso Factura";
		public static final String LABEL_NUMEROPREIMPRESOFACTURA_LOWER= "Numero Pre Impreso Factura";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unidad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_TAREA= "Tarea";
		public static final String LABEL_TAREA_LOWER= "Tarea";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PROVINCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PROVINCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CIUDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CIUDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_ZONA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ZONA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_DATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_DATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO_DATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_DATO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PRE_IMPRESO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXTAREA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTAREA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProcesoFacturasProductosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.IDCIUDAD)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.IDZONA)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.IDGRUPOCLIENTE)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_IDGRUPOCLIENTE;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.IDVENDEDOR)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.CODIGO)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREPROVINCIA)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREPROVINCIA;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.NOMBRECIUDAD)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECIUDAD;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREZONA)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREZONA;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREGRUPOCLIENTE)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.CODIGODATO)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_CODIGODATO;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETODATO)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECOMPLETODATO;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.PRECIO)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(ProcesoFacturasProductosConstantesFunciones.TAREA)) {sLabelColumna=ProcesoFacturasProductosConstantesFunciones.LABEL_TAREA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProcesoFacturasProductosDescripcion(ProcesoFacturasProductos procesofacturasproductos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesofacturasproductos !=null/* && procesofacturasproductos.getId()!=0*/) {
			sDescripcion=procesofacturasproductos.getcodigo();//procesofacturasproductosprocesofacturasproductos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoFacturasProductosDescripcionDetallado(ProcesoFacturasProductos procesofacturasproductos) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.ID+"=";
		sDescripcion+=procesofacturasproductos.getId().toString()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesofacturasproductos.getVersionRow().toString()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=procesofacturasproductos.getid_ciudad().toString()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.IDZONA+"=";
		sDescripcion+=procesofacturasproductos.getid_zona().toString()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.IDGRUPOCLIENTE+"=";
		sDescripcion+=procesofacturasproductos.getid_grupo_cliente().toString()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=procesofacturasproductos.getid_vendedor().toString()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.CODIGO+"=";
		sDescripcion+=procesofacturasproductos.getcodigo()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=procesofacturasproductos.getnombre_completo()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.NOMBREPROVINCIA+"=";
		sDescripcion+=procesofacturasproductos.getnombre_provincia()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.NOMBRECIUDAD+"=";
		sDescripcion+=procesofacturasproductos.getnombre_ciudad()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.NOMBREZONA+"=";
		sDescripcion+=procesofacturasproductos.getnombre_zona()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.NOMBREGRUPOCLIENTE+"=";
		sDescripcion+=procesofacturasproductos.getnombre_grupo_cliente()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.CODIGODATO+"=";
		sDescripcion+=procesofacturasproductos.getcodigo_dato()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETODATO+"=";
		sDescripcion+=procesofacturasproductos.getnombre_completo_dato()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.NUMEROPREIMPRESOFACTURA+"=";
		sDescripcion+=procesofacturasproductos.getnumero_pre_impreso_factura()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=procesofacturasproductos.getnombre_producto()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=procesofacturasproductos.getnombre_unidad()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.PRECIO+"=";
		sDescripcion+=procesofacturasproductos.getprecio().toString()+",";
		sDescripcion+=ProcesoFacturasProductosConstantesFunciones.TAREA+"=";
		sDescripcion+=procesofacturasproductos.gettarea()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoFacturasProductosDescripcion(ProcesoFacturasProductos procesofacturasproductos,String sValor) throws Exception {			
		if(procesofacturasproductos !=null) {
			procesofacturasproductos.setcodigo(sValor);;//procesofacturasproductosprocesofacturasproductos.getcodigo().trim();
		}		
	}
	
		

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}

	public static String getZonaDescripcion(Zona zona) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(zona!=null/*&&zona.getId()>0*/) {
			sDescripcion=ZonaConstantesFunciones.getZonaDescripcion(zona);
		}

		return sDescripcion;
	}

	public static String getGrupoClienteDescripcion(GrupoCliente grupocliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupocliente!=null/*&&grupocliente.getId()>0*/) {
			sDescripcion=GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(grupocliente);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoFacturasProductos")) {
			sNombreIndice="Tipo=  Por Ciudad Por Zona Por Grupo Cliente Por Vendedor Por Codigo Por Nombre Completo";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdGrupoCliente")) {
			sNombreIndice="Tipo=  Por Grupo Cliente";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		} else if(sNombreIndice.equals("FK_IdZona")) {
			sNombreIndice="Tipo=  Por Zona";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoFacturasProductos(Long id_ciudad,Long id_zona,Long id_grupo_cliente,Long id_vendedor,String codigo,String nombre_completo) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();}
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();}
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();}
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();}
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;}
		if(nombre_completo!=null) {sDetalleIndice+=" Nombre Completo="+nombre_completo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdGrupoCliente(Long id_grupo_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoFacturasProductos(ProcesoFacturasProductos procesofacturasproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesofacturasproductos.setnombre_provincia(procesofacturasproductos.getnombre_provincia().trim());
		procesofacturasproductos.setnombre_ciudad(procesofacturasproductos.getnombre_ciudad().trim());
		procesofacturasproductos.setnombre_zona(procesofacturasproductos.getnombre_zona().trim());
		procesofacturasproductos.setnombre_grupo_cliente(procesofacturasproductos.getnombre_grupo_cliente().trim());
		procesofacturasproductos.setcodigo_dato(procesofacturasproductos.getcodigo_dato().trim());
		procesofacturasproductos.setnombre_completo_dato(procesofacturasproductos.getnombre_completo_dato().trim());
		procesofacturasproductos.setnumero_pre_impreso_factura(procesofacturasproductos.getnumero_pre_impreso_factura().trim());
		procesofacturasproductos.setnombre_producto(procesofacturasproductos.getnombre_producto().trim());
		procesofacturasproductos.setnombre_unidad(procesofacturasproductos.getnombre_unidad().trim());
		procesofacturasproductos.settarea(procesofacturasproductos.gettarea().trim());
	}
	
	public static void quitarEspaciosProcesoFacturasProductoss(List<ProcesoFacturasProductos> procesofacturasproductoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoFacturasProductos procesofacturasproductos: procesofacturasproductoss) {
			procesofacturasproductos.setnombre_provincia(procesofacturasproductos.getnombre_provincia().trim());
			procesofacturasproductos.setnombre_ciudad(procesofacturasproductos.getnombre_ciudad().trim());
			procesofacturasproductos.setnombre_zona(procesofacturasproductos.getnombre_zona().trim());
			procesofacturasproductos.setnombre_grupo_cliente(procesofacturasproductos.getnombre_grupo_cliente().trim());
			procesofacturasproductos.setcodigo_dato(procesofacturasproductos.getcodigo_dato().trim());
			procesofacturasproductos.setnombre_completo_dato(procesofacturasproductos.getnombre_completo_dato().trim());
			procesofacturasproductos.setnumero_pre_impreso_factura(procesofacturasproductos.getnumero_pre_impreso_factura().trim());
			procesofacturasproductos.setnombre_producto(procesofacturasproductos.getnombre_producto().trim());
			procesofacturasproductos.setnombre_unidad(procesofacturasproductos.getnombre_unidad().trim());
			procesofacturasproductos.settarea(procesofacturasproductos.gettarea().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoFacturasProductos(ProcesoFacturasProductos procesofacturasproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesofacturasproductos.getConCambioAuxiliar()) {
			procesofacturasproductos.setIsDeleted(procesofacturasproductos.getIsDeletedAuxiliar());	
			procesofacturasproductos.setIsNew(procesofacturasproductos.getIsNewAuxiliar());	
			procesofacturasproductos.setIsChanged(procesofacturasproductos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesofacturasproductos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesofacturasproductos.setIsDeletedAuxiliar(false);	
			procesofacturasproductos.setIsNewAuxiliar(false);	
			procesofacturasproductos.setIsChangedAuxiliar(false);
			
			procesofacturasproductos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoFacturasProductoss(List<ProcesoFacturasProductos> procesofacturasproductoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoFacturasProductos procesofacturasproductos : procesofacturasproductoss) {
			if(conAsignarBase && procesofacturasproductos.getConCambioAuxiliar()) {
				procesofacturasproductos.setIsDeleted(procesofacturasproductos.getIsDeletedAuxiliar());	
				procesofacturasproductos.setIsNew(procesofacturasproductos.getIsNewAuxiliar());	
				procesofacturasproductos.setIsChanged(procesofacturasproductos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesofacturasproductos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesofacturasproductos.setIsDeletedAuxiliar(false);	
				procesofacturasproductos.setIsNewAuxiliar(false);	
				procesofacturasproductos.setIsChangedAuxiliar(false);
				
				procesofacturasproductos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoFacturasProductos(ProcesoFacturasProductos procesofacturasproductos,Boolean conEnteros) throws Exception  {
		procesofacturasproductos.setprecio(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoFacturasProductoss(List<ProcesoFacturasProductos> procesofacturasproductoss,Boolean conEnteros) throws Exception  {
		
		for(ProcesoFacturasProductos procesofacturasproductos: procesofacturasproductoss) {
			procesofacturasproductos.setprecio(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoFacturasProductos(List<ProcesoFacturasProductos> procesofacturasproductoss,ProcesoFacturasProductos procesofacturasproductosAux) throws Exception  {
		ProcesoFacturasProductosConstantesFunciones.InicializarValoresProcesoFacturasProductos(procesofacturasproductosAux,true);
		
		for(ProcesoFacturasProductos procesofacturasproductos: procesofacturasproductoss) {
			if(procesofacturasproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			procesofacturasproductosAux.setprecio(procesofacturasproductosAux.getprecio()+procesofacturasproductos.getprecio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoFacturasProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoFacturasProductosConstantesFunciones.getArrayColumnasGlobalesProcesoFacturasProductos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoFacturasProductos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoFacturasProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoFacturasProductos> procesofacturasproductoss,ProcesoFacturasProductos procesofacturasproductos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoFacturasProductos procesofacturasproductosAux: procesofacturasproductoss) {
			if(procesofacturasproductosAux!=null && procesofacturasproductos!=null) {
				if((procesofacturasproductosAux.getId()==null && procesofacturasproductos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesofacturasproductosAux.getId()!=null && procesofacturasproductos.getId()!=null){
					if(procesofacturasproductosAux.getId().equals(procesofacturasproductos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoFacturasProductos(List<ProcesoFacturasProductos> procesofacturasproductoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
	
		for(ProcesoFacturasProductos procesofacturasproductos: procesofacturasproductoss) {			
			if(procesofacturasproductos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=procesofacturasproductos.getprecio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoFacturasProductosConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoFacturasProductos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProcesoFacturasProductosConstantesFunciones.LABEL_ID, ProcesoFacturasProductosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoFacturasProductosConstantesFunciones.LABEL_VERSIONROW, ProcesoFacturasProductosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREPROVINCIA, ProcesoFacturasProductosConstantesFunciones.NOMBREPROVINCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECIUDAD, ProcesoFacturasProductosConstantesFunciones.NOMBRECIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREZONA, ProcesoFacturasProductosConstantesFunciones.NOMBREZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE, ProcesoFacturasProductosConstantesFunciones.NOMBREGRUPOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoFacturasProductosConstantesFunciones.LABEL_CODIGODATO, ProcesoFacturasProductosConstantesFunciones.CODIGODATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECOMPLETODATO, ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETODATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoFacturasProductosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA, ProcesoFacturasProductosConstantesFunciones.NUMEROPREIMPRESOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREPRODUCTO, ProcesoFacturasProductosConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREUNIDAD, ProcesoFacturasProductosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoFacturasProductosConstantesFunciones.LABEL_PRECIO, ProcesoFacturasProductosConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoFacturasProductosConstantesFunciones.LABEL_TAREA, ProcesoFacturasProductosConstantesFunciones.TAREA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoFacturasProductos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProcesoFacturasProductosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoFacturasProductosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoFacturasProductosConstantesFunciones.NOMBREPROVINCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoFacturasProductosConstantesFunciones.NOMBRECIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoFacturasProductosConstantesFunciones.NOMBREZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoFacturasProductosConstantesFunciones.NOMBREGRUPOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoFacturasProductosConstantesFunciones.CODIGODATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETODATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoFacturasProductosConstantesFunciones.NUMEROPREIMPRESOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoFacturasProductosConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoFacturasProductosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoFacturasProductosConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoFacturasProductosConstantesFunciones.TAREA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoFacturasProductos() throws Exception  {
		return ProcesoFacturasProductosConstantesFunciones.getTiposSeleccionarProcesoFacturasProductos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoFacturasProductos(Boolean conFk) throws Exception  {
		return ProcesoFacturasProductosConstantesFunciones.getTiposSeleccionarProcesoFacturasProductos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoFacturasProductos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_IDGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREPROVINCIA);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECIUDAD);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREZONA);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_CODIGODATO);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_CODIGODATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECOMPLETODATO);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECOMPLETODATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoFacturasProductosConstantesFunciones.LABEL_TAREA);
			reporte.setsDescripcion(ProcesoFacturasProductosConstantesFunciones.LABEL_TAREA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoFacturasProductos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoFacturasProductos(ProcesoFacturasProductos procesofacturasproductosAux) throws Exception {
		
			procesofacturasproductosAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(procesofacturasproductosAux.getCiudad()));
			procesofacturasproductosAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(procesofacturasproductosAux.getZona()));
			procesofacturasproductosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(procesofacturasproductosAux.getGrupoCliente()));
			procesofacturasproductosAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(procesofacturasproductosAux.getVendedor()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoFacturasProductos(List<ProcesoFacturasProductos> procesofacturasproductossTemp) throws Exception {
		for(ProcesoFacturasProductos procesofacturasproductosAux:procesofacturasproductossTemp) {
			
			procesofacturasproductosAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(procesofacturasproductosAux.getCiudad()));
			procesofacturasproductosAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(procesofacturasproductosAux.getZona()));
			procesofacturasproductosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(procesofacturasproductosAux.getGrupoCliente()));
			procesofacturasproductosAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(procesofacturasproductosAux.getVendedor()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoFacturasProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(Zona.class));
				classes.add(new Classe(GrupoCliente.class));
				classes.add(new Classe(Vendedor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Zona.class)) {
						classes.add(new Classe(Zona.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoCliente.class)) {
						classes.add(new Classe(GrupoCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoFacturasProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoFacturasProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoFacturasProductosConstantesFunciones.getClassesRelationshipsOfProcesoFacturasProductos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoFacturasProductos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoFacturasProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoFacturasProductosConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoFacturasProductos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoFacturasProductos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoFacturasProductos procesofacturasproductos,List<ProcesoFacturasProductos> procesofacturasproductoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoFacturasProductos procesofacturasproductos,List<ProcesoFacturasProductos> procesofacturasproductoss) throws Exception {
		try	{			
			for(ProcesoFacturasProductos procesofacturasproductosLocal:procesofacturasproductoss) {
				if(procesofacturasproductosLocal.getId().equals(procesofacturasproductos.getId())) {
					procesofacturasproductosLocal.setIsSelected(procesofacturasproductos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoFacturasProductos(List<ProcesoFacturasProductos> procesofacturasproductossAux) throws Exception {
		//this.procesofacturasproductossAux=procesofacturasproductossAux;
		
		for(ProcesoFacturasProductos procesofacturasproductosAux:procesofacturasproductossAux) {
			if(procesofacturasproductosAux.getIsChanged()) {
				procesofacturasproductosAux.setIsChanged(false);
			}		
			
			if(procesofacturasproductosAux.getIsNew()) {
				procesofacturasproductosAux.setIsNew(false);
			}	
			
			if(procesofacturasproductosAux.getIsDeleted()) {
				procesofacturasproductosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoFacturasProductos(ProcesoFacturasProductos procesofacturasproductosAux) throws Exception {
		//this.procesofacturasproductosAux=procesofacturasproductosAux;
		
			if(procesofacturasproductosAux.getIsChanged()) {
				procesofacturasproductosAux.setIsChanged(false);
			}		
			
			if(procesofacturasproductosAux.getIsNew()) {
				procesofacturasproductosAux.setIsNew(false);
			}	
			
			if(procesofacturasproductosAux.getIsDeleted()) {
				procesofacturasproductosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoFacturasProductos procesofacturasproductosAsignar,ProcesoFacturasProductos procesofacturasproductos) throws Exception {
		procesofacturasproductosAsignar.setId(procesofacturasproductos.getId());	
		procesofacturasproductosAsignar.setVersionRow(procesofacturasproductos.getVersionRow());	
		procesofacturasproductosAsignar.setnombre_provincia(procesofacturasproductos.getnombre_provincia());	
		procesofacturasproductosAsignar.setnombre_ciudad(procesofacturasproductos.getnombre_ciudad());	
		procesofacturasproductosAsignar.setnombre_zona(procesofacturasproductos.getnombre_zona());	
		procesofacturasproductosAsignar.setnombre_grupo_cliente(procesofacturasproductos.getnombre_grupo_cliente());	
		procesofacturasproductosAsignar.setcodigo_dato(procesofacturasproductos.getcodigo_dato());	
		procesofacturasproductosAsignar.setnombre_completo_dato(procesofacturasproductos.getnombre_completo_dato());	
		procesofacturasproductosAsignar.setnumero_pre_impreso_factura(procesofacturasproductos.getnumero_pre_impreso_factura());	
		procesofacturasproductosAsignar.setnombre_producto(procesofacturasproductos.getnombre_producto());	
		procesofacturasproductosAsignar.setnombre_unidad(procesofacturasproductos.getnombre_unidad());	
		procesofacturasproductosAsignar.setprecio(procesofacturasproductos.getprecio());	
		procesofacturasproductosAsignar.settarea(procesofacturasproductos.gettarea());	
	}
	
	public static void inicializarProcesoFacturasProductos(ProcesoFacturasProductos procesofacturasproductos) throws Exception {
		try {
				procesofacturasproductos.setId(0L);	
					
				procesofacturasproductos.setnombre_provincia("");	
				procesofacturasproductos.setnombre_ciudad("");	
				procesofacturasproductos.setnombre_zona("");	
				procesofacturasproductos.setnombre_grupo_cliente("");	
				procesofacturasproductos.setcodigo_dato("");	
				procesofacturasproductos.setnombre_completo_dato("");	
				procesofacturasproductos.setnumero_pre_impreso_factura("");	
				procesofacturasproductos.setnombre_producto("");	
				procesofacturasproductos.setnombre_unidad("");	
				procesofacturasproductos.setprecio(0.0);	
				procesofacturasproductos.settarea("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoFacturasProductos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_CODIGODATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBRECOMPLETODATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoFacturasProductosConstantesFunciones.LABEL_TAREA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoFacturasProductos(String sTipo,Row row,Workbook workbook,ProcesoFacturasProductos procesofacturasproductos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getgrupocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getnombre_provincia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getnombre_ciudad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getnombre_zona());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getnombre_grupo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getcodigo_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getnombre_completo_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getnumero_pre_impreso_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesofacturasproductos.gettarea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoFacturasProductos="";
	
	public String getsFinalQueryProcesoFacturasProductos() {
		return this.sFinalQueryProcesoFacturasProductos;
	}
	
	public void setsFinalQueryProcesoFacturasProductos(String sFinalQueryProcesoFacturasProductos) {
		this.sFinalQueryProcesoFacturasProductos= sFinalQueryProcesoFacturasProductos;
	}
	
	public Border resaltarSeleccionarProcesoFacturasProductos=null;
	
	public Border setResaltarSeleccionarProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoFacturasProductos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoFacturasProductos() {
		return this.resaltarSeleccionarProcesoFacturasProductos;
	}
	
	public void setResaltarSeleccionarProcesoFacturasProductos(Border borderResaltarSeleccionarProcesoFacturasProductos) {
		this.resaltarSeleccionarProcesoFacturasProductos= borderResaltarSeleccionarProcesoFacturasProductos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoFacturasProductos=null;
	public Boolean mostraridProcesoFacturasProductos=true;
	public Boolean activaridProcesoFacturasProductos=true;

	public Border resaltarid_ciudadProcesoFacturasProductos=null;
	public Boolean mostrarid_ciudadProcesoFacturasProductos=true;
	public Boolean activarid_ciudadProcesoFacturasProductos=true;
	public Boolean cargarid_ciudadProcesoFacturasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadProcesoFacturasProductos=false;//ConEventDepend=true

	public Border resaltarid_zonaProcesoFacturasProductos=null;
	public Boolean mostrarid_zonaProcesoFacturasProductos=true;
	public Boolean activarid_zonaProcesoFacturasProductos=true;
	public Boolean cargarid_zonaProcesoFacturasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaProcesoFacturasProductos=false;//ConEventDepend=true

	public Border resaltarid_grupo_clienteProcesoFacturasProductos=null;
	public Boolean mostrarid_grupo_clienteProcesoFacturasProductos=true;
	public Boolean activarid_grupo_clienteProcesoFacturasProductos=true;
	public Boolean cargarid_grupo_clienteProcesoFacturasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_clienteProcesoFacturasProductos=false;//ConEventDepend=true

	public Border resaltarid_vendedorProcesoFacturasProductos=null;
	public Boolean mostrarid_vendedorProcesoFacturasProductos=true;
	public Boolean activarid_vendedorProcesoFacturasProductos=true;
	public Boolean cargarid_vendedorProcesoFacturasProductos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorProcesoFacturasProductos=false;//ConEventDepend=true

	public Border resaltarcodigoProcesoFacturasProductos=null;
	public Boolean mostrarcodigoProcesoFacturasProductos=true;
	public Boolean activarcodigoProcesoFacturasProductos=true;

	public Border resaltarnombre_completoProcesoFacturasProductos=null;
	public Boolean mostrarnombre_completoProcesoFacturasProductos=true;
	public Boolean activarnombre_completoProcesoFacturasProductos=true;

	public Border resaltarnombre_provinciaProcesoFacturasProductos=null;
	public Boolean mostrarnombre_provinciaProcesoFacturasProductos=true;
	public Boolean activarnombre_provinciaProcesoFacturasProductos=true;

	public Border resaltarnombre_ciudadProcesoFacturasProductos=null;
	public Boolean mostrarnombre_ciudadProcesoFacturasProductos=true;
	public Boolean activarnombre_ciudadProcesoFacturasProductos=true;

	public Border resaltarnombre_zonaProcesoFacturasProductos=null;
	public Boolean mostrarnombre_zonaProcesoFacturasProductos=true;
	public Boolean activarnombre_zonaProcesoFacturasProductos=true;

	public Border resaltarnombre_grupo_clienteProcesoFacturasProductos=null;
	public Boolean mostrarnombre_grupo_clienteProcesoFacturasProductos=true;
	public Boolean activarnombre_grupo_clienteProcesoFacturasProductos=true;

	public Border resaltarcodigo_datoProcesoFacturasProductos=null;
	public Boolean mostrarcodigo_datoProcesoFacturasProductos=true;
	public Boolean activarcodigo_datoProcesoFacturasProductos=true;

	public Border resaltarnombre_completo_datoProcesoFacturasProductos=null;
	public Boolean mostrarnombre_completo_datoProcesoFacturasProductos=true;
	public Boolean activarnombre_completo_datoProcesoFacturasProductos=true;

	public Border resaltarnumero_pre_impreso_facturaProcesoFacturasProductos=null;
	public Boolean mostrarnumero_pre_impreso_facturaProcesoFacturasProductos=true;
	public Boolean activarnumero_pre_impreso_facturaProcesoFacturasProductos=true;

	public Border resaltarnombre_productoProcesoFacturasProductos=null;
	public Boolean mostrarnombre_productoProcesoFacturasProductos=true;
	public Boolean activarnombre_productoProcesoFacturasProductos=true;

	public Border resaltarnombre_unidadProcesoFacturasProductos=null;
	public Boolean mostrarnombre_unidadProcesoFacturasProductos=true;
	public Boolean activarnombre_unidadProcesoFacturasProductos=true;

	public Border resaltarprecioProcesoFacturasProductos=null;
	public Boolean mostrarprecioProcesoFacturasProductos=true;
	public Boolean activarprecioProcesoFacturasProductos=true;

	public Border resaltartareaProcesoFacturasProductos=null;
	public Boolean mostrartareaProcesoFacturasProductos=true;
	public Boolean activartareaProcesoFacturasProductos=true;

	
	

	public Border setResaltaridProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltaridProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoFacturasProductos() {
		return this.resaltaridProcesoFacturasProductos;
	}

	public void setResaltaridProcesoFacturasProductos(Border borderResaltar) {
		this.resaltaridProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostraridProcesoFacturasProductos() {
		return this.mostraridProcesoFacturasProductos;
	}

	public void setMostraridProcesoFacturasProductos(Boolean mostraridProcesoFacturasProductos) {
		this.mostraridProcesoFacturasProductos= mostraridProcesoFacturasProductos;
	}

	public Boolean getActivaridProcesoFacturasProductos() {
		return this.activaridProcesoFacturasProductos;
	}

	public void setActivaridProcesoFacturasProductos(Boolean activaridProcesoFacturasProductos) {
		this.activaridProcesoFacturasProductos= activaridProcesoFacturasProductos;
	}

	public Border setResaltarid_ciudadProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarid_ciudadProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadProcesoFacturasProductos() {
		return this.resaltarid_ciudadProcesoFacturasProductos;
	}

	public void setResaltarid_ciudadProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarid_ciudadProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarid_ciudadProcesoFacturasProductos() {
		return this.mostrarid_ciudadProcesoFacturasProductos;
	}

	public void setMostrarid_ciudadProcesoFacturasProductos(Boolean mostrarid_ciudadProcesoFacturasProductos) {
		this.mostrarid_ciudadProcesoFacturasProductos= mostrarid_ciudadProcesoFacturasProductos;
	}

	public Boolean getActivarid_ciudadProcesoFacturasProductos() {
		return this.activarid_ciudadProcesoFacturasProductos;
	}

	public void setActivarid_ciudadProcesoFacturasProductos(Boolean activarid_ciudadProcesoFacturasProductos) {
		this.activarid_ciudadProcesoFacturasProductos= activarid_ciudadProcesoFacturasProductos;
	}

	public Boolean getCargarid_ciudadProcesoFacturasProductos() {
		return this.cargarid_ciudadProcesoFacturasProductos;
	}

	public void setCargarid_ciudadProcesoFacturasProductos(Boolean cargarid_ciudadProcesoFacturasProductos) {
		this.cargarid_ciudadProcesoFacturasProductos= cargarid_ciudadProcesoFacturasProductos;
	}

	public Border setResaltarid_zonaProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarid_zonaProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaProcesoFacturasProductos() {
		return this.resaltarid_zonaProcesoFacturasProductos;
	}

	public void setResaltarid_zonaProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarid_zonaProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarid_zonaProcesoFacturasProductos() {
		return this.mostrarid_zonaProcesoFacturasProductos;
	}

	public void setMostrarid_zonaProcesoFacturasProductos(Boolean mostrarid_zonaProcesoFacturasProductos) {
		this.mostrarid_zonaProcesoFacturasProductos= mostrarid_zonaProcesoFacturasProductos;
	}

	public Boolean getActivarid_zonaProcesoFacturasProductos() {
		return this.activarid_zonaProcesoFacturasProductos;
	}

	public void setActivarid_zonaProcesoFacturasProductos(Boolean activarid_zonaProcesoFacturasProductos) {
		this.activarid_zonaProcesoFacturasProductos= activarid_zonaProcesoFacturasProductos;
	}

	public Boolean getCargarid_zonaProcesoFacturasProductos() {
		return this.cargarid_zonaProcesoFacturasProductos;
	}

	public void setCargarid_zonaProcesoFacturasProductos(Boolean cargarid_zonaProcesoFacturasProductos) {
		this.cargarid_zonaProcesoFacturasProductos= cargarid_zonaProcesoFacturasProductos;
	}

	public Border setResaltarid_grupo_clienteProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarid_grupo_clienteProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_clienteProcesoFacturasProductos() {
		return this.resaltarid_grupo_clienteProcesoFacturasProductos;
	}

	public void setResaltarid_grupo_clienteProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarid_grupo_clienteProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarid_grupo_clienteProcesoFacturasProductos() {
		return this.mostrarid_grupo_clienteProcesoFacturasProductos;
	}

	public void setMostrarid_grupo_clienteProcesoFacturasProductos(Boolean mostrarid_grupo_clienteProcesoFacturasProductos) {
		this.mostrarid_grupo_clienteProcesoFacturasProductos= mostrarid_grupo_clienteProcesoFacturasProductos;
	}

	public Boolean getActivarid_grupo_clienteProcesoFacturasProductos() {
		return this.activarid_grupo_clienteProcesoFacturasProductos;
	}

	public void setActivarid_grupo_clienteProcesoFacturasProductos(Boolean activarid_grupo_clienteProcesoFacturasProductos) {
		this.activarid_grupo_clienteProcesoFacturasProductos= activarid_grupo_clienteProcesoFacturasProductos;
	}

	public Boolean getCargarid_grupo_clienteProcesoFacturasProductos() {
		return this.cargarid_grupo_clienteProcesoFacturasProductos;
	}

	public void setCargarid_grupo_clienteProcesoFacturasProductos(Boolean cargarid_grupo_clienteProcesoFacturasProductos) {
		this.cargarid_grupo_clienteProcesoFacturasProductos= cargarid_grupo_clienteProcesoFacturasProductos;
	}

	public Border setResaltarid_vendedorProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarid_vendedorProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorProcesoFacturasProductos() {
		return this.resaltarid_vendedorProcesoFacturasProductos;
	}

	public void setResaltarid_vendedorProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarid_vendedorProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarid_vendedorProcesoFacturasProductos() {
		return this.mostrarid_vendedorProcesoFacturasProductos;
	}

	public void setMostrarid_vendedorProcesoFacturasProductos(Boolean mostrarid_vendedorProcesoFacturasProductos) {
		this.mostrarid_vendedorProcesoFacturasProductos= mostrarid_vendedorProcesoFacturasProductos;
	}

	public Boolean getActivarid_vendedorProcesoFacturasProductos() {
		return this.activarid_vendedorProcesoFacturasProductos;
	}

	public void setActivarid_vendedorProcesoFacturasProductos(Boolean activarid_vendedorProcesoFacturasProductos) {
		this.activarid_vendedorProcesoFacturasProductos= activarid_vendedorProcesoFacturasProductos;
	}

	public Boolean getCargarid_vendedorProcesoFacturasProductos() {
		return this.cargarid_vendedorProcesoFacturasProductos;
	}

	public void setCargarid_vendedorProcesoFacturasProductos(Boolean cargarid_vendedorProcesoFacturasProductos) {
		this.cargarid_vendedorProcesoFacturasProductos= cargarid_vendedorProcesoFacturasProductos;
	}

	public Border setResaltarcodigoProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarcodigoProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProcesoFacturasProductos() {
		return this.resaltarcodigoProcesoFacturasProductos;
	}

	public void setResaltarcodigoProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarcodigoProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarcodigoProcesoFacturasProductos() {
		return this.mostrarcodigoProcesoFacturasProductos;
	}

	public void setMostrarcodigoProcesoFacturasProductos(Boolean mostrarcodigoProcesoFacturasProductos) {
		this.mostrarcodigoProcesoFacturasProductos= mostrarcodigoProcesoFacturasProductos;
	}

	public Boolean getActivarcodigoProcesoFacturasProductos() {
		return this.activarcodigoProcesoFacturasProductos;
	}

	public void setActivarcodigoProcesoFacturasProductos(Boolean activarcodigoProcesoFacturasProductos) {
		this.activarcodigoProcesoFacturasProductos= activarcodigoProcesoFacturasProductos;
	}

	public Border setResaltarnombre_completoProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoProcesoFacturasProductos() {
		return this.resaltarnombre_completoProcesoFacturasProductos;
	}

	public void setResaltarnombre_completoProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarnombre_completoProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoProcesoFacturasProductos() {
		return this.mostrarnombre_completoProcesoFacturasProductos;
	}

	public void setMostrarnombre_completoProcesoFacturasProductos(Boolean mostrarnombre_completoProcesoFacturasProductos) {
		this.mostrarnombre_completoProcesoFacturasProductos= mostrarnombre_completoProcesoFacturasProductos;
	}

	public Boolean getActivarnombre_completoProcesoFacturasProductos() {
		return this.activarnombre_completoProcesoFacturasProductos;
	}

	public void setActivarnombre_completoProcesoFacturasProductos(Boolean activarnombre_completoProcesoFacturasProductos) {
		this.activarnombre_completoProcesoFacturasProductos= activarnombre_completoProcesoFacturasProductos;
	}

	public Border setResaltarnombre_provinciaProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_provinciaProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_provinciaProcesoFacturasProductos() {
		return this.resaltarnombre_provinciaProcesoFacturasProductos;
	}

	public void setResaltarnombre_provinciaProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarnombre_provinciaProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_provinciaProcesoFacturasProductos() {
		return this.mostrarnombre_provinciaProcesoFacturasProductos;
	}

	public void setMostrarnombre_provinciaProcesoFacturasProductos(Boolean mostrarnombre_provinciaProcesoFacturasProductos) {
		this.mostrarnombre_provinciaProcesoFacturasProductos= mostrarnombre_provinciaProcesoFacturasProductos;
	}

	public Boolean getActivarnombre_provinciaProcesoFacturasProductos() {
		return this.activarnombre_provinciaProcesoFacturasProductos;
	}

	public void setActivarnombre_provinciaProcesoFacturasProductos(Boolean activarnombre_provinciaProcesoFacturasProductos) {
		this.activarnombre_provinciaProcesoFacturasProductos= activarnombre_provinciaProcesoFacturasProductos;
	}

	public Border setResaltarnombre_ciudadProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_ciudadProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_ciudadProcesoFacturasProductos() {
		return this.resaltarnombre_ciudadProcesoFacturasProductos;
	}

	public void setResaltarnombre_ciudadProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarnombre_ciudadProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_ciudadProcesoFacturasProductos() {
		return this.mostrarnombre_ciudadProcesoFacturasProductos;
	}

	public void setMostrarnombre_ciudadProcesoFacturasProductos(Boolean mostrarnombre_ciudadProcesoFacturasProductos) {
		this.mostrarnombre_ciudadProcesoFacturasProductos= mostrarnombre_ciudadProcesoFacturasProductos;
	}

	public Boolean getActivarnombre_ciudadProcesoFacturasProductos() {
		return this.activarnombre_ciudadProcesoFacturasProductos;
	}

	public void setActivarnombre_ciudadProcesoFacturasProductos(Boolean activarnombre_ciudadProcesoFacturasProductos) {
		this.activarnombre_ciudadProcesoFacturasProductos= activarnombre_ciudadProcesoFacturasProductos;
	}

	public Border setResaltarnombre_zonaProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_zonaProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_zonaProcesoFacturasProductos() {
		return this.resaltarnombre_zonaProcesoFacturasProductos;
	}

	public void setResaltarnombre_zonaProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarnombre_zonaProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_zonaProcesoFacturasProductos() {
		return this.mostrarnombre_zonaProcesoFacturasProductos;
	}

	public void setMostrarnombre_zonaProcesoFacturasProductos(Boolean mostrarnombre_zonaProcesoFacturasProductos) {
		this.mostrarnombre_zonaProcesoFacturasProductos= mostrarnombre_zonaProcesoFacturasProductos;
	}

	public Boolean getActivarnombre_zonaProcesoFacturasProductos() {
		return this.activarnombre_zonaProcesoFacturasProductos;
	}

	public void setActivarnombre_zonaProcesoFacturasProductos(Boolean activarnombre_zonaProcesoFacturasProductos) {
		this.activarnombre_zonaProcesoFacturasProductos= activarnombre_zonaProcesoFacturasProductos;
	}

	public Border setResaltarnombre_grupo_clienteProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_grupo_clienteProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_grupo_clienteProcesoFacturasProductos() {
		return this.resaltarnombre_grupo_clienteProcesoFacturasProductos;
	}

	public void setResaltarnombre_grupo_clienteProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarnombre_grupo_clienteProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_grupo_clienteProcesoFacturasProductos() {
		return this.mostrarnombre_grupo_clienteProcesoFacturasProductos;
	}

	public void setMostrarnombre_grupo_clienteProcesoFacturasProductos(Boolean mostrarnombre_grupo_clienteProcesoFacturasProductos) {
		this.mostrarnombre_grupo_clienteProcesoFacturasProductos= mostrarnombre_grupo_clienteProcesoFacturasProductos;
	}

	public Boolean getActivarnombre_grupo_clienteProcesoFacturasProductos() {
		return this.activarnombre_grupo_clienteProcesoFacturasProductos;
	}

	public void setActivarnombre_grupo_clienteProcesoFacturasProductos(Boolean activarnombre_grupo_clienteProcesoFacturasProductos) {
		this.activarnombre_grupo_clienteProcesoFacturasProductos= activarnombre_grupo_clienteProcesoFacturasProductos;
	}

	public Border setResaltarcodigo_datoProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarcodigo_datoProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_datoProcesoFacturasProductos() {
		return this.resaltarcodigo_datoProcesoFacturasProductos;
	}

	public void setResaltarcodigo_datoProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarcodigo_datoProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarcodigo_datoProcesoFacturasProductos() {
		return this.mostrarcodigo_datoProcesoFacturasProductos;
	}

	public void setMostrarcodigo_datoProcesoFacturasProductos(Boolean mostrarcodigo_datoProcesoFacturasProductos) {
		this.mostrarcodigo_datoProcesoFacturasProductos= mostrarcodigo_datoProcesoFacturasProductos;
	}

	public Boolean getActivarcodigo_datoProcesoFacturasProductos() {
		return this.activarcodigo_datoProcesoFacturasProductos;
	}

	public void setActivarcodigo_datoProcesoFacturasProductos(Boolean activarcodigo_datoProcesoFacturasProductos) {
		this.activarcodigo_datoProcesoFacturasProductos= activarcodigo_datoProcesoFacturasProductos;
	}

	public Border setResaltarnombre_completo_datoProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_datoProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_datoProcesoFacturasProductos() {
		return this.resaltarnombre_completo_datoProcesoFacturasProductos;
	}

	public void setResaltarnombre_completo_datoProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarnombre_completo_datoProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_datoProcesoFacturasProductos() {
		return this.mostrarnombre_completo_datoProcesoFacturasProductos;
	}

	public void setMostrarnombre_completo_datoProcesoFacturasProductos(Boolean mostrarnombre_completo_datoProcesoFacturasProductos) {
		this.mostrarnombre_completo_datoProcesoFacturasProductos= mostrarnombre_completo_datoProcesoFacturasProductos;
	}

	public Boolean getActivarnombre_completo_datoProcesoFacturasProductos() {
		return this.activarnombre_completo_datoProcesoFacturasProductos;
	}

	public void setActivarnombre_completo_datoProcesoFacturasProductos(Boolean activarnombre_completo_datoProcesoFacturasProductos) {
		this.activarnombre_completo_datoProcesoFacturasProductos= activarnombre_completo_datoProcesoFacturasProductos;
	}

	public Border setResaltarnumero_pre_impreso_facturaProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impreso_facturaProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impreso_facturaProcesoFacturasProductos() {
		return this.resaltarnumero_pre_impreso_facturaProcesoFacturasProductos;
	}

	public void setResaltarnumero_pre_impreso_facturaProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarnumero_pre_impreso_facturaProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impreso_facturaProcesoFacturasProductos() {
		return this.mostrarnumero_pre_impreso_facturaProcesoFacturasProductos;
	}

	public void setMostrarnumero_pre_impreso_facturaProcesoFacturasProductos(Boolean mostrarnumero_pre_impreso_facturaProcesoFacturasProductos) {
		this.mostrarnumero_pre_impreso_facturaProcesoFacturasProductos= mostrarnumero_pre_impreso_facturaProcesoFacturasProductos;
	}

	public Boolean getActivarnumero_pre_impreso_facturaProcesoFacturasProductos() {
		return this.activarnumero_pre_impreso_facturaProcesoFacturasProductos;
	}

	public void setActivarnumero_pre_impreso_facturaProcesoFacturasProductos(Boolean activarnumero_pre_impreso_facturaProcesoFacturasProductos) {
		this.activarnumero_pre_impreso_facturaProcesoFacturasProductos= activarnumero_pre_impreso_facturaProcesoFacturasProductos;
	}

	public Border setResaltarnombre_productoProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_productoProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoProcesoFacturasProductos() {
		return this.resaltarnombre_productoProcesoFacturasProductos;
	}

	public void setResaltarnombre_productoProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarnombre_productoProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_productoProcesoFacturasProductos() {
		return this.mostrarnombre_productoProcesoFacturasProductos;
	}

	public void setMostrarnombre_productoProcesoFacturasProductos(Boolean mostrarnombre_productoProcesoFacturasProductos) {
		this.mostrarnombre_productoProcesoFacturasProductos= mostrarnombre_productoProcesoFacturasProductos;
	}

	public Boolean getActivarnombre_productoProcesoFacturasProductos() {
		return this.activarnombre_productoProcesoFacturasProductos;
	}

	public void setActivarnombre_productoProcesoFacturasProductos(Boolean activarnombre_productoProcesoFacturasProductos) {
		this.activarnombre_productoProcesoFacturasProductos= activarnombre_productoProcesoFacturasProductos;
	}

	public Border setResaltarnombre_unidadProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadProcesoFacturasProductos() {
		return this.resaltarnombre_unidadProcesoFacturasProductos;
	}

	public void setResaltarnombre_unidadProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarnombre_unidadProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadProcesoFacturasProductos() {
		return this.mostrarnombre_unidadProcesoFacturasProductos;
	}

	public void setMostrarnombre_unidadProcesoFacturasProductos(Boolean mostrarnombre_unidadProcesoFacturasProductos) {
		this.mostrarnombre_unidadProcesoFacturasProductos= mostrarnombre_unidadProcesoFacturasProductos;
	}

	public Boolean getActivarnombre_unidadProcesoFacturasProductos() {
		return this.activarnombre_unidadProcesoFacturasProductos;
	}

	public void setActivarnombre_unidadProcesoFacturasProductos(Boolean activarnombre_unidadProcesoFacturasProductos) {
		this.activarnombre_unidadProcesoFacturasProductos= activarnombre_unidadProcesoFacturasProductos;
	}

	public Border setResaltarprecioProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltarprecioProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioProcesoFacturasProductos() {
		return this.resaltarprecioProcesoFacturasProductos;
	}

	public void setResaltarprecioProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarprecioProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrarprecioProcesoFacturasProductos() {
		return this.mostrarprecioProcesoFacturasProductos;
	}

	public void setMostrarprecioProcesoFacturasProductos(Boolean mostrarprecioProcesoFacturasProductos) {
		this.mostrarprecioProcesoFacturasProductos= mostrarprecioProcesoFacturasProductos;
	}

	public Boolean getActivarprecioProcesoFacturasProductos() {
		return this.activarprecioProcesoFacturasProductos;
	}

	public void setActivarprecioProcesoFacturasProductos(Boolean activarprecioProcesoFacturasProductos) {
		this.activarprecioProcesoFacturasProductos= activarprecioProcesoFacturasProductos;
	}

	public Border setResaltartareaProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesofacturasproductosBeanSwingJInternalFrame.jTtoolBarProcesoFacturasProductos.setBorder(borderResaltar);
		
		this.resaltartareaProcesoFacturasProductos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartareaProcesoFacturasProductos() {
		return this.resaltartareaProcesoFacturasProductos;
	}

	public void setResaltartareaProcesoFacturasProductos(Border borderResaltar) {
		this.resaltartareaProcesoFacturasProductos= borderResaltar;
	}

	public Boolean getMostrartareaProcesoFacturasProductos() {
		return this.mostrartareaProcesoFacturasProductos;
	}

	public void setMostrartareaProcesoFacturasProductos(Boolean mostrartareaProcesoFacturasProductos) {
		this.mostrartareaProcesoFacturasProductos= mostrartareaProcesoFacturasProductos;
	}

	public Boolean getActivartareaProcesoFacturasProductos() {
		return this.activartareaProcesoFacturasProductos;
	}

	public void setActivartareaProcesoFacturasProductos(Boolean activartareaProcesoFacturasProductos) {
		this.activartareaProcesoFacturasProductos= activartareaProcesoFacturasProductos;
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
		
		
		this.setMostraridProcesoFacturasProductos(esInicial);
		this.setMostrarid_ciudadProcesoFacturasProductos(esInicial);
		this.setMostrarid_zonaProcesoFacturasProductos(esInicial);
		this.setMostrarid_grupo_clienteProcesoFacturasProductos(esInicial);
		this.setMostrarid_vendedorProcesoFacturasProductos(esInicial);
		this.setMostrarcodigoProcesoFacturasProductos(esInicial);
		this.setMostrarnombre_completoProcesoFacturasProductos(esInicial);
		this.setMostrarnombre_provinciaProcesoFacturasProductos(esInicial);
		this.setMostrarnombre_ciudadProcesoFacturasProductos(esInicial);
		this.setMostrarnombre_zonaProcesoFacturasProductos(esInicial);
		this.setMostrarnombre_grupo_clienteProcesoFacturasProductos(esInicial);
		this.setMostrarcodigo_datoProcesoFacturasProductos(esInicial);
		this.setMostrarnombre_completo_datoProcesoFacturasProductos(esInicial);
		this.setMostrarnumero_pre_impreso_facturaProcesoFacturasProductos(esInicial);
		this.setMostrarnombre_productoProcesoFacturasProductos(esInicial);
		this.setMostrarnombre_unidadProcesoFacturasProductos(esInicial);
		this.setMostrarprecioProcesoFacturasProductos(esInicial);
		this.setMostrartareaProcesoFacturasProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.ID)) {
				this.setMostraridProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setMostrarid_grupo_clienteProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREPROVINCIA)) {
				this.setMostrarnombre_provinciaProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBRECIUDAD)) {
				this.setMostrarnombre_ciudadProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREZONA)) {
				this.setMostrarnombre_zonaProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setMostrarnombre_grupo_clienteProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.CODIGODATO)) {
				this.setMostrarcodigo_datoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETODATO)) {
				this.setMostrarnombre_completo_datoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setMostrarnumero_pre_impreso_facturaProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.PRECIO)) {
				this.setMostrarprecioProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.TAREA)) {
				this.setMostrartareaProcesoFacturasProductos(esAsigna);
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
		
		
		this.setActivaridProcesoFacturasProductos(esInicial);
		this.setActivarid_ciudadProcesoFacturasProductos(esInicial);
		this.setActivarid_zonaProcesoFacturasProductos(esInicial);
		this.setActivarid_grupo_clienteProcesoFacturasProductos(esInicial);
		this.setActivarid_vendedorProcesoFacturasProductos(esInicial);
		this.setActivarcodigoProcesoFacturasProductos(esInicial);
		this.setActivarnombre_completoProcesoFacturasProductos(esInicial);
		this.setActivarnombre_provinciaProcesoFacturasProductos(esInicial);
		this.setActivarnombre_ciudadProcesoFacturasProductos(esInicial);
		this.setActivarnombre_zonaProcesoFacturasProductos(esInicial);
		this.setActivarnombre_grupo_clienteProcesoFacturasProductos(esInicial);
		this.setActivarcodigo_datoProcesoFacturasProductos(esInicial);
		this.setActivarnombre_completo_datoProcesoFacturasProductos(esInicial);
		this.setActivarnumero_pre_impreso_facturaProcesoFacturasProductos(esInicial);
		this.setActivarnombre_productoProcesoFacturasProductos(esInicial);
		this.setActivarnombre_unidadProcesoFacturasProductos(esInicial);
		this.setActivarprecioProcesoFacturasProductos(esInicial);
		this.setActivartareaProcesoFacturasProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.ID)) {
				this.setActivaridProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setActivarid_grupo_clienteProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREPROVINCIA)) {
				this.setActivarnombre_provinciaProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBRECIUDAD)) {
				this.setActivarnombre_ciudadProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREZONA)) {
				this.setActivarnombre_zonaProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setActivarnombre_grupo_clienteProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.CODIGODATO)) {
				this.setActivarcodigo_datoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETODATO)) {
				this.setActivarnombre_completo_datoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setActivarnumero_pre_impreso_facturaProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.PRECIO)) {
				this.setActivarprecioProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.TAREA)) {
				this.setActivartareaProcesoFacturasProductos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoFacturasProductos(esInicial);
		this.setResaltarid_ciudadProcesoFacturasProductos(esInicial);
		this.setResaltarid_zonaProcesoFacturasProductos(esInicial);
		this.setResaltarid_grupo_clienteProcesoFacturasProductos(esInicial);
		this.setResaltarid_vendedorProcesoFacturasProductos(esInicial);
		this.setResaltarcodigoProcesoFacturasProductos(esInicial);
		this.setResaltarnombre_completoProcesoFacturasProductos(esInicial);
		this.setResaltarnombre_provinciaProcesoFacturasProductos(esInicial);
		this.setResaltarnombre_ciudadProcesoFacturasProductos(esInicial);
		this.setResaltarnombre_zonaProcesoFacturasProductos(esInicial);
		this.setResaltarnombre_grupo_clienteProcesoFacturasProductos(esInicial);
		this.setResaltarcodigo_datoProcesoFacturasProductos(esInicial);
		this.setResaltarnombre_completo_datoProcesoFacturasProductos(esInicial);
		this.setResaltarnumero_pre_impreso_facturaProcesoFacturasProductos(esInicial);
		this.setResaltarnombre_productoProcesoFacturasProductos(esInicial);
		this.setResaltarnombre_unidadProcesoFacturasProductos(esInicial);
		this.setResaltarprecioProcesoFacturasProductos(esInicial);
		this.setResaltartareaProcesoFacturasProductos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.ID)) {
				this.setResaltaridProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setResaltarid_grupo_clienteProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREPROVINCIA)) {
				this.setResaltarnombre_provinciaProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBRECIUDAD)) {
				this.setResaltarnombre_ciudadProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREZONA)) {
				this.setResaltarnombre_zonaProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setResaltarnombre_grupo_clienteProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.CODIGODATO)) {
				this.setResaltarcodigo_datoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBRECOMPLETODATO)) {
				this.setResaltarnombre_completo_datoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setResaltarnumero_pre_impreso_facturaProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.PRECIO)) {
				this.setResaltarprecioProcesoFacturasProductos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoFacturasProductosConstantesFunciones.TAREA)) {
				this.setResaltartareaProcesoFacturasProductos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoFacturasProductosProcesoFacturasProductos=true;

	public Boolean getMostrarBusquedaProcesoFacturasProductosProcesoFacturasProductos() {
		return this.mostrarBusquedaProcesoFacturasProductosProcesoFacturasProductos;
	}

	public void setMostrarBusquedaProcesoFacturasProductosProcesoFacturasProductos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoFacturasProductosProcesoFacturasProductos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoFacturasProductosProcesoFacturasProductos=true;

	public Boolean getActivarBusquedaProcesoFacturasProductosProcesoFacturasProductos() {
		return this.activarBusquedaProcesoFacturasProductosProcesoFacturasProductos;
	}

	public void setActivarBusquedaProcesoFacturasProductosProcesoFacturasProductos(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoFacturasProductosProcesoFacturasProductos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoFacturasProductosProcesoFacturasProductos=null;

	public Border getResaltarBusquedaProcesoFacturasProductosProcesoFacturasProductos() {
		return this.resaltarBusquedaProcesoFacturasProductosProcesoFacturasProductos;
	}

	public void setResaltarBusquedaProcesoFacturasProductosProcesoFacturasProductos(Border borderResaltar) {
		this.resaltarBusquedaProcesoFacturasProductosProcesoFacturasProductos= borderResaltar;
	}

	public void setResaltarBusquedaProcesoFacturasProductosProcesoFacturasProductos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoFacturasProductosBeanSwingJInternalFrame procesofacturasproductosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoFacturasProductosProcesoFacturasProductos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}