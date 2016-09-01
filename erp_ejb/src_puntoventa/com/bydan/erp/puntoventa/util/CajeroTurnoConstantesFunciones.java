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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.CajeroTurnoConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajeroTurnoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajeroTurnoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CajeroTurnoConstantesFunciones extends CajeroTurnoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CajeroTurno";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CajeroTurno"+CajeroTurnoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CajeroTurnoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CajeroTurnoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CajeroTurnoConstantesFunciones.SCHEMA+"_"+CajeroTurnoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CajeroTurnoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CajeroTurnoConstantesFunciones.SCHEMA+"_"+CajeroTurnoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CajeroTurnoConstantesFunciones.SCHEMA+"_"+CajeroTurnoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CajeroTurnoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CajeroTurnoConstantesFunciones.SCHEMA+"_"+CajeroTurnoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajeroTurnoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajeroTurnoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajeroTurnoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajeroTurnoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajeroTurnoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajeroTurnoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CajeroTurnoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CajeroTurnoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CajeroTurnoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CajeroTurnoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cajero Turnos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cajero Turno";
	public static final String SCLASSWEBTITULO_LOWER="Cajero Turno";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CajeroTurno";
	public static final String OBJECTNAME="cajeroturno";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="cajero_turno";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cajeroturno from "+CajeroTurnoConstantesFunciones.SPERSISTENCENAME+" cajeroturno";
	public static String QUERYSELECTNATIVE="select "+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".version_row,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_empresa,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_sucursal,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_usuario,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_vendedor,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_caja,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_mesa,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_turno_pun_ven,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".hora_inicio,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".hora_fin,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".hora_servicio from "+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME;//+" as "+CajeroTurnoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CajeroTurnoConstantesFuncionesAdditional cajeroturnoConstantesFuncionesAdditional=null;
	
	public CajeroTurnoConstantesFuncionesAdditional getCajeroTurnoConstantesFuncionesAdditional() {
		return this.cajeroturnoConstantesFuncionesAdditional;
	}
	
	public void setCajeroTurnoConstantesFuncionesAdditional(CajeroTurnoConstantesFuncionesAdditional cajeroturnoConstantesFuncionesAdditional) {
		try {
			this.cajeroturnoConstantesFuncionesAdditional=cajeroturnoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDCAJA= "id_caja";
    public static final String IDMESA= "id_mesa";
    public static final String IDTURNOPUNVEN= "id_turno_pun_ven";
    public static final String HORAINICIO= "hora_inicio";
    public static final String HORAFIN= "hora_fin";
    public static final String HORASERVICIO= "hora_servicio";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_IDMESA= "Mesa";
		public static final String LABEL_IDMESA_LOWER= "Mesa";
    	public static final String LABEL_IDTURNOPUNVEN= "Turno";
		public static final String LABEL_IDTURNOPUNVEN_LOWER= "Turno Pun Ven";
    	public static final String LABEL_HORAINICIO= "Hora Inicio";
		public static final String LABEL_HORAINICIO_LOWER= "Hora Inicio";
    	public static final String LABEL_HORAFIN= "Hora Fin";
		public static final String LABEL_HORAFIN_LOWER= "Hora Fin";
    	public static final String LABEL_HORASERVICIO= "Hora Servicio";
		public static final String LABEL_HORASERVICIO_LOWER= "Hora Servicio";
	
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getCajeroTurnoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CajeroTurnoConstantesFunciones.IDEMPRESA)) {sLabelColumna=CajeroTurnoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CajeroTurnoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CajeroTurnoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CajeroTurnoConstantesFunciones.IDUSUARIO)) {sLabelColumna=CajeroTurnoConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(CajeroTurnoConstantesFunciones.IDVENDEDOR)) {sLabelColumna=CajeroTurnoConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(CajeroTurnoConstantesFunciones.IDCAJA)) {sLabelColumna=CajeroTurnoConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(CajeroTurnoConstantesFunciones.IDMESA)) {sLabelColumna=CajeroTurnoConstantesFunciones.LABEL_IDMESA;}
		if(sNombreColumna.equals(CajeroTurnoConstantesFunciones.IDTURNOPUNVEN)) {sLabelColumna=CajeroTurnoConstantesFunciones.LABEL_IDTURNOPUNVEN;}
		if(sNombreColumna.equals(CajeroTurnoConstantesFunciones.HORAINICIO)) {sLabelColumna=CajeroTurnoConstantesFunciones.LABEL_HORAINICIO;}
		if(sNombreColumna.equals(CajeroTurnoConstantesFunciones.HORAFIN)) {sLabelColumna=CajeroTurnoConstantesFunciones.LABEL_HORAFIN;}
		if(sNombreColumna.equals(CajeroTurnoConstantesFunciones.HORASERVICIO)) {sLabelColumna=CajeroTurnoConstantesFunciones.LABEL_HORASERVICIO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCajeroTurnoDescripcion(CajeroTurno cajeroturno) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cajeroturno !=null/* && cajeroturno.getId()!=0*/) {
			if(cajeroturno.getId()!=null) {
				sDescripcion=cajeroturno.getId().toString();
			}//cajeroturnocajeroturno.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCajeroTurnoDescripcionDetallado(CajeroTurno cajeroturno) {
		String sDescripcion="";
			
		sDescripcion+=CajeroTurnoConstantesFunciones.ID+"=";
		sDescripcion+=cajeroturno.getId().toString()+",";
		sDescripcion+=CajeroTurnoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cajeroturno.getVersionRow().toString()+",";
		sDescripcion+=CajeroTurnoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cajeroturno.getid_empresa().toString()+",";
		sDescripcion+=CajeroTurnoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cajeroturno.getid_sucursal().toString()+",";
		sDescripcion+=CajeroTurnoConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=cajeroturno.getid_usuario().toString()+",";
		sDescripcion+=CajeroTurnoConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=cajeroturno.getid_vendedor().toString()+",";
		sDescripcion+=CajeroTurnoConstantesFunciones.IDCAJA+"=";
		sDescripcion+=cajeroturno.getid_caja().toString()+",";
		sDescripcion+=CajeroTurnoConstantesFunciones.IDMESA+"=";
		sDescripcion+=cajeroturno.getid_mesa().toString()+",";
		sDescripcion+=CajeroTurnoConstantesFunciones.IDTURNOPUNVEN+"=";
		sDescripcion+=cajeroturno.getid_turno_pun_ven().toString()+",";
		sDescripcion+=CajeroTurnoConstantesFunciones.HORAINICIO+"=";
		sDescripcion+=cajeroturno.gethora_inicio().toString()+",";
		sDescripcion+=CajeroTurnoConstantesFunciones.HORAFIN+"=";
		sDescripcion+=cajeroturno.gethora_fin().toString()+",";
		sDescripcion+=CajeroTurnoConstantesFunciones.HORASERVICIO+"=";
		sDescripcion+=cajeroturno.gethora_servicio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCajeroTurnoDescripcion(CajeroTurno cajeroturno,String sValor) throws Exception {			
		if(cajeroturno !=null) {
			//cajeroturnocajeroturno.getId().toString();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
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

	public static String getCajaDescripcion(Caja caja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(caja!=null/*&&caja.getId()>0*/) {
			sDescripcion=CajaConstantesFunciones.getCajaDescripcion(caja);
		}

		return sDescripcion;
	}

	public static String getMesaDescripcion(Mesa mesa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mesa!=null/*&&mesa.getId()>0*/) {
			sDescripcion=MesaConstantesFunciones.getMesaDescripcion(mesa);
		}

		return sDescripcion;
	}

	public static String getTurnoPunVenDescripcion(TurnoPunVen turnopunven) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(turnopunven!=null/*&&turnopunven.getId()>0*/) {
			sDescripcion=TurnoPunVenConstantesFunciones.getTurnoPunVenDescripcion(turnopunven);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMesa")) {
			sNombreIndice="Tipo=  Por Mesa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTurnoPunVen")) {
			sNombreIndice="Tipo=  Por Turno";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMesa(Long id_mesa) {
		String sDetalleIndice=" Parametros->";
		if(id_mesa!=null) {sDetalleIndice+=" Codigo Unico De Mesa="+id_mesa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTurnoPunVen(Long id_turno_pun_ven) {
		String sDetalleIndice=" Parametros->";
		if(id_turno_pun_ven!=null) {sDetalleIndice+=" Codigo Unico De Turno="+id_turno_pun_ven.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCajeroTurno(CajeroTurno cajeroturno,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosCajeroTurnos(List<CajeroTurno> cajeroturnos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CajeroTurno cajeroturno: cajeroturnos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajeroTurno(CajeroTurno cajeroturno,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cajeroturno.getConCambioAuxiliar()) {
			cajeroturno.setIsDeleted(cajeroturno.getIsDeletedAuxiliar());	
			cajeroturno.setIsNew(cajeroturno.getIsNewAuxiliar());	
			cajeroturno.setIsChanged(cajeroturno.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cajeroturno.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cajeroturno.setIsDeletedAuxiliar(false);	
			cajeroturno.setIsNewAuxiliar(false);	
			cajeroturno.setIsChangedAuxiliar(false);
			
			cajeroturno.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajeroTurnos(List<CajeroTurno> cajeroturnos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CajeroTurno cajeroturno : cajeroturnos) {
			if(conAsignarBase && cajeroturno.getConCambioAuxiliar()) {
				cajeroturno.setIsDeleted(cajeroturno.getIsDeletedAuxiliar());	
				cajeroturno.setIsNew(cajeroturno.getIsNewAuxiliar());	
				cajeroturno.setIsChanged(cajeroturno.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cajeroturno.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cajeroturno.setIsDeletedAuxiliar(false);	
				cajeroturno.setIsNewAuxiliar(false);	
				cajeroturno.setIsChangedAuxiliar(false);
				
				cajeroturno.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCajeroTurno(CajeroTurno cajeroturno,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCajeroTurnos(List<CajeroTurno> cajeroturnos,Boolean conEnteros) throws Exception  {
		
		for(CajeroTurno cajeroturno: cajeroturnos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCajeroTurno(List<CajeroTurno> cajeroturnos,CajeroTurno cajeroturnoAux) throws Exception  {
		CajeroTurnoConstantesFunciones.InicializarValoresCajeroTurno(cajeroturnoAux,true);
		
		for(CajeroTurno cajeroturno: cajeroturnos) {
			if(cajeroturno.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajeroTurno(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CajeroTurnoConstantesFunciones.getArrayColumnasGlobalesCajeroTurno(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCajeroTurno(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajeroTurnoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajeroTurnoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajeroTurnoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajeroTurnoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajeroTurnoConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajeroTurnoConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCajeroTurno(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CajeroTurno> cajeroturnos,CajeroTurno cajeroturno,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CajeroTurno cajeroturnoAux: cajeroturnos) {
			if(cajeroturnoAux!=null && cajeroturno!=null) {
				if((cajeroturnoAux.getId()==null && cajeroturno.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cajeroturnoAux.getId()!=null && cajeroturno.getId()!=null){
					if(cajeroturnoAux.getId().equals(cajeroturno.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajeroTurno(List<CajeroTurno> cajeroturnos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CajeroTurno cajeroturno: cajeroturnos) {			
			if(cajeroturno.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCajeroTurno() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CajeroTurnoConstantesFunciones.LABEL_ID, CajeroTurnoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajeroTurnoConstantesFunciones.LABEL_VERSIONROW, CajeroTurnoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajeroTurnoConstantesFunciones.LABEL_IDEMPRESA, CajeroTurnoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajeroTurnoConstantesFunciones.LABEL_IDSUCURSAL, CajeroTurnoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajeroTurnoConstantesFunciones.LABEL_IDUSUARIO, CajeroTurnoConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajeroTurnoConstantesFunciones.LABEL_IDVENDEDOR, CajeroTurnoConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajeroTurnoConstantesFunciones.LABEL_IDCAJA, CajeroTurnoConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajeroTurnoConstantesFunciones.LABEL_IDMESA, CajeroTurnoConstantesFunciones.IDMESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajeroTurnoConstantesFunciones.LABEL_IDTURNOPUNVEN, CajeroTurnoConstantesFunciones.IDTURNOPUNVEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajeroTurnoConstantesFunciones.LABEL_HORAINICIO, CajeroTurnoConstantesFunciones.HORAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajeroTurnoConstantesFunciones.LABEL_HORAFIN, CajeroTurnoConstantesFunciones.HORAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajeroTurnoConstantesFunciones.LABEL_HORASERVICIO, CajeroTurnoConstantesFunciones.HORASERVICIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCajeroTurno() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CajeroTurnoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajeroTurnoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajeroTurnoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajeroTurnoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajeroTurnoConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajeroTurnoConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajeroTurnoConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajeroTurnoConstantesFunciones.IDMESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajeroTurnoConstantesFunciones.IDTURNOPUNVEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajeroTurnoConstantesFunciones.HORAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajeroTurnoConstantesFunciones.HORAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajeroTurnoConstantesFunciones.HORASERVICIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajeroTurno() throws Exception  {
		return CajeroTurnoConstantesFunciones.getTiposSeleccionarCajeroTurno(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajeroTurno(Boolean conFk) throws Exception  {
		return CajeroTurnoConstantesFunciones.getTiposSeleccionarCajeroTurno(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajeroTurno(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajeroTurnoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CajeroTurnoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajeroTurnoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CajeroTurnoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajeroTurnoConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(CajeroTurnoConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajeroTurnoConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(CajeroTurnoConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajeroTurnoConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(CajeroTurnoConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajeroTurnoConstantesFunciones.LABEL_IDMESA);
			reporte.setsDescripcion(CajeroTurnoConstantesFunciones.LABEL_IDMESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajeroTurnoConstantesFunciones.LABEL_IDTURNOPUNVEN);
			reporte.setsDescripcion(CajeroTurnoConstantesFunciones.LABEL_IDTURNOPUNVEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(CajeroTurnoConstantesFunciones.LABEL_HORAINICIO);
		reporte.setsDescripcion(CajeroTurnoConstantesFunciones.LABEL_HORAINICIO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(CajeroTurnoConstantesFunciones.LABEL_HORAFIN);
		reporte.setsDescripcion(CajeroTurnoConstantesFunciones.LABEL_HORAFIN);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(CajeroTurnoConstantesFunciones.LABEL_HORASERVICIO);
		reporte.setsDescripcion(CajeroTurnoConstantesFunciones.LABEL_HORASERVICIO);

		arrTiposSeleccionarTodos.add(reporte);
		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCajeroTurno(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCajeroTurno(CajeroTurno cajeroturnoAux) throws Exception {
		
			cajeroturnoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajeroturnoAux.getEmpresa()));
			cajeroturnoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajeroturnoAux.getSucursal()));
			cajeroturnoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(cajeroturnoAux.getUsuario()));
			cajeroturnoAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(cajeroturnoAux.getVendedor()));
			cajeroturnoAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajeroturnoAux.getCaja()));
			cajeroturnoAux.setmesa_descripcion(MesaConstantesFunciones.getMesaDescripcion(cajeroturnoAux.getMesa()));
			cajeroturnoAux.setturnopunven_descripcion(TurnoPunVenConstantesFunciones.getTurnoPunVenDescripcion(cajeroturnoAux.getTurnoPunVen()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCajeroTurno(List<CajeroTurno> cajeroturnosTemp) throws Exception {
		for(CajeroTurno cajeroturnoAux:cajeroturnosTemp) {
			
			cajeroturnoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajeroturnoAux.getEmpresa()));
			cajeroturnoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajeroturnoAux.getSucursal()));
			cajeroturnoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(cajeroturnoAux.getUsuario()));
			cajeroturnoAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(cajeroturnoAux.getVendedor()));
			cajeroturnoAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajeroturnoAux.getCaja()));
			cajeroturnoAux.setmesa_descripcion(MesaConstantesFunciones.getMesaDescripcion(cajeroturnoAux.getMesa()));
			cajeroturnoAux.setturnopunven_descripcion(TurnoPunVenConstantesFunciones.getTurnoPunVenDescripcion(cajeroturnoAux.getTurnoPunVen()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCajeroTurno(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Caja.class));
				classes.add(new Classe(Mesa.class));
				classes.add(new Classe(TurnoPunVen.class));
				
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
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mesa.class)) {
						classes.add(new Classe(Mesa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TurnoPunVen.class)) {
						classes.add(new Classe(TurnoPunVen.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCajeroTurno(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(Mesa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mesa.class)); continue;
					}

					if(TurnoPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TurnoPunVen.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(Mesa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mesa.class)); continue;
					}

					if(TurnoPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TurnoPunVen.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajeroTurno(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajeroTurnoConstantesFunciones.getClassesRelationshipsOfCajeroTurno(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajeroTurno(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajeroTurno(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajeroTurnoConstantesFunciones.getClassesRelationshipsFromStringsOfCajeroTurno(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajeroTurno(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CajeroTurno cajeroturno,List<CajeroTurno> cajeroturnos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CajeroTurno cajeroturnoEncontrado=null;
			
			for(CajeroTurno cajeroturnoLocal:cajeroturnos) {
				if(cajeroturnoLocal.getId().equals(cajeroturno.getId())) {
					cajeroturnoEncontrado=cajeroturnoLocal;
					
					cajeroturnoLocal.setIsChanged(cajeroturno.getIsChanged());
					cajeroturnoLocal.setIsNew(cajeroturno.getIsNew());
					cajeroturnoLocal.setIsDeleted(cajeroturno.getIsDeleted());
					
					cajeroturnoLocal.setGeneralEntityOriginal(cajeroturno.getGeneralEntityOriginal());
					
					cajeroturnoLocal.setId(cajeroturno.getId());	
					cajeroturnoLocal.setVersionRow(cajeroturno.getVersionRow());	
					cajeroturnoLocal.setid_empresa(cajeroturno.getid_empresa());	
					cajeroturnoLocal.setid_sucursal(cajeroturno.getid_sucursal());	
					cajeroturnoLocal.setid_usuario(cajeroturno.getid_usuario());	
					cajeroturnoLocal.setid_vendedor(cajeroturno.getid_vendedor());	
					cajeroturnoLocal.setid_caja(cajeroturno.getid_caja());	
					cajeroturnoLocal.setid_mesa(cajeroturno.getid_mesa());	
					cajeroturnoLocal.setid_turno_pun_ven(cajeroturno.getid_turno_pun_ven());	
					cajeroturnoLocal.sethora_inicio(cajeroturno.gethora_inicio());	
					cajeroturnoLocal.sethora_fin(cajeroturno.gethora_fin());	
					cajeroturnoLocal.sethora_servicio(cajeroturno.gethora_servicio());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cajeroturno.getIsDeleted()) {
				if(!existe) {
					cajeroturnos.add(cajeroturno);
				}
			} else {
				if(cajeroturnoEncontrado!=null && permiteQuitar)  {
					cajeroturnos.remove(cajeroturnoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CajeroTurno cajeroturno,List<CajeroTurno> cajeroturnos) throws Exception {
		try	{			
			for(CajeroTurno cajeroturnoLocal:cajeroturnos) {
				if(cajeroturnoLocal.getId().equals(cajeroturno.getId())) {
					cajeroturnoLocal.setIsSelected(cajeroturno.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCajeroTurno(List<CajeroTurno> cajeroturnosAux) throws Exception {
		//this.cajeroturnosAux=cajeroturnosAux;
		
		for(CajeroTurno cajeroturnoAux:cajeroturnosAux) {
			if(cajeroturnoAux.getIsChanged()) {
				cajeroturnoAux.setIsChanged(false);
			}		
			
			if(cajeroturnoAux.getIsNew()) {
				cajeroturnoAux.setIsNew(false);
			}	
			
			if(cajeroturnoAux.getIsDeleted()) {
				cajeroturnoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCajeroTurno(CajeroTurno cajeroturnoAux) throws Exception {
		//this.cajeroturnoAux=cajeroturnoAux;
		
			if(cajeroturnoAux.getIsChanged()) {
				cajeroturnoAux.setIsChanged(false);
			}		
			
			if(cajeroturnoAux.getIsNew()) {
				cajeroturnoAux.setIsNew(false);
			}	
			
			if(cajeroturnoAux.getIsDeleted()) {
				cajeroturnoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CajeroTurno cajeroturnoAsignar,CajeroTurno cajeroturno) throws Exception {
		cajeroturnoAsignar.setId(cajeroturno.getId());	
		cajeroturnoAsignar.setVersionRow(cajeroturno.getVersionRow());	
		cajeroturnoAsignar.setid_empresa(cajeroturno.getid_empresa());
		cajeroturnoAsignar.setempresa_descripcion(cajeroturno.getempresa_descripcion());	
		cajeroturnoAsignar.setid_sucursal(cajeroturno.getid_sucursal());
		cajeroturnoAsignar.setsucursal_descripcion(cajeroturno.getsucursal_descripcion());	
		cajeroturnoAsignar.setid_usuario(cajeroturno.getid_usuario());
		cajeroturnoAsignar.setusuario_descripcion(cajeroturno.getusuario_descripcion());	
		cajeroturnoAsignar.setid_vendedor(cajeroturno.getid_vendedor());
		cajeroturnoAsignar.setvendedor_descripcion(cajeroturno.getvendedor_descripcion());	
		cajeroturnoAsignar.setid_caja(cajeroturno.getid_caja());
		cajeroturnoAsignar.setcaja_descripcion(cajeroturno.getcaja_descripcion());	
		cajeroturnoAsignar.setid_mesa(cajeroturno.getid_mesa());
		cajeroturnoAsignar.setmesa_descripcion(cajeroturno.getmesa_descripcion());	
		cajeroturnoAsignar.setid_turno_pun_ven(cajeroturno.getid_turno_pun_ven());
		cajeroturnoAsignar.setturnopunven_descripcion(cajeroturno.getturnopunven_descripcion());	
		cajeroturnoAsignar.sethora_inicio(cajeroturno.gethora_inicio());	
		cajeroturnoAsignar.sethora_fin(cajeroturno.gethora_fin());	
		cajeroturnoAsignar.sethora_servicio(cajeroturno.gethora_servicio());	
	}
	
	public static void inicializarCajeroTurno(CajeroTurno cajeroturno) throws Exception {
		try {
				cajeroturno.setId(0L);	
					
				cajeroturno.setid_empresa(-1L);	
				cajeroturno.setid_sucursal(-1L);	
				cajeroturno.setid_usuario(-1L);	
				cajeroturno.setid_vendedor(-1L);	
				cajeroturno.setid_caja(-1L);	
				cajeroturno.setid_mesa(-1L);	
				cajeroturno.setid_turno_pun_ven(-1L);	
				cajeroturno.sethora_inicio(new Time((new Date()).getTime()));	
				cajeroturno.sethora_fin(new Time((new Date()).getTime()));	
				cajeroturno.sethora_servicio(new Time((new Date()).getTime()));	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCajeroTurno(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CajeroTurnoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajeroTurnoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajeroTurnoConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajeroTurnoConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajeroTurnoConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajeroTurnoConstantesFunciones.LABEL_IDMESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajeroTurnoConstantesFunciones.LABEL_IDTURNOPUNVEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajeroTurnoConstantesFunciones.LABEL_HORAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajeroTurnoConstantesFunciones.LABEL_HORAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajeroTurnoConstantesFunciones.LABEL_HORASERVICIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCajeroTurno(String sTipo,Row row,Workbook workbook,CajeroTurno cajeroturno,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeroturno.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeroturno.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeroturno.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeroturno.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeroturno.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeroturno.getmesa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeroturno.getturnopunven_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeroturno.gethora_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeroturno.gethora_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeroturno.gethora_servicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCajeroTurno=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCajeroTurno() {
		return this.sFinalQueryCajeroTurno;
	}
	
	public void setsFinalQueryCajeroTurno(String sFinalQueryCajeroTurno) {
		this.sFinalQueryCajeroTurno= sFinalQueryCajeroTurno;
	}
	
	public Border resaltarSeleccionarCajeroTurno=null;
	
	public Border setResaltarSeleccionarCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cajeroturnoBeanSwingJInternalFrame.jTtoolBarCajeroTurno.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCajeroTurno= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCajeroTurno() {
		return this.resaltarSeleccionarCajeroTurno;
	}
	
	public void setResaltarSeleccionarCajeroTurno(Border borderResaltarSeleccionarCajeroTurno) {
		this.resaltarSeleccionarCajeroTurno= borderResaltarSeleccionarCajeroTurno;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCajeroTurno=null;
	public Boolean mostraridCajeroTurno=true;
	public Boolean activaridCajeroTurno=true;

	public Border resaltarid_empresaCajeroTurno=null;
	public Boolean mostrarid_empresaCajeroTurno=true;
	public Boolean activarid_empresaCajeroTurno=true;
	public Boolean cargarid_empresaCajeroTurno=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCajeroTurno=false;//ConEventDepend=true

	public Border resaltarid_sucursalCajeroTurno=null;
	public Boolean mostrarid_sucursalCajeroTurno=true;
	public Boolean activarid_sucursalCajeroTurno=true;
	public Boolean cargarid_sucursalCajeroTurno=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCajeroTurno=false;//ConEventDepend=true

	public Border resaltarid_usuarioCajeroTurno=null;
	public Boolean mostrarid_usuarioCajeroTurno=true;
	public Boolean activarid_usuarioCajeroTurno=true;
	public Boolean cargarid_usuarioCajeroTurno=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioCajeroTurno=false;//ConEventDepend=true

	public Border resaltarid_vendedorCajeroTurno=null;
	public Boolean mostrarid_vendedorCajeroTurno=true;
	public Boolean activarid_vendedorCajeroTurno=true;
	public Boolean cargarid_vendedorCajeroTurno=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorCajeroTurno=false;//ConEventDepend=true

	public Border resaltarid_cajaCajeroTurno=null;
	public Boolean mostrarid_cajaCajeroTurno=true;
	public Boolean activarid_cajaCajeroTurno=true;
	public Boolean cargarid_cajaCajeroTurno=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaCajeroTurno=false;//ConEventDepend=true

	public Border resaltarid_mesaCajeroTurno=null;
	public Boolean mostrarid_mesaCajeroTurno=true;
	public Boolean activarid_mesaCajeroTurno=true;
	public Boolean cargarid_mesaCajeroTurno=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesaCajeroTurno=false;//ConEventDepend=true

	public Border resaltarid_turno_pun_venCajeroTurno=null;
	public Boolean mostrarid_turno_pun_venCajeroTurno=true;
	public Boolean activarid_turno_pun_venCajeroTurno=true;
	public Boolean cargarid_turno_pun_venCajeroTurno=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_turno_pun_venCajeroTurno=false;//ConEventDepend=true

	public Border resaltarhora_inicioCajeroTurno=null;
	public Boolean mostrarhora_inicioCajeroTurno=true;
	public Boolean activarhora_inicioCajeroTurno=true;

	public Border resaltarhora_finCajeroTurno=null;
	public Boolean mostrarhora_finCajeroTurno=true;
	public Boolean activarhora_finCajeroTurno=true;

	public Border resaltarhora_servicioCajeroTurno=null;
	public Boolean mostrarhora_servicioCajeroTurno=true;
	public Boolean activarhora_servicioCajeroTurno=true;

	
	

	public Border setResaltaridCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajeroturnoBeanSwingJInternalFrame.jTtoolBarCajeroTurno.setBorder(borderResaltar);
		
		this.resaltaridCajeroTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCajeroTurno() {
		return this.resaltaridCajeroTurno;
	}

	public void setResaltaridCajeroTurno(Border borderResaltar) {
		this.resaltaridCajeroTurno= borderResaltar;
	}

	public Boolean getMostraridCajeroTurno() {
		return this.mostraridCajeroTurno;
	}

	public void setMostraridCajeroTurno(Boolean mostraridCajeroTurno) {
		this.mostraridCajeroTurno= mostraridCajeroTurno;
	}

	public Boolean getActivaridCajeroTurno() {
		return this.activaridCajeroTurno;
	}

	public void setActivaridCajeroTurno(Boolean activaridCajeroTurno) {
		this.activaridCajeroTurno= activaridCajeroTurno;
	}

	public Border setResaltarid_empresaCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajeroturnoBeanSwingJInternalFrame.jTtoolBarCajeroTurno.setBorder(borderResaltar);
		
		this.resaltarid_empresaCajeroTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCajeroTurno() {
		return this.resaltarid_empresaCajeroTurno;
	}

	public void setResaltarid_empresaCajeroTurno(Border borderResaltar) {
		this.resaltarid_empresaCajeroTurno= borderResaltar;
	}

	public Boolean getMostrarid_empresaCajeroTurno() {
		return this.mostrarid_empresaCajeroTurno;
	}

	public void setMostrarid_empresaCajeroTurno(Boolean mostrarid_empresaCajeroTurno) {
		this.mostrarid_empresaCajeroTurno= mostrarid_empresaCajeroTurno;
	}

	public Boolean getActivarid_empresaCajeroTurno() {
		return this.activarid_empresaCajeroTurno;
	}

	public void setActivarid_empresaCajeroTurno(Boolean activarid_empresaCajeroTurno) {
		this.activarid_empresaCajeroTurno= activarid_empresaCajeroTurno;
	}

	public Boolean getCargarid_empresaCajeroTurno() {
		return this.cargarid_empresaCajeroTurno;
	}

	public void setCargarid_empresaCajeroTurno(Boolean cargarid_empresaCajeroTurno) {
		this.cargarid_empresaCajeroTurno= cargarid_empresaCajeroTurno;
	}

	public Border setResaltarid_sucursalCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajeroturnoBeanSwingJInternalFrame.jTtoolBarCajeroTurno.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCajeroTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCajeroTurno() {
		return this.resaltarid_sucursalCajeroTurno;
	}

	public void setResaltarid_sucursalCajeroTurno(Border borderResaltar) {
		this.resaltarid_sucursalCajeroTurno= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCajeroTurno() {
		return this.mostrarid_sucursalCajeroTurno;
	}

	public void setMostrarid_sucursalCajeroTurno(Boolean mostrarid_sucursalCajeroTurno) {
		this.mostrarid_sucursalCajeroTurno= mostrarid_sucursalCajeroTurno;
	}

	public Boolean getActivarid_sucursalCajeroTurno() {
		return this.activarid_sucursalCajeroTurno;
	}

	public void setActivarid_sucursalCajeroTurno(Boolean activarid_sucursalCajeroTurno) {
		this.activarid_sucursalCajeroTurno= activarid_sucursalCajeroTurno;
	}

	public Boolean getCargarid_sucursalCajeroTurno() {
		return this.cargarid_sucursalCajeroTurno;
	}

	public void setCargarid_sucursalCajeroTurno(Boolean cargarid_sucursalCajeroTurno) {
		this.cargarid_sucursalCajeroTurno= cargarid_sucursalCajeroTurno;
	}

	public Border setResaltarid_usuarioCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajeroturnoBeanSwingJInternalFrame.jTtoolBarCajeroTurno.setBorder(borderResaltar);
		
		this.resaltarid_usuarioCajeroTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioCajeroTurno() {
		return this.resaltarid_usuarioCajeroTurno;
	}

	public void setResaltarid_usuarioCajeroTurno(Border borderResaltar) {
		this.resaltarid_usuarioCajeroTurno= borderResaltar;
	}

	public Boolean getMostrarid_usuarioCajeroTurno() {
		return this.mostrarid_usuarioCajeroTurno;
	}

	public void setMostrarid_usuarioCajeroTurno(Boolean mostrarid_usuarioCajeroTurno) {
		this.mostrarid_usuarioCajeroTurno= mostrarid_usuarioCajeroTurno;
	}

	public Boolean getActivarid_usuarioCajeroTurno() {
		return this.activarid_usuarioCajeroTurno;
	}

	public void setActivarid_usuarioCajeroTurno(Boolean activarid_usuarioCajeroTurno) {
		this.activarid_usuarioCajeroTurno= activarid_usuarioCajeroTurno;
	}

	public Boolean getCargarid_usuarioCajeroTurno() {
		return this.cargarid_usuarioCajeroTurno;
	}

	public void setCargarid_usuarioCajeroTurno(Boolean cargarid_usuarioCajeroTurno) {
		this.cargarid_usuarioCajeroTurno= cargarid_usuarioCajeroTurno;
	}

	public Border setResaltarid_vendedorCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajeroturnoBeanSwingJInternalFrame.jTtoolBarCajeroTurno.setBorder(borderResaltar);
		
		this.resaltarid_vendedorCajeroTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorCajeroTurno() {
		return this.resaltarid_vendedorCajeroTurno;
	}

	public void setResaltarid_vendedorCajeroTurno(Border borderResaltar) {
		this.resaltarid_vendedorCajeroTurno= borderResaltar;
	}

	public Boolean getMostrarid_vendedorCajeroTurno() {
		return this.mostrarid_vendedorCajeroTurno;
	}

	public void setMostrarid_vendedorCajeroTurno(Boolean mostrarid_vendedorCajeroTurno) {
		this.mostrarid_vendedorCajeroTurno= mostrarid_vendedorCajeroTurno;
	}

	public Boolean getActivarid_vendedorCajeroTurno() {
		return this.activarid_vendedorCajeroTurno;
	}

	public void setActivarid_vendedorCajeroTurno(Boolean activarid_vendedorCajeroTurno) {
		this.activarid_vendedorCajeroTurno= activarid_vendedorCajeroTurno;
	}

	public Boolean getCargarid_vendedorCajeroTurno() {
		return this.cargarid_vendedorCajeroTurno;
	}

	public void setCargarid_vendedorCajeroTurno(Boolean cargarid_vendedorCajeroTurno) {
		this.cargarid_vendedorCajeroTurno= cargarid_vendedorCajeroTurno;
	}

	public Border setResaltarid_cajaCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajeroturnoBeanSwingJInternalFrame.jTtoolBarCajeroTurno.setBorder(borderResaltar);
		
		this.resaltarid_cajaCajeroTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaCajeroTurno() {
		return this.resaltarid_cajaCajeroTurno;
	}

	public void setResaltarid_cajaCajeroTurno(Border borderResaltar) {
		this.resaltarid_cajaCajeroTurno= borderResaltar;
	}

	public Boolean getMostrarid_cajaCajeroTurno() {
		return this.mostrarid_cajaCajeroTurno;
	}

	public void setMostrarid_cajaCajeroTurno(Boolean mostrarid_cajaCajeroTurno) {
		this.mostrarid_cajaCajeroTurno= mostrarid_cajaCajeroTurno;
	}

	public Boolean getActivarid_cajaCajeroTurno() {
		return this.activarid_cajaCajeroTurno;
	}

	public void setActivarid_cajaCajeroTurno(Boolean activarid_cajaCajeroTurno) {
		this.activarid_cajaCajeroTurno= activarid_cajaCajeroTurno;
	}

	public Boolean getCargarid_cajaCajeroTurno() {
		return this.cargarid_cajaCajeroTurno;
	}

	public void setCargarid_cajaCajeroTurno(Boolean cargarid_cajaCajeroTurno) {
		this.cargarid_cajaCajeroTurno= cargarid_cajaCajeroTurno;
	}

	public Border setResaltarid_mesaCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajeroturnoBeanSwingJInternalFrame.jTtoolBarCajeroTurno.setBorder(borderResaltar);
		
		this.resaltarid_mesaCajeroTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesaCajeroTurno() {
		return this.resaltarid_mesaCajeroTurno;
	}

	public void setResaltarid_mesaCajeroTurno(Border borderResaltar) {
		this.resaltarid_mesaCajeroTurno= borderResaltar;
	}

	public Boolean getMostrarid_mesaCajeroTurno() {
		return this.mostrarid_mesaCajeroTurno;
	}

	public void setMostrarid_mesaCajeroTurno(Boolean mostrarid_mesaCajeroTurno) {
		this.mostrarid_mesaCajeroTurno= mostrarid_mesaCajeroTurno;
	}

	public Boolean getActivarid_mesaCajeroTurno() {
		return this.activarid_mesaCajeroTurno;
	}

	public void setActivarid_mesaCajeroTurno(Boolean activarid_mesaCajeroTurno) {
		this.activarid_mesaCajeroTurno= activarid_mesaCajeroTurno;
	}

	public Boolean getCargarid_mesaCajeroTurno() {
		return this.cargarid_mesaCajeroTurno;
	}

	public void setCargarid_mesaCajeroTurno(Boolean cargarid_mesaCajeroTurno) {
		this.cargarid_mesaCajeroTurno= cargarid_mesaCajeroTurno;
	}

	public Border setResaltarid_turno_pun_venCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajeroturnoBeanSwingJInternalFrame.jTtoolBarCajeroTurno.setBorder(borderResaltar);
		
		this.resaltarid_turno_pun_venCajeroTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_turno_pun_venCajeroTurno() {
		return this.resaltarid_turno_pun_venCajeroTurno;
	}

	public void setResaltarid_turno_pun_venCajeroTurno(Border borderResaltar) {
		this.resaltarid_turno_pun_venCajeroTurno= borderResaltar;
	}

	public Boolean getMostrarid_turno_pun_venCajeroTurno() {
		return this.mostrarid_turno_pun_venCajeroTurno;
	}

	public void setMostrarid_turno_pun_venCajeroTurno(Boolean mostrarid_turno_pun_venCajeroTurno) {
		this.mostrarid_turno_pun_venCajeroTurno= mostrarid_turno_pun_venCajeroTurno;
	}

	public Boolean getActivarid_turno_pun_venCajeroTurno() {
		return this.activarid_turno_pun_venCajeroTurno;
	}

	public void setActivarid_turno_pun_venCajeroTurno(Boolean activarid_turno_pun_venCajeroTurno) {
		this.activarid_turno_pun_venCajeroTurno= activarid_turno_pun_venCajeroTurno;
	}

	public Boolean getCargarid_turno_pun_venCajeroTurno() {
		return this.cargarid_turno_pun_venCajeroTurno;
	}

	public void setCargarid_turno_pun_venCajeroTurno(Boolean cargarid_turno_pun_venCajeroTurno) {
		this.cargarid_turno_pun_venCajeroTurno= cargarid_turno_pun_venCajeroTurno;
	}

	public Border setResaltarhora_inicioCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajeroturnoBeanSwingJInternalFrame.jTtoolBarCajeroTurno.setBorder(borderResaltar);
		
		this.resaltarhora_inicioCajeroTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_inicioCajeroTurno() {
		return this.resaltarhora_inicioCajeroTurno;
	}

	public void setResaltarhora_inicioCajeroTurno(Border borderResaltar) {
		this.resaltarhora_inicioCajeroTurno= borderResaltar;
	}

	public Boolean getMostrarhora_inicioCajeroTurno() {
		return this.mostrarhora_inicioCajeroTurno;
	}

	public void setMostrarhora_inicioCajeroTurno(Boolean mostrarhora_inicioCajeroTurno) {
		this.mostrarhora_inicioCajeroTurno= mostrarhora_inicioCajeroTurno;
	}

	public Boolean getActivarhora_inicioCajeroTurno() {
		return this.activarhora_inicioCajeroTurno;
	}

	public void setActivarhora_inicioCajeroTurno(Boolean activarhora_inicioCajeroTurno) {
		this.activarhora_inicioCajeroTurno= activarhora_inicioCajeroTurno;
	}

	public Border setResaltarhora_finCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajeroturnoBeanSwingJInternalFrame.jTtoolBarCajeroTurno.setBorder(borderResaltar);
		
		this.resaltarhora_finCajeroTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_finCajeroTurno() {
		return this.resaltarhora_finCajeroTurno;
	}

	public void setResaltarhora_finCajeroTurno(Border borderResaltar) {
		this.resaltarhora_finCajeroTurno= borderResaltar;
	}

	public Boolean getMostrarhora_finCajeroTurno() {
		return this.mostrarhora_finCajeroTurno;
	}

	public void setMostrarhora_finCajeroTurno(Boolean mostrarhora_finCajeroTurno) {
		this.mostrarhora_finCajeroTurno= mostrarhora_finCajeroTurno;
	}

	public Boolean getActivarhora_finCajeroTurno() {
		return this.activarhora_finCajeroTurno;
	}

	public void setActivarhora_finCajeroTurno(Boolean activarhora_finCajeroTurno) {
		this.activarhora_finCajeroTurno= activarhora_finCajeroTurno;
	}

	public Border setResaltarhora_servicioCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajeroturnoBeanSwingJInternalFrame.jTtoolBarCajeroTurno.setBorder(borderResaltar);
		
		this.resaltarhora_servicioCajeroTurno= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_servicioCajeroTurno() {
		return this.resaltarhora_servicioCajeroTurno;
	}

	public void setResaltarhora_servicioCajeroTurno(Border borderResaltar) {
		this.resaltarhora_servicioCajeroTurno= borderResaltar;
	}

	public Boolean getMostrarhora_servicioCajeroTurno() {
		return this.mostrarhora_servicioCajeroTurno;
	}

	public void setMostrarhora_servicioCajeroTurno(Boolean mostrarhora_servicioCajeroTurno) {
		this.mostrarhora_servicioCajeroTurno= mostrarhora_servicioCajeroTurno;
	}

	public Boolean getActivarhora_servicioCajeroTurno() {
		return this.activarhora_servicioCajeroTurno;
	}

	public void setActivarhora_servicioCajeroTurno(Boolean activarhora_servicioCajeroTurno) {
		this.activarhora_servicioCajeroTurno= activarhora_servicioCajeroTurno;
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
		
		
		this.setMostraridCajeroTurno(esInicial);
		this.setMostrarid_empresaCajeroTurno(esInicial);
		this.setMostrarid_sucursalCajeroTurno(esInicial);
		this.setMostrarid_usuarioCajeroTurno(esInicial);
		this.setMostrarid_vendedorCajeroTurno(esInicial);
		this.setMostrarid_cajaCajeroTurno(esInicial);
		this.setMostrarid_mesaCajeroTurno(esInicial);
		this.setMostrarid_turno_pun_venCajeroTurno(esInicial);
		this.setMostrarhora_inicioCajeroTurno(esInicial);
		this.setMostrarhora_finCajeroTurno(esInicial);
		this.setMostrarhora_servicioCajeroTurno(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.ID)) {
				this.setMostraridCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDMESA)) {
				this.setMostrarid_mesaCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDTURNOPUNVEN)) {
				this.setMostrarid_turno_pun_venCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.HORAINICIO)) {
				this.setMostrarhora_inicioCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.HORAFIN)) {
				this.setMostrarhora_finCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.HORASERVICIO)) {
				this.setMostrarhora_servicioCajeroTurno(esAsigna);
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
		
		
		this.setActivaridCajeroTurno(esInicial);
		this.setActivarid_empresaCajeroTurno(esInicial);
		this.setActivarid_sucursalCajeroTurno(esInicial);
		this.setActivarid_usuarioCajeroTurno(esInicial);
		this.setActivarid_vendedorCajeroTurno(esInicial);
		this.setActivarid_cajaCajeroTurno(esInicial);
		this.setActivarid_mesaCajeroTurno(esInicial);
		this.setActivarid_turno_pun_venCajeroTurno(esInicial);
		this.setActivarhora_inicioCajeroTurno(esInicial);
		this.setActivarhora_finCajeroTurno(esInicial);
		this.setActivarhora_servicioCajeroTurno(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.ID)) {
				this.setActivaridCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDMESA)) {
				this.setActivarid_mesaCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDTURNOPUNVEN)) {
				this.setActivarid_turno_pun_venCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.HORAINICIO)) {
				this.setActivarhora_inicioCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.HORAFIN)) {
				this.setActivarhora_finCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.HORASERVICIO)) {
				this.setActivarhora_servicioCajeroTurno(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCajeroTurno(esInicial);
		this.setResaltarid_empresaCajeroTurno(esInicial);
		this.setResaltarid_sucursalCajeroTurno(esInicial);
		this.setResaltarid_usuarioCajeroTurno(esInicial);
		this.setResaltarid_vendedorCajeroTurno(esInicial);
		this.setResaltarid_cajaCajeroTurno(esInicial);
		this.setResaltarid_mesaCajeroTurno(esInicial);
		this.setResaltarid_turno_pun_venCajeroTurno(esInicial);
		this.setResaltarhora_inicioCajeroTurno(esInicial);
		this.setResaltarhora_finCajeroTurno(esInicial);
		this.setResaltarhora_servicioCajeroTurno(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.ID)) {
				this.setResaltaridCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDMESA)) {
				this.setResaltarid_mesaCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.IDTURNOPUNVEN)) {
				this.setResaltarid_turno_pun_venCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.HORAINICIO)) {
				this.setResaltarhora_inicioCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.HORAFIN)) {
				this.setResaltarhora_finCajeroTurno(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajeroTurnoConstantesFunciones.HORASERVICIO)) {
				this.setResaltarhora_servicioCajeroTurno(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCajaCajeroTurno=true;

	public Boolean getMostrarFK_IdCajaCajeroTurno() {
		return this.mostrarFK_IdCajaCajeroTurno;
	}

	public void setMostrarFK_IdCajaCajeroTurno(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCajaCajeroTurno= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCajeroTurno=true;

	public Boolean getMostrarFK_IdEmpresaCajeroTurno() {
		return this.mostrarFK_IdEmpresaCajeroTurno;
	}

	public void setMostrarFK_IdEmpresaCajeroTurno(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCajeroTurno= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesaCajeroTurno=true;

	public Boolean getMostrarFK_IdMesaCajeroTurno() {
		return this.mostrarFK_IdMesaCajeroTurno;
	}

	public void setMostrarFK_IdMesaCajeroTurno(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesaCajeroTurno= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCajeroTurno=true;

	public Boolean getMostrarFK_IdSucursalCajeroTurno() {
		return this.mostrarFK_IdSucursalCajeroTurno;
	}

	public void setMostrarFK_IdSucursalCajeroTurno(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCajeroTurno= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTurnoPunVenCajeroTurno=true;

	public Boolean getMostrarFK_IdTurnoPunVenCajeroTurno() {
		return this.mostrarFK_IdTurnoPunVenCajeroTurno;
	}

	public void setMostrarFK_IdTurnoPunVenCajeroTurno(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTurnoPunVenCajeroTurno= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioCajeroTurno=true;

	public Boolean getMostrarFK_IdUsuarioCajeroTurno() {
		return this.mostrarFK_IdUsuarioCajeroTurno;
	}

	public void setMostrarFK_IdUsuarioCajeroTurno(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioCajeroTurno= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorCajeroTurno=true;

	public Boolean getMostrarFK_IdVendedorCajeroTurno() {
		return this.mostrarFK_IdVendedorCajeroTurno;
	}

	public void setMostrarFK_IdVendedorCajeroTurno(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorCajeroTurno= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCajaCajeroTurno=true;

	public Boolean getActivarFK_IdCajaCajeroTurno() {
		return this.activarFK_IdCajaCajeroTurno;
	}

	public void setActivarFK_IdCajaCajeroTurno(Boolean habilitarResaltar) {
		this.activarFK_IdCajaCajeroTurno= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCajeroTurno=true;

	public Boolean getActivarFK_IdEmpresaCajeroTurno() {
		return this.activarFK_IdEmpresaCajeroTurno;
	}

	public void setActivarFK_IdEmpresaCajeroTurno(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCajeroTurno= habilitarResaltar;
	}

	public Boolean activarFK_IdMesaCajeroTurno=true;

	public Boolean getActivarFK_IdMesaCajeroTurno() {
		return this.activarFK_IdMesaCajeroTurno;
	}

	public void setActivarFK_IdMesaCajeroTurno(Boolean habilitarResaltar) {
		this.activarFK_IdMesaCajeroTurno= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCajeroTurno=true;

	public Boolean getActivarFK_IdSucursalCajeroTurno() {
		return this.activarFK_IdSucursalCajeroTurno;
	}

	public void setActivarFK_IdSucursalCajeroTurno(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCajeroTurno= habilitarResaltar;
	}

	public Boolean activarFK_IdTurnoPunVenCajeroTurno=true;

	public Boolean getActivarFK_IdTurnoPunVenCajeroTurno() {
		return this.activarFK_IdTurnoPunVenCajeroTurno;
	}

	public void setActivarFK_IdTurnoPunVenCajeroTurno(Boolean habilitarResaltar) {
		this.activarFK_IdTurnoPunVenCajeroTurno= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioCajeroTurno=true;

	public Boolean getActivarFK_IdUsuarioCajeroTurno() {
		return this.activarFK_IdUsuarioCajeroTurno;
	}

	public void setActivarFK_IdUsuarioCajeroTurno(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioCajeroTurno= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorCajeroTurno=true;

	public Boolean getActivarFK_IdVendedorCajeroTurno() {
		return this.activarFK_IdVendedorCajeroTurno;
	}

	public void setActivarFK_IdVendedorCajeroTurno(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorCajeroTurno= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCajaCajeroTurno=null;

	public Border getResaltarFK_IdCajaCajeroTurno() {
		return this.resaltarFK_IdCajaCajeroTurno;
	}

	public void setResaltarFK_IdCajaCajeroTurno(Border borderResaltar) {
		this.resaltarFK_IdCajaCajeroTurno= borderResaltar;
	}

	public void setResaltarFK_IdCajaCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCajaCajeroTurno= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCajeroTurno=null;

	public Border getResaltarFK_IdEmpresaCajeroTurno() {
		return this.resaltarFK_IdEmpresaCajeroTurno;
	}

	public void setResaltarFK_IdEmpresaCajeroTurno(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCajeroTurno= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCajeroTurno= borderResaltar;
	}

	public Border resaltarFK_IdMesaCajeroTurno=null;

	public Border getResaltarFK_IdMesaCajeroTurno() {
		return this.resaltarFK_IdMesaCajeroTurno;
	}

	public void setResaltarFK_IdMesaCajeroTurno(Border borderResaltar) {
		this.resaltarFK_IdMesaCajeroTurno= borderResaltar;
	}

	public void setResaltarFK_IdMesaCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesaCajeroTurno= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCajeroTurno=null;

	public Border getResaltarFK_IdSucursalCajeroTurno() {
		return this.resaltarFK_IdSucursalCajeroTurno;
	}

	public void setResaltarFK_IdSucursalCajeroTurno(Border borderResaltar) {
		this.resaltarFK_IdSucursalCajeroTurno= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCajeroTurno= borderResaltar;
	}

	public Border resaltarFK_IdTurnoPunVenCajeroTurno=null;

	public Border getResaltarFK_IdTurnoPunVenCajeroTurno() {
		return this.resaltarFK_IdTurnoPunVenCajeroTurno;
	}

	public void setResaltarFK_IdTurnoPunVenCajeroTurno(Border borderResaltar) {
		this.resaltarFK_IdTurnoPunVenCajeroTurno= borderResaltar;
	}

	public void setResaltarFK_IdTurnoPunVenCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTurnoPunVenCajeroTurno= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioCajeroTurno=null;

	public Border getResaltarFK_IdUsuarioCajeroTurno() {
		return this.resaltarFK_IdUsuarioCajeroTurno;
	}

	public void setResaltarFK_IdUsuarioCajeroTurno(Border borderResaltar) {
		this.resaltarFK_IdUsuarioCajeroTurno= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioCajeroTurno= borderResaltar;
	}

	public Border resaltarFK_IdVendedorCajeroTurno=null;

	public Border getResaltarFK_IdVendedorCajeroTurno() {
		return this.resaltarFK_IdVendedorCajeroTurno;
	}

	public void setResaltarFK_IdVendedorCajeroTurno(Border borderResaltar) {
		this.resaltarFK_IdVendedorCajeroTurno= borderResaltar;
	}

	public void setResaltarFK_IdVendedorCajeroTurno(ParametroGeneralUsuario parametroGeneralUsuario/*CajeroTurnoBeanSwingJInternalFrame cajeroturnoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorCajeroTurno= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}