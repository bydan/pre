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


import com.bydan.erp.nomina.util.CuotaConstantesFunciones;
import com.bydan.erp.nomina.util.CuotaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CuotaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CuotaConstantesFunciones extends CuotaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Cuota";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Cuota"+CuotaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CuotaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CuotaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CuotaConstantesFunciones.SCHEMA+"_"+CuotaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CuotaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CuotaConstantesFunciones.SCHEMA+"_"+CuotaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CuotaConstantesFunciones.SCHEMA+"_"+CuotaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CuotaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CuotaConstantesFunciones.SCHEMA+"_"+CuotaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuotaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuotaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuotaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuotaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuotaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuotaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CuotaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CuotaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CuotaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CuotaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cuotas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cuota";
	public static final String SCLASSWEBTITULO_LOWER="Cuota";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Cuota";
	public static final String OBJECTNAME="cuota";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="cuota";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cuota from "+CuotaConstantesFunciones.SPERSISTENCENAME+" cuota";
	public static String QUERYSELECTNATIVE="select "+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".id,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".version_row,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".id_prestamo,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".id_estado_cuota,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".id_defi_provision_empleado,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".numero_cuota,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".capital,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".interes,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".total,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".fecha_liquidacion,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".monto_ajuste,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".interes_ajuste,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".fecha_vencimiento,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".descripcion from "+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME;//+" as "+CuotaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CuotaConstantesFuncionesAdditional cuotaConstantesFuncionesAdditional=null;
	
	public CuotaConstantesFuncionesAdditional getCuotaConstantesFuncionesAdditional() {
		return this.cuotaConstantesFuncionesAdditional;
	}
	
	public void setCuotaConstantesFuncionesAdditional(CuotaConstantesFuncionesAdditional cuotaConstantesFuncionesAdditional) {
		try {
			this.cuotaConstantesFuncionesAdditional=cuotaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRESTAMO= "id_prestamo";
    public static final String IDESTADOCUOTA= "id_estado_cuota";
    public static final String IDDEFIPROVISIONEMPLEADO= "id_defi_provision_empleado";
    public static final String NUMEROCUOTA= "numero_cuota";
    public static final String CAPITAL= "capital";
    public static final String INTERES= "interes";
    public static final String TOTAL= "total";
    public static final String FECHALIQUIDACION= "fecha_liquidacion";
    public static final String MONTOAJUSTE= "monto_ajuste";
    public static final String INTERESAJUSTE= "interes_ajuste";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPRESTAMO= "Prestamo";
		public static final String LABEL_IDPRESTAMO_LOWER= "Prestamo";
    	public static final String LABEL_IDESTADOCUOTA= "Estado Cuota";
		public static final String LABEL_IDESTADOCUOTA_LOWER= "Estado Cuota";
    	public static final String LABEL_IDDEFIPROVISIONEMPLEADO= "Defi Provision Empleado";
		public static final String LABEL_IDDEFIPROVISIONEMPLEADO_LOWER= "Defi Provision Empleado";
    	public static final String LABEL_NUMEROCUOTA= "Numero Cuota";
		public static final String LABEL_NUMEROCUOTA_LOWER= "Numero Cuota";
    	public static final String LABEL_CAPITAL= "Capital";
		public static final String LABEL_CAPITAL_LOWER= "Capital";
    	public static final String LABEL_INTERES= "Interes";
		public static final String LABEL_INTERES_LOWER= "Interes";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_FECHALIQUIDACION= "Fecha Liquacion";
		public static final String LABEL_FECHALIQUIDACION_LOWER= "Fecha Liquidacion";
    	public static final String LABEL_MONTOAJUSTE= "Monto Ajuste";
		public static final String LABEL_MONTOAJUSTE_LOWER= "Monto Ajuste";
    	public static final String LABEL_INTERESAJUSTE= "Interes Ajuste";
		public static final String LABEL_INTERESAJUSTE_LOWER= "Interes Ajuste";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCuotaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CuotaConstantesFunciones.IDPRESTAMO)) {sLabelColumna=CuotaConstantesFunciones.LABEL_IDPRESTAMO;}
		if(sNombreColumna.equals(CuotaConstantesFunciones.IDESTADOCUOTA)) {sLabelColumna=CuotaConstantesFunciones.LABEL_IDESTADOCUOTA;}
		if(sNombreColumna.equals(CuotaConstantesFunciones.IDDEFIPROVISIONEMPLEADO)) {sLabelColumna=CuotaConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO;}
		if(sNombreColumna.equals(CuotaConstantesFunciones.NUMEROCUOTA)) {sLabelColumna=CuotaConstantesFunciones.LABEL_NUMEROCUOTA;}
		if(sNombreColumna.equals(CuotaConstantesFunciones.CAPITAL)) {sLabelColumna=CuotaConstantesFunciones.LABEL_CAPITAL;}
		if(sNombreColumna.equals(CuotaConstantesFunciones.INTERES)) {sLabelColumna=CuotaConstantesFunciones.LABEL_INTERES;}
		if(sNombreColumna.equals(CuotaConstantesFunciones.TOTAL)) {sLabelColumna=CuotaConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(CuotaConstantesFunciones.FECHALIQUIDACION)) {sLabelColumna=CuotaConstantesFunciones.LABEL_FECHALIQUIDACION;}
		if(sNombreColumna.equals(CuotaConstantesFunciones.MONTOAJUSTE)) {sLabelColumna=CuotaConstantesFunciones.LABEL_MONTOAJUSTE;}
		if(sNombreColumna.equals(CuotaConstantesFunciones.INTERESAJUSTE)) {sLabelColumna=CuotaConstantesFunciones.LABEL_INTERESAJUSTE;}
		if(sNombreColumna.equals(CuotaConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=CuotaConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(CuotaConstantesFunciones.DESCRIPCION)) {sLabelColumna=CuotaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCuotaDescripcion(Cuota cuota) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cuota !=null/* && cuota.getId()!=0*/) {
			if(cuota.getId()!=null) {
				sDescripcion=cuota.getId().toString();
			}//cuotacuota.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCuotaDescripcionDetallado(Cuota cuota) {
		String sDescripcion="";
			
		sDescripcion+=CuotaConstantesFunciones.ID+"=";
		sDescripcion+=cuota.getId().toString()+",";
		sDescripcion+=CuotaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cuota.getVersionRow().toString()+",";
		sDescripcion+=CuotaConstantesFunciones.IDPRESTAMO+"=";
		sDescripcion+=cuota.getid_prestamo().toString()+",";
		sDescripcion+=CuotaConstantesFunciones.IDESTADOCUOTA+"=";
		sDescripcion+=cuota.getid_estado_cuota().toString()+",";
		sDescripcion+=CuotaConstantesFunciones.IDDEFIPROVISIONEMPLEADO+"=";
		sDescripcion+=cuota.getid_defi_provision_empleado().toString()+",";
		sDescripcion+=CuotaConstantesFunciones.NUMEROCUOTA+"=";
		sDescripcion+=cuota.getnumero_cuota().toString()+",";
		sDescripcion+=CuotaConstantesFunciones.CAPITAL+"=";
		sDescripcion+=cuota.getcapital().toString()+",";
		sDescripcion+=CuotaConstantesFunciones.INTERES+"=";
		sDescripcion+=cuota.getinteres().toString()+",";
		sDescripcion+=CuotaConstantesFunciones.TOTAL+"=";
		sDescripcion+=cuota.gettotal().toString()+",";
		sDescripcion+=CuotaConstantesFunciones.FECHALIQUIDACION+"=";
		sDescripcion+=cuota.getfecha_liquidacion().toString()+",";
		sDescripcion+=CuotaConstantesFunciones.MONTOAJUSTE+"=";
		sDescripcion+=cuota.getmonto_ajuste().toString()+",";
		sDescripcion+=CuotaConstantesFunciones.INTERESAJUSTE+"=";
		sDescripcion+=cuota.getinteres_ajuste().toString()+",";
		sDescripcion+=CuotaConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=cuota.getfecha_vencimiento().toString()+",";
		sDescripcion+=CuotaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=cuota.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setCuotaDescripcion(Cuota cuota,String sValor) throws Exception {			
		if(cuota !=null) {
			//cuotacuota.getId().toString();
		}		
	}
	
		

	public static String getPrestamoDescripcion(Prestamo prestamo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(prestamo!=null/*&&prestamo.getId()>0*/) {
			sDescripcion=PrestamoConstantesFunciones.getPrestamoDescripcion(prestamo);
		}

		return sDescripcion;
	}

	public static String getEstadoCuotaDescripcion(EstadoCuota estadocuota) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadocuota!=null/*&&estadocuota.getId()>0*/) {
			sDescripcion=EstadoCuotaConstantesFunciones.getEstadoCuotaDescripcion(estadocuota);
		}

		return sDescripcion;
	}

	public static String getDefiProvisionEmpleadoDescripcion(DefiProvisionEmpleado defiprovisionempleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(defiprovisionempleado!=null/*&&defiprovisionempleado.getId()>0*/) {
			sDescripcion=DefiProvisionEmpleadoConstantesFunciones.getDefiProvisionEmpleadoDescripcion(defiprovisionempleado);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdDefiProvisionEmpleado")) {
			sNombreIndice="Tipo=  Por Defi Provision Empleado";
		} else if(sNombreIndice.equals("FK_IdEstadoCuota")) {
			sNombreIndice="Tipo=  Por Estado Cuota";
		} else if(sNombreIndice.equals("FK_IdPrestamo")) {
			sNombreIndice="Tipo=  Por Prestamo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdDefiProvisionEmpleado(Long id_defi_provision_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_defi_provision_empleado!=null) {sDetalleIndice+=" Codigo Unico De Defi Provision Empleado="+id_defi_provision_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoCuota(Long id_estado_cuota) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_cuota!=null) {sDetalleIndice+=" Codigo Unico De Estado Cuota="+id_estado_cuota.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPrestamo(Long id_prestamo) {
		String sDetalleIndice=" Parametros->";
		if(id_prestamo!=null) {sDetalleIndice+=" Codigo Unico De Prestamo="+id_prestamo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCuota(Cuota cuota,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cuota.setdescripcion(cuota.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCuotas(List<Cuota> cuotas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Cuota cuota: cuotas) {
			cuota.setdescripcion(cuota.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuota(Cuota cuota,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cuota.getConCambioAuxiliar()) {
			cuota.setIsDeleted(cuota.getIsDeletedAuxiliar());	
			cuota.setIsNew(cuota.getIsNewAuxiliar());	
			cuota.setIsChanged(cuota.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cuota.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cuota.setIsDeletedAuxiliar(false);	
			cuota.setIsNewAuxiliar(false);	
			cuota.setIsChangedAuxiliar(false);
			
			cuota.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuotas(List<Cuota> cuotas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Cuota cuota : cuotas) {
			if(conAsignarBase && cuota.getConCambioAuxiliar()) {
				cuota.setIsDeleted(cuota.getIsDeletedAuxiliar());	
				cuota.setIsNew(cuota.getIsNewAuxiliar());	
				cuota.setIsChanged(cuota.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cuota.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cuota.setIsDeletedAuxiliar(false);	
				cuota.setIsNewAuxiliar(false);	
				cuota.setIsChangedAuxiliar(false);
				
				cuota.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCuota(Cuota cuota,Boolean conEnteros) throws Exception  {
		cuota.setcapital(0.0);
		cuota.setinteres(0.0);
		cuota.settotal(0.0);
		cuota.setfecha_liquidacion(0.0);
		cuota.setmonto_ajuste(0.0);
		cuota.setinteres_ajuste(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			cuota.setnumero_cuota(0);
		}
	}		
	
	public static void InicializarValoresCuotas(List<Cuota> cuotas,Boolean conEnteros) throws Exception  {
		
		for(Cuota cuota: cuotas) {
			cuota.setcapital(0.0);
			cuota.setinteres(0.0);
			cuota.settotal(0.0);
			cuota.setfecha_liquidacion(0.0);
			cuota.setmonto_ajuste(0.0);
			cuota.setinteres_ajuste(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				cuota.setnumero_cuota(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCuota(List<Cuota> cuotas,Cuota cuotaAux) throws Exception  {
		CuotaConstantesFunciones.InicializarValoresCuota(cuotaAux,true);
		
		for(Cuota cuota: cuotas) {
			if(cuota.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cuotaAux.setnumero_cuota(cuotaAux.getnumero_cuota()+cuota.getnumero_cuota());			
			cuotaAux.setcapital(cuotaAux.getcapital()+cuota.getcapital());			
			cuotaAux.setinteres(cuotaAux.getinteres()+cuota.getinteres());			
			cuotaAux.settotal(cuotaAux.gettotal()+cuota.gettotal());			
			cuotaAux.setfecha_liquidacion(cuotaAux.getfecha_liquidacion()+cuota.getfecha_liquidacion());			
			cuotaAux.setmonto_ajuste(cuotaAux.getmonto_ajuste()+cuota.getmonto_ajuste());			
			cuotaAux.setinteres_ajuste(cuotaAux.getinteres_ajuste()+cuota.getinteres_ajuste());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuota(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CuotaConstantesFunciones.getArrayColumnasGlobalesCuota(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCuota(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCuota(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Cuota> cuotas,Cuota cuota,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Cuota cuotaAux: cuotas) {
			if(cuotaAux!=null && cuota!=null) {
				if((cuotaAux.getId()==null && cuota.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cuotaAux.getId()!=null && cuota.getId()!=null){
					if(cuotaAux.getId().equals(cuota.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCuota(List<Cuota> cuotas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double capitalTotal=0.0;
		Double interesTotal=0.0;
		Double totalTotal=0.0;
		Double fecha_liquidacionTotal=0.0;
		Double monto_ajusteTotal=0.0;
		Double interes_ajusteTotal=0.0;
	
		for(Cuota cuota: cuotas) {			
			if(cuota.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			capitalTotal+=cuota.getcapital();
			interesTotal+=cuota.getinteres();
			totalTotal+=cuota.gettotal();
			fecha_liquidacionTotal+=cuota.getfecha_liquidacion();
			monto_ajusteTotal+=cuota.getmonto_ajuste();
			interes_ajusteTotal+=cuota.getinteres_ajuste();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CuotaConstantesFunciones.CAPITAL);
		datoGeneral.setsDescripcion(CuotaConstantesFunciones.LABEL_CAPITAL);
		datoGeneral.setdValorDouble(capitalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CuotaConstantesFunciones.INTERES);
		datoGeneral.setsDescripcion(CuotaConstantesFunciones.LABEL_INTERES);
		datoGeneral.setdValorDouble(interesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CuotaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(CuotaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CuotaConstantesFunciones.FECHALIQUIDACION);
		datoGeneral.setsDescripcion(CuotaConstantesFunciones.LABEL_FECHALIQUIDACION);
		datoGeneral.setdValorDouble(fecha_liquidacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CuotaConstantesFunciones.MONTOAJUSTE);
		datoGeneral.setsDescripcion(CuotaConstantesFunciones.LABEL_MONTOAJUSTE);
		datoGeneral.setdValorDouble(monto_ajusteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CuotaConstantesFunciones.INTERESAJUSTE);
		datoGeneral.setsDescripcion(CuotaConstantesFunciones.LABEL_INTERESAJUSTE);
		datoGeneral.setdValorDouble(interes_ajusteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCuota() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_ID, CuotaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_VERSIONROW, CuotaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_IDPRESTAMO, CuotaConstantesFunciones.IDPRESTAMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_IDESTADOCUOTA, CuotaConstantesFunciones.IDESTADOCUOTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO, CuotaConstantesFunciones.IDDEFIPROVISIONEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_NUMEROCUOTA, CuotaConstantesFunciones.NUMEROCUOTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_CAPITAL, CuotaConstantesFunciones.CAPITAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_INTERES, CuotaConstantesFunciones.INTERES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_TOTAL, CuotaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_FECHALIQUIDACION, CuotaConstantesFunciones.FECHALIQUIDACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_MONTOAJUSTE, CuotaConstantesFunciones.MONTOAJUSTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_INTERESAJUSTE, CuotaConstantesFunciones.INTERESAJUSTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_FECHAVENCIMIENTO, CuotaConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuotaConstantesFunciones.LABEL_DESCRIPCION, CuotaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCuota() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.IDPRESTAMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.IDESTADOCUOTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.IDDEFIPROVISIONEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.NUMEROCUOTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.CAPITAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.INTERES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.FECHALIQUIDACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.MONTOAJUSTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.INTERESAJUSTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuotaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuota() throws Exception  {
		return CuotaConstantesFunciones.getTiposSeleccionarCuota(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuota(Boolean conFk) throws Exception  {
		return CuotaConstantesFunciones.getTiposSeleccionarCuota(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuota(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuotaConstantesFunciones.LABEL_IDPRESTAMO);
			reporte.setsDescripcion(CuotaConstantesFunciones.LABEL_IDPRESTAMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuotaConstantesFunciones.LABEL_IDESTADOCUOTA);
			reporte.setsDescripcion(CuotaConstantesFunciones.LABEL_IDESTADOCUOTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuotaConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO);
			reporte.setsDescripcion(CuotaConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuotaConstantesFunciones.LABEL_NUMEROCUOTA);
			reporte.setsDescripcion(CuotaConstantesFunciones.LABEL_NUMEROCUOTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuotaConstantesFunciones.LABEL_CAPITAL);
			reporte.setsDescripcion(CuotaConstantesFunciones.LABEL_CAPITAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuotaConstantesFunciones.LABEL_INTERES);
			reporte.setsDescripcion(CuotaConstantesFunciones.LABEL_INTERES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuotaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(CuotaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuotaConstantesFunciones.LABEL_FECHALIQUIDACION);
			reporte.setsDescripcion(CuotaConstantesFunciones.LABEL_FECHALIQUIDACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuotaConstantesFunciones.LABEL_MONTOAJUSTE);
			reporte.setsDescripcion(CuotaConstantesFunciones.LABEL_MONTOAJUSTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuotaConstantesFunciones.LABEL_INTERESAJUSTE);
			reporte.setsDescripcion(CuotaConstantesFunciones.LABEL_INTERESAJUSTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuotaConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(CuotaConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuotaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(CuotaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCuota(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCuota(Cuota cuotaAux) throws Exception {
		
			cuotaAux.setprestamo_descripcion(PrestamoConstantesFunciones.getPrestamoDescripcion(cuotaAux.getPrestamo()));
			cuotaAux.setestadocuota_descripcion(EstadoCuotaConstantesFunciones.getEstadoCuotaDescripcion(cuotaAux.getEstadoCuota()));
			cuotaAux.setdefiprovisionempleado_descripcion(DefiProvisionEmpleadoConstantesFunciones.getDefiProvisionEmpleadoDescripcion(cuotaAux.getDefiProvisionEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCuota(List<Cuota> cuotasTemp) throws Exception {
		for(Cuota cuotaAux:cuotasTemp) {
			
			cuotaAux.setprestamo_descripcion(PrestamoConstantesFunciones.getPrestamoDescripcion(cuotaAux.getPrestamo()));
			cuotaAux.setestadocuota_descripcion(EstadoCuotaConstantesFunciones.getEstadoCuotaDescripcion(cuotaAux.getEstadoCuota()));
			cuotaAux.setdefiprovisionempleado_descripcion(DefiProvisionEmpleadoConstantesFunciones.getDefiProvisionEmpleadoDescripcion(cuotaAux.getDefiProvisionEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Prestamo.class));
				classes.add(new Classe(EstadoCuota.class));
				classes.add(new Classe(DefiProvisionEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Prestamo.class)) {
						classes.add(new Classe(Prestamo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoCuota.class)) {
						classes.add(new Classe(EstadoCuota.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DefiProvisionEmpleado.class)) {
						classes.add(new Classe(DefiProvisionEmpleado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCuota(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Prestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Prestamo.class)); continue;
					}

					if(EstadoCuota.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCuota.class)); continue;
					}

					if(DefiProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DefiProvisionEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Prestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Prestamo.class)); continue;
					}

					if(EstadoCuota.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCuota.class)); continue;
					}

					if(DefiProvisionEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DefiProvisionEmpleado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuotaConstantesFunciones.getClassesRelationshipsOfCuota(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuota(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuotaConstantesFunciones.getClassesRelationshipsFromStringsOfCuota(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuota(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Cuota cuota,List<Cuota> cuotas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Cuota cuotaEncontrado=null;
			
			for(Cuota cuotaLocal:cuotas) {
				if(cuotaLocal.getId().equals(cuota.getId())) {
					cuotaEncontrado=cuotaLocal;
					
					cuotaLocal.setIsChanged(cuota.getIsChanged());
					cuotaLocal.setIsNew(cuota.getIsNew());
					cuotaLocal.setIsDeleted(cuota.getIsDeleted());
					
					cuotaLocal.setGeneralEntityOriginal(cuota.getGeneralEntityOriginal());
					
					cuotaLocal.setId(cuota.getId());	
					cuotaLocal.setVersionRow(cuota.getVersionRow());	
					cuotaLocal.setid_prestamo(cuota.getid_prestamo());	
					cuotaLocal.setid_estado_cuota(cuota.getid_estado_cuota());	
					cuotaLocal.setid_defi_provision_empleado(cuota.getid_defi_provision_empleado());	
					cuotaLocal.setnumero_cuota(cuota.getnumero_cuota());	
					cuotaLocal.setcapital(cuota.getcapital());	
					cuotaLocal.setinteres(cuota.getinteres());	
					cuotaLocal.settotal(cuota.gettotal());	
					cuotaLocal.setfecha_liquidacion(cuota.getfecha_liquidacion());	
					cuotaLocal.setmonto_ajuste(cuota.getmonto_ajuste());	
					cuotaLocal.setinteres_ajuste(cuota.getinteres_ajuste());	
					cuotaLocal.setfecha_vencimiento(cuota.getfecha_vencimiento());	
					cuotaLocal.setdescripcion(cuota.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cuota.getIsDeleted()) {
				if(!existe) {
					cuotas.add(cuota);
				}
			} else {
				if(cuotaEncontrado!=null && permiteQuitar)  {
					cuotas.remove(cuotaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Cuota cuota,List<Cuota> cuotas) throws Exception {
		try	{			
			for(Cuota cuotaLocal:cuotas) {
				if(cuotaLocal.getId().equals(cuota.getId())) {
					cuotaLocal.setIsSelected(cuota.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCuota(List<Cuota> cuotasAux) throws Exception {
		//this.cuotasAux=cuotasAux;
		
		for(Cuota cuotaAux:cuotasAux) {
			if(cuotaAux.getIsChanged()) {
				cuotaAux.setIsChanged(false);
			}		
			
			if(cuotaAux.getIsNew()) {
				cuotaAux.setIsNew(false);
			}	
			
			if(cuotaAux.getIsDeleted()) {
				cuotaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCuota(Cuota cuotaAux) throws Exception {
		//this.cuotaAux=cuotaAux;
		
			if(cuotaAux.getIsChanged()) {
				cuotaAux.setIsChanged(false);
			}		
			
			if(cuotaAux.getIsNew()) {
				cuotaAux.setIsNew(false);
			}	
			
			if(cuotaAux.getIsDeleted()) {
				cuotaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Cuota cuotaAsignar,Cuota cuota) throws Exception {
		cuotaAsignar.setId(cuota.getId());	
		cuotaAsignar.setVersionRow(cuota.getVersionRow());	
		cuotaAsignar.setid_prestamo(cuota.getid_prestamo());
		cuotaAsignar.setprestamo_descripcion(cuota.getprestamo_descripcion());	
		cuotaAsignar.setid_estado_cuota(cuota.getid_estado_cuota());
		cuotaAsignar.setestadocuota_descripcion(cuota.getestadocuota_descripcion());	
		cuotaAsignar.setid_defi_provision_empleado(cuota.getid_defi_provision_empleado());
		cuotaAsignar.setdefiprovisionempleado_descripcion(cuota.getdefiprovisionempleado_descripcion());	
		cuotaAsignar.setnumero_cuota(cuota.getnumero_cuota());	
		cuotaAsignar.setcapital(cuota.getcapital());	
		cuotaAsignar.setinteres(cuota.getinteres());	
		cuotaAsignar.settotal(cuota.gettotal());	
		cuotaAsignar.setfecha_liquidacion(cuota.getfecha_liquidacion());	
		cuotaAsignar.setmonto_ajuste(cuota.getmonto_ajuste());	
		cuotaAsignar.setinteres_ajuste(cuota.getinteres_ajuste());	
		cuotaAsignar.setfecha_vencimiento(cuota.getfecha_vencimiento());	
		cuotaAsignar.setdescripcion(cuota.getdescripcion());	
	}
	
	public static void inicializarCuota(Cuota cuota) throws Exception {
		try {
				cuota.setId(0L);	
					
				cuota.setid_prestamo(-1L);	
				cuota.setid_estado_cuota(-1L);	
				cuota.setid_defi_provision_empleado(-1L);	
				cuota.setnumero_cuota(0);	
				cuota.setcapital(0.0);	
				cuota.setinteres(0.0);	
				cuota.settotal(0.0);	
				cuota.setfecha_liquidacion(0.0);	
				cuota.setmonto_ajuste(0.0);	
				cuota.setinteres_ajuste(0.0);	
				cuota.setfecha_vencimiento(new Date());	
				cuota.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCuota(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CuotaConstantesFunciones.LABEL_IDPRESTAMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuotaConstantesFunciones.LABEL_IDESTADOCUOTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuotaConstantesFunciones.LABEL_IDDEFIPROVISIONEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuotaConstantesFunciones.LABEL_NUMEROCUOTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuotaConstantesFunciones.LABEL_CAPITAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuotaConstantesFunciones.LABEL_INTERES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuotaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuotaConstantesFunciones.LABEL_FECHALIQUIDACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuotaConstantesFunciones.LABEL_MONTOAJUSTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuotaConstantesFunciones.LABEL_INTERESAJUSTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuotaConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuotaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCuota(String sTipo,Row row,Workbook workbook,Cuota cuota,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cuota.getprestamo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuota.getestadocuota_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuota.getdefiprovisionempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuota.getnumero_cuota());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuota.getcapital());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuota.getinteres());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuota.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuota.getfecha_liquidacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuota.getmonto_ajuste());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuota.getinteres_ajuste());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuota.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuota.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCuota=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCuota() {
		return this.sFinalQueryCuota;
	}
	
	public void setsFinalQueryCuota(String sFinalQueryCuota) {
		this.sFinalQueryCuota= sFinalQueryCuota;
	}
	
	public Border resaltarSeleccionarCuota=null;
	
	public Border setResaltarSeleccionarCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCuota= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCuota() {
		return this.resaltarSeleccionarCuota;
	}
	
	public void setResaltarSeleccionarCuota(Border borderResaltarSeleccionarCuota) {
		this.resaltarSeleccionarCuota= borderResaltarSeleccionarCuota;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCuota=null;
	public Boolean mostraridCuota=true;
	public Boolean activaridCuota=true;

	public Border resaltarid_prestamoCuota=null;
	public Boolean mostrarid_prestamoCuota=true;
	public Boolean activarid_prestamoCuota=true;
	public Boolean cargarid_prestamoCuota=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_prestamoCuota=false;//ConEventDepend=true

	public Border resaltarid_estado_cuotaCuota=null;
	public Boolean mostrarid_estado_cuotaCuota=true;
	public Boolean activarid_estado_cuotaCuota=true;
	public Boolean cargarid_estado_cuotaCuota=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_cuotaCuota=false;//ConEventDepend=true

	public Border resaltarid_defi_provision_empleadoCuota=null;
	public Boolean mostrarid_defi_provision_empleadoCuota=true;
	public Boolean activarid_defi_provision_empleadoCuota=true;
	public Boolean cargarid_defi_provision_empleadoCuota=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_defi_provision_empleadoCuota=false;//ConEventDepend=true

	public Border resaltarnumero_cuotaCuota=null;
	public Boolean mostrarnumero_cuotaCuota=true;
	public Boolean activarnumero_cuotaCuota=true;

	public Border resaltarcapitalCuota=null;
	public Boolean mostrarcapitalCuota=true;
	public Boolean activarcapitalCuota=true;

	public Border resaltarinteresCuota=null;
	public Boolean mostrarinteresCuota=true;
	public Boolean activarinteresCuota=true;

	public Border resaltartotalCuota=null;
	public Boolean mostrartotalCuota=true;
	public Boolean activartotalCuota=true;

	public Border resaltarfecha_liquidacionCuota=null;
	public Boolean mostrarfecha_liquidacionCuota=true;
	public Boolean activarfecha_liquidacionCuota=true;

	public Border resaltarmonto_ajusteCuota=null;
	public Boolean mostrarmonto_ajusteCuota=true;
	public Boolean activarmonto_ajusteCuota=true;

	public Border resaltarinteres_ajusteCuota=null;
	public Boolean mostrarinteres_ajusteCuota=true;
	public Boolean activarinteres_ajusteCuota=true;

	public Border resaltarfecha_vencimientoCuota=null;
	public Boolean mostrarfecha_vencimientoCuota=true;
	public Boolean activarfecha_vencimientoCuota=false;

	public Border resaltardescripcionCuota=null;
	public Boolean mostrardescripcionCuota=true;
	public Boolean activardescripcionCuota=true;

	
	

	public Border setResaltaridCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltaridCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCuota() {
		return this.resaltaridCuota;
	}

	public void setResaltaridCuota(Border borderResaltar) {
		this.resaltaridCuota= borderResaltar;
	}

	public Boolean getMostraridCuota() {
		return this.mostraridCuota;
	}

	public void setMostraridCuota(Boolean mostraridCuota) {
		this.mostraridCuota= mostraridCuota;
	}

	public Boolean getActivaridCuota() {
		return this.activaridCuota;
	}

	public void setActivaridCuota(Boolean activaridCuota) {
		this.activaridCuota= activaridCuota;
	}

	public Border setResaltarid_prestamoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltarid_prestamoCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_prestamoCuota() {
		return this.resaltarid_prestamoCuota;
	}

	public void setResaltarid_prestamoCuota(Border borderResaltar) {
		this.resaltarid_prestamoCuota= borderResaltar;
	}

	public Boolean getMostrarid_prestamoCuota() {
		return this.mostrarid_prestamoCuota;
	}

	public void setMostrarid_prestamoCuota(Boolean mostrarid_prestamoCuota) {
		this.mostrarid_prestamoCuota= mostrarid_prestamoCuota;
	}

	public Boolean getActivarid_prestamoCuota() {
		return this.activarid_prestamoCuota;
	}

	public void setActivarid_prestamoCuota(Boolean activarid_prestamoCuota) {
		this.activarid_prestamoCuota= activarid_prestamoCuota;
	}

	public Boolean getCargarid_prestamoCuota() {
		return this.cargarid_prestamoCuota;
	}

	public void setCargarid_prestamoCuota(Boolean cargarid_prestamoCuota) {
		this.cargarid_prestamoCuota= cargarid_prestamoCuota;
	}

	public Border setResaltarid_estado_cuotaCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltarid_estado_cuotaCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_cuotaCuota() {
		return this.resaltarid_estado_cuotaCuota;
	}

	public void setResaltarid_estado_cuotaCuota(Border borderResaltar) {
		this.resaltarid_estado_cuotaCuota= borderResaltar;
	}

	public Boolean getMostrarid_estado_cuotaCuota() {
		return this.mostrarid_estado_cuotaCuota;
	}

	public void setMostrarid_estado_cuotaCuota(Boolean mostrarid_estado_cuotaCuota) {
		this.mostrarid_estado_cuotaCuota= mostrarid_estado_cuotaCuota;
	}

	public Boolean getActivarid_estado_cuotaCuota() {
		return this.activarid_estado_cuotaCuota;
	}

	public void setActivarid_estado_cuotaCuota(Boolean activarid_estado_cuotaCuota) {
		this.activarid_estado_cuotaCuota= activarid_estado_cuotaCuota;
	}

	public Boolean getCargarid_estado_cuotaCuota() {
		return this.cargarid_estado_cuotaCuota;
	}

	public void setCargarid_estado_cuotaCuota(Boolean cargarid_estado_cuotaCuota) {
		this.cargarid_estado_cuotaCuota= cargarid_estado_cuotaCuota;
	}

	public Border setResaltarid_defi_provision_empleadoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltarid_defi_provision_empleadoCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_defi_provision_empleadoCuota() {
		return this.resaltarid_defi_provision_empleadoCuota;
	}

	public void setResaltarid_defi_provision_empleadoCuota(Border borderResaltar) {
		this.resaltarid_defi_provision_empleadoCuota= borderResaltar;
	}

	public Boolean getMostrarid_defi_provision_empleadoCuota() {
		return this.mostrarid_defi_provision_empleadoCuota;
	}

	public void setMostrarid_defi_provision_empleadoCuota(Boolean mostrarid_defi_provision_empleadoCuota) {
		this.mostrarid_defi_provision_empleadoCuota= mostrarid_defi_provision_empleadoCuota;
	}

	public Boolean getActivarid_defi_provision_empleadoCuota() {
		return this.activarid_defi_provision_empleadoCuota;
	}

	public void setActivarid_defi_provision_empleadoCuota(Boolean activarid_defi_provision_empleadoCuota) {
		this.activarid_defi_provision_empleadoCuota= activarid_defi_provision_empleadoCuota;
	}

	public Boolean getCargarid_defi_provision_empleadoCuota() {
		return this.cargarid_defi_provision_empleadoCuota;
	}

	public void setCargarid_defi_provision_empleadoCuota(Boolean cargarid_defi_provision_empleadoCuota) {
		this.cargarid_defi_provision_empleadoCuota= cargarid_defi_provision_empleadoCuota;
	}

	public Border setResaltarnumero_cuotaCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltarnumero_cuotaCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuotaCuota() {
		return this.resaltarnumero_cuotaCuota;
	}

	public void setResaltarnumero_cuotaCuota(Border borderResaltar) {
		this.resaltarnumero_cuotaCuota= borderResaltar;
	}

	public Boolean getMostrarnumero_cuotaCuota() {
		return this.mostrarnumero_cuotaCuota;
	}

	public void setMostrarnumero_cuotaCuota(Boolean mostrarnumero_cuotaCuota) {
		this.mostrarnumero_cuotaCuota= mostrarnumero_cuotaCuota;
	}

	public Boolean getActivarnumero_cuotaCuota() {
		return this.activarnumero_cuotaCuota;
	}

	public void setActivarnumero_cuotaCuota(Boolean activarnumero_cuotaCuota) {
		this.activarnumero_cuotaCuota= activarnumero_cuotaCuota;
	}

	public Border setResaltarcapitalCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltarcapitalCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcapitalCuota() {
		return this.resaltarcapitalCuota;
	}

	public void setResaltarcapitalCuota(Border borderResaltar) {
		this.resaltarcapitalCuota= borderResaltar;
	}

	public Boolean getMostrarcapitalCuota() {
		return this.mostrarcapitalCuota;
	}

	public void setMostrarcapitalCuota(Boolean mostrarcapitalCuota) {
		this.mostrarcapitalCuota= mostrarcapitalCuota;
	}

	public Boolean getActivarcapitalCuota() {
		return this.activarcapitalCuota;
	}

	public void setActivarcapitalCuota(Boolean activarcapitalCuota) {
		this.activarcapitalCuota= activarcapitalCuota;
	}

	public Border setResaltarinteresCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltarinteresCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarinteresCuota() {
		return this.resaltarinteresCuota;
	}

	public void setResaltarinteresCuota(Border borderResaltar) {
		this.resaltarinteresCuota= borderResaltar;
	}

	public Boolean getMostrarinteresCuota() {
		return this.mostrarinteresCuota;
	}

	public void setMostrarinteresCuota(Boolean mostrarinteresCuota) {
		this.mostrarinteresCuota= mostrarinteresCuota;
	}

	public Boolean getActivarinteresCuota() {
		return this.activarinteresCuota;
	}

	public void setActivarinteresCuota(Boolean activarinteresCuota) {
		this.activarinteresCuota= activarinteresCuota;
	}

	public Border setResaltartotalCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltartotalCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalCuota() {
		return this.resaltartotalCuota;
	}

	public void setResaltartotalCuota(Border borderResaltar) {
		this.resaltartotalCuota= borderResaltar;
	}

	public Boolean getMostrartotalCuota() {
		return this.mostrartotalCuota;
	}

	public void setMostrartotalCuota(Boolean mostrartotalCuota) {
		this.mostrartotalCuota= mostrartotalCuota;
	}

	public Boolean getActivartotalCuota() {
		return this.activartotalCuota;
	}

	public void setActivartotalCuota(Boolean activartotalCuota) {
		this.activartotalCuota= activartotalCuota;
	}

	public Border setResaltarfecha_liquidacionCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltarfecha_liquidacionCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_liquidacionCuota() {
		return this.resaltarfecha_liquidacionCuota;
	}

	public void setResaltarfecha_liquidacionCuota(Border borderResaltar) {
		this.resaltarfecha_liquidacionCuota= borderResaltar;
	}

	public Boolean getMostrarfecha_liquidacionCuota() {
		return this.mostrarfecha_liquidacionCuota;
	}

	public void setMostrarfecha_liquidacionCuota(Boolean mostrarfecha_liquidacionCuota) {
		this.mostrarfecha_liquidacionCuota= mostrarfecha_liquidacionCuota;
	}

	public Boolean getActivarfecha_liquidacionCuota() {
		return this.activarfecha_liquidacionCuota;
	}

	public void setActivarfecha_liquidacionCuota(Boolean activarfecha_liquidacionCuota) {
		this.activarfecha_liquidacionCuota= activarfecha_liquidacionCuota;
	}

	public Border setResaltarmonto_ajusteCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltarmonto_ajusteCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_ajusteCuota() {
		return this.resaltarmonto_ajusteCuota;
	}

	public void setResaltarmonto_ajusteCuota(Border borderResaltar) {
		this.resaltarmonto_ajusteCuota= borderResaltar;
	}

	public Boolean getMostrarmonto_ajusteCuota() {
		return this.mostrarmonto_ajusteCuota;
	}

	public void setMostrarmonto_ajusteCuota(Boolean mostrarmonto_ajusteCuota) {
		this.mostrarmonto_ajusteCuota= mostrarmonto_ajusteCuota;
	}

	public Boolean getActivarmonto_ajusteCuota() {
		return this.activarmonto_ajusteCuota;
	}

	public void setActivarmonto_ajusteCuota(Boolean activarmonto_ajusteCuota) {
		this.activarmonto_ajusteCuota= activarmonto_ajusteCuota;
	}

	public Border setResaltarinteres_ajusteCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltarinteres_ajusteCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarinteres_ajusteCuota() {
		return this.resaltarinteres_ajusteCuota;
	}

	public void setResaltarinteres_ajusteCuota(Border borderResaltar) {
		this.resaltarinteres_ajusteCuota= borderResaltar;
	}

	public Boolean getMostrarinteres_ajusteCuota() {
		return this.mostrarinteres_ajusteCuota;
	}

	public void setMostrarinteres_ajusteCuota(Boolean mostrarinteres_ajusteCuota) {
		this.mostrarinteres_ajusteCuota= mostrarinteres_ajusteCuota;
	}

	public Boolean getActivarinteres_ajusteCuota() {
		return this.activarinteres_ajusteCuota;
	}

	public void setActivarinteres_ajusteCuota(Boolean activarinteres_ajusteCuota) {
		this.activarinteres_ajusteCuota= activarinteres_ajusteCuota;
	}

	public Border setResaltarfecha_vencimientoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoCuota() {
		return this.resaltarfecha_vencimientoCuota;
	}

	public void setResaltarfecha_vencimientoCuota(Border borderResaltar) {
		this.resaltarfecha_vencimientoCuota= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoCuota() {
		return this.mostrarfecha_vencimientoCuota;
	}

	public void setMostrarfecha_vencimientoCuota(Boolean mostrarfecha_vencimientoCuota) {
		this.mostrarfecha_vencimientoCuota= mostrarfecha_vencimientoCuota;
	}

	public Boolean getActivarfecha_vencimientoCuota() {
		return this.activarfecha_vencimientoCuota;
	}

	public void setActivarfecha_vencimientoCuota(Boolean activarfecha_vencimientoCuota) {
		this.activarfecha_vencimientoCuota= activarfecha_vencimientoCuota;
	}

	public Border setResaltardescripcionCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuotaBeanSwingJInternalFrame.jTtoolBarCuota.setBorder(borderResaltar);
		
		this.resaltardescripcionCuota= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionCuota() {
		return this.resaltardescripcionCuota;
	}

	public void setResaltardescripcionCuota(Border borderResaltar) {
		this.resaltardescripcionCuota= borderResaltar;
	}

	public Boolean getMostrardescripcionCuota() {
		return this.mostrardescripcionCuota;
	}

	public void setMostrardescripcionCuota(Boolean mostrardescripcionCuota) {
		this.mostrardescripcionCuota= mostrardescripcionCuota;
	}

	public Boolean getActivardescripcionCuota() {
		return this.activardescripcionCuota;
	}

	public void setActivardescripcionCuota(Boolean activardescripcionCuota) {
		this.activardescripcionCuota= activardescripcionCuota;
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
		
		
		this.setMostraridCuota(esInicial);
		this.setMostrarid_prestamoCuota(esInicial);
		this.setMostrarid_estado_cuotaCuota(esInicial);
		this.setMostrarid_defi_provision_empleadoCuota(esInicial);
		this.setMostrarnumero_cuotaCuota(esInicial);
		this.setMostrarcapitalCuota(esInicial);
		this.setMostrarinteresCuota(esInicial);
		this.setMostrartotalCuota(esInicial);
		this.setMostrarfecha_liquidacionCuota(esInicial);
		this.setMostrarmonto_ajusteCuota(esInicial);
		this.setMostrarinteres_ajusteCuota(esInicial);
		this.setMostrarfecha_vencimientoCuota(esInicial);
		this.setMostrardescripcionCuota(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuotaConstantesFunciones.ID)) {
				this.setMostraridCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.IDPRESTAMO)) {
				this.setMostrarid_prestamoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.IDESTADOCUOTA)) {
				this.setMostrarid_estado_cuotaCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.IDDEFIPROVISIONEMPLEADO)) {
				this.setMostrarid_defi_provision_empleadoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.NUMEROCUOTA)) {
				this.setMostrarnumero_cuotaCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.CAPITAL)) {
				this.setMostrarcapitalCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.INTERES)) {
				this.setMostrarinteresCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.TOTAL)) {
				this.setMostrartotalCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.FECHALIQUIDACION)) {
				this.setMostrarfecha_liquidacionCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.MONTOAJUSTE)) {
				this.setMostrarmonto_ajusteCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.INTERESAJUSTE)) {
				this.setMostrarinteres_ajusteCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionCuota(esAsigna);
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
		
		
		this.setActivaridCuota(esInicial);
		this.setActivarid_prestamoCuota(esInicial);
		this.setActivarid_estado_cuotaCuota(esInicial);
		this.setActivarid_defi_provision_empleadoCuota(esInicial);
		this.setActivarnumero_cuotaCuota(esInicial);
		this.setActivarcapitalCuota(esInicial);
		this.setActivarinteresCuota(esInicial);
		this.setActivartotalCuota(esInicial);
		this.setActivarfecha_liquidacionCuota(esInicial);
		this.setActivarmonto_ajusteCuota(esInicial);
		this.setActivarinteres_ajusteCuota(esInicial);
		this.setActivarfecha_vencimientoCuota(esInicial);
		this.setActivardescripcionCuota(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuotaConstantesFunciones.ID)) {
				this.setActivaridCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.IDPRESTAMO)) {
				this.setActivarid_prestamoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.IDESTADOCUOTA)) {
				this.setActivarid_estado_cuotaCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.IDDEFIPROVISIONEMPLEADO)) {
				this.setActivarid_defi_provision_empleadoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.NUMEROCUOTA)) {
				this.setActivarnumero_cuotaCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.CAPITAL)) {
				this.setActivarcapitalCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.INTERES)) {
				this.setActivarinteresCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.TOTAL)) {
				this.setActivartotalCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.FECHALIQUIDACION)) {
				this.setActivarfecha_liquidacionCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.MONTOAJUSTE)) {
				this.setActivarmonto_ajusteCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.INTERESAJUSTE)) {
				this.setActivarinteres_ajusteCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionCuota(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCuota(esInicial);
		this.setResaltarid_prestamoCuota(esInicial);
		this.setResaltarid_estado_cuotaCuota(esInicial);
		this.setResaltarid_defi_provision_empleadoCuota(esInicial);
		this.setResaltarnumero_cuotaCuota(esInicial);
		this.setResaltarcapitalCuota(esInicial);
		this.setResaltarinteresCuota(esInicial);
		this.setResaltartotalCuota(esInicial);
		this.setResaltarfecha_liquidacionCuota(esInicial);
		this.setResaltarmonto_ajusteCuota(esInicial);
		this.setResaltarinteres_ajusteCuota(esInicial);
		this.setResaltarfecha_vencimientoCuota(esInicial);
		this.setResaltardescripcionCuota(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuotaConstantesFunciones.ID)) {
				this.setResaltaridCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.IDPRESTAMO)) {
				this.setResaltarid_prestamoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.IDESTADOCUOTA)) {
				this.setResaltarid_estado_cuotaCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.IDDEFIPROVISIONEMPLEADO)) {
				this.setResaltarid_defi_provision_empleadoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.NUMEROCUOTA)) {
				this.setResaltarnumero_cuotaCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.CAPITAL)) {
				this.setResaltarcapitalCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.INTERES)) {
				this.setResaltarinteresCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.TOTAL)) {
				this.setResaltartotalCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.FECHALIQUIDACION)) {
				this.setResaltarfecha_liquidacionCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.MONTOAJUSTE)) {
				this.setResaltarmonto_ajusteCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.INTERESAJUSTE)) {
				this.setResaltarinteres_ajusteCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoCuota(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuotaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionCuota(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdDefiProvisionEmpleadoCuota=true;

	public Boolean getMostrarFK_IdDefiProvisionEmpleadoCuota() {
		return this.mostrarFK_IdDefiProvisionEmpleadoCuota;
	}

	public void setMostrarFK_IdDefiProvisionEmpleadoCuota(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDefiProvisionEmpleadoCuota= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoCuotaCuota=true;

	public Boolean getMostrarFK_IdEstadoCuotaCuota() {
		return this.mostrarFK_IdEstadoCuotaCuota;
	}

	public void setMostrarFK_IdEstadoCuotaCuota(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoCuotaCuota= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPrestamoCuota=true;

	public Boolean getMostrarFK_IdPrestamoCuota() {
		return this.mostrarFK_IdPrestamoCuota;
	}

	public void setMostrarFK_IdPrestamoCuota(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPrestamoCuota= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdDefiProvisionEmpleadoCuota=true;

	public Boolean getActivarFK_IdDefiProvisionEmpleadoCuota() {
		return this.activarFK_IdDefiProvisionEmpleadoCuota;
	}

	public void setActivarFK_IdDefiProvisionEmpleadoCuota(Boolean habilitarResaltar) {
		this.activarFK_IdDefiProvisionEmpleadoCuota= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoCuotaCuota=true;

	public Boolean getActivarFK_IdEstadoCuotaCuota() {
		return this.activarFK_IdEstadoCuotaCuota;
	}

	public void setActivarFK_IdEstadoCuotaCuota(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoCuotaCuota= habilitarResaltar;
	}

	public Boolean activarFK_IdPrestamoCuota=true;

	public Boolean getActivarFK_IdPrestamoCuota() {
		return this.activarFK_IdPrestamoCuota;
	}

	public void setActivarFK_IdPrestamoCuota(Boolean habilitarResaltar) {
		this.activarFK_IdPrestamoCuota= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdDefiProvisionEmpleadoCuota=null;

	public Border getResaltarFK_IdDefiProvisionEmpleadoCuota() {
		return this.resaltarFK_IdDefiProvisionEmpleadoCuota;
	}

	public void setResaltarFK_IdDefiProvisionEmpleadoCuota(Border borderResaltar) {
		this.resaltarFK_IdDefiProvisionEmpleadoCuota= borderResaltar;
	}

	public void setResaltarFK_IdDefiProvisionEmpleadoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDefiProvisionEmpleadoCuota= borderResaltar;
	}

	public Border resaltarFK_IdEstadoCuotaCuota=null;

	public Border getResaltarFK_IdEstadoCuotaCuota() {
		return this.resaltarFK_IdEstadoCuotaCuota;
	}

	public void setResaltarFK_IdEstadoCuotaCuota(Border borderResaltar) {
		this.resaltarFK_IdEstadoCuotaCuota= borderResaltar;
	}

	public void setResaltarFK_IdEstadoCuotaCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoCuotaCuota= borderResaltar;
	}

	public Border resaltarFK_IdPrestamoCuota=null;

	public Border getResaltarFK_IdPrestamoCuota() {
		return this.resaltarFK_IdPrestamoCuota;
	}

	public void setResaltarFK_IdPrestamoCuota(Border borderResaltar) {
		this.resaltarFK_IdPrestamoCuota= borderResaltar;
	}

	public void setResaltarFK_IdPrestamoCuota(ParametroGeneralUsuario parametroGeneralUsuario/*CuotaBeanSwingJInternalFrame cuotaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPrestamoCuota= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}