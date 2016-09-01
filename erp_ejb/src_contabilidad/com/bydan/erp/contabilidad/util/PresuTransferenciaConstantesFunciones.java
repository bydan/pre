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


import com.bydan.erp.contabilidad.util.PresuTransferenciaConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresuTransferenciaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresuTransferenciaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PresuTransferenciaConstantesFunciones extends PresuTransferenciaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PresuTransferencia";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresuTransferencia"+PresuTransferenciaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresuTransferenciaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresuTransferenciaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresuTransferenciaConstantesFunciones.SCHEMA+"_"+PresuTransferenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresuTransferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresuTransferenciaConstantesFunciones.SCHEMA+"_"+PresuTransferenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresuTransferenciaConstantesFunciones.SCHEMA+"_"+PresuTransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresuTransferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresuTransferenciaConstantesFunciones.SCHEMA+"_"+PresuTransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuTransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuTransferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuTransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuTransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuTransferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuTransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresuTransferenciaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresuTransferenciaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresuTransferenciaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresuTransferenciaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Transferenciaes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Transferencia";
	public static final String SCLASSWEBTITULO_LOWER="Presu Transferencia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresuTransferencia";
	public static final String OBJECTNAME="presutransferencia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="presu_transferencia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presutransferencia from "+PresuTransferenciaConstantesFunciones.SPERSISTENCENAME+" presutransferencia";
	public static String QUERYSELECTNATIVE="select "+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".id,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".version_row,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".id_presu_proyecto,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".id_cuenta_contable_destino,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".id_empleado,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".fecha,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".valor,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".descripcion from "+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME;//+" as "+PresuTransferenciaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PresuTransferenciaConstantesFuncionesAdditional presutransferenciaConstantesFuncionesAdditional=null;
	
	public PresuTransferenciaConstantesFuncionesAdditional getPresuTransferenciaConstantesFuncionesAdditional() {
		return this.presutransferenciaConstantesFuncionesAdditional;
	}
	
	public void setPresuTransferenciaConstantesFuncionesAdditional(PresuTransferenciaConstantesFuncionesAdditional presutransferenciaConstantesFuncionesAdditional) {
		try {
			this.presutransferenciaConstantesFuncionesAdditional=presutransferenciaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRESUPROYECTO= "id_presu_proyecto";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDCUENTACONTABLEDESTINO= "id_cuenta_contable_destino";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String FECHA= "fecha";
    public static final String VALOR= "valor";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPRESUPROYECTO= "Proyecto";
		public static final String LABEL_IDPRESUPROYECTO_LOWER= "Presu Proyecto";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDCUENTACONTABLEDESTINO= "Cuenta Contable Destino";
		public static final String LABEL_IDCUENTACONTABLEDESTINO_LOWER= "Cuenta Contable Destino";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPresuTransferenciaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresuTransferenciaConstantesFunciones.IDPRESUPROYECTO)) {sLabelColumna=PresuTransferenciaConstantesFunciones.LABEL_IDPRESUPROYECTO;}
		if(sNombreColumna.equals(PresuTransferenciaConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=PresuTransferenciaConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(PresuTransferenciaConstantesFunciones.IDCUENTACONTABLEDESTINO)) {sLabelColumna=PresuTransferenciaConstantesFunciones.LABEL_IDCUENTACONTABLEDESTINO;}
		if(sNombreColumna.equals(PresuTransferenciaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=PresuTransferenciaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(PresuTransferenciaConstantesFunciones.FECHA)) {sLabelColumna=PresuTransferenciaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PresuTransferenciaConstantesFunciones.VALOR)) {sLabelColumna=PresuTransferenciaConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(PresuTransferenciaConstantesFunciones.DESCRIPCION)) {sLabelColumna=PresuTransferenciaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getPresuTransferenciaDescripcion(PresuTransferencia presutransferencia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presutransferencia !=null/* && presutransferencia.getId()!=0*/) {
			if(presutransferencia.getId()!=null) {
				sDescripcion=presutransferencia.getId().toString();
			}//presutransferenciapresutransferencia.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPresuTransferenciaDescripcionDetallado(PresuTransferencia presutransferencia) {
		String sDescripcion="";
			
		sDescripcion+=PresuTransferenciaConstantesFunciones.ID+"=";
		sDescripcion+=presutransferencia.getId().toString()+",";
		sDescripcion+=PresuTransferenciaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presutransferencia.getVersionRow().toString()+",";
		sDescripcion+=PresuTransferenciaConstantesFunciones.IDPRESUPROYECTO+"=";
		sDescripcion+=presutransferencia.getid_presu_proyecto().toString()+",";
		sDescripcion+=PresuTransferenciaConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=presutransferencia.getid_cuenta_contable().toString()+",";
		sDescripcion+=PresuTransferenciaConstantesFunciones.IDCUENTACONTABLEDESTINO+"=";
		sDescripcion+=presutransferencia.getid_cuenta_contable_destino().toString()+",";
		sDescripcion+=PresuTransferenciaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=presutransferencia.getid_empleado().toString()+",";
		sDescripcion+=PresuTransferenciaConstantesFunciones.FECHA+"=";
		sDescripcion+=presutransferencia.getfecha().toString()+",";
		sDescripcion+=PresuTransferenciaConstantesFunciones.VALOR+"=";
		sDescripcion+=presutransferencia.getvalor().toString()+",";
		sDescripcion+=PresuTransferenciaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=presutransferencia.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setPresuTransferenciaDescripcion(PresuTransferencia presutransferencia,String sValor) throws Exception {			
		if(presutransferencia !=null) {
			//presutransferenciapresutransferencia.getId().toString();
		}		
	}
	
		

	public static String getPresuProyectoDescripcion(PresuProyecto presuproyecto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(presuproyecto!=null/*&&presuproyecto.getId()>0*/) {
			sDescripcion=PresuProyectoConstantesFunciones.getPresuProyectoDescripcion(presuproyecto);
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

	public static String getCuentaContableDestinoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
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
		} else if(sNombreIndice.equals("FK_IdCuentaContableDestino")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Destino";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdPresuProyecto")) {
			sNombreIndice="Tipo=  Por Proyecto";
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

	public static String getDetalleIndiceFK_IdCuentaContableDestino(Long id_cuenta_contable_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_destino!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Destino="+id_cuenta_contable_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPresuProyecto(Long id_presu_proyecto) {
		String sDetalleIndice=" Parametros->";
		if(id_presu_proyecto!=null) {sDetalleIndice+=" Codigo Unico De Proyecto="+id_presu_proyecto.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPresuTransferencia(PresuTransferencia presutransferencia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		presutransferencia.setdescripcion(presutransferencia.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPresuTransferencias(List<PresuTransferencia> presutransferencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresuTransferencia presutransferencia: presutransferencias) {
			presutransferencia.setdescripcion(presutransferencia.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuTransferencia(PresuTransferencia presutransferencia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presutransferencia.getConCambioAuxiliar()) {
			presutransferencia.setIsDeleted(presutransferencia.getIsDeletedAuxiliar());	
			presutransferencia.setIsNew(presutransferencia.getIsNewAuxiliar());	
			presutransferencia.setIsChanged(presutransferencia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presutransferencia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presutransferencia.setIsDeletedAuxiliar(false);	
			presutransferencia.setIsNewAuxiliar(false);	
			presutransferencia.setIsChangedAuxiliar(false);
			
			presutransferencia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuTransferencias(List<PresuTransferencia> presutransferencias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresuTransferencia presutransferencia : presutransferencias) {
			if(conAsignarBase && presutransferencia.getConCambioAuxiliar()) {
				presutransferencia.setIsDeleted(presutransferencia.getIsDeletedAuxiliar());	
				presutransferencia.setIsNew(presutransferencia.getIsNewAuxiliar());	
				presutransferencia.setIsChanged(presutransferencia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presutransferencia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presutransferencia.setIsDeletedAuxiliar(false);	
				presutransferencia.setIsNewAuxiliar(false);	
				presutransferencia.setIsChangedAuxiliar(false);
				
				presutransferencia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresuTransferencia(PresuTransferencia presutransferencia,Boolean conEnteros) throws Exception  {
		presutransferencia.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPresuTransferencias(List<PresuTransferencia> presutransferencias,Boolean conEnteros) throws Exception  {
		
		for(PresuTransferencia presutransferencia: presutransferencias) {
			presutransferencia.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresuTransferencia(List<PresuTransferencia> presutransferencias,PresuTransferencia presutransferenciaAux) throws Exception  {
		PresuTransferenciaConstantesFunciones.InicializarValoresPresuTransferencia(presutransferenciaAux,true);
		
		for(PresuTransferencia presutransferencia: presutransferencias) {
			if(presutransferencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			presutransferenciaAux.setvalor(presutransferenciaAux.getvalor()+presutransferencia.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuTransferencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresuTransferenciaConstantesFunciones.getArrayColumnasGlobalesPresuTransferencia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuTransferencia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresuTransferencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresuTransferencia> presutransferencias,PresuTransferencia presutransferencia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresuTransferencia presutransferenciaAux: presutransferencias) {
			if(presutransferenciaAux!=null && presutransferencia!=null) {
				if((presutransferenciaAux.getId()==null && presutransferencia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presutransferenciaAux.getId()!=null && presutransferencia.getId()!=null){
					if(presutransferenciaAux.getId().equals(presutransferencia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresuTransferencia(List<PresuTransferencia> presutransferencias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(PresuTransferencia presutransferencia: presutransferencias) {			
			if(presutransferencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=presutransferencia.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresuTransferenciaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(PresuTransferenciaConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresuTransferencia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresuTransferenciaConstantesFunciones.LABEL_ID, PresuTransferenciaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTransferenciaConstantesFunciones.LABEL_VERSIONROW, PresuTransferenciaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTransferenciaConstantesFunciones.LABEL_IDPRESUPROYECTO, PresuTransferenciaConstantesFunciones.IDPRESUPROYECTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTransferenciaConstantesFunciones.LABEL_IDCUENTACONTABLE, PresuTransferenciaConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTransferenciaConstantesFunciones.LABEL_IDCUENTACONTABLEDESTINO, PresuTransferenciaConstantesFunciones.IDCUENTACONTABLEDESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTransferenciaConstantesFunciones.LABEL_IDEMPLEADO, PresuTransferenciaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTransferenciaConstantesFunciones.LABEL_FECHA, PresuTransferenciaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTransferenciaConstantesFunciones.LABEL_VALOR, PresuTransferenciaConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTransferenciaConstantesFunciones.LABEL_DESCRIPCION, PresuTransferenciaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresuTransferencia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresuTransferenciaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTransferenciaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTransferenciaConstantesFunciones.IDPRESUPROYECTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTransferenciaConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTransferenciaConstantesFunciones.IDCUENTACONTABLEDESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTransferenciaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTransferenciaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTransferenciaConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTransferenciaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuTransferencia() throws Exception  {
		return PresuTransferenciaConstantesFunciones.getTiposSeleccionarPresuTransferencia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuTransferencia(Boolean conFk) throws Exception  {
		return PresuTransferenciaConstantesFunciones.getTiposSeleccionarPresuTransferencia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuTransferencia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuTransferenciaConstantesFunciones.LABEL_IDPRESUPROYECTO);
			reporte.setsDescripcion(PresuTransferenciaConstantesFunciones.LABEL_IDPRESUPROYECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuTransferenciaConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(PresuTransferenciaConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuTransferenciaConstantesFunciones.LABEL_IDCUENTACONTABLEDESTINO);
			reporte.setsDescripcion(PresuTransferenciaConstantesFunciones.LABEL_IDCUENTACONTABLEDESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuTransferenciaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(PresuTransferenciaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuTransferenciaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PresuTransferenciaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuTransferenciaConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(PresuTransferenciaConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuTransferenciaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PresuTransferenciaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresuTransferencia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresuTransferencia(PresuTransferencia presutransferenciaAux) throws Exception {
		
			presutransferenciaAux.setpresuproyecto_descripcion(PresuProyectoConstantesFunciones.getPresuProyectoDescripcion(presutransferenciaAux.getPresuProyecto()));
			presutransferenciaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(presutransferenciaAux.getCuentaContable()));
			presutransferenciaAux.setcuentacontabledestino_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(presutransferenciaAux.getCuentaContableDestino()));
			presutransferenciaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(presutransferenciaAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresuTransferencia(List<PresuTransferencia> presutransferenciasTemp) throws Exception {
		for(PresuTransferencia presutransferenciaAux:presutransferenciasTemp) {
			
			presutransferenciaAux.setpresuproyecto_descripcion(PresuProyectoConstantesFunciones.getPresuProyectoDescripcion(presutransferenciaAux.getPresuProyecto()));
			presutransferenciaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(presutransferenciaAux.getCuentaContable()));
			presutransferenciaAux.setcuentacontabledestino_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(presutransferenciaAux.getCuentaContableDestino()));
			presutransferenciaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(presutransferenciaAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresuTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PresuProyecto.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PresuProyecto.class)) {
						classes.add(new Classe(PresuProyecto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresuTransferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuProyecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuProyecto.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuProyecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuProyecto.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuTransferenciaConstantesFunciones.getClassesRelationshipsOfPresuTransferencia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuTransferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuTransferenciaConstantesFunciones.getClassesRelationshipsFromStringsOfPresuTransferencia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuTransferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PresuTransferencia presutransferencia,List<PresuTransferencia> presutransferencias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresuTransferencia presutransferenciaEncontrado=null;
			
			for(PresuTransferencia presutransferenciaLocal:presutransferencias) {
				if(presutransferenciaLocal.getId().equals(presutransferencia.getId())) {
					presutransferenciaEncontrado=presutransferenciaLocal;
					
					presutransferenciaLocal.setIsChanged(presutransferencia.getIsChanged());
					presutransferenciaLocal.setIsNew(presutransferencia.getIsNew());
					presutransferenciaLocal.setIsDeleted(presutransferencia.getIsDeleted());
					
					presutransferenciaLocal.setGeneralEntityOriginal(presutransferencia.getGeneralEntityOriginal());
					
					presutransferenciaLocal.setId(presutransferencia.getId());	
					presutransferenciaLocal.setVersionRow(presutransferencia.getVersionRow());	
					presutransferenciaLocal.setid_presu_proyecto(presutransferencia.getid_presu_proyecto());	
					presutransferenciaLocal.setid_cuenta_contable(presutransferencia.getid_cuenta_contable());	
					presutransferenciaLocal.setid_cuenta_contable_destino(presutransferencia.getid_cuenta_contable_destino());	
					presutransferenciaLocal.setid_empleado(presutransferencia.getid_empleado());	
					presutransferenciaLocal.setfecha(presutransferencia.getfecha());	
					presutransferenciaLocal.setvalor(presutransferencia.getvalor());	
					presutransferenciaLocal.setdescripcion(presutransferencia.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!presutransferencia.getIsDeleted()) {
				if(!existe) {
					presutransferencias.add(presutransferencia);
				}
			} else {
				if(presutransferenciaEncontrado!=null && permiteQuitar)  {
					presutransferencias.remove(presutransferenciaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresuTransferencia presutransferencia,List<PresuTransferencia> presutransferencias) throws Exception {
		try	{			
			for(PresuTransferencia presutransferenciaLocal:presutransferencias) {
				if(presutransferenciaLocal.getId().equals(presutransferencia.getId())) {
					presutransferenciaLocal.setIsSelected(presutransferencia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresuTransferencia(List<PresuTransferencia> presutransferenciasAux) throws Exception {
		//this.presutransferenciasAux=presutransferenciasAux;
		
		for(PresuTransferencia presutransferenciaAux:presutransferenciasAux) {
			if(presutransferenciaAux.getIsChanged()) {
				presutransferenciaAux.setIsChanged(false);
			}		
			
			if(presutransferenciaAux.getIsNew()) {
				presutransferenciaAux.setIsNew(false);
			}	
			
			if(presutransferenciaAux.getIsDeleted()) {
				presutransferenciaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresuTransferencia(PresuTransferencia presutransferenciaAux) throws Exception {
		//this.presutransferenciaAux=presutransferenciaAux;
		
			if(presutransferenciaAux.getIsChanged()) {
				presutransferenciaAux.setIsChanged(false);
			}		
			
			if(presutransferenciaAux.getIsNew()) {
				presutransferenciaAux.setIsNew(false);
			}	
			
			if(presutransferenciaAux.getIsDeleted()) {
				presutransferenciaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresuTransferencia presutransferenciaAsignar,PresuTransferencia presutransferencia) throws Exception {
		presutransferenciaAsignar.setId(presutransferencia.getId());	
		presutransferenciaAsignar.setVersionRow(presutransferencia.getVersionRow());	
		presutransferenciaAsignar.setid_presu_proyecto(presutransferencia.getid_presu_proyecto());
		presutransferenciaAsignar.setpresuproyecto_descripcion(presutransferencia.getpresuproyecto_descripcion());	
		presutransferenciaAsignar.setid_cuenta_contable(presutransferencia.getid_cuenta_contable());
		presutransferenciaAsignar.setcuentacontable_descripcion(presutransferencia.getcuentacontable_descripcion());	
		presutransferenciaAsignar.setid_cuenta_contable_destino(presutransferencia.getid_cuenta_contable_destino());
		presutransferenciaAsignar.setcuentacontabledestino_descripcion(presutransferencia.getcuentacontabledestino_descripcion());	
		presutransferenciaAsignar.setid_empleado(presutransferencia.getid_empleado());
		presutransferenciaAsignar.setempleado_descripcion(presutransferencia.getempleado_descripcion());	
		presutransferenciaAsignar.setfecha(presutransferencia.getfecha());	
		presutransferenciaAsignar.setvalor(presutransferencia.getvalor());	
		presutransferenciaAsignar.setdescripcion(presutransferencia.getdescripcion());	
	}
	
	public static void inicializarPresuTransferencia(PresuTransferencia presutransferencia) throws Exception {
		try {
				presutransferencia.setId(0L);	
					
				presutransferencia.setid_presu_proyecto(-1L);	
				presutransferencia.setid_cuenta_contable(-1L);	
				presutransferencia.setid_cuenta_contable_destino(-1L);	
				presutransferencia.setid_empleado(-1L);	
				presutransferencia.setfecha(new Date());	
				presutransferencia.setvalor(0.0);	
				presutransferencia.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresuTransferencia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuTransferenciaConstantesFunciones.LABEL_IDPRESUPROYECTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuTransferenciaConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuTransferenciaConstantesFunciones.LABEL_IDCUENTACONTABLEDESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuTransferenciaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuTransferenciaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuTransferenciaConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuTransferenciaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresuTransferencia(String sTipo,Row row,Workbook workbook,PresuTransferencia presutransferencia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presutransferencia.getpresuproyecto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presutransferencia.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presutransferencia.getcuentacontabledestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presutransferencia.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presutransferencia.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presutransferencia.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presutransferencia.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresuTransferencia=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresuTransferencia() {
		return this.sFinalQueryPresuTransferencia;
	}
	
	public void setsFinalQueryPresuTransferencia(String sFinalQueryPresuTransferencia) {
		this.sFinalQueryPresuTransferencia= sFinalQueryPresuTransferencia;
	}
	
	public Border resaltarSeleccionarPresuTransferencia=null;
	
	public Border setResaltarSeleccionarPresuTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presutransferenciaBeanSwingJInternalFrame.jTtoolBarPresuTransferencia.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresuTransferencia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresuTransferencia() {
		return this.resaltarSeleccionarPresuTransferencia;
	}
	
	public void setResaltarSeleccionarPresuTransferencia(Border borderResaltarSeleccionarPresuTransferencia) {
		this.resaltarSeleccionarPresuTransferencia= borderResaltarSeleccionarPresuTransferencia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresuTransferencia=null;
	public Boolean mostraridPresuTransferencia=true;
	public Boolean activaridPresuTransferencia=true;

	public Border resaltarid_presu_proyectoPresuTransferencia=null;
	public Boolean mostrarid_presu_proyectoPresuTransferencia=true;
	public Boolean activarid_presu_proyectoPresuTransferencia=true;
	public Boolean cargarid_presu_proyectoPresuTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_presu_proyectoPresuTransferencia=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contablePresuTransferencia=null;
	public Boolean mostrarid_cuenta_contablePresuTransferencia=true;
	public Boolean activarid_cuenta_contablePresuTransferencia=true;
	public Boolean cargarid_cuenta_contablePresuTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contablePresuTransferencia=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_destinoPresuTransferencia=null;
	public Boolean mostrarid_cuenta_contable_destinoPresuTransferencia=true;
	public Boolean activarid_cuenta_contable_destinoPresuTransferencia=true;
	public Boolean cargarid_cuenta_contable_destinoPresuTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_destinoPresuTransferencia=false;//ConEventDepend=true

	public Border resaltarid_empleadoPresuTransferencia=null;
	public Boolean mostrarid_empleadoPresuTransferencia=true;
	public Boolean activarid_empleadoPresuTransferencia=true;
	public Boolean cargarid_empleadoPresuTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoPresuTransferencia=false;//ConEventDepend=true

	public Border resaltarfechaPresuTransferencia=null;
	public Boolean mostrarfechaPresuTransferencia=true;
	public Boolean activarfechaPresuTransferencia=false;

	public Border resaltarvalorPresuTransferencia=null;
	public Boolean mostrarvalorPresuTransferencia=true;
	public Boolean activarvalorPresuTransferencia=true;

	public Border resaltardescripcionPresuTransferencia=null;
	public Boolean mostrardescripcionPresuTransferencia=true;
	public Boolean activardescripcionPresuTransferencia=true;

	
	

	public Border setResaltaridPresuTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutransferenciaBeanSwingJInternalFrame.jTtoolBarPresuTransferencia.setBorder(borderResaltar);
		
		this.resaltaridPresuTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresuTransferencia() {
		return this.resaltaridPresuTransferencia;
	}

	public void setResaltaridPresuTransferencia(Border borderResaltar) {
		this.resaltaridPresuTransferencia= borderResaltar;
	}

	public Boolean getMostraridPresuTransferencia() {
		return this.mostraridPresuTransferencia;
	}

	public void setMostraridPresuTransferencia(Boolean mostraridPresuTransferencia) {
		this.mostraridPresuTransferencia= mostraridPresuTransferencia;
	}

	public Boolean getActivaridPresuTransferencia() {
		return this.activaridPresuTransferencia;
	}

	public void setActivaridPresuTransferencia(Boolean activaridPresuTransferencia) {
		this.activaridPresuTransferencia= activaridPresuTransferencia;
	}

	public Border setResaltarid_presu_proyectoPresuTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutransferenciaBeanSwingJInternalFrame.jTtoolBarPresuTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_presu_proyectoPresuTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_presu_proyectoPresuTransferencia() {
		return this.resaltarid_presu_proyectoPresuTransferencia;
	}

	public void setResaltarid_presu_proyectoPresuTransferencia(Border borderResaltar) {
		this.resaltarid_presu_proyectoPresuTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_presu_proyectoPresuTransferencia() {
		return this.mostrarid_presu_proyectoPresuTransferencia;
	}

	public void setMostrarid_presu_proyectoPresuTransferencia(Boolean mostrarid_presu_proyectoPresuTransferencia) {
		this.mostrarid_presu_proyectoPresuTransferencia= mostrarid_presu_proyectoPresuTransferencia;
	}

	public Boolean getActivarid_presu_proyectoPresuTransferencia() {
		return this.activarid_presu_proyectoPresuTransferencia;
	}

	public void setActivarid_presu_proyectoPresuTransferencia(Boolean activarid_presu_proyectoPresuTransferencia) {
		this.activarid_presu_proyectoPresuTransferencia= activarid_presu_proyectoPresuTransferencia;
	}

	public Boolean getCargarid_presu_proyectoPresuTransferencia() {
		return this.cargarid_presu_proyectoPresuTransferencia;
	}

	public void setCargarid_presu_proyectoPresuTransferencia(Boolean cargarid_presu_proyectoPresuTransferencia) {
		this.cargarid_presu_proyectoPresuTransferencia= cargarid_presu_proyectoPresuTransferencia;
	}

	public Border setResaltarid_cuenta_contablePresuTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutransferenciaBeanSwingJInternalFrame.jTtoolBarPresuTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contablePresuTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contablePresuTransferencia() {
		return this.resaltarid_cuenta_contablePresuTransferencia;
	}

	public void setResaltarid_cuenta_contablePresuTransferencia(Border borderResaltar) {
		this.resaltarid_cuenta_contablePresuTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contablePresuTransferencia() {
		return this.mostrarid_cuenta_contablePresuTransferencia;
	}

	public void setMostrarid_cuenta_contablePresuTransferencia(Boolean mostrarid_cuenta_contablePresuTransferencia) {
		this.mostrarid_cuenta_contablePresuTransferencia= mostrarid_cuenta_contablePresuTransferencia;
	}

	public Boolean getActivarid_cuenta_contablePresuTransferencia() {
		return this.activarid_cuenta_contablePresuTransferencia;
	}

	public void setActivarid_cuenta_contablePresuTransferencia(Boolean activarid_cuenta_contablePresuTransferencia) {
		this.activarid_cuenta_contablePresuTransferencia= activarid_cuenta_contablePresuTransferencia;
	}

	public Boolean getCargarid_cuenta_contablePresuTransferencia() {
		return this.cargarid_cuenta_contablePresuTransferencia;
	}

	public void setCargarid_cuenta_contablePresuTransferencia(Boolean cargarid_cuenta_contablePresuTransferencia) {
		this.cargarid_cuenta_contablePresuTransferencia= cargarid_cuenta_contablePresuTransferencia;
	}

	public Border setResaltarid_cuenta_contable_destinoPresuTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutransferenciaBeanSwingJInternalFrame.jTtoolBarPresuTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_destinoPresuTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_destinoPresuTransferencia() {
		return this.resaltarid_cuenta_contable_destinoPresuTransferencia;
	}

	public void setResaltarid_cuenta_contable_destinoPresuTransferencia(Border borderResaltar) {
		this.resaltarid_cuenta_contable_destinoPresuTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_destinoPresuTransferencia() {
		return this.mostrarid_cuenta_contable_destinoPresuTransferencia;
	}

	public void setMostrarid_cuenta_contable_destinoPresuTransferencia(Boolean mostrarid_cuenta_contable_destinoPresuTransferencia) {
		this.mostrarid_cuenta_contable_destinoPresuTransferencia= mostrarid_cuenta_contable_destinoPresuTransferencia;
	}

	public Boolean getActivarid_cuenta_contable_destinoPresuTransferencia() {
		return this.activarid_cuenta_contable_destinoPresuTransferencia;
	}

	public void setActivarid_cuenta_contable_destinoPresuTransferencia(Boolean activarid_cuenta_contable_destinoPresuTransferencia) {
		this.activarid_cuenta_contable_destinoPresuTransferencia= activarid_cuenta_contable_destinoPresuTransferencia;
	}

	public Boolean getCargarid_cuenta_contable_destinoPresuTransferencia() {
		return this.cargarid_cuenta_contable_destinoPresuTransferencia;
	}

	public void setCargarid_cuenta_contable_destinoPresuTransferencia(Boolean cargarid_cuenta_contable_destinoPresuTransferencia) {
		this.cargarid_cuenta_contable_destinoPresuTransferencia= cargarid_cuenta_contable_destinoPresuTransferencia;
	}

	public Border setResaltarid_empleadoPresuTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutransferenciaBeanSwingJInternalFrame.jTtoolBarPresuTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_empleadoPresuTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoPresuTransferencia() {
		return this.resaltarid_empleadoPresuTransferencia;
	}

	public void setResaltarid_empleadoPresuTransferencia(Border borderResaltar) {
		this.resaltarid_empleadoPresuTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_empleadoPresuTransferencia() {
		return this.mostrarid_empleadoPresuTransferencia;
	}

	public void setMostrarid_empleadoPresuTransferencia(Boolean mostrarid_empleadoPresuTransferencia) {
		this.mostrarid_empleadoPresuTransferencia= mostrarid_empleadoPresuTransferencia;
	}

	public Boolean getActivarid_empleadoPresuTransferencia() {
		return this.activarid_empleadoPresuTransferencia;
	}

	public void setActivarid_empleadoPresuTransferencia(Boolean activarid_empleadoPresuTransferencia) {
		this.activarid_empleadoPresuTransferencia= activarid_empleadoPresuTransferencia;
	}

	public Boolean getCargarid_empleadoPresuTransferencia() {
		return this.cargarid_empleadoPresuTransferencia;
	}

	public void setCargarid_empleadoPresuTransferencia(Boolean cargarid_empleadoPresuTransferencia) {
		this.cargarid_empleadoPresuTransferencia= cargarid_empleadoPresuTransferencia;
	}

	public Border setResaltarfechaPresuTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutransferenciaBeanSwingJInternalFrame.jTtoolBarPresuTransferencia.setBorder(borderResaltar);
		
		this.resaltarfechaPresuTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPresuTransferencia() {
		return this.resaltarfechaPresuTransferencia;
	}

	public void setResaltarfechaPresuTransferencia(Border borderResaltar) {
		this.resaltarfechaPresuTransferencia= borderResaltar;
	}

	public Boolean getMostrarfechaPresuTransferencia() {
		return this.mostrarfechaPresuTransferencia;
	}

	public void setMostrarfechaPresuTransferencia(Boolean mostrarfechaPresuTransferencia) {
		this.mostrarfechaPresuTransferencia= mostrarfechaPresuTransferencia;
	}

	public Boolean getActivarfechaPresuTransferencia() {
		return this.activarfechaPresuTransferencia;
	}

	public void setActivarfechaPresuTransferencia(Boolean activarfechaPresuTransferencia) {
		this.activarfechaPresuTransferencia= activarfechaPresuTransferencia;
	}

	public Border setResaltarvalorPresuTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutransferenciaBeanSwingJInternalFrame.jTtoolBarPresuTransferencia.setBorder(borderResaltar);
		
		this.resaltarvalorPresuTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorPresuTransferencia() {
		return this.resaltarvalorPresuTransferencia;
	}

	public void setResaltarvalorPresuTransferencia(Border borderResaltar) {
		this.resaltarvalorPresuTransferencia= borderResaltar;
	}

	public Boolean getMostrarvalorPresuTransferencia() {
		return this.mostrarvalorPresuTransferencia;
	}

	public void setMostrarvalorPresuTransferencia(Boolean mostrarvalorPresuTransferencia) {
		this.mostrarvalorPresuTransferencia= mostrarvalorPresuTransferencia;
	}

	public Boolean getActivarvalorPresuTransferencia() {
		return this.activarvalorPresuTransferencia;
	}

	public void setActivarvalorPresuTransferencia(Boolean activarvalorPresuTransferencia) {
		this.activarvalorPresuTransferencia= activarvalorPresuTransferencia;
	}

	public Border setResaltardescripcionPresuTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutransferenciaBeanSwingJInternalFrame.jTtoolBarPresuTransferencia.setBorder(borderResaltar);
		
		this.resaltardescripcionPresuTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPresuTransferencia() {
		return this.resaltardescripcionPresuTransferencia;
	}

	public void setResaltardescripcionPresuTransferencia(Border borderResaltar) {
		this.resaltardescripcionPresuTransferencia= borderResaltar;
	}

	public Boolean getMostrardescripcionPresuTransferencia() {
		return this.mostrardescripcionPresuTransferencia;
	}

	public void setMostrardescripcionPresuTransferencia(Boolean mostrardescripcionPresuTransferencia) {
		this.mostrardescripcionPresuTransferencia= mostrardescripcionPresuTransferencia;
	}

	public Boolean getActivardescripcionPresuTransferencia() {
		return this.activardescripcionPresuTransferencia;
	}

	public void setActivardescripcionPresuTransferencia(Boolean activardescripcionPresuTransferencia) {
		this.activardescripcionPresuTransferencia= activardescripcionPresuTransferencia;
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
		
		
		this.setMostraridPresuTransferencia(esInicial);
		this.setMostrarid_presu_proyectoPresuTransferencia(esInicial);
		this.setMostrarid_cuenta_contablePresuTransferencia(esInicial);
		this.setMostrarid_cuenta_contable_destinoPresuTransferencia(esInicial);
		this.setMostrarid_empleadoPresuTransferencia(esInicial);
		this.setMostrarfechaPresuTransferencia(esInicial);
		this.setMostrarvalorPresuTransferencia(esInicial);
		this.setMostrardescripcionPresuTransferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.ID)) {
				this.setMostraridPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.IDPRESUPROYECTO)) {
				this.setMostrarid_presu_proyectoPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contablePresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.IDCUENTACONTABLEDESTINO)) {
				this.setMostrarid_cuenta_contable_destinoPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.FECHA)) {
				this.setMostrarfechaPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.VALOR)) {
				this.setMostrarvalorPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPresuTransferencia(esAsigna);
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
		
		
		this.setActivaridPresuTransferencia(esInicial);
		this.setActivarid_presu_proyectoPresuTransferencia(esInicial);
		this.setActivarid_cuenta_contablePresuTransferencia(esInicial);
		this.setActivarid_cuenta_contable_destinoPresuTransferencia(esInicial);
		this.setActivarid_empleadoPresuTransferencia(esInicial);
		this.setActivarfechaPresuTransferencia(esInicial);
		this.setActivarvalorPresuTransferencia(esInicial);
		this.setActivardescripcionPresuTransferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.ID)) {
				this.setActivaridPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.IDPRESUPROYECTO)) {
				this.setActivarid_presu_proyectoPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contablePresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.IDCUENTACONTABLEDESTINO)) {
				this.setActivarid_cuenta_contable_destinoPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.FECHA)) {
				this.setActivarfechaPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.VALOR)) {
				this.setActivarvalorPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPresuTransferencia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresuTransferencia(esInicial);
		this.setResaltarid_presu_proyectoPresuTransferencia(esInicial);
		this.setResaltarid_cuenta_contablePresuTransferencia(esInicial);
		this.setResaltarid_cuenta_contable_destinoPresuTransferencia(esInicial);
		this.setResaltarid_empleadoPresuTransferencia(esInicial);
		this.setResaltarfechaPresuTransferencia(esInicial);
		this.setResaltarvalorPresuTransferencia(esInicial);
		this.setResaltardescripcionPresuTransferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.ID)) {
				this.setResaltaridPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.IDPRESUPROYECTO)) {
				this.setResaltarid_presu_proyectoPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contablePresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.IDCUENTACONTABLEDESTINO)) {
				this.setResaltarid_cuenta_contable_destinoPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.FECHA)) {
				this.setResaltarfechaPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.VALOR)) {
				this.setResaltarvalorPresuTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTransferenciaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPresuTransferencia(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContablePresuTransferencia=true;

	public Boolean getMostrarFK_IdCuentaContablePresuTransferencia() {
		return this.mostrarFK_IdCuentaContablePresuTransferencia;
	}

	public void setMostrarFK_IdCuentaContablePresuTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContablePresuTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDestinoPresuTransferencia=true;

	public Boolean getMostrarFK_IdCuentaContableDestinoPresuTransferencia() {
		return this.mostrarFK_IdCuentaContableDestinoPresuTransferencia;
	}

	public void setMostrarFK_IdCuentaContableDestinoPresuTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDestinoPresuTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoPresuTransferencia=true;

	public Boolean getMostrarFK_IdEmpleadoPresuTransferencia() {
		return this.mostrarFK_IdEmpleadoPresuTransferencia;
	}

	public void setMostrarFK_IdEmpleadoPresuTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoPresuTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPresuProyectoPresuTransferencia=true;

	public Boolean getMostrarFK_IdPresuProyectoPresuTransferencia() {
		return this.mostrarFK_IdPresuProyectoPresuTransferencia;
	}

	public void setMostrarFK_IdPresuProyectoPresuTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPresuProyectoPresuTransferencia= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContablePresuTransferencia=true;

	public Boolean getActivarFK_IdCuentaContablePresuTransferencia() {
		return this.activarFK_IdCuentaContablePresuTransferencia;
	}

	public void setActivarFK_IdCuentaContablePresuTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContablePresuTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDestinoPresuTransferencia=true;

	public Boolean getActivarFK_IdCuentaContableDestinoPresuTransferencia() {
		return this.activarFK_IdCuentaContableDestinoPresuTransferencia;
	}

	public void setActivarFK_IdCuentaContableDestinoPresuTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDestinoPresuTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoPresuTransferencia=true;

	public Boolean getActivarFK_IdEmpleadoPresuTransferencia() {
		return this.activarFK_IdEmpleadoPresuTransferencia;
	}

	public void setActivarFK_IdEmpleadoPresuTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoPresuTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdPresuProyectoPresuTransferencia=true;

	public Boolean getActivarFK_IdPresuProyectoPresuTransferencia() {
		return this.activarFK_IdPresuProyectoPresuTransferencia;
	}

	public void setActivarFK_IdPresuProyectoPresuTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdPresuProyectoPresuTransferencia= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContablePresuTransferencia=null;

	public Border getResaltarFK_IdCuentaContablePresuTransferencia() {
		return this.resaltarFK_IdCuentaContablePresuTransferencia;
	}

	public void setResaltarFK_IdCuentaContablePresuTransferencia(Border borderResaltar) {
		this.resaltarFK_IdCuentaContablePresuTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContablePresuTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContablePresuTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDestinoPresuTransferencia=null;

	public Border getResaltarFK_IdCuentaContableDestinoPresuTransferencia() {
		return this.resaltarFK_IdCuentaContableDestinoPresuTransferencia;
	}

	public void setResaltarFK_IdCuentaContableDestinoPresuTransferencia(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDestinoPresuTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDestinoPresuTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDestinoPresuTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoPresuTransferencia=null;

	public Border getResaltarFK_IdEmpleadoPresuTransferencia() {
		return this.resaltarFK_IdEmpleadoPresuTransferencia;
	}

	public void setResaltarFK_IdEmpleadoPresuTransferencia(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoPresuTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoPresuTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoPresuTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdPresuProyectoPresuTransferencia=null;

	public Border getResaltarFK_IdPresuProyectoPresuTransferencia() {
		return this.resaltarFK_IdPresuProyectoPresuTransferencia;
	}

	public void setResaltarFK_IdPresuProyectoPresuTransferencia(Border borderResaltar) {
		this.resaltarFK_IdPresuProyectoPresuTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdPresuProyectoPresuTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTransferenciaBeanSwingJInternalFrame presutransferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPresuProyectoPresuTransferencia= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}