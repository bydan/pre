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


import com.bydan.erp.contabilidad.util.FormularioRentaConstantesFunciones;
import com.bydan.erp.contabilidad.util.FormularioRentaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.FormularioRentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FormularioRentaConstantesFunciones extends FormularioRentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FormularioRenta";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FormularioRenta"+FormularioRentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FormularioRentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FormularioRentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FormularioRentaConstantesFunciones.SCHEMA+"_"+FormularioRentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FormularioRentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FormularioRentaConstantesFunciones.SCHEMA+"_"+FormularioRentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FormularioRentaConstantesFunciones.SCHEMA+"_"+FormularioRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FormularioRentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FormularioRentaConstantesFunciones.SCHEMA+"_"+FormularioRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioRentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormularioRentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioRentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormularioRentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormularioRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FormularioRentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FormularioRentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FormularioRentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FormularioRentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Formulario Rentas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Formulario Renta";
	public static final String SCLASSWEBTITULO_LOWER="Formulario Renta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FormularioRenta";
	public static final String OBJECTNAME="formulariorenta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="formulario_renta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select formulariorenta from "+FormularioRentaConstantesFunciones.SPERSISTENCENAME+" formulariorenta";
	public static String QUERYSELECTNATIVE="select "+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".version_row,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_empresa,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_ejercicio,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_periodo,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_dato_formulario_renta,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_tipo_retencion,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_parametro_formulario_iva,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_pais,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".valor_pagado,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".impuesto_retenido,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".base_impornible from "+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME;//+" as "+FormularioRentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FormularioRentaConstantesFuncionesAdditional formulariorentaConstantesFuncionesAdditional=null;
	
	public FormularioRentaConstantesFuncionesAdditional getFormularioRentaConstantesFuncionesAdditional() {
		return this.formulariorentaConstantesFuncionesAdditional;
	}
	
	public void setFormularioRentaConstantesFuncionesAdditional(FormularioRentaConstantesFuncionesAdditional formulariorentaConstantesFuncionesAdditional) {
		try {
			this.formulariorentaConstantesFuncionesAdditional=formulariorentaConstantesFuncionesAdditional;
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
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDTIPORETENCION= "id_tipo_retencion";
    public static final String IDPARAMETROFORMULARIOIVA= "id_parametro_formulario_iva";
    public static final String IDPAIS= "id_pais";
    public static final String VALORPAGADO= "valor_pagado";
    public static final String IMPUESTORETENIDO= "impuesto_retenido";
    public static final String BASEIMPORNIBLE= "base_impornible";
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
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDTIPORETENCION= "Tipo Retencion";
		public static final String LABEL_IDTIPORETENCION_LOWER= "Tipo Retencion";
    	public static final String LABEL_IDPARAMETROFORMULARIOIVA= "Parametro Formulario Iva";
		public static final String LABEL_IDPARAMETROFORMULARIOIVA_LOWER= "Parametro Formulario Iva";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_VALORPAGADO= "Valor Pagado";
		public static final String LABEL_VALORPAGADO_LOWER= "Valor Pagado";
    	public static final String LABEL_IMPUESTORETENIDO= "Impuesto Retenido";
		public static final String LABEL_IMPUESTORETENIDO_LOWER= "Impuesto Retenido";
    	public static final String LABEL_BASEIMPORNIBLE= "Base Impornible";
		public static final String LABEL_BASEIMPORNIBLE_LOWER= "Base Impornible";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getFormularioRentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FormularioRentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=FormularioRentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FormularioRentaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=FormularioRentaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(FormularioRentaConstantesFunciones.IDPERIODO)) {sLabelColumna=FormularioRentaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(FormularioRentaConstantesFunciones.IDDATOFORMULARIORENTA)) {sLabelColumna=FormularioRentaConstantesFunciones.LABEL_IDDATOFORMULARIORENTA;}
		if(sNombreColumna.equals(FormularioRentaConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=FormularioRentaConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(FormularioRentaConstantesFunciones.IDTIPORETENCION)) {sLabelColumna=FormularioRentaConstantesFunciones.LABEL_IDTIPORETENCION;}
		if(sNombreColumna.equals(FormularioRentaConstantesFunciones.IDPARAMETROFORMULARIOIVA)) {sLabelColumna=FormularioRentaConstantesFunciones.LABEL_IDPARAMETROFORMULARIOIVA;}
		if(sNombreColumna.equals(FormularioRentaConstantesFunciones.IDPAIS)) {sLabelColumna=FormularioRentaConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(FormularioRentaConstantesFunciones.VALORPAGADO)) {sLabelColumna=FormularioRentaConstantesFunciones.LABEL_VALORPAGADO;}
		if(sNombreColumna.equals(FormularioRentaConstantesFunciones.IMPUESTORETENIDO)) {sLabelColumna=FormularioRentaConstantesFunciones.LABEL_IMPUESTORETENIDO;}
		if(sNombreColumna.equals(FormularioRentaConstantesFunciones.BASEIMPORNIBLE)) {sLabelColumna=FormularioRentaConstantesFunciones.LABEL_BASEIMPORNIBLE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFormularioRentaDescripcion(FormularioRenta formulariorenta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(formulariorenta !=null/* && formulariorenta.getId()!=0*/) {
			if(formulariorenta.getId()!=null) {
				sDescripcion=formulariorenta.getId().toString();
			}//formulariorentaformulariorenta.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFormularioRentaDescripcionDetallado(FormularioRenta formulariorenta) {
		String sDescripcion="";
			
		sDescripcion+=FormularioRentaConstantesFunciones.ID+"=";
		sDescripcion+=formulariorenta.getId().toString()+",";
		sDescripcion+=FormularioRentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=formulariorenta.getVersionRow().toString()+",";
		sDescripcion+=FormularioRentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=formulariorenta.getid_empresa().toString()+",";
		sDescripcion+=FormularioRentaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=formulariorenta.getid_ejercicio().toString()+",";
		sDescripcion+=FormularioRentaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=formulariorenta.getid_periodo().toString()+",";
		sDescripcion+=FormularioRentaConstantesFunciones.IDDATOFORMULARIORENTA+"=";
		sDescripcion+=formulariorenta.getid_dato_formulario_renta().toString()+",";
		sDescripcion+=FormularioRentaConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=formulariorenta.getid_cuenta_contable().toString()+",";
		sDescripcion+=FormularioRentaConstantesFunciones.IDTIPORETENCION+"=";
		sDescripcion+=formulariorenta.getid_tipo_retencion().toString()+",";
		sDescripcion+=FormularioRentaConstantesFunciones.IDPARAMETROFORMULARIOIVA+"=";
		sDescripcion+=formulariorenta.getid_parametro_formulario_iva().toString()+",";
		sDescripcion+=FormularioRentaConstantesFunciones.IDPAIS+"=";
		sDescripcion+=formulariorenta.getid_pais().toString()+",";
		sDescripcion+=FormularioRentaConstantesFunciones.VALORPAGADO+"=";
		sDescripcion+=formulariorenta.getvalor_pagado().toString()+",";
		sDescripcion+=FormularioRentaConstantesFunciones.IMPUESTORETENIDO+"=";
		sDescripcion+=formulariorenta.getimpuesto_retenido().toString()+",";
		sDescripcion+=FormularioRentaConstantesFunciones.BASEIMPORNIBLE+"=";
		sDescripcion+=formulariorenta.getbase_impornible().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFormularioRentaDescripcion(FormularioRenta formulariorenta,String sValor) throws Exception {			
		if(formulariorenta !=null) {
			//formulariorentaformulariorenta.getId().toString();
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

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getParametroFormularioIvaDescripcion(ParametroFormularioIva parametroformularioiva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(parametroformularioiva!=null/*&&parametroformularioiva.getId()>0*/) {
			sDescripcion=ParametroFormularioIvaConstantesFunciones.getParametroFormularioIvaDescripcion(parametroformularioiva);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdDatoFormularioRenta")) {
			sNombreIndice="Tipo=  Por Dato Formulario Renta";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdParametroFormularioIva")) {
			sNombreIndice="Tipo=  Por Parametro Formulario Iva";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdTipoRetencion")) {
			sNombreIndice="Tipo=  Por Tipo Retencion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

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

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdParametroFormularioIva(Long id_parametro_formulario_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_parametro_formulario_iva!=null) {sDetalleIndice+=" Codigo Unico De Parametro Formulario Iva="+id_parametro_formulario_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencion(Long id_tipo_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion="+id_tipo_retencion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFormularioRenta(FormularioRenta formulariorenta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosFormularioRentas(List<FormularioRenta> formulariorentas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FormularioRenta formulariorenta: formulariorentas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormularioRenta(FormularioRenta formulariorenta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && formulariorenta.getConCambioAuxiliar()) {
			formulariorenta.setIsDeleted(formulariorenta.getIsDeletedAuxiliar());	
			formulariorenta.setIsNew(formulariorenta.getIsNewAuxiliar());	
			formulariorenta.setIsChanged(formulariorenta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			formulariorenta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			formulariorenta.setIsDeletedAuxiliar(false);	
			formulariorenta.setIsNewAuxiliar(false);	
			formulariorenta.setIsChangedAuxiliar(false);
			
			formulariorenta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormularioRentas(List<FormularioRenta> formulariorentas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FormularioRenta formulariorenta : formulariorentas) {
			if(conAsignarBase && formulariorenta.getConCambioAuxiliar()) {
				formulariorenta.setIsDeleted(formulariorenta.getIsDeletedAuxiliar());	
				formulariorenta.setIsNew(formulariorenta.getIsNewAuxiliar());	
				formulariorenta.setIsChanged(formulariorenta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				formulariorenta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				formulariorenta.setIsDeletedAuxiliar(false);	
				formulariorenta.setIsNewAuxiliar(false);	
				formulariorenta.setIsChangedAuxiliar(false);
				
				formulariorenta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFormularioRenta(FormularioRenta formulariorenta,Boolean conEnteros) throws Exception  {
		formulariorenta.setvalor_pagado(0.0);
		formulariorenta.setimpuesto_retenido(0.0);
		formulariorenta.setbase_impornible(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFormularioRentas(List<FormularioRenta> formulariorentas,Boolean conEnteros) throws Exception  {
		
		for(FormularioRenta formulariorenta: formulariorentas) {
			formulariorenta.setvalor_pagado(0.0);
			formulariorenta.setimpuesto_retenido(0.0);
			formulariorenta.setbase_impornible(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFormularioRenta(List<FormularioRenta> formulariorentas,FormularioRenta formulariorentaAux) throws Exception  {
		FormularioRentaConstantesFunciones.InicializarValoresFormularioRenta(formulariorentaAux,true);
		
		for(FormularioRenta formulariorenta: formulariorentas) {
			if(formulariorenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			formulariorentaAux.setvalor_pagado(formulariorentaAux.getvalor_pagado()+formulariorenta.getvalor_pagado());			
			formulariorentaAux.setimpuesto_retenido(formulariorentaAux.getimpuesto_retenido()+formulariorenta.getimpuesto_retenido());			
			formulariorentaAux.setbase_impornible(formulariorentaAux.getbase_impornible()+formulariorenta.getbase_impornible());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormularioRenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FormularioRentaConstantesFunciones.getArrayColumnasGlobalesFormularioRenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFormularioRenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormularioRentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormularioRentaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormularioRentaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormularioRentaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormularioRentaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormularioRentaConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFormularioRenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FormularioRenta> formulariorentas,FormularioRenta formulariorenta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FormularioRenta formulariorentaAux: formulariorentas) {
			if(formulariorentaAux!=null && formulariorenta!=null) {
				if((formulariorentaAux.getId()==null && formulariorenta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(formulariorentaAux.getId()!=null && formulariorenta.getId()!=null){
					if(formulariorentaAux.getId().equals(formulariorenta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFormularioRenta(List<FormularioRenta> formulariorentas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_pagadoTotal=0.0;
		Double impuesto_retenidoTotal=0.0;
		Double base_impornibleTotal=0.0;
	
		for(FormularioRenta formulariorenta: formulariorentas) {			
			if(formulariorenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_pagadoTotal+=formulariorenta.getvalor_pagado();
			impuesto_retenidoTotal+=formulariorenta.getimpuesto_retenido();
			base_impornibleTotal+=formulariorenta.getbase_impornible();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaConstantesFunciones.VALORPAGADO);
		datoGeneral.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_VALORPAGADO);
		datoGeneral.setdValorDouble(valor_pagadoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaConstantesFunciones.IMPUESTORETENIDO);
		datoGeneral.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_IMPUESTORETENIDO);
		datoGeneral.setdValorDouble(impuesto_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormularioRentaConstantesFunciones.BASEIMPORNIBLE);
		datoGeneral.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_BASEIMPORNIBLE);
		datoGeneral.setdValorDouble(base_impornibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFormularioRenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FormularioRentaConstantesFunciones.LABEL_ID, FormularioRentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaConstantesFunciones.LABEL_VERSIONROW, FormularioRentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaConstantesFunciones.LABEL_IDEMPRESA, FormularioRentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaConstantesFunciones.LABEL_IDEJERCICIO, FormularioRentaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaConstantesFunciones.LABEL_IDPERIODO, FormularioRentaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaConstantesFunciones.LABEL_IDDATOFORMULARIORENTA, FormularioRentaConstantesFunciones.IDDATOFORMULARIORENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaConstantesFunciones.LABEL_IDCUENTACONTABLE, FormularioRentaConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaConstantesFunciones.LABEL_IDTIPORETENCION, FormularioRentaConstantesFunciones.IDTIPORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaConstantesFunciones.LABEL_IDPARAMETROFORMULARIOIVA, FormularioRentaConstantesFunciones.IDPARAMETROFORMULARIOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaConstantesFunciones.LABEL_IDPAIS, FormularioRentaConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaConstantesFunciones.LABEL_VALORPAGADO, FormularioRentaConstantesFunciones.VALORPAGADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaConstantesFunciones.LABEL_IMPUESTORETENIDO, FormularioRentaConstantesFunciones.IMPUESTORETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormularioRentaConstantesFunciones.LABEL_BASEIMPORNIBLE, FormularioRentaConstantesFunciones.BASEIMPORNIBLE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFormularioRenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaConstantesFunciones.IDDATOFORMULARIORENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaConstantesFunciones.IDTIPORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaConstantesFunciones.IDPARAMETROFORMULARIOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaConstantesFunciones.VALORPAGADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaConstantesFunciones.IMPUESTORETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormularioRentaConstantesFunciones.BASEIMPORNIBLE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormularioRenta() throws Exception  {
		return FormularioRentaConstantesFunciones.getTiposSeleccionarFormularioRenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormularioRenta(Boolean conFk) throws Exception  {
		return FormularioRentaConstantesFunciones.getTiposSeleccionarFormularioRenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormularioRenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaConstantesFunciones.LABEL_IDDATOFORMULARIORENTA);
			reporte.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_IDDATOFORMULARIORENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaConstantesFunciones.LABEL_IDTIPORETENCION);
			reporte.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_IDTIPORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaConstantesFunciones.LABEL_IDPARAMETROFORMULARIOIVA);
			reporte.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_IDPARAMETROFORMULARIOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaConstantesFunciones.LABEL_VALORPAGADO);
			reporte.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_VALORPAGADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaConstantesFunciones.LABEL_IMPUESTORETENIDO);
			reporte.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_IMPUESTORETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormularioRentaConstantesFunciones.LABEL_BASEIMPORNIBLE);
			reporte.setsDescripcion(FormularioRentaConstantesFunciones.LABEL_BASEIMPORNIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFormularioRenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFormularioRenta(FormularioRenta formulariorentaAux) throws Exception {
		
			formulariorentaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formulariorentaAux.getEmpresa()));
			formulariorentaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formulariorentaAux.getEjercicio()));
			formulariorentaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(formulariorentaAux.getPeriodo()));
			formulariorentaAux.setdatoformulariorenta_descripcion(DatoFormularioRentaConstantesFunciones.getDatoFormularioRentaDescripcion(formulariorentaAux.getDatoFormularioRenta()));
			formulariorentaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(formulariorentaAux.getCuentaContable()));
			formulariorentaAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(formulariorentaAux.getTipoRetencion()));
			formulariorentaAux.setparametroformularioiva_descripcion(ParametroFormularioIvaConstantesFunciones.getParametroFormularioIvaDescripcion(formulariorentaAux.getParametroFormularioIva()));
			formulariorentaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(formulariorentaAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFormularioRenta(List<FormularioRenta> formulariorentasTemp) throws Exception {
		for(FormularioRenta formulariorentaAux:formulariorentasTemp) {
			
			formulariorentaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formulariorentaAux.getEmpresa()));
			formulariorentaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formulariorentaAux.getEjercicio()));
			formulariorentaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(formulariorentaAux.getPeriodo()));
			formulariorentaAux.setdatoformulariorenta_descripcion(DatoFormularioRentaConstantesFunciones.getDatoFormularioRentaDescripcion(formulariorentaAux.getDatoFormularioRenta()));
			formulariorentaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(formulariorentaAux.getCuentaContable()));
			formulariorentaAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(formulariorentaAux.getTipoRetencion()));
			formulariorentaAux.setparametroformularioiva_descripcion(ParametroFormularioIvaConstantesFunciones.getParametroFormularioIvaDescripcion(formulariorentaAux.getParametroFormularioIva()));
			formulariorentaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(formulariorentaAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFormularioRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(DatoFormularioRenta.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(ParametroFormularioIva.class));
				classes.add(new Classe(Pais.class));
				
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
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroFormularioIva.class)) {
						classes.add(new Classe(ParametroFormularioIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFormularioRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(ParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFormularioIva.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(ParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFormularioIva.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormularioRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormularioRentaConstantesFunciones.getClassesRelationshipsOfFormularioRenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormularioRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormularioRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormularioRentaConstantesFunciones.getClassesRelationshipsFromStringsOfFormularioRenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormularioRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FormularioRenta formulariorenta,List<FormularioRenta> formulariorentas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FormularioRenta formulariorentaEncontrado=null;
			
			for(FormularioRenta formulariorentaLocal:formulariorentas) {
				if(formulariorentaLocal.getId().equals(formulariorenta.getId())) {
					formulariorentaEncontrado=formulariorentaLocal;
					
					formulariorentaLocal.setIsChanged(formulariorenta.getIsChanged());
					formulariorentaLocal.setIsNew(formulariorenta.getIsNew());
					formulariorentaLocal.setIsDeleted(formulariorenta.getIsDeleted());
					
					formulariorentaLocal.setGeneralEntityOriginal(formulariorenta.getGeneralEntityOriginal());
					
					formulariorentaLocal.setId(formulariorenta.getId());	
					formulariorentaLocal.setVersionRow(formulariorenta.getVersionRow());	
					formulariorentaLocal.setid_empresa(formulariorenta.getid_empresa());	
					formulariorentaLocal.setid_ejercicio(formulariorenta.getid_ejercicio());	
					formulariorentaLocal.setid_periodo(formulariorenta.getid_periodo());	
					formulariorentaLocal.setid_dato_formulario_renta(formulariorenta.getid_dato_formulario_renta());	
					formulariorentaLocal.setid_cuenta_contable(formulariorenta.getid_cuenta_contable());	
					formulariorentaLocal.setid_tipo_retencion(formulariorenta.getid_tipo_retencion());	
					formulariorentaLocal.setid_parametro_formulario_iva(formulariorenta.getid_parametro_formulario_iva());	
					formulariorentaLocal.setid_pais(formulariorenta.getid_pais());	
					formulariorentaLocal.setvalor_pagado(formulariorenta.getvalor_pagado());	
					formulariorentaLocal.setimpuesto_retenido(formulariorenta.getimpuesto_retenido());	
					formulariorentaLocal.setbase_impornible(formulariorenta.getbase_impornible());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!formulariorenta.getIsDeleted()) {
				if(!existe) {
					formulariorentas.add(formulariorenta);
				}
			} else {
				if(formulariorentaEncontrado!=null && permiteQuitar)  {
					formulariorentas.remove(formulariorentaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FormularioRenta formulariorenta,List<FormularioRenta> formulariorentas) throws Exception {
		try	{			
			for(FormularioRenta formulariorentaLocal:formulariorentas) {
				if(formulariorentaLocal.getId().equals(formulariorenta.getId())) {
					formulariorentaLocal.setIsSelected(formulariorenta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFormularioRenta(List<FormularioRenta> formulariorentasAux) throws Exception {
		//this.formulariorentasAux=formulariorentasAux;
		
		for(FormularioRenta formulariorentaAux:formulariorentasAux) {
			if(formulariorentaAux.getIsChanged()) {
				formulariorentaAux.setIsChanged(false);
			}		
			
			if(formulariorentaAux.getIsNew()) {
				formulariorentaAux.setIsNew(false);
			}	
			
			if(formulariorentaAux.getIsDeleted()) {
				formulariorentaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFormularioRenta(FormularioRenta formulariorentaAux) throws Exception {
		//this.formulariorentaAux=formulariorentaAux;
		
			if(formulariorentaAux.getIsChanged()) {
				formulariorentaAux.setIsChanged(false);
			}		
			
			if(formulariorentaAux.getIsNew()) {
				formulariorentaAux.setIsNew(false);
			}	
			
			if(formulariorentaAux.getIsDeleted()) {
				formulariorentaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FormularioRenta formulariorentaAsignar,FormularioRenta formulariorenta) throws Exception {
		formulariorentaAsignar.setId(formulariorenta.getId());	
		formulariorentaAsignar.setVersionRow(formulariorenta.getVersionRow());	
		formulariorentaAsignar.setid_empresa(formulariorenta.getid_empresa());
		formulariorentaAsignar.setempresa_descripcion(formulariorenta.getempresa_descripcion());	
		formulariorentaAsignar.setid_ejercicio(formulariorenta.getid_ejercicio());
		formulariorentaAsignar.setejercicio_descripcion(formulariorenta.getejercicio_descripcion());	
		formulariorentaAsignar.setid_periodo(formulariorenta.getid_periodo());
		formulariorentaAsignar.setperiodo_descripcion(formulariorenta.getperiodo_descripcion());	
		formulariorentaAsignar.setid_dato_formulario_renta(formulariorenta.getid_dato_formulario_renta());
		formulariorentaAsignar.setdatoformulariorenta_descripcion(formulariorenta.getdatoformulariorenta_descripcion());	
		formulariorentaAsignar.setid_cuenta_contable(formulariorenta.getid_cuenta_contable());
		formulariorentaAsignar.setcuentacontable_descripcion(formulariorenta.getcuentacontable_descripcion());	
		formulariorentaAsignar.setid_tipo_retencion(formulariorenta.getid_tipo_retencion());
		formulariorentaAsignar.settiporetencion_descripcion(formulariorenta.gettiporetencion_descripcion());	
		formulariorentaAsignar.setid_parametro_formulario_iva(formulariorenta.getid_parametro_formulario_iva());
		formulariorentaAsignar.setparametroformularioiva_descripcion(formulariorenta.getparametroformularioiva_descripcion());	
		formulariorentaAsignar.setid_pais(formulariorenta.getid_pais());
		formulariorentaAsignar.setpais_descripcion(formulariorenta.getpais_descripcion());	
		formulariorentaAsignar.setvalor_pagado(formulariorenta.getvalor_pagado());	
		formulariorentaAsignar.setimpuesto_retenido(formulariorenta.getimpuesto_retenido());	
		formulariorentaAsignar.setbase_impornible(formulariorenta.getbase_impornible());	
	}
	
	public static void inicializarFormularioRenta(FormularioRenta formulariorenta) throws Exception {
		try {
				formulariorenta.setId(0L);	
					
				formulariorenta.setid_empresa(-1L);	
				formulariorenta.setid_ejercicio(-1L);	
				formulariorenta.setid_periodo(-1L);	
				formulariorenta.setid_dato_formulario_renta(-1L);	
				formulariorenta.setid_cuenta_contable(-1L);	
				formulariorenta.setid_tipo_retencion(-1L);	
				formulariorenta.setid_parametro_formulario_iva(-1L);	
				formulariorenta.setid_pais(-1L);	
				formulariorenta.setvalor_pagado(0.0);	
				formulariorenta.setimpuesto_retenido(0.0);	
				formulariorenta.setbase_impornible(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFormularioRenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaConstantesFunciones.LABEL_IDDATOFORMULARIORENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaConstantesFunciones.LABEL_IDTIPORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaConstantesFunciones.LABEL_IDPARAMETROFORMULARIOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaConstantesFunciones.LABEL_VALORPAGADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaConstantesFunciones.LABEL_IMPUESTORETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormularioRentaConstantesFunciones.LABEL_BASEIMPORNIBLE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFormularioRenta(String sTipo,Row row,Workbook workbook,FormularioRenta formulariorenta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta.getdatoformulariorenta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta.gettiporetencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta.getparametroformularioiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta.getvalor_pagado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta.getimpuesto_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formulariorenta.getbase_impornible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFormularioRenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFormularioRenta() {
		return this.sFinalQueryFormularioRenta;
	}
	
	public void setsFinalQueryFormularioRenta(String sFinalQueryFormularioRenta) {
		this.sFinalQueryFormularioRenta= sFinalQueryFormularioRenta;
	}
	
	public Border resaltarSeleccionarFormularioRenta=null;
	
	public Border setResaltarSeleccionarFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//formulariorentaBeanSwingJInternalFrame.jTtoolBarFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFormularioRenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFormularioRenta() {
		return this.resaltarSeleccionarFormularioRenta;
	}
	
	public void setResaltarSeleccionarFormularioRenta(Border borderResaltarSeleccionarFormularioRenta) {
		this.resaltarSeleccionarFormularioRenta= borderResaltarSeleccionarFormularioRenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFormularioRenta=null;
	public Boolean mostraridFormularioRenta=true;
	public Boolean activaridFormularioRenta=true;

	public Border resaltarid_empresaFormularioRenta=null;
	public Boolean mostrarid_empresaFormularioRenta=true;
	public Boolean activarid_empresaFormularioRenta=true;
	public Boolean cargarid_empresaFormularioRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFormularioRenta=false;//ConEventDepend=true

	public Border resaltarid_ejercicioFormularioRenta=null;
	public Boolean mostrarid_ejercicioFormularioRenta=true;
	public Boolean activarid_ejercicioFormularioRenta=true;
	public Boolean cargarid_ejercicioFormularioRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioFormularioRenta=false;//ConEventDepend=true

	public Border resaltarid_periodoFormularioRenta=null;
	public Boolean mostrarid_periodoFormularioRenta=true;
	public Boolean activarid_periodoFormularioRenta=true;
	public Boolean cargarid_periodoFormularioRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoFormularioRenta=false;//ConEventDepend=true

	public Border resaltarid_dato_formulario_rentaFormularioRenta=null;
	public Boolean mostrarid_dato_formulario_rentaFormularioRenta=true;
	public Boolean activarid_dato_formulario_rentaFormularioRenta=true;
	public Boolean cargarid_dato_formulario_rentaFormularioRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_dato_formulario_rentaFormularioRenta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableFormularioRenta=null;
	public Boolean mostrarid_cuenta_contableFormularioRenta=true;
	public Boolean activarid_cuenta_contableFormularioRenta=true;
	public Boolean cargarid_cuenta_contableFormularioRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableFormularioRenta=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencionFormularioRenta=null;
	public Boolean mostrarid_tipo_retencionFormularioRenta=true;
	public Boolean activarid_tipo_retencionFormularioRenta=true;
	public Boolean cargarid_tipo_retencionFormularioRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencionFormularioRenta=false;//ConEventDepend=true

	public Border resaltarid_parametro_formulario_ivaFormularioRenta=null;
	public Boolean mostrarid_parametro_formulario_ivaFormularioRenta=true;
	public Boolean activarid_parametro_formulario_ivaFormularioRenta=true;
	public Boolean cargarid_parametro_formulario_ivaFormularioRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_parametro_formulario_ivaFormularioRenta=false;//ConEventDepend=true

	public Border resaltarid_paisFormularioRenta=null;
	public Boolean mostrarid_paisFormularioRenta=true;
	public Boolean activarid_paisFormularioRenta=true;
	public Boolean cargarid_paisFormularioRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisFormularioRenta=false;//ConEventDepend=true

	public Border resaltarvalor_pagadoFormularioRenta=null;
	public Boolean mostrarvalor_pagadoFormularioRenta=true;
	public Boolean activarvalor_pagadoFormularioRenta=true;

	public Border resaltarimpuesto_retenidoFormularioRenta=null;
	public Boolean mostrarimpuesto_retenidoFormularioRenta=true;
	public Boolean activarimpuesto_retenidoFormularioRenta=true;

	public Border resaltarbase_impornibleFormularioRenta=null;
	public Boolean mostrarbase_impornibleFormularioRenta=true;
	public Boolean activarbase_impornibleFormularioRenta=true;

	
	

	public Border setResaltaridFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaBeanSwingJInternalFrame.jTtoolBarFormularioRenta.setBorder(borderResaltar);
		
		this.resaltaridFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFormularioRenta() {
		return this.resaltaridFormularioRenta;
	}

	public void setResaltaridFormularioRenta(Border borderResaltar) {
		this.resaltaridFormularioRenta= borderResaltar;
	}

	public Boolean getMostraridFormularioRenta() {
		return this.mostraridFormularioRenta;
	}

	public void setMostraridFormularioRenta(Boolean mostraridFormularioRenta) {
		this.mostraridFormularioRenta= mostraridFormularioRenta;
	}

	public Boolean getActivaridFormularioRenta() {
		return this.activaridFormularioRenta;
	}

	public void setActivaridFormularioRenta(Boolean activaridFormularioRenta) {
		this.activaridFormularioRenta= activaridFormularioRenta;
	}

	public Border setResaltarid_empresaFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaBeanSwingJInternalFrame.jTtoolBarFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFormularioRenta() {
		return this.resaltarid_empresaFormularioRenta;
	}

	public void setResaltarid_empresaFormularioRenta(Border borderResaltar) {
		this.resaltarid_empresaFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaFormularioRenta() {
		return this.mostrarid_empresaFormularioRenta;
	}

	public void setMostrarid_empresaFormularioRenta(Boolean mostrarid_empresaFormularioRenta) {
		this.mostrarid_empresaFormularioRenta= mostrarid_empresaFormularioRenta;
	}

	public Boolean getActivarid_empresaFormularioRenta() {
		return this.activarid_empresaFormularioRenta;
	}

	public void setActivarid_empresaFormularioRenta(Boolean activarid_empresaFormularioRenta) {
		this.activarid_empresaFormularioRenta= activarid_empresaFormularioRenta;
	}

	public Boolean getCargarid_empresaFormularioRenta() {
		return this.cargarid_empresaFormularioRenta;
	}

	public void setCargarid_empresaFormularioRenta(Boolean cargarid_empresaFormularioRenta) {
		this.cargarid_empresaFormularioRenta= cargarid_empresaFormularioRenta;
	}

	public Border setResaltarid_ejercicioFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaBeanSwingJInternalFrame.jTtoolBarFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioFormularioRenta() {
		return this.resaltarid_ejercicioFormularioRenta;
	}

	public void setResaltarid_ejercicioFormularioRenta(Border borderResaltar) {
		this.resaltarid_ejercicioFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioFormularioRenta() {
		return this.mostrarid_ejercicioFormularioRenta;
	}

	public void setMostrarid_ejercicioFormularioRenta(Boolean mostrarid_ejercicioFormularioRenta) {
		this.mostrarid_ejercicioFormularioRenta= mostrarid_ejercicioFormularioRenta;
	}

	public Boolean getActivarid_ejercicioFormularioRenta() {
		return this.activarid_ejercicioFormularioRenta;
	}

	public void setActivarid_ejercicioFormularioRenta(Boolean activarid_ejercicioFormularioRenta) {
		this.activarid_ejercicioFormularioRenta= activarid_ejercicioFormularioRenta;
	}

	public Boolean getCargarid_ejercicioFormularioRenta() {
		return this.cargarid_ejercicioFormularioRenta;
	}

	public void setCargarid_ejercicioFormularioRenta(Boolean cargarid_ejercicioFormularioRenta) {
		this.cargarid_ejercicioFormularioRenta= cargarid_ejercicioFormularioRenta;
	}

	public Border setResaltarid_periodoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaBeanSwingJInternalFrame.jTtoolBarFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarid_periodoFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoFormularioRenta() {
		return this.resaltarid_periodoFormularioRenta;
	}

	public void setResaltarid_periodoFormularioRenta(Border borderResaltar) {
		this.resaltarid_periodoFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarid_periodoFormularioRenta() {
		return this.mostrarid_periodoFormularioRenta;
	}

	public void setMostrarid_periodoFormularioRenta(Boolean mostrarid_periodoFormularioRenta) {
		this.mostrarid_periodoFormularioRenta= mostrarid_periodoFormularioRenta;
	}

	public Boolean getActivarid_periodoFormularioRenta() {
		return this.activarid_periodoFormularioRenta;
	}

	public void setActivarid_periodoFormularioRenta(Boolean activarid_periodoFormularioRenta) {
		this.activarid_periodoFormularioRenta= activarid_periodoFormularioRenta;
	}

	public Boolean getCargarid_periodoFormularioRenta() {
		return this.cargarid_periodoFormularioRenta;
	}

	public void setCargarid_periodoFormularioRenta(Boolean cargarid_periodoFormularioRenta) {
		this.cargarid_periodoFormularioRenta= cargarid_periodoFormularioRenta;
	}

	public Border setResaltarid_dato_formulario_rentaFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaBeanSwingJInternalFrame.jTtoolBarFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarid_dato_formulario_rentaFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_dato_formulario_rentaFormularioRenta() {
		return this.resaltarid_dato_formulario_rentaFormularioRenta;
	}

	public void setResaltarid_dato_formulario_rentaFormularioRenta(Border borderResaltar) {
		this.resaltarid_dato_formulario_rentaFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarid_dato_formulario_rentaFormularioRenta() {
		return this.mostrarid_dato_formulario_rentaFormularioRenta;
	}

	public void setMostrarid_dato_formulario_rentaFormularioRenta(Boolean mostrarid_dato_formulario_rentaFormularioRenta) {
		this.mostrarid_dato_formulario_rentaFormularioRenta= mostrarid_dato_formulario_rentaFormularioRenta;
	}

	public Boolean getActivarid_dato_formulario_rentaFormularioRenta() {
		return this.activarid_dato_formulario_rentaFormularioRenta;
	}

	public void setActivarid_dato_formulario_rentaFormularioRenta(Boolean activarid_dato_formulario_rentaFormularioRenta) {
		this.activarid_dato_formulario_rentaFormularioRenta= activarid_dato_formulario_rentaFormularioRenta;
	}

	public Boolean getCargarid_dato_formulario_rentaFormularioRenta() {
		return this.cargarid_dato_formulario_rentaFormularioRenta;
	}

	public void setCargarid_dato_formulario_rentaFormularioRenta(Boolean cargarid_dato_formulario_rentaFormularioRenta) {
		this.cargarid_dato_formulario_rentaFormularioRenta= cargarid_dato_formulario_rentaFormularioRenta;
	}

	public Border setResaltarid_cuenta_contableFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaBeanSwingJInternalFrame.jTtoolBarFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableFormularioRenta() {
		return this.resaltarid_cuenta_contableFormularioRenta;
	}

	public void setResaltarid_cuenta_contableFormularioRenta(Border borderResaltar) {
		this.resaltarid_cuenta_contableFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableFormularioRenta() {
		return this.mostrarid_cuenta_contableFormularioRenta;
	}

	public void setMostrarid_cuenta_contableFormularioRenta(Boolean mostrarid_cuenta_contableFormularioRenta) {
		this.mostrarid_cuenta_contableFormularioRenta= mostrarid_cuenta_contableFormularioRenta;
	}

	public Boolean getActivarid_cuenta_contableFormularioRenta() {
		return this.activarid_cuenta_contableFormularioRenta;
	}

	public void setActivarid_cuenta_contableFormularioRenta(Boolean activarid_cuenta_contableFormularioRenta) {
		this.activarid_cuenta_contableFormularioRenta= activarid_cuenta_contableFormularioRenta;
	}

	public Boolean getCargarid_cuenta_contableFormularioRenta() {
		return this.cargarid_cuenta_contableFormularioRenta;
	}

	public void setCargarid_cuenta_contableFormularioRenta(Boolean cargarid_cuenta_contableFormularioRenta) {
		this.cargarid_cuenta_contableFormularioRenta= cargarid_cuenta_contableFormularioRenta;
	}

	public Border setResaltarid_tipo_retencionFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaBeanSwingJInternalFrame.jTtoolBarFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencionFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencionFormularioRenta() {
		return this.resaltarid_tipo_retencionFormularioRenta;
	}

	public void setResaltarid_tipo_retencionFormularioRenta(Border borderResaltar) {
		this.resaltarid_tipo_retencionFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencionFormularioRenta() {
		return this.mostrarid_tipo_retencionFormularioRenta;
	}

	public void setMostrarid_tipo_retencionFormularioRenta(Boolean mostrarid_tipo_retencionFormularioRenta) {
		this.mostrarid_tipo_retencionFormularioRenta= mostrarid_tipo_retencionFormularioRenta;
	}

	public Boolean getActivarid_tipo_retencionFormularioRenta() {
		return this.activarid_tipo_retencionFormularioRenta;
	}

	public void setActivarid_tipo_retencionFormularioRenta(Boolean activarid_tipo_retencionFormularioRenta) {
		this.activarid_tipo_retencionFormularioRenta= activarid_tipo_retencionFormularioRenta;
	}

	public Boolean getCargarid_tipo_retencionFormularioRenta() {
		return this.cargarid_tipo_retencionFormularioRenta;
	}

	public void setCargarid_tipo_retencionFormularioRenta(Boolean cargarid_tipo_retencionFormularioRenta) {
		this.cargarid_tipo_retencionFormularioRenta= cargarid_tipo_retencionFormularioRenta;
	}

	public Border setResaltarid_parametro_formulario_ivaFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaBeanSwingJInternalFrame.jTtoolBarFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarid_parametro_formulario_ivaFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_parametro_formulario_ivaFormularioRenta() {
		return this.resaltarid_parametro_formulario_ivaFormularioRenta;
	}

	public void setResaltarid_parametro_formulario_ivaFormularioRenta(Border borderResaltar) {
		this.resaltarid_parametro_formulario_ivaFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarid_parametro_formulario_ivaFormularioRenta() {
		return this.mostrarid_parametro_formulario_ivaFormularioRenta;
	}

	public void setMostrarid_parametro_formulario_ivaFormularioRenta(Boolean mostrarid_parametro_formulario_ivaFormularioRenta) {
		this.mostrarid_parametro_formulario_ivaFormularioRenta= mostrarid_parametro_formulario_ivaFormularioRenta;
	}

	public Boolean getActivarid_parametro_formulario_ivaFormularioRenta() {
		return this.activarid_parametro_formulario_ivaFormularioRenta;
	}

	public void setActivarid_parametro_formulario_ivaFormularioRenta(Boolean activarid_parametro_formulario_ivaFormularioRenta) {
		this.activarid_parametro_formulario_ivaFormularioRenta= activarid_parametro_formulario_ivaFormularioRenta;
	}

	public Boolean getCargarid_parametro_formulario_ivaFormularioRenta() {
		return this.cargarid_parametro_formulario_ivaFormularioRenta;
	}

	public void setCargarid_parametro_formulario_ivaFormularioRenta(Boolean cargarid_parametro_formulario_ivaFormularioRenta) {
		this.cargarid_parametro_formulario_ivaFormularioRenta= cargarid_parametro_formulario_ivaFormularioRenta;
	}

	public Border setResaltarid_paisFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaBeanSwingJInternalFrame.jTtoolBarFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarid_paisFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisFormularioRenta() {
		return this.resaltarid_paisFormularioRenta;
	}

	public void setResaltarid_paisFormularioRenta(Border borderResaltar) {
		this.resaltarid_paisFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarid_paisFormularioRenta() {
		return this.mostrarid_paisFormularioRenta;
	}

	public void setMostrarid_paisFormularioRenta(Boolean mostrarid_paisFormularioRenta) {
		this.mostrarid_paisFormularioRenta= mostrarid_paisFormularioRenta;
	}

	public Boolean getActivarid_paisFormularioRenta() {
		return this.activarid_paisFormularioRenta;
	}

	public void setActivarid_paisFormularioRenta(Boolean activarid_paisFormularioRenta) {
		this.activarid_paisFormularioRenta= activarid_paisFormularioRenta;
	}

	public Boolean getCargarid_paisFormularioRenta() {
		return this.cargarid_paisFormularioRenta;
	}

	public void setCargarid_paisFormularioRenta(Boolean cargarid_paisFormularioRenta) {
		this.cargarid_paisFormularioRenta= cargarid_paisFormularioRenta;
	}

	public Border setResaltarvalor_pagadoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaBeanSwingJInternalFrame.jTtoolBarFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarvalor_pagadoFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_pagadoFormularioRenta() {
		return this.resaltarvalor_pagadoFormularioRenta;
	}

	public void setResaltarvalor_pagadoFormularioRenta(Border borderResaltar) {
		this.resaltarvalor_pagadoFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarvalor_pagadoFormularioRenta() {
		return this.mostrarvalor_pagadoFormularioRenta;
	}

	public void setMostrarvalor_pagadoFormularioRenta(Boolean mostrarvalor_pagadoFormularioRenta) {
		this.mostrarvalor_pagadoFormularioRenta= mostrarvalor_pagadoFormularioRenta;
	}

	public Boolean getActivarvalor_pagadoFormularioRenta() {
		return this.activarvalor_pagadoFormularioRenta;
	}

	public void setActivarvalor_pagadoFormularioRenta(Boolean activarvalor_pagadoFormularioRenta) {
		this.activarvalor_pagadoFormularioRenta= activarvalor_pagadoFormularioRenta;
	}

	public Border setResaltarimpuesto_retenidoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaBeanSwingJInternalFrame.jTtoolBarFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarimpuesto_retenidoFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuesto_retenidoFormularioRenta() {
		return this.resaltarimpuesto_retenidoFormularioRenta;
	}

	public void setResaltarimpuesto_retenidoFormularioRenta(Border borderResaltar) {
		this.resaltarimpuesto_retenidoFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarimpuesto_retenidoFormularioRenta() {
		return this.mostrarimpuesto_retenidoFormularioRenta;
	}

	public void setMostrarimpuesto_retenidoFormularioRenta(Boolean mostrarimpuesto_retenidoFormularioRenta) {
		this.mostrarimpuesto_retenidoFormularioRenta= mostrarimpuesto_retenidoFormularioRenta;
	}

	public Boolean getActivarimpuesto_retenidoFormularioRenta() {
		return this.activarimpuesto_retenidoFormularioRenta;
	}

	public void setActivarimpuesto_retenidoFormularioRenta(Boolean activarimpuesto_retenidoFormularioRenta) {
		this.activarimpuesto_retenidoFormularioRenta= activarimpuesto_retenidoFormularioRenta;
	}

	public Border setResaltarbase_impornibleFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//formulariorentaBeanSwingJInternalFrame.jTtoolBarFormularioRenta.setBorder(borderResaltar);
		
		this.resaltarbase_impornibleFormularioRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_impornibleFormularioRenta() {
		return this.resaltarbase_impornibleFormularioRenta;
	}

	public void setResaltarbase_impornibleFormularioRenta(Border borderResaltar) {
		this.resaltarbase_impornibleFormularioRenta= borderResaltar;
	}

	public Boolean getMostrarbase_impornibleFormularioRenta() {
		return this.mostrarbase_impornibleFormularioRenta;
	}

	public void setMostrarbase_impornibleFormularioRenta(Boolean mostrarbase_impornibleFormularioRenta) {
		this.mostrarbase_impornibleFormularioRenta= mostrarbase_impornibleFormularioRenta;
	}

	public Boolean getActivarbase_impornibleFormularioRenta() {
		return this.activarbase_impornibleFormularioRenta;
	}

	public void setActivarbase_impornibleFormularioRenta(Boolean activarbase_impornibleFormularioRenta) {
		this.activarbase_impornibleFormularioRenta= activarbase_impornibleFormularioRenta;
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
		
		
		this.setMostraridFormularioRenta(esInicial);
		this.setMostrarid_empresaFormularioRenta(esInicial);
		this.setMostrarid_ejercicioFormularioRenta(esInicial);
		this.setMostrarid_periodoFormularioRenta(esInicial);
		this.setMostrarid_dato_formulario_rentaFormularioRenta(esInicial);
		this.setMostrarid_cuenta_contableFormularioRenta(esInicial);
		this.setMostrarid_tipo_retencionFormularioRenta(esInicial);
		this.setMostrarid_parametro_formulario_ivaFormularioRenta(esInicial);
		this.setMostrarid_paisFormularioRenta(esInicial);
		this.setMostrarvalor_pagadoFormularioRenta(esInicial);
		this.setMostrarimpuesto_retenidoFormularioRenta(esInicial);
		this.setMostrarbase_impornibleFormularioRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormularioRentaConstantesFunciones.ID)) {
				this.setMostraridFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDDATOFORMULARIORENTA)) {
				this.setMostrarid_dato_formulario_rentaFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDTIPORETENCION)) {
				this.setMostrarid_tipo_retencionFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDPARAMETROFORMULARIOIVA)) {
				this.setMostrarid_parametro_formulario_ivaFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.VALORPAGADO)) {
				this.setMostrarvalor_pagadoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IMPUESTORETENIDO)) {
				this.setMostrarimpuesto_retenidoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.BASEIMPORNIBLE)) {
				this.setMostrarbase_impornibleFormularioRenta(esAsigna);
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
		
		
		this.setActivaridFormularioRenta(esInicial);
		this.setActivarid_empresaFormularioRenta(esInicial);
		this.setActivarid_ejercicioFormularioRenta(esInicial);
		this.setActivarid_periodoFormularioRenta(esInicial);
		this.setActivarid_dato_formulario_rentaFormularioRenta(esInicial);
		this.setActivarid_cuenta_contableFormularioRenta(esInicial);
		this.setActivarid_tipo_retencionFormularioRenta(esInicial);
		this.setActivarid_parametro_formulario_ivaFormularioRenta(esInicial);
		this.setActivarid_paisFormularioRenta(esInicial);
		this.setActivarvalor_pagadoFormularioRenta(esInicial);
		this.setActivarimpuesto_retenidoFormularioRenta(esInicial);
		this.setActivarbase_impornibleFormularioRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormularioRentaConstantesFunciones.ID)) {
				this.setActivaridFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDDATOFORMULARIORENTA)) {
				this.setActivarid_dato_formulario_rentaFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDTIPORETENCION)) {
				this.setActivarid_tipo_retencionFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDPARAMETROFORMULARIOIVA)) {
				this.setActivarid_parametro_formulario_ivaFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.VALORPAGADO)) {
				this.setActivarvalor_pagadoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IMPUESTORETENIDO)) {
				this.setActivarimpuesto_retenidoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.BASEIMPORNIBLE)) {
				this.setActivarbase_impornibleFormularioRenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFormularioRenta(esInicial);
		this.setResaltarid_empresaFormularioRenta(esInicial);
		this.setResaltarid_ejercicioFormularioRenta(esInicial);
		this.setResaltarid_periodoFormularioRenta(esInicial);
		this.setResaltarid_dato_formulario_rentaFormularioRenta(esInicial);
		this.setResaltarid_cuenta_contableFormularioRenta(esInicial);
		this.setResaltarid_tipo_retencionFormularioRenta(esInicial);
		this.setResaltarid_parametro_formulario_ivaFormularioRenta(esInicial);
		this.setResaltarid_paisFormularioRenta(esInicial);
		this.setResaltarvalor_pagadoFormularioRenta(esInicial);
		this.setResaltarimpuesto_retenidoFormularioRenta(esInicial);
		this.setResaltarbase_impornibleFormularioRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormularioRentaConstantesFunciones.ID)) {
				this.setResaltaridFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDDATOFORMULARIORENTA)) {
				this.setResaltarid_dato_formulario_rentaFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDTIPORETENCION)) {
				this.setResaltarid_tipo_retencionFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDPARAMETROFORMULARIOIVA)) {
				this.setResaltarid_parametro_formulario_ivaFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.VALORPAGADO)) {
				this.setResaltarvalor_pagadoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.IMPUESTORETENIDO)) {
				this.setResaltarimpuesto_retenidoFormularioRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormularioRentaConstantesFunciones.BASEIMPORNIBLE)) {
				this.setResaltarbase_impornibleFormularioRenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableFormularioRenta=true;

	public Boolean getMostrarFK_IdCuentaContableFormularioRenta() {
		return this.mostrarFK_IdCuentaContableFormularioRenta;
	}

	public void setMostrarFK_IdCuentaContableFormularioRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableFormularioRenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDatoFormularioRentaFormularioRenta=true;

	public Boolean getMostrarFK_IdDatoFormularioRentaFormularioRenta() {
		return this.mostrarFK_IdDatoFormularioRentaFormularioRenta;
	}

	public void setMostrarFK_IdDatoFormularioRentaFormularioRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDatoFormularioRentaFormularioRenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioFormularioRenta=true;

	public Boolean getMostrarFK_IdEjercicioFormularioRenta() {
		return this.mostrarFK_IdEjercicioFormularioRenta;
	}

	public void setMostrarFK_IdEjercicioFormularioRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioFormularioRenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFormularioRenta=true;

	public Boolean getMostrarFK_IdEmpresaFormularioRenta() {
		return this.mostrarFK_IdEmpresaFormularioRenta;
	}

	public void setMostrarFK_IdEmpresaFormularioRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFormularioRenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisFormularioRenta=true;

	public Boolean getMostrarFK_IdPaisFormularioRenta() {
		return this.mostrarFK_IdPaisFormularioRenta;
	}

	public void setMostrarFK_IdPaisFormularioRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisFormularioRenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdParametroFormularioIvaFormularioRenta=true;

	public Boolean getMostrarFK_IdParametroFormularioIvaFormularioRenta() {
		return this.mostrarFK_IdParametroFormularioIvaFormularioRenta;
	}

	public void setMostrarFK_IdParametroFormularioIvaFormularioRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdParametroFormularioIvaFormularioRenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoFormularioRenta=true;

	public Boolean getMostrarFK_IdPeriodoFormularioRenta() {
		return this.mostrarFK_IdPeriodoFormularioRenta;
	}

	public void setMostrarFK_IdPeriodoFormularioRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoFormularioRenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionFormularioRenta=true;

	public Boolean getMostrarFK_IdTipoRetencionFormularioRenta() {
		return this.mostrarFK_IdTipoRetencionFormularioRenta;
	}

	public void setMostrarFK_IdTipoRetencionFormularioRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionFormularioRenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableFormularioRenta=true;

	public Boolean getActivarFK_IdCuentaContableFormularioRenta() {
		return this.activarFK_IdCuentaContableFormularioRenta;
	}

	public void setActivarFK_IdCuentaContableFormularioRenta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableFormularioRenta= habilitarResaltar;
	}

	public Boolean activarFK_IdDatoFormularioRentaFormularioRenta=true;

	public Boolean getActivarFK_IdDatoFormularioRentaFormularioRenta() {
		return this.activarFK_IdDatoFormularioRentaFormularioRenta;
	}

	public void setActivarFK_IdDatoFormularioRentaFormularioRenta(Boolean habilitarResaltar) {
		this.activarFK_IdDatoFormularioRentaFormularioRenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioFormularioRenta=true;

	public Boolean getActivarFK_IdEjercicioFormularioRenta() {
		return this.activarFK_IdEjercicioFormularioRenta;
	}

	public void setActivarFK_IdEjercicioFormularioRenta(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioFormularioRenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFormularioRenta=true;

	public Boolean getActivarFK_IdEmpresaFormularioRenta() {
		return this.activarFK_IdEmpresaFormularioRenta;
	}

	public void setActivarFK_IdEmpresaFormularioRenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFormularioRenta= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisFormularioRenta=true;

	public Boolean getActivarFK_IdPaisFormularioRenta() {
		return this.activarFK_IdPaisFormularioRenta;
	}

	public void setActivarFK_IdPaisFormularioRenta(Boolean habilitarResaltar) {
		this.activarFK_IdPaisFormularioRenta= habilitarResaltar;
	}

	public Boolean activarFK_IdParametroFormularioIvaFormularioRenta=true;

	public Boolean getActivarFK_IdParametroFormularioIvaFormularioRenta() {
		return this.activarFK_IdParametroFormularioIvaFormularioRenta;
	}

	public void setActivarFK_IdParametroFormularioIvaFormularioRenta(Boolean habilitarResaltar) {
		this.activarFK_IdParametroFormularioIvaFormularioRenta= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoFormularioRenta=true;

	public Boolean getActivarFK_IdPeriodoFormularioRenta() {
		return this.activarFK_IdPeriodoFormularioRenta;
	}

	public void setActivarFK_IdPeriodoFormularioRenta(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoFormularioRenta= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionFormularioRenta=true;

	public Boolean getActivarFK_IdTipoRetencionFormularioRenta() {
		return this.activarFK_IdTipoRetencionFormularioRenta;
	}

	public void setActivarFK_IdTipoRetencionFormularioRenta(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionFormularioRenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableFormularioRenta=null;

	public Border getResaltarFK_IdCuentaContableFormularioRenta() {
		return this.resaltarFK_IdCuentaContableFormularioRenta;
	}

	public void setResaltarFK_IdCuentaContableFormularioRenta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableFormularioRenta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableFormularioRenta= borderResaltar;
	}

	public Border resaltarFK_IdDatoFormularioRentaFormularioRenta=null;

	public Border getResaltarFK_IdDatoFormularioRentaFormularioRenta() {
		return this.resaltarFK_IdDatoFormularioRentaFormularioRenta;
	}

	public void setResaltarFK_IdDatoFormularioRentaFormularioRenta(Border borderResaltar) {
		this.resaltarFK_IdDatoFormularioRentaFormularioRenta= borderResaltar;
	}

	public void setResaltarFK_IdDatoFormularioRentaFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDatoFormularioRentaFormularioRenta= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioFormularioRenta=null;

	public Border getResaltarFK_IdEjercicioFormularioRenta() {
		return this.resaltarFK_IdEjercicioFormularioRenta;
	}

	public void setResaltarFK_IdEjercicioFormularioRenta(Border borderResaltar) {
		this.resaltarFK_IdEjercicioFormularioRenta= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioFormularioRenta= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFormularioRenta=null;

	public Border getResaltarFK_IdEmpresaFormularioRenta() {
		return this.resaltarFK_IdEmpresaFormularioRenta;
	}

	public void setResaltarFK_IdEmpresaFormularioRenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFormularioRenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFormularioRenta= borderResaltar;
	}

	public Border resaltarFK_IdPaisFormularioRenta=null;

	public Border getResaltarFK_IdPaisFormularioRenta() {
		return this.resaltarFK_IdPaisFormularioRenta;
	}

	public void setResaltarFK_IdPaisFormularioRenta(Border borderResaltar) {
		this.resaltarFK_IdPaisFormularioRenta= borderResaltar;
	}

	public void setResaltarFK_IdPaisFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisFormularioRenta= borderResaltar;
	}

	public Border resaltarFK_IdParametroFormularioIvaFormularioRenta=null;

	public Border getResaltarFK_IdParametroFormularioIvaFormularioRenta() {
		return this.resaltarFK_IdParametroFormularioIvaFormularioRenta;
	}

	public void setResaltarFK_IdParametroFormularioIvaFormularioRenta(Border borderResaltar) {
		this.resaltarFK_IdParametroFormularioIvaFormularioRenta= borderResaltar;
	}

	public void setResaltarFK_IdParametroFormularioIvaFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdParametroFormularioIvaFormularioRenta= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoFormularioRenta=null;

	public Border getResaltarFK_IdPeriodoFormularioRenta() {
		return this.resaltarFK_IdPeriodoFormularioRenta;
	}

	public void setResaltarFK_IdPeriodoFormularioRenta(Border borderResaltar) {
		this.resaltarFK_IdPeriodoFormularioRenta= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoFormularioRenta= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionFormularioRenta=null;

	public Border getResaltarFK_IdTipoRetencionFormularioRenta() {
		return this.resaltarFK_IdTipoRetencionFormularioRenta;
	}

	public void setResaltarFK_IdTipoRetencionFormularioRenta(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionFormularioRenta= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionFormularioRenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormularioRentaBeanSwingJInternalFrame formulariorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionFormularioRenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}