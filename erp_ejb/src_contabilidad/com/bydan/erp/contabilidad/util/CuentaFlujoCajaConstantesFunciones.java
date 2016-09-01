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


import com.bydan.erp.contabilidad.util.CuentaFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.CuentaFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.CuentaFlujoCajaParameterGeneral;

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
final public class CuentaFlujoCajaConstantesFunciones extends CuentaFlujoCajaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CuentaFlujoCaja";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CuentaFlujoCaja"+CuentaFlujoCajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CuentaFlujoCajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CuentaFlujoCajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CuentaFlujoCajaConstantesFunciones.SCHEMA+"_"+CuentaFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CuentaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CuentaFlujoCajaConstantesFunciones.SCHEMA+"_"+CuentaFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CuentaFlujoCajaConstantesFunciones.SCHEMA+"_"+CuentaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CuentaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CuentaFlujoCajaConstantesFunciones.SCHEMA+"_"+CuentaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CuentaFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CuentaFlujoCajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CuentaFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CuentaFlujoCajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cuenta Flujo Cajas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cuenta Flujo Caja";
	public static final String SCLASSWEBTITULO_LOWER="Cuenta Flujo Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CuentaFlujoCaja";
	public static final String OBJECTNAME="cuentaflujocaja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="cuenta_flujo_caja";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cuentaflujocaja from "+CuentaFlujoCajaConstantesFunciones.SPERSISTENCENAME+" cuentaflujocaja";
	public static String QUERYSELECTNATIVE="select "+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".id,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".id_empresa,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".nombre,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".id_mes,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".id_dia,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".formula,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".es_flujo_caja,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".con_agrupar from "+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME;//+" as "+CuentaFlujoCajaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CuentaFlujoCajaConstantesFuncionesAdditional cuentaflujocajaConstantesFuncionesAdditional=null;
	
	public CuentaFlujoCajaConstantesFuncionesAdditional getCuentaFlujoCajaConstantesFuncionesAdditional() {
		return this.cuentaflujocajaConstantesFuncionesAdditional;
	}
	
	public void setCuentaFlujoCajaConstantesFuncionesAdditional(CuentaFlujoCajaConstantesFuncionesAdditional cuentaflujocajaConstantesFuncionesAdditional) {
		try {
			this.cuentaflujocajaConstantesFuncionesAdditional=cuentaflujocajaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String IDMES= "id_mes";
    public static final String IDDIA= "id_dia";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String FORMULA= "formula";
    public static final String ESFLUJOCAJA= "es_flujo_caja";
    public static final String CONAGRUPAR= "con_agrupar";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDDIA= "Dia";
		public static final String LABEL_IDDIA_LOWER= "Dia";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_FORMULA= "Formula";
		public static final String LABEL_FORMULA_LOWER= "Formula";
    	public static final String LABEL_ESFLUJOCAJA= "Es Flujo Caja";
		public static final String LABEL_ESFLUJOCAJA_LOWER= "Es Flujo Caja";
    	public static final String LABEL_CONAGRUPAR= "Con Agrupar";
		public static final String LABEL_CONAGRUPAR_LOWER= "Con Agrupar";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXFORMULA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFORMULA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getCuentaFlujoCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CuentaFlujoCajaConstantesFunciones.IDEMPRESA)) {sLabelColumna=CuentaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CuentaFlujoCajaConstantesFunciones.NOMBRE)) {sLabelColumna=CuentaFlujoCajaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CuentaFlujoCajaConstantesFunciones.IDMES)) {sLabelColumna=CuentaFlujoCajaConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(CuentaFlujoCajaConstantesFunciones.IDDIA)) {sLabelColumna=CuentaFlujoCajaConstantesFunciones.LABEL_IDDIA;}
		if(sNombreColumna.equals(CuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=CuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(CuentaFlujoCajaConstantesFunciones.FORMULA)) {sLabelColumna=CuentaFlujoCajaConstantesFunciones.LABEL_FORMULA;}
		if(sNombreColumna.equals(CuentaFlujoCajaConstantesFunciones.ESFLUJOCAJA)) {sLabelColumna=CuentaFlujoCajaConstantesFunciones.LABEL_ESFLUJOCAJA;}
		if(sNombreColumna.equals(CuentaFlujoCajaConstantesFunciones.CONAGRUPAR)) {sLabelColumna=CuentaFlujoCajaConstantesFunciones.LABEL_CONAGRUPAR;}
		
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
	
	
	
			
			
			
			
			
			
			
			
		
	public static String getes_flujo_cajaDescripcion(CuentaFlujoCaja cuentaflujocaja) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cuentaflujocaja.getes_flujo_caja()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_flujo_cajaHtmlDescripcion(CuentaFlujoCaja cuentaflujocaja) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cuentaflujocaja.getId(),cuentaflujocaja.getes_flujo_caja());

		return sDescripcion;
	}	
		
	public static String getcon_agruparDescripcion(CuentaFlujoCaja cuentaflujocaja) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cuentaflujocaja.getcon_agrupar()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_agruparHtmlDescripcion(CuentaFlujoCaja cuentaflujocaja) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cuentaflujocaja.getId(),cuentaflujocaja.getcon_agrupar());

		return sDescripcion;
	}	
	
	public static String getCuentaFlujoCajaDescripcion(CuentaFlujoCaja cuentaflujocaja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cuentaflujocaja !=null/* && cuentaflujocaja.getId()!=0*/) {
			sDescripcion=cuentaflujocaja.getnombre();//cuentaflujocajacuentaflujocaja.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCuentaFlujoCajaDescripcionDetallado(CuentaFlujoCaja cuentaflujocaja) {
		String sDescripcion="";
			
		sDescripcion+=CuentaFlujoCajaConstantesFunciones.ID+"=";
		sDescripcion+=cuentaflujocaja.getId().toString()+",";
		sDescripcion+=CuentaFlujoCajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cuentaflujocaja.getVersionRow().toString()+",";
		sDescripcion+=CuentaFlujoCajaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cuentaflujocaja.getid_empresa().toString()+",";
		sDescripcion+=CuentaFlujoCajaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cuentaflujocaja.getnombre()+",";
		sDescripcion+=CuentaFlujoCajaConstantesFunciones.IDMES+"=";
		sDescripcion+=cuentaflujocaja.getid_mes().toString()+",";
		sDescripcion+=CuentaFlujoCajaConstantesFunciones.IDDIA+"=";
		sDescripcion+=cuentaflujocaja.getid_dia().toString()+",";
		sDescripcion+=CuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=cuentaflujocaja.getid_cuenta_contable().toString()+",";
		sDescripcion+=CuentaFlujoCajaConstantesFunciones.FORMULA+"=";
		sDescripcion+=cuentaflujocaja.getformula()+",";
		sDescripcion+=CuentaFlujoCajaConstantesFunciones.ESFLUJOCAJA+"=";
		sDescripcion+=cuentaflujocaja.getes_flujo_caja().toString()+",";
		sDescripcion+=CuentaFlujoCajaConstantesFunciones.CONAGRUPAR+"=";
		sDescripcion+=cuentaflujocaja.getcon_agrupar().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCuentaFlujoCajaDescripcion(CuentaFlujoCaja cuentaflujocaja,String sValor) throws Exception {			
		if(cuentaflujocaja !=null) {
			cuentaflujocaja.setnombre(sValor);;//cuentaflujocajacuentaflujocaja.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getDiaDescripcion(Dia dia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(dia!=null/*&&dia.getId()>0*/) {
			sDescripcion=DiaConstantesFunciones.getDiaDescripcion(dia);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdDia")) {
			sNombreIndice="Tipo=  Por Dia";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDia(Long id_dia) {
		String sDetalleIndice=" Parametros->";
		if(id_dia!=null) {sDetalleIndice+=" Codigo Unico De Dia="+id_dia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCuentaFlujoCaja(CuentaFlujoCaja cuentaflujocaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cuentaflujocaja.setnombre(cuentaflujocaja.getnombre().trim());
		cuentaflujocaja.setformula(cuentaflujocaja.getformula().trim());
	}
	
	public static void quitarEspaciosCuentaFlujoCajas(List<CuentaFlujoCaja> cuentaflujocajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CuentaFlujoCaja cuentaflujocaja: cuentaflujocajas) {
			cuentaflujocaja.setnombre(cuentaflujocaja.getnombre().trim());
			cuentaflujocaja.setformula(cuentaflujocaja.getformula().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaFlujoCaja(CuentaFlujoCaja cuentaflujocaja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cuentaflujocaja.getConCambioAuxiliar()) {
			cuentaflujocaja.setIsDeleted(cuentaflujocaja.getIsDeletedAuxiliar());	
			cuentaflujocaja.setIsNew(cuentaflujocaja.getIsNewAuxiliar());	
			cuentaflujocaja.setIsChanged(cuentaflujocaja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cuentaflujocaja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cuentaflujocaja.setIsDeletedAuxiliar(false);	
			cuentaflujocaja.setIsNewAuxiliar(false);	
			cuentaflujocaja.setIsChangedAuxiliar(false);
			
			cuentaflujocaja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaFlujoCajas(List<CuentaFlujoCaja> cuentaflujocajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CuentaFlujoCaja cuentaflujocaja : cuentaflujocajas) {
			if(conAsignarBase && cuentaflujocaja.getConCambioAuxiliar()) {
				cuentaflujocaja.setIsDeleted(cuentaflujocaja.getIsDeletedAuxiliar());	
				cuentaflujocaja.setIsNew(cuentaflujocaja.getIsNewAuxiliar());	
				cuentaflujocaja.setIsChanged(cuentaflujocaja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cuentaflujocaja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cuentaflujocaja.setIsDeletedAuxiliar(false);	
				cuentaflujocaja.setIsNewAuxiliar(false);	
				cuentaflujocaja.setIsChangedAuxiliar(false);
				
				cuentaflujocaja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCuentaFlujoCaja(CuentaFlujoCaja cuentaflujocaja,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCuentaFlujoCajas(List<CuentaFlujoCaja> cuentaflujocajas,Boolean conEnteros) throws Exception  {
		
		for(CuentaFlujoCaja cuentaflujocaja: cuentaflujocajas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCuentaFlujoCaja(List<CuentaFlujoCaja> cuentaflujocajas,CuentaFlujoCaja cuentaflujocajaAux) throws Exception  {
		CuentaFlujoCajaConstantesFunciones.InicializarValoresCuentaFlujoCaja(cuentaflujocajaAux,true);
		
		for(CuentaFlujoCaja cuentaflujocaja: cuentaflujocajas) {
			if(cuentaflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CuentaFlujoCajaConstantesFunciones.getArrayColumnasGlobalesCuentaFlujoCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaFlujoCajaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaFlujoCajaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCuentaFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CuentaFlujoCaja> cuentaflujocajas,CuentaFlujoCaja cuentaflujocaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CuentaFlujoCaja cuentaflujocajaAux: cuentaflujocajas) {
			if(cuentaflujocajaAux!=null && cuentaflujocaja!=null) {
				if((cuentaflujocajaAux.getId()==null && cuentaflujocaja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cuentaflujocajaAux.getId()!=null && cuentaflujocaja.getId()!=null){
					if(cuentaflujocajaAux.getId().equals(cuentaflujocaja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCuentaFlujoCaja(List<CuentaFlujoCaja> cuentaflujocajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CuentaFlujoCaja cuentaflujocaja: cuentaflujocajas) {			
			if(cuentaflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCuentaFlujoCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CuentaFlujoCajaConstantesFunciones.LABEL_ID, CuentaFlujoCajaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaFlujoCajaConstantesFunciones.LABEL_VERSIONROW, CuentaFlujoCajaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA, CuentaFlujoCajaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaFlujoCajaConstantesFunciones.LABEL_NOMBRE, CuentaFlujoCajaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaFlujoCajaConstantesFunciones.LABEL_IDMES, CuentaFlujoCajaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaFlujoCajaConstantesFunciones.LABEL_IDDIA, CuentaFlujoCajaConstantesFunciones.IDDIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE, CuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaFlujoCajaConstantesFunciones.LABEL_FORMULA, CuentaFlujoCajaConstantesFunciones.FORMULA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaFlujoCajaConstantesFunciones.LABEL_ESFLUJOCAJA, CuentaFlujoCajaConstantesFunciones.ESFLUJOCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaFlujoCajaConstantesFunciones.LABEL_CONAGRUPAR, CuentaFlujoCajaConstantesFunciones.CONAGRUPAR,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCuentaFlujoCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CuentaFlujoCajaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaFlujoCajaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaFlujoCajaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaFlujoCajaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaFlujoCajaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaFlujoCajaConstantesFunciones.IDDIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaFlujoCajaConstantesFunciones.FORMULA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaFlujoCajaConstantesFunciones.ESFLUJOCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaFlujoCajaConstantesFunciones.CONAGRUPAR;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaFlujoCaja() throws Exception  {
		return CuentaFlujoCajaConstantesFunciones.getTiposSeleccionarCuentaFlujoCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaFlujoCaja(Boolean conFk) throws Exception  {
		return CuentaFlujoCajaConstantesFunciones.getTiposSeleccionarCuentaFlujoCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaFlujoCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CuentaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaFlujoCajaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CuentaFlujoCajaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaFlujoCajaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(CuentaFlujoCajaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaFlujoCajaConstantesFunciones.LABEL_IDDIA);
			reporte.setsDescripcion(CuentaFlujoCajaConstantesFunciones.LABEL_IDDIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(CuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaFlujoCajaConstantesFunciones.LABEL_FORMULA);
			reporte.setsDescripcion(CuentaFlujoCajaConstantesFunciones.LABEL_FORMULA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaFlujoCajaConstantesFunciones.LABEL_ESFLUJOCAJA);
			reporte.setsDescripcion(CuentaFlujoCajaConstantesFunciones.LABEL_ESFLUJOCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaFlujoCajaConstantesFunciones.LABEL_CONAGRUPAR);
			reporte.setsDescripcion(CuentaFlujoCajaConstantesFunciones.LABEL_CONAGRUPAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCuentaFlujoCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaFlujoCaja(CuentaFlujoCaja cuentaflujocajaAux) throws Exception {
		
			cuentaflujocajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentaflujocajaAux.getEmpresa()));
			cuentaflujocajaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(cuentaflujocajaAux.getMes()));
			cuentaflujocajaAux.setdia_descripcion(DiaConstantesFunciones.getDiaDescripcion(cuentaflujocajaAux.getDia()));
			cuentaflujocajaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentaflujocajaAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaFlujoCaja(List<CuentaFlujoCaja> cuentaflujocajasTemp) throws Exception {
		for(CuentaFlujoCaja cuentaflujocajaAux:cuentaflujocajasTemp) {
			
			cuentaflujocajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentaflujocajaAux.getEmpresa()));
			cuentaflujocajaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(cuentaflujocajaAux.getMes()));
			cuentaflujocajaAux.setdia_descripcion(DiaConstantesFunciones.getDiaDescripcion(cuentaflujocajaAux.getDia()));
			cuentaflujocajaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentaflujocajaAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Dia.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Dia.class)) {
						classes.add(new Classe(Dia.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCuentaFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Dia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Dia.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Dia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Dia.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaFlujoCajaConstantesFunciones.getClassesRelationshipsOfCuentaFlujoCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleCuentaFlujoCaja.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleCuentaFlujoCaja.class)) {
						classes.add(new Classe(DetalleCuentaFlujoCaja.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaFlujoCajaConstantesFunciones.getClassesRelationshipsFromStringsOfCuentaFlujoCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleCuentaFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCuentaFlujoCaja.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleCuentaFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleCuentaFlujoCaja.class)); continue;
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
	public static void actualizarLista(CuentaFlujoCaja cuentaflujocaja,List<CuentaFlujoCaja> cuentaflujocajas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CuentaFlujoCaja cuentaflujocajaEncontrado=null;
			
			for(CuentaFlujoCaja cuentaflujocajaLocal:cuentaflujocajas) {
				if(cuentaflujocajaLocal.getId().equals(cuentaflujocaja.getId())) {
					cuentaflujocajaEncontrado=cuentaflujocajaLocal;
					
					cuentaflujocajaLocal.setIsChanged(cuentaflujocaja.getIsChanged());
					cuentaflujocajaLocal.setIsNew(cuentaflujocaja.getIsNew());
					cuentaflujocajaLocal.setIsDeleted(cuentaflujocaja.getIsDeleted());
					
					cuentaflujocajaLocal.setGeneralEntityOriginal(cuentaflujocaja.getGeneralEntityOriginal());
					
					cuentaflujocajaLocal.setId(cuentaflujocaja.getId());	
					cuentaflujocajaLocal.setVersionRow(cuentaflujocaja.getVersionRow());	
					cuentaflujocajaLocal.setid_empresa(cuentaflujocaja.getid_empresa());	
					cuentaflujocajaLocal.setnombre(cuentaflujocaja.getnombre());	
					cuentaflujocajaLocal.setid_mes(cuentaflujocaja.getid_mes());	
					cuentaflujocajaLocal.setid_dia(cuentaflujocaja.getid_dia());	
					cuentaflujocajaLocal.setid_cuenta_contable(cuentaflujocaja.getid_cuenta_contable());	
					cuentaflujocajaLocal.setformula(cuentaflujocaja.getformula());	
					cuentaflujocajaLocal.setes_flujo_caja(cuentaflujocaja.getes_flujo_caja());	
					cuentaflujocajaLocal.setcon_agrupar(cuentaflujocaja.getcon_agrupar());	
					
					
					cuentaflujocajaLocal.setDetalleCuentaFlujoCajas(cuentaflujocaja.getDetalleCuentaFlujoCajas());
					
					existe=true;
					break;
				}
			}
			
			if(!cuentaflujocaja.getIsDeleted()) {
				if(!existe) {
					cuentaflujocajas.add(cuentaflujocaja);
				}
			} else {
				if(cuentaflujocajaEncontrado!=null && permiteQuitar)  {
					cuentaflujocajas.remove(cuentaflujocajaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CuentaFlujoCaja cuentaflujocaja,List<CuentaFlujoCaja> cuentaflujocajas) throws Exception {
		try	{			
			for(CuentaFlujoCaja cuentaflujocajaLocal:cuentaflujocajas) {
				if(cuentaflujocajaLocal.getId().equals(cuentaflujocaja.getId())) {
					cuentaflujocajaLocal.setIsSelected(cuentaflujocaja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCuentaFlujoCaja(List<CuentaFlujoCaja> cuentaflujocajasAux) throws Exception {
		//this.cuentaflujocajasAux=cuentaflujocajasAux;
		
		for(CuentaFlujoCaja cuentaflujocajaAux:cuentaflujocajasAux) {
			if(cuentaflujocajaAux.getIsChanged()) {
				cuentaflujocajaAux.setIsChanged(false);
			}		
			
			if(cuentaflujocajaAux.getIsNew()) {
				cuentaflujocajaAux.setIsNew(false);
			}	
			
			if(cuentaflujocajaAux.getIsDeleted()) {
				cuentaflujocajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCuentaFlujoCaja(CuentaFlujoCaja cuentaflujocajaAux) throws Exception {
		//this.cuentaflujocajaAux=cuentaflujocajaAux;
		
			if(cuentaflujocajaAux.getIsChanged()) {
				cuentaflujocajaAux.setIsChanged(false);
			}		
			
			if(cuentaflujocajaAux.getIsNew()) {
				cuentaflujocajaAux.setIsNew(false);
			}	
			
			if(cuentaflujocajaAux.getIsDeleted()) {
				cuentaflujocajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CuentaFlujoCaja cuentaflujocajaAsignar,CuentaFlujoCaja cuentaflujocaja) throws Exception {
		cuentaflujocajaAsignar.setId(cuentaflujocaja.getId());	
		cuentaflujocajaAsignar.setVersionRow(cuentaflujocaja.getVersionRow());	
		cuentaflujocajaAsignar.setid_empresa(cuentaflujocaja.getid_empresa());
		cuentaflujocajaAsignar.setempresa_descripcion(cuentaflujocaja.getempresa_descripcion());	
		cuentaflujocajaAsignar.setnombre(cuentaflujocaja.getnombre());	
		cuentaflujocajaAsignar.setid_mes(cuentaflujocaja.getid_mes());
		cuentaflujocajaAsignar.setmes_descripcion(cuentaflujocaja.getmes_descripcion());	
		cuentaflujocajaAsignar.setid_dia(cuentaflujocaja.getid_dia());
		cuentaflujocajaAsignar.setdia_descripcion(cuentaflujocaja.getdia_descripcion());	
		cuentaflujocajaAsignar.setid_cuenta_contable(cuentaflujocaja.getid_cuenta_contable());
		cuentaflujocajaAsignar.setcuentacontable_descripcion(cuentaflujocaja.getcuentacontable_descripcion());	
		cuentaflujocajaAsignar.setformula(cuentaflujocaja.getformula());	
		cuentaflujocajaAsignar.setes_flujo_caja(cuentaflujocaja.getes_flujo_caja());	
		cuentaflujocajaAsignar.setcon_agrupar(cuentaflujocaja.getcon_agrupar());	
	}
	
	public static void inicializarCuentaFlujoCaja(CuentaFlujoCaja cuentaflujocaja) throws Exception {
		try {
				cuentaflujocaja.setId(0L);	
					
				cuentaflujocaja.setid_empresa(-1L);	
				cuentaflujocaja.setnombre("");	
				cuentaflujocaja.setid_mes(null);	
				cuentaflujocaja.setid_dia(-1L);	
				cuentaflujocaja.setid_cuenta_contable(-1L);	
				cuentaflujocaja.setformula("");	
				cuentaflujocaja.setes_flujo_caja(false);	
				cuentaflujocaja.setcon_agrupar(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCuentaFlujoCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaFlujoCajaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaFlujoCajaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaFlujoCajaConstantesFunciones.LABEL_IDDIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaFlujoCajaConstantesFunciones.LABEL_FORMULA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaFlujoCajaConstantesFunciones.LABEL_ESFLUJOCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaFlujoCajaConstantesFunciones.LABEL_CONAGRUPAR);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCuentaFlujoCaja(String sTipo,Row row,Workbook workbook,CuentaFlujoCaja cuentaflujocaja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaflujocaja.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaflujocaja.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaflujocaja.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaflujocaja.getdia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaflujocaja.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaflujocaja.getformula());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cuentaflujocaja.getes_flujo_caja()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cuentaflujocaja.getcon_agrupar()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCuentaFlujoCaja=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCuentaFlujoCaja() {
		return this.sFinalQueryCuentaFlujoCaja;
	}
	
	public void setsFinalQueryCuentaFlujoCaja(String sFinalQueryCuentaFlujoCaja) {
		this.sFinalQueryCuentaFlujoCaja= sFinalQueryCuentaFlujoCaja;
	}
	
	public Border resaltarSeleccionarCuentaFlujoCaja=null;
	
	public Border setResaltarSeleccionarCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cuentaflujocajaBeanSwingJInternalFrame.jTtoolBarCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCuentaFlujoCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCuentaFlujoCaja() {
		return this.resaltarSeleccionarCuentaFlujoCaja;
	}
	
	public void setResaltarSeleccionarCuentaFlujoCaja(Border borderResaltarSeleccionarCuentaFlujoCaja) {
		this.resaltarSeleccionarCuentaFlujoCaja= borderResaltarSeleccionarCuentaFlujoCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCuentaFlujoCaja=null;
	public Boolean mostraridCuentaFlujoCaja=true;
	public Boolean activaridCuentaFlujoCaja=true;

	public Border resaltarid_empresaCuentaFlujoCaja=null;
	public Boolean mostrarid_empresaCuentaFlujoCaja=true;
	public Boolean activarid_empresaCuentaFlujoCaja=true;
	public Boolean cargarid_empresaCuentaFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCuentaFlujoCaja=false;//ConEventDepend=true

	public Border resaltarnombreCuentaFlujoCaja=null;
	public Boolean mostrarnombreCuentaFlujoCaja=true;
	public Boolean activarnombreCuentaFlujoCaja=true;

	public Border resaltarid_mesCuentaFlujoCaja=null;
	public Boolean mostrarid_mesCuentaFlujoCaja=true;
	public Boolean activarid_mesCuentaFlujoCaja=true;
	public Boolean cargarid_mesCuentaFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesCuentaFlujoCaja=false;//ConEventDepend=true

	public Border resaltarid_diaCuentaFlujoCaja=null;
	public Boolean mostrarid_diaCuentaFlujoCaja=true;
	public Boolean activarid_diaCuentaFlujoCaja=true;
	public Boolean cargarid_diaCuentaFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_diaCuentaFlujoCaja=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableCuentaFlujoCaja=null;
	public Boolean mostrarid_cuenta_contableCuentaFlujoCaja=true;
	public Boolean activarid_cuenta_contableCuentaFlujoCaja=true;
	public Boolean cargarid_cuenta_contableCuentaFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableCuentaFlujoCaja=false;//ConEventDepend=true

	public Border resaltarformulaCuentaFlujoCaja=null;
	public Boolean mostrarformulaCuentaFlujoCaja=true;
	public Boolean activarformulaCuentaFlujoCaja=true;

	public Border resaltares_flujo_cajaCuentaFlujoCaja=null;
	public Boolean mostrares_flujo_cajaCuentaFlujoCaja=true;
	public Boolean activares_flujo_cajaCuentaFlujoCaja=true;

	public Border resaltarcon_agruparCuentaFlujoCaja=null;
	public Boolean mostrarcon_agruparCuentaFlujoCaja=true;
	public Boolean activarcon_agruparCuentaFlujoCaja=true;

	
	

	public Border setResaltaridCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaflujocajaBeanSwingJInternalFrame.jTtoolBarCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltaridCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCuentaFlujoCaja() {
		return this.resaltaridCuentaFlujoCaja;
	}

	public void setResaltaridCuentaFlujoCaja(Border borderResaltar) {
		this.resaltaridCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostraridCuentaFlujoCaja() {
		return this.mostraridCuentaFlujoCaja;
	}

	public void setMostraridCuentaFlujoCaja(Boolean mostraridCuentaFlujoCaja) {
		this.mostraridCuentaFlujoCaja= mostraridCuentaFlujoCaja;
	}

	public Boolean getActivaridCuentaFlujoCaja() {
		return this.activaridCuentaFlujoCaja;
	}

	public void setActivaridCuentaFlujoCaja(Boolean activaridCuentaFlujoCaja) {
		this.activaridCuentaFlujoCaja= activaridCuentaFlujoCaja;
	}

	public Border setResaltarid_empresaCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaflujocajaBeanSwingJInternalFrame.jTtoolBarCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_empresaCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCuentaFlujoCaja() {
		return this.resaltarid_empresaCuentaFlujoCaja;
	}

	public void setResaltarid_empresaCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarid_empresaCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_empresaCuentaFlujoCaja() {
		return this.mostrarid_empresaCuentaFlujoCaja;
	}

	public void setMostrarid_empresaCuentaFlujoCaja(Boolean mostrarid_empresaCuentaFlujoCaja) {
		this.mostrarid_empresaCuentaFlujoCaja= mostrarid_empresaCuentaFlujoCaja;
	}

	public Boolean getActivarid_empresaCuentaFlujoCaja() {
		return this.activarid_empresaCuentaFlujoCaja;
	}

	public void setActivarid_empresaCuentaFlujoCaja(Boolean activarid_empresaCuentaFlujoCaja) {
		this.activarid_empresaCuentaFlujoCaja= activarid_empresaCuentaFlujoCaja;
	}

	public Boolean getCargarid_empresaCuentaFlujoCaja() {
		return this.cargarid_empresaCuentaFlujoCaja;
	}

	public void setCargarid_empresaCuentaFlujoCaja(Boolean cargarid_empresaCuentaFlujoCaja) {
		this.cargarid_empresaCuentaFlujoCaja= cargarid_empresaCuentaFlujoCaja;
	}

	public Border setResaltarnombreCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaflujocajaBeanSwingJInternalFrame.jTtoolBarCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarnombreCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCuentaFlujoCaja() {
		return this.resaltarnombreCuentaFlujoCaja;
	}

	public void setResaltarnombreCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarnombreCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarnombreCuentaFlujoCaja() {
		return this.mostrarnombreCuentaFlujoCaja;
	}

	public void setMostrarnombreCuentaFlujoCaja(Boolean mostrarnombreCuentaFlujoCaja) {
		this.mostrarnombreCuentaFlujoCaja= mostrarnombreCuentaFlujoCaja;
	}

	public Boolean getActivarnombreCuentaFlujoCaja() {
		return this.activarnombreCuentaFlujoCaja;
	}

	public void setActivarnombreCuentaFlujoCaja(Boolean activarnombreCuentaFlujoCaja) {
		this.activarnombreCuentaFlujoCaja= activarnombreCuentaFlujoCaja;
	}

	public Border setResaltarid_mesCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaflujocajaBeanSwingJInternalFrame.jTtoolBarCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_mesCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesCuentaFlujoCaja() {
		return this.resaltarid_mesCuentaFlujoCaja;
	}

	public void setResaltarid_mesCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarid_mesCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_mesCuentaFlujoCaja() {
		return this.mostrarid_mesCuentaFlujoCaja;
	}

	public void setMostrarid_mesCuentaFlujoCaja(Boolean mostrarid_mesCuentaFlujoCaja) {
		this.mostrarid_mesCuentaFlujoCaja= mostrarid_mesCuentaFlujoCaja;
	}

	public Boolean getActivarid_mesCuentaFlujoCaja() {
		return this.activarid_mesCuentaFlujoCaja;
	}

	public void setActivarid_mesCuentaFlujoCaja(Boolean activarid_mesCuentaFlujoCaja) {
		this.activarid_mesCuentaFlujoCaja= activarid_mesCuentaFlujoCaja;
	}

	public Boolean getCargarid_mesCuentaFlujoCaja() {
		return this.cargarid_mesCuentaFlujoCaja;
	}

	public void setCargarid_mesCuentaFlujoCaja(Boolean cargarid_mesCuentaFlujoCaja) {
		this.cargarid_mesCuentaFlujoCaja= cargarid_mesCuentaFlujoCaja;
	}

	public Border setResaltarid_diaCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaflujocajaBeanSwingJInternalFrame.jTtoolBarCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_diaCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_diaCuentaFlujoCaja() {
		return this.resaltarid_diaCuentaFlujoCaja;
	}

	public void setResaltarid_diaCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarid_diaCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_diaCuentaFlujoCaja() {
		return this.mostrarid_diaCuentaFlujoCaja;
	}

	public void setMostrarid_diaCuentaFlujoCaja(Boolean mostrarid_diaCuentaFlujoCaja) {
		this.mostrarid_diaCuentaFlujoCaja= mostrarid_diaCuentaFlujoCaja;
	}

	public Boolean getActivarid_diaCuentaFlujoCaja() {
		return this.activarid_diaCuentaFlujoCaja;
	}

	public void setActivarid_diaCuentaFlujoCaja(Boolean activarid_diaCuentaFlujoCaja) {
		this.activarid_diaCuentaFlujoCaja= activarid_diaCuentaFlujoCaja;
	}

	public Boolean getCargarid_diaCuentaFlujoCaja() {
		return this.cargarid_diaCuentaFlujoCaja;
	}

	public void setCargarid_diaCuentaFlujoCaja(Boolean cargarid_diaCuentaFlujoCaja) {
		this.cargarid_diaCuentaFlujoCaja= cargarid_diaCuentaFlujoCaja;
	}

	public Border setResaltarid_cuenta_contableCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaflujocajaBeanSwingJInternalFrame.jTtoolBarCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableCuentaFlujoCaja() {
		return this.resaltarid_cuenta_contableCuentaFlujoCaja;
	}

	public void setResaltarid_cuenta_contableCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarid_cuenta_contableCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableCuentaFlujoCaja() {
		return this.mostrarid_cuenta_contableCuentaFlujoCaja;
	}

	public void setMostrarid_cuenta_contableCuentaFlujoCaja(Boolean mostrarid_cuenta_contableCuentaFlujoCaja) {
		this.mostrarid_cuenta_contableCuentaFlujoCaja= mostrarid_cuenta_contableCuentaFlujoCaja;
	}

	public Boolean getActivarid_cuenta_contableCuentaFlujoCaja() {
		return this.activarid_cuenta_contableCuentaFlujoCaja;
	}

	public void setActivarid_cuenta_contableCuentaFlujoCaja(Boolean activarid_cuenta_contableCuentaFlujoCaja) {
		this.activarid_cuenta_contableCuentaFlujoCaja= activarid_cuenta_contableCuentaFlujoCaja;
	}

	public Boolean getCargarid_cuenta_contableCuentaFlujoCaja() {
		return this.cargarid_cuenta_contableCuentaFlujoCaja;
	}

	public void setCargarid_cuenta_contableCuentaFlujoCaja(Boolean cargarid_cuenta_contableCuentaFlujoCaja) {
		this.cargarid_cuenta_contableCuentaFlujoCaja= cargarid_cuenta_contableCuentaFlujoCaja;
	}

	public Border setResaltarformulaCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaflujocajaBeanSwingJInternalFrame.jTtoolBarCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarformulaCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarformulaCuentaFlujoCaja() {
		return this.resaltarformulaCuentaFlujoCaja;
	}

	public void setResaltarformulaCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarformulaCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarformulaCuentaFlujoCaja() {
		return this.mostrarformulaCuentaFlujoCaja;
	}

	public void setMostrarformulaCuentaFlujoCaja(Boolean mostrarformulaCuentaFlujoCaja) {
		this.mostrarformulaCuentaFlujoCaja= mostrarformulaCuentaFlujoCaja;
	}

	public Boolean getActivarformulaCuentaFlujoCaja() {
		return this.activarformulaCuentaFlujoCaja;
	}

	public void setActivarformulaCuentaFlujoCaja(Boolean activarformulaCuentaFlujoCaja) {
		this.activarformulaCuentaFlujoCaja= activarformulaCuentaFlujoCaja;
	}

	public Border setResaltares_flujo_cajaCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaflujocajaBeanSwingJInternalFrame.jTtoolBarCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltares_flujo_cajaCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_flujo_cajaCuentaFlujoCaja() {
		return this.resaltares_flujo_cajaCuentaFlujoCaja;
	}

	public void setResaltares_flujo_cajaCuentaFlujoCaja(Border borderResaltar) {
		this.resaltares_flujo_cajaCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrares_flujo_cajaCuentaFlujoCaja() {
		return this.mostrares_flujo_cajaCuentaFlujoCaja;
	}

	public void setMostrares_flujo_cajaCuentaFlujoCaja(Boolean mostrares_flujo_cajaCuentaFlujoCaja) {
		this.mostrares_flujo_cajaCuentaFlujoCaja= mostrares_flujo_cajaCuentaFlujoCaja;
	}

	public Boolean getActivares_flujo_cajaCuentaFlujoCaja() {
		return this.activares_flujo_cajaCuentaFlujoCaja;
	}

	public void setActivares_flujo_cajaCuentaFlujoCaja(Boolean activares_flujo_cajaCuentaFlujoCaja) {
		this.activares_flujo_cajaCuentaFlujoCaja= activares_flujo_cajaCuentaFlujoCaja;
	}

	public Border setResaltarcon_agruparCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaflujocajaBeanSwingJInternalFrame.jTtoolBarCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarcon_agruparCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_agruparCuentaFlujoCaja() {
		return this.resaltarcon_agruparCuentaFlujoCaja;
	}

	public void setResaltarcon_agruparCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarcon_agruparCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarcon_agruparCuentaFlujoCaja() {
		return this.mostrarcon_agruparCuentaFlujoCaja;
	}

	public void setMostrarcon_agruparCuentaFlujoCaja(Boolean mostrarcon_agruparCuentaFlujoCaja) {
		this.mostrarcon_agruparCuentaFlujoCaja= mostrarcon_agruparCuentaFlujoCaja;
	}

	public Boolean getActivarcon_agruparCuentaFlujoCaja() {
		return this.activarcon_agruparCuentaFlujoCaja;
	}

	public void setActivarcon_agruparCuentaFlujoCaja(Boolean activarcon_agruparCuentaFlujoCaja) {
		this.activarcon_agruparCuentaFlujoCaja= activarcon_agruparCuentaFlujoCaja;
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
		
		
		this.setMostraridCuentaFlujoCaja(esInicial);
		this.setMostrarid_empresaCuentaFlujoCaja(esInicial);
		this.setMostrarnombreCuentaFlujoCaja(esInicial);
		this.setMostrarid_mesCuentaFlujoCaja(esInicial);
		this.setMostrarid_diaCuentaFlujoCaja(esInicial);
		this.setMostrarid_cuenta_contableCuentaFlujoCaja(esInicial);
		this.setMostrarformulaCuentaFlujoCaja(esInicial);
		this.setMostrares_flujo_cajaCuentaFlujoCaja(esInicial);
		this.setMostrarcon_agruparCuentaFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.ID)) {
				this.setMostraridCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.IDDIA)) {
				this.setMostrarid_diaCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.FORMULA)) {
				this.setMostrarformulaCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.ESFLUJOCAJA)) {
				this.setMostrares_flujo_cajaCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.CONAGRUPAR)) {
				this.setMostrarcon_agruparCuentaFlujoCaja(esAsigna);
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
		
		
		this.setActivaridCuentaFlujoCaja(esInicial);
		this.setActivarid_empresaCuentaFlujoCaja(esInicial);
		this.setActivarnombreCuentaFlujoCaja(esInicial);
		this.setActivarid_mesCuentaFlujoCaja(esInicial);
		this.setActivarid_diaCuentaFlujoCaja(esInicial);
		this.setActivarid_cuenta_contableCuentaFlujoCaja(esInicial);
		this.setActivarformulaCuentaFlujoCaja(esInicial);
		this.setActivares_flujo_cajaCuentaFlujoCaja(esInicial);
		this.setActivarcon_agruparCuentaFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.ID)) {
				this.setActivaridCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.IDMES)) {
				this.setActivarid_mesCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.IDDIA)) {
				this.setActivarid_diaCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.FORMULA)) {
				this.setActivarformulaCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.ESFLUJOCAJA)) {
				this.setActivares_flujo_cajaCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.CONAGRUPAR)) {
				this.setActivarcon_agruparCuentaFlujoCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCuentaFlujoCaja(esInicial);
		this.setResaltarid_empresaCuentaFlujoCaja(esInicial);
		this.setResaltarnombreCuentaFlujoCaja(esInicial);
		this.setResaltarid_mesCuentaFlujoCaja(esInicial);
		this.setResaltarid_diaCuentaFlujoCaja(esInicial);
		this.setResaltarid_cuenta_contableCuentaFlujoCaja(esInicial);
		this.setResaltarformulaCuentaFlujoCaja(esInicial);
		this.setResaltares_flujo_cajaCuentaFlujoCaja(esInicial);
		this.setResaltarcon_agruparCuentaFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.ID)) {
				this.setResaltaridCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.IDDIA)) {
				this.setResaltarid_diaCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.FORMULA)) {
				this.setResaltarformulaCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.ESFLUJOCAJA)) {
				this.setResaltares_flujo_cajaCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaFlujoCajaConstantesFunciones.CONAGRUPAR)) {
				this.setResaltarcon_agruparCuentaFlujoCaja(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleCuentaFlujoCajaCuentaFlujoCaja=null;

	public Border getResaltarDetalleCuentaFlujoCajaCuentaFlujoCaja() {
		return this.resaltarDetalleCuentaFlujoCajaCuentaFlujoCaja;
	}

	public void setResaltarDetalleCuentaFlujoCajaCuentaFlujoCaja(Border borderResaltarDetalleCuentaFlujoCaja) {
		if(borderResaltarDetalleCuentaFlujoCaja!=null) {
			this.resaltarDetalleCuentaFlujoCajaCuentaFlujoCaja= borderResaltarDetalleCuentaFlujoCaja;
		}
	}

	public Border setResaltarDetalleCuentaFlujoCajaCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleCuentaFlujoCaja=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cuentaflujocajaBeanSwingJInternalFrame.jTtoolBarCuentaFlujoCaja.setBorder(borderResaltarDetalleCuentaFlujoCaja);
			
		this.resaltarDetalleCuentaFlujoCajaCuentaFlujoCaja= borderResaltarDetalleCuentaFlujoCaja;

		 return borderResaltarDetalleCuentaFlujoCaja;
	}



	public Boolean mostrarDetalleCuentaFlujoCajaCuentaFlujoCaja=true;

	public Boolean getMostrarDetalleCuentaFlujoCajaCuentaFlujoCaja() {
		return this.mostrarDetalleCuentaFlujoCajaCuentaFlujoCaja;
	}

	public void setMostrarDetalleCuentaFlujoCajaCuentaFlujoCaja(Boolean visibilidadResaltarDetalleCuentaFlujoCaja) {
		this.mostrarDetalleCuentaFlujoCajaCuentaFlujoCaja= visibilidadResaltarDetalleCuentaFlujoCaja;
	}



	public Boolean activarDetalleCuentaFlujoCajaCuentaFlujoCaja=true;

	public Boolean gethabilitarResaltarDetalleCuentaFlujoCajaCuentaFlujoCaja() {
		return this.activarDetalleCuentaFlujoCajaCuentaFlujoCaja;
	}

	public void setActivarDetalleCuentaFlujoCajaCuentaFlujoCaja(Boolean habilitarResaltarDetalleCuentaFlujoCaja) {
		this.activarDetalleCuentaFlujoCajaCuentaFlujoCaja= habilitarResaltarDetalleCuentaFlujoCaja;
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

		this.setMostrarDetalleCuentaFlujoCajaCuentaFlujoCaja(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleCuentaFlujoCaja.class)) {
				this.setMostrarDetalleCuentaFlujoCajaCuentaFlujoCaja(esAsigna);
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

		this.setActivarDetalleCuentaFlujoCajaCuentaFlujoCaja(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleCuentaFlujoCaja.class)) {
				this.setActivarDetalleCuentaFlujoCajaCuentaFlujoCaja(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleCuentaFlujoCajaCuentaFlujoCaja(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleCuentaFlujoCaja.class)) {
				this.setResaltarDetalleCuentaFlujoCajaCuentaFlujoCaja(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreCuentaFlujoCaja=true;

	public Boolean getMostrarBusquedaPorNombreCuentaFlujoCaja() {
		return this.mostrarBusquedaPorNombreCuentaFlujoCaja;
	}

	public void setMostrarBusquedaPorNombreCuentaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreCuentaFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCuentaFlujoCaja=true;

	public Boolean getMostrarFK_IdCuentaContableCuentaFlujoCaja() {
		return this.mostrarFK_IdCuentaContableCuentaFlujoCaja;
	}

	public void setMostrarFK_IdCuentaContableCuentaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCuentaFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCuentaFlujoCaja=true;

	public Boolean getMostrarFK_IdEmpresaCuentaFlujoCaja() {
		return this.mostrarFK_IdEmpresaCuentaFlujoCaja;
	}

	public void setMostrarFK_IdEmpresaCuentaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCuentaFlujoCaja= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreCuentaFlujoCaja=true;

	public Boolean getActivarBusquedaPorNombreCuentaFlujoCaja() {
		return this.activarBusquedaPorNombreCuentaFlujoCaja;
	}

	public void setActivarBusquedaPorNombreCuentaFlujoCaja(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreCuentaFlujoCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCuentaFlujoCaja=true;

	public Boolean getActivarFK_IdCuentaContableCuentaFlujoCaja() {
		return this.activarFK_IdCuentaContableCuentaFlujoCaja;
	}

	public void setActivarFK_IdCuentaContableCuentaFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCuentaFlujoCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCuentaFlujoCaja=true;

	public Boolean getActivarFK_IdEmpresaCuentaFlujoCaja() {
		return this.activarFK_IdEmpresaCuentaFlujoCaja;
	}

	public void setActivarFK_IdEmpresaCuentaFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCuentaFlujoCaja= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreCuentaFlujoCaja=null;

	public Border getResaltarBusquedaPorNombreCuentaFlujoCaja() {
		return this.resaltarBusquedaPorNombreCuentaFlujoCaja;
	}

	public void setResaltarBusquedaPorNombreCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarBusquedaPorNombreCuentaFlujoCaja= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreCuentaFlujoCaja= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCuentaFlujoCaja=null;

	public Border getResaltarFK_IdCuentaContableCuentaFlujoCaja() {
		return this.resaltarFK_IdCuentaContableCuentaFlujoCaja;
	}

	public void setResaltarFK_IdCuentaContableCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCuentaFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCuentaFlujoCaja= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCuentaFlujoCaja=null;

	public Border getResaltarFK_IdEmpresaCuentaFlujoCaja() {
		return this.resaltarFK_IdEmpresaCuentaFlujoCaja;
	}

	public void setResaltarFK_IdEmpresaCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCuentaFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaFlujoCajaBeanSwingJInternalFrame cuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCuentaFlujoCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}