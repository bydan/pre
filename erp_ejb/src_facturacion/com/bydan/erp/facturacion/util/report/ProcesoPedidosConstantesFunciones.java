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


import com.bydan.erp.facturacion.util.report.ProcesoPedidosConstantesFunciones;
import com.bydan.erp.facturacion.util.report.ProcesoPedidosParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.ProcesoPedidosParameterGeneral;

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
final public class ProcesoPedidosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoPedidos";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoPedidos"+ProcesoPedidosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoPedidosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoPedidosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoPedidosConstantesFunciones.SCHEMA+"_"+ProcesoPedidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoPedidosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoPedidosConstantesFunciones.SCHEMA+"_"+ProcesoPedidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoPedidosConstantesFunciones.SCHEMA+"_"+ProcesoPedidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoPedidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoPedidosConstantesFunciones.SCHEMA+"_"+ProcesoPedidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoPedidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoPedidosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoPedidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoPedidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoPedidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoPedidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoPedidosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoPedidosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoPedidosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoPedidosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Pedidoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Pedidos";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Pedidos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoPedidos";
	public static final String OBJECTNAME="procesopedidos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="proceso_pedidos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesopedidos from "+ProcesoPedidosConstantesFunciones.SPERSISTENCENAME+" procesopedidos";
	public static String QUERYSELECTNATIVE="select "+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".id,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".version_row,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".id_ciudad,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".id_zona,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".id_grupo_cliente,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".id_vendedor,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".nombre_provincia,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".nombre_ciudad,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".nombre_zona,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".nombre_grupo_cliente,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".nombre_vendedor,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".codigo,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".nombre_completo,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".numero,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".numero_autorizacion,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".total,"+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME+".fecha_emision from "+ProcesoPedidosConstantesFunciones.SCHEMA+"."+ProcesoPedidosConstantesFunciones.TABLENAME;//+" as "+ProcesoPedidosConstantesFunciones.TABLENAME;
	
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
    public static final String NOMBREPROVINCIA= "nombre_provincia";
    public static final String NOMBRECIUDAD= "nombre_ciudad";
    public static final String NOMBREZONA= "nombre_zona";
    public static final String NOMBREGRUPOCLIENTE= "nombre_grupo_cliente";
    public static final String NOMBREVENDEDOR= "nombre_vendedor";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String NUMERO= "numero";
    public static final String NUMEROAUTORIZACION= "numero_autorizacion";
    public static final String TOTAL= "total";
    public static final String FECHAEMISION= "fecha_emision";
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
    	public static final String LABEL_NOMBREPROVINCIA= "Nombre Provincia";
		public static final String LABEL_NOMBREPROVINCIA_LOWER= "Nombre Provincia";
    	public static final String LABEL_NOMBRECIUDAD= "Nombre Ciudad";
		public static final String LABEL_NOMBRECIUDAD_LOWER= "Nombre Ciudad";
    	public static final String LABEL_NOMBREZONA= "Nombre Zona";
		public static final String LABEL_NOMBREZONA_LOWER= "Nombre Zona";
    	public static final String LABEL_NOMBREGRUPOCLIENTE= "Nombre Grupo Cliente";
		public static final String LABEL_NOMBREGRUPOCLIENTE_LOWER= "Nombre Grupo Cliente";
    	public static final String LABEL_NOMBREVENDEDOR= "Nombre Vendedor";
		public static final String LABEL_NOMBREVENDEDOR_LOWER= "Nombre Vendedor";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_NUMEROAUTORIZACION= "Numero Autorizacion";
		public static final String LABEL_NUMEROAUTORIZACION_LOWER= "Numero Autorizacion";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_PROVINCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PROVINCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CIUDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CIUDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_ZONA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ZONA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getProcesoPedidosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.IDCIUDAD)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.IDZONA)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.IDGRUPOCLIENTE)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_IDGRUPOCLIENTE;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.IDVENDEDOR)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.NOMBREPROVINCIA)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_NOMBREPROVINCIA;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.NOMBRECIUDAD)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_NOMBRECIUDAD;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.NOMBREZONA)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_NOMBREZONA;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.NOMBREGRUPOCLIENTE)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.NOMBREVENDEDOR)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_NOMBREVENDEDOR;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.CODIGO)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.NUMERO)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.NUMEROAUTORIZACION)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_NUMEROAUTORIZACION;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.TOTAL)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(ProcesoPedidosConstantesFunciones.FECHAEMISION)) {sLabelColumna=ProcesoPedidosConstantesFunciones.LABEL_FECHAEMISION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProcesoPedidosDescripcion(ProcesoPedidos procesopedidos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesopedidos !=null/* && procesopedidos.getId()!=0*/) {
			sDescripcion=procesopedidos.getcodigo();//procesopedidosprocesopedidos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoPedidosDescripcionDetallado(ProcesoPedidos procesopedidos) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoPedidosConstantesFunciones.ID+"=";
		sDescripcion+=procesopedidos.getId().toString()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesopedidos.getVersionRow().toString()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=procesopedidos.getid_ciudad().toString()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.IDZONA+"=";
		sDescripcion+=procesopedidos.getid_zona().toString()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.IDGRUPOCLIENTE+"=";
		sDescripcion+=procesopedidos.getid_grupo_cliente().toString()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=procesopedidos.getid_vendedor().toString()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.NOMBREPROVINCIA+"=";
		sDescripcion+=procesopedidos.getnombre_provincia()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.NOMBRECIUDAD+"=";
		sDescripcion+=procesopedidos.getnombre_ciudad()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.NOMBREZONA+"=";
		sDescripcion+=procesopedidos.getnombre_zona()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.NOMBREGRUPOCLIENTE+"=";
		sDescripcion+=procesopedidos.getnombre_grupo_cliente()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.NOMBREVENDEDOR+"=";
		sDescripcion+=procesopedidos.getnombre_vendedor()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.CODIGO+"=";
		sDescripcion+=procesopedidos.getcodigo()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=procesopedidos.getnombre_completo()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.NUMERO+"=";
		sDescripcion+=procesopedidos.getnumero()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.NUMEROAUTORIZACION+"=";
		sDescripcion+=procesopedidos.getnumero_autorizacion()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.TOTAL+"=";
		sDescripcion+=procesopedidos.gettotal().toString()+",";
		sDescripcion+=ProcesoPedidosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=procesopedidos.getfecha_emision().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoPedidosDescripcion(ProcesoPedidos procesopedidos,String sValor) throws Exception {			
		if(procesopedidos !=null) {
			procesopedidos.setcodigo(sValor);;//procesopedidosprocesopedidos.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaProcesoPedidos")) {
			sNombreIndice="Tipo=  Por Ciudad Por Zona Por Grupo Cliente Por Vendedor";
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

	public static String getDetalleIndiceBusquedaProcesoPedidos(Long id_ciudad,Long id_zona,Long id_grupo_cliente,Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();}
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();}
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();}
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProcesoPedidos(ProcesoPedidos procesopedidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesopedidos.setnombre_provincia(procesopedidos.getnombre_provincia().trim());
		procesopedidos.setnombre_ciudad(procesopedidos.getnombre_ciudad().trim());
		procesopedidos.setnombre_zona(procesopedidos.getnombre_zona().trim());
		procesopedidos.setnombre_grupo_cliente(procesopedidos.getnombre_grupo_cliente().trim());
		procesopedidos.setnombre_vendedor(procesopedidos.getnombre_vendedor().trim());
		procesopedidos.setcodigo(procesopedidos.getcodigo().trim());
		procesopedidos.setnombre_completo(procesopedidos.getnombre_completo().trim());
		procesopedidos.setnumero(procesopedidos.getnumero().trim());
		procesopedidos.setnumero_autorizacion(procesopedidos.getnumero_autorizacion().trim());
	}
	
	public static void quitarEspaciosProcesoPedidoss(List<ProcesoPedidos> procesopedidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoPedidos procesopedidos: procesopedidoss) {
			procesopedidos.setnombre_provincia(procesopedidos.getnombre_provincia().trim());
			procesopedidos.setnombre_ciudad(procesopedidos.getnombre_ciudad().trim());
			procesopedidos.setnombre_zona(procesopedidos.getnombre_zona().trim());
			procesopedidos.setnombre_grupo_cliente(procesopedidos.getnombre_grupo_cliente().trim());
			procesopedidos.setnombre_vendedor(procesopedidos.getnombre_vendedor().trim());
			procesopedidos.setcodigo(procesopedidos.getcodigo().trim());
			procesopedidos.setnombre_completo(procesopedidos.getnombre_completo().trim());
			procesopedidos.setnumero(procesopedidos.getnumero().trim());
			procesopedidos.setnumero_autorizacion(procesopedidos.getnumero_autorizacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoPedidos(ProcesoPedidos procesopedidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesopedidos.getConCambioAuxiliar()) {
			procesopedidos.setIsDeleted(procesopedidos.getIsDeletedAuxiliar());	
			procesopedidos.setIsNew(procesopedidos.getIsNewAuxiliar());	
			procesopedidos.setIsChanged(procesopedidos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesopedidos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesopedidos.setIsDeletedAuxiliar(false);	
			procesopedidos.setIsNewAuxiliar(false);	
			procesopedidos.setIsChangedAuxiliar(false);
			
			procesopedidos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoPedidoss(List<ProcesoPedidos> procesopedidoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoPedidos procesopedidos : procesopedidoss) {
			if(conAsignarBase && procesopedidos.getConCambioAuxiliar()) {
				procesopedidos.setIsDeleted(procesopedidos.getIsDeletedAuxiliar());	
				procesopedidos.setIsNew(procesopedidos.getIsNewAuxiliar());	
				procesopedidos.setIsChanged(procesopedidos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesopedidos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesopedidos.setIsDeletedAuxiliar(false);	
				procesopedidos.setIsNewAuxiliar(false);	
				procesopedidos.setIsChangedAuxiliar(false);
				
				procesopedidos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoPedidos(ProcesoPedidos procesopedidos,Boolean conEnteros) throws Exception  {
		procesopedidos.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoPedidoss(List<ProcesoPedidos> procesopedidoss,Boolean conEnteros) throws Exception  {
		
		for(ProcesoPedidos procesopedidos: procesopedidoss) {
			procesopedidos.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoPedidos(List<ProcesoPedidos> procesopedidoss,ProcesoPedidos procesopedidosAux) throws Exception  {
		ProcesoPedidosConstantesFunciones.InicializarValoresProcesoPedidos(procesopedidosAux,true);
		
		for(ProcesoPedidos procesopedidos: procesopedidoss) {
			if(procesopedidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			procesopedidosAux.settotal(procesopedidosAux.gettotal()+procesopedidos.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoPedidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoPedidosConstantesFunciones.getArrayColumnasGlobalesProcesoPedidos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoPedidos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoPedidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoPedidos> procesopedidoss,ProcesoPedidos procesopedidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoPedidos procesopedidosAux: procesopedidoss) {
			if(procesopedidosAux!=null && procesopedidos!=null) {
				if((procesopedidosAux.getId()==null && procesopedidos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesopedidosAux.getId()!=null && procesopedidos.getId()!=null){
					if(procesopedidosAux.getId().equals(procesopedidos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoPedidos(List<ProcesoPedidos> procesopedidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
	
		for(ProcesoPedidos procesopedidos: procesopedidoss) {			
			if(procesopedidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalTotal+=procesopedidos.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoPedidosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoPedidos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProcesoPedidosConstantesFunciones.LABEL_ID, ProcesoPedidosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPedidosConstantesFunciones.LABEL_VERSIONROW, ProcesoPedidosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPedidosConstantesFunciones.LABEL_NOMBREPROVINCIA, ProcesoPedidosConstantesFunciones.NOMBREPROVINCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPedidosConstantesFunciones.LABEL_NOMBRECIUDAD, ProcesoPedidosConstantesFunciones.NOMBRECIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPedidosConstantesFunciones.LABEL_NOMBREZONA, ProcesoPedidosConstantesFunciones.NOMBREZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPedidosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE, ProcesoPedidosConstantesFunciones.NOMBREGRUPOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPedidosConstantesFunciones.LABEL_NOMBREVENDEDOR, ProcesoPedidosConstantesFunciones.NOMBREVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPedidosConstantesFunciones.LABEL_CODIGO, ProcesoPedidosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPedidosConstantesFunciones.LABEL_NOMBRECOMPLETO, ProcesoPedidosConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPedidosConstantesFunciones.LABEL_NUMERO, ProcesoPedidosConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPedidosConstantesFunciones.LABEL_NUMEROAUTORIZACION, ProcesoPedidosConstantesFunciones.NUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPedidosConstantesFunciones.LABEL_TOTAL, ProcesoPedidosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoPedidosConstantesFunciones.LABEL_FECHAEMISION, ProcesoPedidosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoPedidos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProcesoPedidosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPedidosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPedidosConstantesFunciones.NOMBREPROVINCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPedidosConstantesFunciones.NOMBRECIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPedidosConstantesFunciones.NOMBREZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPedidosConstantesFunciones.NOMBREGRUPOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPedidosConstantesFunciones.NOMBREVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPedidosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPedidosConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPedidosConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPedidosConstantesFunciones.NUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPedidosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoPedidosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoPedidos() throws Exception  {
		return ProcesoPedidosConstantesFunciones.getTiposSeleccionarProcesoPedidos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoPedidos(Boolean conFk) throws Exception  {
		return ProcesoPedidosConstantesFunciones.getTiposSeleccionarProcesoPedidos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoPedidos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_IDGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_NOMBREPROVINCIA);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_NOMBREPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_NOMBRECIUDAD);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_NOMBRECIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_NOMBREZONA);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_NOMBREZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_NOMBREVENDEDOR);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_NOMBREVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_NUMEROAUTORIZACION);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_NUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoPedidosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(ProcesoPedidosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoPedidos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoPedidos(ProcesoPedidos procesopedidosAux) throws Exception {
		
			procesopedidosAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(procesopedidosAux.getCiudad()));
			procesopedidosAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(procesopedidosAux.getZona()));
			procesopedidosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(procesopedidosAux.getGrupoCliente()));
			procesopedidosAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(procesopedidosAux.getVendedor()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoPedidos(List<ProcesoPedidos> procesopedidossTemp) throws Exception {
		for(ProcesoPedidos procesopedidosAux:procesopedidossTemp) {
			
			procesopedidosAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(procesopedidosAux.getCiudad()));
			procesopedidosAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(procesopedidosAux.getZona()));
			procesopedidosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(procesopedidosAux.getGrupoCliente()));
			procesopedidosAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(procesopedidosAux.getVendedor()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoPedidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoPedidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoPedidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoPedidosConstantesFunciones.getClassesRelationshipsOfProcesoPedidos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoPedidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoPedidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoPedidosConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoPedidos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoPedidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoPedidos procesopedidos,List<ProcesoPedidos> procesopedidoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoPedidos procesopedidos,List<ProcesoPedidos> procesopedidoss) throws Exception {
		try	{			
			for(ProcesoPedidos procesopedidosLocal:procesopedidoss) {
				if(procesopedidosLocal.getId().equals(procesopedidos.getId())) {
					procesopedidosLocal.setIsSelected(procesopedidos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoPedidos(List<ProcesoPedidos> procesopedidossAux) throws Exception {
		//this.procesopedidossAux=procesopedidossAux;
		
		for(ProcesoPedidos procesopedidosAux:procesopedidossAux) {
			if(procesopedidosAux.getIsChanged()) {
				procesopedidosAux.setIsChanged(false);
			}		
			
			if(procesopedidosAux.getIsNew()) {
				procesopedidosAux.setIsNew(false);
			}	
			
			if(procesopedidosAux.getIsDeleted()) {
				procesopedidosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoPedidos(ProcesoPedidos procesopedidosAux) throws Exception {
		//this.procesopedidosAux=procesopedidosAux;
		
			if(procesopedidosAux.getIsChanged()) {
				procesopedidosAux.setIsChanged(false);
			}		
			
			if(procesopedidosAux.getIsNew()) {
				procesopedidosAux.setIsNew(false);
			}	
			
			if(procesopedidosAux.getIsDeleted()) {
				procesopedidosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoPedidos procesopedidosAsignar,ProcesoPedidos procesopedidos) throws Exception {
		procesopedidosAsignar.setId(procesopedidos.getId());	
		procesopedidosAsignar.setVersionRow(procesopedidos.getVersionRow());	
		procesopedidosAsignar.setnombre_provincia(procesopedidos.getnombre_provincia());	
		procesopedidosAsignar.setnombre_ciudad(procesopedidos.getnombre_ciudad());	
		procesopedidosAsignar.setnombre_zona(procesopedidos.getnombre_zona());	
		procesopedidosAsignar.setnombre_grupo_cliente(procesopedidos.getnombre_grupo_cliente());	
		procesopedidosAsignar.setnombre_vendedor(procesopedidos.getnombre_vendedor());	
		procesopedidosAsignar.setcodigo(procesopedidos.getcodigo());	
		procesopedidosAsignar.setnombre_completo(procesopedidos.getnombre_completo());	
		procesopedidosAsignar.setnumero(procesopedidos.getnumero());	
		procesopedidosAsignar.setnumero_autorizacion(procesopedidos.getnumero_autorizacion());	
		procesopedidosAsignar.settotal(procesopedidos.gettotal());	
		procesopedidosAsignar.setfecha_emision(procesopedidos.getfecha_emision());	
	}
	
	public static void inicializarProcesoPedidos(ProcesoPedidos procesopedidos) throws Exception {
		try {
				procesopedidos.setId(0L);	
					
				procesopedidos.setnombre_provincia("");	
				procesopedidos.setnombre_ciudad("");	
				procesopedidos.setnombre_zona("");	
				procesopedidos.setnombre_grupo_cliente("");	
				procesopedidos.setnombre_vendedor("");	
				procesopedidos.setcodigo("");	
				procesopedidos.setnombre_completo("");	
				procesopedidos.setnumero("");	
				procesopedidos.setnumero_autorizacion("");	
				procesopedidos.settotal(0.0);	
				procesopedidos.setfecha_emision(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoPedidos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_NOMBREPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_NOMBRECIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_NOMBREZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_NOMBREVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_NUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoPedidosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoPedidos(String sTipo,Row row,Workbook workbook,ProcesoPedidos procesopedidos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getgrupocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getnombre_provincia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getnombre_ciudad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getnombre_zona());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getnombre_grupo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getnombre_vendedor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getnumero_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesopedidos.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoPedidos="";
	
	public String getsFinalQueryProcesoPedidos() {
		return this.sFinalQueryProcesoPedidos;
	}
	
	public void setsFinalQueryProcesoPedidos(String sFinalQueryProcesoPedidos) {
		this.sFinalQueryProcesoPedidos= sFinalQueryProcesoPedidos;
	}
	
	public Border resaltarSeleccionarProcesoPedidos=null;
	
	public Border setResaltarSeleccionarProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoPedidos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoPedidos() {
		return this.resaltarSeleccionarProcesoPedidos;
	}
	
	public void setResaltarSeleccionarProcesoPedidos(Border borderResaltarSeleccionarProcesoPedidos) {
		this.resaltarSeleccionarProcesoPedidos= borderResaltarSeleccionarProcesoPedidos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoPedidos=null;
	public Boolean mostraridProcesoPedidos=true;
	public Boolean activaridProcesoPedidos=true;

	public Border resaltarid_ciudadProcesoPedidos=null;
	public Boolean mostrarid_ciudadProcesoPedidos=true;
	public Boolean activarid_ciudadProcesoPedidos=true;
	public Boolean cargarid_ciudadProcesoPedidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadProcesoPedidos=false;//ConEventDepend=true

	public Border resaltarid_zonaProcesoPedidos=null;
	public Boolean mostrarid_zonaProcesoPedidos=true;
	public Boolean activarid_zonaProcesoPedidos=true;
	public Boolean cargarid_zonaProcesoPedidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaProcesoPedidos=false;//ConEventDepend=true

	public Border resaltarid_grupo_clienteProcesoPedidos=null;
	public Boolean mostrarid_grupo_clienteProcesoPedidos=true;
	public Boolean activarid_grupo_clienteProcesoPedidos=true;
	public Boolean cargarid_grupo_clienteProcesoPedidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_clienteProcesoPedidos=false;//ConEventDepend=true

	public Border resaltarid_vendedorProcesoPedidos=null;
	public Boolean mostrarid_vendedorProcesoPedidos=true;
	public Boolean activarid_vendedorProcesoPedidos=true;
	public Boolean cargarid_vendedorProcesoPedidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorProcesoPedidos=false;//ConEventDepend=true

	public Border resaltarnombre_provinciaProcesoPedidos=null;
	public Boolean mostrarnombre_provinciaProcesoPedidos=true;
	public Boolean activarnombre_provinciaProcesoPedidos=true;

	public Border resaltarnombre_ciudadProcesoPedidos=null;
	public Boolean mostrarnombre_ciudadProcesoPedidos=true;
	public Boolean activarnombre_ciudadProcesoPedidos=true;

	public Border resaltarnombre_zonaProcesoPedidos=null;
	public Boolean mostrarnombre_zonaProcesoPedidos=true;
	public Boolean activarnombre_zonaProcesoPedidos=true;

	public Border resaltarnombre_grupo_clienteProcesoPedidos=null;
	public Boolean mostrarnombre_grupo_clienteProcesoPedidos=true;
	public Boolean activarnombre_grupo_clienteProcesoPedidos=true;

	public Border resaltarnombre_vendedorProcesoPedidos=null;
	public Boolean mostrarnombre_vendedorProcesoPedidos=true;
	public Boolean activarnombre_vendedorProcesoPedidos=true;

	public Border resaltarcodigoProcesoPedidos=null;
	public Boolean mostrarcodigoProcesoPedidos=true;
	public Boolean activarcodigoProcesoPedidos=true;

	public Border resaltarnombre_completoProcesoPedidos=null;
	public Boolean mostrarnombre_completoProcesoPedidos=true;
	public Boolean activarnombre_completoProcesoPedidos=true;

	public Border resaltarnumeroProcesoPedidos=null;
	public Boolean mostrarnumeroProcesoPedidos=true;
	public Boolean activarnumeroProcesoPedidos=true;

	public Border resaltarnumero_autorizacionProcesoPedidos=null;
	public Boolean mostrarnumero_autorizacionProcesoPedidos=true;
	public Boolean activarnumero_autorizacionProcesoPedidos=true;

	public Border resaltartotalProcesoPedidos=null;
	public Boolean mostrartotalProcesoPedidos=true;
	public Boolean activartotalProcesoPedidos=true;

	public Border resaltarfecha_emisionProcesoPedidos=null;
	public Boolean mostrarfecha_emisionProcesoPedidos=true;
	public Boolean activarfecha_emisionProcesoPedidos=true;

	
	

	public Border setResaltaridProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltaridProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoPedidos() {
		return this.resaltaridProcesoPedidos;
	}

	public void setResaltaridProcesoPedidos(Border borderResaltar) {
		this.resaltaridProcesoPedidos= borderResaltar;
	}

	public Boolean getMostraridProcesoPedidos() {
		return this.mostraridProcesoPedidos;
	}

	public void setMostraridProcesoPedidos(Boolean mostraridProcesoPedidos) {
		this.mostraridProcesoPedidos= mostraridProcesoPedidos;
	}

	public Boolean getActivaridProcesoPedidos() {
		return this.activaridProcesoPedidos;
	}

	public void setActivaridProcesoPedidos(Boolean activaridProcesoPedidos) {
		this.activaridProcesoPedidos= activaridProcesoPedidos;
	}

	public Border setResaltarid_ciudadProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarid_ciudadProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadProcesoPedidos() {
		return this.resaltarid_ciudadProcesoPedidos;
	}

	public void setResaltarid_ciudadProcesoPedidos(Border borderResaltar) {
		this.resaltarid_ciudadProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarid_ciudadProcesoPedidos() {
		return this.mostrarid_ciudadProcesoPedidos;
	}

	public void setMostrarid_ciudadProcesoPedidos(Boolean mostrarid_ciudadProcesoPedidos) {
		this.mostrarid_ciudadProcesoPedidos= mostrarid_ciudadProcesoPedidos;
	}

	public Boolean getActivarid_ciudadProcesoPedidos() {
		return this.activarid_ciudadProcesoPedidos;
	}

	public void setActivarid_ciudadProcesoPedidos(Boolean activarid_ciudadProcesoPedidos) {
		this.activarid_ciudadProcesoPedidos= activarid_ciudadProcesoPedidos;
	}

	public Boolean getCargarid_ciudadProcesoPedidos() {
		return this.cargarid_ciudadProcesoPedidos;
	}

	public void setCargarid_ciudadProcesoPedidos(Boolean cargarid_ciudadProcesoPedidos) {
		this.cargarid_ciudadProcesoPedidos= cargarid_ciudadProcesoPedidos;
	}

	public Border setResaltarid_zonaProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarid_zonaProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaProcesoPedidos() {
		return this.resaltarid_zonaProcesoPedidos;
	}

	public void setResaltarid_zonaProcesoPedidos(Border borderResaltar) {
		this.resaltarid_zonaProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarid_zonaProcesoPedidos() {
		return this.mostrarid_zonaProcesoPedidos;
	}

	public void setMostrarid_zonaProcesoPedidos(Boolean mostrarid_zonaProcesoPedidos) {
		this.mostrarid_zonaProcesoPedidos= mostrarid_zonaProcesoPedidos;
	}

	public Boolean getActivarid_zonaProcesoPedidos() {
		return this.activarid_zonaProcesoPedidos;
	}

	public void setActivarid_zonaProcesoPedidos(Boolean activarid_zonaProcesoPedidos) {
		this.activarid_zonaProcesoPedidos= activarid_zonaProcesoPedidos;
	}

	public Boolean getCargarid_zonaProcesoPedidos() {
		return this.cargarid_zonaProcesoPedidos;
	}

	public void setCargarid_zonaProcesoPedidos(Boolean cargarid_zonaProcesoPedidos) {
		this.cargarid_zonaProcesoPedidos= cargarid_zonaProcesoPedidos;
	}

	public Border setResaltarid_grupo_clienteProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarid_grupo_clienteProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_clienteProcesoPedidos() {
		return this.resaltarid_grupo_clienteProcesoPedidos;
	}

	public void setResaltarid_grupo_clienteProcesoPedidos(Border borderResaltar) {
		this.resaltarid_grupo_clienteProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarid_grupo_clienteProcesoPedidos() {
		return this.mostrarid_grupo_clienteProcesoPedidos;
	}

	public void setMostrarid_grupo_clienteProcesoPedidos(Boolean mostrarid_grupo_clienteProcesoPedidos) {
		this.mostrarid_grupo_clienteProcesoPedidos= mostrarid_grupo_clienteProcesoPedidos;
	}

	public Boolean getActivarid_grupo_clienteProcesoPedidos() {
		return this.activarid_grupo_clienteProcesoPedidos;
	}

	public void setActivarid_grupo_clienteProcesoPedidos(Boolean activarid_grupo_clienteProcesoPedidos) {
		this.activarid_grupo_clienteProcesoPedidos= activarid_grupo_clienteProcesoPedidos;
	}

	public Boolean getCargarid_grupo_clienteProcesoPedidos() {
		return this.cargarid_grupo_clienteProcesoPedidos;
	}

	public void setCargarid_grupo_clienteProcesoPedidos(Boolean cargarid_grupo_clienteProcesoPedidos) {
		this.cargarid_grupo_clienteProcesoPedidos= cargarid_grupo_clienteProcesoPedidos;
	}

	public Border setResaltarid_vendedorProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarid_vendedorProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorProcesoPedidos() {
		return this.resaltarid_vendedorProcesoPedidos;
	}

	public void setResaltarid_vendedorProcesoPedidos(Border borderResaltar) {
		this.resaltarid_vendedorProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarid_vendedorProcesoPedidos() {
		return this.mostrarid_vendedorProcesoPedidos;
	}

	public void setMostrarid_vendedorProcesoPedidos(Boolean mostrarid_vendedorProcesoPedidos) {
		this.mostrarid_vendedorProcesoPedidos= mostrarid_vendedorProcesoPedidos;
	}

	public Boolean getActivarid_vendedorProcesoPedidos() {
		return this.activarid_vendedorProcesoPedidos;
	}

	public void setActivarid_vendedorProcesoPedidos(Boolean activarid_vendedorProcesoPedidos) {
		this.activarid_vendedorProcesoPedidos= activarid_vendedorProcesoPedidos;
	}

	public Boolean getCargarid_vendedorProcesoPedidos() {
		return this.cargarid_vendedorProcesoPedidos;
	}

	public void setCargarid_vendedorProcesoPedidos(Boolean cargarid_vendedorProcesoPedidos) {
		this.cargarid_vendedorProcesoPedidos= cargarid_vendedorProcesoPedidos;
	}

	public Border setResaltarnombre_provinciaProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarnombre_provinciaProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_provinciaProcesoPedidos() {
		return this.resaltarnombre_provinciaProcesoPedidos;
	}

	public void setResaltarnombre_provinciaProcesoPedidos(Border borderResaltar) {
		this.resaltarnombre_provinciaProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarnombre_provinciaProcesoPedidos() {
		return this.mostrarnombre_provinciaProcesoPedidos;
	}

	public void setMostrarnombre_provinciaProcesoPedidos(Boolean mostrarnombre_provinciaProcesoPedidos) {
		this.mostrarnombre_provinciaProcesoPedidos= mostrarnombre_provinciaProcesoPedidos;
	}

	public Boolean getActivarnombre_provinciaProcesoPedidos() {
		return this.activarnombre_provinciaProcesoPedidos;
	}

	public void setActivarnombre_provinciaProcesoPedidos(Boolean activarnombre_provinciaProcesoPedidos) {
		this.activarnombre_provinciaProcesoPedidos= activarnombre_provinciaProcesoPedidos;
	}

	public Border setResaltarnombre_ciudadProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarnombre_ciudadProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_ciudadProcesoPedidos() {
		return this.resaltarnombre_ciudadProcesoPedidos;
	}

	public void setResaltarnombre_ciudadProcesoPedidos(Border borderResaltar) {
		this.resaltarnombre_ciudadProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarnombre_ciudadProcesoPedidos() {
		return this.mostrarnombre_ciudadProcesoPedidos;
	}

	public void setMostrarnombre_ciudadProcesoPedidos(Boolean mostrarnombre_ciudadProcesoPedidos) {
		this.mostrarnombre_ciudadProcesoPedidos= mostrarnombre_ciudadProcesoPedidos;
	}

	public Boolean getActivarnombre_ciudadProcesoPedidos() {
		return this.activarnombre_ciudadProcesoPedidos;
	}

	public void setActivarnombre_ciudadProcesoPedidos(Boolean activarnombre_ciudadProcesoPedidos) {
		this.activarnombre_ciudadProcesoPedidos= activarnombre_ciudadProcesoPedidos;
	}

	public Border setResaltarnombre_zonaProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarnombre_zonaProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_zonaProcesoPedidos() {
		return this.resaltarnombre_zonaProcesoPedidos;
	}

	public void setResaltarnombre_zonaProcesoPedidos(Border borderResaltar) {
		this.resaltarnombre_zonaProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarnombre_zonaProcesoPedidos() {
		return this.mostrarnombre_zonaProcesoPedidos;
	}

	public void setMostrarnombre_zonaProcesoPedidos(Boolean mostrarnombre_zonaProcesoPedidos) {
		this.mostrarnombre_zonaProcesoPedidos= mostrarnombre_zonaProcesoPedidos;
	}

	public Boolean getActivarnombre_zonaProcesoPedidos() {
		return this.activarnombre_zonaProcesoPedidos;
	}

	public void setActivarnombre_zonaProcesoPedidos(Boolean activarnombre_zonaProcesoPedidos) {
		this.activarnombre_zonaProcesoPedidos= activarnombre_zonaProcesoPedidos;
	}

	public Border setResaltarnombre_grupo_clienteProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarnombre_grupo_clienteProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_grupo_clienteProcesoPedidos() {
		return this.resaltarnombre_grupo_clienteProcesoPedidos;
	}

	public void setResaltarnombre_grupo_clienteProcesoPedidos(Border borderResaltar) {
		this.resaltarnombre_grupo_clienteProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarnombre_grupo_clienteProcesoPedidos() {
		return this.mostrarnombre_grupo_clienteProcesoPedidos;
	}

	public void setMostrarnombre_grupo_clienteProcesoPedidos(Boolean mostrarnombre_grupo_clienteProcesoPedidos) {
		this.mostrarnombre_grupo_clienteProcesoPedidos= mostrarnombre_grupo_clienteProcesoPedidos;
	}

	public Boolean getActivarnombre_grupo_clienteProcesoPedidos() {
		return this.activarnombre_grupo_clienteProcesoPedidos;
	}

	public void setActivarnombre_grupo_clienteProcesoPedidos(Boolean activarnombre_grupo_clienteProcesoPedidos) {
		this.activarnombre_grupo_clienteProcesoPedidos= activarnombre_grupo_clienteProcesoPedidos;
	}

	public Border setResaltarnombre_vendedorProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarnombre_vendedorProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_vendedorProcesoPedidos() {
		return this.resaltarnombre_vendedorProcesoPedidos;
	}

	public void setResaltarnombre_vendedorProcesoPedidos(Border borderResaltar) {
		this.resaltarnombre_vendedorProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarnombre_vendedorProcesoPedidos() {
		return this.mostrarnombre_vendedorProcesoPedidos;
	}

	public void setMostrarnombre_vendedorProcesoPedidos(Boolean mostrarnombre_vendedorProcesoPedidos) {
		this.mostrarnombre_vendedorProcesoPedidos= mostrarnombre_vendedorProcesoPedidos;
	}

	public Boolean getActivarnombre_vendedorProcesoPedidos() {
		return this.activarnombre_vendedorProcesoPedidos;
	}

	public void setActivarnombre_vendedorProcesoPedidos(Boolean activarnombre_vendedorProcesoPedidos) {
		this.activarnombre_vendedorProcesoPedidos= activarnombre_vendedorProcesoPedidos;
	}

	public Border setResaltarcodigoProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarcodigoProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProcesoPedidos() {
		return this.resaltarcodigoProcesoPedidos;
	}

	public void setResaltarcodigoProcesoPedidos(Border borderResaltar) {
		this.resaltarcodigoProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarcodigoProcesoPedidos() {
		return this.mostrarcodigoProcesoPedidos;
	}

	public void setMostrarcodigoProcesoPedidos(Boolean mostrarcodigoProcesoPedidos) {
		this.mostrarcodigoProcesoPedidos= mostrarcodigoProcesoPedidos;
	}

	public Boolean getActivarcodigoProcesoPedidos() {
		return this.activarcodigoProcesoPedidos;
	}

	public void setActivarcodigoProcesoPedidos(Boolean activarcodigoProcesoPedidos) {
		this.activarcodigoProcesoPedidos= activarcodigoProcesoPedidos;
	}

	public Border setResaltarnombre_completoProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoProcesoPedidos() {
		return this.resaltarnombre_completoProcesoPedidos;
	}

	public void setResaltarnombre_completoProcesoPedidos(Border borderResaltar) {
		this.resaltarnombre_completoProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoProcesoPedidos() {
		return this.mostrarnombre_completoProcesoPedidos;
	}

	public void setMostrarnombre_completoProcesoPedidos(Boolean mostrarnombre_completoProcesoPedidos) {
		this.mostrarnombre_completoProcesoPedidos= mostrarnombre_completoProcesoPedidos;
	}

	public Boolean getActivarnombre_completoProcesoPedidos() {
		return this.activarnombre_completoProcesoPedidos;
	}

	public void setActivarnombre_completoProcesoPedidos(Boolean activarnombre_completoProcesoPedidos) {
		this.activarnombre_completoProcesoPedidos= activarnombre_completoProcesoPedidos;
	}

	public Border setResaltarnumeroProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarnumeroProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroProcesoPedidos() {
		return this.resaltarnumeroProcesoPedidos;
	}

	public void setResaltarnumeroProcesoPedidos(Border borderResaltar) {
		this.resaltarnumeroProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarnumeroProcesoPedidos() {
		return this.mostrarnumeroProcesoPedidos;
	}

	public void setMostrarnumeroProcesoPedidos(Boolean mostrarnumeroProcesoPedidos) {
		this.mostrarnumeroProcesoPedidos= mostrarnumeroProcesoPedidos;
	}

	public Boolean getActivarnumeroProcesoPedidos() {
		return this.activarnumeroProcesoPedidos;
	}

	public void setActivarnumeroProcesoPedidos(Boolean activarnumeroProcesoPedidos) {
		this.activarnumeroProcesoPedidos= activarnumeroProcesoPedidos;
	}

	public Border setResaltarnumero_autorizacionProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarnumero_autorizacionProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorizacionProcesoPedidos() {
		return this.resaltarnumero_autorizacionProcesoPedidos;
	}

	public void setResaltarnumero_autorizacionProcesoPedidos(Border borderResaltar) {
		this.resaltarnumero_autorizacionProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarnumero_autorizacionProcesoPedidos() {
		return this.mostrarnumero_autorizacionProcesoPedidos;
	}

	public void setMostrarnumero_autorizacionProcesoPedidos(Boolean mostrarnumero_autorizacionProcesoPedidos) {
		this.mostrarnumero_autorizacionProcesoPedidos= mostrarnumero_autorizacionProcesoPedidos;
	}

	public Boolean getActivarnumero_autorizacionProcesoPedidos() {
		return this.activarnumero_autorizacionProcesoPedidos;
	}

	public void setActivarnumero_autorizacionProcesoPedidos(Boolean activarnumero_autorizacionProcesoPedidos) {
		this.activarnumero_autorizacionProcesoPedidos= activarnumero_autorizacionProcesoPedidos;
	}

	public Border setResaltartotalProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltartotalProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalProcesoPedidos() {
		return this.resaltartotalProcesoPedidos;
	}

	public void setResaltartotalProcesoPedidos(Border borderResaltar) {
		this.resaltartotalProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrartotalProcesoPedidos() {
		return this.mostrartotalProcesoPedidos;
	}

	public void setMostrartotalProcesoPedidos(Boolean mostrartotalProcesoPedidos) {
		this.mostrartotalProcesoPedidos= mostrartotalProcesoPedidos;
	}

	public Boolean getActivartotalProcesoPedidos() {
		return this.activartotalProcesoPedidos;
	}

	public void setActivartotalProcesoPedidos(Boolean activartotalProcesoPedidos) {
		this.activartotalProcesoPedidos= activartotalProcesoPedidos;
	}

	public Border setResaltarfecha_emisionProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesopedidosBeanSwingJInternalFrame.jTtoolBarProcesoPedidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionProcesoPedidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionProcesoPedidos() {
		return this.resaltarfecha_emisionProcesoPedidos;
	}

	public void setResaltarfecha_emisionProcesoPedidos(Border borderResaltar) {
		this.resaltarfecha_emisionProcesoPedidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionProcesoPedidos() {
		return this.mostrarfecha_emisionProcesoPedidos;
	}

	public void setMostrarfecha_emisionProcesoPedidos(Boolean mostrarfecha_emisionProcesoPedidos) {
		this.mostrarfecha_emisionProcesoPedidos= mostrarfecha_emisionProcesoPedidos;
	}

	public Boolean getActivarfecha_emisionProcesoPedidos() {
		return this.activarfecha_emisionProcesoPedidos;
	}

	public void setActivarfecha_emisionProcesoPedidos(Boolean activarfecha_emisionProcesoPedidos) {
		this.activarfecha_emisionProcesoPedidos= activarfecha_emisionProcesoPedidos;
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
		
		
		this.setMostraridProcesoPedidos(esInicial);
		this.setMostrarid_ciudadProcesoPedidos(esInicial);
		this.setMostrarid_zonaProcesoPedidos(esInicial);
		this.setMostrarid_grupo_clienteProcesoPedidos(esInicial);
		this.setMostrarid_vendedorProcesoPedidos(esInicial);
		this.setMostrarnombre_provinciaProcesoPedidos(esInicial);
		this.setMostrarnombre_ciudadProcesoPedidos(esInicial);
		this.setMostrarnombre_zonaProcesoPedidos(esInicial);
		this.setMostrarnombre_grupo_clienteProcesoPedidos(esInicial);
		this.setMostrarnombre_vendedorProcesoPedidos(esInicial);
		this.setMostrarcodigoProcesoPedidos(esInicial);
		this.setMostrarnombre_completoProcesoPedidos(esInicial);
		this.setMostrarnumeroProcesoPedidos(esInicial);
		this.setMostrarnumero_autorizacionProcesoPedidos(esInicial);
		this.setMostrartotalProcesoPedidos(esInicial);
		this.setMostrarfecha_emisionProcesoPedidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.ID)) {
				this.setMostraridProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setMostrarid_grupo_clienteProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBREPROVINCIA)) {
				this.setMostrarnombre_provinciaProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBRECIUDAD)) {
				this.setMostrarnombre_ciudadProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBREZONA)) {
				this.setMostrarnombre_zonaProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setMostrarnombre_grupo_clienteProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setMostrarnombre_vendedorProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setMostrarnumero_autorizacionProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.TOTAL)) {
				this.setMostrartotalProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionProcesoPedidos(esAsigna);
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
		
		
		this.setActivaridProcesoPedidos(esInicial);
		this.setActivarid_ciudadProcesoPedidos(esInicial);
		this.setActivarid_zonaProcesoPedidos(esInicial);
		this.setActivarid_grupo_clienteProcesoPedidos(esInicial);
		this.setActivarid_vendedorProcesoPedidos(esInicial);
		this.setActivarnombre_provinciaProcesoPedidos(esInicial);
		this.setActivarnombre_ciudadProcesoPedidos(esInicial);
		this.setActivarnombre_zonaProcesoPedidos(esInicial);
		this.setActivarnombre_grupo_clienteProcesoPedidos(esInicial);
		this.setActivarnombre_vendedorProcesoPedidos(esInicial);
		this.setActivarcodigoProcesoPedidos(esInicial);
		this.setActivarnombre_completoProcesoPedidos(esInicial);
		this.setActivarnumeroProcesoPedidos(esInicial);
		this.setActivarnumero_autorizacionProcesoPedidos(esInicial);
		this.setActivartotalProcesoPedidos(esInicial);
		this.setActivarfecha_emisionProcesoPedidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.ID)) {
				this.setActivaridProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setActivarid_grupo_clienteProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBREPROVINCIA)) {
				this.setActivarnombre_provinciaProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBRECIUDAD)) {
				this.setActivarnombre_ciudadProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBREZONA)) {
				this.setActivarnombre_zonaProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setActivarnombre_grupo_clienteProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setActivarnombre_vendedorProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NUMERO)) {
				this.setActivarnumeroProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setActivarnumero_autorizacionProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.TOTAL)) {
				this.setActivartotalProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionProcesoPedidos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoPedidos(esInicial);
		this.setResaltarid_ciudadProcesoPedidos(esInicial);
		this.setResaltarid_zonaProcesoPedidos(esInicial);
		this.setResaltarid_grupo_clienteProcesoPedidos(esInicial);
		this.setResaltarid_vendedorProcesoPedidos(esInicial);
		this.setResaltarnombre_provinciaProcesoPedidos(esInicial);
		this.setResaltarnombre_ciudadProcesoPedidos(esInicial);
		this.setResaltarnombre_zonaProcesoPedidos(esInicial);
		this.setResaltarnombre_grupo_clienteProcesoPedidos(esInicial);
		this.setResaltarnombre_vendedorProcesoPedidos(esInicial);
		this.setResaltarcodigoProcesoPedidos(esInicial);
		this.setResaltarnombre_completoProcesoPedidos(esInicial);
		this.setResaltarnumeroProcesoPedidos(esInicial);
		this.setResaltarnumero_autorizacionProcesoPedidos(esInicial);
		this.setResaltartotalProcesoPedidos(esInicial);
		this.setResaltarfecha_emisionProcesoPedidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.ID)) {
				this.setResaltaridProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setResaltarid_grupo_clienteProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBREPROVINCIA)) {
				this.setResaltarnombre_provinciaProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBRECIUDAD)) {
				this.setResaltarnombre_ciudadProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBREZONA)) {
				this.setResaltarnombre_zonaProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setResaltarnombre_grupo_clienteProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setResaltarnombre_vendedorProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setResaltarnumero_autorizacionProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.TOTAL)) {
				this.setResaltartotalProcesoPedidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoPedidosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionProcesoPedidos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoPedidosProcesoPedidos=true;

	public Boolean getMostrarBusquedaProcesoPedidosProcesoPedidos() {
		return this.mostrarBusquedaProcesoPedidosProcesoPedidos;
	}

	public void setMostrarBusquedaProcesoPedidosProcesoPedidos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoPedidosProcesoPedidos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoPedidosProcesoPedidos=true;

	public Boolean getActivarBusquedaProcesoPedidosProcesoPedidos() {
		return this.activarBusquedaProcesoPedidosProcesoPedidos;
	}

	public void setActivarBusquedaProcesoPedidosProcesoPedidos(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoPedidosProcesoPedidos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoPedidosProcesoPedidos=null;

	public Border getResaltarBusquedaProcesoPedidosProcesoPedidos() {
		return this.resaltarBusquedaProcesoPedidosProcesoPedidos;
	}

	public void setResaltarBusquedaProcesoPedidosProcesoPedidos(Border borderResaltar) {
		this.resaltarBusquedaProcesoPedidosProcesoPedidos= borderResaltar;
	}

	public void setResaltarBusquedaProcesoPedidosProcesoPedidos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoPedidosBeanSwingJInternalFrame procesopedidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoPedidosProcesoPedidos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}