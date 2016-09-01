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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.EstructuraConstantesFunciones;
import com.bydan.erp.nomina.util.EstructuraParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstructuraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstructuraConstantesFunciones extends EstructuraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Estructura";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Estructura"+EstructuraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstructuraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstructuraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstructuraConstantesFunciones.SCHEMA+"_"+EstructuraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstructuraConstantesFunciones.SCHEMA+"_"+EstructuraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstructuraConstantesFunciones.SCHEMA+"_"+EstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstructuraConstantesFunciones.SCHEMA+"_"+EstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstructuraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstructuraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstructuraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstructuraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estructuras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estructura";
	public static final String SCLASSWEBTITULO_LOWER="Estructura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Estructura";
	public static final String OBJECTNAME="estructura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="estructura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estructura from "+EstructuraConstantesFunciones.SPERSISTENCENAME+" estructura";
	public static String QUERYSELECTNATIVE="select "+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".version_row,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_empresa,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_sucursal,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_estructura,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_tipo_pago__n_m,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_numero_patronal,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_cuenta_contable,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_tipo_estructura,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_pais,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_ciudad,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".codigo,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".numero,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".valor_anticipo,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".porcentaje_anticipo,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".nombre,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".es_jefe,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".es_anual,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".porcentaje,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".valor from "+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME;//+" as "+EstructuraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstructuraConstantesFuncionesAdditional estructuraConstantesFuncionesAdditional=null;
	
	public EstructuraConstantesFuncionesAdditional getEstructuraConstantesFuncionesAdditional() {
		return this.estructuraConstantesFuncionesAdditional;
	}
	
	public void setEstructuraConstantesFuncionesAdditional(EstructuraConstantesFuncionesAdditional estructuraConstantesFuncionesAdditional) {
		try {
			this.estructuraConstantesFuncionesAdditional=estructuraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDTIPOPAGO_NM= "id_tipo_pago__n_m";
    public static final String IDNUMEROPATRONAL= "id_numero_patronal";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDTIPOESTRUCTURA= "id_tipo_estructura";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String CODIGO= "codigo";
    public static final String NUMERO= "numero";
    public static final String VALORANTICIPO= "valor_anticipo";
    public static final String PORCENTAJEANTICIPO= "porcentaje_anticipo";
    public static final String NOMBRE= "nombre";
    public static final String ESJEFE= "es_jefe";
    public static final String ESANUAL= "es_anual";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALOR= "valor";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDESTRUCTURA= "Estructura Padre";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDTIPOPAGO_NM= "Tipo Pago_ N M";
		public static final String LABEL_IDTIPOPAGO_NM_LOWER= "Tipo Pago_ N M";
    	public static final String LABEL_IDNUMEROPATRONAL= "Numero Patronal";
		public static final String LABEL_IDNUMEROPATRONAL_LOWER= "Numero Patronal";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDTIPOESTRUCTURA= "Tipo Estructura";
		public static final String LABEL_IDTIPOESTRUCTURA_LOWER= "Tipo Estructura";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_VALORANTICIPO= "Valor Anticipo";
		public static final String LABEL_VALORANTICIPO_LOWER= "Valor Anticipo";
    	public static final String LABEL_PORCENTAJEANTICIPO= "Porcentaje Anticipo";
		public static final String LABEL_PORCENTAJEANTICIPO_LOWER= "Porcentaje Anticipo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ESJEFE= "Es Jefe";
		public static final String LABEL_ESJEFE_LOWER= "Es Jefe";
    	public static final String LABEL_ESANUAL= "Es Anual Exacto";
		public static final String LABEL_ESANUAL_LOWER= "Es Anual";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getEstructuraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstructuraConstantesFunciones.IDEMPRESA)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.IDTIPOPAGO_NM)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_IDTIPOPAGO_NM;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.IDNUMEROPATRONAL)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_IDNUMEROPATRONAL;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.IDTIPOESTRUCTURA)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_IDTIPOESTRUCTURA;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.IDPAIS)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.IDCIUDAD)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.CODIGO)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.NUMERO)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.VALORANTICIPO)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_VALORANTICIPO;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.PORCENTAJEANTICIPO)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_PORCENTAJEANTICIPO;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.NOMBRE)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.ESJEFE)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_ESJEFE;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.ESANUAL)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_ESANUAL;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.PORCENTAJE)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(EstructuraConstantesFunciones.VALOR)) {sLabelColumna=EstructuraConstantesFunciones.LABEL_VALOR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_jefeDescripcion(Estructura estructura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!estructura.getes_jefe()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_jefeHtmlDescripcion(Estructura estructura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(estructura.getId(),estructura.getes_jefe());

		return sDescripcion;
	}	
		
	public static String getes_anualDescripcion(Estructura estructura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!estructura.getes_anual()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_anualHtmlDescripcion(Estructura estructura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(estructura.getId(),estructura.getes_anual());

		return sDescripcion;
	}	
			
			
	
	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estructura !=null/* && estructura.getId()!=0*/) {
			sDescripcion=estructura.getcodigo()+"-"+estructura.getnombre();//estructuraestructura.getcodigo().trim()+"-"+estructura.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstructuraDescripcionDetallado(Estructura estructura) {
		String sDescripcion="";
			
		sDescripcion+=EstructuraConstantesFunciones.ID+"=";
		sDescripcion+=estructura.getId().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estructura.getVersionRow().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=estructura.getid_empresa().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=estructura.getid_sucursal().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=estructura.getid_estructura().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.IDTIPOPAGO_NM+"=";
		sDescripcion+=estructura.getid_tipo_pago__n_m().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.IDNUMEROPATRONAL+"=";
		sDescripcion+=estructura.getid_numero_patronal().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=estructura.getid_cuenta_contable().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.IDTIPOESTRUCTURA+"=";
		sDescripcion+=estructura.getid_tipo_estructura().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.IDPAIS+"=";
		sDescripcion+=estructura.getid_pais().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=estructura.getid_ciudad().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.CODIGO+"=";
		sDescripcion+=estructura.getcodigo()+",";
		sDescripcion+=EstructuraConstantesFunciones.NUMERO+"=";
		sDescripcion+=estructura.getnumero()+",";
		sDescripcion+=EstructuraConstantesFunciones.VALORANTICIPO+"=";
		sDescripcion+=estructura.getvalor_anticipo().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.PORCENTAJEANTICIPO+"=";
		sDescripcion+=estructura.getporcentaje_anticipo().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estructura.getnombre()+",";
		sDescripcion+=EstructuraConstantesFunciones.ESJEFE+"=";
		sDescripcion+=estructura.getes_jefe().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.ESANUAL+"=";
		sDescripcion+=estructura.getes_anual().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=estructura.getporcentaje().toString()+",";
		sDescripcion+=EstructuraConstantesFunciones.VALOR+"=";
		sDescripcion+=estructura.getvalor().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEstructuraDescripcion(Estructura estructura,String sValor) throws Exception {			
		if(estructura !=null) {
			estructura.setcodigo(sValor);
estructura.setnombre(sValor);;//estructuraestructura.getcodigo().trim()+"-"+estructura.getnombre().trim();
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

	public static String getTipoPago_NMDescripcion(TipoPago_NM tipopago_nm) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipopago_nm!=null/*&&tipopago_nm.getId()>0*/) {
			sDescripcion=TipoPago_NMConstantesFunciones.getTipoPago_NMDescripcion(tipopago_nm);
		}

		return sDescripcion;
	}

	public static String getNumeroPatronalDescripcion(NumeroPatronal numeropatronal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(numeropatronal!=null/*&&numeropatronal.getId()>0*/) {
			sDescripcion=NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(numeropatronal);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getTipoEstructuraDescripcion(TipoEstructura tipoestructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoestructura!=null/*&&tipoestructura.getId()>0*/) {
			sDescripcion=TipoEstructuraConstantesFunciones.getTipoEstructuraDescripcion(tipoestructura);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura Padre";
		} else if(sNombreIndice.equals("FK_IdNumeroPatronal")) {
			sNombreIndice="Tipo=  Por Numero Patronal";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoEstructura")) {
			sNombreIndice="Tipo=  Por Tipo Estructura";
		} else if(sNombreIndice.equals("FK_IdTipoPago_NM")) {
			sNombreIndice="Tipo=  Por Tipo Pago_ N M";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura Padre="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdNumeroPatronal(Long id_numero_patronal) {
		String sDetalleIndice=" Parametros->";
		if(id_numero_patronal!=null) {sDetalleIndice+=" Codigo Unico De Numero Patronal="+id_numero_patronal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoEstructura(Long id_tipo_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_estructura!=null) {sDetalleIndice+=" Codigo Unico De Tipo Estructura="+id_tipo_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPago_NM(Long id_tipo_pago__n_m) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_pago__n_m!=null) {sDetalleIndice+=" Codigo Unico De Tipo Pago_ N M="+id_tipo_pago__n_m.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstructura(Estructura estructura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estructura.setcodigo(estructura.getcodigo().trim());
		estructura.setnumero(estructura.getnumero().trim());
		estructura.setnombre(estructura.getnombre().trim());
	}
	
	public static void quitarEspaciosEstructuras(List<Estructura> estructuras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Estructura estructura: estructuras) {
			estructura.setcodigo(estructura.getcodigo().trim());
			estructura.setnumero(estructura.getnumero().trim());
			estructura.setnombre(estructura.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstructura(Estructura estructura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estructura.getConCambioAuxiliar()) {
			estructura.setIsDeleted(estructura.getIsDeletedAuxiliar());	
			estructura.setIsNew(estructura.getIsNewAuxiliar());	
			estructura.setIsChanged(estructura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estructura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estructura.setIsDeletedAuxiliar(false);	
			estructura.setIsNewAuxiliar(false);	
			estructura.setIsChangedAuxiliar(false);
			
			estructura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstructuras(List<Estructura> estructuras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Estructura estructura : estructuras) {
			if(conAsignarBase && estructura.getConCambioAuxiliar()) {
				estructura.setIsDeleted(estructura.getIsDeletedAuxiliar());	
				estructura.setIsNew(estructura.getIsNewAuxiliar());	
				estructura.setIsChanged(estructura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estructura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estructura.setIsDeletedAuxiliar(false);	
				estructura.setIsNewAuxiliar(false);	
				estructura.setIsChangedAuxiliar(false);
				
				estructura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstructura(Estructura estructura,Boolean conEnteros) throws Exception  {
		estructura.setvalor_anticipo(0.0);
		estructura.setporcentaje_anticipo(0.0);
		estructura.setporcentaje(0.0);
		estructura.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstructuras(List<Estructura> estructuras,Boolean conEnteros) throws Exception  {
		
		for(Estructura estructura: estructuras) {
			estructura.setvalor_anticipo(0.0);
			estructura.setporcentaje_anticipo(0.0);
			estructura.setporcentaje(0.0);
			estructura.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstructura(List<Estructura> estructuras,Estructura estructuraAux) throws Exception  {
		EstructuraConstantesFunciones.InicializarValoresEstructura(estructuraAux,true);
		
		for(Estructura estructura: estructuras) {
			if(estructura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			estructuraAux.setvalor_anticipo(estructuraAux.getvalor_anticipo()+estructura.getvalor_anticipo());			
			estructuraAux.setporcentaje_anticipo(estructuraAux.getporcentaje_anticipo()+estructura.getporcentaje_anticipo());			
			estructuraAux.setporcentaje(estructuraAux.getporcentaje()+estructura.getporcentaje());			
			estructuraAux.setvalor(estructuraAux.getvalor()+estructura.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstructura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstructuraConstantesFunciones.getArrayColumnasGlobalesEstructura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstructura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EstructuraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EstructuraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EstructuraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EstructuraConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstructura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Estructura> estructuras,Estructura estructura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Estructura estructuraAux: estructuras) {
			if(estructuraAux!=null && estructura!=null) {
				if((estructuraAux.getId()==null && estructura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estructuraAux.getId()!=null && estructura.getId()!=null){
					if(estructuraAux.getId().equals(estructura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstructura(List<Estructura> estructuras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_anticipoTotal=0.0;
		Double porcentaje_anticipoTotal=0.0;
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
	
		for(Estructura estructura: estructuras) {			
			if(estructura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_anticipoTotal+=estructura.getvalor_anticipo();
			porcentaje_anticipoTotal+=estructura.getporcentaje_anticipo();
			porcentajeTotal+=estructura.getporcentaje();
			valorTotal+=estructura.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstructuraConstantesFunciones.VALORANTICIPO);
		datoGeneral.setsDescripcion(EstructuraConstantesFunciones.LABEL_VALORANTICIPO);
		datoGeneral.setdValorDouble(valor_anticipoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstructuraConstantesFunciones.PORCENTAJEANTICIPO);
		datoGeneral.setsDescripcion(EstructuraConstantesFunciones.LABEL_PORCENTAJEANTICIPO);
		datoGeneral.setdValorDouble(porcentaje_anticipoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstructuraConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(EstructuraConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstructuraConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(EstructuraConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstructura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_ID, EstructuraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_VERSIONROW, EstructuraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_IDEMPRESA, EstructuraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_IDSUCURSAL, EstructuraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_IDESTRUCTURA, EstructuraConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_IDTIPOPAGO_NM, EstructuraConstantesFunciones.IDTIPOPAGO_NM,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_IDNUMEROPATRONAL, EstructuraConstantesFunciones.IDNUMEROPATRONAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_IDCUENTACONTABLE, EstructuraConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_IDTIPOESTRUCTURA, EstructuraConstantesFunciones.IDTIPOESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_IDPAIS, EstructuraConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_IDCIUDAD, EstructuraConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_CODIGO, EstructuraConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_NUMERO, EstructuraConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_VALORANTICIPO, EstructuraConstantesFunciones.VALORANTICIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_PORCENTAJEANTICIPO, EstructuraConstantesFunciones.PORCENTAJEANTICIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_NOMBRE, EstructuraConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_ESJEFE, EstructuraConstantesFunciones.ESJEFE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_ESANUAL, EstructuraConstantesFunciones.ESANUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_PORCENTAJE, EstructuraConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstructuraConstantesFunciones.LABEL_VALOR, EstructuraConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstructura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.IDTIPOPAGO_NM;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.IDNUMEROPATRONAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.IDTIPOESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.VALORANTICIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.PORCENTAJEANTICIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.ESJEFE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.ESANUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstructuraConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstructura() throws Exception  {
		return EstructuraConstantesFunciones.getTiposSeleccionarEstructura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstructura(Boolean conFk) throws Exception  {
		return EstructuraConstantesFunciones.getTiposSeleccionarEstructura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstructura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_IDTIPOPAGO_NM);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_IDTIPOPAGO_NM);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_IDNUMEROPATRONAL);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_IDNUMEROPATRONAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_IDTIPOESTRUCTURA);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_IDTIPOESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_VALORANTICIPO);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_VALORANTICIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_PORCENTAJEANTICIPO);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_PORCENTAJEANTICIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_ESJEFE);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_ESJEFE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_ESANUAL);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_ESANUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstructuraConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(EstructuraConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstructura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstructura(Estructura estructuraAux) throws Exception {
		
			estructuraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estructuraAux.getEmpresa()));
			estructuraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(estructuraAux.getSucursal()));
			estructuraAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(estructuraAux.getEstructura()));
			estructuraAux.settipopago_nm_descripcion(TipoPago_NMConstantesFunciones.getTipoPago_NMDescripcion(estructuraAux.getTipoPago_NM()));
			estructuraAux.setnumeropatronal_descripcion(NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(estructuraAux.getNumeroPatronal()));
			estructuraAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(estructuraAux.getCuentaContable()));
			estructuraAux.settipoestructura_descripcion(TipoEstructuraConstantesFunciones.getTipoEstructuraDescripcion(estructuraAux.getTipoEstructura()));
			estructuraAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(estructuraAux.getPais()));
			estructuraAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(estructuraAux.getCiudad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEstructura(List<Estructura> estructurasTemp) throws Exception {
		for(Estructura estructuraAux:estructurasTemp) {
			
			estructuraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estructuraAux.getEmpresa()));
			estructuraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(estructuraAux.getSucursal()));
			estructuraAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(estructuraAux.getEstructura()));
			estructuraAux.settipopago_nm_descripcion(TipoPago_NMConstantesFunciones.getTipoPago_NMDescripcion(estructuraAux.getTipoPago_NM()));
			estructuraAux.setnumeropatronal_descripcion(NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(estructuraAux.getNumeroPatronal()));
			estructuraAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(estructuraAux.getCuentaContable()));
			estructuraAux.settipoestructura_descripcion(TipoEstructuraConstantesFunciones.getTipoEstructuraDescripcion(estructuraAux.getTipoEstructura()));
			estructuraAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(estructuraAux.getPais()));
			estructuraAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(estructuraAux.getCiudad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(TipoPago_NM.class));
				classes.add(new Classe(NumeroPatronal.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(TipoEstructura.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				
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
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPago_NM.class)) {
						classes.add(new Classe(TipoPago_NM.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NumeroPatronal.class)) {
						classes.add(new Classe(NumeroPatronal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoEstructura.class)) {
						classes.add(new Classe(TipoEstructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(TipoPago_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPago_NM.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(TipoEstructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEstructura.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(TipoPago_NM.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPago_NM.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(TipoEstructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoEstructura.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstructuraConstantesFunciones.getClassesRelationshipsOfEstructura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CentroCostoEstructura.class));
				classes.add(new Classe(PlaniVacacion.class));
				classes.add(new Classe(AsistenciaMensual.class));
				classes.add(new Classe(EmpleadoProcesoRubro.class));
				classes.add(new Classe(EmpleadoPagoRubro.class));
				classes.add(new Classe(ProvisionEmpleado.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(EvaluacionEmpleado.class));
				classes.add(new Classe(EmpleadoImpuestoRenta.class));
				classes.add(new Classe(RubroEstructura.class));
				classes.add(new Classe(CierreRolMensual.class));
				classes.add(new Classe(FormatoNomi.class));
				classes.add(new Classe(EmpleadoEstructura.class));
				classes.add(new Classe(HistorialPagoNomi.class));
				classes.add(new Classe(AsistenciaDiaria.class));
				classes.add(new Classe(FuncionEstruc.class));
				classes.add(new Classe(SolicitudReemplazo.class));
				classes.add(new Classe(SolicitudHoraExtra.class));
				classes.add(new Classe(EvaluacionNomi.class));
				classes.add(new Classe(SolicitudVacacion.class));
				classes.add(new Classe(ResponsableActivoFijo.class));
				classes.add(new Classe(RubroEmpleaCuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCostoEstructura.class)) {
						classes.add(new Classe(CentroCostoEstructura.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PlaniVacacion.class)) {
						classes.add(new Classe(PlaniVacacion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsistenciaMensual.class)) {
						classes.add(new Classe(AsistenciaMensual.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoProcesoRubro.class)) {
						classes.add(new Classe(EmpleadoProcesoRubro.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoPagoRubro.class)) {
						classes.add(new Classe(EmpleadoPagoRubro.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProvisionEmpleado.class)) {
						classes.add(new Classe(ProvisionEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EvaluacionEmpleado.class)) {
						classes.add(new Classe(EvaluacionEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoImpuestoRenta.class)) {
						classes.add(new Classe(EmpleadoImpuestoRenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEstructura.class)) {
						classes.add(new Classe(RubroEstructura.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CierreRolMensual.class)) {
						classes.add(new Classe(CierreRolMensual.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormatoNomi.class)) {
						classes.add(new Classe(FormatoNomi.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoEstructura.class)) {
						classes.add(new Classe(EmpleadoEstructura.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(HistorialPagoNomi.class)) {
						classes.add(new Classe(HistorialPagoNomi.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsistenciaDiaria.class)) {
						classes.add(new Classe(AsistenciaDiaria.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FuncionEstruc.class)) {
						classes.add(new Classe(FuncionEstruc.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SolicitudReemplazo.class)) {
						classes.add(new Classe(SolicitudReemplazo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SolicitudHoraExtra.class)) {
						classes.add(new Classe(SolicitudHoraExtra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EvaluacionNomi.class)) {
						classes.add(new Classe(EvaluacionNomi.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SolicitudVacacion.class)) {
						classes.add(new Classe(SolicitudVacacion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ResponsableActivoFijo.class)) {
						classes.add(new Classe(ResponsableActivoFijo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEmpleaCuentaContable.class)) {
						classes.add(new Classe(RubroEmpleaCuentaContable.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstructuraConstantesFunciones.getClassesRelationshipsFromStringsOfEstructura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CentroCostoEstructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCostoEstructura.class)); continue;
					}

					if(PlaniVacacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PlaniVacacion.class)); continue;
					}

					if(AsistenciaMensual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsistenciaMensual.class)); continue;
					}

					if(EmpleadoProcesoRubro.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoProcesoRubro.class)); continue;
					}

					if(EmpleadoPagoRubro.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoPagoRubro.class)); continue;
					}

					if(ProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProvisionEmpleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(EvaluacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionEmpleado.class)); continue;
					}

					if(EmpleadoImpuestoRenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoImpuestoRenta.class)); continue;
					}

					if(RubroEstructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEstructura.class)); continue;
					}

					if(CierreRolMensual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CierreRolMensual.class)); continue;
					}

					if(FormatoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomi.class)); continue;
					}

					if(EmpleadoEstructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoEstructura.class)); continue;
					}

					if(HistorialPagoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialPagoNomi.class)); continue;
					}

					if(AsistenciaDiaria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsistenciaDiaria.class)); continue;
					}

					if(FuncionEstruc.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FuncionEstruc.class)); continue;
					}

					if(SolicitudReemplazo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SolicitudReemplazo.class)); continue;
					}

					if(SolicitudHoraExtra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SolicitudHoraExtra.class)); continue;
					}

					if(EvaluacionNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionNomi.class)); continue;
					}

					if(SolicitudVacacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SolicitudVacacion.class)); continue;
					}

					if(ResponsableActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ResponsableActivoFijo.class)); continue;
					}

					if(RubroEmpleaCuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmpleaCuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CentroCostoEstructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCostoEstructura.class)); continue;
					}

					if(PlaniVacacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PlaniVacacion.class)); continue;
					}

					if(AsistenciaMensual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsistenciaMensual.class)); continue;
					}

					if(EmpleadoProcesoRubro.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoProcesoRubro.class)); continue;
					}

					if(EmpleadoPagoRubro.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoPagoRubro.class)); continue;
					}

					if(ProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProvisionEmpleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(EvaluacionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionEmpleado.class)); continue;
					}

					if(EmpleadoImpuestoRenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoImpuestoRenta.class)); continue;
					}

					if(RubroEstructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEstructura.class)); continue;
					}

					if(CierreRolMensual.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CierreRolMensual.class)); continue;
					}

					if(FormatoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomi.class)); continue;
					}

					if(EmpleadoEstructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoEstructura.class)); continue;
					}

					if(HistorialPagoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialPagoNomi.class)); continue;
					}

					if(AsistenciaDiaria.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsistenciaDiaria.class)); continue;
					}

					if(FuncionEstruc.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FuncionEstruc.class)); continue;
					}

					if(SolicitudReemplazo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SolicitudReemplazo.class)); continue;
					}

					if(SolicitudHoraExtra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SolicitudHoraExtra.class)); continue;
					}

					if(EvaluacionNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EvaluacionNomi.class)); continue;
					}

					if(SolicitudVacacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SolicitudVacacion.class)); continue;
					}

					if(ResponsableActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ResponsableActivoFijo.class)); continue;
					}

					if(RubroEmpleaCuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmpleaCuentaContable.class)); continue;
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
	public static void actualizarLista(Estructura estructura,List<Estructura> estructuras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Estructura estructuraEncontrado=null;
			
			for(Estructura estructuraLocal:estructuras) {
				if(estructuraLocal.getId().equals(estructura.getId())) {
					estructuraEncontrado=estructuraLocal;
					
					estructuraLocal.setIsChanged(estructura.getIsChanged());
					estructuraLocal.setIsNew(estructura.getIsNew());
					estructuraLocal.setIsDeleted(estructura.getIsDeleted());
					
					estructuraLocal.setGeneralEntityOriginal(estructura.getGeneralEntityOriginal());
					
					estructuraLocal.setId(estructura.getId());	
					estructuraLocal.setVersionRow(estructura.getVersionRow());	
					estructuraLocal.setid_empresa(estructura.getid_empresa());	
					estructuraLocal.setid_sucursal(estructura.getid_sucursal());	
					estructuraLocal.setid_estructura(estructura.getid_estructura());	
					estructuraLocal.setid_tipo_pago__n_m(estructura.getid_tipo_pago__n_m());	
					estructuraLocal.setid_numero_patronal(estructura.getid_numero_patronal());	
					estructuraLocal.setid_cuenta_contable(estructura.getid_cuenta_contable());	
					estructuraLocal.setid_tipo_estructura(estructura.getid_tipo_estructura());	
					estructuraLocal.setid_pais(estructura.getid_pais());	
					estructuraLocal.setid_ciudad(estructura.getid_ciudad());	
					estructuraLocal.setcodigo(estructura.getcodigo());	
					estructuraLocal.setnumero(estructura.getnumero());	
					estructuraLocal.setvalor_anticipo(estructura.getvalor_anticipo());	
					estructuraLocal.setporcentaje_anticipo(estructura.getporcentaje_anticipo());	
					estructuraLocal.setnombre(estructura.getnombre());	
					estructuraLocal.setes_jefe(estructura.getes_jefe());	
					estructuraLocal.setes_anual(estructura.getes_anual());	
					estructuraLocal.setporcentaje(estructura.getporcentaje());	
					estructuraLocal.setvalor(estructura.getvalor());	
					
					
					estructuraLocal.setCentroCostoEstructuras(estructura.getCentroCostoEstructuras());
					estructuraLocal.setPlaniVacacionCargos(estructura.getPlaniVacacionCargos());
					estructuraLocal.setAsistenciaMensuals(estructura.getAsistenciaMensuals());
					estructuraLocal.setEmpleadoProcesoRubros(estructura.getEmpleadoProcesoRubros());
					estructuraLocal.setEmpleadoPagoRubros(estructura.getEmpleadoPagoRubros());
					estructuraLocal.setProvisionEmpleados(estructura.getProvisionEmpleados());
					estructuraLocal.setEmpleados(estructura.getEmpleados());
					estructuraLocal.setEstructuras(estructura.getEstructuras());
					estructuraLocal.setEvaluacionEmpleados(estructura.getEvaluacionEmpleados());
					estructuraLocal.setEmpleadoImpuestoRentas(estructura.getEmpleadoImpuestoRentas());
					estructuraLocal.setRubroEstructuras(estructura.getRubroEstructuras());
					estructuraLocal.setCierreRolMensuals(estructura.getCierreRolMensuals());
					estructuraLocal.setFormatoNomis(estructura.getFormatoNomis());
					estructuraLocal.setEmpleadoEstructuras(estructura.getEmpleadoEstructuras());
					estructuraLocal.setHistorialPagoNomis(estructura.getHistorialPagoNomis());
					estructuraLocal.setAsistenciaDiarias(estructura.getAsistenciaDiarias());
					estructuraLocal.setFuncionEstrucs(estructura.getFuncionEstrucs());
					estructuraLocal.setSolicitudReemplazos(estructura.getSolicitudReemplazos());
					estructuraLocal.setSolicitudHoraExtras(estructura.getSolicitudHoraExtras());
					estructuraLocal.setEvaluacionNomis(estructura.getEvaluacionNomis());
					estructuraLocal.setSolicitudVacacions(estructura.getSolicitudVacacions());
					estructuraLocal.setResponsableActivoFijos(estructura.getResponsableActivoFijos());
					estructuraLocal.setRubroEmpleaCuentaContables(estructura.getRubroEmpleaCuentaContables());
					
					existe=true;
					break;
				}
			}
			
			if(!estructura.getIsDeleted()) {
				if(!existe) {
					estructuras.add(estructura);
				}
			} else {
				if(estructuraEncontrado!=null && permiteQuitar)  {
					estructuras.remove(estructuraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Estructura estructura,List<Estructura> estructuras) throws Exception {
		try	{			
			for(Estructura estructuraLocal:estructuras) {
				if(estructuraLocal.getId().equals(estructura.getId())) {
					estructuraLocal.setIsSelected(estructura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstructura(List<Estructura> estructurasAux) throws Exception {
		//this.estructurasAux=estructurasAux;
		
		for(Estructura estructuraAux:estructurasAux) {
			if(estructuraAux.getIsChanged()) {
				estructuraAux.setIsChanged(false);
			}		
			
			if(estructuraAux.getIsNew()) {
				estructuraAux.setIsNew(false);
			}	
			
			if(estructuraAux.getIsDeleted()) {
				estructuraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstructura(Estructura estructuraAux) throws Exception {
		//this.estructuraAux=estructuraAux;
		
			if(estructuraAux.getIsChanged()) {
				estructuraAux.setIsChanged(false);
			}		
			
			if(estructuraAux.getIsNew()) {
				estructuraAux.setIsNew(false);
			}	
			
			if(estructuraAux.getIsDeleted()) {
				estructuraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Estructura estructuraAsignar,Estructura estructura) throws Exception {
		estructuraAsignar.setId(estructura.getId());	
		estructuraAsignar.setVersionRow(estructura.getVersionRow());	
		estructuraAsignar.setid_empresa(estructura.getid_empresa());
		estructuraAsignar.setempresa_descripcion(estructura.getempresa_descripcion());	
		estructuraAsignar.setid_sucursal(estructura.getid_sucursal());
		estructuraAsignar.setsucursal_descripcion(estructura.getsucursal_descripcion());	
		estructuraAsignar.setid_estructura(estructura.getid_estructura());
		estructuraAsignar.setestructura_descripcion(estructura.getestructura_descripcion());	
		estructuraAsignar.setid_tipo_pago__n_m(estructura.getid_tipo_pago__n_m());
		estructuraAsignar.settipopago_nm_descripcion(estructura.gettipopago_nm_descripcion());	
		estructuraAsignar.setid_numero_patronal(estructura.getid_numero_patronal());
		estructuraAsignar.setnumeropatronal_descripcion(estructura.getnumeropatronal_descripcion());	
		estructuraAsignar.setid_cuenta_contable(estructura.getid_cuenta_contable());
		estructuraAsignar.setcuentacontable_descripcion(estructura.getcuentacontable_descripcion());	
		estructuraAsignar.setid_tipo_estructura(estructura.getid_tipo_estructura());
		estructuraAsignar.settipoestructura_descripcion(estructura.gettipoestructura_descripcion());	
		estructuraAsignar.setid_pais(estructura.getid_pais());
		estructuraAsignar.setpais_descripcion(estructura.getpais_descripcion());	
		estructuraAsignar.setid_ciudad(estructura.getid_ciudad());
		estructuraAsignar.setciudad_descripcion(estructura.getciudad_descripcion());	
		estructuraAsignar.setcodigo(estructura.getcodigo());	
		estructuraAsignar.setnumero(estructura.getnumero());	
		estructuraAsignar.setvalor_anticipo(estructura.getvalor_anticipo());	
		estructuraAsignar.setporcentaje_anticipo(estructura.getporcentaje_anticipo());	
		estructuraAsignar.setnombre(estructura.getnombre());	
		estructuraAsignar.setes_jefe(estructura.getes_jefe());	
		estructuraAsignar.setes_anual(estructura.getes_anual());	
		estructuraAsignar.setporcentaje(estructura.getporcentaje());	
		estructuraAsignar.setvalor(estructura.getvalor());	
	}
	
	public static void inicializarEstructura(Estructura estructura) throws Exception {
		try {
				estructura.setId(0L);	
					
				estructura.setid_empresa(-1L);	
				estructura.setid_sucursal(-1L);	
				estructura.setid_estructura(null);	
				estructura.setid_tipo_pago__n_m(-1L);	
				estructura.setid_numero_patronal(-1L);	
				estructura.setid_cuenta_contable(-1L);	
				estructura.setid_tipo_estructura(-1L);	
				estructura.setid_pais(-1L);	
				estructura.setid_ciudad(-1L);	
				estructura.setcodigo("");	
				estructura.setnumero("");	
				estructura.setvalor_anticipo(0.0);	
				estructura.setporcentaje_anticipo(0.0);	
				estructura.setnombre("");	
				estructura.setes_jefe(false);	
				estructura.setes_anual(false);	
				estructura.setporcentaje(0.0);	
				estructura.setvalor(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstructura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_IDTIPOPAGO_NM);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_IDNUMEROPATRONAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_IDTIPOESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_VALORANTICIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_PORCENTAJEANTICIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_ESJEFE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_ESANUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstructuraConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstructura(String sTipo,Row row,Workbook workbook,Estructura estructura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.gettipopago_nm_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getnumeropatronal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.gettipoestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getvalor_anticipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getporcentaje_anticipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(estructura.getes_jefe()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(estructura.getes_anual()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estructura.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstructura=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstructura() {
		return this.sFinalQueryEstructura;
	}
	
	public void setsFinalQueryEstructura(String sFinalQueryEstructura) {
		this.sFinalQueryEstructura= sFinalQueryEstructura;
	}
	
	public Border resaltarSeleccionarEstructura=null;
	
	public Border setResaltarSeleccionarEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstructura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstructura() {
		return this.resaltarSeleccionarEstructura;
	}
	
	public void setResaltarSeleccionarEstructura(Border borderResaltarSeleccionarEstructura) {
		this.resaltarSeleccionarEstructura= borderResaltarSeleccionarEstructura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstructura=null;
	public Boolean mostraridEstructura=true;
	public Boolean activaridEstructura=true;

	public Border resaltarid_empresaEstructura=null;
	public Boolean mostrarid_empresaEstructura=true;
	public Boolean activarid_empresaEstructura=true;
	public Boolean cargarid_empresaEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEstructura=false;//ConEventDepend=true

	public Border resaltarid_sucursalEstructura=null;
	public Boolean mostrarid_sucursalEstructura=true;
	public Boolean activarid_sucursalEstructura=true;
	public Boolean cargarid_sucursalEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalEstructura=false;//ConEventDepend=true

	public Border resaltarid_estructuraEstructura=null;
	public Boolean mostrarid_estructuraEstructura=true;
	public Boolean activarid_estructuraEstructura=true;
	public Boolean cargarid_estructuraEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraEstructura=false;//ConEventDepend=true

	public Border resaltarid_tipo_pago__n_mEstructura=null;
	public Boolean mostrarid_tipo_pago__n_mEstructura=true;
	public Boolean activarid_tipo_pago__n_mEstructura=true;
	public Boolean cargarid_tipo_pago__n_mEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_pago__n_mEstructura=false;//ConEventDepend=true

	public Border resaltarid_numero_patronalEstructura=null;
	public Boolean mostrarid_numero_patronalEstructura=true;
	public Boolean activarid_numero_patronalEstructura=true;
	public Boolean cargarid_numero_patronalEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_numero_patronalEstructura=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableEstructura=null;
	public Boolean mostrarid_cuenta_contableEstructura=true;
	public Boolean activarid_cuenta_contableEstructura=true;
	public Boolean cargarid_cuenta_contableEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableEstructura=false;//ConEventDepend=true

	public Border resaltarid_tipo_estructuraEstructura=null;
	public Boolean mostrarid_tipo_estructuraEstructura=true;
	public Boolean activarid_tipo_estructuraEstructura=true;
	public Boolean cargarid_tipo_estructuraEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_estructuraEstructura=false;//ConEventDepend=true

	public Border resaltarid_paisEstructura=null;
	public Boolean mostrarid_paisEstructura=true;
	public Boolean activarid_paisEstructura=true;
	public Boolean cargarid_paisEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisEstructura=false;//ConEventDepend=true

	public Border resaltarid_ciudadEstructura=null;
	public Boolean mostrarid_ciudadEstructura=true;
	public Boolean activarid_ciudadEstructura=true;
	public Boolean cargarid_ciudadEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadEstructura=false;//ConEventDepend=true

	public Border resaltarcodigoEstructura=null;
	public Boolean mostrarcodigoEstructura=true;
	public Boolean activarcodigoEstructura=true;

	public Border resaltarnumeroEstructura=null;
	public Boolean mostrarnumeroEstructura=true;
	public Boolean activarnumeroEstructura=true;

	public Border resaltarvalor_anticipoEstructura=null;
	public Boolean mostrarvalor_anticipoEstructura=true;
	public Boolean activarvalor_anticipoEstructura=true;

	public Border resaltarporcentaje_anticipoEstructura=null;
	public Boolean mostrarporcentaje_anticipoEstructura=true;
	public Boolean activarporcentaje_anticipoEstructura=true;

	public Border resaltarnombreEstructura=null;
	public Boolean mostrarnombreEstructura=true;
	public Boolean activarnombreEstructura=true;

	public Border resaltares_jefeEstructura=null;
	public Boolean mostrares_jefeEstructura=true;
	public Boolean activares_jefeEstructura=true;

	public Border resaltares_anualEstructura=null;
	public Boolean mostrares_anualEstructura=true;
	public Boolean activares_anualEstructura=true;

	public Border resaltarporcentajeEstructura=null;
	public Boolean mostrarporcentajeEstructura=true;
	public Boolean activarporcentajeEstructura=true;

	public Border resaltarvalorEstructura=null;
	public Boolean mostrarvalorEstructura=true;
	public Boolean activarvalorEstructura=true;

	
	

	public Border setResaltaridEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltaridEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstructura() {
		return this.resaltaridEstructura;
	}

	public void setResaltaridEstructura(Border borderResaltar) {
		this.resaltaridEstructura= borderResaltar;
	}

	public Boolean getMostraridEstructura() {
		return this.mostraridEstructura;
	}

	public void setMostraridEstructura(Boolean mostraridEstructura) {
		this.mostraridEstructura= mostraridEstructura;
	}

	public Boolean getActivaridEstructura() {
		return this.activaridEstructura;
	}

	public void setActivaridEstructura(Boolean activaridEstructura) {
		this.activaridEstructura= activaridEstructura;
	}

	public Border setResaltarid_empresaEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarid_empresaEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEstructura() {
		return this.resaltarid_empresaEstructura;
	}

	public void setResaltarid_empresaEstructura(Border borderResaltar) {
		this.resaltarid_empresaEstructura= borderResaltar;
	}

	public Boolean getMostrarid_empresaEstructura() {
		return this.mostrarid_empresaEstructura;
	}

	public void setMostrarid_empresaEstructura(Boolean mostrarid_empresaEstructura) {
		this.mostrarid_empresaEstructura= mostrarid_empresaEstructura;
	}

	public Boolean getActivarid_empresaEstructura() {
		return this.activarid_empresaEstructura;
	}

	public void setActivarid_empresaEstructura(Boolean activarid_empresaEstructura) {
		this.activarid_empresaEstructura= activarid_empresaEstructura;
	}

	public Boolean getCargarid_empresaEstructura() {
		return this.cargarid_empresaEstructura;
	}

	public void setCargarid_empresaEstructura(Boolean cargarid_empresaEstructura) {
		this.cargarid_empresaEstructura= cargarid_empresaEstructura;
	}

	public Border setResaltarid_sucursalEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarid_sucursalEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalEstructura() {
		return this.resaltarid_sucursalEstructura;
	}

	public void setResaltarid_sucursalEstructura(Border borderResaltar) {
		this.resaltarid_sucursalEstructura= borderResaltar;
	}

	public Boolean getMostrarid_sucursalEstructura() {
		return this.mostrarid_sucursalEstructura;
	}

	public void setMostrarid_sucursalEstructura(Boolean mostrarid_sucursalEstructura) {
		this.mostrarid_sucursalEstructura= mostrarid_sucursalEstructura;
	}

	public Boolean getActivarid_sucursalEstructura() {
		return this.activarid_sucursalEstructura;
	}

	public void setActivarid_sucursalEstructura(Boolean activarid_sucursalEstructura) {
		this.activarid_sucursalEstructura= activarid_sucursalEstructura;
	}

	public Boolean getCargarid_sucursalEstructura() {
		return this.cargarid_sucursalEstructura;
	}

	public void setCargarid_sucursalEstructura(Boolean cargarid_sucursalEstructura) {
		this.cargarid_sucursalEstructura= cargarid_sucursalEstructura;
	}

	public Border setResaltarid_estructuraEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarid_estructuraEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraEstructura() {
		return this.resaltarid_estructuraEstructura;
	}

	public void setResaltarid_estructuraEstructura(Border borderResaltar) {
		this.resaltarid_estructuraEstructura= borderResaltar;
	}

	public Boolean getMostrarid_estructuraEstructura() {
		return this.mostrarid_estructuraEstructura;
	}

	public void setMostrarid_estructuraEstructura(Boolean mostrarid_estructuraEstructura) {
		this.mostrarid_estructuraEstructura= mostrarid_estructuraEstructura;
	}

	public Boolean getActivarid_estructuraEstructura() {
		return this.activarid_estructuraEstructura;
	}

	public void setActivarid_estructuraEstructura(Boolean activarid_estructuraEstructura) {
		this.activarid_estructuraEstructura= activarid_estructuraEstructura;
	}

	public Boolean getCargarid_estructuraEstructura() {
		return this.cargarid_estructuraEstructura;
	}

	public void setCargarid_estructuraEstructura(Boolean cargarid_estructuraEstructura) {
		this.cargarid_estructuraEstructura= cargarid_estructuraEstructura;
	}

	public Border setResaltarid_tipo_pago__n_mEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarid_tipo_pago__n_mEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_pago__n_mEstructura() {
		return this.resaltarid_tipo_pago__n_mEstructura;
	}

	public void setResaltarid_tipo_pago__n_mEstructura(Border borderResaltar) {
		this.resaltarid_tipo_pago__n_mEstructura= borderResaltar;
	}

	public Boolean getMostrarid_tipo_pago__n_mEstructura() {
		return this.mostrarid_tipo_pago__n_mEstructura;
	}

	public void setMostrarid_tipo_pago__n_mEstructura(Boolean mostrarid_tipo_pago__n_mEstructura) {
		this.mostrarid_tipo_pago__n_mEstructura= mostrarid_tipo_pago__n_mEstructura;
	}

	public Boolean getActivarid_tipo_pago__n_mEstructura() {
		return this.activarid_tipo_pago__n_mEstructura;
	}

	public void setActivarid_tipo_pago__n_mEstructura(Boolean activarid_tipo_pago__n_mEstructura) {
		this.activarid_tipo_pago__n_mEstructura= activarid_tipo_pago__n_mEstructura;
	}

	public Boolean getCargarid_tipo_pago__n_mEstructura() {
		return this.cargarid_tipo_pago__n_mEstructura;
	}

	public void setCargarid_tipo_pago__n_mEstructura(Boolean cargarid_tipo_pago__n_mEstructura) {
		this.cargarid_tipo_pago__n_mEstructura= cargarid_tipo_pago__n_mEstructura;
	}

	public Border setResaltarid_numero_patronalEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarid_numero_patronalEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_numero_patronalEstructura() {
		return this.resaltarid_numero_patronalEstructura;
	}

	public void setResaltarid_numero_patronalEstructura(Border borderResaltar) {
		this.resaltarid_numero_patronalEstructura= borderResaltar;
	}

	public Boolean getMostrarid_numero_patronalEstructura() {
		return this.mostrarid_numero_patronalEstructura;
	}

	public void setMostrarid_numero_patronalEstructura(Boolean mostrarid_numero_patronalEstructura) {
		this.mostrarid_numero_patronalEstructura= mostrarid_numero_patronalEstructura;
	}

	public Boolean getActivarid_numero_patronalEstructura() {
		return this.activarid_numero_patronalEstructura;
	}

	public void setActivarid_numero_patronalEstructura(Boolean activarid_numero_patronalEstructura) {
		this.activarid_numero_patronalEstructura= activarid_numero_patronalEstructura;
	}

	public Boolean getCargarid_numero_patronalEstructura() {
		return this.cargarid_numero_patronalEstructura;
	}

	public void setCargarid_numero_patronalEstructura(Boolean cargarid_numero_patronalEstructura) {
		this.cargarid_numero_patronalEstructura= cargarid_numero_patronalEstructura;
	}

	public Border setResaltarid_cuenta_contableEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableEstructura() {
		return this.resaltarid_cuenta_contableEstructura;
	}

	public void setResaltarid_cuenta_contableEstructura(Border borderResaltar) {
		this.resaltarid_cuenta_contableEstructura= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableEstructura() {
		return this.mostrarid_cuenta_contableEstructura;
	}

	public void setMostrarid_cuenta_contableEstructura(Boolean mostrarid_cuenta_contableEstructura) {
		this.mostrarid_cuenta_contableEstructura= mostrarid_cuenta_contableEstructura;
	}

	public Boolean getActivarid_cuenta_contableEstructura() {
		return this.activarid_cuenta_contableEstructura;
	}

	public void setActivarid_cuenta_contableEstructura(Boolean activarid_cuenta_contableEstructura) {
		this.activarid_cuenta_contableEstructura= activarid_cuenta_contableEstructura;
	}

	public Boolean getCargarid_cuenta_contableEstructura() {
		return this.cargarid_cuenta_contableEstructura;
	}

	public void setCargarid_cuenta_contableEstructura(Boolean cargarid_cuenta_contableEstructura) {
		this.cargarid_cuenta_contableEstructura= cargarid_cuenta_contableEstructura;
	}

	public Border setResaltarid_tipo_estructuraEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarid_tipo_estructuraEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_estructuraEstructura() {
		return this.resaltarid_tipo_estructuraEstructura;
	}

	public void setResaltarid_tipo_estructuraEstructura(Border borderResaltar) {
		this.resaltarid_tipo_estructuraEstructura= borderResaltar;
	}

	public Boolean getMostrarid_tipo_estructuraEstructura() {
		return this.mostrarid_tipo_estructuraEstructura;
	}

	public void setMostrarid_tipo_estructuraEstructura(Boolean mostrarid_tipo_estructuraEstructura) {
		this.mostrarid_tipo_estructuraEstructura= mostrarid_tipo_estructuraEstructura;
	}

	public Boolean getActivarid_tipo_estructuraEstructura() {
		return this.activarid_tipo_estructuraEstructura;
	}

	public void setActivarid_tipo_estructuraEstructura(Boolean activarid_tipo_estructuraEstructura) {
		this.activarid_tipo_estructuraEstructura= activarid_tipo_estructuraEstructura;
	}

	public Boolean getCargarid_tipo_estructuraEstructura() {
		return this.cargarid_tipo_estructuraEstructura;
	}

	public void setCargarid_tipo_estructuraEstructura(Boolean cargarid_tipo_estructuraEstructura) {
		this.cargarid_tipo_estructuraEstructura= cargarid_tipo_estructuraEstructura;
	}

	public Border setResaltarid_paisEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarid_paisEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisEstructura() {
		return this.resaltarid_paisEstructura;
	}

	public void setResaltarid_paisEstructura(Border borderResaltar) {
		this.resaltarid_paisEstructura= borderResaltar;
	}

	public Boolean getMostrarid_paisEstructura() {
		return this.mostrarid_paisEstructura;
	}

	public void setMostrarid_paisEstructura(Boolean mostrarid_paisEstructura) {
		this.mostrarid_paisEstructura= mostrarid_paisEstructura;
	}

	public Boolean getActivarid_paisEstructura() {
		return this.activarid_paisEstructura;
	}

	public void setActivarid_paisEstructura(Boolean activarid_paisEstructura) {
		this.activarid_paisEstructura= activarid_paisEstructura;
	}

	public Boolean getCargarid_paisEstructura() {
		return this.cargarid_paisEstructura;
	}

	public void setCargarid_paisEstructura(Boolean cargarid_paisEstructura) {
		this.cargarid_paisEstructura= cargarid_paisEstructura;
	}

	public Border setResaltarid_ciudadEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarid_ciudadEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadEstructura() {
		return this.resaltarid_ciudadEstructura;
	}

	public void setResaltarid_ciudadEstructura(Border borderResaltar) {
		this.resaltarid_ciudadEstructura= borderResaltar;
	}

	public Boolean getMostrarid_ciudadEstructura() {
		return this.mostrarid_ciudadEstructura;
	}

	public void setMostrarid_ciudadEstructura(Boolean mostrarid_ciudadEstructura) {
		this.mostrarid_ciudadEstructura= mostrarid_ciudadEstructura;
	}

	public Boolean getActivarid_ciudadEstructura() {
		return this.activarid_ciudadEstructura;
	}

	public void setActivarid_ciudadEstructura(Boolean activarid_ciudadEstructura) {
		this.activarid_ciudadEstructura= activarid_ciudadEstructura;
	}

	public Boolean getCargarid_ciudadEstructura() {
		return this.cargarid_ciudadEstructura;
	}

	public void setCargarid_ciudadEstructura(Boolean cargarid_ciudadEstructura) {
		this.cargarid_ciudadEstructura= cargarid_ciudadEstructura;
	}

	public Border setResaltarcodigoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarcodigoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstructura() {
		return this.resaltarcodigoEstructura;
	}

	public void setResaltarcodigoEstructura(Border borderResaltar) {
		this.resaltarcodigoEstructura= borderResaltar;
	}

	public Boolean getMostrarcodigoEstructura() {
		return this.mostrarcodigoEstructura;
	}

	public void setMostrarcodigoEstructura(Boolean mostrarcodigoEstructura) {
		this.mostrarcodigoEstructura= mostrarcodigoEstructura;
	}

	public Boolean getActivarcodigoEstructura() {
		return this.activarcodigoEstructura;
	}

	public void setActivarcodigoEstructura(Boolean activarcodigoEstructura) {
		this.activarcodigoEstructura= activarcodigoEstructura;
	}

	public Border setResaltarnumeroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarnumeroEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroEstructura() {
		return this.resaltarnumeroEstructura;
	}

	public void setResaltarnumeroEstructura(Border borderResaltar) {
		this.resaltarnumeroEstructura= borderResaltar;
	}

	public Boolean getMostrarnumeroEstructura() {
		return this.mostrarnumeroEstructura;
	}

	public void setMostrarnumeroEstructura(Boolean mostrarnumeroEstructura) {
		this.mostrarnumeroEstructura= mostrarnumeroEstructura;
	}

	public Boolean getActivarnumeroEstructura() {
		return this.activarnumeroEstructura;
	}

	public void setActivarnumeroEstructura(Boolean activarnumeroEstructura) {
		this.activarnumeroEstructura= activarnumeroEstructura;
	}

	public Border setResaltarvalor_anticipoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarvalor_anticipoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_anticipoEstructura() {
		return this.resaltarvalor_anticipoEstructura;
	}

	public void setResaltarvalor_anticipoEstructura(Border borderResaltar) {
		this.resaltarvalor_anticipoEstructura= borderResaltar;
	}

	public Boolean getMostrarvalor_anticipoEstructura() {
		return this.mostrarvalor_anticipoEstructura;
	}

	public void setMostrarvalor_anticipoEstructura(Boolean mostrarvalor_anticipoEstructura) {
		this.mostrarvalor_anticipoEstructura= mostrarvalor_anticipoEstructura;
	}

	public Boolean getActivarvalor_anticipoEstructura() {
		return this.activarvalor_anticipoEstructura;
	}

	public void setActivarvalor_anticipoEstructura(Boolean activarvalor_anticipoEstructura) {
		this.activarvalor_anticipoEstructura= activarvalor_anticipoEstructura;
	}

	public Border setResaltarporcentaje_anticipoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarporcentaje_anticipoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_anticipoEstructura() {
		return this.resaltarporcentaje_anticipoEstructura;
	}

	public void setResaltarporcentaje_anticipoEstructura(Border borderResaltar) {
		this.resaltarporcentaje_anticipoEstructura= borderResaltar;
	}

	public Boolean getMostrarporcentaje_anticipoEstructura() {
		return this.mostrarporcentaje_anticipoEstructura;
	}

	public void setMostrarporcentaje_anticipoEstructura(Boolean mostrarporcentaje_anticipoEstructura) {
		this.mostrarporcentaje_anticipoEstructura= mostrarporcentaje_anticipoEstructura;
	}

	public Boolean getActivarporcentaje_anticipoEstructura() {
		return this.activarporcentaje_anticipoEstructura;
	}

	public void setActivarporcentaje_anticipoEstructura(Boolean activarporcentaje_anticipoEstructura) {
		this.activarporcentaje_anticipoEstructura= activarporcentaje_anticipoEstructura;
	}

	public Border setResaltarnombreEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarnombreEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstructura() {
		return this.resaltarnombreEstructura;
	}

	public void setResaltarnombreEstructura(Border borderResaltar) {
		this.resaltarnombreEstructura= borderResaltar;
	}

	public Boolean getMostrarnombreEstructura() {
		return this.mostrarnombreEstructura;
	}

	public void setMostrarnombreEstructura(Boolean mostrarnombreEstructura) {
		this.mostrarnombreEstructura= mostrarnombreEstructura;
	}

	public Boolean getActivarnombreEstructura() {
		return this.activarnombreEstructura;
	}

	public void setActivarnombreEstructura(Boolean activarnombreEstructura) {
		this.activarnombreEstructura= activarnombreEstructura;
	}

	public Border setResaltares_jefeEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltares_jefeEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_jefeEstructura() {
		return this.resaltares_jefeEstructura;
	}

	public void setResaltares_jefeEstructura(Border borderResaltar) {
		this.resaltares_jefeEstructura= borderResaltar;
	}

	public Boolean getMostrares_jefeEstructura() {
		return this.mostrares_jefeEstructura;
	}

	public void setMostrares_jefeEstructura(Boolean mostrares_jefeEstructura) {
		this.mostrares_jefeEstructura= mostrares_jefeEstructura;
	}

	public Boolean getActivares_jefeEstructura() {
		return this.activares_jefeEstructura;
	}

	public void setActivares_jefeEstructura(Boolean activares_jefeEstructura) {
		this.activares_jefeEstructura= activares_jefeEstructura;
	}

	public Border setResaltares_anualEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltares_anualEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_anualEstructura() {
		return this.resaltares_anualEstructura;
	}

	public void setResaltares_anualEstructura(Border borderResaltar) {
		this.resaltares_anualEstructura= borderResaltar;
	}

	public Boolean getMostrares_anualEstructura() {
		return this.mostrares_anualEstructura;
	}

	public void setMostrares_anualEstructura(Boolean mostrares_anualEstructura) {
		this.mostrares_anualEstructura= mostrares_anualEstructura;
	}

	public Boolean getActivares_anualEstructura() {
		return this.activares_anualEstructura;
	}

	public void setActivares_anualEstructura(Boolean activares_anualEstructura) {
		this.activares_anualEstructura= activares_anualEstructura;
	}

	public Border setResaltarporcentajeEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarporcentajeEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeEstructura() {
		return this.resaltarporcentajeEstructura;
	}

	public void setResaltarporcentajeEstructura(Border borderResaltar) {
		this.resaltarporcentajeEstructura= borderResaltar;
	}

	public Boolean getMostrarporcentajeEstructura() {
		return this.mostrarporcentajeEstructura;
	}

	public void setMostrarporcentajeEstructura(Boolean mostrarporcentajeEstructura) {
		this.mostrarporcentajeEstructura= mostrarporcentajeEstructura;
	}

	public Boolean getActivarporcentajeEstructura() {
		return this.activarporcentajeEstructura;
	}

	public void setActivarporcentajeEstructura(Boolean activarporcentajeEstructura) {
		this.activarporcentajeEstructura= activarporcentajeEstructura;
	}

	public Border setResaltarvalorEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltar);
		
		this.resaltarvalorEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorEstructura() {
		return this.resaltarvalorEstructura;
	}

	public void setResaltarvalorEstructura(Border borderResaltar) {
		this.resaltarvalorEstructura= borderResaltar;
	}

	public Boolean getMostrarvalorEstructura() {
		return this.mostrarvalorEstructura;
	}

	public void setMostrarvalorEstructura(Boolean mostrarvalorEstructura) {
		this.mostrarvalorEstructura= mostrarvalorEstructura;
	}

	public Boolean getActivarvalorEstructura() {
		return this.activarvalorEstructura;
	}

	public void setActivarvalorEstructura(Boolean activarvalorEstructura) {
		this.activarvalorEstructura= activarvalorEstructura;
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
		
		
		this.setMostraridEstructura(esInicial);
		this.setMostrarid_empresaEstructura(esInicial);
		this.setMostrarid_sucursalEstructura(esInicial);
		this.setMostrarid_estructuraEstructura(esInicial);
		this.setMostrarid_tipo_pago__n_mEstructura(esInicial);
		this.setMostrarid_numero_patronalEstructura(esInicial);
		this.setMostrarid_cuenta_contableEstructura(esInicial);
		this.setMostrarid_tipo_estructuraEstructura(esInicial);
		this.setMostrarid_paisEstructura(esInicial);
		this.setMostrarid_ciudadEstructura(esInicial);
		this.setMostrarcodigoEstructura(esInicial);
		this.setMostrarnumeroEstructura(esInicial);
		this.setMostrarvalor_anticipoEstructura(esInicial);
		this.setMostrarporcentaje_anticipoEstructura(esInicial);
		this.setMostrarnombreEstructura(esInicial);
		this.setMostrares_jefeEstructura(esInicial);
		this.setMostrares_anualEstructura(esInicial);
		this.setMostrarporcentajeEstructura(esInicial);
		this.setMostrarvalorEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstructuraConstantesFunciones.ID)) {
				this.setMostraridEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDTIPOPAGO_NM)) {
				this.setMostrarid_tipo_pago__n_mEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setMostrarid_numero_patronalEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDTIPOESTRUCTURA)) {
				this.setMostrarid_tipo_estructuraEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.VALORANTICIPO)) {
				this.setMostrarvalor_anticipoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.PORCENTAJEANTICIPO)) {
				this.setMostrarporcentaje_anticipoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.ESJEFE)) {
				this.setMostrares_jefeEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.ESANUAL)) {
				this.setMostrares_anualEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.VALOR)) {
				this.setMostrarvalorEstructura(esAsigna);
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
		
		
		this.setActivaridEstructura(esInicial);
		this.setActivarid_empresaEstructura(esInicial);
		this.setActivarid_sucursalEstructura(esInicial);
		this.setActivarid_estructuraEstructura(esInicial);
		this.setActivarid_tipo_pago__n_mEstructura(esInicial);
		this.setActivarid_numero_patronalEstructura(esInicial);
		this.setActivarid_cuenta_contableEstructura(esInicial);
		this.setActivarid_tipo_estructuraEstructura(esInicial);
		this.setActivarid_paisEstructura(esInicial);
		this.setActivarid_ciudadEstructura(esInicial);
		this.setActivarcodigoEstructura(esInicial);
		this.setActivarnumeroEstructura(esInicial);
		this.setActivarvalor_anticipoEstructura(esInicial);
		this.setActivarporcentaje_anticipoEstructura(esInicial);
		this.setActivarnombreEstructura(esInicial);
		this.setActivares_jefeEstructura(esInicial);
		this.setActivares_anualEstructura(esInicial);
		this.setActivarporcentajeEstructura(esInicial);
		this.setActivarvalorEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstructuraConstantesFunciones.ID)) {
				this.setActivaridEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDTIPOPAGO_NM)) {
				this.setActivarid_tipo_pago__n_mEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setActivarid_numero_patronalEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDTIPOESTRUCTURA)) {
				this.setActivarid_tipo_estructuraEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.NUMERO)) {
				this.setActivarnumeroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.VALORANTICIPO)) {
				this.setActivarvalor_anticipoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.PORCENTAJEANTICIPO)) {
				this.setActivarporcentaje_anticipoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.ESJEFE)) {
				this.setActivares_jefeEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.ESANUAL)) {
				this.setActivares_anualEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.VALOR)) {
				this.setActivarvalorEstructura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstructura(esInicial);
		this.setResaltarid_empresaEstructura(esInicial);
		this.setResaltarid_sucursalEstructura(esInicial);
		this.setResaltarid_estructuraEstructura(esInicial);
		this.setResaltarid_tipo_pago__n_mEstructura(esInicial);
		this.setResaltarid_numero_patronalEstructura(esInicial);
		this.setResaltarid_cuenta_contableEstructura(esInicial);
		this.setResaltarid_tipo_estructuraEstructura(esInicial);
		this.setResaltarid_paisEstructura(esInicial);
		this.setResaltarid_ciudadEstructura(esInicial);
		this.setResaltarcodigoEstructura(esInicial);
		this.setResaltarnumeroEstructura(esInicial);
		this.setResaltarvalor_anticipoEstructura(esInicial);
		this.setResaltarporcentaje_anticipoEstructura(esInicial);
		this.setResaltarnombreEstructura(esInicial);
		this.setResaltares_jefeEstructura(esInicial);
		this.setResaltares_anualEstructura(esInicial);
		this.setResaltarporcentajeEstructura(esInicial);
		this.setResaltarvalorEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstructuraConstantesFunciones.ID)) {
				this.setResaltaridEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDTIPOPAGO_NM)) {
				this.setResaltarid_tipo_pago__n_mEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setResaltarid_numero_patronalEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDTIPOESTRUCTURA)) {
				this.setResaltarid_tipo_estructuraEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.VALORANTICIPO)) {
				this.setResaltarvalor_anticipoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.PORCENTAJEANTICIPO)) {
				this.setResaltarporcentaje_anticipoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.ESJEFE)) {
				this.setResaltares_jefeEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.ESANUAL)) {
				this.setResaltares_anualEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstructuraConstantesFunciones.VALOR)) {
				this.setResaltarvalorEstructura(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCentroCostoEstructuraEstructura=null;

	public Border getResaltarCentroCostoEstructuraEstructura() {
		return this.resaltarCentroCostoEstructuraEstructura;
	}

	public void setResaltarCentroCostoEstructuraEstructura(Border borderResaltarCentroCostoEstructura) {
		if(borderResaltarCentroCostoEstructura!=null) {
			this.resaltarCentroCostoEstructuraEstructura= borderResaltarCentroCostoEstructura;
		}
	}

	public Border setResaltarCentroCostoEstructuraEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarCentroCostoEstructura=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarCentroCostoEstructura);
			
		this.resaltarCentroCostoEstructuraEstructura= borderResaltarCentroCostoEstructura;

		 return borderResaltarCentroCostoEstructura;
	}



	public Boolean mostrarCentroCostoEstructuraEstructura=true;

	public Boolean getMostrarCentroCostoEstructuraEstructura() {
		return this.mostrarCentroCostoEstructuraEstructura;
	}

	public void setMostrarCentroCostoEstructuraEstructura(Boolean visibilidadResaltarCentroCostoEstructura) {
		this.mostrarCentroCostoEstructuraEstructura= visibilidadResaltarCentroCostoEstructura;
	}



	public Boolean activarCentroCostoEstructuraEstructura=true;

	public Boolean gethabilitarResaltarCentroCostoEstructuraEstructura() {
		return this.activarCentroCostoEstructuraEstructura;
	}

	public void setActivarCentroCostoEstructuraEstructura(Boolean habilitarResaltarCentroCostoEstructura) {
		this.activarCentroCostoEstructuraEstructura= habilitarResaltarCentroCostoEstructura;
	}


	public Border resaltarPlaniVacacionEstructura=null;

	public Border getResaltarPlaniVacacionEstructura() {
		return this.resaltarPlaniVacacionEstructura;
	}

	public void setResaltarPlaniVacacionEstructura(Border borderResaltarPlaniVacacion) {
		if(borderResaltarPlaniVacacion!=null) {
			this.resaltarPlaniVacacionEstructura= borderResaltarPlaniVacacion;
		}
	}

	public Border setResaltarPlaniVacacionEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarPlaniVacacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarPlaniVacacion);
			
		this.resaltarPlaniVacacionEstructura= borderResaltarPlaniVacacion;

		 return borderResaltarPlaniVacacion;
	}



	public Boolean mostrarPlaniVacacionEstructura=true;

	public Boolean getMostrarPlaniVacacionEstructura() {
		return this.mostrarPlaniVacacionEstructura;
	}

	public void setMostrarPlaniVacacionEstructura(Boolean visibilidadResaltarPlaniVacacion) {
		this.mostrarPlaniVacacionEstructura= visibilidadResaltarPlaniVacacion;
	}



	public Boolean activarPlaniVacacionEstructura=true;

	public Boolean gethabilitarResaltarPlaniVacacionEstructura() {
		return this.activarPlaniVacacionEstructura;
	}

	public void setActivarPlaniVacacionEstructura(Boolean habilitarResaltarPlaniVacacion) {
		this.activarPlaniVacacionEstructura= habilitarResaltarPlaniVacacion;
	}


	public Border resaltarAsistenciaMensualEstructura=null;

	public Border getResaltarAsistenciaMensualEstructura() {
		return this.resaltarAsistenciaMensualEstructura;
	}

	public void setResaltarAsistenciaMensualEstructura(Border borderResaltarAsistenciaMensual) {
		if(borderResaltarAsistenciaMensual!=null) {
			this.resaltarAsistenciaMensualEstructura= borderResaltarAsistenciaMensual;
		}
	}

	public Border setResaltarAsistenciaMensualEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarAsistenciaMensual=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarAsistenciaMensual);
			
		this.resaltarAsistenciaMensualEstructura= borderResaltarAsistenciaMensual;

		 return borderResaltarAsistenciaMensual;
	}



	public Boolean mostrarAsistenciaMensualEstructura=true;

	public Boolean getMostrarAsistenciaMensualEstructura() {
		return this.mostrarAsistenciaMensualEstructura;
	}

	public void setMostrarAsistenciaMensualEstructura(Boolean visibilidadResaltarAsistenciaMensual) {
		this.mostrarAsistenciaMensualEstructura= visibilidadResaltarAsistenciaMensual;
	}



	public Boolean activarAsistenciaMensualEstructura=true;

	public Boolean gethabilitarResaltarAsistenciaMensualEstructura() {
		return this.activarAsistenciaMensualEstructura;
	}

	public void setActivarAsistenciaMensualEstructura(Boolean habilitarResaltarAsistenciaMensual) {
		this.activarAsistenciaMensualEstructura= habilitarResaltarAsistenciaMensual;
	}


	public Border resaltarEmpleadoProcesoRubroEstructura=null;

	public Border getResaltarEmpleadoProcesoRubroEstructura() {
		return this.resaltarEmpleadoProcesoRubroEstructura;
	}

	public void setResaltarEmpleadoProcesoRubroEstructura(Border borderResaltarEmpleadoProcesoRubro) {
		if(borderResaltarEmpleadoProcesoRubro!=null) {
			this.resaltarEmpleadoProcesoRubroEstructura= borderResaltarEmpleadoProcesoRubro;
		}
	}

	public Border setResaltarEmpleadoProcesoRubroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoProcesoRubro=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarEmpleadoProcesoRubro);
			
		this.resaltarEmpleadoProcesoRubroEstructura= borderResaltarEmpleadoProcesoRubro;

		 return borderResaltarEmpleadoProcesoRubro;
	}



	public Boolean mostrarEmpleadoProcesoRubroEstructura=true;

	public Boolean getMostrarEmpleadoProcesoRubroEstructura() {
		return this.mostrarEmpleadoProcesoRubroEstructura;
	}

	public void setMostrarEmpleadoProcesoRubroEstructura(Boolean visibilidadResaltarEmpleadoProcesoRubro) {
		this.mostrarEmpleadoProcesoRubroEstructura= visibilidadResaltarEmpleadoProcesoRubro;
	}



	public Boolean activarEmpleadoProcesoRubroEstructura=true;

	public Boolean gethabilitarResaltarEmpleadoProcesoRubroEstructura() {
		return this.activarEmpleadoProcesoRubroEstructura;
	}

	public void setActivarEmpleadoProcesoRubroEstructura(Boolean habilitarResaltarEmpleadoProcesoRubro) {
		this.activarEmpleadoProcesoRubroEstructura= habilitarResaltarEmpleadoProcesoRubro;
	}


	public Border resaltarEmpleadoPagoRubroEstructura=null;

	public Border getResaltarEmpleadoPagoRubroEstructura() {
		return this.resaltarEmpleadoPagoRubroEstructura;
	}

	public void setResaltarEmpleadoPagoRubroEstructura(Border borderResaltarEmpleadoPagoRubro) {
		if(borderResaltarEmpleadoPagoRubro!=null) {
			this.resaltarEmpleadoPagoRubroEstructura= borderResaltarEmpleadoPagoRubro;
		}
	}

	public Border setResaltarEmpleadoPagoRubroEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoPagoRubro=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarEmpleadoPagoRubro);
			
		this.resaltarEmpleadoPagoRubroEstructura= borderResaltarEmpleadoPagoRubro;

		 return borderResaltarEmpleadoPagoRubro;
	}



	public Boolean mostrarEmpleadoPagoRubroEstructura=true;

	public Boolean getMostrarEmpleadoPagoRubroEstructura() {
		return this.mostrarEmpleadoPagoRubroEstructura;
	}

	public void setMostrarEmpleadoPagoRubroEstructura(Boolean visibilidadResaltarEmpleadoPagoRubro) {
		this.mostrarEmpleadoPagoRubroEstructura= visibilidadResaltarEmpleadoPagoRubro;
	}



	public Boolean activarEmpleadoPagoRubroEstructura=true;

	public Boolean gethabilitarResaltarEmpleadoPagoRubroEstructura() {
		return this.activarEmpleadoPagoRubroEstructura;
	}

	public void setActivarEmpleadoPagoRubroEstructura(Boolean habilitarResaltarEmpleadoPagoRubro) {
		this.activarEmpleadoPagoRubroEstructura= habilitarResaltarEmpleadoPagoRubro;
	}


	public Border resaltarProvisionEmpleadoEstructura=null;

	public Border getResaltarProvisionEmpleadoEstructura() {
		return this.resaltarProvisionEmpleadoEstructura;
	}

	public void setResaltarProvisionEmpleadoEstructura(Border borderResaltarProvisionEmpleado) {
		if(borderResaltarProvisionEmpleado!=null) {
			this.resaltarProvisionEmpleadoEstructura= borderResaltarProvisionEmpleado;
		}
	}

	public Border setResaltarProvisionEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarProvisionEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarProvisionEmpleado);
			
		this.resaltarProvisionEmpleadoEstructura= borderResaltarProvisionEmpleado;

		 return borderResaltarProvisionEmpleado;
	}



	public Boolean mostrarProvisionEmpleadoEstructura=true;

	public Boolean getMostrarProvisionEmpleadoEstructura() {
		return this.mostrarProvisionEmpleadoEstructura;
	}

	public void setMostrarProvisionEmpleadoEstructura(Boolean visibilidadResaltarProvisionEmpleado) {
		this.mostrarProvisionEmpleadoEstructura= visibilidadResaltarProvisionEmpleado;
	}



	public Boolean activarProvisionEmpleadoEstructura=true;

	public Boolean gethabilitarResaltarProvisionEmpleadoEstructura() {
		return this.activarProvisionEmpleadoEstructura;
	}

	public void setActivarProvisionEmpleadoEstructura(Boolean habilitarResaltarProvisionEmpleado) {
		this.activarProvisionEmpleadoEstructura= habilitarResaltarProvisionEmpleado;
	}


	public Border resaltarEmpleadoEstructura=null;

	public Border getResaltarEmpleadoEstructura() {
		return this.resaltarEmpleadoEstructura;
	}

	public void setResaltarEmpleadoEstructura(Border borderResaltarEmpleado) {
		if(borderResaltarEmpleado!=null) {
			this.resaltarEmpleadoEstructura= borderResaltarEmpleado;
		}
	}

	public Border setResaltarEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarEmpleado);
			
		this.resaltarEmpleadoEstructura= borderResaltarEmpleado;

		 return borderResaltarEmpleado;
	}



	public Boolean mostrarEmpleadoEstructura=true;

	public Boolean getMostrarEmpleadoEstructura() {
		return this.mostrarEmpleadoEstructura;
	}

	public void setMostrarEmpleadoEstructura(Boolean visibilidadResaltarEmpleado) {
		this.mostrarEmpleadoEstructura= visibilidadResaltarEmpleado;
	}



	public Boolean activarEmpleadoEstructura=true;

	public Boolean gethabilitarResaltarEmpleadoEstructura() {
		return this.activarEmpleadoEstructura;
	}

	public void setActivarEmpleadoEstructura(Boolean habilitarResaltarEmpleado) {
		this.activarEmpleadoEstructura= habilitarResaltarEmpleado;
	}


	public Border resaltarEstructuraEstructura=null;

	public Border getResaltarEstructuraEstructura() {
		return this.resaltarEstructuraEstructura;
	}

	public void setResaltarEstructuraEstructura(Border borderResaltarEstructura) {
		if(borderResaltarEstructura!=null) {
			this.resaltarEstructuraEstructura= borderResaltarEstructura;
		}
	}

	public Border setResaltarEstructuraEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarEstructura=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarEstructura);
			
		this.resaltarEstructuraEstructura= borderResaltarEstructura;

		 return borderResaltarEstructura;
	}



	public Boolean mostrarEstructuraEstructura=true;

	public Boolean getMostrarEstructuraEstructura() {
		return this.mostrarEstructuraEstructura;
	}

	public void setMostrarEstructuraEstructura(Boolean visibilidadResaltarEstructura) {
		this.mostrarEstructuraEstructura= visibilidadResaltarEstructura;
	}



	public Boolean activarEstructuraEstructura=true;

	public Boolean gethabilitarResaltarEstructuraEstructura() {
		return this.activarEstructuraEstructura;
	}

	public void setActivarEstructuraEstructura(Boolean habilitarResaltarEstructura) {
		this.activarEstructuraEstructura= habilitarResaltarEstructura;
	}


	public Border resaltarEvaluacionEmpleadoEstructura=null;

	public Border getResaltarEvaluacionEmpleadoEstructura() {
		return this.resaltarEvaluacionEmpleadoEstructura;
	}

	public void setResaltarEvaluacionEmpleadoEstructura(Border borderResaltarEvaluacionEmpleado) {
		if(borderResaltarEvaluacionEmpleado!=null) {
			this.resaltarEvaluacionEmpleadoEstructura= borderResaltarEvaluacionEmpleado;
		}
	}

	public Border setResaltarEvaluacionEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarEvaluacionEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarEvaluacionEmpleado);
			
		this.resaltarEvaluacionEmpleadoEstructura= borderResaltarEvaluacionEmpleado;

		 return borderResaltarEvaluacionEmpleado;
	}



	public Boolean mostrarEvaluacionEmpleadoEstructura=true;

	public Boolean getMostrarEvaluacionEmpleadoEstructura() {
		return this.mostrarEvaluacionEmpleadoEstructura;
	}

	public void setMostrarEvaluacionEmpleadoEstructura(Boolean visibilidadResaltarEvaluacionEmpleado) {
		this.mostrarEvaluacionEmpleadoEstructura= visibilidadResaltarEvaluacionEmpleado;
	}



	public Boolean activarEvaluacionEmpleadoEstructura=true;

	public Boolean gethabilitarResaltarEvaluacionEmpleadoEstructura() {
		return this.activarEvaluacionEmpleadoEstructura;
	}

	public void setActivarEvaluacionEmpleadoEstructura(Boolean habilitarResaltarEvaluacionEmpleado) {
		this.activarEvaluacionEmpleadoEstructura= habilitarResaltarEvaluacionEmpleado;
	}


	public Border resaltarEmpleadoImpuestoRentaEstructura=null;

	public Border getResaltarEmpleadoImpuestoRentaEstructura() {
		return this.resaltarEmpleadoImpuestoRentaEstructura;
	}

	public void setResaltarEmpleadoImpuestoRentaEstructura(Border borderResaltarEmpleadoImpuestoRenta) {
		if(borderResaltarEmpleadoImpuestoRenta!=null) {
			this.resaltarEmpleadoImpuestoRentaEstructura= borderResaltarEmpleadoImpuestoRenta;
		}
	}

	public Border setResaltarEmpleadoImpuestoRentaEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoImpuestoRenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarEmpleadoImpuestoRenta);
			
		this.resaltarEmpleadoImpuestoRentaEstructura= borderResaltarEmpleadoImpuestoRenta;

		 return borderResaltarEmpleadoImpuestoRenta;
	}



	public Boolean mostrarEmpleadoImpuestoRentaEstructura=true;

	public Boolean getMostrarEmpleadoImpuestoRentaEstructura() {
		return this.mostrarEmpleadoImpuestoRentaEstructura;
	}

	public void setMostrarEmpleadoImpuestoRentaEstructura(Boolean visibilidadResaltarEmpleadoImpuestoRenta) {
		this.mostrarEmpleadoImpuestoRentaEstructura= visibilidadResaltarEmpleadoImpuestoRenta;
	}



	public Boolean activarEmpleadoImpuestoRentaEstructura=true;

	public Boolean gethabilitarResaltarEmpleadoImpuestoRentaEstructura() {
		return this.activarEmpleadoImpuestoRentaEstructura;
	}

	public void setActivarEmpleadoImpuestoRentaEstructura(Boolean habilitarResaltarEmpleadoImpuestoRenta) {
		this.activarEmpleadoImpuestoRentaEstructura= habilitarResaltarEmpleadoImpuestoRenta;
	}


	public Border resaltarRubroEstructuraEstructura=null;

	public Border getResaltarRubroEstructuraEstructura() {
		return this.resaltarRubroEstructuraEstructura;
	}

	public void setResaltarRubroEstructuraEstructura(Border borderResaltarRubroEstructura) {
		if(borderResaltarRubroEstructura!=null) {
			this.resaltarRubroEstructuraEstructura= borderResaltarRubroEstructura;
		}
	}

	public Border setResaltarRubroEstructuraEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarRubroEstructura=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarRubroEstructura);
			
		this.resaltarRubroEstructuraEstructura= borderResaltarRubroEstructura;

		 return borderResaltarRubroEstructura;
	}



	public Boolean mostrarRubroEstructuraEstructura=true;

	public Boolean getMostrarRubroEstructuraEstructura() {
		return this.mostrarRubroEstructuraEstructura;
	}

	public void setMostrarRubroEstructuraEstructura(Boolean visibilidadResaltarRubroEstructura) {
		this.mostrarRubroEstructuraEstructura= visibilidadResaltarRubroEstructura;
	}



	public Boolean activarRubroEstructuraEstructura=true;

	public Boolean gethabilitarResaltarRubroEstructuraEstructura() {
		return this.activarRubroEstructuraEstructura;
	}

	public void setActivarRubroEstructuraEstructura(Boolean habilitarResaltarRubroEstructura) {
		this.activarRubroEstructuraEstructura= habilitarResaltarRubroEstructura;
	}


	public Border resaltarCierreRolMensualEstructura=null;

	public Border getResaltarCierreRolMensualEstructura() {
		return this.resaltarCierreRolMensualEstructura;
	}

	public void setResaltarCierreRolMensualEstructura(Border borderResaltarCierreRolMensual) {
		if(borderResaltarCierreRolMensual!=null) {
			this.resaltarCierreRolMensualEstructura= borderResaltarCierreRolMensual;
		}
	}

	public Border setResaltarCierreRolMensualEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarCierreRolMensual=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarCierreRolMensual);
			
		this.resaltarCierreRolMensualEstructura= borderResaltarCierreRolMensual;

		 return borderResaltarCierreRolMensual;
	}



	public Boolean mostrarCierreRolMensualEstructura=true;

	public Boolean getMostrarCierreRolMensualEstructura() {
		return this.mostrarCierreRolMensualEstructura;
	}

	public void setMostrarCierreRolMensualEstructura(Boolean visibilidadResaltarCierreRolMensual) {
		this.mostrarCierreRolMensualEstructura= visibilidadResaltarCierreRolMensual;
	}



	public Boolean activarCierreRolMensualEstructura=true;

	public Boolean gethabilitarResaltarCierreRolMensualEstructura() {
		return this.activarCierreRolMensualEstructura;
	}

	public void setActivarCierreRolMensualEstructura(Boolean habilitarResaltarCierreRolMensual) {
		this.activarCierreRolMensualEstructura= habilitarResaltarCierreRolMensual;
	}


	public Border resaltarFormatoNomiEstructura=null;

	public Border getResaltarFormatoNomiEstructura() {
		return this.resaltarFormatoNomiEstructura;
	}

	public void setResaltarFormatoNomiEstructura(Border borderResaltarFormatoNomi) {
		if(borderResaltarFormatoNomi!=null) {
			this.resaltarFormatoNomiEstructura= borderResaltarFormatoNomi;
		}
	}

	public Border setResaltarFormatoNomiEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarFormatoNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarFormatoNomi);
			
		this.resaltarFormatoNomiEstructura= borderResaltarFormatoNomi;

		 return borderResaltarFormatoNomi;
	}



	public Boolean mostrarFormatoNomiEstructura=true;

	public Boolean getMostrarFormatoNomiEstructura() {
		return this.mostrarFormatoNomiEstructura;
	}

	public void setMostrarFormatoNomiEstructura(Boolean visibilidadResaltarFormatoNomi) {
		this.mostrarFormatoNomiEstructura= visibilidadResaltarFormatoNomi;
	}



	public Boolean activarFormatoNomiEstructura=true;

	public Boolean gethabilitarResaltarFormatoNomiEstructura() {
		return this.activarFormatoNomiEstructura;
	}

	public void setActivarFormatoNomiEstructura(Boolean habilitarResaltarFormatoNomi) {
		this.activarFormatoNomiEstructura= habilitarResaltarFormatoNomi;
	}


	public Border resaltarEmpleadoEstructuraEstructura=null;

	public Border getResaltarEmpleadoEstructuraEstructura() {
		return this.resaltarEmpleadoEstructuraEstructura;
	}

	public void setResaltarEmpleadoEstructuraEstructura(Border borderResaltarEmpleadoEstructura) {
		if(borderResaltarEmpleadoEstructura!=null) {
			this.resaltarEmpleadoEstructuraEstructura= borderResaltarEmpleadoEstructura;
		}
	}

	public Border setResaltarEmpleadoEstructuraEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoEstructura=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarEmpleadoEstructura);
			
		this.resaltarEmpleadoEstructuraEstructura= borderResaltarEmpleadoEstructura;

		 return borderResaltarEmpleadoEstructura;
	}



	public Boolean mostrarEmpleadoEstructuraEstructura=true;

	public Boolean getMostrarEmpleadoEstructuraEstructura() {
		return this.mostrarEmpleadoEstructuraEstructura;
	}

	public void setMostrarEmpleadoEstructuraEstructura(Boolean visibilidadResaltarEmpleadoEstructura) {
		this.mostrarEmpleadoEstructuraEstructura= visibilidadResaltarEmpleadoEstructura;
	}



	public Boolean activarEmpleadoEstructuraEstructura=true;

	public Boolean gethabilitarResaltarEmpleadoEstructuraEstructura() {
		return this.activarEmpleadoEstructuraEstructura;
	}

	public void setActivarEmpleadoEstructuraEstructura(Boolean habilitarResaltarEmpleadoEstructura) {
		this.activarEmpleadoEstructuraEstructura= habilitarResaltarEmpleadoEstructura;
	}


	public Border resaltarHistorialPagoNomiEstructura=null;

	public Border getResaltarHistorialPagoNomiEstructura() {
		return this.resaltarHistorialPagoNomiEstructura;
	}

	public void setResaltarHistorialPagoNomiEstructura(Border borderResaltarHistorialPagoNomi) {
		if(borderResaltarHistorialPagoNomi!=null) {
			this.resaltarHistorialPagoNomiEstructura= borderResaltarHistorialPagoNomi;
		}
	}

	public Border setResaltarHistorialPagoNomiEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarHistorialPagoNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarHistorialPagoNomi);
			
		this.resaltarHistorialPagoNomiEstructura= borderResaltarHistorialPagoNomi;

		 return borderResaltarHistorialPagoNomi;
	}



	public Boolean mostrarHistorialPagoNomiEstructura=true;

	public Boolean getMostrarHistorialPagoNomiEstructura() {
		return this.mostrarHistorialPagoNomiEstructura;
	}

	public void setMostrarHistorialPagoNomiEstructura(Boolean visibilidadResaltarHistorialPagoNomi) {
		this.mostrarHistorialPagoNomiEstructura= visibilidadResaltarHistorialPagoNomi;
	}



	public Boolean activarHistorialPagoNomiEstructura=true;

	public Boolean gethabilitarResaltarHistorialPagoNomiEstructura() {
		return this.activarHistorialPagoNomiEstructura;
	}

	public void setActivarHistorialPagoNomiEstructura(Boolean habilitarResaltarHistorialPagoNomi) {
		this.activarHistorialPagoNomiEstructura= habilitarResaltarHistorialPagoNomi;
	}


	public Border resaltarAsistenciaDiariaEstructura=null;

	public Border getResaltarAsistenciaDiariaEstructura() {
		return this.resaltarAsistenciaDiariaEstructura;
	}

	public void setResaltarAsistenciaDiariaEstructura(Border borderResaltarAsistenciaDiaria) {
		if(borderResaltarAsistenciaDiaria!=null) {
			this.resaltarAsistenciaDiariaEstructura= borderResaltarAsistenciaDiaria;
		}
	}

	public Border setResaltarAsistenciaDiariaEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarAsistenciaDiaria=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarAsistenciaDiaria);
			
		this.resaltarAsistenciaDiariaEstructura= borderResaltarAsistenciaDiaria;

		 return borderResaltarAsistenciaDiaria;
	}



	public Boolean mostrarAsistenciaDiariaEstructura=true;

	public Boolean getMostrarAsistenciaDiariaEstructura() {
		return this.mostrarAsistenciaDiariaEstructura;
	}

	public void setMostrarAsistenciaDiariaEstructura(Boolean visibilidadResaltarAsistenciaDiaria) {
		this.mostrarAsistenciaDiariaEstructura= visibilidadResaltarAsistenciaDiaria;
	}



	public Boolean activarAsistenciaDiariaEstructura=true;

	public Boolean gethabilitarResaltarAsistenciaDiariaEstructura() {
		return this.activarAsistenciaDiariaEstructura;
	}

	public void setActivarAsistenciaDiariaEstructura(Boolean habilitarResaltarAsistenciaDiaria) {
		this.activarAsistenciaDiariaEstructura= habilitarResaltarAsistenciaDiaria;
	}


	public Border resaltarFuncionEstrucEstructura=null;

	public Border getResaltarFuncionEstrucEstructura() {
		return this.resaltarFuncionEstrucEstructura;
	}

	public void setResaltarFuncionEstrucEstructura(Border borderResaltarFuncionEstruc) {
		if(borderResaltarFuncionEstruc!=null) {
			this.resaltarFuncionEstrucEstructura= borderResaltarFuncionEstruc;
		}
	}

	public Border setResaltarFuncionEstrucEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarFuncionEstruc=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarFuncionEstruc);
			
		this.resaltarFuncionEstrucEstructura= borderResaltarFuncionEstruc;

		 return borderResaltarFuncionEstruc;
	}



	public Boolean mostrarFuncionEstrucEstructura=true;

	public Boolean getMostrarFuncionEstrucEstructura() {
		return this.mostrarFuncionEstrucEstructura;
	}

	public void setMostrarFuncionEstrucEstructura(Boolean visibilidadResaltarFuncionEstruc) {
		this.mostrarFuncionEstrucEstructura= visibilidadResaltarFuncionEstruc;
	}



	public Boolean activarFuncionEstrucEstructura=true;

	public Boolean gethabilitarResaltarFuncionEstrucEstructura() {
		return this.activarFuncionEstrucEstructura;
	}

	public void setActivarFuncionEstrucEstructura(Boolean habilitarResaltarFuncionEstruc) {
		this.activarFuncionEstrucEstructura= habilitarResaltarFuncionEstruc;
	}


	public Border resaltarSolicitudReemplazoEstructura=null;

	public Border getResaltarSolicitudReemplazoEstructura() {
		return this.resaltarSolicitudReemplazoEstructura;
	}

	public void setResaltarSolicitudReemplazoEstructura(Border borderResaltarSolicitudReemplazo) {
		if(borderResaltarSolicitudReemplazo!=null) {
			this.resaltarSolicitudReemplazoEstructura= borderResaltarSolicitudReemplazo;
		}
	}

	public Border setResaltarSolicitudReemplazoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarSolicitudReemplazo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarSolicitudReemplazo);
			
		this.resaltarSolicitudReemplazoEstructura= borderResaltarSolicitudReemplazo;

		 return borderResaltarSolicitudReemplazo;
	}



	public Boolean mostrarSolicitudReemplazoEstructura=true;

	public Boolean getMostrarSolicitudReemplazoEstructura() {
		return this.mostrarSolicitudReemplazoEstructura;
	}

	public void setMostrarSolicitudReemplazoEstructura(Boolean visibilidadResaltarSolicitudReemplazo) {
		this.mostrarSolicitudReemplazoEstructura= visibilidadResaltarSolicitudReemplazo;
	}



	public Boolean activarSolicitudReemplazoEstructura=true;

	public Boolean gethabilitarResaltarSolicitudReemplazoEstructura() {
		return this.activarSolicitudReemplazoEstructura;
	}

	public void setActivarSolicitudReemplazoEstructura(Boolean habilitarResaltarSolicitudReemplazo) {
		this.activarSolicitudReemplazoEstructura= habilitarResaltarSolicitudReemplazo;
	}


	public Border resaltarSolicitudHoraExtraEstructura=null;

	public Border getResaltarSolicitudHoraExtraEstructura() {
		return this.resaltarSolicitudHoraExtraEstructura;
	}

	public void setResaltarSolicitudHoraExtraEstructura(Border borderResaltarSolicitudHoraExtra) {
		if(borderResaltarSolicitudHoraExtra!=null) {
			this.resaltarSolicitudHoraExtraEstructura= borderResaltarSolicitudHoraExtra;
		}
	}

	public Border setResaltarSolicitudHoraExtraEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarSolicitudHoraExtra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarSolicitudHoraExtra);
			
		this.resaltarSolicitudHoraExtraEstructura= borderResaltarSolicitudHoraExtra;

		 return borderResaltarSolicitudHoraExtra;
	}



	public Boolean mostrarSolicitudHoraExtraEstructura=true;

	public Boolean getMostrarSolicitudHoraExtraEstructura() {
		return this.mostrarSolicitudHoraExtraEstructura;
	}

	public void setMostrarSolicitudHoraExtraEstructura(Boolean visibilidadResaltarSolicitudHoraExtra) {
		this.mostrarSolicitudHoraExtraEstructura= visibilidadResaltarSolicitudHoraExtra;
	}



	public Boolean activarSolicitudHoraExtraEstructura=true;

	public Boolean gethabilitarResaltarSolicitudHoraExtraEstructura() {
		return this.activarSolicitudHoraExtraEstructura;
	}

	public void setActivarSolicitudHoraExtraEstructura(Boolean habilitarResaltarSolicitudHoraExtra) {
		this.activarSolicitudHoraExtraEstructura= habilitarResaltarSolicitudHoraExtra;
	}


	public Border resaltarEvaluacionNomiEstructura=null;

	public Border getResaltarEvaluacionNomiEstructura() {
		return this.resaltarEvaluacionNomiEstructura;
	}

	public void setResaltarEvaluacionNomiEstructura(Border borderResaltarEvaluacionNomi) {
		if(borderResaltarEvaluacionNomi!=null) {
			this.resaltarEvaluacionNomiEstructura= borderResaltarEvaluacionNomi;
		}
	}

	public Border setResaltarEvaluacionNomiEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarEvaluacionNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarEvaluacionNomi);
			
		this.resaltarEvaluacionNomiEstructura= borderResaltarEvaluacionNomi;

		 return borderResaltarEvaluacionNomi;
	}



	public Boolean mostrarEvaluacionNomiEstructura=true;

	public Boolean getMostrarEvaluacionNomiEstructura() {
		return this.mostrarEvaluacionNomiEstructura;
	}

	public void setMostrarEvaluacionNomiEstructura(Boolean visibilidadResaltarEvaluacionNomi) {
		this.mostrarEvaluacionNomiEstructura= visibilidadResaltarEvaluacionNomi;
	}



	public Boolean activarEvaluacionNomiEstructura=true;

	public Boolean gethabilitarResaltarEvaluacionNomiEstructura() {
		return this.activarEvaluacionNomiEstructura;
	}

	public void setActivarEvaluacionNomiEstructura(Boolean habilitarResaltarEvaluacionNomi) {
		this.activarEvaluacionNomiEstructura= habilitarResaltarEvaluacionNomi;
	}


	public Border resaltarSolicitudVacacionEstructura=null;

	public Border getResaltarSolicitudVacacionEstructura() {
		return this.resaltarSolicitudVacacionEstructura;
	}

	public void setResaltarSolicitudVacacionEstructura(Border borderResaltarSolicitudVacacion) {
		if(borderResaltarSolicitudVacacion!=null) {
			this.resaltarSolicitudVacacionEstructura= borderResaltarSolicitudVacacion;
		}
	}

	public Border setResaltarSolicitudVacacionEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarSolicitudVacacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarSolicitudVacacion);
			
		this.resaltarSolicitudVacacionEstructura= borderResaltarSolicitudVacacion;

		 return borderResaltarSolicitudVacacion;
	}



	public Boolean mostrarSolicitudVacacionEstructura=true;

	public Boolean getMostrarSolicitudVacacionEstructura() {
		return this.mostrarSolicitudVacacionEstructura;
	}

	public void setMostrarSolicitudVacacionEstructura(Boolean visibilidadResaltarSolicitudVacacion) {
		this.mostrarSolicitudVacacionEstructura= visibilidadResaltarSolicitudVacacion;
	}



	public Boolean activarSolicitudVacacionEstructura=true;

	public Boolean gethabilitarResaltarSolicitudVacacionEstructura() {
		return this.activarSolicitudVacacionEstructura;
	}

	public void setActivarSolicitudVacacionEstructura(Boolean habilitarResaltarSolicitudVacacion) {
		this.activarSolicitudVacacionEstructura= habilitarResaltarSolicitudVacacion;
	}


	public Border resaltarResponsableActivoFijoEstructura=null;

	public Border getResaltarResponsableActivoFijoEstructura() {
		return this.resaltarResponsableActivoFijoEstructura;
	}

	public void setResaltarResponsableActivoFijoEstructura(Border borderResaltarResponsableActivoFijo) {
		if(borderResaltarResponsableActivoFijo!=null) {
			this.resaltarResponsableActivoFijoEstructura= borderResaltarResponsableActivoFijo;
		}
	}

	public Border setResaltarResponsableActivoFijoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarResponsableActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarResponsableActivoFijo);
			
		this.resaltarResponsableActivoFijoEstructura= borderResaltarResponsableActivoFijo;

		 return borderResaltarResponsableActivoFijo;
	}



	public Boolean mostrarResponsableActivoFijoEstructura=true;

	public Boolean getMostrarResponsableActivoFijoEstructura() {
		return this.mostrarResponsableActivoFijoEstructura;
	}

	public void setMostrarResponsableActivoFijoEstructura(Boolean visibilidadResaltarResponsableActivoFijo) {
		this.mostrarResponsableActivoFijoEstructura= visibilidadResaltarResponsableActivoFijo;
	}



	public Boolean activarResponsableActivoFijoEstructura=true;

	public Boolean gethabilitarResaltarResponsableActivoFijoEstructura() {
		return this.activarResponsableActivoFijoEstructura;
	}

	public void setActivarResponsableActivoFijoEstructura(Boolean habilitarResaltarResponsableActivoFijo) {
		this.activarResponsableActivoFijoEstructura= habilitarResaltarResponsableActivoFijo;
	}


	public Border resaltarRubroEmpleaCuentaContableEstructura=null;

	public Border getResaltarRubroEmpleaCuentaContableEstructura() {
		return this.resaltarRubroEmpleaCuentaContableEstructura;
	}

	public void setResaltarRubroEmpleaCuentaContableEstructura(Border borderResaltarRubroEmpleaCuentaContable) {
		if(borderResaltarRubroEmpleaCuentaContable!=null) {
			this.resaltarRubroEmpleaCuentaContableEstructura= borderResaltarRubroEmpleaCuentaContable;
		}
	}

	public Border setResaltarRubroEmpleaCuentaContableEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltarRubroEmpleaCuentaContable=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estructuraBeanSwingJInternalFrame.jTtoolBarEstructura.setBorder(borderResaltarRubroEmpleaCuentaContable);
			
		this.resaltarRubroEmpleaCuentaContableEstructura= borderResaltarRubroEmpleaCuentaContable;

		 return borderResaltarRubroEmpleaCuentaContable;
	}



	public Boolean mostrarRubroEmpleaCuentaContableEstructura=true;

	public Boolean getMostrarRubroEmpleaCuentaContableEstructura() {
		return this.mostrarRubroEmpleaCuentaContableEstructura;
	}

	public void setMostrarRubroEmpleaCuentaContableEstructura(Boolean visibilidadResaltarRubroEmpleaCuentaContable) {
		this.mostrarRubroEmpleaCuentaContableEstructura= visibilidadResaltarRubroEmpleaCuentaContable;
	}



	public Boolean activarRubroEmpleaCuentaContableEstructura=true;

	public Boolean gethabilitarResaltarRubroEmpleaCuentaContableEstructura() {
		return this.activarRubroEmpleaCuentaContableEstructura;
	}

	public void setActivarRubroEmpleaCuentaContableEstructura(Boolean habilitarResaltarRubroEmpleaCuentaContable) {
		this.activarRubroEmpleaCuentaContableEstructura= habilitarResaltarRubroEmpleaCuentaContable;
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

		this.setMostrarCentroCostoEstructuraEstructura(esInicial);
		this.setMostrarPlaniVacacionEstructura(esInicial);
		this.setMostrarAsistenciaMensualEstructura(esInicial);
		this.setMostrarEmpleadoProcesoRubroEstructura(esInicial);
		this.setMostrarEmpleadoPagoRubroEstructura(esInicial);
		this.setMostrarProvisionEmpleadoEstructura(esInicial);
		this.setMostrarEmpleadoEstructura(esInicial);
		this.setMostrarEstructuraEstructura(esInicial);
		this.setMostrarEvaluacionEmpleadoEstructura(esInicial);
		this.setMostrarEmpleadoImpuestoRentaEstructura(esInicial);
		this.setMostrarRubroEstructuraEstructura(esInicial);
		this.setMostrarCierreRolMensualEstructura(esInicial);
		this.setMostrarFormatoNomiEstructura(esInicial);
		this.setMostrarEmpleadoEstructuraEstructura(esInicial);
		this.setMostrarHistorialPagoNomiEstructura(esInicial);
		this.setMostrarAsistenciaDiariaEstructura(esInicial);
		this.setMostrarFuncionEstrucEstructura(esInicial);
		this.setMostrarSolicitudReemplazoEstructura(esInicial);
		this.setMostrarSolicitudHoraExtraEstructura(esInicial);
		this.setMostrarEvaluacionNomiEstructura(esInicial);
		this.setMostrarSolicitudVacacionEstructura(esInicial);
		this.setMostrarResponsableActivoFijoEstructura(esInicial);
		this.setMostrarRubroEmpleaCuentaContableEstructura(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CentroCostoEstructura.class)) {
				this.setMostrarCentroCostoEstructuraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(PlaniVacacion.class)) {
				this.setMostrarPlaniVacacionEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(AsistenciaMensual.class)) {
				this.setMostrarAsistenciaMensualEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoProcesoRubro.class)) {
				this.setMostrarEmpleadoProcesoRubroEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoPagoRubro.class)) {
				this.setMostrarEmpleadoPagoRubroEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProvisionEmpleado.class)) {
				this.setMostrarProvisionEmpleadoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setMostrarEmpleadoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(Estructura.class)) {
				this.setMostrarEstructuraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EvaluacionEmpleado.class)) {
				this.setMostrarEvaluacionEmpleadoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoImpuestoRenta.class)) {
				this.setMostrarEmpleadoImpuestoRentaEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEstructura.class)) {
				this.setMostrarRubroEstructuraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(CierreRolMensual.class)) {
				this.setMostrarCierreRolMensualEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormatoNomi.class)) {
				this.setMostrarFormatoNomiEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoEstructura.class)) {
				this.setMostrarEmpleadoEstructuraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(HistorialPagoNomi.class)) {
				this.setMostrarHistorialPagoNomiEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(AsistenciaDiaria.class)) {
				this.setMostrarAsistenciaDiariaEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(FuncionEstruc.class)) {
				this.setMostrarFuncionEstrucEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudReemplazo.class)) {
				this.setMostrarSolicitudReemplazoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudHoraExtra.class)) {
				this.setMostrarSolicitudHoraExtraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EvaluacionNomi.class)) {
				this.setMostrarEvaluacionNomiEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudVacacion.class)) {
				this.setMostrarSolicitudVacacionEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(ResponsableActivoFijo.class)) {
				this.setMostrarResponsableActivoFijoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEmpleaCuentaContable.class)) {
				this.setMostrarRubroEmpleaCuentaContableEstructura(esAsigna);
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

		this.setActivarCentroCostoEstructuraEstructura(esInicial);
		this.setActivarPlaniVacacionEstructura(esInicial);
		this.setActivarAsistenciaMensualEstructura(esInicial);
		this.setActivarEmpleadoProcesoRubroEstructura(esInicial);
		this.setActivarEmpleadoPagoRubroEstructura(esInicial);
		this.setActivarProvisionEmpleadoEstructura(esInicial);
		this.setActivarEmpleadoEstructura(esInicial);
		this.setActivarEstructuraEstructura(esInicial);
		this.setActivarEvaluacionEmpleadoEstructura(esInicial);
		this.setActivarEmpleadoImpuestoRentaEstructura(esInicial);
		this.setActivarRubroEstructuraEstructura(esInicial);
		this.setActivarCierreRolMensualEstructura(esInicial);
		this.setActivarFormatoNomiEstructura(esInicial);
		this.setActivarEmpleadoEstructuraEstructura(esInicial);
		this.setActivarHistorialPagoNomiEstructura(esInicial);
		this.setActivarAsistenciaDiariaEstructura(esInicial);
		this.setActivarFuncionEstrucEstructura(esInicial);
		this.setActivarSolicitudReemplazoEstructura(esInicial);
		this.setActivarSolicitudHoraExtraEstructura(esInicial);
		this.setActivarEvaluacionNomiEstructura(esInicial);
		this.setActivarSolicitudVacacionEstructura(esInicial);
		this.setActivarResponsableActivoFijoEstructura(esInicial);
		this.setActivarRubroEmpleaCuentaContableEstructura(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CentroCostoEstructura.class)) {
				this.setActivarCentroCostoEstructuraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(PlaniVacacion.class)) {
				this.setActivarPlaniVacacionEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(AsistenciaMensual.class)) {
				this.setActivarAsistenciaMensualEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoProcesoRubro.class)) {
				this.setActivarEmpleadoProcesoRubroEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoPagoRubro.class)) {
				this.setActivarEmpleadoPagoRubroEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProvisionEmpleado.class)) {
				this.setActivarProvisionEmpleadoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setActivarEmpleadoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(Estructura.class)) {
				this.setActivarEstructuraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EvaluacionEmpleado.class)) {
				this.setActivarEvaluacionEmpleadoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoImpuestoRenta.class)) {
				this.setActivarEmpleadoImpuestoRentaEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEstructura.class)) {
				this.setActivarRubroEstructuraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(CierreRolMensual.class)) {
				this.setActivarCierreRolMensualEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormatoNomi.class)) {
				this.setActivarFormatoNomiEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoEstructura.class)) {
				this.setActivarEmpleadoEstructuraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(HistorialPagoNomi.class)) {
				this.setActivarHistorialPagoNomiEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(AsistenciaDiaria.class)) {
				this.setActivarAsistenciaDiariaEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(FuncionEstruc.class)) {
				this.setActivarFuncionEstrucEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudReemplazo.class)) {
				this.setActivarSolicitudReemplazoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudHoraExtra.class)) {
				this.setActivarSolicitudHoraExtraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EvaluacionNomi.class)) {
				this.setActivarEvaluacionNomiEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudVacacion.class)) {
				this.setActivarSolicitudVacacionEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(ResponsableActivoFijo.class)) {
				this.setActivarResponsableActivoFijoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEmpleaCuentaContable.class)) {
				this.setActivarRubroEmpleaCuentaContableEstructura(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCentroCostoEstructuraEstructura(esInicial);
		this.setResaltarPlaniVacacionEstructura(esInicial);
		this.setResaltarAsistenciaMensualEstructura(esInicial);
		this.setResaltarEmpleadoProcesoRubroEstructura(esInicial);
		this.setResaltarEmpleadoPagoRubroEstructura(esInicial);
		this.setResaltarProvisionEmpleadoEstructura(esInicial);
		this.setResaltarEmpleadoEstructura(esInicial);
		this.setResaltarEstructuraEstructura(esInicial);
		this.setResaltarEvaluacionEmpleadoEstructura(esInicial);
		this.setResaltarEmpleadoImpuestoRentaEstructura(esInicial);
		this.setResaltarRubroEstructuraEstructura(esInicial);
		this.setResaltarCierreRolMensualEstructura(esInicial);
		this.setResaltarFormatoNomiEstructura(esInicial);
		this.setResaltarEmpleadoEstructuraEstructura(esInicial);
		this.setResaltarHistorialPagoNomiEstructura(esInicial);
		this.setResaltarAsistenciaDiariaEstructura(esInicial);
		this.setResaltarFuncionEstrucEstructura(esInicial);
		this.setResaltarSolicitudReemplazoEstructura(esInicial);
		this.setResaltarSolicitudHoraExtraEstructura(esInicial);
		this.setResaltarEvaluacionNomiEstructura(esInicial);
		this.setResaltarSolicitudVacacionEstructura(esInicial);
		this.setResaltarResponsableActivoFijoEstructura(esInicial);
		this.setResaltarRubroEmpleaCuentaContableEstructura(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CentroCostoEstructura.class)) {
				this.setResaltarCentroCostoEstructuraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(PlaniVacacion.class)) {
				this.setResaltarPlaniVacacionEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(AsistenciaMensual.class)) {
				this.setResaltarAsistenciaMensualEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoProcesoRubro.class)) {
				this.setResaltarEmpleadoProcesoRubroEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoPagoRubro.class)) {
				this.setResaltarEmpleadoPagoRubroEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProvisionEmpleado.class)) {
				this.setResaltarProvisionEmpleadoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setResaltarEmpleadoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(Estructura.class)) {
				this.setResaltarEstructuraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EvaluacionEmpleado.class)) {
				this.setResaltarEvaluacionEmpleadoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoImpuestoRenta.class)) {
				this.setResaltarEmpleadoImpuestoRentaEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEstructura.class)) {
				this.setResaltarRubroEstructuraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(CierreRolMensual.class)) {
				this.setResaltarCierreRolMensualEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormatoNomi.class)) {
				this.setResaltarFormatoNomiEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EmpleadoEstructura.class)) {
				this.setResaltarEmpleadoEstructuraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(HistorialPagoNomi.class)) {
				this.setResaltarHistorialPagoNomiEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(AsistenciaDiaria.class)) {
				this.setResaltarAsistenciaDiariaEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(FuncionEstruc.class)) {
				this.setResaltarFuncionEstrucEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudReemplazo.class)) {
				this.setResaltarSolicitudReemplazoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudHoraExtra.class)) {
				this.setResaltarSolicitudHoraExtraEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(EvaluacionNomi.class)) {
				this.setResaltarEvaluacionNomiEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(SolicitudVacacion.class)) {
				this.setResaltarSolicitudVacacionEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(ResponsableActivoFijo.class)) {
				this.setResaltarResponsableActivoFijoEstructura(esAsigna);
				continue;
			}

			if(clase.clas.equals(RubroEmpleaCuentaContable.class)) {
				this.setResaltarRubroEmpleaCuentaContableEstructura(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCiudadEstructura=true;

	public Boolean getMostrarFK_IdCiudadEstructura() {
		return this.mostrarFK_IdCiudadEstructura;
	}

	public void setMostrarFK_IdCiudadEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableEstructura=true;

	public Boolean getMostrarFK_IdCuentaContableEstructura() {
		return this.mostrarFK_IdCuentaContableEstructura;
	}

	public void setMostrarFK_IdCuentaContableEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEstructura=true;

	public Boolean getMostrarFK_IdEmpresaEstructura() {
		return this.mostrarFK_IdEmpresaEstructura;
	}

	public void setMostrarFK_IdEmpresaEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraEstructura=true;

	public Boolean getMostrarFK_IdEstructuraEstructura() {
		return this.mostrarFK_IdEstructuraEstructura;
	}

	public void setMostrarFK_IdEstructuraEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNumeroPatronalEstructura=true;

	public Boolean getMostrarFK_IdNumeroPatronalEstructura() {
		return this.mostrarFK_IdNumeroPatronalEstructura;
	}

	public void setMostrarFK_IdNumeroPatronalEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNumeroPatronalEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisEstructura=true;

	public Boolean getMostrarFK_IdPaisEstructura() {
		return this.mostrarFK_IdPaisEstructura;
	}

	public void setMostrarFK_IdPaisEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalEstructura=true;

	public Boolean getMostrarFK_IdSucursalEstructura() {
		return this.mostrarFK_IdSucursalEstructura;
	}

	public void setMostrarFK_IdSucursalEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoEstructuraEstructura=true;

	public Boolean getMostrarFK_IdTipoEstructuraEstructura() {
		return this.mostrarFK_IdTipoEstructuraEstructura;
	}

	public void setMostrarFK_IdTipoEstructuraEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoEstructuraEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPago_NMEstructura=true;

	public Boolean getMostrarFK_IdTipoPago_NMEstructura() {
		return this.mostrarFK_IdTipoPago_NMEstructura;
	}

	public void setMostrarFK_IdTipoPago_NMEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPago_NMEstructura= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadEstructura=true;

	public Boolean getActivarFK_IdCiudadEstructura() {
		return this.activarFK_IdCiudadEstructura;
	}

	public void setActivarFK_IdCiudadEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableEstructura=true;

	public Boolean getActivarFK_IdCuentaContableEstructura() {
		return this.activarFK_IdCuentaContableEstructura;
	}

	public void setActivarFK_IdCuentaContableEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEstructura=true;

	public Boolean getActivarFK_IdEmpresaEstructura() {
		return this.activarFK_IdEmpresaEstructura;
	}

	public void setActivarFK_IdEmpresaEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraEstructura=true;

	public Boolean getActivarFK_IdEstructuraEstructura() {
		return this.activarFK_IdEstructuraEstructura;
	}

	public void setActivarFK_IdEstructuraEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdNumeroPatronalEstructura=true;

	public Boolean getActivarFK_IdNumeroPatronalEstructura() {
		return this.activarFK_IdNumeroPatronalEstructura;
	}

	public void setActivarFK_IdNumeroPatronalEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdNumeroPatronalEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisEstructura=true;

	public Boolean getActivarFK_IdPaisEstructura() {
		return this.activarFK_IdPaisEstructura;
	}

	public void setActivarFK_IdPaisEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdPaisEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalEstructura=true;

	public Boolean getActivarFK_IdSucursalEstructura() {
		return this.activarFK_IdSucursalEstructura;
	}

	public void setActivarFK_IdSucursalEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoEstructuraEstructura=true;

	public Boolean getActivarFK_IdTipoEstructuraEstructura() {
		return this.activarFK_IdTipoEstructuraEstructura;
	}

	public void setActivarFK_IdTipoEstructuraEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdTipoEstructuraEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPago_NMEstructura=true;

	public Boolean getActivarFK_IdTipoPago_NMEstructura() {
		return this.activarFK_IdTipoPago_NMEstructura;
	}

	public void setActivarFK_IdTipoPago_NMEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPago_NMEstructura= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadEstructura=null;

	public Border getResaltarFK_IdCiudadEstructura() {
		return this.resaltarFK_IdCiudadEstructura;
	}

	public void setResaltarFK_IdCiudadEstructura(Border borderResaltar) {
		this.resaltarFK_IdCiudadEstructura= borderResaltar;
	}

	public void setResaltarFK_IdCiudadEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadEstructura= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableEstructura=null;

	public Border getResaltarFK_IdCuentaContableEstructura() {
		return this.resaltarFK_IdCuentaContableEstructura;
	}

	public void setResaltarFK_IdCuentaContableEstructura(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableEstructura= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableEstructura= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEstructura=null;

	public Border getResaltarFK_IdEmpresaEstructura() {
		return this.resaltarFK_IdEmpresaEstructura;
	}

	public void setResaltarFK_IdEmpresaEstructura(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEstructura= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEstructura= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraEstructura=null;

	public Border getResaltarFK_IdEstructuraEstructura() {
		return this.resaltarFK_IdEstructuraEstructura;
	}

	public void setResaltarFK_IdEstructuraEstructura(Border borderResaltar) {
		this.resaltarFK_IdEstructuraEstructura= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraEstructura= borderResaltar;
	}

	public Border resaltarFK_IdNumeroPatronalEstructura=null;

	public Border getResaltarFK_IdNumeroPatronalEstructura() {
		return this.resaltarFK_IdNumeroPatronalEstructura;
	}

	public void setResaltarFK_IdNumeroPatronalEstructura(Border borderResaltar) {
		this.resaltarFK_IdNumeroPatronalEstructura= borderResaltar;
	}

	public void setResaltarFK_IdNumeroPatronalEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNumeroPatronalEstructura= borderResaltar;
	}

	public Border resaltarFK_IdPaisEstructura=null;

	public Border getResaltarFK_IdPaisEstructura() {
		return this.resaltarFK_IdPaisEstructura;
	}

	public void setResaltarFK_IdPaisEstructura(Border borderResaltar) {
		this.resaltarFK_IdPaisEstructura= borderResaltar;
	}

	public void setResaltarFK_IdPaisEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisEstructura= borderResaltar;
	}

	public Border resaltarFK_IdSucursalEstructura=null;

	public Border getResaltarFK_IdSucursalEstructura() {
		return this.resaltarFK_IdSucursalEstructura;
	}

	public void setResaltarFK_IdSucursalEstructura(Border borderResaltar) {
		this.resaltarFK_IdSucursalEstructura= borderResaltar;
	}

	public void setResaltarFK_IdSucursalEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalEstructura= borderResaltar;
	}

	public Border resaltarFK_IdTipoEstructuraEstructura=null;

	public Border getResaltarFK_IdTipoEstructuraEstructura() {
		return this.resaltarFK_IdTipoEstructuraEstructura;
	}

	public void setResaltarFK_IdTipoEstructuraEstructura(Border borderResaltar) {
		this.resaltarFK_IdTipoEstructuraEstructura= borderResaltar;
	}

	public void setResaltarFK_IdTipoEstructuraEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoEstructuraEstructura= borderResaltar;
	}

	public Border resaltarFK_IdTipoPago_NMEstructura=null;

	public Border getResaltarFK_IdTipoPago_NMEstructura() {
		return this.resaltarFK_IdTipoPago_NMEstructura;
	}

	public void setResaltarFK_IdTipoPago_NMEstructura(Border borderResaltar) {
		this.resaltarFK_IdTipoPago_NMEstructura= borderResaltar;
	}

	public void setResaltarFK_IdTipoPago_NMEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EstructuraBeanSwingJInternalFrame estructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPago_NMEstructura= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}