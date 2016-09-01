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


import com.bydan.erp.facturacion.util.report.ProcesoRecibosConstantesFunciones;
import com.bydan.erp.facturacion.util.report.ProcesoRecibosParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.ProcesoRecibosParameterGeneral;

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
final public class ProcesoRecibosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoRecibos";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoRecibos"+ProcesoRecibosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoRecibosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoRecibosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoRecibosConstantesFunciones.SCHEMA+"_"+ProcesoRecibosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoRecibosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoRecibosConstantesFunciones.SCHEMA+"_"+ProcesoRecibosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoRecibosConstantesFunciones.SCHEMA+"_"+ProcesoRecibosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoRecibosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoRecibosConstantesFunciones.SCHEMA+"_"+ProcesoRecibosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoRecibosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoRecibosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoRecibosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoRecibosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoRecibosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoRecibosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoRecibosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoRecibosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoRecibosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoRecibosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Reciboses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Recibos";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Recibos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoRecibos";
	public static final String OBJECTNAME="procesorecibos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="proceso_recibos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesorecibos from "+ProcesoRecibosConstantesFunciones.SPERSISTENCENAME+" procesorecibos";
	public static String QUERYSELECTNATIVE="select "+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".id,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".version_row,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".id_provincia,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".id_ciudad,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".id_zona,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".id_grupo_cliente,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".id_vendedor,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".nombre_provincia,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".nombre_ciudad,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".nombre_zona,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".nombre_grupo_cliente,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".nombre_vendedor,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".codigo,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".nombre_completo,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".codigo_asiento,"+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME+".numero_mayor from "+ProcesoRecibosConstantesFunciones.SCHEMA+"."+ProcesoRecibosConstantesFunciones.TABLENAME;//+" as "+ProcesoRecibosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPROVINCIA= "id_provincia";
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
    public static final String CODIGOASIENTO= "codigo_asiento";
    public static final String NUMEROMAYOR= "numero_mayor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPROVINCIA= "Provincia";
		public static final String LABEL_IDPROVINCIA_LOWER= "Provincia";
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
    	public static final String LABEL_CODIGOASIENTO= "Codigo Asiento";
		public static final String LABEL_CODIGOASIENTO_LOWER= "Codigo Asiento";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
	
		
		
		
		
		
		
		
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
	public static final String SREGEXCODIGO_ASIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_ASIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProcesoRecibosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.IDPROVINCIA)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_IDPROVINCIA;}
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.IDCIUDAD)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.IDZONA)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.IDGRUPOCLIENTE)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_IDGRUPOCLIENTE;}
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.IDVENDEDOR)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.NOMBREPROVINCIA)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_NOMBREPROVINCIA;}
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.NOMBRECIUDAD)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_NOMBRECIUDAD;}
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.NOMBREZONA)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_NOMBREZONA;}
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.NOMBREGRUPOCLIENTE)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE;}
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.NOMBREVENDEDOR)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_NOMBREVENDEDOR;}
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.CODIGO)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.CODIGOASIENTO)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_CODIGOASIENTO;}
		if(sNombreColumna.equals(ProcesoRecibosConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=ProcesoRecibosConstantesFunciones.LABEL_NUMEROMAYOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProcesoRecibosDescripcion(ProcesoRecibos procesorecibos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesorecibos !=null/* && procesorecibos.getId()!=0*/) {
			sDescripcion=procesorecibos.getcodigo();//procesorecibosprocesorecibos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoRecibosDescripcionDetallado(ProcesoRecibos procesorecibos) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoRecibosConstantesFunciones.ID+"=";
		sDescripcion+=procesorecibos.getId().toString()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesorecibos.getVersionRow().toString()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.IDPROVINCIA+"=";
		sDescripcion+=procesorecibos.getid_provincia().toString()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=procesorecibos.getid_ciudad().toString()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.IDZONA+"=";
		sDescripcion+=procesorecibos.getid_zona().toString()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.IDGRUPOCLIENTE+"=";
		sDescripcion+=procesorecibos.getid_grupo_cliente().toString()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=procesorecibos.getid_vendedor().toString()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.NOMBREPROVINCIA+"=";
		sDescripcion+=procesorecibos.getnombre_provincia()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.NOMBRECIUDAD+"=";
		sDescripcion+=procesorecibos.getnombre_ciudad()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.NOMBREZONA+"=";
		sDescripcion+=procesorecibos.getnombre_zona()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.NOMBREGRUPOCLIENTE+"=";
		sDescripcion+=procesorecibos.getnombre_grupo_cliente()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.NOMBREVENDEDOR+"=";
		sDescripcion+=procesorecibos.getnombre_vendedor()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.CODIGO+"=";
		sDescripcion+=procesorecibos.getcodigo()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=procesorecibos.getnombre_completo()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.CODIGOASIENTO+"=";
		sDescripcion+=procesorecibos.getcodigo_asiento()+",";
		sDescripcion+=ProcesoRecibosConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=procesorecibos.getnumero_mayor()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoRecibosDescripcion(ProcesoRecibos procesorecibos,String sValor) throws Exception {			
		if(procesorecibos !=null) {
			procesorecibos.setcodigo(sValor);;//procesorecibosprocesorecibos.getcodigo().trim();
		}		
	}
	
		

	public static String getProvinciaDescripcion(Provincia provincia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(provincia!=null/*&&provincia.getId()>0*/) {
			sDescripcion=ProvinciaConstantesFunciones.getProvinciaDescripcion(provincia);
		}

		return sDescripcion;
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
		} else if(sNombreIndice.equals("BusquedaProcesoRecibos")) {
			sNombreIndice="Tipo=  Por Provincia Por Ciudad Por Zona Por Grupo Cliente Por Vendedor";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdGrupoCliente")) {
			sNombreIndice="Tipo=  Por Grupo Cliente";
		} else if(sNombreIndice.equals("FK_IdProvincia")) {
			sNombreIndice="Tipo=  Por Provincia";
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

	public static String getDetalleIndiceBusquedaProcesoRecibos(Long id_provincia,Long id_ciudad,Long id_zona,Long id_grupo_cliente,Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_provincia!=null) {sDetalleIndice+=" Codigo Unico De Provincia="+id_provincia.toString();}
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

	public static String getDetalleIndiceFK_IdProvincia(Long id_provincia) {
		String sDetalleIndice=" Parametros->";
		if(id_provincia!=null) {sDetalleIndice+=" Codigo Unico De Provincia="+id_provincia.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProcesoRecibos(ProcesoRecibos procesorecibos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesorecibos.setnombre_provincia(procesorecibos.getnombre_provincia().trim());
		procesorecibos.setnombre_ciudad(procesorecibos.getnombre_ciudad().trim());
		procesorecibos.setnombre_zona(procesorecibos.getnombre_zona().trim());
		procesorecibos.setnombre_grupo_cliente(procesorecibos.getnombre_grupo_cliente().trim());
		procesorecibos.setnombre_vendedor(procesorecibos.getnombre_vendedor().trim());
		procesorecibos.setcodigo(procesorecibos.getcodigo().trim());
		procesorecibos.setnombre_completo(procesorecibos.getnombre_completo().trim());
		procesorecibos.setcodigo_asiento(procesorecibos.getcodigo_asiento().trim());
		procesorecibos.setnumero_mayor(procesorecibos.getnumero_mayor().trim());
	}
	
	public static void quitarEspaciosProcesoReciboss(List<ProcesoRecibos> procesoreciboss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoRecibos procesorecibos: procesoreciboss) {
			procesorecibos.setnombre_provincia(procesorecibos.getnombre_provincia().trim());
			procesorecibos.setnombre_ciudad(procesorecibos.getnombre_ciudad().trim());
			procesorecibos.setnombre_zona(procesorecibos.getnombre_zona().trim());
			procesorecibos.setnombre_grupo_cliente(procesorecibos.getnombre_grupo_cliente().trim());
			procesorecibos.setnombre_vendedor(procesorecibos.getnombre_vendedor().trim());
			procesorecibos.setcodigo(procesorecibos.getcodigo().trim());
			procesorecibos.setnombre_completo(procesorecibos.getnombre_completo().trim());
			procesorecibos.setcodigo_asiento(procesorecibos.getcodigo_asiento().trim());
			procesorecibos.setnumero_mayor(procesorecibos.getnumero_mayor().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoRecibos(ProcesoRecibos procesorecibos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesorecibos.getConCambioAuxiliar()) {
			procesorecibos.setIsDeleted(procesorecibos.getIsDeletedAuxiliar());	
			procesorecibos.setIsNew(procesorecibos.getIsNewAuxiliar());	
			procesorecibos.setIsChanged(procesorecibos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesorecibos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesorecibos.setIsDeletedAuxiliar(false);	
			procesorecibos.setIsNewAuxiliar(false);	
			procesorecibos.setIsChangedAuxiliar(false);
			
			procesorecibos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoReciboss(List<ProcesoRecibos> procesoreciboss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoRecibos procesorecibos : procesoreciboss) {
			if(conAsignarBase && procesorecibos.getConCambioAuxiliar()) {
				procesorecibos.setIsDeleted(procesorecibos.getIsDeletedAuxiliar());	
				procesorecibos.setIsNew(procesorecibos.getIsNewAuxiliar());	
				procesorecibos.setIsChanged(procesorecibos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesorecibos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesorecibos.setIsDeletedAuxiliar(false);	
				procesorecibos.setIsNewAuxiliar(false);	
				procesorecibos.setIsChangedAuxiliar(false);
				
				procesorecibos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoRecibos(ProcesoRecibos procesorecibos,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoReciboss(List<ProcesoRecibos> procesoreciboss,Boolean conEnteros) throws Exception  {
		
		for(ProcesoRecibos procesorecibos: procesoreciboss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoRecibos(List<ProcesoRecibos> procesoreciboss,ProcesoRecibos procesorecibosAux) throws Exception  {
		ProcesoRecibosConstantesFunciones.InicializarValoresProcesoRecibos(procesorecibosAux,true);
		
		for(ProcesoRecibos procesorecibos: procesoreciboss) {
			if(procesorecibos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoRecibos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoRecibosConstantesFunciones.getArrayColumnasGlobalesProcesoRecibos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoRecibos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoRecibos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoRecibos> procesoreciboss,ProcesoRecibos procesorecibos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoRecibos procesorecibosAux: procesoreciboss) {
			if(procesorecibosAux!=null && procesorecibos!=null) {
				if((procesorecibosAux.getId()==null && procesorecibos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesorecibosAux.getId()!=null && procesorecibos.getId()!=null){
					if(procesorecibosAux.getId().equals(procesorecibos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoRecibos(List<ProcesoRecibos> procesoreciboss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoRecibos procesorecibos: procesoreciboss) {			
			if(procesorecibos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoRecibos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProcesoRecibosConstantesFunciones.LABEL_ID, ProcesoRecibosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoRecibosConstantesFunciones.LABEL_VERSIONROW, ProcesoRecibosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoRecibosConstantesFunciones.LABEL_NOMBREPROVINCIA, ProcesoRecibosConstantesFunciones.NOMBREPROVINCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoRecibosConstantesFunciones.LABEL_NOMBRECIUDAD, ProcesoRecibosConstantesFunciones.NOMBRECIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoRecibosConstantesFunciones.LABEL_NOMBREZONA, ProcesoRecibosConstantesFunciones.NOMBREZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoRecibosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE, ProcesoRecibosConstantesFunciones.NOMBREGRUPOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoRecibosConstantesFunciones.LABEL_NOMBREVENDEDOR, ProcesoRecibosConstantesFunciones.NOMBREVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoRecibosConstantesFunciones.LABEL_CODIGO, ProcesoRecibosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoRecibosConstantesFunciones.LABEL_NOMBRECOMPLETO, ProcesoRecibosConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoRecibosConstantesFunciones.LABEL_CODIGOASIENTO, ProcesoRecibosConstantesFunciones.CODIGOASIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProcesoRecibosConstantesFunciones.LABEL_NUMEROMAYOR, ProcesoRecibosConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoRecibos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProcesoRecibosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoRecibosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoRecibosConstantesFunciones.NOMBREPROVINCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoRecibosConstantesFunciones.NOMBRECIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoRecibosConstantesFunciones.NOMBREZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoRecibosConstantesFunciones.NOMBREGRUPOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoRecibosConstantesFunciones.NOMBREVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoRecibosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoRecibosConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoRecibosConstantesFunciones.CODIGOASIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProcesoRecibosConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoRecibos() throws Exception  {
		return ProcesoRecibosConstantesFunciones.getTiposSeleccionarProcesoRecibos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoRecibos(Boolean conFk) throws Exception  {
		return ProcesoRecibosConstantesFunciones.getTiposSeleccionarProcesoRecibos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoRecibos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_IDPROVINCIA);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_IDPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_IDGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_NOMBREPROVINCIA);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_NOMBREPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_NOMBRECIUDAD);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_NOMBRECIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_NOMBREZONA);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_NOMBREZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_NOMBREVENDEDOR);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_NOMBREVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_CODIGOASIENTO);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_CODIGOASIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecibosConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(ProcesoRecibosConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoRecibos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoRecibos(ProcesoRecibos procesorecibosAux) throws Exception {
		
			procesorecibosAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(procesorecibosAux.getProvincia()));
			procesorecibosAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(procesorecibosAux.getCiudad()));
			procesorecibosAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(procesorecibosAux.getZona()));
			procesorecibosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(procesorecibosAux.getGrupoCliente()));
			procesorecibosAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(procesorecibosAux.getVendedor()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoRecibos(List<ProcesoRecibos> procesorecibossTemp) throws Exception {
		for(ProcesoRecibos procesorecibosAux:procesorecibossTemp) {
			
			procesorecibosAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(procesorecibosAux.getProvincia()));
			procesorecibosAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(procesorecibosAux.getCiudad()));
			procesorecibosAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(procesorecibosAux.getZona()));
			procesorecibosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(procesorecibosAux.getGrupoCliente()));
			procesorecibosAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(procesorecibosAux.getVendedor()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoRecibos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Provincia.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(Zona.class));
				classes.add(new Classe(GrupoCliente.class));
				classes.add(new Classe(Vendedor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Provincia.class)) {
						classes.add(new Classe(Provincia.class));
					}
				}

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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoRecibos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

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

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoRecibos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoRecibosConstantesFunciones.getClassesRelationshipsOfProcesoRecibos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoRecibos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoRecibos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoRecibosConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoRecibos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoRecibos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoRecibos procesorecibos,List<ProcesoRecibos> procesoreciboss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoRecibos procesorecibos,List<ProcesoRecibos> procesoreciboss) throws Exception {
		try	{			
			for(ProcesoRecibos procesorecibosLocal:procesoreciboss) {
				if(procesorecibosLocal.getId().equals(procesorecibos.getId())) {
					procesorecibosLocal.setIsSelected(procesorecibos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoRecibos(List<ProcesoRecibos> procesorecibossAux) throws Exception {
		//this.procesorecibossAux=procesorecibossAux;
		
		for(ProcesoRecibos procesorecibosAux:procesorecibossAux) {
			if(procesorecibosAux.getIsChanged()) {
				procesorecibosAux.setIsChanged(false);
			}		
			
			if(procesorecibosAux.getIsNew()) {
				procesorecibosAux.setIsNew(false);
			}	
			
			if(procesorecibosAux.getIsDeleted()) {
				procesorecibosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoRecibos(ProcesoRecibos procesorecibosAux) throws Exception {
		//this.procesorecibosAux=procesorecibosAux;
		
			if(procesorecibosAux.getIsChanged()) {
				procesorecibosAux.setIsChanged(false);
			}		
			
			if(procesorecibosAux.getIsNew()) {
				procesorecibosAux.setIsNew(false);
			}	
			
			if(procesorecibosAux.getIsDeleted()) {
				procesorecibosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoRecibos procesorecibosAsignar,ProcesoRecibos procesorecibos) throws Exception {
		procesorecibosAsignar.setId(procesorecibos.getId());	
		procesorecibosAsignar.setVersionRow(procesorecibos.getVersionRow());	
		procesorecibosAsignar.setnombre_provincia(procesorecibos.getnombre_provincia());	
		procesorecibosAsignar.setnombre_ciudad(procesorecibos.getnombre_ciudad());	
		procesorecibosAsignar.setnombre_zona(procesorecibos.getnombre_zona());	
		procesorecibosAsignar.setnombre_grupo_cliente(procesorecibos.getnombre_grupo_cliente());	
		procesorecibosAsignar.setnombre_vendedor(procesorecibos.getnombre_vendedor());	
		procesorecibosAsignar.setcodigo(procesorecibos.getcodigo());	
		procesorecibosAsignar.setnombre_completo(procesorecibos.getnombre_completo());	
		procesorecibosAsignar.setcodigo_asiento(procesorecibos.getcodigo_asiento());	
		procesorecibosAsignar.setnumero_mayor(procesorecibos.getnumero_mayor());	
	}
	
	public static void inicializarProcesoRecibos(ProcesoRecibos procesorecibos) throws Exception {
		try {
				procesorecibos.setId(0L);	
					
				procesorecibos.setnombre_provincia("");	
				procesorecibos.setnombre_ciudad("");	
				procesorecibos.setnombre_zona("");	
				procesorecibos.setnombre_grupo_cliente("");	
				procesorecibos.setnombre_vendedor("");	
				procesorecibos.setcodigo("");	
				procesorecibos.setnombre_completo("");	
				procesorecibos.setcodigo_asiento("");	
				procesorecibos.setnumero_mayor("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoRecibos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_IDPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_NOMBREPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_NOMBRECIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_NOMBREZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_NOMBREVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_CODIGOASIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecibosConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoRecibos(String sTipo,Row row,Workbook workbook,ProcesoRecibos procesorecibos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getprovincia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getgrupocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getnombre_provincia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getnombre_ciudad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getnombre_zona());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getnombre_grupo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getnombre_vendedor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getcodigo_asiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecibos.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoRecibos="";
	
	public String getsFinalQueryProcesoRecibos() {
		return this.sFinalQueryProcesoRecibos;
	}
	
	public void setsFinalQueryProcesoRecibos(String sFinalQueryProcesoRecibos) {
		this.sFinalQueryProcesoRecibos= sFinalQueryProcesoRecibos;
	}
	
	public Border resaltarSeleccionarProcesoRecibos=null;
	
	public Border setResaltarSeleccionarProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoRecibos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoRecibos() {
		return this.resaltarSeleccionarProcesoRecibos;
	}
	
	public void setResaltarSeleccionarProcesoRecibos(Border borderResaltarSeleccionarProcesoRecibos) {
		this.resaltarSeleccionarProcesoRecibos= borderResaltarSeleccionarProcesoRecibos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoRecibos=null;
	public Boolean mostraridProcesoRecibos=true;
	public Boolean activaridProcesoRecibos=true;

	public Border resaltarid_provinciaProcesoRecibos=null;
	public Boolean mostrarid_provinciaProcesoRecibos=true;
	public Boolean activarid_provinciaProcesoRecibos=true;
	public Boolean cargarid_provinciaProcesoRecibos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_provinciaProcesoRecibos=false;//ConEventDepend=true

	public Border resaltarid_ciudadProcesoRecibos=null;
	public Boolean mostrarid_ciudadProcesoRecibos=true;
	public Boolean activarid_ciudadProcesoRecibos=true;
	public Boolean cargarid_ciudadProcesoRecibos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadProcesoRecibos=false;//ConEventDepend=true

	public Border resaltarid_zonaProcesoRecibos=null;
	public Boolean mostrarid_zonaProcesoRecibos=true;
	public Boolean activarid_zonaProcesoRecibos=true;
	public Boolean cargarid_zonaProcesoRecibos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaProcesoRecibos=false;//ConEventDepend=true

	public Border resaltarid_grupo_clienteProcesoRecibos=null;
	public Boolean mostrarid_grupo_clienteProcesoRecibos=true;
	public Boolean activarid_grupo_clienteProcesoRecibos=true;
	public Boolean cargarid_grupo_clienteProcesoRecibos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_clienteProcesoRecibos=false;//ConEventDepend=true

	public Border resaltarid_vendedorProcesoRecibos=null;
	public Boolean mostrarid_vendedorProcesoRecibos=true;
	public Boolean activarid_vendedorProcesoRecibos=true;
	public Boolean cargarid_vendedorProcesoRecibos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorProcesoRecibos=false;//ConEventDepend=true

	public Border resaltarnombre_provinciaProcesoRecibos=null;
	public Boolean mostrarnombre_provinciaProcesoRecibos=true;
	public Boolean activarnombre_provinciaProcesoRecibos=true;

	public Border resaltarnombre_ciudadProcesoRecibos=null;
	public Boolean mostrarnombre_ciudadProcesoRecibos=true;
	public Boolean activarnombre_ciudadProcesoRecibos=true;

	public Border resaltarnombre_zonaProcesoRecibos=null;
	public Boolean mostrarnombre_zonaProcesoRecibos=true;
	public Boolean activarnombre_zonaProcesoRecibos=true;

	public Border resaltarnombre_grupo_clienteProcesoRecibos=null;
	public Boolean mostrarnombre_grupo_clienteProcesoRecibos=true;
	public Boolean activarnombre_grupo_clienteProcesoRecibos=true;

	public Border resaltarnombre_vendedorProcesoRecibos=null;
	public Boolean mostrarnombre_vendedorProcesoRecibos=true;
	public Boolean activarnombre_vendedorProcesoRecibos=true;

	public Border resaltarcodigoProcesoRecibos=null;
	public Boolean mostrarcodigoProcesoRecibos=true;
	public Boolean activarcodigoProcesoRecibos=true;

	public Border resaltarnombre_completoProcesoRecibos=null;
	public Boolean mostrarnombre_completoProcesoRecibos=true;
	public Boolean activarnombre_completoProcesoRecibos=true;

	public Border resaltarcodigo_asientoProcesoRecibos=null;
	public Boolean mostrarcodigo_asientoProcesoRecibos=true;
	public Boolean activarcodigo_asientoProcesoRecibos=true;

	public Border resaltarnumero_mayorProcesoRecibos=null;
	public Boolean mostrarnumero_mayorProcesoRecibos=true;
	public Boolean activarnumero_mayorProcesoRecibos=true;

	
	

	public Border setResaltaridProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltaridProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoRecibos() {
		return this.resaltaridProcesoRecibos;
	}

	public void setResaltaridProcesoRecibos(Border borderResaltar) {
		this.resaltaridProcesoRecibos= borderResaltar;
	}

	public Boolean getMostraridProcesoRecibos() {
		return this.mostraridProcesoRecibos;
	}

	public void setMostraridProcesoRecibos(Boolean mostraridProcesoRecibos) {
		this.mostraridProcesoRecibos= mostraridProcesoRecibos;
	}

	public Boolean getActivaridProcesoRecibos() {
		return this.activaridProcesoRecibos;
	}

	public void setActivaridProcesoRecibos(Boolean activaridProcesoRecibos) {
		this.activaridProcesoRecibos= activaridProcesoRecibos;
	}

	public Border setResaltarid_provinciaProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarid_provinciaProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_provinciaProcesoRecibos() {
		return this.resaltarid_provinciaProcesoRecibos;
	}

	public void setResaltarid_provinciaProcesoRecibos(Border borderResaltar) {
		this.resaltarid_provinciaProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarid_provinciaProcesoRecibos() {
		return this.mostrarid_provinciaProcesoRecibos;
	}

	public void setMostrarid_provinciaProcesoRecibos(Boolean mostrarid_provinciaProcesoRecibos) {
		this.mostrarid_provinciaProcesoRecibos= mostrarid_provinciaProcesoRecibos;
	}

	public Boolean getActivarid_provinciaProcesoRecibos() {
		return this.activarid_provinciaProcesoRecibos;
	}

	public void setActivarid_provinciaProcesoRecibos(Boolean activarid_provinciaProcesoRecibos) {
		this.activarid_provinciaProcesoRecibos= activarid_provinciaProcesoRecibos;
	}

	public Boolean getCargarid_provinciaProcesoRecibos() {
		return this.cargarid_provinciaProcesoRecibos;
	}

	public void setCargarid_provinciaProcesoRecibos(Boolean cargarid_provinciaProcesoRecibos) {
		this.cargarid_provinciaProcesoRecibos= cargarid_provinciaProcesoRecibos;
	}

	public Border setResaltarid_ciudadProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarid_ciudadProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadProcesoRecibos() {
		return this.resaltarid_ciudadProcesoRecibos;
	}

	public void setResaltarid_ciudadProcesoRecibos(Border borderResaltar) {
		this.resaltarid_ciudadProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarid_ciudadProcesoRecibos() {
		return this.mostrarid_ciudadProcesoRecibos;
	}

	public void setMostrarid_ciudadProcesoRecibos(Boolean mostrarid_ciudadProcesoRecibos) {
		this.mostrarid_ciudadProcesoRecibos= mostrarid_ciudadProcesoRecibos;
	}

	public Boolean getActivarid_ciudadProcesoRecibos() {
		return this.activarid_ciudadProcesoRecibos;
	}

	public void setActivarid_ciudadProcesoRecibos(Boolean activarid_ciudadProcesoRecibos) {
		this.activarid_ciudadProcesoRecibos= activarid_ciudadProcesoRecibos;
	}

	public Boolean getCargarid_ciudadProcesoRecibos() {
		return this.cargarid_ciudadProcesoRecibos;
	}

	public void setCargarid_ciudadProcesoRecibos(Boolean cargarid_ciudadProcesoRecibos) {
		this.cargarid_ciudadProcesoRecibos= cargarid_ciudadProcesoRecibos;
	}

	public Border setResaltarid_zonaProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarid_zonaProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaProcesoRecibos() {
		return this.resaltarid_zonaProcesoRecibos;
	}

	public void setResaltarid_zonaProcesoRecibos(Border borderResaltar) {
		this.resaltarid_zonaProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarid_zonaProcesoRecibos() {
		return this.mostrarid_zonaProcesoRecibos;
	}

	public void setMostrarid_zonaProcesoRecibos(Boolean mostrarid_zonaProcesoRecibos) {
		this.mostrarid_zonaProcesoRecibos= mostrarid_zonaProcesoRecibos;
	}

	public Boolean getActivarid_zonaProcesoRecibos() {
		return this.activarid_zonaProcesoRecibos;
	}

	public void setActivarid_zonaProcesoRecibos(Boolean activarid_zonaProcesoRecibos) {
		this.activarid_zonaProcesoRecibos= activarid_zonaProcesoRecibos;
	}

	public Boolean getCargarid_zonaProcesoRecibos() {
		return this.cargarid_zonaProcesoRecibos;
	}

	public void setCargarid_zonaProcesoRecibos(Boolean cargarid_zonaProcesoRecibos) {
		this.cargarid_zonaProcesoRecibos= cargarid_zonaProcesoRecibos;
	}

	public Border setResaltarid_grupo_clienteProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarid_grupo_clienteProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_clienteProcesoRecibos() {
		return this.resaltarid_grupo_clienteProcesoRecibos;
	}

	public void setResaltarid_grupo_clienteProcesoRecibos(Border borderResaltar) {
		this.resaltarid_grupo_clienteProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarid_grupo_clienteProcesoRecibos() {
		return this.mostrarid_grupo_clienteProcesoRecibos;
	}

	public void setMostrarid_grupo_clienteProcesoRecibos(Boolean mostrarid_grupo_clienteProcesoRecibos) {
		this.mostrarid_grupo_clienteProcesoRecibos= mostrarid_grupo_clienteProcesoRecibos;
	}

	public Boolean getActivarid_grupo_clienteProcesoRecibos() {
		return this.activarid_grupo_clienteProcesoRecibos;
	}

	public void setActivarid_grupo_clienteProcesoRecibos(Boolean activarid_grupo_clienteProcesoRecibos) {
		this.activarid_grupo_clienteProcesoRecibos= activarid_grupo_clienteProcesoRecibos;
	}

	public Boolean getCargarid_grupo_clienteProcesoRecibos() {
		return this.cargarid_grupo_clienteProcesoRecibos;
	}

	public void setCargarid_grupo_clienteProcesoRecibos(Boolean cargarid_grupo_clienteProcesoRecibos) {
		this.cargarid_grupo_clienteProcesoRecibos= cargarid_grupo_clienteProcesoRecibos;
	}

	public Border setResaltarid_vendedorProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarid_vendedorProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorProcesoRecibos() {
		return this.resaltarid_vendedorProcesoRecibos;
	}

	public void setResaltarid_vendedorProcesoRecibos(Border borderResaltar) {
		this.resaltarid_vendedorProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarid_vendedorProcesoRecibos() {
		return this.mostrarid_vendedorProcesoRecibos;
	}

	public void setMostrarid_vendedorProcesoRecibos(Boolean mostrarid_vendedorProcesoRecibos) {
		this.mostrarid_vendedorProcesoRecibos= mostrarid_vendedorProcesoRecibos;
	}

	public Boolean getActivarid_vendedorProcesoRecibos() {
		return this.activarid_vendedorProcesoRecibos;
	}

	public void setActivarid_vendedorProcesoRecibos(Boolean activarid_vendedorProcesoRecibos) {
		this.activarid_vendedorProcesoRecibos= activarid_vendedorProcesoRecibos;
	}

	public Boolean getCargarid_vendedorProcesoRecibos() {
		return this.cargarid_vendedorProcesoRecibos;
	}

	public void setCargarid_vendedorProcesoRecibos(Boolean cargarid_vendedorProcesoRecibos) {
		this.cargarid_vendedorProcesoRecibos= cargarid_vendedorProcesoRecibos;
	}

	public Border setResaltarnombre_provinciaProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarnombre_provinciaProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_provinciaProcesoRecibos() {
		return this.resaltarnombre_provinciaProcesoRecibos;
	}

	public void setResaltarnombre_provinciaProcesoRecibos(Border borderResaltar) {
		this.resaltarnombre_provinciaProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarnombre_provinciaProcesoRecibos() {
		return this.mostrarnombre_provinciaProcesoRecibos;
	}

	public void setMostrarnombre_provinciaProcesoRecibos(Boolean mostrarnombre_provinciaProcesoRecibos) {
		this.mostrarnombre_provinciaProcesoRecibos= mostrarnombre_provinciaProcesoRecibos;
	}

	public Boolean getActivarnombre_provinciaProcesoRecibos() {
		return this.activarnombre_provinciaProcesoRecibos;
	}

	public void setActivarnombre_provinciaProcesoRecibos(Boolean activarnombre_provinciaProcesoRecibos) {
		this.activarnombre_provinciaProcesoRecibos= activarnombre_provinciaProcesoRecibos;
	}

	public Border setResaltarnombre_ciudadProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarnombre_ciudadProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_ciudadProcesoRecibos() {
		return this.resaltarnombre_ciudadProcesoRecibos;
	}

	public void setResaltarnombre_ciudadProcesoRecibos(Border borderResaltar) {
		this.resaltarnombre_ciudadProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarnombre_ciudadProcesoRecibos() {
		return this.mostrarnombre_ciudadProcesoRecibos;
	}

	public void setMostrarnombre_ciudadProcesoRecibos(Boolean mostrarnombre_ciudadProcesoRecibos) {
		this.mostrarnombre_ciudadProcesoRecibos= mostrarnombre_ciudadProcesoRecibos;
	}

	public Boolean getActivarnombre_ciudadProcesoRecibos() {
		return this.activarnombre_ciudadProcesoRecibos;
	}

	public void setActivarnombre_ciudadProcesoRecibos(Boolean activarnombre_ciudadProcesoRecibos) {
		this.activarnombre_ciudadProcesoRecibos= activarnombre_ciudadProcesoRecibos;
	}

	public Border setResaltarnombre_zonaProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarnombre_zonaProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_zonaProcesoRecibos() {
		return this.resaltarnombre_zonaProcesoRecibos;
	}

	public void setResaltarnombre_zonaProcesoRecibos(Border borderResaltar) {
		this.resaltarnombre_zonaProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarnombre_zonaProcesoRecibos() {
		return this.mostrarnombre_zonaProcesoRecibos;
	}

	public void setMostrarnombre_zonaProcesoRecibos(Boolean mostrarnombre_zonaProcesoRecibos) {
		this.mostrarnombre_zonaProcesoRecibos= mostrarnombre_zonaProcesoRecibos;
	}

	public Boolean getActivarnombre_zonaProcesoRecibos() {
		return this.activarnombre_zonaProcesoRecibos;
	}

	public void setActivarnombre_zonaProcesoRecibos(Boolean activarnombre_zonaProcesoRecibos) {
		this.activarnombre_zonaProcesoRecibos= activarnombre_zonaProcesoRecibos;
	}

	public Border setResaltarnombre_grupo_clienteProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarnombre_grupo_clienteProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_grupo_clienteProcesoRecibos() {
		return this.resaltarnombre_grupo_clienteProcesoRecibos;
	}

	public void setResaltarnombre_grupo_clienteProcesoRecibos(Border borderResaltar) {
		this.resaltarnombre_grupo_clienteProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarnombre_grupo_clienteProcesoRecibos() {
		return this.mostrarnombre_grupo_clienteProcesoRecibos;
	}

	public void setMostrarnombre_grupo_clienteProcesoRecibos(Boolean mostrarnombre_grupo_clienteProcesoRecibos) {
		this.mostrarnombre_grupo_clienteProcesoRecibos= mostrarnombre_grupo_clienteProcesoRecibos;
	}

	public Boolean getActivarnombre_grupo_clienteProcesoRecibos() {
		return this.activarnombre_grupo_clienteProcesoRecibos;
	}

	public void setActivarnombre_grupo_clienteProcesoRecibos(Boolean activarnombre_grupo_clienteProcesoRecibos) {
		this.activarnombre_grupo_clienteProcesoRecibos= activarnombre_grupo_clienteProcesoRecibos;
	}

	public Border setResaltarnombre_vendedorProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarnombre_vendedorProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_vendedorProcesoRecibos() {
		return this.resaltarnombre_vendedorProcesoRecibos;
	}

	public void setResaltarnombre_vendedorProcesoRecibos(Border borderResaltar) {
		this.resaltarnombre_vendedorProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarnombre_vendedorProcesoRecibos() {
		return this.mostrarnombre_vendedorProcesoRecibos;
	}

	public void setMostrarnombre_vendedorProcesoRecibos(Boolean mostrarnombre_vendedorProcesoRecibos) {
		this.mostrarnombre_vendedorProcesoRecibos= mostrarnombre_vendedorProcesoRecibos;
	}

	public Boolean getActivarnombre_vendedorProcesoRecibos() {
		return this.activarnombre_vendedorProcesoRecibos;
	}

	public void setActivarnombre_vendedorProcesoRecibos(Boolean activarnombre_vendedorProcesoRecibos) {
		this.activarnombre_vendedorProcesoRecibos= activarnombre_vendedorProcesoRecibos;
	}

	public Border setResaltarcodigoProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarcodigoProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProcesoRecibos() {
		return this.resaltarcodigoProcesoRecibos;
	}

	public void setResaltarcodigoProcesoRecibos(Border borderResaltar) {
		this.resaltarcodigoProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarcodigoProcesoRecibos() {
		return this.mostrarcodigoProcesoRecibos;
	}

	public void setMostrarcodigoProcesoRecibos(Boolean mostrarcodigoProcesoRecibos) {
		this.mostrarcodigoProcesoRecibos= mostrarcodigoProcesoRecibos;
	}

	public Boolean getActivarcodigoProcesoRecibos() {
		return this.activarcodigoProcesoRecibos;
	}

	public void setActivarcodigoProcesoRecibos(Boolean activarcodigoProcesoRecibos) {
		this.activarcodigoProcesoRecibos= activarcodigoProcesoRecibos;
	}

	public Border setResaltarnombre_completoProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoProcesoRecibos() {
		return this.resaltarnombre_completoProcesoRecibos;
	}

	public void setResaltarnombre_completoProcesoRecibos(Border borderResaltar) {
		this.resaltarnombre_completoProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoProcesoRecibos() {
		return this.mostrarnombre_completoProcesoRecibos;
	}

	public void setMostrarnombre_completoProcesoRecibos(Boolean mostrarnombre_completoProcesoRecibos) {
		this.mostrarnombre_completoProcesoRecibos= mostrarnombre_completoProcesoRecibos;
	}

	public Boolean getActivarnombre_completoProcesoRecibos() {
		return this.activarnombre_completoProcesoRecibos;
	}

	public void setActivarnombre_completoProcesoRecibos(Boolean activarnombre_completoProcesoRecibos) {
		this.activarnombre_completoProcesoRecibos= activarnombre_completoProcesoRecibos;
	}

	public Border setResaltarcodigo_asientoProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarcodigo_asientoProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_asientoProcesoRecibos() {
		return this.resaltarcodigo_asientoProcesoRecibos;
	}

	public void setResaltarcodigo_asientoProcesoRecibos(Border borderResaltar) {
		this.resaltarcodigo_asientoProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarcodigo_asientoProcesoRecibos() {
		return this.mostrarcodigo_asientoProcesoRecibos;
	}

	public void setMostrarcodigo_asientoProcesoRecibos(Boolean mostrarcodigo_asientoProcesoRecibos) {
		this.mostrarcodigo_asientoProcesoRecibos= mostrarcodigo_asientoProcesoRecibos;
	}

	public Boolean getActivarcodigo_asientoProcesoRecibos() {
		return this.activarcodigo_asientoProcesoRecibos;
	}

	public void setActivarcodigo_asientoProcesoRecibos(Boolean activarcodigo_asientoProcesoRecibos) {
		this.activarcodigo_asientoProcesoRecibos= activarcodigo_asientoProcesoRecibos;
	}

	public Border setResaltarnumero_mayorProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecibosBeanSwingJInternalFrame.jTtoolBarProcesoRecibos.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorProcesoRecibos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorProcesoRecibos() {
		return this.resaltarnumero_mayorProcesoRecibos;
	}

	public void setResaltarnumero_mayorProcesoRecibos(Border borderResaltar) {
		this.resaltarnumero_mayorProcesoRecibos= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorProcesoRecibos() {
		return this.mostrarnumero_mayorProcesoRecibos;
	}

	public void setMostrarnumero_mayorProcesoRecibos(Boolean mostrarnumero_mayorProcesoRecibos) {
		this.mostrarnumero_mayorProcesoRecibos= mostrarnumero_mayorProcesoRecibos;
	}

	public Boolean getActivarnumero_mayorProcesoRecibos() {
		return this.activarnumero_mayorProcesoRecibos;
	}

	public void setActivarnumero_mayorProcesoRecibos(Boolean activarnumero_mayorProcesoRecibos) {
		this.activarnumero_mayorProcesoRecibos= activarnumero_mayorProcesoRecibos;
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
		
		
		this.setMostraridProcesoRecibos(esInicial);
		this.setMostrarid_provinciaProcesoRecibos(esInicial);
		this.setMostrarid_ciudadProcesoRecibos(esInicial);
		this.setMostrarid_zonaProcesoRecibos(esInicial);
		this.setMostrarid_grupo_clienteProcesoRecibos(esInicial);
		this.setMostrarid_vendedorProcesoRecibos(esInicial);
		this.setMostrarnombre_provinciaProcesoRecibos(esInicial);
		this.setMostrarnombre_ciudadProcesoRecibos(esInicial);
		this.setMostrarnombre_zonaProcesoRecibos(esInicial);
		this.setMostrarnombre_grupo_clienteProcesoRecibos(esInicial);
		this.setMostrarnombre_vendedorProcesoRecibos(esInicial);
		this.setMostrarcodigoProcesoRecibos(esInicial);
		this.setMostrarnombre_completoProcesoRecibos(esInicial);
		this.setMostrarcodigo_asientoProcesoRecibos(esInicial);
		this.setMostrarnumero_mayorProcesoRecibos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.ID)) {
				this.setMostraridProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDPROVINCIA)) {
				this.setMostrarid_provinciaProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setMostrarid_grupo_clienteProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBREPROVINCIA)) {
				this.setMostrarnombre_provinciaProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBRECIUDAD)) {
				this.setMostrarnombre_ciudadProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBREZONA)) {
				this.setMostrarnombre_zonaProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setMostrarnombre_grupo_clienteProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setMostrarnombre_vendedorProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.CODIGOASIENTO)) {
				this.setMostrarcodigo_asientoProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorProcesoRecibos(esAsigna);
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
		
		
		this.setActivaridProcesoRecibos(esInicial);
		this.setActivarid_provinciaProcesoRecibos(esInicial);
		this.setActivarid_ciudadProcesoRecibos(esInicial);
		this.setActivarid_zonaProcesoRecibos(esInicial);
		this.setActivarid_grupo_clienteProcesoRecibos(esInicial);
		this.setActivarid_vendedorProcesoRecibos(esInicial);
		this.setActivarnombre_provinciaProcesoRecibos(esInicial);
		this.setActivarnombre_ciudadProcesoRecibos(esInicial);
		this.setActivarnombre_zonaProcesoRecibos(esInicial);
		this.setActivarnombre_grupo_clienteProcesoRecibos(esInicial);
		this.setActivarnombre_vendedorProcesoRecibos(esInicial);
		this.setActivarcodigoProcesoRecibos(esInicial);
		this.setActivarnombre_completoProcesoRecibos(esInicial);
		this.setActivarcodigo_asientoProcesoRecibos(esInicial);
		this.setActivarnumero_mayorProcesoRecibos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.ID)) {
				this.setActivaridProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDPROVINCIA)) {
				this.setActivarid_provinciaProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setActivarid_grupo_clienteProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBREPROVINCIA)) {
				this.setActivarnombre_provinciaProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBRECIUDAD)) {
				this.setActivarnombre_ciudadProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBREZONA)) {
				this.setActivarnombre_zonaProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setActivarnombre_grupo_clienteProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setActivarnombre_vendedorProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.CODIGOASIENTO)) {
				this.setActivarcodigo_asientoProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorProcesoRecibos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoRecibos(esInicial);
		this.setResaltarid_provinciaProcesoRecibos(esInicial);
		this.setResaltarid_ciudadProcesoRecibos(esInicial);
		this.setResaltarid_zonaProcesoRecibos(esInicial);
		this.setResaltarid_grupo_clienteProcesoRecibos(esInicial);
		this.setResaltarid_vendedorProcesoRecibos(esInicial);
		this.setResaltarnombre_provinciaProcesoRecibos(esInicial);
		this.setResaltarnombre_ciudadProcesoRecibos(esInicial);
		this.setResaltarnombre_zonaProcesoRecibos(esInicial);
		this.setResaltarnombre_grupo_clienteProcesoRecibos(esInicial);
		this.setResaltarnombre_vendedorProcesoRecibos(esInicial);
		this.setResaltarcodigoProcesoRecibos(esInicial);
		this.setResaltarnombre_completoProcesoRecibos(esInicial);
		this.setResaltarcodigo_asientoProcesoRecibos(esInicial);
		this.setResaltarnumero_mayorProcesoRecibos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.ID)) {
				this.setResaltaridProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDPROVINCIA)) {
				this.setResaltarid_provinciaProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setResaltarid_grupo_clienteProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBREPROVINCIA)) {
				this.setResaltarnombre_provinciaProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBRECIUDAD)) {
				this.setResaltarnombre_ciudadProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBREZONA)) {
				this.setResaltarnombre_zonaProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setResaltarnombre_grupo_clienteProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setResaltarnombre_vendedorProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.CODIGOASIENTO)) {
				this.setResaltarcodigo_asientoProcesoRecibos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecibosConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorProcesoRecibos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoRecibosProcesoRecibos=true;

	public Boolean getMostrarBusquedaProcesoRecibosProcesoRecibos() {
		return this.mostrarBusquedaProcesoRecibosProcesoRecibos;
	}

	public void setMostrarBusquedaProcesoRecibosProcesoRecibos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoRecibosProcesoRecibos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoRecibosProcesoRecibos=true;

	public Boolean getActivarBusquedaProcesoRecibosProcesoRecibos() {
		return this.activarBusquedaProcesoRecibosProcesoRecibos;
	}

	public void setActivarBusquedaProcesoRecibosProcesoRecibos(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoRecibosProcesoRecibos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoRecibosProcesoRecibos=null;

	public Border getResaltarBusquedaProcesoRecibosProcesoRecibos() {
		return this.resaltarBusquedaProcesoRecibosProcesoRecibos;
	}

	public void setResaltarBusquedaProcesoRecibosProcesoRecibos(Border borderResaltar) {
		this.resaltarBusquedaProcesoRecibosProcesoRecibos= borderResaltar;
	}

	public void setResaltarBusquedaProcesoRecibosProcesoRecibos(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecibosBeanSwingJInternalFrame procesorecibosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoRecibosProcesoRecibos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}