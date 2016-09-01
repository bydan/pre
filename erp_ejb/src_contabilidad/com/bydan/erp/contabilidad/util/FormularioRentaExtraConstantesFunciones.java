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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.FormularioRentaExtraConstantesFunciones;
import com.bydan.erp.contabilidad.util.FormularioRentaExtraParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.FormularioRentaExtraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FormularioRentaExtraConstantesFunciones extends FormularioRentaExtraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FormularioRentaExtra";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FormularioRentaExtra"+FormularioRentaExtraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FormularioRentaExtraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FormularioRentaExtraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FormularioRentaExtraConstantesFunciones.SCHEMA+"_"+FormularioRentaExtraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FormularioRentaExtraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FormularioRentaExtraConstantesFunciones.SCHEMA+"_"+FormularioRentaExtraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FormularioRentaExtraConstantesFunciones.SCHEMA+"_"+FormularioRentaExtraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FormularioRentaExtraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FormularioRentaExtraConstantesFunciones.SCHEMA+"_"+FormularioRentaExtraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioRentaExtraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormularioRentaExtraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioRentaExtraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioRentaExtraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormularioRentaExtraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioRentaExtraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FormularioRentaExtraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FormularioRentaExtraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FormularioRentaExtraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FormularioRentaExtraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Formulario Renta Extras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Formulario Renta Extra";
	public static final String SCLASSWEBTITULO_LOWER="Formulario Renta Extra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FormularioRentaExtra";
	public static final String OBJECTNAME="formulariorentaextra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="formulario_renta_extra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select formulariorentaextra from "+FormularioRentaExtraConstantesFunciones.SPERSISTENCENAME+" formulariorentaextra";
	public static String QUERYSELECTNATIVE="select "+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".version_row,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id_empresa,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id_ejercicio,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id_periodo,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id_dato_formulario_renta,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id_forma_pago,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".id_banco,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".pago_previo,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".interes_mora,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_multa,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".forma_pago1,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".forma_pago2,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".numero_nota_credito1,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".numero_nota_credito2,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".numero_nota_credito3,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".numero_nota_credito4,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_nota_credito1,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_nota_credito2,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_nota_credito3,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_nota_credito4,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".numero_comprobante1,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".numero_comprobante2,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_comprobante1,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor_comprobante2,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor301,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor303,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor305,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor307,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor351,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor355,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor357,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor359,"+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME+".valor361 from "+FormularioRentaExtraConstantesFunciones.SCHEMA+"."+FormularioRentaExtraConstantesFunciones.TABLENAME;//+" as "+FormularioRentaExtraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FormularioRentaExtraConstantesFuncionesAdditional formulariorentaextraConstantesFuncionesAdditional=null;
	
	public FormularioRentaExtraConstantesFuncionesAdditional getFormularioRentaExtraConstantesFuncionesAdditional() {
		return this.formulariorentaextraConstantesFuncionesAdditional;
	}
	
	public void setFormularioRentaExtraConstantesFuncionesAdditional(FormularioRentaExtraConstantesFuncionesAdditional formulariorentaextraConstantesFuncionesAdditional) {
		try {
			this.formulariorentaextraConstantesFuncionesAdditional=formulariorentaextraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDDATOFORMULARIORENTA= "id_dato_formulario_renta";
    public static final String IDFORMAPAGO= "id_forma_pago";
    public static final String IDBANCO= "id_banco";
    public static final String PAGOPREVIO= "pago_previo";
    public static final String INTERESMORA= "interes_mora";
    public static final String VALORMULTA= "valor_multa";
    public static final String FORMAPAGO1= "forma_pago1";
    public static final String FORMAPAGO2= "forma_pago2";
    public static final String NUMERONOTACREDITO1= "numero_nota_credito1";
    public static final String NUMERONOTACREDITO2= "numero_nota_credito2";
    public static final String NUMERONOTACREDITO3= "numero_nota_credito3";
    public static final String NUMERONOTACREDITO4= "numero_nota_credito4";
    public static final String VALORNOTACREDITO1= "valor_nota_credito1";
    public static final String VALORNOTACREDITO2= "valor_nota_credito2";
    public static final String VALORNOTACREDITO3= "valor_nota_credito3";
    public static final String VALORNOTACREDITO4= "valor_nota_credito4";
    public static final String NUMEROCOMPROBANTE1= "numero_comprobante1";
    public static final String NUMEROCOMPROBANTE2= "numero_comprobante2";
    public static final String VALORCOMPROBANTE1= "valor_comprobante1";
    public static final String VALORCOMPROBANTE2= "valor_comprobante2";
    public static final String VALOR301= "valor301";
    public static final String VALOR303= "valor303";
    public static final String VALOR305= "valor305";
    public static final String VALOR307= "valor307";
    public static final String VALOR351= "valor351";
    public static final String VALOR355= "valor355";
    public static final String VALOR357= "valor357";
    public static final String VALOR359= "valor359";
    public static final String VALOR361= "valor361";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDDATOFORMULARIORENTA= "Dato Formulario Renta";
		public static final String LABEL_IDDATOFORMULARIORENTA_LOWER= "Dato Formulario Renta";
    	public static final String LABEL_IDFORMAPAGO= "Forma Pago";
		public static final String LABEL_IDFORMAPAGO_LOWER= "Forma Pago";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_PAGOPREVIO= "Pago Previo";
		public static final String LABEL_PAGOPREVIO_LOWER= "Pago Previo";
    	public static final String LABEL_INTERESMORA= "Interes Mora";
		public static final String LABEL_INTERESMORA_LOWER= "Interes Mora";
    	public static final String LABEL_VALORMULTA= "Valor Multa";
		public static final String LABEL_VALORMULTA_LOWER= "Valor Multa";
    	public static final String LABEL_FORMAPAGO1= "Forma Pago1";
		public static final String LABEL_FORMAPAGO1_LOWER= "Forma Pago1";
    	public static final String LABEL_FORMAPAGO2= "Forma Pago2";
		public static final String LABEL_FORMAPAGO2_LOWER= "Forma Pago2";
    	public static final String LABEL_NUMERONOTACREDITO1= "Numero Nota Credito1";
		public static final String LABEL_NUMERONOTACREDITO1_LOWER= "Numero Nota Credito1";
    	public static final String LABEL_NUMERONOTACREDITO2= "Numero Nota Credito2";
		public static final String LABEL_NUMERONOTACREDITO2_LOWER= "Numero Nota Credito2";
    	public static final String LABEL_NUMERONOTACREDITO3= "Numero Nota Credito3";
		public static final String LABEL_NUMERONOTACREDITO3_LOWER= "Numero Nota Credito3";
    	public static final String LABEL_NUMERONOTACREDITO4= "Numero Nota Credito4";
		public static final String LABEL_NUMERONOTACREDITO4_LOWER= "Numero Nota Credito4";
    	public static final String LABEL_VALORNOTACREDITO1= "Valor Nota Credito1";
		public static final String LABEL_VALORNOTACREDITO1_LOWER= "Valor Nota Credito1";
    	public static final String LABEL_VALORNOTACREDITO2= "Valor Nota Credito2";
		public static final String LABEL_VALORNOTACREDITO2_LOWER= "Valor Nota Credito2";
    	public static final String LABEL_VALORNOTACREDITO3= "Valor Nota Credito3";
		public static final String LABEL_VALORNOTACREDITO3_LOWER= "Valor Nota Credito3";
    	public static final String LABEL_VALORNOTACREDITO4= "Valor Nota Credito4";
		public static final String LABEL_VALORNOTACREDITO4_LOWER= "Valor Nota Credito4";
    	public static final String LABEL_NUMEROCOMPROBANTE1= "Numero Comprobante1";
		public static final String LABEL_NUMEROCOMPROBANTE1_LOWER= "Numero Comprobante1";
    	public static final String LABEL_NUMEROCOMPROBANTE2= "Numero Comprobante2";
		public static final String LABEL_NUMEROCOMPROBANTE2_LOWER= "Numero Comprobante2";
    	public static final String LABEL_VALORCOMPROBANTE1= "Valor Comprobante1";
		public static final String LABEL_VALORCOMPROBANTE1_LOWER= "Valor Comprobante1";
    	public static final String LABEL_VALORCOMPROBANTE2= "Valor Comprobante2";
		public static final String LABEL_VALORCOMPROBANTE2_LOWER= "Valor Comprobante2";
    	public static final String LABEL_VALOR301= "Valor301";
		public static final String LABEL_VALOR301_LOWER= "Valor301";
    	public static final String LABEL_VALOR303= "Valor303";
		public static final String LABEL_VALOR303_LOWER= "Valor303";
    	public static final String LABEL_VALOR305= "Valor305";
		public static final String LABEL_VALOR305_LOWER= "Valor305";
    	public static final String LABEL_VALOR307= "Valor307";
		public static final String LABEL_VALOR307_LOWER= "Valor307";
    	public static final String LABEL_VALOR351= "Valor351";
		public static final String LABEL_VALOR351_LOWER= "Valor351";
    	public static final String LABEL_VALOR355= "Valor355";
		public static final String LABEL_VALOR355_LOWER= "Valor355";
    	public static final String LABEL_VALOR357= "Valor357";
		public static final String LABEL_VALOR357_LOWER= "Valor357";
    	public static final String LABEL_VALOR359= "Valor359";
		public static final String LABEL_VALOR359_LOWER= "Valor359";
    	public static final String LABEL_VALOR361= "Valor361";
		public static final String LABEL_VALOR361_LOWER= "Valor361";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_NOTA_CREDITO1=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_NOTA_CREDITO1=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_NOTA_CREDITO2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_NOTA_CREDITO2=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_NOTA_CREDITO3=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_NOTA_CREDITO3=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_NOTA_CREDITO4=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_NOTA_CREDITO4=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXNUMERO_COMPROBANTE1=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE1=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_COMPROBANTE2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE2=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getFormularioRentaExtraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.IDEMPRESA)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.IDEJERCICIO)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.IDPERIODO)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.IDDATOFORMULARIORENTA)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_IDDATOFORMULARIORENTA;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.IDFORMAPAGO)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_IDFORMAPAGO;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.IDBANCO)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.PAGOPREVIO)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_PAGOPREVIO;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.INTERESMORA)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_INTERESMORA;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALORMULTA)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALORMULTA;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.FORMAPAGO1)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_FORMAPAGO1;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.FORMAPAGO2)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_FORMAPAGO2;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO1)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO1;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO2)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO2;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO3)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO3;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO4)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO4;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO1)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO1;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO2)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO2;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO3)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO3;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO4)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO4;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE1)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_NUMEROCOMPROBANTE1;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE2)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_NUMEROCOMPROBANTE2;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE1)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALORCOMPROBANTE1;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE2)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALORCOMPROBANTE2;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALOR301)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALOR301;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALOR303)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALOR303;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALOR305)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALOR305;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALOR307)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALOR307;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALOR351)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALOR351;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALOR355)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALOR355;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALOR357)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALOR357;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALOR359)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALOR359;}
		if(sNombreColumna.equals(FormularioRentaExtraConstantesFunciones.VALOR361)) {sLabelColumna=FormularioRentaExtraConstantesFunciones.LABEL_VALOR361;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFormularioRentaExtraDescripcion(FormularioRentaExtra formulariorentaextra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(formulariorentaextra !=null/* && formulariorentaextra.getId()!=0*/) {
			if(formulariorentaextra.getId()!=null) {
				sDescripcion=formulariorentaextra.getId().toString();
			}//formulariorentaextraformulariorentaextra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFormularioRentaExtraDescripcionDetallado(FormularioRentaExtra formulariorentaextra) {
		String sDescripcion="";
			
		sDescripcion+=FormularioRentaExtraConstantesFunciones.ID+"=";
		sDescripcion+=formulariorentaextra.getId().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=formulariorentaextra.getVersionRow().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=formulariorentaextra.getid_empresa().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=formulariorentaextra.getid_ejercicio().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=formulariorentaextra.getid_periodo().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.IDDATOFORMULARIORENTA+"=";
		sDescripcion+=formulariorentaextra.getid_dato_formulario_renta().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.IDFORMAPAGO+"=";
		sDescripcion+=formulariorentaextra.getid_forma_pago().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.IDBANCO+"=";
		sDescripcion+=formulariorentaextra.getid_banco().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.PAGOPREVIO+"=";
		sDescripcion+=formulariorentaextra.getpago_previo().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.INTERESMORA+"=";
		sDescripcion+=formulariorentaextra.getinteres_mora().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALORMULTA+"=";
		sDescripcion+=formulariorentaextra.getvalor_multa().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.FORMAPAGO1+"=";
		sDescripcion+=formulariorentaextra.getforma_pago1().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.FORMAPAGO2+"=";
		sDescripcion+=formulariorentaextra.getforma_pago2().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO1+"=";
		sDescripcion+=formulariorentaextra.getnumero_nota_credito1()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO2+"=";
		sDescripcion+=formulariorentaextra.getnumero_nota_credito2()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO3+"=";
		sDescripcion+=formulariorentaextra.getnumero_nota_credito3()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO4+"=";
		sDescripcion+=formulariorentaextra.getnumero_nota_credito4()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO1+"=";
		sDescripcion+=formulariorentaextra.getvalor_nota_credito1().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO2+"=";
		sDescripcion+=formulariorentaextra.getvalor_nota_credito2().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO3+"=";
		sDescripcion+=formulariorentaextra.getvalor_nota_credito3().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO4+"=";
		sDescripcion+=formulariorentaextra.getvalor_nota_credito4().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE1+"=";
		sDescripcion+=formulariorentaextra.getnumero_comprobante1()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE2+"=";
		sDescripcion+=formulariorentaextra.getnumero_comprobante2()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE1+"=";
		sDescripcion+=formulariorentaextra.getvalor_comprobante1().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE2+"=";
		sDescripcion+=formulariorentaextra.getvalor_comprobante2().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALOR301+"=";
		sDescripcion+=formulariorentaextra.getvalor301().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALOR303+"=";
		sDescripcion+=formulariorentaextra.getvalor303().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALOR305+"=";
		sDescripcion+=formulariorentaextra.getvalor305().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALOR307+"=";
		sDescripcion+=formulariorentaextra.getvalor307().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALOR351+"=";
		sDescripcion+=formulariorentaextra.getvalor351().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALOR355+"=";
		sDescripcion+=formulariorentaextra.getvalor355().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALOR357+"=";
		sDescripcion+=formulariorentaextra.getvalor357().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALOR359+"=";
		sDescripcion+=formulariorentaextra.getvalor359().toString()+",";
		sDescripcion+=FormularioRentaExtraConstantesFunciones.VALOR361+"=";
		sDescripcion+=formulariorentaextra.getvalor361().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFormularioRentaExtraDescripcion(FormularioRentaExtra formulariorentaextra,String sValor) throws Exception {			
		if(formulariorentaextra !=null) {
			//formulariorentaextraformulariorentaextra.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getDatoFormularioRentaDescripcion(DatoFormularioRenta datoformulariorenta) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(datoformulariorenta!=null/*&&datoformulariorenta.getId()>0*/) {
			sDescripcion=DatoFormularioRentaConstantesFunciones.getDatoFormularioRentaDescripcion(datoformulariorenta);
		}

		return sDescripcion;
	}

	public static String getFormaPagoDescripcion(FormaPago formapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formapago!=null/*&&formapago.getId()>0*/) {
			sDescripcion=FormaPagoConstantesFunciones.getFormaPagoDescripcion(formapago);
		}

		return sDescripcion;
	}

	public static String getBancoDescripcion(Banco banco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(banco!=null/*&&banco.getId()>0*/) {
			sDescripcion=BancoConstantesFunciones.getBancoDescripcion(banco);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdDatoFormularioRenta")) {
			sNombreIndice="Tipo=  Por Dato Formulario Renta";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormaPago")) {
			sNombreIndice="Tipo=  Por Forma Pago";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBanco(Long id_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_banco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDatoFormularioRenta(Long id_dato_formulario_renta) {
		String sDetalleIndice=" Parametros->";
		if(id_dato_formulario_renta!=null) {sDetalleIndice+=" Codigo Unico De Dato Formulario Renta="+id_dato_formulario_renta.toString();} 

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

	public static String getDetalleIndiceFK_IdFormaPago(Long id_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Forma Pago="+id_forma_pago.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFormularioRentaExtra(FormularioRentaExtra formulariorentaextra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		formulariorentaextra.setnumero_nota_credito1(formulariorentaextra.getnumero_nota_credito1().trim());
		formulariorentaextra.setnumero_nota_credito2(formulariorentaextra.getnumero_nota_credito2().trim());
		formulariorentaextra.setnumero_nota_credito3(formulariorentaextra.getnumero_nota_credito3().trim());
		formulariorentaextra.setnumero_nota_credito4(formulariorentaextra.getnumero_nota_credito4().trim());
		formulariorentaextra.setnumero_comprobante1(formulariorentaextra.getnumero_comprobante1().trim());
		formulariorentaextra.setnumero_comprobante2(formulariorentaextra.getnumero_comprobante2().trim());
	}
	
	public static void quitarEspaciosFormularioRentaExtras(List<FormularioRentaExtra> formulariorentaextras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FormularioRentaExtra formulariorentaextra: formulariorentaextras) {
			formulariorentaextra.setnumero_nota_credito1(formulariorentaextra.getnumero_nota_credito1().trim());
			formulariorentaextra.setnumero_nota_credito2(formulariorentaextra.getnumero_nota_credito2().trim());
			formulariorentaextra.setnumero_nota_credito3(formulariorentaextra.getnumero_nota_credito3().trim());
			formulariorentaextra.setnumero_nota_credito4(formulariorentaextra.getnumero_nota_credito4().trim());
			formulariorentaextra.setnumero_comprobante1(formulariorentaextra.getnumero_comprobante1().trim());
			formulariorentaextra.setnumero_comprobante2(formulariorentaextra.getnumero_comprobante2().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormularioRentaExtra(FormularioRentaExtra formulariorentaextra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && formulariorentaextra.getConCambioAuxiliar()) {
			formulariorentaextra.setIsDeleted(formulariorentaextra.getIsDeletedAuxiliar());	
			formulariorentaextra.setIsNew(formulariorentaextra.getIsNewAuxiliar());	
			formulariorentaextra.setIsChanged(formulariorentaextra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			formulariorentaextra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			formulariorentaextra.setIsDeletedAuxiliar(false);	
			formulariorentaextra.setIsNewAuxiliar(false);	
			formulariorentaextra.setIsChangedAuxiliar(false);
			
			formulariorentaextra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormularioRentaExtras(List<FormularioRentaExtra> formulariorentaextras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FormularioRentaExtra formulariorentaextra : formulariorentaextras) {
			if(conAsignarBase && formulariorentaextra.getConCambioAuxiliar()) {
				formulariorentaextra.setIsDeleted(formulariorentaextra.getIsDeletedAuxiliar());	
				formulariorentaextra.setIsNew(formulariorentaextra.getIsNewAuxiliar());	
				formulariorentaextra.setIsChanged(formulariorentaextra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				formulariorentaextra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				formulariorentaextra.setIsDeletedAuxiliar(false);	
				formulariorentaextra.setIsNewAuxiliar(false);	
				formulariorentaextra.setIsChangedAuxiliar(false);
				
				formulariorentaextra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFormularioRentaExtra(FormularioRentaExtra formulariorentaextra,Boolean conEnteros) throws Exception  {
		formulariorentaextra.setpago_previo(0.0);
		formulariorentaextra.setinteres_mora(0.0);
		formulariorentaextra.setvalor_multa(0.0);
		formulariorentaextra.setforma_pago1(0.0);
		formulariorentaextra.setforma_pago2(0.0);
		formulariorentaextra.setvalor_nota_credito1(0.0);
		formulariorentaextra.setvalor_nota_credito2(0.0);
		formulariorentaextra.setvalor_nota_credito3(0.0);
		formulariorentaextra.setvalor_nota_credito4(0.0);
		formulariorentaextra.setvalor_comprobante1(0.0);
		formulariorentaextra.setvalor_comprobante2(0.0);
		formulariorentaextra.setvalor301(0.0);
		formulariorentaextra.setvalor303(0.0);
		formulariorentaextra.setvalor305(0.0);
		formulariorentaextra.setvalor307(0.0);
		formulariorentaextra.setvalor351(0.0);
		formulariorentaextra.setvalor355(0.0);
		formulariorentaextra.setvalor357(0.0);
		formulariorentaextra.setvalor359(0.0);
		formulariorentaextra.setvalor361(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFormularioRentaExtras(List<FormularioRentaExtra> formulariorentaextras,Boolean conEnteros) throws Exception  {
		
		for(FormularioRentaExtra formulariorentaextra: formulariorentaextras) {
			formulariorentaextra.setpago_previo(0.0);
			formulariorentaextra.setinteres_mora(0.0);
			formulariorentaextra.setvalor_multa(0.0);
			formulariorentaextra.setforma_pago1(0.0);
			formulariorentaextra.setforma_pago2(0.0);
			formulariorentaextra.setvalor_nota_credito1(0.0);
			formulariorentaextra.setvalor_nota_credito2(0.0);
			formulariorentaextra.setvalor_nota_credito3(0.0);
			formulariorentaextra.setvalor_nota_credito4(0.0);
			formulariorentaextra.setvalor_comprobante1(0.0);
			formulariorentaextra.setvalor_comprobante2(0.0);
			formulariorentaextra.setvalor301(0.0);
			formulariorentaextra.setvalor303(0.0);
			formulariorentaextra.setvalor305(0.0);
			formulariorentaextra.setvalor307(0.0);
			formulariorentaextra.setvalor351(0.0);
			formulariorentaextra.setvalor355(0.0);
			formulariorentaextra.setvalor357(0.0);
			formulariorentaextra.setvalor359(0.0);
			formulariorentaextra.setvalor361(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFormularioRentaExtra(List<FormularioRentaExtra> formulariorentaextras,FormularioRentaExtra formulariorentaextraAux) throws Exception  {
		FormularioRentaExtraConstantesFunciones.InicializarValoresFormularioRentaExtra(formulariorentaextraAux,true);
		
		for(FormularioRentaExtra formulariorentaextra: formulariorentaextras) {
			if(formulariorentaextra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			formulariorentaextraAux.setpago_previo(formulariorentaextraAux.getpago_previo()+formulariorentaextra.getpago_previo());			
			formulariorentaextraAux.setinteres_mora(formulariorentaextraAux.getinteres_mora()+formulariorentaextra.getinteres_mora());			
			formulariorentaextraAux.setvalor_multa(formulariorentaextraAux.getvalor_multa()+formulariorentaextra.getvalor_multa());			
			formulariorentaextraAux.setforma_pago1(formulariorentaextraAux.getforma_pago1()+formulariorentaextra.getforma_pago1());			
			formulariorentaextraAux.setforma_pago2(formulariorentaextraAux.getforma_pago2()+formulariorentaextra.getforma_pago2());			
			formulariorentaextraAux.setvalor_nota_credito1(formulariorentaextraAux.getvalor_nota_credito1()+formulariorentaextra.getvalor_nota_credito1());			
			formulariorentaextraAux.setvalor_nota_credito2(formulariorentaextraAux.getvalor_nota_credito2()+formulariorentaextra.getvalor_nota_credito2());			
			formulariorentaextraAux.setvalor_nota_credito3(formulariorentaextraAux.getvalor_nota_credito3()+formulariorentaextra.getvalor_nota_credito3());			
			formulariorentaextraAux.setvalor_nota_credito4(formulariorentaextraAux.getvalor_nota_credito4()+formulariorentaextra.getvalor_nota_credito4());			
			formulariorentaextraAux.setvalor_comprobante1(formulariorentaextraAux.getvalor_comprobante1()+formulariorentaextra.getvalor_comprobante1());			
			formulariorentaextraAux.setvalor_comprobante2(formulariorentaextraAux.getvalor_comprobante2()+formulariorentaextra.getvalor_comprobante2());			
			formulariorentaextraAux.setvalor301(formulariorentaextraAux.getvalor301()+formulariorentaextra.getvalor301());			
			formulariorentaextraAux.setvalor303(formulariorentaextraAux.getvalor303()+formulariorentaextra.getvalor303());			
			formulariorentaextraAux.setvalor305(formulariorentaextraAux.getvalor305()+formulariorentaextra.getvalor305());			
			formulariorentaextraAux.setvalor307(formulariorentaextraAux.getvalor307()+formulariorentaextra.getvalor307());			
			formulariorentaextraAux.setvalor351(formulariorentaextraAux.getvalor351()+formulariorentaextra.getvalor351());			
			formulariorentaextraAux.setvalor355(formulariorentaextraAux.getvalor355()+formulariorentaextra.getvalor355());			
			formulariorentaextraAux.setvalor357(formulariorentaextraAux.getvalor357()+formulariorentaextra.getvalor357());			
			formulariorentaextraAux.setvalor359(formulariorentaextraAux.getvalor359()+formulariorentaextra.getvalor359());			
			formulariorentaextraAux.setvalor361(formulariorentaextraAux.getvalor361()+formulariorentaextra.getvalor361());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormularioRentaExtra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FormularioRentaExtraConstantesFunciones.getArrayColumnasGlobalesFormularioRentaExtra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFormularioRentaExtra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormularioRentaExtraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormularioRentaExtraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormularioRentaExtraConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormularioRentaExtraConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormularioRentaExtraConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormularioRentaExtraConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFormularioRentaExtra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FormularioRentaExtra> formulariorentaextras,FormularioRentaExtra formulariorentaextra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FormularioRentaExtra formulariorentaextraAux: formulariorentaextras) {
			if(formulariorentaextraAux!=null && formulariorentaextra!=null) {
				if((formulariorentaextraAux.getId()==null && formulariorentaextra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(formulariorentaextraAux.getId()!=null && formulariorentaextra.getId()!=null){
					if(formulariorentaextraAux.getId().equals(formulariorentaextra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFormularioRentaExtra(List<FormularioRentaExtra> formulariorentaextras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double pago_previoTotal=0.0;
		Double interes_moraTotal=0.0;
		Double valor_multaTotal=0.0;
		Double forma_pago1Total=0.0;
		Double forma_pago2Total=0.0;
		Double valor_nota_credito1Total=0.0;
		Double valor_nota_credito2Total=0.0;
		Double valor_nota_credito3Total=0.0;
		Double valor_nota_credito4Total=0.0;
		Double valor_comprobante1Total=0.0;
		Double valor_comprobante2Total=0.0;
		Double valor301Total=0.0;
		Double valor303Total=0.0;
		Double valor305Total=0.0;
		Double valor307Total=0.0;
		Double valor351Total=0.0;
		Double valor355Total=0.0;
		Double valor357Total=0.0;
		Double valor359Total=0.0;
		Double valor361Total=0.0;
	
		for(FormularioRentaExtra formulariorentaextra: formulariorentaextras) {			
			if(formulariorentaextra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pago_previoTotal+=formulariorentaextra.getpago_previo();
			interes_moraTotal+=formulariorentaextra.getinteres_mora();
			valor_multaTotal+=formulariorentaextra.getvalor_multa();
			forma_pago1Total+=formulariorentaextra.getforma_pago1();
			forma_pago2Total+=formulariorentaextra.getforma_pago2();
			valor_nota_credito1Total+=formulariorentaextra.getvalor_nota_credito1();
			valor_nota_credito2Total+=formulariorentaextra.getvalor_nota_credito2();
			valor_nota_credito3Total+=formulariorentaextra.getvalor_nota_credito3();
			valor_nota_credito4Total+=formulariorentaextra.getvalor_nota_credito4();
			valor_comprobante1Total+=formulariorentaextra.getvalor_comprobante1();
			valor_comprobante2Total+=formulariorentaextra.getvalor_comprobante2();
			valor301Total+=formulariorentaextra.getvalor301();
			valor303Total+=formulariorentaextra.getvalor303();
			valor305Total+=formulariorentaextra.getvalor305();
			valor307Total+=formulariorentaextra.getvalor307();
			valor351Total+=formulariorentaextra.getvalor351();
			valor355Total+=formulariorentaextra.getvalor355();
			valor357Total+=formulariorentaextra.getvalor357();
			valor359Total+=formulariorentaextra.getvalor359();
			valor361Total+=formulariorentaextra.getvalor361();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.PAGOPREVIO);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_PAGOPREVIO);
		datoGeneral.setdValorDouble(pago_previoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.INTERESMORA);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_INTERESMORA);
		datoGeneral.setdValorDouble(interes_moraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALORMULTA);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORMULTA);
		datoGeneral.setdValorDouble(valor_multaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.FORMAPAGO1);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_FORMAPAGO1);
		datoGeneral.setdValorDouble(forma_pago1Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.FORMAPAGO2);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_FORMAPAGO2);
		datoGeneral.setdValorDouble(forma_pago2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO1);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO1);
		datoGeneral.setdValorDouble(valor_nota_credito1Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO2);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO2);
		datoGeneral.setdValorDouble(valor_nota_credito2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO3);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO3);
		datoGeneral.setdValorDouble(valor_nota_credito3Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO4);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO4);
		datoGeneral.setdValorDouble(valor_nota_credito4Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE1);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORCOMPROBANTE1);
		datoGeneral.setdValorDouble(valor_comprobante1Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE2);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORCOMPROBANTE2);
		datoGeneral.setdValorDouble(valor_comprobante2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALOR301);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR301);
		datoGeneral.setdValorDouble(valor301Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALOR303);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR303);
		datoGeneral.setdValorDouble(valor303Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALOR305);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR305);
		datoGeneral.setdValorDouble(valor305Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALOR307);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR307);
		datoGeneral.setdValorDouble(valor307Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALOR351);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR351);
		datoGeneral.setdValorDouble(valor351Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALOR355);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR355);
		datoGeneral.setdValorDouble(valor355Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALOR357);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR357);
		datoGeneral.setdValorDouble(valor357Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALOR359);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR359);
		datoGeneral.setdValorDouble(valor359Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaExtraConstantesFunciones.VALOR361);
		datoGeneral.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR361);
		datoGeneral.setdValorDouble(valor361Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFormularioRentaExtra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_ID, FormularioRentaExtraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VERSIONROW, FormularioRentaExtraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_IDEMPRESA, FormularioRentaExtraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_IDEJERCICIO, FormularioRentaExtraConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_IDPERIODO, FormularioRentaExtraConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_IDDATOFORMULARIORENTA, FormularioRentaExtraConstantesFunciones.IDDATOFORMULARIORENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_IDFORMAPAGO, FormularioRentaExtraConstantesFunciones.IDFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_IDBANCO, FormularioRentaExtraConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_PAGOPREVIO, FormularioRentaExtraConstantesFunciones.PAGOPREVIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_INTERESMORA, FormularioRentaExtraConstantesFunciones.INTERESMORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALORMULTA, FormularioRentaExtraConstantesFunciones.VALORMULTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_FORMAPAGO1, FormularioRentaExtraConstantesFunciones.FORMAPAGO1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_FORMAPAGO2, FormularioRentaExtraConstantesFunciones.FORMAPAGO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO1, FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO2, FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO3, FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO4, FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO4,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO1, FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO2, FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO3, FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO4, FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO4,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_NUMEROCOMPROBANTE1, FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_NUMEROCOMPROBANTE2, FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALORCOMPROBANTE1, FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALORCOMPROBANTE2, FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALOR301, FormularioRentaExtraConstantesFunciones.VALOR301,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALOR303, FormularioRentaExtraConstantesFunciones.VALOR303,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALOR305, FormularioRentaExtraConstantesFunciones.VALOR305,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALOR307, FormularioRentaExtraConstantesFunciones.VALOR307,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALOR351, FormularioRentaExtraConstantesFunciones.VALOR351,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALOR355, FormularioRentaExtraConstantesFunciones.VALOR355,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALOR357, FormularioRentaExtraConstantesFunciones.VALOR357,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALOR359, FormularioRentaExtraConstantesFunciones.VALOR359,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaExtraConstantesFunciones.LABEL_VALOR361, FormularioRentaExtraConstantesFunciones.VALOR361,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFormularioRentaExtra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.IDDATOFORMULARIORENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.IDFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.PAGOPREVIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.INTERESMORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALORMULTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.FORMAPAGO1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.FORMAPAGO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO4;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO4;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALOR301;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALOR303;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALOR305;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALOR307;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALOR351;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALOR355;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALOR357;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALOR359;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaExtraConstantesFunciones.VALOR361;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormularioRentaExtra() throws Exception  {
		return FormularioRentaExtraConstantesFunciones.getTiposSeleccionarFormularioRentaExtra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormularioRentaExtra(Boolean conFk) throws Exception  {
		return FormularioRentaExtraConstantesFunciones.getTiposSeleccionarFormularioRentaExtra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormularioRentaExtra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_IDDATOFORMULARIORENTA);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_IDDATOFORMULARIORENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_IDFORMAPAGO);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_IDFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_PAGOPREVIO);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_PAGOPREVIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_INTERESMORA);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_INTERESMORA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALORMULTA);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORMULTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_FORMAPAGO1);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_FORMAPAGO1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_FORMAPAGO2);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_FORMAPAGO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO1);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO2);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO3);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO4);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO1);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO2);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO3);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO4);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_NUMEROCOMPROBANTE1);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_NUMEROCOMPROBANTE1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_NUMEROCOMPROBANTE2);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_NUMEROCOMPROBANTE2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALORCOMPROBANTE1);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORCOMPROBANTE1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALORCOMPROBANTE2);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALORCOMPROBANTE2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALOR301);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR301);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALOR303);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR303);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALOR305);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR305);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALOR307);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR307);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALOR351);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR351);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALOR355);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR355);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALOR357);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR357);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALOR359);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR359);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaExtraConstantesFunciones.LABEL_VALOR361);
			reporte.setsDescripcion(FormularioRentaExtraConstantesFunciones.LABEL_VALOR361);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFormularioRentaExtra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFormularioRentaExtra(FormularioRentaExtra formulariorentaextraAux) throws Exception {
		
			formulariorentaextraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formulariorentaextraAux.getEmpresa()));
			formulariorentaextraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formulariorentaextraAux.getEjercicio()));
			formulariorentaextraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(formulariorentaextraAux.getPeriodo()));
			formulariorentaextraAux.setdatoformulariorenta_descripcion(DatoFormularioRentaConstantesFunciones.getDatoFormularioRentaDescripcion(formulariorentaextraAux.getDatoFormularioRenta()));
			formulariorentaextraAux.setformapago_descripcion(FormaPagoConstantesFunciones.getFormaPagoDescripcion(formulariorentaextraAux.getFormaPago()));
			formulariorentaextraAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(formulariorentaextraAux.getBanco()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFormularioRentaExtra(List<FormularioRentaExtra> formulariorentaextrasTemp) throws Exception {
		for(FormularioRentaExtra formulariorentaextraAux:formulariorentaextrasTemp) {
			
			formulariorentaextraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formulariorentaextraAux.getEmpresa()));
			formulariorentaextraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formulariorentaextraAux.getEjercicio()));
			formulariorentaextraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(formulariorentaextraAux.getPeriodo()));
			formulariorentaextraAux.setdatoformulariorenta_descripcion(DatoFormularioRentaConstantesFunciones.getDatoFormularioRentaDescripcion(formulariorentaextraAux.getDatoFormularioRenta()));
			formulariorentaextraAux.setformapago_descripcion(FormaPagoConstantesFunciones.getFormaPagoDescripcion(formulariorentaextraAux.getFormaPago()));
			formulariorentaextraAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(formulariorentaextraAux.getBanco()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFormularioRentaExtra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(DatoFormularioRenta.class));
				classes.add(new Classe(FormaPago.class));
				classes.add(new Classe(Banco.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
					if(clas.clas.equals(DatoFormularioRenta.class)) {
						classes.add(new Classe(DatoFormularioRenta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormaPago.class)) {
						classes.add(new Classe(FormaPago.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFormularioRentaExtra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(DatoFormularioRenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoFormularioRenta.class)); continue;
					}

					if(FormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPago.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(DatoFormularioRenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoFormularioRenta.class)); continue;
					}

					if(FormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPago.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormularioRentaExtra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormularioRentaExtraConstantesFunciones.getClassesRelationshipsOfFormularioRentaExtra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormularioRentaExtra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormularioRentaExtra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormularioRentaExtraConstantesFunciones.getClassesRelationshipsFromStringsOfFormularioRentaExtra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormularioRentaExtra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FormularioRentaExtra formulariorentaextra,List<FormularioRentaExtra> formulariorentaextras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FormularioRentaExtra formulariorentaextraEncontrado=null;
			
			for(FormularioRentaExtra formulariorentaextraLocal:formulariorentaextras) {
				if(formulariorentaextraLocal.getId().equals(formulariorentaextra.getId())) {
					formulariorentaextraEncontrado=formulariorentaextraLocal;
					
					formulariorentaextraLocal.setIsChanged(formulariorentaextra.getIsChanged());
					formulariorentaextraLocal.setIsNew(formulariorentaextra.getIsNew());
					formulariorentaextraLocal.setIsDeleted(formulariorentaextra.getIsDeleted());
					
					formulariorentaextraLocal.setGeneralEntityOriginal(formulariorentaextra.getGeneralEntityOriginal());
					
					formulariorentaextraLocal.setId(formulariorentaextra.getId());	
					formulariorentaextraLocal.setVersionRow(formulariorentaextra.getVersionRow());	
					formulariorentaextraLocal.setid_empresa(formulariorentaextra.getid_empresa());	
					formulariorentaextraLocal.setid_ejercicio(formulariorentaextra.getid_ejercicio());	
					formulariorentaextraLocal.setid_periodo(formulariorentaextra.getid_periodo());	
					formulariorentaextraLocal.setid_dato_formulario_renta(formulariorentaextra.getid_dato_formulario_renta());	
					formulariorentaextraLocal.setid_forma_pago(formulariorentaextra.getid_forma_pago());	
					formulariorentaextraLocal.setid_banco(formulariorentaextra.getid_banco());	
					formulariorentaextraLocal.setpago_previo(formulariorentaextra.getpago_previo());	
					formulariorentaextraLocal.setinteres_mora(formulariorentaextra.getinteres_mora());	
					formulariorentaextraLocal.setvalor_multa(formulariorentaextra.getvalor_multa());	
					formulariorentaextraLocal.setforma_pago1(formulariorentaextra.getforma_pago1());	
					formulariorentaextraLocal.setforma_pago2(formulariorentaextra.getforma_pago2());	
					formulariorentaextraLocal.setnumero_nota_credito1(formulariorentaextra.getnumero_nota_credito1());	
					formulariorentaextraLocal.setnumero_nota_credito2(formulariorentaextra.getnumero_nota_credito2());	
					formulariorentaextraLocal.setnumero_nota_credito3(formulariorentaextra.getnumero_nota_credito3());	
					formulariorentaextraLocal.setnumero_nota_credito4(formulariorentaextra.getnumero_nota_credito4());	
					formulariorentaextraLocal.setvalor_nota_credito1(formulariorentaextra.getvalor_nota_credito1());	
					formulariorentaextraLocal.setvalor_nota_credito2(formulariorentaextra.getvalor_nota_credito2());	
					formulariorentaextraLocal.setvalor_nota_credito3(formulariorentaextra.getvalor_nota_credito3());	
					formulariorentaextraLocal.setvalor_nota_credito4(formulariorentaextra.getvalor_nota_credito4());	
					formulariorentaextraLocal.setnumero_comprobante1(formulariorentaextra.getnumero_comprobante1());	
					formulariorentaextraLocal.setnumero_comprobante2(formulariorentaextra.getnumero_comprobante2());	
					formulariorentaextraLocal.setvalor_comprobante1(formulariorentaextra.getvalor_comprobante1());	
					formulariorentaextraLocal.setvalor_comprobante2(formulariorentaextra.getvalor_comprobante2());	
					formulariorentaextraLocal.setvalor301(formulariorentaextra.getvalor301());	
					formulariorentaextraLocal.setvalor303(formulariorentaextra.getvalor303());	
					formulariorentaextraLocal.setvalor305(formulariorentaextra.getvalor305());	
					formulariorentaextraLocal.setvalor307(formulariorentaextra.getvalor307());	
					formulariorentaextraLocal.setvalor351(formulariorentaextra.getvalor351());	
					formulariorentaextraLocal.setvalor355(formulariorentaextra.getvalor355());	
					formulariorentaextraLocal.setvalor357(formulariorentaextra.getvalor357());	
					formulariorentaextraLocal.setvalor359(formulariorentaextra.getvalor359());	
					formulariorentaextraLocal.setvalor361(formulariorentaextra.getvalor361());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!formulariorentaextra.getIsDeleted()) {
				if(!existe) {
					formulariorentaextras.add(formulariorentaextra);
				}
			} else {
				if(formulariorentaextraEncontrado!=null && permiteQuitar)  {
					formulariorentaextras.remove(formulariorentaextraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FormularioRentaExtra formulariorentaextra,List<FormularioRentaExtra> formulariorentaextras) throws Exception {
		try	{			
			for(FormularioRentaExtra formulariorentaextraLocal:formulariorentaextras) {
				if(formulariorentaextraLocal.getId().equals(formulariorentaextra.getId())) {
					formulariorentaextraLocal.setIsSelected(formulariorentaextra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFormularioRentaExtra(List<FormularioRentaExtra> formulariorentaextrasAux) throws Exception {
		//this.formulariorentaextrasAux=formulariorentaextrasAux;
		
		for(FormularioRentaExtra formulariorentaextraAux:formulariorentaextrasAux) {
			if(formulariorentaextraAux.getIsChanged()) {
				formulariorentaextraAux.setIsChanged(false);
			}		
			
			if(formulariorentaextraAux.getIsNew()) {
				formulariorentaextraAux.setIsNew(false);
			}	
			
			if(formulariorentaextraAux.getIsDeleted()) {
				formulariorentaextraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFormularioRentaExtra(FormularioRentaExtra formulariorentaextraAux) throws Exception {
		//this.formulariorentaextraAux=formulariorentaextraAux;
		
			if(formulariorentaextraAux.getIsChanged()) {
				formulariorentaextraAux.setIsChanged(false);
			}		
			
			if(formulariorentaextraAux.getIsNew()) {
				formulariorentaextraAux.setIsNew(false);
			}	
			
			if(formulariorentaextraAux.getIsDeleted()) {
				formulariorentaextraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FormularioRentaExtra formulariorentaextraAsignar,FormularioRentaExtra formulariorentaextra) throws Exception {
		formulariorentaextraAsignar.setId(formulariorentaextra.getId());	
		formulariorentaextraAsignar.setVersionRow(formulariorentaextra.getVersionRow());	
		formulariorentaextraAsignar.setid_empresa(formulariorentaextra.getid_empresa());
		formulariorentaextraAsignar.setempresa_descripcion(formulariorentaextra.getempresa_descripcion());	
		formulariorentaextraAsignar.setid_ejercicio(formulariorentaextra.getid_ejercicio());
		formulariorentaextraAsignar.setejercicio_descripcion(formulariorentaextra.getejercicio_descripcion());	
		formulariorentaextraAsignar.setid_periodo(formulariorentaextra.getid_periodo());
		formulariorentaextraAsignar.setperiodo_descripcion(formulariorentaextra.getperiodo_descripcion());	
		formulariorentaextraAsignar.setid_dato_formulario_renta(formulariorentaextra.getid_dato_formulario_renta());
		formulariorentaextraAsignar.setdatoformulariorenta_descripcion(formulariorentaextra.getdatoformulariorenta_descripcion());	
		formulariorentaextraAsignar.setid_forma_pago(formulariorentaextra.getid_forma_pago());
		formulariorentaextraAsignar.setformapago_descripcion(formulariorentaextra.getformapago_descripcion());	
		formulariorentaextraAsignar.setid_banco(formulariorentaextra.getid_banco());
		formulariorentaextraAsignar.setbanco_descripcion(formulariorentaextra.getbanco_descripcion());	
		formulariorentaextraAsignar.setpago_previo(formulariorentaextra.getpago_previo());	
		formulariorentaextraAsignar.setinteres_mora(formulariorentaextra.getinteres_mora());	
		formulariorentaextraAsignar.setvalor_multa(formulariorentaextra.getvalor_multa());	
		formulariorentaextraAsignar.setforma_pago1(formulariorentaextra.getforma_pago1());	
		formulariorentaextraAsignar.setforma_pago2(formulariorentaextra.getforma_pago2());	
		formulariorentaextraAsignar.setnumero_nota_credito1(formulariorentaextra.getnumero_nota_credito1());	
		formulariorentaextraAsignar.setnumero_nota_credito2(formulariorentaextra.getnumero_nota_credito2());	
		formulariorentaextraAsignar.setnumero_nota_credito3(formulariorentaextra.getnumero_nota_credito3());	
		formulariorentaextraAsignar.setnumero_nota_credito4(formulariorentaextra.getnumero_nota_credito4());	
		formulariorentaextraAsignar.setvalor_nota_credito1(formulariorentaextra.getvalor_nota_credito1());	
		formulariorentaextraAsignar.setvalor_nota_credito2(formulariorentaextra.getvalor_nota_credito2());	
		formulariorentaextraAsignar.setvalor_nota_credito3(formulariorentaextra.getvalor_nota_credito3());	
		formulariorentaextraAsignar.setvalor_nota_credito4(formulariorentaextra.getvalor_nota_credito4());	
		formulariorentaextraAsignar.setnumero_comprobante1(formulariorentaextra.getnumero_comprobante1());	
		formulariorentaextraAsignar.setnumero_comprobante2(formulariorentaextra.getnumero_comprobante2());	
		formulariorentaextraAsignar.setvalor_comprobante1(formulariorentaextra.getvalor_comprobante1());	
		formulariorentaextraAsignar.setvalor_comprobante2(formulariorentaextra.getvalor_comprobante2());	
		formulariorentaextraAsignar.setvalor301(formulariorentaextra.getvalor301());	
		formulariorentaextraAsignar.setvalor303(formulariorentaextra.getvalor303());	
		formulariorentaextraAsignar.setvalor305(formulariorentaextra.getvalor305());	
		formulariorentaextraAsignar.setvalor307(formulariorentaextra.getvalor307());	
		formulariorentaextraAsignar.setvalor351(formulariorentaextra.getvalor351());	
		formulariorentaextraAsignar.setvalor355(formulariorentaextra.getvalor355());	
		formulariorentaextraAsignar.setvalor357(formulariorentaextra.getvalor357());	
		formulariorentaextraAsignar.setvalor359(formulariorentaextra.getvalor359());	
		formulariorentaextraAsignar.setvalor361(formulariorentaextra.getvalor361());	
	}
	
	public static void inicializarFormularioRentaExtra(FormularioRentaExtra formulariorentaextra) throws Exception {
		try {
				formulariorentaextra.setId(0L);	
					
				formulariorentaextra.setid_empresa(-1L);	
				formulariorentaextra.setid_ejercicio(-1L);	
				formulariorentaextra.setid_periodo(-1L);	
				formulariorentaextra.setid_dato_formulario_renta(-1L);	
				formulariorentaextra.setid_forma_pago(-1L);	
				formulariorentaextra.setid_banco(-1L);	
				formulariorentaextra.setpago_previo(0.0);	
				formulariorentaextra.setinteres_mora(0.0);	
				formulariorentaextra.setvalor_multa(0.0);	
				formulariorentaextra.setforma_pago1(0.0);	
				formulariorentaextra.setforma_pago2(0.0);	
				formulariorentaextra.setnumero_nota_credito1("");	
				formulariorentaextra.setnumero_nota_credito2("");	
				formulariorentaextra.setnumero_nota_credito3("");	
				formulariorentaextra.setnumero_nota_credito4("");	
				formulariorentaextra.setvalor_nota_credito1(0.0);	
				formulariorentaextra.setvalor_nota_credito2(0.0);	
				formulariorentaextra.setvalor_nota_credito3(0.0);	
				formulariorentaextra.setvalor_nota_credito4(0.0);	
				formulariorentaextra.setnumero_comprobante1("");	
				formulariorentaextra.setnumero_comprobante2("");	
				formulariorentaextra.setvalor_comprobante1(0.0);	
				formulariorentaextra.setvalor_comprobante2(0.0);	
				formulariorentaextra.setvalor301(0.0);	
				formulariorentaextra.setvalor303(0.0);	
				formulariorentaextra.setvalor305(0.0);	
				formulariorentaextra.setvalor307(0.0);	
				formulariorentaextra.setvalor351(0.0);	
				formulariorentaextra.setvalor355(0.0);	
				formulariorentaextra.setvalor357(0.0);	
				formulariorentaextra.setvalor359(0.0);	
				formulariorentaextra.setvalor361(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFormularioRentaExtra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_IDDATOFORMULARIORENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_IDFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_PAGOPREVIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_INTERESMORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALORMULTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_FORMAPAGO1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_FORMAPAGO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_NUMERONOTACREDITO4);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALORNOTACREDITO4);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_NUMEROCOMPROBANTE1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_NUMEROCOMPROBANTE2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALORCOMPROBANTE1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALORCOMPROBANTE2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALOR301);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALOR303);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALOR305);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALOR307);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALOR351);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALOR355);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALOR357);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALOR359);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaExtraConstantesFunciones.LABEL_VALOR361);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFormularioRentaExtra(String sTipo,Row row,Workbook workbook,FormularioRentaExtra formulariorentaextra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getdatoformulariorenta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getpago_previo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getinteres_mora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor_multa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getforma_pago1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getforma_pago2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getnumero_nota_credito1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getnumero_nota_credito2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getnumero_nota_credito3());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getnumero_nota_credito4());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor_nota_credito1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor_nota_credito2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor_nota_credito3());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor_nota_credito4());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getnumero_comprobante1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getnumero_comprobante2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor_comprobante1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor_comprobante2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor301());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor303());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor305());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor307());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor351());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor355());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor357());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor359());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorentaextra.getvalor361());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFormularioRentaExtra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFormularioRentaExtra() {
		return this.sFinalQueryFormularioRentaExtra;
	}
	
	public void setsFinalQueryFormularioRentaExtra(String sFinalQueryFormularioRentaExtra) {
		this.sFinalQueryFormularioRentaExtra= sFinalQueryFormularioRentaExtra;
	}
	
	public Border resaltarSeleccionarFormularioRentaExtra=null;
	
	public Border setResaltarSeleccionarFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFormularioRentaExtra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFormularioRentaExtra() {
		return this.resaltarSeleccionarFormularioRentaExtra;
	}
	
	public void setResaltarSeleccionarFormularioRentaExtra(Border borderResaltarSeleccionarFormularioRentaExtra) {
		this.resaltarSeleccionarFormularioRentaExtra= borderResaltarSeleccionarFormularioRentaExtra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFormularioRentaExtra=null;
	public Boolean mostraridFormularioRentaExtra=true;
	public Boolean activaridFormularioRentaExtra=true;

	public Border resaltarid_empresaFormularioRentaExtra=null;
	public Boolean mostrarid_empresaFormularioRentaExtra=true;
	public Boolean activarid_empresaFormularioRentaExtra=true;
	public Boolean cargarid_empresaFormularioRentaExtra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFormularioRentaExtra=false;//ConEventDepend=true

	public Border resaltarid_ejercicioFormularioRentaExtra=null;
	public Boolean mostrarid_ejercicioFormularioRentaExtra=true;
	public Boolean activarid_ejercicioFormularioRentaExtra=true;
	public Boolean cargarid_ejercicioFormularioRentaExtra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioFormularioRentaExtra=false;//ConEventDepend=true

	public Border resaltarid_periodoFormularioRentaExtra=null;
	public Boolean mostrarid_periodoFormularioRentaExtra=true;
	public Boolean activarid_periodoFormularioRentaExtra=true;
	public Boolean cargarid_periodoFormularioRentaExtra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoFormularioRentaExtra=false;//ConEventDepend=true

	public Border resaltarid_dato_formulario_rentaFormularioRentaExtra=null;
	public Boolean mostrarid_dato_formulario_rentaFormularioRentaExtra=true;
	public Boolean activarid_dato_formulario_rentaFormularioRentaExtra=true;
	public Boolean cargarid_dato_formulario_rentaFormularioRentaExtra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_dato_formulario_rentaFormularioRentaExtra=false;//ConEventDepend=true

	public Border resaltarid_forma_pagoFormularioRentaExtra=null;
	public Boolean mostrarid_forma_pagoFormularioRentaExtra=true;
	public Boolean activarid_forma_pagoFormularioRentaExtra=true;
	public Boolean cargarid_forma_pagoFormularioRentaExtra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_forma_pagoFormularioRentaExtra=false;//ConEventDepend=true

	public Border resaltarid_bancoFormularioRentaExtra=null;
	public Boolean mostrarid_bancoFormularioRentaExtra=true;
	public Boolean activarid_bancoFormularioRentaExtra=true;
	public Boolean cargarid_bancoFormularioRentaExtra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoFormularioRentaExtra=false;//ConEventDepend=true

	public Border resaltarpago_previoFormularioRentaExtra=null;
	public Boolean mostrarpago_previoFormularioRentaExtra=true;
	public Boolean activarpago_previoFormularioRentaExtra=true;

	public Border resaltarinteres_moraFormularioRentaExtra=null;
	public Boolean mostrarinteres_moraFormularioRentaExtra=true;
	public Boolean activarinteres_moraFormularioRentaExtra=true;

	public Border resaltarvalor_multaFormularioRentaExtra=null;
	public Boolean mostrarvalor_multaFormularioRentaExtra=true;
	public Boolean activarvalor_multaFormularioRentaExtra=true;

	public Border resaltarforma_pago1FormularioRentaExtra=null;
	public Boolean mostrarforma_pago1FormularioRentaExtra=true;
	public Boolean activarforma_pago1FormularioRentaExtra=true;

	public Border resaltarforma_pago2FormularioRentaExtra=null;
	public Boolean mostrarforma_pago2FormularioRentaExtra=true;
	public Boolean activarforma_pago2FormularioRentaExtra=true;

	public Border resaltarnumero_nota_credito1FormularioRentaExtra=null;
	public Boolean mostrarnumero_nota_credito1FormularioRentaExtra=true;
	public Boolean activarnumero_nota_credito1FormularioRentaExtra=true;

	public Border resaltarnumero_nota_credito2FormularioRentaExtra=null;
	public Boolean mostrarnumero_nota_credito2FormularioRentaExtra=true;
	public Boolean activarnumero_nota_credito2FormularioRentaExtra=true;

	public Border resaltarnumero_nota_credito3FormularioRentaExtra=null;
	public Boolean mostrarnumero_nota_credito3FormularioRentaExtra=true;
	public Boolean activarnumero_nota_credito3FormularioRentaExtra=true;

	public Border resaltarnumero_nota_credito4FormularioRentaExtra=null;
	public Boolean mostrarnumero_nota_credito4FormularioRentaExtra=true;
	public Boolean activarnumero_nota_credito4FormularioRentaExtra=true;

	public Border resaltarvalor_nota_credito1FormularioRentaExtra=null;
	public Boolean mostrarvalor_nota_credito1FormularioRentaExtra=true;
	public Boolean activarvalor_nota_credito1FormularioRentaExtra=true;

	public Border resaltarvalor_nota_credito2FormularioRentaExtra=null;
	public Boolean mostrarvalor_nota_credito2FormularioRentaExtra=true;
	public Boolean activarvalor_nota_credito2FormularioRentaExtra=true;

	public Border resaltarvalor_nota_credito3FormularioRentaExtra=null;
	public Boolean mostrarvalor_nota_credito3FormularioRentaExtra=true;
	public Boolean activarvalor_nota_credito3FormularioRentaExtra=true;

	public Border resaltarvalor_nota_credito4FormularioRentaExtra=null;
	public Boolean mostrarvalor_nota_credito4FormularioRentaExtra=true;
	public Boolean activarvalor_nota_credito4FormularioRentaExtra=true;

	public Border resaltarnumero_comprobante1FormularioRentaExtra=null;
	public Boolean mostrarnumero_comprobante1FormularioRentaExtra=true;
	public Boolean activarnumero_comprobante1FormularioRentaExtra=true;

	public Border resaltarnumero_comprobante2FormularioRentaExtra=null;
	public Boolean mostrarnumero_comprobante2FormularioRentaExtra=true;
	public Boolean activarnumero_comprobante2FormularioRentaExtra=true;

	public Border resaltarvalor_comprobante1FormularioRentaExtra=null;
	public Boolean mostrarvalor_comprobante1FormularioRentaExtra=true;
	public Boolean activarvalor_comprobante1FormularioRentaExtra=true;

	public Border resaltarvalor_comprobante2FormularioRentaExtra=null;
	public Boolean mostrarvalor_comprobante2FormularioRentaExtra=true;
	public Boolean activarvalor_comprobante2FormularioRentaExtra=true;

	public Border resaltarvalor301FormularioRentaExtra=null;
	public Boolean mostrarvalor301FormularioRentaExtra=true;
	public Boolean activarvalor301FormularioRentaExtra=true;

	public Border resaltarvalor303FormularioRentaExtra=null;
	public Boolean mostrarvalor303FormularioRentaExtra=true;
	public Boolean activarvalor303FormularioRentaExtra=true;

	public Border resaltarvalor305FormularioRentaExtra=null;
	public Boolean mostrarvalor305FormularioRentaExtra=true;
	public Boolean activarvalor305FormularioRentaExtra=true;

	public Border resaltarvalor307FormularioRentaExtra=null;
	public Boolean mostrarvalor307FormularioRentaExtra=true;
	public Boolean activarvalor307FormularioRentaExtra=true;

	public Border resaltarvalor351FormularioRentaExtra=null;
	public Boolean mostrarvalor351FormularioRentaExtra=true;
	public Boolean activarvalor351FormularioRentaExtra=true;

	public Border resaltarvalor355FormularioRentaExtra=null;
	public Boolean mostrarvalor355FormularioRentaExtra=true;
	public Boolean activarvalor355FormularioRentaExtra=true;

	public Border resaltarvalor357FormularioRentaExtra=null;
	public Boolean mostrarvalor357FormularioRentaExtra=true;
	public Boolean activarvalor357FormularioRentaExtra=true;

	public Border resaltarvalor359FormularioRentaExtra=null;
	public Boolean mostrarvalor359FormularioRentaExtra=true;
	public Boolean activarvalor359FormularioRentaExtra=true;

	public Border resaltarvalor361FormularioRentaExtra=null;
	public Boolean mostrarvalor361FormularioRentaExtra=true;
	public Boolean activarvalor361FormularioRentaExtra=true;

	
	

	public Border setResaltaridFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltaridFormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFormularioRentaExtra() {
		return this.resaltaridFormularioRentaExtra;
	}

	public void setResaltaridFormularioRentaExtra(Border borderResaltar) {
		this.resaltaridFormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostraridFormularioRentaExtra() {
		return this.mostraridFormularioRentaExtra;
	}

	public void setMostraridFormularioRentaExtra(Boolean mostraridFormularioRentaExtra) {
		this.mostraridFormularioRentaExtra= mostraridFormularioRentaExtra;
	}

	public Boolean getActivaridFormularioRentaExtra() {
		return this.activaridFormularioRentaExtra;
	}

	public void setActivaridFormularioRentaExtra(Boolean activaridFormularioRentaExtra) {
		this.activaridFormularioRentaExtra= activaridFormularioRentaExtra;
	}

	public Border setResaltarid_empresaFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarid_empresaFormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFormularioRentaExtra() {
		return this.resaltarid_empresaFormularioRentaExtra;
	}

	public void setResaltarid_empresaFormularioRentaExtra(Border borderResaltar) {
		this.resaltarid_empresaFormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarid_empresaFormularioRentaExtra() {
		return this.mostrarid_empresaFormularioRentaExtra;
	}

	public void setMostrarid_empresaFormularioRentaExtra(Boolean mostrarid_empresaFormularioRentaExtra) {
		this.mostrarid_empresaFormularioRentaExtra= mostrarid_empresaFormularioRentaExtra;
	}

	public Boolean getActivarid_empresaFormularioRentaExtra() {
		return this.activarid_empresaFormularioRentaExtra;
	}

	public void setActivarid_empresaFormularioRentaExtra(Boolean activarid_empresaFormularioRentaExtra) {
		this.activarid_empresaFormularioRentaExtra= activarid_empresaFormularioRentaExtra;
	}

	public Boolean getCargarid_empresaFormularioRentaExtra() {
		return this.cargarid_empresaFormularioRentaExtra;
	}

	public void setCargarid_empresaFormularioRentaExtra(Boolean cargarid_empresaFormularioRentaExtra) {
		this.cargarid_empresaFormularioRentaExtra= cargarid_empresaFormularioRentaExtra;
	}

	public Border setResaltarid_ejercicioFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioFormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioFormularioRentaExtra() {
		return this.resaltarid_ejercicioFormularioRentaExtra;
	}

	public void setResaltarid_ejercicioFormularioRentaExtra(Border borderResaltar) {
		this.resaltarid_ejercicioFormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioFormularioRentaExtra() {
		return this.mostrarid_ejercicioFormularioRentaExtra;
	}

	public void setMostrarid_ejercicioFormularioRentaExtra(Boolean mostrarid_ejercicioFormularioRentaExtra) {
		this.mostrarid_ejercicioFormularioRentaExtra= mostrarid_ejercicioFormularioRentaExtra;
	}

	public Boolean getActivarid_ejercicioFormularioRentaExtra() {
		return this.activarid_ejercicioFormularioRentaExtra;
	}

	public void setActivarid_ejercicioFormularioRentaExtra(Boolean activarid_ejercicioFormularioRentaExtra) {
		this.activarid_ejercicioFormularioRentaExtra= activarid_ejercicioFormularioRentaExtra;
	}

	public Boolean getCargarid_ejercicioFormularioRentaExtra() {
		return this.cargarid_ejercicioFormularioRentaExtra;
	}

	public void setCargarid_ejercicioFormularioRentaExtra(Boolean cargarid_ejercicioFormularioRentaExtra) {
		this.cargarid_ejercicioFormularioRentaExtra= cargarid_ejercicioFormularioRentaExtra;
	}

	public Border setResaltarid_periodoFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarid_periodoFormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoFormularioRentaExtra() {
		return this.resaltarid_periodoFormularioRentaExtra;
	}

	public void setResaltarid_periodoFormularioRentaExtra(Border borderResaltar) {
		this.resaltarid_periodoFormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarid_periodoFormularioRentaExtra() {
		return this.mostrarid_periodoFormularioRentaExtra;
	}

	public void setMostrarid_periodoFormularioRentaExtra(Boolean mostrarid_periodoFormularioRentaExtra) {
		this.mostrarid_periodoFormularioRentaExtra= mostrarid_periodoFormularioRentaExtra;
	}

	public Boolean getActivarid_periodoFormularioRentaExtra() {
		return this.activarid_periodoFormularioRentaExtra;
	}

	public void setActivarid_periodoFormularioRentaExtra(Boolean activarid_periodoFormularioRentaExtra) {
		this.activarid_periodoFormularioRentaExtra= activarid_periodoFormularioRentaExtra;
	}

	public Boolean getCargarid_periodoFormularioRentaExtra() {
		return this.cargarid_periodoFormularioRentaExtra;
	}

	public void setCargarid_periodoFormularioRentaExtra(Boolean cargarid_periodoFormularioRentaExtra) {
		this.cargarid_periodoFormularioRentaExtra= cargarid_periodoFormularioRentaExtra;
	}

	public Border setResaltarid_dato_formulario_rentaFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarid_dato_formulario_rentaFormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_dato_formulario_rentaFormularioRentaExtra() {
		return this.resaltarid_dato_formulario_rentaFormularioRentaExtra;
	}

	public void setResaltarid_dato_formulario_rentaFormularioRentaExtra(Border borderResaltar) {
		this.resaltarid_dato_formulario_rentaFormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarid_dato_formulario_rentaFormularioRentaExtra() {
		return this.mostrarid_dato_formulario_rentaFormularioRentaExtra;
	}

	public void setMostrarid_dato_formulario_rentaFormularioRentaExtra(Boolean mostrarid_dato_formulario_rentaFormularioRentaExtra) {
		this.mostrarid_dato_formulario_rentaFormularioRentaExtra= mostrarid_dato_formulario_rentaFormularioRentaExtra;
	}

	public Boolean getActivarid_dato_formulario_rentaFormularioRentaExtra() {
		return this.activarid_dato_formulario_rentaFormularioRentaExtra;
	}

	public void setActivarid_dato_formulario_rentaFormularioRentaExtra(Boolean activarid_dato_formulario_rentaFormularioRentaExtra) {
		this.activarid_dato_formulario_rentaFormularioRentaExtra= activarid_dato_formulario_rentaFormularioRentaExtra;
	}

	public Boolean getCargarid_dato_formulario_rentaFormularioRentaExtra() {
		return this.cargarid_dato_formulario_rentaFormularioRentaExtra;
	}

	public void setCargarid_dato_formulario_rentaFormularioRentaExtra(Boolean cargarid_dato_formulario_rentaFormularioRentaExtra) {
		this.cargarid_dato_formulario_rentaFormularioRentaExtra= cargarid_dato_formulario_rentaFormularioRentaExtra;
	}

	public Border setResaltarid_forma_pagoFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarid_forma_pagoFormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_forma_pagoFormularioRentaExtra() {
		return this.resaltarid_forma_pagoFormularioRentaExtra;
	}

	public void setResaltarid_forma_pagoFormularioRentaExtra(Border borderResaltar) {
		this.resaltarid_forma_pagoFormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarid_forma_pagoFormularioRentaExtra() {
		return this.mostrarid_forma_pagoFormularioRentaExtra;
	}

	public void setMostrarid_forma_pagoFormularioRentaExtra(Boolean mostrarid_forma_pagoFormularioRentaExtra) {
		this.mostrarid_forma_pagoFormularioRentaExtra= mostrarid_forma_pagoFormularioRentaExtra;
	}

	public Boolean getActivarid_forma_pagoFormularioRentaExtra() {
		return this.activarid_forma_pagoFormularioRentaExtra;
	}

	public void setActivarid_forma_pagoFormularioRentaExtra(Boolean activarid_forma_pagoFormularioRentaExtra) {
		this.activarid_forma_pagoFormularioRentaExtra= activarid_forma_pagoFormularioRentaExtra;
	}

	public Boolean getCargarid_forma_pagoFormularioRentaExtra() {
		return this.cargarid_forma_pagoFormularioRentaExtra;
	}

	public void setCargarid_forma_pagoFormularioRentaExtra(Boolean cargarid_forma_pagoFormularioRentaExtra) {
		this.cargarid_forma_pagoFormularioRentaExtra= cargarid_forma_pagoFormularioRentaExtra;
	}

	public Border setResaltarid_bancoFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarid_bancoFormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoFormularioRentaExtra() {
		return this.resaltarid_bancoFormularioRentaExtra;
	}

	public void setResaltarid_bancoFormularioRentaExtra(Border borderResaltar) {
		this.resaltarid_bancoFormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarid_bancoFormularioRentaExtra() {
		return this.mostrarid_bancoFormularioRentaExtra;
	}

	public void setMostrarid_bancoFormularioRentaExtra(Boolean mostrarid_bancoFormularioRentaExtra) {
		this.mostrarid_bancoFormularioRentaExtra= mostrarid_bancoFormularioRentaExtra;
	}

	public Boolean getActivarid_bancoFormularioRentaExtra() {
		return this.activarid_bancoFormularioRentaExtra;
	}

	public void setActivarid_bancoFormularioRentaExtra(Boolean activarid_bancoFormularioRentaExtra) {
		this.activarid_bancoFormularioRentaExtra= activarid_bancoFormularioRentaExtra;
	}

	public Boolean getCargarid_bancoFormularioRentaExtra() {
		return this.cargarid_bancoFormularioRentaExtra;
	}

	public void setCargarid_bancoFormularioRentaExtra(Boolean cargarid_bancoFormularioRentaExtra) {
		this.cargarid_bancoFormularioRentaExtra= cargarid_bancoFormularioRentaExtra;
	}

	public Border setResaltarpago_previoFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarpago_previoFormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpago_previoFormularioRentaExtra() {
		return this.resaltarpago_previoFormularioRentaExtra;
	}

	public void setResaltarpago_previoFormularioRentaExtra(Border borderResaltar) {
		this.resaltarpago_previoFormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarpago_previoFormularioRentaExtra() {
		return this.mostrarpago_previoFormularioRentaExtra;
	}

	public void setMostrarpago_previoFormularioRentaExtra(Boolean mostrarpago_previoFormularioRentaExtra) {
		this.mostrarpago_previoFormularioRentaExtra= mostrarpago_previoFormularioRentaExtra;
	}

	public Boolean getActivarpago_previoFormularioRentaExtra() {
		return this.activarpago_previoFormularioRentaExtra;
	}

	public void setActivarpago_previoFormularioRentaExtra(Boolean activarpago_previoFormularioRentaExtra) {
		this.activarpago_previoFormularioRentaExtra= activarpago_previoFormularioRentaExtra;
	}

	public Border setResaltarinteres_moraFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarinteres_moraFormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarinteres_moraFormularioRentaExtra() {
		return this.resaltarinteres_moraFormularioRentaExtra;
	}

	public void setResaltarinteres_moraFormularioRentaExtra(Border borderResaltar) {
		this.resaltarinteres_moraFormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarinteres_moraFormularioRentaExtra() {
		return this.mostrarinteres_moraFormularioRentaExtra;
	}

	public void setMostrarinteres_moraFormularioRentaExtra(Boolean mostrarinteres_moraFormularioRentaExtra) {
		this.mostrarinteres_moraFormularioRentaExtra= mostrarinteres_moraFormularioRentaExtra;
	}

	public Boolean getActivarinteres_moraFormularioRentaExtra() {
		return this.activarinteres_moraFormularioRentaExtra;
	}

	public void setActivarinteres_moraFormularioRentaExtra(Boolean activarinteres_moraFormularioRentaExtra) {
		this.activarinteres_moraFormularioRentaExtra= activarinteres_moraFormularioRentaExtra;
	}

	public Border setResaltarvalor_multaFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor_multaFormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_multaFormularioRentaExtra() {
		return this.resaltarvalor_multaFormularioRentaExtra;
	}

	public void setResaltarvalor_multaFormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor_multaFormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor_multaFormularioRentaExtra() {
		return this.mostrarvalor_multaFormularioRentaExtra;
	}

	public void setMostrarvalor_multaFormularioRentaExtra(Boolean mostrarvalor_multaFormularioRentaExtra) {
		this.mostrarvalor_multaFormularioRentaExtra= mostrarvalor_multaFormularioRentaExtra;
	}

	public Boolean getActivarvalor_multaFormularioRentaExtra() {
		return this.activarvalor_multaFormularioRentaExtra;
	}

	public void setActivarvalor_multaFormularioRentaExtra(Boolean activarvalor_multaFormularioRentaExtra) {
		this.activarvalor_multaFormularioRentaExtra= activarvalor_multaFormularioRentaExtra;
	}

	public Border setResaltarforma_pago1FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarforma_pago1FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarforma_pago1FormularioRentaExtra() {
		return this.resaltarforma_pago1FormularioRentaExtra;
	}

	public void setResaltarforma_pago1FormularioRentaExtra(Border borderResaltar) {
		this.resaltarforma_pago1FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarforma_pago1FormularioRentaExtra() {
		return this.mostrarforma_pago1FormularioRentaExtra;
	}

	public void setMostrarforma_pago1FormularioRentaExtra(Boolean mostrarforma_pago1FormularioRentaExtra) {
		this.mostrarforma_pago1FormularioRentaExtra= mostrarforma_pago1FormularioRentaExtra;
	}

	public Boolean getActivarforma_pago1FormularioRentaExtra() {
		return this.activarforma_pago1FormularioRentaExtra;
	}

	public void setActivarforma_pago1FormularioRentaExtra(Boolean activarforma_pago1FormularioRentaExtra) {
		this.activarforma_pago1FormularioRentaExtra= activarforma_pago1FormularioRentaExtra;
	}

	public Border setResaltarforma_pago2FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarforma_pago2FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarforma_pago2FormularioRentaExtra() {
		return this.resaltarforma_pago2FormularioRentaExtra;
	}

	public void setResaltarforma_pago2FormularioRentaExtra(Border borderResaltar) {
		this.resaltarforma_pago2FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarforma_pago2FormularioRentaExtra() {
		return this.mostrarforma_pago2FormularioRentaExtra;
	}

	public void setMostrarforma_pago2FormularioRentaExtra(Boolean mostrarforma_pago2FormularioRentaExtra) {
		this.mostrarforma_pago2FormularioRentaExtra= mostrarforma_pago2FormularioRentaExtra;
	}

	public Boolean getActivarforma_pago2FormularioRentaExtra() {
		return this.activarforma_pago2FormularioRentaExtra;
	}

	public void setActivarforma_pago2FormularioRentaExtra(Boolean activarforma_pago2FormularioRentaExtra) {
		this.activarforma_pago2FormularioRentaExtra= activarforma_pago2FormularioRentaExtra;
	}

	public Border setResaltarnumero_nota_credito1FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarnumero_nota_credito1FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_nota_credito1FormularioRentaExtra() {
		return this.resaltarnumero_nota_credito1FormularioRentaExtra;
	}

	public void setResaltarnumero_nota_credito1FormularioRentaExtra(Border borderResaltar) {
		this.resaltarnumero_nota_credito1FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarnumero_nota_credito1FormularioRentaExtra() {
		return this.mostrarnumero_nota_credito1FormularioRentaExtra;
	}

	public void setMostrarnumero_nota_credito1FormularioRentaExtra(Boolean mostrarnumero_nota_credito1FormularioRentaExtra) {
		this.mostrarnumero_nota_credito1FormularioRentaExtra= mostrarnumero_nota_credito1FormularioRentaExtra;
	}

	public Boolean getActivarnumero_nota_credito1FormularioRentaExtra() {
		return this.activarnumero_nota_credito1FormularioRentaExtra;
	}

	public void setActivarnumero_nota_credito1FormularioRentaExtra(Boolean activarnumero_nota_credito1FormularioRentaExtra) {
		this.activarnumero_nota_credito1FormularioRentaExtra= activarnumero_nota_credito1FormularioRentaExtra;
	}

	public Border setResaltarnumero_nota_credito2FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarnumero_nota_credito2FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_nota_credito2FormularioRentaExtra() {
		return this.resaltarnumero_nota_credito2FormularioRentaExtra;
	}

	public void setResaltarnumero_nota_credito2FormularioRentaExtra(Border borderResaltar) {
		this.resaltarnumero_nota_credito2FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarnumero_nota_credito2FormularioRentaExtra() {
		return this.mostrarnumero_nota_credito2FormularioRentaExtra;
	}

	public void setMostrarnumero_nota_credito2FormularioRentaExtra(Boolean mostrarnumero_nota_credito2FormularioRentaExtra) {
		this.mostrarnumero_nota_credito2FormularioRentaExtra= mostrarnumero_nota_credito2FormularioRentaExtra;
	}

	public Boolean getActivarnumero_nota_credito2FormularioRentaExtra() {
		return this.activarnumero_nota_credito2FormularioRentaExtra;
	}

	public void setActivarnumero_nota_credito2FormularioRentaExtra(Boolean activarnumero_nota_credito2FormularioRentaExtra) {
		this.activarnumero_nota_credito2FormularioRentaExtra= activarnumero_nota_credito2FormularioRentaExtra;
	}

	public Border setResaltarnumero_nota_credito3FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarnumero_nota_credito3FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_nota_credito3FormularioRentaExtra() {
		return this.resaltarnumero_nota_credito3FormularioRentaExtra;
	}

	public void setResaltarnumero_nota_credito3FormularioRentaExtra(Border borderResaltar) {
		this.resaltarnumero_nota_credito3FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarnumero_nota_credito3FormularioRentaExtra() {
		return this.mostrarnumero_nota_credito3FormularioRentaExtra;
	}

	public void setMostrarnumero_nota_credito3FormularioRentaExtra(Boolean mostrarnumero_nota_credito3FormularioRentaExtra) {
		this.mostrarnumero_nota_credito3FormularioRentaExtra= mostrarnumero_nota_credito3FormularioRentaExtra;
	}

	public Boolean getActivarnumero_nota_credito3FormularioRentaExtra() {
		return this.activarnumero_nota_credito3FormularioRentaExtra;
	}

	public void setActivarnumero_nota_credito3FormularioRentaExtra(Boolean activarnumero_nota_credito3FormularioRentaExtra) {
		this.activarnumero_nota_credito3FormularioRentaExtra= activarnumero_nota_credito3FormularioRentaExtra;
	}

	public Border setResaltarnumero_nota_credito4FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarnumero_nota_credito4FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_nota_credito4FormularioRentaExtra() {
		return this.resaltarnumero_nota_credito4FormularioRentaExtra;
	}

	public void setResaltarnumero_nota_credito4FormularioRentaExtra(Border borderResaltar) {
		this.resaltarnumero_nota_credito4FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarnumero_nota_credito4FormularioRentaExtra() {
		return this.mostrarnumero_nota_credito4FormularioRentaExtra;
	}

	public void setMostrarnumero_nota_credito4FormularioRentaExtra(Boolean mostrarnumero_nota_credito4FormularioRentaExtra) {
		this.mostrarnumero_nota_credito4FormularioRentaExtra= mostrarnumero_nota_credito4FormularioRentaExtra;
	}

	public Boolean getActivarnumero_nota_credito4FormularioRentaExtra() {
		return this.activarnumero_nota_credito4FormularioRentaExtra;
	}

	public void setActivarnumero_nota_credito4FormularioRentaExtra(Boolean activarnumero_nota_credito4FormularioRentaExtra) {
		this.activarnumero_nota_credito4FormularioRentaExtra= activarnumero_nota_credito4FormularioRentaExtra;
	}

	public Border setResaltarvalor_nota_credito1FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor_nota_credito1FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_nota_credito1FormularioRentaExtra() {
		return this.resaltarvalor_nota_credito1FormularioRentaExtra;
	}

	public void setResaltarvalor_nota_credito1FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor_nota_credito1FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor_nota_credito1FormularioRentaExtra() {
		return this.mostrarvalor_nota_credito1FormularioRentaExtra;
	}

	public void setMostrarvalor_nota_credito1FormularioRentaExtra(Boolean mostrarvalor_nota_credito1FormularioRentaExtra) {
		this.mostrarvalor_nota_credito1FormularioRentaExtra= mostrarvalor_nota_credito1FormularioRentaExtra;
	}

	public Boolean getActivarvalor_nota_credito1FormularioRentaExtra() {
		return this.activarvalor_nota_credito1FormularioRentaExtra;
	}

	public void setActivarvalor_nota_credito1FormularioRentaExtra(Boolean activarvalor_nota_credito1FormularioRentaExtra) {
		this.activarvalor_nota_credito1FormularioRentaExtra= activarvalor_nota_credito1FormularioRentaExtra;
	}

	public Border setResaltarvalor_nota_credito2FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor_nota_credito2FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_nota_credito2FormularioRentaExtra() {
		return this.resaltarvalor_nota_credito2FormularioRentaExtra;
	}

	public void setResaltarvalor_nota_credito2FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor_nota_credito2FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor_nota_credito2FormularioRentaExtra() {
		return this.mostrarvalor_nota_credito2FormularioRentaExtra;
	}

	public void setMostrarvalor_nota_credito2FormularioRentaExtra(Boolean mostrarvalor_nota_credito2FormularioRentaExtra) {
		this.mostrarvalor_nota_credito2FormularioRentaExtra= mostrarvalor_nota_credito2FormularioRentaExtra;
	}

	public Boolean getActivarvalor_nota_credito2FormularioRentaExtra() {
		return this.activarvalor_nota_credito2FormularioRentaExtra;
	}

	public void setActivarvalor_nota_credito2FormularioRentaExtra(Boolean activarvalor_nota_credito2FormularioRentaExtra) {
		this.activarvalor_nota_credito2FormularioRentaExtra= activarvalor_nota_credito2FormularioRentaExtra;
	}

	public Border setResaltarvalor_nota_credito3FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor_nota_credito3FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_nota_credito3FormularioRentaExtra() {
		return this.resaltarvalor_nota_credito3FormularioRentaExtra;
	}

	public void setResaltarvalor_nota_credito3FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor_nota_credito3FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor_nota_credito3FormularioRentaExtra() {
		return this.mostrarvalor_nota_credito3FormularioRentaExtra;
	}

	public void setMostrarvalor_nota_credito3FormularioRentaExtra(Boolean mostrarvalor_nota_credito3FormularioRentaExtra) {
		this.mostrarvalor_nota_credito3FormularioRentaExtra= mostrarvalor_nota_credito3FormularioRentaExtra;
	}

	public Boolean getActivarvalor_nota_credito3FormularioRentaExtra() {
		return this.activarvalor_nota_credito3FormularioRentaExtra;
	}

	public void setActivarvalor_nota_credito3FormularioRentaExtra(Boolean activarvalor_nota_credito3FormularioRentaExtra) {
		this.activarvalor_nota_credito3FormularioRentaExtra= activarvalor_nota_credito3FormularioRentaExtra;
	}

	public Border setResaltarvalor_nota_credito4FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor_nota_credito4FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_nota_credito4FormularioRentaExtra() {
		return this.resaltarvalor_nota_credito4FormularioRentaExtra;
	}

	public void setResaltarvalor_nota_credito4FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor_nota_credito4FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor_nota_credito4FormularioRentaExtra() {
		return this.mostrarvalor_nota_credito4FormularioRentaExtra;
	}

	public void setMostrarvalor_nota_credito4FormularioRentaExtra(Boolean mostrarvalor_nota_credito4FormularioRentaExtra) {
		this.mostrarvalor_nota_credito4FormularioRentaExtra= mostrarvalor_nota_credito4FormularioRentaExtra;
	}

	public Boolean getActivarvalor_nota_credito4FormularioRentaExtra() {
		return this.activarvalor_nota_credito4FormularioRentaExtra;
	}

	public void setActivarvalor_nota_credito4FormularioRentaExtra(Boolean activarvalor_nota_credito4FormularioRentaExtra) {
		this.activarvalor_nota_credito4FormularioRentaExtra= activarvalor_nota_credito4FormularioRentaExtra;
	}

	public Border setResaltarnumero_comprobante1FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobante1FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobante1FormularioRentaExtra() {
		return this.resaltarnumero_comprobante1FormularioRentaExtra;
	}

	public void setResaltarnumero_comprobante1FormularioRentaExtra(Border borderResaltar) {
		this.resaltarnumero_comprobante1FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobante1FormularioRentaExtra() {
		return this.mostrarnumero_comprobante1FormularioRentaExtra;
	}

	public void setMostrarnumero_comprobante1FormularioRentaExtra(Boolean mostrarnumero_comprobante1FormularioRentaExtra) {
		this.mostrarnumero_comprobante1FormularioRentaExtra= mostrarnumero_comprobante1FormularioRentaExtra;
	}

	public Boolean getActivarnumero_comprobante1FormularioRentaExtra() {
		return this.activarnumero_comprobante1FormularioRentaExtra;
	}

	public void setActivarnumero_comprobante1FormularioRentaExtra(Boolean activarnumero_comprobante1FormularioRentaExtra) {
		this.activarnumero_comprobante1FormularioRentaExtra= activarnumero_comprobante1FormularioRentaExtra;
	}

	public Border setResaltarnumero_comprobante2FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobante2FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobante2FormularioRentaExtra() {
		return this.resaltarnumero_comprobante2FormularioRentaExtra;
	}

	public void setResaltarnumero_comprobante2FormularioRentaExtra(Border borderResaltar) {
		this.resaltarnumero_comprobante2FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobante2FormularioRentaExtra() {
		return this.mostrarnumero_comprobante2FormularioRentaExtra;
	}

	public void setMostrarnumero_comprobante2FormularioRentaExtra(Boolean mostrarnumero_comprobante2FormularioRentaExtra) {
		this.mostrarnumero_comprobante2FormularioRentaExtra= mostrarnumero_comprobante2FormularioRentaExtra;
	}

	public Boolean getActivarnumero_comprobante2FormularioRentaExtra() {
		return this.activarnumero_comprobante2FormularioRentaExtra;
	}

	public void setActivarnumero_comprobante2FormularioRentaExtra(Boolean activarnumero_comprobante2FormularioRentaExtra) {
		this.activarnumero_comprobante2FormularioRentaExtra= activarnumero_comprobante2FormularioRentaExtra;
	}

	public Border setResaltarvalor_comprobante1FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor_comprobante1FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_comprobante1FormularioRentaExtra() {
		return this.resaltarvalor_comprobante1FormularioRentaExtra;
	}

	public void setResaltarvalor_comprobante1FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor_comprobante1FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor_comprobante1FormularioRentaExtra() {
		return this.mostrarvalor_comprobante1FormularioRentaExtra;
	}

	public void setMostrarvalor_comprobante1FormularioRentaExtra(Boolean mostrarvalor_comprobante1FormularioRentaExtra) {
		this.mostrarvalor_comprobante1FormularioRentaExtra= mostrarvalor_comprobante1FormularioRentaExtra;
	}

	public Boolean getActivarvalor_comprobante1FormularioRentaExtra() {
		return this.activarvalor_comprobante1FormularioRentaExtra;
	}

	public void setActivarvalor_comprobante1FormularioRentaExtra(Boolean activarvalor_comprobante1FormularioRentaExtra) {
		this.activarvalor_comprobante1FormularioRentaExtra= activarvalor_comprobante1FormularioRentaExtra;
	}

	public Border setResaltarvalor_comprobante2FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor_comprobante2FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_comprobante2FormularioRentaExtra() {
		return this.resaltarvalor_comprobante2FormularioRentaExtra;
	}

	public void setResaltarvalor_comprobante2FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor_comprobante2FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor_comprobante2FormularioRentaExtra() {
		return this.mostrarvalor_comprobante2FormularioRentaExtra;
	}

	public void setMostrarvalor_comprobante2FormularioRentaExtra(Boolean mostrarvalor_comprobante2FormularioRentaExtra) {
		this.mostrarvalor_comprobante2FormularioRentaExtra= mostrarvalor_comprobante2FormularioRentaExtra;
	}

	public Boolean getActivarvalor_comprobante2FormularioRentaExtra() {
		return this.activarvalor_comprobante2FormularioRentaExtra;
	}

	public void setActivarvalor_comprobante2FormularioRentaExtra(Boolean activarvalor_comprobante2FormularioRentaExtra) {
		this.activarvalor_comprobante2FormularioRentaExtra= activarvalor_comprobante2FormularioRentaExtra;
	}

	public Border setResaltarvalor301FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor301FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor301FormularioRentaExtra() {
		return this.resaltarvalor301FormularioRentaExtra;
	}

	public void setResaltarvalor301FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor301FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor301FormularioRentaExtra() {
		return this.mostrarvalor301FormularioRentaExtra;
	}

	public void setMostrarvalor301FormularioRentaExtra(Boolean mostrarvalor301FormularioRentaExtra) {
		this.mostrarvalor301FormularioRentaExtra= mostrarvalor301FormularioRentaExtra;
	}

	public Boolean getActivarvalor301FormularioRentaExtra() {
		return this.activarvalor301FormularioRentaExtra;
	}

	public void setActivarvalor301FormularioRentaExtra(Boolean activarvalor301FormularioRentaExtra) {
		this.activarvalor301FormularioRentaExtra= activarvalor301FormularioRentaExtra;
	}

	public Border setResaltarvalor303FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor303FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor303FormularioRentaExtra() {
		return this.resaltarvalor303FormularioRentaExtra;
	}

	public void setResaltarvalor303FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor303FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor303FormularioRentaExtra() {
		return this.mostrarvalor303FormularioRentaExtra;
	}

	public void setMostrarvalor303FormularioRentaExtra(Boolean mostrarvalor303FormularioRentaExtra) {
		this.mostrarvalor303FormularioRentaExtra= mostrarvalor303FormularioRentaExtra;
	}

	public Boolean getActivarvalor303FormularioRentaExtra() {
		return this.activarvalor303FormularioRentaExtra;
	}

	public void setActivarvalor303FormularioRentaExtra(Boolean activarvalor303FormularioRentaExtra) {
		this.activarvalor303FormularioRentaExtra= activarvalor303FormularioRentaExtra;
	}

	public Border setResaltarvalor305FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor305FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor305FormularioRentaExtra() {
		return this.resaltarvalor305FormularioRentaExtra;
	}

	public void setResaltarvalor305FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor305FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor305FormularioRentaExtra() {
		return this.mostrarvalor305FormularioRentaExtra;
	}

	public void setMostrarvalor305FormularioRentaExtra(Boolean mostrarvalor305FormularioRentaExtra) {
		this.mostrarvalor305FormularioRentaExtra= mostrarvalor305FormularioRentaExtra;
	}

	public Boolean getActivarvalor305FormularioRentaExtra() {
		return this.activarvalor305FormularioRentaExtra;
	}

	public void setActivarvalor305FormularioRentaExtra(Boolean activarvalor305FormularioRentaExtra) {
		this.activarvalor305FormularioRentaExtra= activarvalor305FormularioRentaExtra;
	}

	public Border setResaltarvalor307FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor307FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor307FormularioRentaExtra() {
		return this.resaltarvalor307FormularioRentaExtra;
	}

	public void setResaltarvalor307FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor307FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor307FormularioRentaExtra() {
		return this.mostrarvalor307FormularioRentaExtra;
	}

	public void setMostrarvalor307FormularioRentaExtra(Boolean mostrarvalor307FormularioRentaExtra) {
		this.mostrarvalor307FormularioRentaExtra= mostrarvalor307FormularioRentaExtra;
	}

	public Boolean getActivarvalor307FormularioRentaExtra() {
		return this.activarvalor307FormularioRentaExtra;
	}

	public void setActivarvalor307FormularioRentaExtra(Boolean activarvalor307FormularioRentaExtra) {
		this.activarvalor307FormularioRentaExtra= activarvalor307FormularioRentaExtra;
	}

	public Border setResaltarvalor351FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor351FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor351FormularioRentaExtra() {
		return this.resaltarvalor351FormularioRentaExtra;
	}

	public void setResaltarvalor351FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor351FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor351FormularioRentaExtra() {
		return this.mostrarvalor351FormularioRentaExtra;
	}

	public void setMostrarvalor351FormularioRentaExtra(Boolean mostrarvalor351FormularioRentaExtra) {
		this.mostrarvalor351FormularioRentaExtra= mostrarvalor351FormularioRentaExtra;
	}

	public Boolean getActivarvalor351FormularioRentaExtra() {
		return this.activarvalor351FormularioRentaExtra;
	}

	public void setActivarvalor351FormularioRentaExtra(Boolean activarvalor351FormularioRentaExtra) {
		this.activarvalor351FormularioRentaExtra= activarvalor351FormularioRentaExtra;
	}

	public Border setResaltarvalor355FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor355FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor355FormularioRentaExtra() {
		return this.resaltarvalor355FormularioRentaExtra;
	}

	public void setResaltarvalor355FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor355FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor355FormularioRentaExtra() {
		return this.mostrarvalor355FormularioRentaExtra;
	}

	public void setMostrarvalor355FormularioRentaExtra(Boolean mostrarvalor355FormularioRentaExtra) {
		this.mostrarvalor355FormularioRentaExtra= mostrarvalor355FormularioRentaExtra;
	}

	public Boolean getActivarvalor355FormularioRentaExtra() {
		return this.activarvalor355FormularioRentaExtra;
	}

	public void setActivarvalor355FormularioRentaExtra(Boolean activarvalor355FormularioRentaExtra) {
		this.activarvalor355FormularioRentaExtra= activarvalor355FormularioRentaExtra;
	}

	public Border setResaltarvalor357FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor357FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor357FormularioRentaExtra() {
		return this.resaltarvalor357FormularioRentaExtra;
	}

	public void setResaltarvalor357FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor357FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor357FormularioRentaExtra() {
		return this.mostrarvalor357FormularioRentaExtra;
	}

	public void setMostrarvalor357FormularioRentaExtra(Boolean mostrarvalor357FormularioRentaExtra) {
		this.mostrarvalor357FormularioRentaExtra= mostrarvalor357FormularioRentaExtra;
	}

	public Boolean getActivarvalor357FormularioRentaExtra() {
		return this.activarvalor357FormularioRentaExtra;
	}

	public void setActivarvalor357FormularioRentaExtra(Boolean activarvalor357FormularioRentaExtra) {
		this.activarvalor357FormularioRentaExtra= activarvalor357FormularioRentaExtra;
	}

	public Border setResaltarvalor359FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor359FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor359FormularioRentaExtra() {
		return this.resaltarvalor359FormularioRentaExtra;
	}

	public void setResaltarvalor359FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor359FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor359FormularioRentaExtra() {
		return this.mostrarvalor359FormularioRentaExtra;
	}

	public void setMostrarvalor359FormularioRentaExtra(Boolean mostrarvalor359FormularioRentaExtra) {
		this.mostrarvalor359FormularioRentaExtra= mostrarvalor359FormularioRentaExtra;
	}

	public Boolean getActivarvalor359FormularioRentaExtra() {
		return this.activarvalor359FormularioRentaExtra;
	}

	public void setActivarvalor359FormularioRentaExtra(Boolean activarvalor359FormularioRentaExtra) {
		this.activarvalor359FormularioRentaExtra= activarvalor359FormularioRentaExtra;
	}

	public Border setResaltarvalor361FormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaextraBeanSwingJInternalFrame.jTtoolBarFormularioRentaExtra.setBorder(borderResaltar);
		
		this.resaltarvalor361FormularioRentaExtra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor361FormularioRentaExtra() {
		return this.resaltarvalor361FormularioRentaExtra;
	}

	public void setResaltarvalor361FormularioRentaExtra(Border borderResaltar) {
		this.resaltarvalor361FormularioRentaExtra= borderResaltar;
	}

	public Boolean getMostrarvalor361FormularioRentaExtra() {
		return this.mostrarvalor361FormularioRentaExtra;
	}

	public void setMostrarvalor361FormularioRentaExtra(Boolean mostrarvalor361FormularioRentaExtra) {
		this.mostrarvalor361FormularioRentaExtra= mostrarvalor361FormularioRentaExtra;
	}

	public Boolean getActivarvalor361FormularioRentaExtra() {
		return this.activarvalor361FormularioRentaExtra;
	}

	public void setActivarvalor361FormularioRentaExtra(Boolean activarvalor361FormularioRentaExtra) {
		this.activarvalor361FormularioRentaExtra= activarvalor361FormularioRentaExtra;
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
		
		
		this.setMostraridFormularioRentaExtra(esInicial);
		this.setMostrarid_empresaFormularioRentaExtra(esInicial);
		this.setMostrarid_ejercicioFormularioRentaExtra(esInicial);
		this.setMostrarid_periodoFormularioRentaExtra(esInicial);
		this.setMostrarid_dato_formulario_rentaFormularioRentaExtra(esInicial);
		this.setMostrarid_forma_pagoFormularioRentaExtra(esInicial);
		this.setMostrarid_bancoFormularioRentaExtra(esInicial);
		this.setMostrarpago_previoFormularioRentaExtra(esInicial);
		this.setMostrarinteres_moraFormularioRentaExtra(esInicial);
		this.setMostrarvalor_multaFormularioRentaExtra(esInicial);
		this.setMostrarforma_pago1FormularioRentaExtra(esInicial);
		this.setMostrarforma_pago2FormularioRentaExtra(esInicial);
		this.setMostrarnumero_nota_credito1FormularioRentaExtra(esInicial);
		this.setMostrarnumero_nota_credito2FormularioRentaExtra(esInicial);
		this.setMostrarnumero_nota_credito3FormularioRentaExtra(esInicial);
		this.setMostrarnumero_nota_credito4FormularioRentaExtra(esInicial);
		this.setMostrarvalor_nota_credito1FormularioRentaExtra(esInicial);
		this.setMostrarvalor_nota_credito2FormularioRentaExtra(esInicial);
		this.setMostrarvalor_nota_credito3FormularioRentaExtra(esInicial);
		this.setMostrarvalor_nota_credito4FormularioRentaExtra(esInicial);
		this.setMostrarnumero_comprobante1FormularioRentaExtra(esInicial);
		this.setMostrarnumero_comprobante2FormularioRentaExtra(esInicial);
		this.setMostrarvalor_comprobante1FormularioRentaExtra(esInicial);
		this.setMostrarvalor_comprobante2FormularioRentaExtra(esInicial);
		this.setMostrarvalor301FormularioRentaExtra(esInicial);
		this.setMostrarvalor303FormularioRentaExtra(esInicial);
		this.setMostrarvalor305FormularioRentaExtra(esInicial);
		this.setMostrarvalor307FormularioRentaExtra(esInicial);
		this.setMostrarvalor351FormularioRentaExtra(esInicial);
		this.setMostrarvalor355FormularioRentaExtra(esInicial);
		this.setMostrarvalor357FormularioRentaExtra(esInicial);
		this.setMostrarvalor359FormularioRentaExtra(esInicial);
		this.setMostrarvalor361FormularioRentaExtra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.ID)) {
				this.setMostraridFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDDATOFORMULARIORENTA)) {
				this.setMostrarid_dato_formulario_rentaFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDFORMAPAGO)) {
				this.setMostrarid_forma_pagoFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.PAGOPREVIO)) {
				this.setMostrarpago_previoFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.INTERESMORA)) {
				this.setMostrarinteres_moraFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORMULTA)) {
				this.setMostrarvalor_multaFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.FORMAPAGO1)) {
				this.setMostrarforma_pago1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.FORMAPAGO2)) {
				this.setMostrarforma_pago2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO1)) {
				this.setMostrarnumero_nota_credito1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO2)) {
				this.setMostrarnumero_nota_credito2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO3)) {
				this.setMostrarnumero_nota_credito3FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO4)) {
				this.setMostrarnumero_nota_credito4FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO1)) {
				this.setMostrarvalor_nota_credito1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO2)) {
				this.setMostrarvalor_nota_credito2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO3)) {
				this.setMostrarvalor_nota_credito3FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO4)) {
				this.setMostrarvalor_nota_credito4FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE1)) {
				this.setMostrarnumero_comprobante1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE2)) {
				this.setMostrarnumero_comprobante2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE1)) {
				this.setMostrarvalor_comprobante1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE2)) {
				this.setMostrarvalor_comprobante2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR301)) {
				this.setMostrarvalor301FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR303)) {
				this.setMostrarvalor303FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR305)) {
				this.setMostrarvalor305FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR307)) {
				this.setMostrarvalor307FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR351)) {
				this.setMostrarvalor351FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR355)) {
				this.setMostrarvalor355FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR357)) {
				this.setMostrarvalor357FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR359)) {
				this.setMostrarvalor359FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR361)) {
				this.setMostrarvalor361FormularioRentaExtra(esAsigna);
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
		
		
		this.setActivaridFormularioRentaExtra(esInicial);
		this.setActivarid_empresaFormularioRentaExtra(esInicial);
		this.setActivarid_ejercicioFormularioRentaExtra(esInicial);
		this.setActivarid_periodoFormularioRentaExtra(esInicial);
		this.setActivarid_dato_formulario_rentaFormularioRentaExtra(esInicial);
		this.setActivarid_forma_pagoFormularioRentaExtra(esInicial);
		this.setActivarid_bancoFormularioRentaExtra(esInicial);
		this.setActivarpago_previoFormularioRentaExtra(esInicial);
		this.setActivarinteres_moraFormularioRentaExtra(esInicial);
		this.setActivarvalor_multaFormularioRentaExtra(esInicial);
		this.setActivarforma_pago1FormularioRentaExtra(esInicial);
		this.setActivarforma_pago2FormularioRentaExtra(esInicial);
		this.setActivarnumero_nota_credito1FormularioRentaExtra(esInicial);
		this.setActivarnumero_nota_credito2FormularioRentaExtra(esInicial);
		this.setActivarnumero_nota_credito3FormularioRentaExtra(esInicial);
		this.setActivarnumero_nota_credito4FormularioRentaExtra(esInicial);
		this.setActivarvalor_nota_credito1FormularioRentaExtra(esInicial);
		this.setActivarvalor_nota_credito2FormularioRentaExtra(esInicial);
		this.setActivarvalor_nota_credito3FormularioRentaExtra(esInicial);
		this.setActivarvalor_nota_credito4FormularioRentaExtra(esInicial);
		this.setActivarnumero_comprobante1FormularioRentaExtra(esInicial);
		this.setActivarnumero_comprobante2FormularioRentaExtra(esInicial);
		this.setActivarvalor_comprobante1FormularioRentaExtra(esInicial);
		this.setActivarvalor_comprobante2FormularioRentaExtra(esInicial);
		this.setActivarvalor301FormularioRentaExtra(esInicial);
		this.setActivarvalor303FormularioRentaExtra(esInicial);
		this.setActivarvalor305FormularioRentaExtra(esInicial);
		this.setActivarvalor307FormularioRentaExtra(esInicial);
		this.setActivarvalor351FormularioRentaExtra(esInicial);
		this.setActivarvalor355FormularioRentaExtra(esInicial);
		this.setActivarvalor357FormularioRentaExtra(esInicial);
		this.setActivarvalor359FormularioRentaExtra(esInicial);
		this.setActivarvalor361FormularioRentaExtra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.ID)) {
				this.setActivaridFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDDATOFORMULARIORENTA)) {
				this.setActivarid_dato_formulario_rentaFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDFORMAPAGO)) {
				this.setActivarid_forma_pagoFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.PAGOPREVIO)) {
				this.setActivarpago_previoFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.INTERESMORA)) {
				this.setActivarinteres_moraFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORMULTA)) {
				this.setActivarvalor_multaFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.FORMAPAGO1)) {
				this.setActivarforma_pago1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.FORMAPAGO2)) {
				this.setActivarforma_pago2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO1)) {
				this.setActivarnumero_nota_credito1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO2)) {
				this.setActivarnumero_nota_credito2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO3)) {
				this.setActivarnumero_nota_credito3FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO4)) {
				this.setActivarnumero_nota_credito4FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO1)) {
				this.setActivarvalor_nota_credito1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO2)) {
				this.setActivarvalor_nota_credito2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO3)) {
				this.setActivarvalor_nota_credito3FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO4)) {
				this.setActivarvalor_nota_credito4FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE1)) {
				this.setActivarnumero_comprobante1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE2)) {
				this.setActivarnumero_comprobante2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE1)) {
				this.setActivarvalor_comprobante1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE2)) {
				this.setActivarvalor_comprobante2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR301)) {
				this.setActivarvalor301FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR303)) {
				this.setActivarvalor303FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR305)) {
				this.setActivarvalor305FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR307)) {
				this.setActivarvalor307FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR351)) {
				this.setActivarvalor351FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR355)) {
				this.setActivarvalor355FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR357)) {
				this.setActivarvalor357FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR359)) {
				this.setActivarvalor359FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR361)) {
				this.setActivarvalor361FormularioRentaExtra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFormularioRentaExtra(esInicial);
		this.setResaltarid_empresaFormularioRentaExtra(esInicial);
		this.setResaltarid_ejercicioFormularioRentaExtra(esInicial);
		this.setResaltarid_periodoFormularioRentaExtra(esInicial);
		this.setResaltarid_dato_formulario_rentaFormularioRentaExtra(esInicial);
		this.setResaltarid_forma_pagoFormularioRentaExtra(esInicial);
		this.setResaltarid_bancoFormularioRentaExtra(esInicial);
		this.setResaltarpago_previoFormularioRentaExtra(esInicial);
		this.setResaltarinteres_moraFormularioRentaExtra(esInicial);
		this.setResaltarvalor_multaFormularioRentaExtra(esInicial);
		this.setResaltarforma_pago1FormularioRentaExtra(esInicial);
		this.setResaltarforma_pago2FormularioRentaExtra(esInicial);
		this.setResaltarnumero_nota_credito1FormularioRentaExtra(esInicial);
		this.setResaltarnumero_nota_credito2FormularioRentaExtra(esInicial);
		this.setResaltarnumero_nota_credito3FormularioRentaExtra(esInicial);
		this.setResaltarnumero_nota_credito4FormularioRentaExtra(esInicial);
		this.setResaltarvalor_nota_credito1FormularioRentaExtra(esInicial);
		this.setResaltarvalor_nota_credito2FormularioRentaExtra(esInicial);
		this.setResaltarvalor_nota_credito3FormularioRentaExtra(esInicial);
		this.setResaltarvalor_nota_credito4FormularioRentaExtra(esInicial);
		this.setResaltarnumero_comprobante1FormularioRentaExtra(esInicial);
		this.setResaltarnumero_comprobante2FormularioRentaExtra(esInicial);
		this.setResaltarvalor_comprobante1FormularioRentaExtra(esInicial);
		this.setResaltarvalor_comprobante2FormularioRentaExtra(esInicial);
		this.setResaltarvalor301FormularioRentaExtra(esInicial);
		this.setResaltarvalor303FormularioRentaExtra(esInicial);
		this.setResaltarvalor305FormularioRentaExtra(esInicial);
		this.setResaltarvalor307FormularioRentaExtra(esInicial);
		this.setResaltarvalor351FormularioRentaExtra(esInicial);
		this.setResaltarvalor355FormularioRentaExtra(esInicial);
		this.setResaltarvalor357FormularioRentaExtra(esInicial);
		this.setResaltarvalor359FormularioRentaExtra(esInicial);
		this.setResaltarvalor361FormularioRentaExtra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.ID)) {
				this.setResaltaridFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDDATOFORMULARIORENTA)) {
				this.setResaltarid_dato_formulario_rentaFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDFORMAPAGO)) {
				this.setResaltarid_forma_pagoFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.PAGOPREVIO)) {
				this.setResaltarpago_previoFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.INTERESMORA)) {
				this.setResaltarinteres_moraFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORMULTA)) {
				this.setResaltarvalor_multaFormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.FORMAPAGO1)) {
				this.setResaltarforma_pago1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.FORMAPAGO2)) {
				this.setResaltarforma_pago2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO1)) {
				this.setResaltarnumero_nota_credito1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO2)) {
				this.setResaltarnumero_nota_credito2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO3)) {
				this.setResaltarnumero_nota_credito3FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO4)) {
				this.setResaltarnumero_nota_credito4FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO1)) {
				this.setResaltarvalor_nota_credito1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO2)) {
				this.setResaltarvalor_nota_credito2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO3)) {
				this.setResaltarvalor_nota_credito3FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO4)) {
				this.setResaltarvalor_nota_credito4FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE1)) {
				this.setResaltarnumero_comprobante1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE2)) {
				this.setResaltarnumero_comprobante2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE1)) {
				this.setResaltarvalor_comprobante1FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE2)) {
				this.setResaltarvalor_comprobante2FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR301)) {
				this.setResaltarvalor301FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR303)) {
				this.setResaltarvalor303FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR305)) {
				this.setResaltarvalor305FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR307)) {
				this.setResaltarvalor307FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR351)) {
				this.setResaltarvalor351FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR355)) {
				this.setResaltarvalor355FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR357)) {
				this.setResaltarvalor357FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR359)) {
				this.setResaltarvalor359FormularioRentaExtra(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaExtraConstantesFunciones.VALOR361)) {
				this.setResaltarvalor361FormularioRentaExtra(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBancoFormularioRentaExtra=true;

	public Boolean getMostrarFK_IdBancoFormularioRentaExtra() {
		return this.mostrarFK_IdBancoFormularioRentaExtra;
	}

	public void setMostrarFK_IdBancoFormularioRentaExtra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoFormularioRentaExtra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDatoFormularioRentaFormularioRentaExtra=true;

	public Boolean getMostrarFK_IdDatoFormularioRentaFormularioRentaExtra() {
		return this.mostrarFK_IdDatoFormularioRentaFormularioRentaExtra;
	}

	public void setMostrarFK_IdDatoFormularioRentaFormularioRentaExtra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDatoFormularioRentaFormularioRentaExtra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioFormularioRentaExtra=true;

	public Boolean getMostrarFK_IdEjercicioFormularioRentaExtra() {
		return this.mostrarFK_IdEjercicioFormularioRentaExtra;
	}

	public void setMostrarFK_IdEjercicioFormularioRentaExtra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioFormularioRentaExtra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFormularioRentaExtra=true;

	public Boolean getMostrarFK_IdEmpresaFormularioRentaExtra() {
		return this.mostrarFK_IdEmpresaFormularioRentaExtra;
	}

	public void setMostrarFK_IdEmpresaFormularioRentaExtra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFormularioRentaExtra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormaPagoFormularioRentaExtra=true;

	public Boolean getMostrarFK_IdFormaPagoFormularioRentaExtra() {
		return this.mostrarFK_IdFormaPagoFormularioRentaExtra;
	}

	public void setMostrarFK_IdFormaPagoFormularioRentaExtra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormaPagoFormularioRentaExtra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoFormularioRentaExtra=true;

	public Boolean getMostrarFK_IdPeriodoFormularioRentaExtra() {
		return this.mostrarFK_IdPeriodoFormularioRentaExtra;
	}

	public void setMostrarFK_IdPeriodoFormularioRentaExtra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoFormularioRentaExtra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBancoFormularioRentaExtra=true;

	public Boolean getActivarFK_IdBancoFormularioRentaExtra() {
		return this.activarFK_IdBancoFormularioRentaExtra;
	}

	public void setActivarFK_IdBancoFormularioRentaExtra(Boolean habilitarResaltar) {
		this.activarFK_IdBancoFormularioRentaExtra= habilitarResaltar;
	}

	public Boolean activarFK_IdDatoFormularioRentaFormularioRentaExtra=true;

	public Boolean getActivarFK_IdDatoFormularioRentaFormularioRentaExtra() {
		return this.activarFK_IdDatoFormularioRentaFormularioRentaExtra;
	}

	public void setActivarFK_IdDatoFormularioRentaFormularioRentaExtra(Boolean habilitarResaltar) {
		this.activarFK_IdDatoFormularioRentaFormularioRentaExtra= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioFormularioRentaExtra=true;

	public Boolean getActivarFK_IdEjercicioFormularioRentaExtra() {
		return this.activarFK_IdEjercicioFormularioRentaExtra;
	}

	public void setActivarFK_IdEjercicioFormularioRentaExtra(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioFormularioRentaExtra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFormularioRentaExtra=true;

	public Boolean getActivarFK_IdEmpresaFormularioRentaExtra() {
		return this.activarFK_IdEmpresaFormularioRentaExtra;
	}

	public void setActivarFK_IdEmpresaFormularioRentaExtra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFormularioRentaExtra= habilitarResaltar;
	}

	public Boolean activarFK_IdFormaPagoFormularioRentaExtra=true;

	public Boolean getActivarFK_IdFormaPagoFormularioRentaExtra() {
		return this.activarFK_IdFormaPagoFormularioRentaExtra;
	}

	public void setActivarFK_IdFormaPagoFormularioRentaExtra(Boolean habilitarResaltar) {
		this.activarFK_IdFormaPagoFormularioRentaExtra= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoFormularioRentaExtra=true;

	public Boolean getActivarFK_IdPeriodoFormularioRentaExtra() {
		return this.activarFK_IdPeriodoFormularioRentaExtra;
	}

	public void setActivarFK_IdPeriodoFormularioRentaExtra(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoFormularioRentaExtra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBancoFormularioRentaExtra=null;

	public Border getResaltarFK_IdBancoFormularioRentaExtra() {
		return this.resaltarFK_IdBancoFormularioRentaExtra;
	}

	public void setResaltarFK_IdBancoFormularioRentaExtra(Border borderResaltar) {
		this.resaltarFK_IdBancoFormularioRentaExtra= borderResaltar;
	}

	public void setResaltarFK_IdBancoFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoFormularioRentaExtra= borderResaltar;
	}

	public Border resaltarFK_IdDatoFormularioRentaFormularioRentaExtra=null;

	public Border getResaltarFK_IdDatoFormularioRentaFormularioRentaExtra() {
		return this.resaltarFK_IdDatoFormularioRentaFormularioRentaExtra;
	}

	public void setResaltarFK_IdDatoFormularioRentaFormularioRentaExtra(Border borderResaltar) {
		this.resaltarFK_IdDatoFormularioRentaFormularioRentaExtra= borderResaltar;
	}

	public void setResaltarFK_IdDatoFormularioRentaFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDatoFormularioRentaFormularioRentaExtra= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioFormularioRentaExtra=null;

	public Border getResaltarFK_IdEjercicioFormularioRentaExtra() {
		return this.resaltarFK_IdEjercicioFormularioRentaExtra;
	}

	public void setResaltarFK_IdEjercicioFormularioRentaExtra(Border borderResaltar) {
		this.resaltarFK_IdEjercicioFormularioRentaExtra= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioFormularioRentaExtra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFormularioRentaExtra=null;

	public Border getResaltarFK_IdEmpresaFormularioRentaExtra() {
		return this.resaltarFK_IdEmpresaFormularioRentaExtra;
	}

	public void setResaltarFK_IdEmpresaFormularioRentaExtra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFormularioRentaExtra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFormularioRentaExtra= borderResaltar;
	}

	public Border resaltarFK_IdFormaPagoFormularioRentaExtra=null;

	public Border getResaltarFK_IdFormaPagoFormularioRentaExtra() {
		return this.resaltarFK_IdFormaPagoFormularioRentaExtra;
	}

	public void setResaltarFK_IdFormaPagoFormularioRentaExtra(Border borderResaltar) {
		this.resaltarFK_IdFormaPagoFormularioRentaExtra= borderResaltar;
	}

	public void setResaltarFK_IdFormaPagoFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormaPagoFormularioRentaExtra= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoFormularioRentaExtra=null;

	public Border getResaltarFK_IdPeriodoFormularioRentaExtra() {
		return this.resaltarFK_IdPeriodoFormularioRentaExtra;
	}

	public void setResaltarFK_IdPeriodoFormularioRentaExtra(Border borderResaltar) {
		this.resaltarFK_IdPeriodoFormularioRentaExtra= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoFormularioRentaExtra(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaExtraBeanSwingJInternalFrame formulariorentaextraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoFormularioRentaExtra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}