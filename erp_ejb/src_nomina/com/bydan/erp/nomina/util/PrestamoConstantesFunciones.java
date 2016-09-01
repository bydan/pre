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


import com.bydan.erp.nomina.util.PrestamoConstantesFunciones;
import com.bydan.erp.nomina.util.PrestamoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.PrestamoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PrestamoConstantesFunciones extends PrestamoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Prestamo";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Prestamo"+PrestamoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PrestamoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PrestamoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PrestamoConstantesFunciones.SCHEMA+"_"+PrestamoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PrestamoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PrestamoConstantesFunciones.SCHEMA+"_"+PrestamoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PrestamoConstantesFunciones.SCHEMA+"_"+PrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PrestamoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PrestamoConstantesFunciones.SCHEMA+"_"+PrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PrestamoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PrestamoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PrestamoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PrestamoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PrestamoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PrestamoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Prestamos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Prestamo";
	public static final String SCLASSWEBTITULO_LOWER="Prestamo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Prestamo";
	public static final String OBJECTNAME="prestamo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="prestamo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select prestamo from "+PrestamoConstantesFunciones.SPERSISTENCENAME+" prestamo";
	public static String QUERYSELECTNATIVE="select "+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".id,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".version_row,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".id_empresa,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".id_empleado,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".id_tipo_prestamo,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".id_tipo_cuota,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".id_asiento_contable,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".codigo,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".numero_pre_impreso,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".fecha,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".monto,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".numero_cuotas,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".tasa,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".descripcion from "+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME;//+" as "+PrestamoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected PrestamoConstantesFuncionesAdditional prestamoConstantesFuncionesAdditional=null;
	
	public PrestamoConstantesFuncionesAdditional getPrestamoConstantesFuncionesAdditional() {
		return this.prestamoConstantesFuncionesAdditional;
	}
	
	public void setPrestamoConstantesFuncionesAdditional(PrestamoConstantesFuncionesAdditional prestamoConstantesFuncionesAdditional) {
		try {
			this.prestamoConstantesFuncionesAdditional=prestamoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDTIPOPRESTAMO= "id_tipo_prestamo";
    public static final String IDTIPOCUOTA= "id_tipo_cuota";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String CODIGO= "codigo";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String FECHA= "fecha";
    public static final String MONTO= "monto";
    public static final String NUMEROCUOTAS= "numero_cuotas";
    public static final String TASA= "tasa";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDTIPOPRESTAMO= "Tipo Prestamo";
		public static final String LABEL_IDTIPOPRESTAMO_LOWER= "Tipo Prestamo";
    	public static final String LABEL_IDTIPOCUOTA= "Tipo Cuota";
		public static final String LABEL_IDTIPOCUOTA_LOWER= "Tipo Cuota";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_NUMEROCUOTAS= "Numero Cuotas";
		public static final String LABEL_NUMEROCUOTAS_LOWER= "Numero Cuotas";
    	public static final String LABEL_TASA= "Tasa";
		public static final String LABEL_TASA_LOWER= "Tasa";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPrestamoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PrestamoConstantesFunciones.IDEMPRESA)) {sLabelColumna=PrestamoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PrestamoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=PrestamoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(PrestamoConstantesFunciones.IDTIPOPRESTAMO)) {sLabelColumna=PrestamoConstantesFunciones.LABEL_IDTIPOPRESTAMO;}
		if(sNombreColumna.equals(PrestamoConstantesFunciones.IDTIPOCUOTA)) {sLabelColumna=PrestamoConstantesFunciones.LABEL_IDTIPOCUOTA;}
		if(sNombreColumna.equals(PrestamoConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=PrestamoConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(PrestamoConstantesFunciones.CODIGO)) {sLabelColumna=PrestamoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PrestamoConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=PrestamoConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(PrestamoConstantesFunciones.FECHA)) {sLabelColumna=PrestamoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PrestamoConstantesFunciones.MONTO)) {sLabelColumna=PrestamoConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(PrestamoConstantesFunciones.NUMEROCUOTAS)) {sLabelColumna=PrestamoConstantesFunciones.LABEL_NUMEROCUOTAS;}
		if(sNombreColumna.equals(PrestamoConstantesFunciones.TASA)) {sLabelColumna=PrestamoConstantesFunciones.LABEL_TASA;}
		if(sNombreColumna.equals(PrestamoConstantesFunciones.DESCRIPCION)) {sLabelColumna=PrestamoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPrestamoDescripcion(Prestamo prestamo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(prestamo !=null/* && prestamo.getId()!=0*/) {
			sDescripcion=prestamo.getcodigo();//prestamoprestamo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPrestamoDescripcionDetallado(Prestamo prestamo) {
		String sDescripcion="";
			
		sDescripcion+=PrestamoConstantesFunciones.ID+"=";
		sDescripcion+=prestamo.getId().toString()+",";
		sDescripcion+=PrestamoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=prestamo.getVersionRow().toString()+",";
		sDescripcion+=PrestamoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=prestamo.getid_empresa().toString()+",";
		sDescripcion+=PrestamoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=prestamo.getid_empleado().toString()+",";
		sDescripcion+=PrestamoConstantesFunciones.IDTIPOPRESTAMO+"=";
		sDescripcion+=prestamo.getid_tipo_prestamo().toString()+",";
		sDescripcion+=PrestamoConstantesFunciones.IDTIPOCUOTA+"=";
		sDescripcion+=prestamo.getid_tipo_cuota().toString()+",";
		sDescripcion+=PrestamoConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=prestamo.getid_asiento_contable().toString()+",";
		sDescripcion+=PrestamoConstantesFunciones.CODIGO+"=";
		sDescripcion+=prestamo.getcodigo()+",";
		sDescripcion+=PrestamoConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=prestamo.getnumero_pre_impreso()+",";
		sDescripcion+=PrestamoConstantesFunciones.FECHA+"=";
		sDescripcion+=prestamo.getfecha().toString()+",";
		sDescripcion+=PrestamoConstantesFunciones.MONTO+"=";
		sDescripcion+=prestamo.getmonto().toString()+",";
		sDescripcion+=PrestamoConstantesFunciones.NUMEROCUOTAS+"=";
		sDescripcion+=prestamo.getnumero_cuotas().toString()+",";
		sDescripcion+=PrestamoConstantesFunciones.TASA+"=";
		sDescripcion+=prestamo.gettasa().toString()+",";
		sDescripcion+=PrestamoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=prestamo.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setPrestamoDescripcion(Prestamo prestamo,String sValor) throws Exception {			
		if(prestamo !=null) {
			prestamo.setcodigo(sValor);;//prestamoprestamo.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getTipoPrestamoDescripcion(TipoPrestamo tipoprestamo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprestamo!=null/*&&tipoprestamo.getId()>0*/) {
			sDescripcion=TipoPrestamoConstantesFunciones.getTipoPrestamoDescripcion(tipoprestamo);
		}

		return sDescripcion;
	}

	public static String getTipoCuotaDescripcion(TipoCuota tipocuota) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocuota!=null/*&&tipocuota.getId()>0*/) {
			sDescripcion=TipoCuotaConstantesFunciones.getTipoCuotaDescripcion(tipocuota);
		}

		return sDescripcion;
	}

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoCuota")) {
			sNombreIndice="Tipo=  Por Tipo Cuota";
		} else if(sNombreIndice.equals("FK_IdTipoPrestamo")) {
			sNombreIndice="Tipo=  Por Tipo Prestamo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCuota(Long id_tipo_cuota) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cuota!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cuota="+id_tipo_cuota.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrestamo(Long id_tipo_prestamo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_prestamo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Prestamo="+id_tipo_prestamo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPrestamo(Prestamo prestamo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		prestamo.setcodigo(prestamo.getcodigo().trim());
		prestamo.setnumero_pre_impreso(prestamo.getnumero_pre_impreso().trim());
		prestamo.setdescripcion(prestamo.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPrestamos(List<Prestamo> prestamos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Prestamo prestamo: prestamos) {
			prestamo.setcodigo(prestamo.getcodigo().trim());
			prestamo.setnumero_pre_impreso(prestamo.getnumero_pre_impreso().trim());
			prestamo.setdescripcion(prestamo.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPrestamo(Prestamo prestamo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && prestamo.getConCambioAuxiliar()) {
			prestamo.setIsDeleted(prestamo.getIsDeletedAuxiliar());	
			prestamo.setIsNew(prestamo.getIsNewAuxiliar());	
			prestamo.setIsChanged(prestamo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			prestamo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			prestamo.setIsDeletedAuxiliar(false);	
			prestamo.setIsNewAuxiliar(false);	
			prestamo.setIsChangedAuxiliar(false);
			
			prestamo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPrestamos(List<Prestamo> prestamos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Prestamo prestamo : prestamos) {
			if(conAsignarBase && prestamo.getConCambioAuxiliar()) {
				prestamo.setIsDeleted(prestamo.getIsDeletedAuxiliar());	
				prestamo.setIsNew(prestamo.getIsNewAuxiliar());	
				prestamo.setIsChanged(prestamo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				prestamo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				prestamo.setIsDeletedAuxiliar(false);	
				prestamo.setIsNewAuxiliar(false);	
				prestamo.setIsChangedAuxiliar(false);
				
				prestamo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPrestamo(Prestamo prestamo,Boolean conEnteros) throws Exception  {
		prestamo.setmonto(0.0);
		prestamo.settasa(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			prestamo.setnumero_cuotas(0);
		}
	}		
	
	public static void InicializarValoresPrestamos(List<Prestamo> prestamos,Boolean conEnteros) throws Exception  {
		
		for(Prestamo prestamo: prestamos) {
			prestamo.setmonto(0.0);
			prestamo.settasa(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				prestamo.setnumero_cuotas(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPrestamo(List<Prestamo> prestamos,Prestamo prestamoAux) throws Exception  {
		PrestamoConstantesFunciones.InicializarValoresPrestamo(prestamoAux,true);
		
		for(Prestamo prestamo: prestamos) {
			if(prestamo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			prestamoAux.setmonto(prestamoAux.getmonto()+prestamo.getmonto());			
			prestamoAux.setnumero_cuotas(prestamoAux.getnumero_cuotas()+prestamo.getnumero_cuotas());			
			prestamoAux.settasa(prestamoAux.gettasa()+prestamo.gettasa());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPrestamo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PrestamoConstantesFunciones.getArrayColumnasGlobalesPrestamo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPrestamo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PrestamoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PrestamoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPrestamo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Prestamo> prestamos,Prestamo prestamo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Prestamo prestamoAux: prestamos) {
			if(prestamoAux!=null && prestamo!=null) {
				if((prestamoAux.getId()==null && prestamo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(prestamoAux.getId()!=null && prestamo.getId()!=null){
					if(prestamoAux.getId().equals(prestamo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPrestamo(List<Prestamo> prestamos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
		Double tasaTotal=0.0;
	
		for(Prestamo prestamo: prestamos) {			
			if(prestamo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			montoTotal+=prestamo.getmonto();
			tasaTotal+=prestamo.gettasa();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PrestamoConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(PrestamoConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PrestamoConstantesFunciones.TASA);
		datoGeneral.setsDescripcion(PrestamoConstantesFunciones.LABEL_TASA);
		datoGeneral.setdValorDouble(tasaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPrestamo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_ID, PrestamoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_VERSIONROW, PrestamoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_IDEMPRESA, PrestamoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_IDEMPLEADO, PrestamoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_IDTIPOPRESTAMO, PrestamoConstantesFunciones.IDTIPOPRESTAMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_IDTIPOCUOTA, PrestamoConstantesFunciones.IDTIPOCUOTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_IDASIENTOCONTABLE, PrestamoConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_CODIGO, PrestamoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_NUMEROPREIMPRESO, PrestamoConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_FECHA, PrestamoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_MONTO, PrestamoConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_NUMEROCUOTAS, PrestamoConstantesFunciones.NUMEROCUOTAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_TASA, PrestamoConstantesFunciones.TASA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PrestamoConstantesFunciones.LABEL_DESCRIPCION, PrestamoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPrestamo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.IDTIPOPRESTAMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.IDTIPOCUOTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.NUMEROCUOTAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.TASA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PrestamoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPrestamo() throws Exception  {
		return PrestamoConstantesFunciones.getTiposSeleccionarPrestamo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPrestamo(Boolean conFk) throws Exception  {
		return PrestamoConstantesFunciones.getTiposSeleccionarPrestamo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPrestamo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrestamoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PrestamoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrestamoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(PrestamoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrestamoConstantesFunciones.LABEL_IDTIPOPRESTAMO);
			reporte.setsDescripcion(PrestamoConstantesFunciones.LABEL_IDTIPOPRESTAMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrestamoConstantesFunciones.LABEL_IDTIPOCUOTA);
			reporte.setsDescripcion(PrestamoConstantesFunciones.LABEL_IDTIPOCUOTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PrestamoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(PrestamoConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PrestamoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PrestamoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PrestamoConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(PrestamoConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PrestamoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PrestamoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PrestamoConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(PrestamoConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PrestamoConstantesFunciones.LABEL_NUMEROCUOTAS);
			reporte.setsDescripcion(PrestamoConstantesFunciones.LABEL_NUMEROCUOTAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PrestamoConstantesFunciones.LABEL_TASA);
			reporte.setsDescripcion(PrestamoConstantesFunciones.LABEL_TASA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PrestamoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PrestamoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPrestamo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPrestamo(Prestamo prestamoAux) throws Exception {
		
			prestamoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(prestamoAux.getEmpresa()));
			prestamoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(prestamoAux.getEmpleado()));
			prestamoAux.settipoprestamo_descripcion(TipoPrestamoConstantesFunciones.getTipoPrestamoDescripcion(prestamoAux.getTipoPrestamo()));
			prestamoAux.settipocuota_descripcion(TipoCuotaConstantesFunciones.getTipoCuotaDescripcion(prestamoAux.getTipoCuota()));
			prestamoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(prestamoAux.getAsientoContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPrestamo(List<Prestamo> prestamosTemp) throws Exception {
		for(Prestamo prestamoAux:prestamosTemp) {
			
			prestamoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(prestamoAux.getEmpresa()));
			prestamoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(prestamoAux.getEmpleado()));
			prestamoAux.settipoprestamo_descripcion(TipoPrestamoConstantesFunciones.getTipoPrestamoDescripcion(prestamoAux.getTipoPrestamo()));
			prestamoAux.settipocuota_descripcion(TipoCuotaConstantesFunciones.getTipoCuotaDescripcion(prestamoAux.getTipoCuota()));
			prestamoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(prestamoAux.getAsientoContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoPrestamo.class));
				classes.add(new Classe(TipoCuota.class));
				classes.add(new Classe(AsientoContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrestamo.class)) {
						classes.add(new Classe(TipoPrestamo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCuota.class)) {
						classes.add(new Classe(TipoCuota.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPrestamo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoPrestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrestamo.class)); continue;
					}

					if(TipoCuota.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuota.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoPrestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrestamo.class)); continue;
					}

					if(TipoCuota.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuota.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PrestamoConstantesFunciones.getClassesRelationshipsOfPrestamo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(AbonoPrestamo.class));
				classes.add(new Classe(Cuota.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(AbonoPrestamo.class)) {
						classes.add(new Classe(AbonoPrestamo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cuota.class)) {
						classes.add(new Classe(Cuota.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPrestamo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PrestamoConstantesFunciones.getClassesRelationshipsFromStringsOfPrestamo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPrestamo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(AbonoPrestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AbonoPrestamo.class)); continue;
					}

					if(Cuota.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cuota.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(AbonoPrestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AbonoPrestamo.class)); continue;
					}

					if(Cuota.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cuota.class)); continue;
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
	public static void actualizarLista(Prestamo prestamo,List<Prestamo> prestamos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Prestamo prestamoEncontrado=null;
			
			for(Prestamo prestamoLocal:prestamos) {
				if(prestamoLocal.getId().equals(prestamo.getId())) {
					prestamoEncontrado=prestamoLocal;
					
					prestamoLocal.setIsChanged(prestamo.getIsChanged());
					prestamoLocal.setIsNew(prestamo.getIsNew());
					prestamoLocal.setIsDeleted(prestamo.getIsDeleted());
					
					prestamoLocal.setGeneralEntityOriginal(prestamo.getGeneralEntityOriginal());
					
					prestamoLocal.setId(prestamo.getId());	
					prestamoLocal.setVersionRow(prestamo.getVersionRow());	
					prestamoLocal.setid_empresa(prestamo.getid_empresa());	
					prestamoLocal.setid_empleado(prestamo.getid_empleado());	
					prestamoLocal.setid_tipo_prestamo(prestamo.getid_tipo_prestamo());	
					prestamoLocal.setid_tipo_cuota(prestamo.getid_tipo_cuota());	
					prestamoLocal.setid_asiento_contable(prestamo.getid_asiento_contable());	
					prestamoLocal.setcodigo(prestamo.getcodigo());	
					prestamoLocal.setnumero_pre_impreso(prestamo.getnumero_pre_impreso());	
					prestamoLocal.setfecha(prestamo.getfecha());	
					prestamoLocal.setmonto(prestamo.getmonto());	
					prestamoLocal.setnumero_cuotas(prestamo.getnumero_cuotas());	
					prestamoLocal.settasa(prestamo.gettasa());	
					prestamoLocal.setdescripcion(prestamo.getdescripcion());	
					
					
					prestamoLocal.setAbonoPrestamos(prestamo.getAbonoPrestamos());
					prestamoLocal.setCuotas(prestamo.getCuotas());
					
					existe=true;
					break;
				}
			}
			
			if(!prestamo.getIsDeleted()) {
				if(!existe) {
					prestamos.add(prestamo);
				}
			} else {
				if(prestamoEncontrado!=null && permiteQuitar)  {
					prestamos.remove(prestamoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Prestamo prestamo,List<Prestamo> prestamos) throws Exception {
		try	{			
			for(Prestamo prestamoLocal:prestamos) {
				if(prestamoLocal.getId().equals(prestamo.getId())) {
					prestamoLocal.setIsSelected(prestamo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPrestamo(List<Prestamo> prestamosAux) throws Exception {
		//this.prestamosAux=prestamosAux;
		
		for(Prestamo prestamoAux:prestamosAux) {
			if(prestamoAux.getIsChanged()) {
				prestamoAux.setIsChanged(false);
			}		
			
			if(prestamoAux.getIsNew()) {
				prestamoAux.setIsNew(false);
			}	
			
			if(prestamoAux.getIsDeleted()) {
				prestamoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPrestamo(Prestamo prestamoAux) throws Exception {
		//this.prestamoAux=prestamoAux;
		
			if(prestamoAux.getIsChanged()) {
				prestamoAux.setIsChanged(false);
			}		
			
			if(prestamoAux.getIsNew()) {
				prestamoAux.setIsNew(false);
			}	
			
			if(prestamoAux.getIsDeleted()) {
				prestamoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Prestamo prestamoAsignar,Prestamo prestamo) throws Exception {
		prestamoAsignar.setId(prestamo.getId());	
		prestamoAsignar.setVersionRow(prestamo.getVersionRow());	
		prestamoAsignar.setid_empresa(prestamo.getid_empresa());
		prestamoAsignar.setempresa_descripcion(prestamo.getempresa_descripcion());	
		prestamoAsignar.setid_empleado(prestamo.getid_empleado());
		prestamoAsignar.setempleado_descripcion(prestamo.getempleado_descripcion());	
		prestamoAsignar.setid_tipo_prestamo(prestamo.getid_tipo_prestamo());
		prestamoAsignar.settipoprestamo_descripcion(prestamo.gettipoprestamo_descripcion());	
		prestamoAsignar.setid_tipo_cuota(prestamo.getid_tipo_cuota());
		prestamoAsignar.settipocuota_descripcion(prestamo.gettipocuota_descripcion());	
		prestamoAsignar.setid_asiento_contable(prestamo.getid_asiento_contable());
		prestamoAsignar.setasientocontable_descripcion(prestamo.getasientocontable_descripcion());	
		prestamoAsignar.setcodigo(prestamo.getcodigo());	
		prestamoAsignar.setnumero_pre_impreso(prestamo.getnumero_pre_impreso());	
		prestamoAsignar.setfecha(prestamo.getfecha());	
		prestamoAsignar.setmonto(prestamo.getmonto());	
		prestamoAsignar.setnumero_cuotas(prestamo.getnumero_cuotas());	
		prestamoAsignar.settasa(prestamo.gettasa());	
		prestamoAsignar.setdescripcion(prestamo.getdescripcion());	
	}
	
	public static void inicializarPrestamo(Prestamo prestamo) throws Exception {
		try {
				prestamo.setId(0L);	
					
				prestamo.setid_empresa(-1L);	
				prestamo.setid_empleado(-1L);	
				prestamo.setid_tipo_prestamo(-1L);	
				prestamo.setid_tipo_cuota(-1L);	
				prestamo.setid_asiento_contable(null);	
				prestamo.setcodigo("");	
				prestamo.setnumero_pre_impreso("");	
				prestamo.setfecha(new Date());	
				prestamo.setmonto(0.0);	
				prestamo.setnumero_cuotas(0);	
				prestamo.settasa(0.0);	
				prestamo.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPrestamo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PrestamoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrestamoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrestamoConstantesFunciones.LABEL_IDTIPOPRESTAMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrestamoConstantesFunciones.LABEL_IDTIPOCUOTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrestamoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrestamoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrestamoConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrestamoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrestamoConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrestamoConstantesFunciones.LABEL_NUMEROCUOTAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrestamoConstantesFunciones.LABEL_TASA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PrestamoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPrestamo(String sTipo,Row row,Workbook workbook,Prestamo prestamo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(prestamo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prestamo.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prestamo.gettipoprestamo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prestamo.gettipocuota_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prestamo.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prestamo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prestamo.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prestamo.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prestamo.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prestamo.getnumero_cuotas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prestamo.gettasa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prestamo.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPrestamo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPrestamo() {
		return this.sFinalQueryPrestamo;
	}
	
	public void setsFinalQueryPrestamo(String sFinalQueryPrestamo) {
		this.sFinalQueryPrestamo= sFinalQueryPrestamo;
	}
	
	public Border resaltarSeleccionarPrestamo=null;
	
	public Border setResaltarSeleccionarPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPrestamo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPrestamo() {
		return this.resaltarSeleccionarPrestamo;
	}
	
	public void setResaltarSeleccionarPrestamo(Border borderResaltarSeleccionarPrestamo) {
		this.resaltarSeleccionarPrestamo= borderResaltarSeleccionarPrestamo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPrestamo=null;
	public Boolean mostraridPrestamo=true;
	public Boolean activaridPrestamo=true;

	public Border resaltarid_empresaPrestamo=null;
	public Boolean mostrarid_empresaPrestamo=true;
	public Boolean activarid_empresaPrestamo=true;
	public Boolean cargarid_empresaPrestamo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPrestamo=false;//ConEventDepend=true

	public Border resaltarid_empleadoPrestamo=null;
	public Boolean mostrarid_empleadoPrestamo=true;
	public Boolean activarid_empleadoPrestamo=true;
	public Boolean cargarid_empleadoPrestamo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoPrestamo=false;//ConEventDepend=true

	public Border resaltarid_tipo_prestamoPrestamo=null;
	public Boolean mostrarid_tipo_prestamoPrestamo=true;
	public Boolean activarid_tipo_prestamoPrestamo=true;
	public Boolean cargarid_tipo_prestamoPrestamo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_prestamoPrestamo=false;//ConEventDepend=true

	public Border resaltarid_tipo_cuotaPrestamo=null;
	public Boolean mostrarid_tipo_cuotaPrestamo=true;
	public Boolean activarid_tipo_cuotaPrestamo=true;
	public Boolean cargarid_tipo_cuotaPrestamo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cuotaPrestamo=false;//ConEventDepend=true

	public Border resaltarid_asiento_contablePrestamo=null;
	public Boolean mostrarid_asiento_contablePrestamo=true;
	public Boolean activarid_asiento_contablePrestamo=true;
	public Boolean cargarid_asiento_contablePrestamo=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contablePrestamo=false;//ConEventDepend=true

	public Border resaltarcodigoPrestamo=null;
	public Boolean mostrarcodigoPrestamo=true;
	public Boolean activarcodigoPrestamo=true;

	public Border resaltarnumero_pre_impresoPrestamo=null;
	public Boolean mostrarnumero_pre_impresoPrestamo=true;
	public Boolean activarnumero_pre_impresoPrestamo=true;

	public Border resaltarfechaPrestamo=null;
	public Boolean mostrarfechaPrestamo=true;
	public Boolean activarfechaPrestamo=false;

	public Border resaltarmontoPrestamo=null;
	public Boolean mostrarmontoPrestamo=true;
	public Boolean activarmontoPrestamo=true;

	public Border resaltarnumero_cuotasPrestamo=null;
	public Boolean mostrarnumero_cuotasPrestamo=true;
	public Boolean activarnumero_cuotasPrestamo=true;

	public Border resaltartasaPrestamo=null;
	public Boolean mostrartasaPrestamo=true;
	public Boolean activartasaPrestamo=true;

	public Border resaltardescripcionPrestamo=null;
	public Boolean mostrardescripcionPrestamo=true;
	public Boolean activardescripcionPrestamo=true;

	
	

	public Border setResaltaridPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltaridPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPrestamo() {
		return this.resaltaridPrestamo;
	}

	public void setResaltaridPrestamo(Border borderResaltar) {
		this.resaltaridPrestamo= borderResaltar;
	}

	public Boolean getMostraridPrestamo() {
		return this.mostraridPrestamo;
	}

	public void setMostraridPrestamo(Boolean mostraridPrestamo) {
		this.mostraridPrestamo= mostraridPrestamo;
	}

	public Boolean getActivaridPrestamo() {
		return this.activaridPrestamo;
	}

	public void setActivaridPrestamo(Boolean activaridPrestamo) {
		this.activaridPrestamo= activaridPrestamo;
	}

	public Border setResaltarid_empresaPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltarid_empresaPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPrestamo() {
		return this.resaltarid_empresaPrestamo;
	}

	public void setResaltarid_empresaPrestamo(Border borderResaltar) {
		this.resaltarid_empresaPrestamo= borderResaltar;
	}

	public Boolean getMostrarid_empresaPrestamo() {
		return this.mostrarid_empresaPrestamo;
	}

	public void setMostrarid_empresaPrestamo(Boolean mostrarid_empresaPrestamo) {
		this.mostrarid_empresaPrestamo= mostrarid_empresaPrestamo;
	}

	public Boolean getActivarid_empresaPrestamo() {
		return this.activarid_empresaPrestamo;
	}

	public void setActivarid_empresaPrestamo(Boolean activarid_empresaPrestamo) {
		this.activarid_empresaPrestamo= activarid_empresaPrestamo;
	}

	public Boolean getCargarid_empresaPrestamo() {
		return this.cargarid_empresaPrestamo;
	}

	public void setCargarid_empresaPrestamo(Boolean cargarid_empresaPrestamo) {
		this.cargarid_empresaPrestamo= cargarid_empresaPrestamo;
	}

	public Border setResaltarid_empleadoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltarid_empleadoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoPrestamo() {
		return this.resaltarid_empleadoPrestamo;
	}

	public void setResaltarid_empleadoPrestamo(Border borderResaltar) {
		this.resaltarid_empleadoPrestamo= borderResaltar;
	}

	public Boolean getMostrarid_empleadoPrestamo() {
		return this.mostrarid_empleadoPrestamo;
	}

	public void setMostrarid_empleadoPrestamo(Boolean mostrarid_empleadoPrestamo) {
		this.mostrarid_empleadoPrestamo= mostrarid_empleadoPrestamo;
	}

	public Boolean getActivarid_empleadoPrestamo() {
		return this.activarid_empleadoPrestamo;
	}

	public void setActivarid_empleadoPrestamo(Boolean activarid_empleadoPrestamo) {
		this.activarid_empleadoPrestamo= activarid_empleadoPrestamo;
	}

	public Boolean getCargarid_empleadoPrestamo() {
		return this.cargarid_empleadoPrestamo;
	}

	public void setCargarid_empleadoPrestamo(Boolean cargarid_empleadoPrestamo) {
		this.cargarid_empleadoPrestamo= cargarid_empleadoPrestamo;
	}

	public Border setResaltarid_tipo_prestamoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltarid_tipo_prestamoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_prestamoPrestamo() {
		return this.resaltarid_tipo_prestamoPrestamo;
	}

	public void setResaltarid_tipo_prestamoPrestamo(Border borderResaltar) {
		this.resaltarid_tipo_prestamoPrestamo= borderResaltar;
	}

	public Boolean getMostrarid_tipo_prestamoPrestamo() {
		return this.mostrarid_tipo_prestamoPrestamo;
	}

	public void setMostrarid_tipo_prestamoPrestamo(Boolean mostrarid_tipo_prestamoPrestamo) {
		this.mostrarid_tipo_prestamoPrestamo= mostrarid_tipo_prestamoPrestamo;
	}

	public Boolean getActivarid_tipo_prestamoPrestamo() {
		return this.activarid_tipo_prestamoPrestamo;
	}

	public void setActivarid_tipo_prestamoPrestamo(Boolean activarid_tipo_prestamoPrestamo) {
		this.activarid_tipo_prestamoPrestamo= activarid_tipo_prestamoPrestamo;
	}

	public Boolean getCargarid_tipo_prestamoPrestamo() {
		return this.cargarid_tipo_prestamoPrestamo;
	}

	public void setCargarid_tipo_prestamoPrestamo(Boolean cargarid_tipo_prestamoPrestamo) {
		this.cargarid_tipo_prestamoPrestamo= cargarid_tipo_prestamoPrestamo;
	}

	public Border setResaltarid_tipo_cuotaPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cuotaPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cuotaPrestamo() {
		return this.resaltarid_tipo_cuotaPrestamo;
	}

	public void setResaltarid_tipo_cuotaPrestamo(Border borderResaltar) {
		this.resaltarid_tipo_cuotaPrestamo= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cuotaPrestamo() {
		return this.mostrarid_tipo_cuotaPrestamo;
	}

	public void setMostrarid_tipo_cuotaPrestamo(Boolean mostrarid_tipo_cuotaPrestamo) {
		this.mostrarid_tipo_cuotaPrestamo= mostrarid_tipo_cuotaPrestamo;
	}

	public Boolean getActivarid_tipo_cuotaPrestamo() {
		return this.activarid_tipo_cuotaPrestamo;
	}

	public void setActivarid_tipo_cuotaPrestamo(Boolean activarid_tipo_cuotaPrestamo) {
		this.activarid_tipo_cuotaPrestamo= activarid_tipo_cuotaPrestamo;
	}

	public Boolean getCargarid_tipo_cuotaPrestamo() {
		return this.cargarid_tipo_cuotaPrestamo;
	}

	public void setCargarid_tipo_cuotaPrestamo(Boolean cargarid_tipo_cuotaPrestamo) {
		this.cargarid_tipo_cuotaPrestamo= cargarid_tipo_cuotaPrestamo;
	}

	public Border setResaltarid_asiento_contablePrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contablePrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contablePrestamo() {
		return this.resaltarid_asiento_contablePrestamo;
	}

	public void setResaltarid_asiento_contablePrestamo(Border borderResaltar) {
		this.resaltarid_asiento_contablePrestamo= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contablePrestamo() {
		return this.mostrarid_asiento_contablePrestamo;
	}

	public void setMostrarid_asiento_contablePrestamo(Boolean mostrarid_asiento_contablePrestamo) {
		this.mostrarid_asiento_contablePrestamo= mostrarid_asiento_contablePrestamo;
	}

	public Boolean getActivarid_asiento_contablePrestamo() {
		return this.activarid_asiento_contablePrestamo;
	}

	public void setActivarid_asiento_contablePrestamo(Boolean activarid_asiento_contablePrestamo) {
		this.activarid_asiento_contablePrestamo= activarid_asiento_contablePrestamo;
	}

	public Boolean getCargarid_asiento_contablePrestamo() {
		return this.cargarid_asiento_contablePrestamo;
	}

	public void setCargarid_asiento_contablePrestamo(Boolean cargarid_asiento_contablePrestamo) {
		this.cargarid_asiento_contablePrestamo= cargarid_asiento_contablePrestamo;
	}

	public Border setResaltarcodigoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltarcodigoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPrestamo() {
		return this.resaltarcodigoPrestamo;
	}

	public void setResaltarcodigoPrestamo(Border borderResaltar) {
		this.resaltarcodigoPrestamo= borderResaltar;
	}

	public Boolean getMostrarcodigoPrestamo() {
		return this.mostrarcodigoPrestamo;
	}

	public void setMostrarcodigoPrestamo(Boolean mostrarcodigoPrestamo) {
		this.mostrarcodigoPrestamo= mostrarcodigoPrestamo;
	}

	public Boolean getActivarcodigoPrestamo() {
		return this.activarcodigoPrestamo;
	}

	public void setActivarcodigoPrestamo(Boolean activarcodigoPrestamo) {
		this.activarcodigoPrestamo= activarcodigoPrestamo;
	}

	public Border setResaltarnumero_pre_impresoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoPrestamo() {
		return this.resaltarnumero_pre_impresoPrestamo;
	}

	public void setResaltarnumero_pre_impresoPrestamo(Border borderResaltar) {
		this.resaltarnumero_pre_impresoPrestamo= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoPrestamo() {
		return this.mostrarnumero_pre_impresoPrestamo;
	}

	public void setMostrarnumero_pre_impresoPrestamo(Boolean mostrarnumero_pre_impresoPrestamo) {
		this.mostrarnumero_pre_impresoPrestamo= mostrarnumero_pre_impresoPrestamo;
	}

	public Boolean getActivarnumero_pre_impresoPrestamo() {
		return this.activarnumero_pre_impresoPrestamo;
	}

	public void setActivarnumero_pre_impresoPrestamo(Boolean activarnumero_pre_impresoPrestamo) {
		this.activarnumero_pre_impresoPrestamo= activarnumero_pre_impresoPrestamo;
	}

	public Border setResaltarfechaPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltarfechaPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPrestamo() {
		return this.resaltarfechaPrestamo;
	}

	public void setResaltarfechaPrestamo(Border borderResaltar) {
		this.resaltarfechaPrestamo= borderResaltar;
	}

	public Boolean getMostrarfechaPrestamo() {
		return this.mostrarfechaPrestamo;
	}

	public void setMostrarfechaPrestamo(Boolean mostrarfechaPrestamo) {
		this.mostrarfechaPrestamo= mostrarfechaPrestamo;
	}

	public Boolean getActivarfechaPrestamo() {
		return this.activarfechaPrestamo;
	}

	public void setActivarfechaPrestamo(Boolean activarfechaPrestamo) {
		this.activarfechaPrestamo= activarfechaPrestamo;
	}

	public Border setResaltarmontoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltarmontoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoPrestamo() {
		return this.resaltarmontoPrestamo;
	}

	public void setResaltarmontoPrestamo(Border borderResaltar) {
		this.resaltarmontoPrestamo= borderResaltar;
	}

	public Boolean getMostrarmontoPrestamo() {
		return this.mostrarmontoPrestamo;
	}

	public void setMostrarmontoPrestamo(Boolean mostrarmontoPrestamo) {
		this.mostrarmontoPrestamo= mostrarmontoPrestamo;
	}

	public Boolean getActivarmontoPrestamo() {
		return this.activarmontoPrestamo;
	}

	public void setActivarmontoPrestamo(Boolean activarmontoPrestamo) {
		this.activarmontoPrestamo= activarmontoPrestamo;
	}

	public Border setResaltarnumero_cuotasPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltarnumero_cuotasPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuotasPrestamo() {
		return this.resaltarnumero_cuotasPrestamo;
	}

	public void setResaltarnumero_cuotasPrestamo(Border borderResaltar) {
		this.resaltarnumero_cuotasPrestamo= borderResaltar;
	}

	public Boolean getMostrarnumero_cuotasPrestamo() {
		return this.mostrarnumero_cuotasPrestamo;
	}

	public void setMostrarnumero_cuotasPrestamo(Boolean mostrarnumero_cuotasPrestamo) {
		this.mostrarnumero_cuotasPrestamo= mostrarnumero_cuotasPrestamo;
	}

	public Boolean getActivarnumero_cuotasPrestamo() {
		return this.activarnumero_cuotasPrestamo;
	}

	public void setActivarnumero_cuotasPrestamo(Boolean activarnumero_cuotasPrestamo) {
		this.activarnumero_cuotasPrestamo= activarnumero_cuotasPrestamo;
	}

	public Border setResaltartasaPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltartasaPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartasaPrestamo() {
		return this.resaltartasaPrestamo;
	}

	public void setResaltartasaPrestamo(Border borderResaltar) {
		this.resaltartasaPrestamo= borderResaltar;
	}

	public Boolean getMostrartasaPrestamo() {
		return this.mostrartasaPrestamo;
	}

	public void setMostrartasaPrestamo(Boolean mostrartasaPrestamo) {
		this.mostrartasaPrestamo= mostrartasaPrestamo;
	}

	public Boolean getActivartasaPrestamo() {
		return this.activartasaPrestamo;
	}

	public void setActivartasaPrestamo(Boolean activartasaPrestamo) {
		this.activartasaPrestamo= activartasaPrestamo;
	}

	public Border setResaltardescripcionPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltar);
		
		this.resaltardescripcionPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPrestamo() {
		return this.resaltardescripcionPrestamo;
	}

	public void setResaltardescripcionPrestamo(Border borderResaltar) {
		this.resaltardescripcionPrestamo= borderResaltar;
	}

	public Boolean getMostrardescripcionPrestamo() {
		return this.mostrardescripcionPrestamo;
	}

	public void setMostrardescripcionPrestamo(Boolean mostrardescripcionPrestamo) {
		this.mostrardescripcionPrestamo= mostrardescripcionPrestamo;
	}

	public Boolean getActivardescripcionPrestamo() {
		return this.activardescripcionPrestamo;
	}

	public void setActivardescripcionPrestamo(Boolean activardescripcionPrestamo) {
		this.activardescripcionPrestamo= activardescripcionPrestamo;
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
		
		
		this.setMostraridPrestamo(esInicial);
		this.setMostrarid_empresaPrestamo(esInicial);
		this.setMostrarid_empleadoPrestamo(esInicial);
		this.setMostrarid_tipo_prestamoPrestamo(esInicial);
		this.setMostrarid_tipo_cuotaPrestamo(esInicial);
		this.setMostrarid_asiento_contablePrestamo(esInicial);
		this.setMostrarcodigoPrestamo(esInicial);
		this.setMostrarnumero_pre_impresoPrestamo(esInicial);
		this.setMostrarfechaPrestamo(esInicial);
		this.setMostrarmontoPrestamo(esInicial);
		this.setMostrarnumero_cuotasPrestamo(esInicial);
		this.setMostrartasaPrestamo(esInicial);
		this.setMostrardescripcionPrestamo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PrestamoConstantesFunciones.ID)) {
				this.setMostraridPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDTIPOPRESTAMO)) {
				this.setMostrarid_tipo_prestamoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDTIPOCUOTA)) {
				this.setMostrarid_tipo_cuotaPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contablePrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.FECHA)) {
				this.setMostrarfechaPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.MONTO)) {
				this.setMostrarmontoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.NUMEROCUOTAS)) {
				this.setMostrarnumero_cuotasPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.TASA)) {
				this.setMostrartasaPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPrestamo(esAsigna);
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
		
		
		this.setActivaridPrestamo(esInicial);
		this.setActivarid_empresaPrestamo(esInicial);
		this.setActivarid_empleadoPrestamo(esInicial);
		this.setActivarid_tipo_prestamoPrestamo(esInicial);
		this.setActivarid_tipo_cuotaPrestamo(esInicial);
		this.setActivarid_asiento_contablePrestamo(esInicial);
		this.setActivarcodigoPrestamo(esInicial);
		this.setActivarnumero_pre_impresoPrestamo(esInicial);
		this.setActivarfechaPrestamo(esInicial);
		this.setActivarmontoPrestamo(esInicial);
		this.setActivarnumero_cuotasPrestamo(esInicial);
		this.setActivartasaPrestamo(esInicial);
		this.setActivardescripcionPrestamo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PrestamoConstantesFunciones.ID)) {
				this.setActivaridPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDTIPOPRESTAMO)) {
				this.setActivarid_tipo_prestamoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDTIPOCUOTA)) {
				this.setActivarid_tipo_cuotaPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contablePrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.FECHA)) {
				this.setActivarfechaPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.MONTO)) {
				this.setActivarmontoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.NUMEROCUOTAS)) {
				this.setActivarnumero_cuotasPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.TASA)) {
				this.setActivartasaPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPrestamo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPrestamo(esInicial);
		this.setResaltarid_empresaPrestamo(esInicial);
		this.setResaltarid_empleadoPrestamo(esInicial);
		this.setResaltarid_tipo_prestamoPrestamo(esInicial);
		this.setResaltarid_tipo_cuotaPrestamo(esInicial);
		this.setResaltarid_asiento_contablePrestamo(esInicial);
		this.setResaltarcodigoPrestamo(esInicial);
		this.setResaltarnumero_pre_impresoPrestamo(esInicial);
		this.setResaltarfechaPrestamo(esInicial);
		this.setResaltarmontoPrestamo(esInicial);
		this.setResaltarnumero_cuotasPrestamo(esInicial);
		this.setResaltartasaPrestamo(esInicial);
		this.setResaltardescripcionPrestamo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PrestamoConstantesFunciones.ID)) {
				this.setResaltaridPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDTIPOPRESTAMO)) {
				this.setResaltarid_tipo_prestamoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDTIPOCUOTA)) {
				this.setResaltarid_tipo_cuotaPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contablePrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.FECHA)) {
				this.setResaltarfechaPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.MONTO)) {
				this.setResaltarmontoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.NUMEROCUOTAS)) {
				this.setResaltarnumero_cuotasPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.TASA)) {
				this.setResaltartasaPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(PrestamoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPrestamo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarAbonoPrestamoPrestamo=null;

	public Border getResaltarAbonoPrestamoPrestamo() {
		return this.resaltarAbonoPrestamoPrestamo;
	}

	public void setResaltarAbonoPrestamoPrestamo(Border borderResaltarAbonoPrestamo) {
		if(borderResaltarAbonoPrestamo!=null) {
			this.resaltarAbonoPrestamoPrestamo= borderResaltarAbonoPrestamo;
		}
	}

	public Border setResaltarAbonoPrestamoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltarAbonoPrestamo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltarAbonoPrestamo);
			
		this.resaltarAbonoPrestamoPrestamo= borderResaltarAbonoPrestamo;

		 return borderResaltarAbonoPrestamo;
	}



	public Boolean mostrarAbonoPrestamoPrestamo=true;

	public Boolean getMostrarAbonoPrestamoPrestamo() {
		return this.mostrarAbonoPrestamoPrestamo;
	}

	public void setMostrarAbonoPrestamoPrestamo(Boolean visibilidadResaltarAbonoPrestamo) {
		this.mostrarAbonoPrestamoPrestamo= visibilidadResaltarAbonoPrestamo;
	}



	public Boolean activarAbonoPrestamoPrestamo=true;

	public Boolean gethabilitarResaltarAbonoPrestamoPrestamo() {
		return this.activarAbonoPrestamoPrestamo;
	}

	public void setActivarAbonoPrestamoPrestamo(Boolean habilitarResaltarAbonoPrestamo) {
		this.activarAbonoPrestamoPrestamo= habilitarResaltarAbonoPrestamo;
	}


	public Border resaltarCuotaPrestamo=null;

	public Border getResaltarCuotaPrestamo() {
		return this.resaltarCuotaPrestamo;
	}

	public void setResaltarCuotaPrestamo(Border borderResaltarCuota) {
		if(borderResaltarCuota!=null) {
			this.resaltarCuotaPrestamo= borderResaltarCuota;
		}
	}

	public Border setResaltarCuotaPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltarCuota=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//prestamoBeanSwingJInternalFrame.jTtoolBarPrestamo.setBorder(borderResaltarCuota);
			
		this.resaltarCuotaPrestamo= borderResaltarCuota;

		 return borderResaltarCuota;
	}



	public Boolean mostrarCuotaPrestamo=true;

	public Boolean getMostrarCuotaPrestamo() {
		return this.mostrarCuotaPrestamo;
	}

	public void setMostrarCuotaPrestamo(Boolean visibilidadResaltarCuota) {
		this.mostrarCuotaPrestamo= visibilidadResaltarCuota;
	}



	public Boolean activarCuotaPrestamo=true;

	public Boolean gethabilitarResaltarCuotaPrestamo() {
		return this.activarCuotaPrestamo;
	}

	public void setActivarCuotaPrestamo(Boolean habilitarResaltarCuota) {
		this.activarCuotaPrestamo= habilitarResaltarCuota;
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

		this.setMostrarAbonoPrestamoPrestamo(esInicial);
		this.setMostrarCuotaPrestamo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AbonoPrestamo.class)) {
				this.setMostrarAbonoPrestamoPrestamo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cuota.class)) {
				this.setMostrarCuotaPrestamo(esAsigna);
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

		this.setActivarAbonoPrestamoPrestamo(esInicial);
		this.setActivarCuotaPrestamo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AbonoPrestamo.class)) {
				this.setActivarAbonoPrestamoPrestamo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cuota.class)) {
				this.setActivarCuotaPrestamo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarAbonoPrestamoPrestamo(esInicial);
		this.setResaltarCuotaPrestamo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(AbonoPrestamo.class)) {
				this.setResaltarAbonoPrestamoPrestamo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cuota.class)) {
				this.setResaltarCuotaPrestamo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdAsientoContablePrestamo=true;

	public Boolean getMostrarFK_IdAsientoContablePrestamo() {
		return this.mostrarFK_IdAsientoContablePrestamo;
	}

	public void setMostrarFK_IdAsientoContablePrestamo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContablePrestamo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoPrestamo=true;

	public Boolean getMostrarFK_IdEmpleadoPrestamo() {
		return this.mostrarFK_IdEmpleadoPrestamo;
	}

	public void setMostrarFK_IdEmpleadoPrestamo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoPrestamo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPrestamo=true;

	public Boolean getMostrarFK_IdEmpresaPrestamo() {
		return this.mostrarFK_IdEmpresaPrestamo;
	}

	public void setMostrarFK_IdEmpresaPrestamo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPrestamo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCuotaPrestamo=true;

	public Boolean getMostrarFK_IdTipoCuotaPrestamo() {
		return this.mostrarFK_IdTipoCuotaPrestamo;
	}

	public void setMostrarFK_IdTipoCuotaPrestamo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCuotaPrestamo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrestamoPrestamo=true;

	public Boolean getMostrarFK_IdTipoPrestamoPrestamo() {
		return this.mostrarFK_IdTipoPrestamoPrestamo;
	}

	public void setMostrarFK_IdTipoPrestamoPrestamo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrestamoPrestamo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContablePrestamo=true;

	public Boolean getActivarFK_IdAsientoContablePrestamo() {
		return this.activarFK_IdAsientoContablePrestamo;
	}

	public void setActivarFK_IdAsientoContablePrestamo(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContablePrestamo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoPrestamo=true;

	public Boolean getActivarFK_IdEmpleadoPrestamo() {
		return this.activarFK_IdEmpleadoPrestamo;
	}

	public void setActivarFK_IdEmpleadoPrestamo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoPrestamo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPrestamo=true;

	public Boolean getActivarFK_IdEmpresaPrestamo() {
		return this.activarFK_IdEmpresaPrestamo;
	}

	public void setActivarFK_IdEmpresaPrestamo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPrestamo= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCuotaPrestamo=true;

	public Boolean getActivarFK_IdTipoCuotaPrestamo() {
		return this.activarFK_IdTipoCuotaPrestamo;
	}

	public void setActivarFK_IdTipoCuotaPrestamo(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCuotaPrestamo= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrestamoPrestamo=true;

	public Boolean getActivarFK_IdTipoPrestamoPrestamo() {
		return this.activarFK_IdTipoPrestamoPrestamo;
	}

	public void setActivarFK_IdTipoPrestamoPrestamo(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrestamoPrestamo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContablePrestamo=null;

	public Border getResaltarFK_IdAsientoContablePrestamo() {
		return this.resaltarFK_IdAsientoContablePrestamo;
	}

	public void setResaltarFK_IdAsientoContablePrestamo(Border borderResaltar) {
		this.resaltarFK_IdAsientoContablePrestamo= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContablePrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContablePrestamo= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoPrestamo=null;

	public Border getResaltarFK_IdEmpleadoPrestamo() {
		return this.resaltarFK_IdEmpleadoPrestamo;
	}

	public void setResaltarFK_IdEmpleadoPrestamo(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoPrestamo= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoPrestamo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPrestamo=null;

	public Border getResaltarFK_IdEmpresaPrestamo() {
		return this.resaltarFK_IdEmpresaPrestamo;
	}

	public void setResaltarFK_IdEmpresaPrestamo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPrestamo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPrestamo= borderResaltar;
	}

	public Border resaltarFK_IdTipoCuotaPrestamo=null;

	public Border getResaltarFK_IdTipoCuotaPrestamo() {
		return this.resaltarFK_IdTipoCuotaPrestamo;
	}

	public void setResaltarFK_IdTipoCuotaPrestamo(Border borderResaltar) {
		this.resaltarFK_IdTipoCuotaPrestamo= borderResaltar;
	}

	public void setResaltarFK_IdTipoCuotaPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCuotaPrestamo= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrestamoPrestamo=null;

	public Border getResaltarFK_IdTipoPrestamoPrestamo() {
		return this.resaltarFK_IdTipoPrestamoPrestamo;
	}

	public void setResaltarFK_IdTipoPrestamoPrestamo(Border borderResaltar) {
		this.resaltarFK_IdTipoPrestamoPrestamo= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrestamoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*PrestamoBeanSwingJInternalFrame prestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrestamoPrestamo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}